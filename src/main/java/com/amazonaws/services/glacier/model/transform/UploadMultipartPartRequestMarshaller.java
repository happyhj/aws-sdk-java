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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.glacier.model.UploadMultipartPartRequest;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Upload Multipart Part Request Marshaller
 */
public class UploadMultipartPartRequestMarshaller implements Marshaller<Request<UploadMultipartPartRequest>, UploadMultipartPartRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
        String path = "/{accountId}/vaults/{vaultName}/multipart-uploads/{uploadId}";
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

    public Request<UploadMultipartPartRequest> marshall(UploadMultipartPartRequest uploadMultipartPartRequest) {
        if (uploadMultipartPartRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UploadMultipartPartRequest> request = new DefaultRequest<UploadMultipartPartRequest>(uploadMultipartPartRequest, "AmazonGlacier");
        String target = "Glacier.UploadMultipartPart";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.PUT);
        if (uploadMultipartPartRequest.getChecksum() != null)
          request.addHeader("x-amz-sha256-tree-hash", StringUtils.fromString(uploadMultipartPartRequest.getChecksum()));
        
        if (uploadMultipartPartRequest.getRange() != null)
          request.addHeader("Content-Range", StringUtils.fromString(uploadMultipartPartRequest.getRange()));
        
        String uriResourcePath = RESOURCE_PATH_TEMPLATE;

        if (DYNAMIC_QUERY_PARAMS.containsKey("accountId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("accountId");
            String value = (uploadMultipartPartRequest.getAccountId() == null) ? null : StringUtils.fromString(uploadMultipartPartRequest.getAccountId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{accountId}", (uploadMultipartPartRequest.getAccountId() == null) ? "" : StringUtils.fromString(uploadMultipartPartRequest.getAccountId())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("vaultName")) {
            String name = DYNAMIC_QUERY_PARAMS.get("vaultName");
            String value = (uploadMultipartPartRequest.getVaultName() == null) ? null : StringUtils.fromString(uploadMultipartPartRequest.getVaultName());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{vaultName}", (uploadMultipartPartRequest.getVaultName() == null) ? "" : StringUtils.fromString(uploadMultipartPartRequest.getVaultName())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("uploadId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("uploadId");
            String value = (uploadMultipartPartRequest.getUploadId() == null) ? null : StringUtils.fromString(uploadMultipartPartRequest.getUploadId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{uploadId}", (uploadMultipartPartRequest.getUploadId() == null) ? "" : StringUtils.fromString(uploadMultipartPartRequest.getUploadId())); 
        }

        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        request.setContent(uploadMultipartPartRequest.getBody());
        if (!request.getHeaders().containsKey("Content-Type")) {
            request.addHeader("Content-Type", "binary/octet-stream");
        }

        return request;
    }
}
