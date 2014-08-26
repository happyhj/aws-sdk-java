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
package com.amazonaws.services.autoscaling.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.internal.ListWithAutoConstructFlag;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.autoscaling.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Describe Lifecycle Hooks Request Marshaller
 */
public class DescribeLifecycleHooksRequestMarshaller implements Marshaller<Request<DescribeLifecycleHooksRequest>, DescribeLifecycleHooksRequest> {

    public Request<DescribeLifecycleHooksRequest> marshall(DescribeLifecycleHooksRequest describeLifecycleHooksRequest) {

        if (describeLifecycleHooksRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeLifecycleHooksRequest> request = new DefaultRequest<DescribeLifecycleHooksRequest>(describeLifecycleHooksRequest, "AmazonAutoScaling");
        request.addParameter("Action", "DescribeLifecycleHooks");
        request.addParameter("Version", "2011-01-01");

        if (describeLifecycleHooksRequest.getAutoScalingGroupName() != null) {
            request.addParameter("AutoScalingGroupName", StringUtils.fromString(describeLifecycleHooksRequest.getAutoScalingGroupName()));
        }

        java.util.List<String> lifecycleHookNamesList = describeLifecycleHooksRequest.getLifecycleHookNames();
        int lifecycleHookNamesListIndex = 1;

        for (String lifecycleHookNamesListValue : lifecycleHookNamesList) {
            if (lifecycleHookNamesListValue != null) {
                request.addParameter("LifecycleHookNames.member." + lifecycleHookNamesListIndex, StringUtils.fromString(lifecycleHookNamesListValue));
            }

            lifecycleHookNamesListIndex++;
        }

        return request;
    }
}
