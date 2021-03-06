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
 * Set Endpoint Attributes Request Marshaller
 */
public class SetEndpointAttributesRequestMarshaller implements Marshaller<Request<SetEndpointAttributesRequest>, SetEndpointAttributesRequest> {

    public Request<SetEndpointAttributesRequest> marshall(SetEndpointAttributesRequest setEndpointAttributesRequest) {

        if (setEndpointAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<SetEndpointAttributesRequest> request = new DefaultRequest<SetEndpointAttributesRequest>(setEndpointAttributesRequest, "AmazonSNS");
        request.addParameter("Action", "SetEndpointAttributes");
        request.addParameter("Version", "2010-03-31");

        if (setEndpointAttributesRequest.getEndpointArn() != null) {
            request.addParameter("EndpointArn", StringUtils.fromString(setEndpointAttributesRequest.getEndpointArn()));
        }
        if (setEndpointAttributesRequest != null) {
            if (setEndpointAttributesRequest.getAttributes() != null) {
                int attributesListIndex = 1;
                for (Map.Entry<String, String> attributesListValue : setEndpointAttributesRequest.getAttributes().entrySet()) {

                    if (attributesListValue.getKey() != null) {
                        request.addParameter("Attributes.entry." + attributesListIndex + ".key", StringUtils.fromString(attributesListValue.getKey()));
                    }
                    if (attributesListValue.getValue() != null) {
                        request.addParameter("Attributes.entry." + attributesListIndex + ".value", StringUtils.fromString(attributesListValue.getValue()));
                    }
                    ++attributesListIndex;
                }
            }
        }

        return request;
    }
}
