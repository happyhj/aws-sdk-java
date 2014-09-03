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
 * Describe Account Limits Request Marshaller
 */
public class DescribeAccountLimitsRequestMarshaller implements Marshaller<Request<DescribeAccountLimitsRequest>, DescribeAccountLimitsRequest> {

    public Request<DescribeAccountLimitsRequest> marshall(DescribeAccountLimitsRequest describeAccountLimitsRequest) {

        if (describeAccountLimitsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeAccountLimitsRequest> request = new DefaultRequest<DescribeAccountLimitsRequest>(describeAccountLimitsRequest, "AmazonAutoScaling");
        request.addParameter("Action", "DescribeAccountLimits");
        request.addParameter("Version", "2011-01-01");

        return request;
    }
}
