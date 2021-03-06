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
 * Describe Engine Default Parameters Request Marshaller
 */
public class DescribeEngineDefaultParametersRequestMarshaller implements Marshaller<Request<DescribeEngineDefaultParametersRequest>, DescribeEngineDefaultParametersRequest> {

    public Request<DescribeEngineDefaultParametersRequest> marshall(DescribeEngineDefaultParametersRequest describeEngineDefaultParametersRequest) {

        if (describeEngineDefaultParametersRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeEngineDefaultParametersRequest> request = new DefaultRequest<DescribeEngineDefaultParametersRequest>(describeEngineDefaultParametersRequest, "AmazonElastiCache");
        request.addParameter("Action", "DescribeEngineDefaultParameters");
        request.addParameter("Version", "2014-07-15");

        if (describeEngineDefaultParametersRequest.getCacheParameterGroupFamily() != null) {
            request.addParameter("CacheParameterGroupFamily", StringUtils.fromString(describeEngineDefaultParametersRequest.getCacheParameterGroupFamily()));
        }
        if (describeEngineDefaultParametersRequest.getMaxRecords() != null) {
            request.addParameter("MaxRecords", StringUtils.fromInteger(describeEngineDefaultParametersRequest.getMaxRecords()));
        }
        if (describeEngineDefaultParametersRequest.getMarker() != null) {
            request.addParameter("Marker", StringUtils.fromString(describeEngineDefaultParametersRequest.getMarker()));
        }

        return request;
    }
}
