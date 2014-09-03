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
package com.amazonaws.services.cognitosync.model.transform;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.cognitosync.model.DeleteDatasetRequest;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Delete Dataset Request Marshaller
 */
public class DeleteDatasetRequestMarshaller implements Marshaller<Request<DeleteDatasetRequest>, DeleteDatasetRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
        String path = "/identitypools/{IdentityPoolId}/identities/{IdentityId}/datasets/{DatasetName}";
        Map<String, String> staticMap = new HashMap<String, String>();
        Map<String, String> dynamicMap = new HashMap<String, String>();

        int index = path.indexOf("?");
        if (index != -1) {
            String queryString = path.substring(index + 1);
            path = path.substring(0, index);

            for (String s : queryString.split("[;&]")) {
                index = s.indexOf("=");
                if (index != -1) {
                    String name = s.substring(0, index);
                    String value = s.substring(index + 1);

                    if (value.startsWith("{") && value.endsWith("}")) {
                        dynamicMap.put(value.substring(1, value.length() - 1), name);
                    } else {
                        staticMap.put(name, value);
                    }
                }
            }
        }

        RESOURCE_PATH_TEMPLATE = path;
        STATIC_QUERY_PARAMS = Collections.unmodifiableMap(staticMap);
        DYNAMIC_QUERY_PARAMS = Collections.unmodifiableMap(dynamicMap);
    }

    public Request<DeleteDatasetRequest> marshall(DeleteDatasetRequest deleteDatasetRequest) {
        if (deleteDatasetRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DeleteDatasetRequest> request = new DefaultRequest<DeleteDatasetRequest>(deleteDatasetRequest, "AmazonCognitoSync");
        String target = "AWSCognitoSyncService.DeleteDataset";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.DELETE);
        String uriResourcePath = RESOURCE_PATH_TEMPLATE;

        if (DYNAMIC_QUERY_PARAMS.containsKey("IdentityPoolId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("IdentityPoolId");
            String value = (deleteDatasetRequest.getIdentityPoolId() == null) ? null : StringUtils.fromString(deleteDatasetRequest.getIdentityPoolId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{IdentityPoolId}", (deleteDatasetRequest.getIdentityPoolId() == null) ? "" : StringUtils.fromString(deleteDatasetRequest.getIdentityPoolId())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("IdentityId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("IdentityId");
            String value = (deleteDatasetRequest.getIdentityId() == null) ? null : StringUtils.fromString(deleteDatasetRequest.getIdentityId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{IdentityId}", (deleteDatasetRequest.getIdentityId() == null) ? "" : StringUtils.fromString(deleteDatasetRequest.getIdentityId())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("DatasetName")) {
            String name = DYNAMIC_QUERY_PARAMS.get("DatasetName");
            String value = (deleteDatasetRequest.getDatasetName() == null) ? null : StringUtils.fromString(deleteDatasetRequest.getDatasetName());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{DatasetName}", (deleteDatasetRequest.getDatasetName() == null) ? "" : StringUtils.fromString(deleteDatasetRequest.getDatasetName())); 
        }

        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        request.setContent(new ByteArrayInputStream(new byte[0]));
        request.addHeader("Content-Type", "application/x-amz-json-1.0");

        return request;
    }
}
