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
package com.amazonaws.services.elasticmapreduce.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.elasticmapreduce.model.SetVisibleToAllUsersRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Set Visible To All Users Request Marshaller
 */
public class SetVisibleToAllUsersRequestMarshaller implements Marshaller<Request<SetVisibleToAllUsersRequest>, SetVisibleToAllUsersRequest> {

    public Request<SetVisibleToAllUsersRequest> marshall(SetVisibleToAllUsersRequest setVisibleToAllUsersRequest) {
        if (setVisibleToAllUsersRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<SetVisibleToAllUsersRequest> request = new DefaultRequest<SetVisibleToAllUsersRequest>(setVisibleToAllUsersRequest, "AmazonElasticMapReduce");
        String target = "ElasticMapReduce.SetVisibleToAllUsers";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> jobFlowIdsList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(setVisibleToAllUsersRequest.getJobFlowIds());
            if (jobFlowIdsList != null && !(jobFlowIdsList.isAutoConstruct() && jobFlowIdsList.isEmpty())) {

                jsonWriter.key("JobFlowIds");
                jsonWriter.array();

                for (String jobFlowIdsListValue : jobFlowIdsList) {
                    if (jobFlowIdsListValue != null) {
                        jsonWriter.value(jobFlowIdsListValue);
                    }
                }
                jsonWriter.endArray();
            }
            if (setVisibleToAllUsersRequest.isVisibleToAllUsers() != null) {
                jsonWriter.key("VisibleToAllUsers").value(setVisibleToAllUsersRequest.isVisibleToAllUsers());
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
