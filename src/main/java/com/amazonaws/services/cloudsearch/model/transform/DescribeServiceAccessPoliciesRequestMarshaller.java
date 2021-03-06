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
package com.amazonaws.services.cloudsearch.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.cloudsearch.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Describe Service Access Policies Request Marshaller
 * @deprecated Use {@link com.amazonaws.services.cloudsearchv2.model.transform.DescribeServiceAccessPoliciesRequestMarshaller} instead.
 */
 @Deprecated
public class DescribeServiceAccessPoliciesRequestMarshaller implements Marshaller<Request<DescribeServiceAccessPoliciesRequest>, DescribeServiceAccessPoliciesRequest> {

    public Request<DescribeServiceAccessPoliciesRequest> marshall(DescribeServiceAccessPoliciesRequest describeServiceAccessPoliciesRequest) {

        if (describeServiceAccessPoliciesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeServiceAccessPoliciesRequest> request = new DefaultRequest<DescribeServiceAccessPoliciesRequest>(describeServiceAccessPoliciesRequest, "AmazonCloudSearch");
        request.addParameter("Action", "DescribeServiceAccessPolicies");
        request.addParameter("Version", "2011-02-01");

        if (describeServiceAccessPoliciesRequest.getDomainName() != null) {
            request.addParameter("DomainName", StringUtils.fromString(describeServiceAccessPoliciesRequest.getDomainName()));
        }

        return request;
    }
}
