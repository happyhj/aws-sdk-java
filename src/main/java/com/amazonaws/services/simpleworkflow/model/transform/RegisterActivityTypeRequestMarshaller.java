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
import com.amazonaws.services.simpleworkflow.model.RegisterActivityTypeRequest;
import com.amazonaws.services.simpleworkflow.model.TaskList;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Register Activity Type Request Marshaller
 */
public class RegisterActivityTypeRequestMarshaller implements Marshaller<Request<RegisterActivityTypeRequest>, RegisterActivityTypeRequest> {

    public Request<RegisterActivityTypeRequest> marshall(RegisterActivityTypeRequest registerActivityTypeRequest) {
        if (registerActivityTypeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<RegisterActivityTypeRequest> request = new DefaultRequest<RegisterActivityTypeRequest>(registerActivityTypeRequest, "AmazonSimpleWorkflow");
        String target = "SimpleWorkflowService.RegisterActivityType";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (registerActivityTypeRequest.getDomain() != null) {
                jsonWriter.key("domain").value(registerActivityTypeRequest.getDomain());
            }
            if (registerActivityTypeRequest.getName() != null) {
                jsonWriter.key("name").value(registerActivityTypeRequest.getName());
            }
            if (registerActivityTypeRequest.getVersion() != null) {
                jsonWriter.key("version").value(registerActivityTypeRequest.getVersion());
            }
            if (registerActivityTypeRequest.getDescription() != null) {
                jsonWriter.key("description").value(registerActivityTypeRequest.getDescription());
            }
            if (registerActivityTypeRequest.getDefaultTaskStartToCloseTimeout() != null) {
                jsonWriter.key("defaultTaskStartToCloseTimeout").value(registerActivityTypeRequest.getDefaultTaskStartToCloseTimeout());
            }
            if (registerActivityTypeRequest.getDefaultTaskHeartbeatTimeout() != null) {
                jsonWriter.key("defaultTaskHeartbeatTimeout").value(registerActivityTypeRequest.getDefaultTaskHeartbeatTimeout());
            }
            TaskList defaultTaskList = registerActivityTypeRequest.getDefaultTaskList();
            if (defaultTaskList != null) {

                jsonWriter.key("defaultTaskList");
                jsonWriter.object();

                if (defaultTaskList.getName() != null) {
                    jsonWriter.key("name").value(defaultTaskList.getName());
                }
                jsonWriter.endObject();
            }
            if (registerActivityTypeRequest.getDefaultTaskScheduleToStartTimeout() != null) {
                jsonWriter.key("defaultTaskScheduleToStartTimeout").value(registerActivityTypeRequest.getDefaultTaskScheduleToStartTimeout());
            }
            if (registerActivityTypeRequest.getDefaultTaskScheduleToCloseTimeout() != null) {
                jsonWriter.key("defaultTaskScheduleToCloseTimeout").value(registerActivityTypeRequest.getDefaultTaskScheduleToCloseTimeout());
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
