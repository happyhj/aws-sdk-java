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
import com.amazonaws.services.elasticmapreduce.model.ListClustersRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * List Clusters Request Marshaller
 */
public class ListClustersRequestMarshaller implements Marshaller<Request<ListClustersRequest>, ListClustersRequest> {

    public Request<ListClustersRequest> marshall(ListClustersRequest listClustersRequest) {
        if (listClustersRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListClustersRequest> request = new DefaultRequest<ListClustersRequest>(listClustersRequest, "AmazonElasticMapReduce");
        String target = "ElasticMapReduce.ListClusters";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (listClustersRequest.getCreatedAfter() != null) {
                jsonWriter.key("CreatedAfter").value(listClustersRequest.getCreatedAfter());
            }
            if (listClustersRequest.getCreatedBefore() != null) {
                jsonWriter.key("CreatedBefore").value(listClustersRequest.getCreatedBefore());
            }

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> clusterStatesList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(listClustersRequest.getClusterStates());
            if (clusterStatesList != null && !(clusterStatesList.isAutoConstruct() && clusterStatesList.isEmpty())) {

                jsonWriter.key("ClusterStates");
                jsonWriter.array();

                for (String clusterStatesListValue : clusterStatesList) {
                    if (clusterStatesListValue != null) {
                        jsonWriter.value(clusterStatesListValue);
                    }
                }
                jsonWriter.endArray();
            }
            if (listClustersRequest.getMarker() != null) {
                jsonWriter.key("Marker").value(listClustersRequest.getMarker());
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
