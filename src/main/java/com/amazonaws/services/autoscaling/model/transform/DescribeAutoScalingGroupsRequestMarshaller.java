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
 * Describe Auto Scaling Groups Request Marshaller
 */
public class DescribeAutoScalingGroupsRequestMarshaller implements Marshaller<Request<DescribeAutoScalingGroupsRequest>, DescribeAutoScalingGroupsRequest> {

    public Request<DescribeAutoScalingGroupsRequest> marshall(DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest) {

        if (describeAutoScalingGroupsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeAutoScalingGroupsRequest> request = new DefaultRequest<DescribeAutoScalingGroupsRequest>(describeAutoScalingGroupsRequest, "AmazonAutoScaling");
        request.addParameter("Action", "DescribeAutoScalingGroups");
        request.addParameter("Version", "2011-01-01");

        java.util.List<String> autoScalingGroupNamesList = describeAutoScalingGroupsRequest.getAutoScalingGroupNames();
        int autoScalingGroupNamesListIndex = 1;

        for (String autoScalingGroupNamesListValue : autoScalingGroupNamesList) {
            if (autoScalingGroupNamesListValue != null) {
                request.addParameter("AutoScalingGroupNames.member." + autoScalingGroupNamesListIndex, StringUtils.fromString(autoScalingGroupNamesListValue));
            }

            autoScalingGroupNamesListIndex++;
        }
        if (describeAutoScalingGroupsRequest.getNextToken() != null) {
            request.addParameter("NextToken", StringUtils.fromString(describeAutoScalingGroupsRequest.getNextToken()));
        }
        if (describeAutoScalingGroupsRequest.getMaxRecords() != null) {
            request.addParameter("MaxRecords", StringUtils.fromInteger(describeAutoScalingGroupsRequest.getMaxRecords()));
        }

        return request;
    }
}
