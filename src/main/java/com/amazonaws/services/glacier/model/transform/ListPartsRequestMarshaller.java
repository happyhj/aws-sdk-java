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
package com.amazonaws.services.glacier.model.transform;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.method.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.glacier.model.ListPartsRequest;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * List Parts Request Marshaller
 */
public class ListPartsRequestMarshaller implements Marshaller<Request<ListPartsRequest>, ListPartsRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
        String path = "/{accountId}/vaults/{vaultName}/multipart-uploads/{uploadId}?marker={marker};limit={limit}";
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

    public Request<ListPartsRequest> marshall(ListPartsRequest listPartsRequest) {
        if (listPartsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListPartsRequest> request = new DefaultRequest<ListPartsRequest>(listPartsRequest, "AmazonGlacier");
        String target = "Glacier.ListParts";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.GET);
        String uriResourcePath = RESOURCE_PATH_TEMPLATE;

        if (DYNAMIC_QUERY_PARAMS.containsKey("accountId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("accountId");
            String value = (listPartsRequest.getAccountId() == null) ? null : StringUtils.fromString(listPartsRequest.getAccountId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{accountId}", (listPartsRequest.getAccountId() == null) ? "" : StringUtils.fromString(listPartsRequest.getAccountId())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("vaultName")) {
            String name = DYNAMIC_QUERY_PARAMS.get("vaultName");
            String value = (listPartsRequest.getVaultName() == null) ? null : StringUtils.fromString(listPartsRequest.getVaultName());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{vaultName}", (listPartsRequest.getVaultName() == null) ? "" : StringUtils.fromString(listPartsRequest.getVaultName())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("uploadId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("uploadId");
            String value = (listPartsRequest.getUploadId() == null) ? null : StringUtils.fromString(listPartsRequest.getUploadId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{uploadId}", (listPartsRequest.getUploadId() == null) ? "" : StringUtils.fromString(listPartsRequest.getUploadId())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("marker")) {
            String name = DYNAMIC_QUERY_PARAMS.get("marker");
            String value = (listPartsRequest.getMarker() == null) ? null : StringUtils.fromString(listPartsRequest.getMarker());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{marker}", (listPartsRequest.getMarker() == null) ? "" : StringUtils.fromString(listPartsRequest.getMarker())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("limit")) {
            String name = DYNAMIC_QUERY_PARAMS.get("limit");
            String value = (listPartsRequest.getLimit() == null) ? null : StringUtils.fromString(listPartsRequest.getLimit());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{limit}", (listPartsRequest.getLimit() == null) ? "" : StringUtils.fromString(listPartsRequest.getLimit())); 
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
