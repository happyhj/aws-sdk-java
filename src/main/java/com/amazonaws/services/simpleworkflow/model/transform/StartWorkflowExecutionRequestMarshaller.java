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
import com.amazonaws.services.simpleworkflow.model.StartWorkflowExecutionRequest;
import com.amazonaws.services.simpleworkflow.model.TaskList;
import com.amazonaws.services.simpleworkflow.model.WorkflowType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Start Workflow Execution Request Marshaller
 */
public class StartWorkflowExecutionRequestMarshaller implements Marshaller<Request<StartWorkflowExecutionRequest>, StartWorkflowExecutionRequest> {

    public Request<StartWorkflowExecutionRequest> marshall(StartWorkflowExecutionRequest startWorkflowExecutionRequest) {
        if (startWorkflowExecutionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<StartWorkflowExecutionRequest> request = new DefaultRequest<StartWorkflowExecutionRequest>(startWorkflowExecutionRequest, "AmazonSimpleWorkflow");
        String target = "SimpleWorkflowService.StartWorkflowExecution";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (startWorkflowExecutionRequest.getDomain() != null) {
                jsonWriter.key("domain").value(startWorkflowExecutionRequest.getDomain());
            }
            if (startWorkflowExecutionRequest.getWorkflowId() != null) {
                jsonWriter.key("workflowId").value(startWorkflowExecutionRequest.getWorkflowId());
            }
            WorkflowType workflowType = startWorkflowExecutionRequest.getWorkflowType();
            if (workflowType != null) {

                jsonWriter.key("workflowType");
                jsonWriter.object();

                if (workflowType.getName() != null) {
                    jsonWriter.key("name").value(workflowType.getName());
                }
                if (workflowType.getVersion() != null) {
                    jsonWriter.key("version").value(workflowType.getVersion());
                }
                jsonWriter.endObject();
            }
            TaskList taskList = startWorkflowExecutionRequest.getTaskList();
            if (taskList != null) {

                jsonWriter.key("taskList");
                jsonWriter.object();

                if (taskList.getName() != null) {
                    jsonWriter.key("name").value(taskList.getName());
                }
                jsonWriter.endObject();
            }
            if (startWorkflowExecutionRequest.getInput() != null) {
                jsonWriter.key("input").value(startWorkflowExecutionRequest.getInput());
            }
            if (startWorkflowExecutionRequest.getExecutionStartToCloseTimeout() != null) {
                jsonWriter.key("executionStartToCloseTimeout").value(startWorkflowExecutionRequest.getExecutionStartToCloseTimeout());
            }

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> tagListList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(startWorkflowExecutionRequest.getTagList());
            if (tagListList != null && !(tagListList.isAutoConstruct() && tagListList.isEmpty())) {

                jsonWriter.key("tagList");
                jsonWriter.array();

                for (String tagListListValue : tagListList) {
                    if (tagListListValue != null) {
                        jsonWriter.value(tagListListValue);
                    }
                }
                jsonWriter.endArray();
            }
            if (startWorkflowExecutionRequest.getTaskStartToCloseTimeout() != null) {
                jsonWriter.key("taskStartToCloseTimeout").value(startWorkflowExecutionRequest.getTaskStartToCloseTimeout());
            }
            if (startWorkflowExecutionRequest.getChildPolicy() != null) {
                jsonWriter.key("childPolicy").value(startWorkflowExecutionRequest.getChildPolicy());
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
