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
import com.amazonaws.method.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.simpleworkflow.model.ActivityType;
import com.amazonaws.services.simpleworkflow.model.DeprecateActivityTypeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;

/**
 * Deprecate Activity Type Request Marshaller
 */
public class DeprecateActivityTypeRequestMarshaller implements Marshaller<Request<DeprecateActivityTypeRequest>, DeprecateActivityTypeRequest> {

    public Request<DeprecateActivityTypeRequest> marshall(DeprecateActivityTypeRequest deprecateActivityTypeRequest) {
        if (deprecateActivityTypeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DeprecateActivityTypeRequest> request = new DefaultRequest<DeprecateActivityTypeRequest>(deprecateActivityTypeRequest, "AmazonSimpleWorkflow");
        String target = "SimpleWorkflowService.DeprecateActivityType";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (deprecateActivityTypeRequest.getDomain() != null) {
                jsonWriter.key("domain").value(deprecateActivityTypeRequest.getDomain());
            }
            ActivityType activityType = deprecateActivityTypeRequest.getActivityType();
            if (activityType != null) {

                jsonWriter.key("activityType");
                jsonWriter.object();

                if (activityType.getName() != null) {
                    jsonWriter.key("name").value(activityType.getName());
                }
                if (activityType.getVersion() != null) {
                    jsonWriter.key("version").value(activityType.getVersion());
                }
                jsonWriter.endObject();
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
