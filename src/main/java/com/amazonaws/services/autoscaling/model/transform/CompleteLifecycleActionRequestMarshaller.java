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
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.autoscaling.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Complete Lifecycle Action Request Marshaller
 */
public class CompleteLifecycleActionRequestMarshaller implements Marshaller<Request<CompleteLifecycleActionRequest>, CompleteLifecycleActionRequest> {

    public Request<CompleteLifecycleActionRequest> marshall(CompleteLifecycleActionRequest completeLifecycleActionRequest) {

        if (completeLifecycleActionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CompleteLifecycleActionRequest> request = new DefaultRequest<CompleteLifecycleActionRequest>(completeLifecycleActionRequest, "AmazonAutoScaling");
        request.addParameter("Action", "CompleteLifecycleAction");
        request.addParameter("Version", "2011-01-01");

        if (completeLifecycleActionRequest.getLifecycleHookName() != null) {
            request.addParameter("LifecycleHookName", StringUtils.fromString(completeLifecycleActionRequest.getLifecycleHookName()));
        }
        if (completeLifecycleActionRequest.getAutoScalingGroupName() != null) {
            request.addParameter("AutoScalingGroupName", StringUtils.fromString(completeLifecycleActionRequest.getAutoScalingGroupName()));
        }
        if (completeLifecycleActionRequest.getLifecycleActionToken() != null) {
            request.addParameter("LifecycleActionToken", StringUtils.fromString(completeLifecycleActionRequest.getLifecycleActionToken()));
        }
        if (completeLifecycleActionRequest.getLifecycleActionResult() != null) {
            request.addParameter("LifecycleActionResult", StringUtils.fromString(completeLifecycleActionRequest.getLifecycleActionResult()));
        }

        return request;
    }
}
