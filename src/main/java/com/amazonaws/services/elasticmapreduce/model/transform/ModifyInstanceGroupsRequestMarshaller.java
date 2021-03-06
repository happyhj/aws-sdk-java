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
import com.amazonaws.services.elasticmapreduce.model.InstanceGroupModifyConfig;
import com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Modify Instance Groups Request Marshaller
 */
public class ModifyInstanceGroupsRequestMarshaller implements Marshaller<Request<ModifyInstanceGroupsRequest>, ModifyInstanceGroupsRequest> {

    public Request<ModifyInstanceGroupsRequest> marshall(ModifyInstanceGroupsRequest modifyInstanceGroupsRequest) {
        if (modifyInstanceGroupsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ModifyInstanceGroupsRequest> request = new DefaultRequest<ModifyInstanceGroupsRequest>(modifyInstanceGroupsRequest, "AmazonElasticMapReduce");
        String target = "ElasticMapReduce.ModifyInstanceGroups";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<InstanceGroupModifyConfig> instanceGroupsList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<InstanceGroupModifyConfig>)(modifyInstanceGroupsRequest.getInstanceGroups());
            if (instanceGroupsList != null && !(instanceGroupsList.isAutoConstruct() && instanceGroupsList.isEmpty())) {

                jsonWriter.key("InstanceGroups");
                jsonWriter.array();

                for (InstanceGroupModifyConfig instanceGroupsListValue : instanceGroupsList) {
                    if (instanceGroupsListValue != null) {
                        jsonWriter.object();
                        if (instanceGroupsListValue.getInstanceGroupId() != null) {
                            jsonWriter.key("InstanceGroupId").value(instanceGroupsListValue.getInstanceGroupId());
                        }
                        if (instanceGroupsListValue.getInstanceCount() != null) {
                            jsonWriter.key("InstanceCount").value(instanceGroupsListValue.getInstanceCount());
                        }

                        com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> eC2InstanceIdsToTerminateList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(instanceGroupsListValue.getEC2InstanceIdsToTerminate());
                        if (eC2InstanceIdsToTerminateList != null && !(eC2InstanceIdsToTerminateList.isAutoConstruct() && eC2InstanceIdsToTerminateList.isEmpty())) {

                            jsonWriter.key("EC2InstanceIdsToTerminate");
                            jsonWriter.array();

                            for (String eC2InstanceIdsToTerminateListValue : eC2InstanceIdsToTerminateList) {
                                if (eC2InstanceIdsToTerminateListValue != null) {
                                    jsonWriter.value(eC2InstanceIdsToTerminateListValue);
                                }
                            }
                            jsonWriter.endArray();
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
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
