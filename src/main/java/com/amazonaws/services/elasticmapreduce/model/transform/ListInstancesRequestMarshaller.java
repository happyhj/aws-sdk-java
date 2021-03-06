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
import com.amazonaws.services.elasticmapreduce.model.ListInstancesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * List Instances Request Marshaller
 */
public class ListInstancesRequestMarshaller implements Marshaller<Request<ListInstancesRequest>, ListInstancesRequest> {

    public Request<ListInstancesRequest> marshall(ListInstancesRequest listInstancesRequest) {
        if (listInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListInstancesRequest> request = new DefaultRequest<ListInstancesRequest>(listInstancesRequest, "AmazonElasticMapReduce");
        String target = "ElasticMapReduce.ListInstances";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (listInstancesRequest.getClusterId() != null) {
                jsonWriter.key("ClusterId").value(listInstancesRequest.getClusterId());
            }
            if (listInstancesRequest.getInstanceGroupId() != null) {
                jsonWriter.key("InstanceGroupId").value(listInstancesRequest.getInstanceGroupId());
            }

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> instanceGroupTypesList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(listInstancesRequest.getInstanceGroupTypes());
            if (instanceGroupTypesList != null && !(instanceGroupTypesList.isAutoConstruct() && instanceGroupTypesList.isEmpty())) {

                jsonWriter.key("InstanceGroupTypes");
                jsonWriter.array();

                for (String instanceGroupTypesListValue : instanceGroupTypesList) {
                    if (instanceGroupTypesListValue != null) {
                        jsonWriter.value(instanceGroupTypesListValue);
                    }
                }
                jsonWriter.endArray();
            }
            if (listInstancesRequest.getMarker() != null) {
                jsonWriter.key("Marker").value(listInstancesRequest.getMarker());
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
