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
package com.amazonaws.services.support.model.transform;

import static com.amazonaws.stringutil.StringUtils.COMMA_SEPARATOR;
import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.codec.BinaryUtils;
import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.method.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.support.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * Create Case Request Marshaller
 */
public class CreateCaseRequestMarshaller implements Marshaller<Request<CreateCaseRequest>, CreateCaseRequest> {

    public Request<CreateCaseRequest> marshall(CreateCaseRequest createCaseRequest) {
        if (createCaseRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CreateCaseRequest> request = new DefaultRequest<CreateCaseRequest>(createCaseRequest, "AWSSupport");
        String target = "AWSSupport_20130415.CreateCase";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (createCaseRequest.getSubject() != null) {
                jsonWriter.key("subject").value(createCaseRequest.getSubject());
            }
            if (createCaseRequest.getServiceCode() != null) {
                jsonWriter.key("serviceCode").value(createCaseRequest.getServiceCode());
            }
            if (createCaseRequest.getSeverityCode() != null) {
                jsonWriter.key("severityCode").value(createCaseRequest.getSeverityCode());
            }
            if (createCaseRequest.getCategoryCode() != null) {
                jsonWriter.key("categoryCode").value(createCaseRequest.getCategoryCode());
            }
            if (createCaseRequest.getCommunicationBody() != null) {
                jsonWriter.key("communicationBody").value(createCaseRequest.getCommunicationBody());
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<String> ccEmailAddressesList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(createCaseRequest.getCcEmailAddresses());
            if (ccEmailAddressesList != null && !(ccEmailAddressesList.isAutoConstruct() && ccEmailAddressesList.isEmpty())) {

                jsonWriter.key("ccEmailAddresses");
                jsonWriter.array();

                for (String ccEmailAddressesListValue : ccEmailAddressesList) {
                    if (ccEmailAddressesListValue != null) {
                        jsonWriter.value(ccEmailAddressesListValue);
                    }
                }
                jsonWriter.endArray();
            }
            if (createCaseRequest.getLanguage() != null) {
                jsonWriter.key("language").value(createCaseRequest.getLanguage());
            }
            if (createCaseRequest.getIssueType() != null) {
                jsonWriter.key("issueType").value(createCaseRequest.getIssueType());
            }
            if (createCaseRequest.getAttachmentSetId() != null) {
                jsonWriter.key("attachmentSetId").value(createCaseRequest.getAttachmentSetId());
            }

          jsonWriter.endObject();

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes(UTF8);
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
          request.addHeader("Content-Type", "application/x-amz-json-1.1");
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
