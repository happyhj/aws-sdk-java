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
package com.amazonaws.services.simpleworkflow.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.simpleworkflow.model.ListDomainsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * List Domains Request Marshaller
 */
public class ListDomainsRequestMarshaller implements Marshaller<Request<ListDomainsRequest>, ListDomainsRequest> {

    public Request<ListDomainsRequest> marshall(ListDomainsRequest listDomainsRequest) {
        if (listDomainsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListDomainsRequest> request = new DefaultRequest<ListDomainsRequest>(listDomainsRequest, "AmazonSimpleWorkflow");
        String target = "SimpleWorkflowService.ListDomains";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (listDomainsRequest.getNextPageToken() != null) {
                jsonWriter.key("nextPageToken").value(listDomainsRequest.getNextPageToken());
            }
            if (listDomainsRequest.getRegistrationStatus() != null) {
                jsonWriter.key("registrationStatus").value(listDomainsRequest.getRegistrationStatus());
            }
            if (listDomainsRequest.getMaximumPageSize() != null) {
                jsonWriter.key("maximumPageSize").value(listDomainsRequest.getMaximumPageSize());
            }
            if (listDomainsRequest.isReverseOrder() != null) {
                jsonWriter.key("reverseOrder").value(listDomainsRequest.isReverseOrder());
            }

          jsonWriter.endObject();

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes(UTF8);
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
          request.addHeader("Content-Type", "application/x-amz-json-1.0");
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
