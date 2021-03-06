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
package com.amazonaws.services.elasticache.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.elasticache.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Modify Cache Parameter Group Request Marshaller
 */
public class ModifyCacheParameterGroupRequestMarshaller implements Marshaller<Request<ModifyCacheParameterGroupRequest>, ModifyCacheParameterGroupRequest> {

    public Request<ModifyCacheParameterGroupRequest> marshall(ModifyCacheParameterGroupRequest modifyCacheParameterGroupRequest) {

        if (modifyCacheParameterGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ModifyCacheParameterGroupRequest> request = new DefaultRequest<ModifyCacheParameterGroupRequest>(modifyCacheParameterGroupRequest, "AmazonElastiCache");
        request.addParameter("Action", "ModifyCacheParameterGroup");
        request.addParameter("Version", "2014-07-15");

        if (modifyCacheParameterGroupRequest.getCacheParameterGroupName() != null) {
            request.addParameter("CacheParameterGroupName", StringUtils.fromString(modifyCacheParameterGroupRequest.getCacheParameterGroupName()));
        }

        java.util.List<ParameterNameValue> parameterNameValuesList = modifyCacheParameterGroupRequest.getParameterNameValues();
        int parameterNameValuesListIndex = 1;

        for (ParameterNameValue parameterNameValuesListValue : parameterNameValuesList) {
            ParameterNameValue parameterNameValueMember = parameterNameValuesListValue;
            if (parameterNameValueMember != null) {
                if (parameterNameValueMember.getParameterName() != null) {
                    request.addParameter("ParameterNameValues.ParameterNameValue." + parameterNameValuesListIndex + ".ParameterName", StringUtils.fromString(parameterNameValueMember.getParameterName()));
                }
                if (parameterNameValueMember.getParameterValue() != null) {
                    request.addParameter("ParameterNameValues.ParameterNameValue." + parameterNameValuesListIndex + ".ParameterValue", StringUtils.fromString(parameterNameValueMember.getParameterValue()));
                }
            }

            parameterNameValuesListIndex++;
        }

        return request;
    }
}
