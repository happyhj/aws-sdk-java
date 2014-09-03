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
package com.amazonaws.services.cloudformation.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.cloudformation.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Describe Stack Resource Request Marshaller
 */
public class DescribeStackResourceRequestMarshaller implements Marshaller<Request<DescribeStackResourceRequest>, DescribeStackResourceRequest> {

    public Request<DescribeStackResourceRequest> marshall(DescribeStackResourceRequest describeStackResourceRequest) {

        if (describeStackResourceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeStackResourceRequest> request = new DefaultRequest<DescribeStackResourceRequest>(describeStackResourceRequest, "AmazonCloudFormation");
        request.addParameter("Action", "DescribeStackResource");
        request.addParameter("Version", "2010-05-15");

        if (describeStackResourceRequest.getStackName() != null) {
            request.addParameter("StackName", StringUtils.fromString(describeStackResourceRequest.getStackName()));
        }
        if (describeStackResourceRequest.getLogicalResourceId() != null) {
            request.addParameter("LogicalResourceId", StringUtils.fromString(describeStackResourceRequest.getLogicalResourceId()));
        }

        return request;
    }
}
