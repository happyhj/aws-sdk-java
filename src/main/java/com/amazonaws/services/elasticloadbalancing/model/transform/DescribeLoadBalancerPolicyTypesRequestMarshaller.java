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
package com.amazonaws.services.elasticloadbalancing.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.elasticloadbalancing.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Describe Load Balancer Policy Types Request Marshaller
 */
public class DescribeLoadBalancerPolicyTypesRequestMarshaller implements Marshaller<Request<DescribeLoadBalancerPolicyTypesRequest>, DescribeLoadBalancerPolicyTypesRequest> {

    public Request<DescribeLoadBalancerPolicyTypesRequest> marshall(DescribeLoadBalancerPolicyTypesRequest describeLoadBalancerPolicyTypesRequest) {

        if (describeLoadBalancerPolicyTypesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeLoadBalancerPolicyTypesRequest> request = new DefaultRequest<DescribeLoadBalancerPolicyTypesRequest>(describeLoadBalancerPolicyTypesRequest, "AmazonElasticLoadBalancing");
        request.addParameter("Action", "DescribeLoadBalancerPolicyTypes");
        request.addParameter("Version", "2012-06-01");

        java.util.List<String> policyTypeNamesList = describeLoadBalancerPolicyTypesRequest.getPolicyTypeNames();
        int policyTypeNamesListIndex = 1;

        for (String policyTypeNamesListValue : policyTypeNamesList) {
            if (policyTypeNamesListValue != null) {
                request.addParameter("PolicyTypeNames.member." + policyTypeNamesListIndex, StringUtils.fromString(policyTypeNamesListValue));
            }

            policyTypeNamesListIndex++;
        }

        return request;
    }
}
