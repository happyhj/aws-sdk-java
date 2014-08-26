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
import com.amazonaws.services.elastictranscoder.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * Update Pipeline Request Marshaller
 */
public class UpdatePipelineRequestMarshaller implements Marshaller<Request<UpdatePipelineRequest>, UpdatePipelineRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
        String path = "2012-09-25/pipelines/{Id}";
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

    public Request<UpdatePipelineRequest> marshall(UpdatePipelineRequest updatePipelineRequest) {
        if (updatePipelineRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdatePipelineRequest> request = new DefaultRequest<UpdatePipelineRequest>(updatePipelineRequest, "AmazonElasticTranscoder");
        String target = "EtsCustomerService.UpdatePipeline";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.PUT);
        String uriResourcePath = RESOURCE_PATH_TEMPLATE;

        if (DYNAMIC_QUERY_PARAMS.containsKey("Id")) {
            String name = DYNAMIC_QUERY_PARAMS.get("Id");
            String value = (updatePipelineRequest.getId() == null) ? null : StringUtils.fromString(updatePipelineRequest.getId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{Id}", (updatePipelineRequest.getId() == null) ? "" : StringUtils.fromString(updatePipelineRequest.getId())); 
        }

        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (updatePipelineRequest.getName() != null) {
                jsonWriter.key("Name").value(updatePipelineRequest.getName());
            }
            if (updatePipelineRequest.getInputBucket() != null) {
                jsonWriter.key("InputBucket").value(updatePipelineRequest.getInputBucket());
            }
            if (updatePipelineRequest.getRole() != null) {
                jsonWriter.key("Role").value(updatePipelineRequest.getRole());
            }
            Notifications notifications = updatePipelineRequest.getNotifications();
            if (notifications != null) {

                jsonWriter.key("Notifications");
                jsonWriter.object();

                if (notifications.getProgressing() != null) {
                    jsonWriter.key("Progressing").value(notifications.getProgressing());
                }
                if (notifications.getCompleted() != null) {
                    jsonWriter.key("Completed").value(notifications.getCompleted());
                }
                if (notifications.getWarning() != null) {
                    jsonWriter.key("Warning").value(notifications.getWarning());
                }
                if (notifications.getError() != null) {
                    jsonWriter.key("Error").value(notifications.getError());
                }
                jsonWriter.endObject();
            }
            PipelineOutputConfig contentConfig = updatePipelineRequest.getContentConfig();
            if (contentConfig != null) {

                jsonWriter.key("ContentConfig");
                jsonWriter.object();

                if (contentConfig.getBucket() != null) {
                    jsonWriter.key("Bucket").value(contentConfig.getBucket());
                }
                if (contentConfig.getStorageClass() != null) {
                    jsonWriter.key("StorageClass").value(contentConfig.getStorageClass());
                }

                com.amazonaws.internal.ListWithAutoConstructFlag<Permission> permissionsList = (com.amazonaws.internal.ListWithAutoConstructFlag<Permission>)(contentConfig.getPermissions());
                if (permissionsList != null && !(permissionsList.isAutoConstruct() && permissionsList.isEmpty())) {

                    jsonWriter.key("Permissions");
                    jsonWriter.array();

                    for (Permission permissionsListValue : permissionsList) {
                        if (permissionsListValue != null) {
                            jsonWriter.object();
                            if (permissionsListValue.getGranteeType() != null) {
                                jsonWriter.key("GranteeType").value(permissionsListValue.getGranteeType());
                            }
                            if (permissionsListValue.getGrantee() != null) {
                                jsonWriter.key("Grantee").value(permissionsListValue.getGrantee());
                            }

                            com.amazonaws.internal.ListWithAutoConstructFlag<String> accessList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(permissionsListValue.getAccess());
                            if (accessList != null && !(accessList.isAutoConstruct() && accessList.isEmpty())) {

                                jsonWriter.key("Access");
                                jsonWriter.array();

                                for (String accessListValue : accessList) {
                                    if (accessListValue != null) {
                                        jsonWriter.value(accessListValue);
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
            }
            PipelineOutputConfig thumbnailConfig = updatePipelineRequest.getThumbnailConfig();
            if (thumbnailConfig != null) {

                jsonWriter.key("ThumbnailConfig");
                jsonWriter.object();

                if (thumbnailConfig.getBucket() != null) {
                    jsonWriter.key("Bucket").value(thumbnailConfig.getBucket());
                }
                if (thumbnailConfig.getStorageClass() != null) {
                    jsonWriter.key("StorageClass").value(thumbnailConfig.getStorageClass());
                }

                com.amazonaws.internal.ListWithAutoConstructFlag<Permission> permissionsList = (com.amazonaws.internal.ListWithAutoConstructFlag<Permission>)(thumbnailConfig.getPermissions());
                if (permissionsList != null && !(permissionsList.isAutoConstruct() && permissionsList.isEmpty())) {

                    jsonWriter.key("Permissions");
                    jsonWriter.array();

                    for (Permission permissionsListValue : permissionsList) {
                        if (permissionsListValue != null) {
                            jsonWriter.object();
                            if (permissionsListValue.getGranteeType() != null) {
                                jsonWriter.key("GranteeType").value(permissionsListValue.getGranteeType());
                            }
                            if (permissionsListValue.getGrantee() != null) {
                                jsonWriter.key("Grantee").value(permissionsListValue.getGrantee());
                            }

                            com.amazonaws.internal.ListWithAutoConstructFlag<String> accessList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(permissionsListValue.getAccess());
                            if (accessList != null && !(accessList.isAutoConstruct() && accessList.isEmpty())) {

                                jsonWriter.key("Access");
                                jsonWriter.array();

                                for (String accessListValue : accessList) {
                                    if (accessListValue != null) {
                                        jsonWriter.value(accessListValue);
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
            }

          jsonWriter.endObject();

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes(UTF8);
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
          request.addHeader("Content-Type", "application/x-amz-json-1.0");
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
