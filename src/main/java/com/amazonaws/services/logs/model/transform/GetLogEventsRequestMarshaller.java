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
package com.amazonaws.services.logs.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.logs.model.GetLogEventsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Get Log Events Request Marshaller
 */
public class GetLogEventsRequestMarshaller implements Marshaller<Request<GetLogEventsRequest>, GetLogEventsRequest> {

    public Request<GetLogEventsRequest> marshall(GetLogEventsRequest getLogEventsRequest) {
        if (getLogEventsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<GetLogEventsRequest> request = new DefaultRequest<GetLogEventsRequest>(getLogEventsRequest, "AWSLogs");
        String target = "Logs_20140328.GetLogEvents";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (getLogEventsRequest.getLogGroupName() != null) {
                jsonWriter.key("logGroupName").value(getLogEventsRequest.getLogGroupName());
            }
            if (getLogEventsRequest.getLogStreamName() != null) {
                jsonWriter.key("logStreamName").value(getLogEventsRequest.getLogStreamName());
            }
            if (getLogEventsRequest.getStartTime() != null) {
                jsonWriter.key("startTime").value(getLogEventsRequest.getStartTime());
            }
            if (getLogEventsRequest.getEndTime() != null) {
                jsonWriter.key("endTime").value(getLogEventsRequest.getEndTime());
            }
            if (getLogEventsRequest.getNextToken() != null) {
                jsonWriter.key("nextToken").value(getLogEventsRequest.getNextToken());
            }
            if (getLogEventsRequest.getLimit() != null) {
                jsonWriter.key("limit").value(getLogEventsRequest.getLimit());
            }
            if (getLogEventsRequest.isStartFromHead() != null) {
                jsonWriter.key("startFromHead").value(getLogEventsRequest.isStartFromHead());
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
