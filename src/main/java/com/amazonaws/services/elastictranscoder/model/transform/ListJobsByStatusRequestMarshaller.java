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
package com.amazonaws.services.elastictranscoder.model.transform;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.elastictranscoder.model.ListJobsByStatusRequest;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * List Jobs By Status Request Marshaller
 */
public class ListJobsByStatusRequestMarshaller implements Marshaller<Request<ListJobsByStatusRequest>, ListJobsByStatusRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
        String path = "2012-09-25/jobsByStatus/{Status}?Ascending={Ascending};PageToken={PageToken}";
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

    public Request<ListJobsByStatusRequest> marshall(ListJobsByStatusRequest listJobsByStatusRequest) {
        if (listJobsByStatusRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListJobsByStatusRequest> request = new DefaultRequest<ListJobsByStatusRequest>(listJobsByStatusRequest, "AmazonElasticTranscoder");
        String target = "EtsCustomerService.ListJobsByStatus";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.GET);
        String uriResourcePath = RESOURCE_PATH_TEMPLATE;

        if (DYNAMIC_QUERY_PARAMS.containsKey("Status")) {
            String name = DYNAMIC_QUERY_PARAMS.get("Status");
            String value = (listJobsByStatusRequest.getStatus() == null) ? null : StringUtils.fromString(listJobsByStatusRequest.getStatus());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{Status}", (listJobsByStatusRequest.getStatus() == null) ? "" : StringUtils.fromString(listJobsByStatusRequest.getStatus())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("Ascending")) {
            String name = DYNAMIC_QUERY_PARAMS.get("Ascending");
            String value = (listJobsByStatusRequest.getAscending() == null) ? null : StringUtils.fromString(listJobsByStatusRequest.getAscending());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{Ascending}", (listJobsByStatusRequest.getAscending() == null) ? "" : StringUtils.fromString(listJobsByStatusRequest.getAscending())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("PageToken")) {
            String name = DYNAMIC_QUERY_PARAMS.get("PageToken");
            String value = (listJobsByStatusRequest.getPageToken() == null) ? null : StringUtils.fromString(listJobsByStatusRequest.getPageToken());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{PageToken}", (listJobsByStatusRequest.getPageToken() == null) ? "" : StringUtils.fromString(listJobsByStatusRequest.getPageToken())); 
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
