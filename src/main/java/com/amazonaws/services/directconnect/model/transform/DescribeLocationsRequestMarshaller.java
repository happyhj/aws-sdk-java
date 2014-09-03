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
package com.amazonaws.services.directconnect.model.transform;

import java.io.ByteArrayInputStream;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.directconnect.model.DescribeLocationsRequest;
import com.amazonaws.transform.Marshaller;

/**
 * Describe Locations Request Marshaller
 */
public class DescribeLocationsRequestMarshaller implements Marshaller<Request<DescribeLocationsRequest>, DescribeLocationsRequest> {

    public Request<DescribeLocationsRequest> marshall(DescribeLocationsRequest describeLocationsRequest) {
        if (describeLocationsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeLocationsRequest> request = new DefaultRequest<DescribeLocationsRequest>(describeLocationsRequest, "AmazonDirectConnect");
        String target = "OvertureService.DescribeLocations";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        request.setContent(new ByteArrayInputStream(new byte[0]));
        request.addHeader("Content-Type", "application/x-amz-json-1.1");

        return request;
    }
}
