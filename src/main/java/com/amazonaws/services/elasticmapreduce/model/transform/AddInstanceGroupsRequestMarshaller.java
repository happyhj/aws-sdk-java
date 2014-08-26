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
import com.amazonaws.services.elasticmapreduce.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * Add Instance Groups Request Marshaller
 */
public class AddInstanceGroupsRequestMarshaller implements Marshaller<Request<AddInstanceGroupsRequest>, AddInstanceGroupsRequest> {

    public Request<AddInstanceGroupsRequest> marshall(AddInstanceGroupsRequest addInstanceGroupsRequest) {
        if (addInstanceGroupsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<AddInstanceGroupsRequest> request = new DefaultRequest<AddInstanceGroupsRequest>(addInstanceGroupsRequest, "AmazonElasticMapReduce");
        String target = "ElasticMapReduce.AddInstanceGroups";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();

            com.amazonaws.internal.ListWithAutoConstructFlag<InstanceGroupConfig> instanceGroupsList = (com.amazonaws.internal.ListWithAutoConstructFlag<InstanceGroupConfig>)(addInstanceGroupsRequest.getInstanceGroups());
            if (instanceGroupsList != null && !(instanceGroupsList.isAutoConstruct() && instanceGroupsList.isEmpty())) {

                jsonWriter.key("InstanceGroups");
                jsonWriter.array();

                for (InstanceGroupConfig instanceGroupsListValue : instanceGroupsList) {
                    if (instanceGroupsListValue != null) {
                        jsonWriter.object();
                        if (instanceGroupsListValue.getName() != null) {
                            jsonWriter.key("Name").value(instanceGroupsListValue.getName());
                        }
                        if (instanceGroupsListValue.getMarket() != null) {
                            jsonWriter.key("Market").value(instanceGroupsListValue.getMarket());
                        }
                        if (instanceGroupsListValue.getInstanceRole() != null) {
                            jsonWriter.key("InstanceRole").value(instanceGroupsListValue.getInstanceRole());
                        }
                        if (instanceGroupsListValue.getBidPrice() != null) {
                            jsonWriter.key("BidPrice").value(instanceGroupsListValue.getBidPrice());
                        }
                        if (instanceGroupsListValue.getInstanceType() != null) {
                            jsonWriter.key("InstanceType").value(instanceGroupsListValue.getInstanceType());
                        }
                        if (instanceGroupsListValue.getInstanceCount() != null) {
                            jsonWriter.key("InstanceCount").value(instanceGroupsListValue.getInstanceCount());
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }
            if (addInstanceGroupsRequest.getJobFlowId() != null) {
                jsonWriter.key("JobFlowId").value(addInstanceGroupsRequest.getJobFlowId());
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
