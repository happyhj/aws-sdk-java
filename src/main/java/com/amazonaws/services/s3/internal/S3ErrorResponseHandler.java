/*
 * Copyright 2010-2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.s3.internal;

import static com.amazonaws.utility.XpathUtils.asString;
import static com.amazonaws.utility.XpathUtils.xpath;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.xpath.XPath;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;

import com.amazonaws.client.handler.response.HttpResponseHandler;
import com.amazonaws.client.util.sdk.IOUtils;
import com.amazonaws.exception.AmazonServiceException;
import com.amazonaws.exception.AmazonServiceException.ErrorType;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.response.HttpResponse;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.utility.XpathUtils;

/**
 * Response handler for S3 error responses. S3 error responses are different
 * from other AWS error responses in a few ways. Most error responses will
 * contain an XML body, but not all (ex: error responses to HEAD requests will
 * not), so this error handler has to account for that. The actual XML error
 * response body is slightly different than other services like SimpleDB or EC2
 * and some information isn't explicitly represented in the XML error response
 * body (ex: error type/fault information) so it has to be inferred from other
 * parts of the error response.
 */
public class S3ErrorResponseHandler
        implements HttpResponseHandler<AmazonServiceException> {
    private static final Log log = LogFactory.getLog(S3ErrorResponseHandler.class);

    @Override
    public AmazonServiceException handle(HttpResponse errorResponse) throws IOException {
        /*
         * We don't always get an error response body back from S3. When we send
         * a HEAD request, we don't receive a body, so we'll have to just return
         * what we can.
         */
        final InputStream is = errorResponse.getContent();
        if (is == null
        || errorResponse.getRequest().getHttpMethod() == HttpMethodName.HEAD) {
            String requestId = errorResponse.getHeaders().get(Headers.REQUEST_ID);
            String extendedRequestId = errorResponse.getHeaders().get(Headers.EXTENDED_REQUEST_ID);
            AmazonS3Exception ase = new AmazonS3Exception(errorResponse.getStatusText());
            final int statusCode = errorResponse.getStatusCode(); 
            ase.setStatusCode(statusCode);
            ase.setRequestId(requestId);
            ase.setExtendedRequestId(extendedRequestId);
            ase.setErrorType(errorTypeOf(statusCode));
            return ase;
        }
        // Try to read the error response
        String content = "";
        try {
            content = IOUtils.toString(is);
        } catch(IOException ex) {
            if (log.isDebugEnabled())
                log.debug("Failed in reading the error response", ex);
            return newAmazonS3Exception(errorResponse.getStatusText(), errorResponse);
        }
        try { // try to parse the error response as XML
            final Document document = XpathUtils.documentFrom(content);
            XPath xpath = xpath();
            final String message = asString("Error/Message", document, xpath);
            final String errorCode = asString("Error/Code", document, xpath);
            final String requestId = asString("Error/RequestId", document, xpath);
            final String extendedRequestId = asString("Error/HostId", document, xpath);
            final AmazonS3Exception ase = new AmazonS3Exception(message);
            final int statusCode = errorResponse.getStatusCode(); 
            ase.setStatusCode(statusCode);
            ase.setErrorType(errorTypeOf(statusCode));
            ase.setErrorCode(errorCode);
            ase.setRequestId(requestId);
            ase.setExtendedRequestId(extendedRequestId);
            return ase;
        } catch(Exception ex) {
            if (log.isDebugEnabled())
                log.debug("Failed in parsing the response as XML: " + content, ex);
            return newAmazonS3Exception(content, errorResponse);
        }
    }

    /**
     * Used to create an {@link AmazonS3Exception} when we failed to read the
     * error response or parsed the error response as XML.
     */
    private AmazonS3Exception newAmazonS3Exception(String errmsg, HttpResponse httpResponse) {
        final AmazonS3Exception ase = new AmazonS3Exception(errmsg);
        final int statusCode = httpResponse.getStatusCode(); 
        ase.setErrorCode(statusCode + " " + httpResponse.getStatusText());
        ase.setStatusCode(statusCode);
        ase.setErrorType(errorTypeOf(statusCode));
        return ase;
    }

    /**
     * Returns the AWS error type information by looking at the HTTP status code
     * in the error response. S3 error responses don't explicitly declare a
     * sender or client fault like other AWS services, so we have to use the
     * HTTP status code to infer this information.
     * 
     * @param httpResponse
     *            The HTTP error response to use to determine the right error
     *            type to set.
     */
    private ErrorType errorTypeOf(int statusCode) {
        return statusCode >= 500 ? ErrorType.Service : ErrorType.Client;
    }

    /**
     * Since this response handler completely consumes all the data from the
     * underlying HTTP connection during the handle method, we don't need to
     * keep the HTTP connection open.
     *
     * @see com.amazonaws.client.handler.response.HttpResponseHandler#needsConnectionLeftOpen()
     */
    public boolean needsConnectionLeftOpen() {
        return false;
    }
}
