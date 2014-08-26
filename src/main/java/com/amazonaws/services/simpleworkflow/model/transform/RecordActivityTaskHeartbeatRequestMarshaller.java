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
import com.amazonaws.services.simpleworkflow.model.RecordActivityTaskHeartbeatRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;

/**
 * Record Activity Task Heartbeat Request Marshaller
 */
public class RecordActivityTaskHeartbeatRequestMarshaller implements Marshaller<Request<RecordActivityTaskHeartbeatRequest>, RecordActivityTaskHeartbeatRequest> {

    public Request<RecordActivityTaskHeartbeatRequest> marshall(RecordActivityTaskHeartbeatRequest recordActivityTaskHeartbeatRequest) {
        if (recordActivityTaskHeartbeatRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<RecordActivityTaskHeartbeatRequest> request = new DefaultRequest<RecordActivityTaskHeartbeatRequest>(recordActivityTaskHeartbeatRequest, "AmazonSimpleWorkflow");
        String target = "SimpleWorkflowService.RecordActivityTaskHeartbeat";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (recordActivityTaskHeartbeatRequest.getTaskToken() != null) {
                jsonWriter.key("taskToken").value(recordActivityTaskHeartbeatRequest.getTaskToken());
            }
            if (recordActivityTaskHeartbeatRequest.getDetails() != null) {
                jsonWriter.key("details").value(recordActivityTaskHeartbeatRequest.getDetails());
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
