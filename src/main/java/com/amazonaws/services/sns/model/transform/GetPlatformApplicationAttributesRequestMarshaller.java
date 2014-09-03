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
package com.amazonaws.services.sns.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.sns.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Get Platform Application Attributes Request Marshaller
 */
public class GetPlatformApplicationAttributesRequestMarshaller implements Marshaller<Request<GetPlatformApplicationAttributesRequest>, GetPlatformApplicationAttributesRequest> {

    public Request<GetPlatformApplicationAttributesRequest> marshall(GetPlatformApplicationAttributesRequest getPlatformApplicationAttributesRequest) {

        if (getPlatformApplicationAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<GetPlatformApplicationAttributesRequest> request = new DefaultRequest<GetPlatformApplicationAttributesRequest>(getPlatformApplicationAttributesRequest, "AmazonSNS");
        request.addParameter("Action", "GetPlatformApplicationAttributes");
        request.addParameter("Version", "2010-03-31");

        if (getPlatformApplicationAttributesRequest.getPlatformApplicationArn() != null) {
            request.addParameter("PlatformApplicationArn", StringUtils.fromString(getPlatformApplicationAttributesRequest.getPlatformApplicationArn()));
        }

        return request;
    }
}
