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
import com.amazonaws.services.simpleworkflow.model.PollForDecisionTaskRequest;
import com.amazonaws.services.simpleworkflow.model.TaskList;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Poll For Decision Task Request Marshaller
 */
public class PollForDecisionTaskRequestMarshaller implements Marshaller<Request<PollForDecisionTaskRequest>, PollForDecisionTaskRequest> {

    public Request<PollForDecisionTaskRequest> marshall(PollForDecisionTaskRequest pollForDecisionTaskRequest) {
        if (pollForDecisionTaskRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<PollForDecisionTaskRequest> request = new DefaultRequest<PollForDecisionTaskRequest>(pollForDecisionTaskRequest, "AmazonSimpleWorkflow");
        String target = "SimpleWorkflowService.PollForDecisionTask";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (pollForDecisionTaskRequest.getDomain() != null) {
                jsonWriter.key("domain").value(pollForDecisionTaskRequest.getDomain());
            }
            TaskList taskList = pollForDecisionTaskRequest.getTaskList();
            if (taskList != null) {

                jsonWriter.key("taskList");
                jsonWriter.object();

                if (taskList.getName() != null) {
                    jsonWriter.key("name").value(taskList.getName());
                }
                jsonWriter.endObject();
            }
            if (pollForDecisionTaskRequest.getIdentity() != null) {
                jsonWriter.key("identity").value(pollForDecisionTaskRequest.getIdentity());
            }
            if (pollForDecisionTaskRequest.getNextPageToken() != null) {
                jsonWriter.key("nextPageToken").value(pollForDecisionTaskRequest.getNextPageToken());
            }
            if (pollForDecisionTaskRequest.getMaximumPageSize() != null) {
                jsonWriter.key("maximumPageSize").value(pollForDecisionTaskRequest.getMaximumPageSize());
            }
            if (pollForDecisionTaskRequest.isReverseOrder() != null) {
                jsonWriter.key("reverseOrder").value(pollForDecisionTaskRequest.isReverseOrder());
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
