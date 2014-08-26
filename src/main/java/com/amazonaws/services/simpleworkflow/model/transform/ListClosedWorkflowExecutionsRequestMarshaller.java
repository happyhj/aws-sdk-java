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
import com.amazonaws.services.simpleworkflow.model.CloseStatusFilter;
import com.amazonaws.services.simpleworkflow.model.ExecutionTimeFilter;
import com.amazonaws.services.simpleworkflow.model.ListClosedWorkflowExecutionsRequest;
import com.amazonaws.services.simpleworkflow.model.TagFilter;
import com.amazonaws.services.simpleworkflow.model.WorkflowExecutionFilter;
import com.amazonaws.services.simpleworkflow.model.WorkflowTypeFilter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;

/**
 * List Closed Workflow Executions Request Marshaller
 */
public class ListClosedWorkflowExecutionsRequestMarshaller implements Marshaller<Request<ListClosedWorkflowExecutionsRequest>, ListClosedWorkflowExecutionsRequest> {

    public Request<ListClosedWorkflowExecutionsRequest> marshall(ListClosedWorkflowExecutionsRequest listClosedWorkflowExecutionsRequest) {
        if (listClosedWorkflowExecutionsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListClosedWorkflowExecutionsRequest> request = new DefaultRequest<ListClosedWorkflowExecutionsRequest>(listClosedWorkflowExecutionsRequest, "AmazonSimpleWorkflow");
        String target = "SimpleWorkflowService.ListClosedWorkflowExecutions";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (listClosedWorkflowExecutionsRequest.getDomain() != null) {
                jsonWriter.key("domain").value(listClosedWorkflowExecutionsRequest.getDomain());
            }
            ExecutionTimeFilter startTimeFilter = listClosedWorkflowExecutionsRequest.getStartTimeFilter();
            if (startTimeFilter != null) {

                jsonWriter.key("startTimeFilter");
                jsonWriter.object();

                if (startTimeFilter.getOldestDate() != null) {
                    jsonWriter.key("oldestDate").value(startTimeFilter.getOldestDate());
                }
                if (startTimeFilter.getLatestDate() != null) {
                    jsonWriter.key("latestDate").value(startTimeFilter.getLatestDate());
                }
                jsonWriter.endObject();
            }
            ExecutionTimeFilter closeTimeFilter = listClosedWorkflowExecutionsRequest.getCloseTimeFilter();
            if (closeTimeFilter != null) {

                jsonWriter.key("closeTimeFilter");
                jsonWriter.object();

                if (closeTimeFilter.getOldestDate() != null) {
                    jsonWriter.key("oldestDate").value(closeTimeFilter.getOldestDate());
                }
                if (closeTimeFilter.getLatestDate() != null) {
                    jsonWriter.key("latestDate").value(closeTimeFilter.getLatestDate());
                }
                jsonWriter.endObject();
            }
            WorkflowExecutionFilter executionFilter = listClosedWorkflowExecutionsRequest.getExecutionFilter();
            if (executionFilter != null) {

                jsonWriter.key("executionFilter");
                jsonWriter.object();

                if (executionFilter.getWorkflowId() != null) {
                    jsonWriter.key("workflowId").value(executionFilter.getWorkflowId());
                }
                jsonWriter.endObject();
            }
            CloseStatusFilter closeStatusFilter = listClosedWorkflowExecutionsRequest.getCloseStatusFilter();
            if (closeStatusFilter != null) {

                jsonWriter.key("closeStatusFilter");
                jsonWriter.object();

                if (closeStatusFilter.getStatus() != null) {
                    jsonWriter.key("status").value(closeStatusFilter.getStatus());
                }
                jsonWriter.endObject();
            }
            WorkflowTypeFilter typeFilter = listClosedWorkflowExecutionsRequest.getTypeFilter();
            if (typeFilter != null) {

                jsonWriter.key("typeFilter");
                jsonWriter.object();

                if (typeFilter.getName() != null) {
                    jsonWriter.key("name").value(typeFilter.getName());
                }
                if (typeFilter.getVersion() != null) {
                    jsonWriter.key("version").value(typeFilter.getVersion());
                }
                jsonWriter.endObject();
            }
            TagFilter tagFilter = listClosedWorkflowExecutionsRequest.getTagFilter();
            if (tagFilter != null) {

                jsonWriter.key("tagFilter");
                jsonWriter.object();

                if (tagFilter.getTag() != null) {
                    jsonWriter.key("tag").value(tagFilter.getTag());
                }
                jsonWriter.endObject();
            }
            if (listClosedWorkflowExecutionsRequest.getNextPageToken() != null) {
                jsonWriter.key("nextPageToken").value(listClosedWorkflowExecutionsRequest.getNextPageToken());
            }
            if (listClosedWorkflowExecutionsRequest.getMaximumPageSize() != null) {
                jsonWriter.key("maximumPageSize").value(listClosedWorkflowExecutionsRequest.getMaximumPageSize());
            }
            if (listClosedWorkflowExecutionsRequest.isReverseOrder() != null) {
                jsonWriter.key("reverseOrder").value(listClosedWorkflowExecutionsRequest.isReverseOrder());
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
