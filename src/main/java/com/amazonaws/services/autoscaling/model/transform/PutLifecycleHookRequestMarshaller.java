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
 * Put Lifecycle Hook Request Marshaller
 */
public class PutLifecycleHookRequestMarshaller implements Marshaller<Request<PutLifecycleHookRequest>, PutLifecycleHookRequest> {

    public Request<PutLifecycleHookRequest> marshall(PutLifecycleHookRequest putLifecycleHookRequest) {

        if (putLifecycleHookRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<PutLifecycleHookRequest> request = new DefaultRequest<PutLifecycleHookRequest>(putLifecycleHookRequest, "AmazonAutoScaling");
        request.addParameter("Action", "PutLifecycleHook");
        request.addParameter("Version", "2011-01-01");

        if (putLifecycleHookRequest.getLifecycleHookName() != null) {
            request.addParameter("LifecycleHookName", StringUtils.fromString(putLifecycleHookRequest.getLifecycleHookName()));
        }
        if (putLifecycleHookRequest.getAutoScalingGroupName() != null) {
            request.addParameter("AutoScalingGroupName", StringUtils.fromString(putLifecycleHookRequest.getAutoScalingGroupName()));
        }
        if (putLifecycleHookRequest.getLifecycleTransition() != null) {
            request.addParameter("LifecycleTransition", StringUtils.fromString(putLifecycleHookRequest.getLifecycleTransition()));
        }
        if (putLifecycleHookRequest.getRoleARN() != null) {
            request.addParameter("RoleARN", StringUtils.fromString(putLifecycleHookRequest.getRoleARN()));
        }
        if (putLifecycleHookRequest.getNotificationTargetARN() != null) {
            request.addParameter("NotificationTargetARN", StringUtils.fromString(putLifecycleHookRequest.getNotificationTargetARN()));
        }
        if (putLifecycleHookRequest.getNotificationMetadata() != null) {
            request.addParameter("NotificationMetadata", StringUtils.fromString(putLifecycleHookRequest.getNotificationMetadata()));
        }
        if (putLifecycleHookRequest.getHeartbeatTimeout() != null) {
            request.addParameter("HeartbeatTimeout", StringUtils.fromInteger(putLifecycleHookRequest.getHeartbeatTimeout()));
        }
        if (putLifecycleHookRequest.getDefaultResult() != null) {
            request.addParameter("DefaultResult", StringUtils.fromString(putLifecycleHookRequest.getDefaultResult()));
        }

        return request;
    }
}
