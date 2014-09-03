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
package com.amazonaws.services.sqs.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.sqs.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Get Queue Attributes Request Marshaller
 */
public class GetQueueAttributesRequestMarshaller implements Marshaller<Request<GetQueueAttributesRequest>, GetQueueAttributesRequest> {

    public Request<GetQueueAttributesRequest> marshall(GetQueueAttributesRequest getQueueAttributesRequest) {

        if (getQueueAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<GetQueueAttributesRequest> request = new DefaultRequest<GetQueueAttributesRequest>(getQueueAttributesRequest, "AmazonSQS");
        request.addParameter("Action", "GetQueueAttributes");
        request.addParameter("Version", "2012-11-05");

        if (getQueueAttributesRequest.getQueueUrl() != null) {
            request.addParameter("QueueUrl", StringUtils.fromString(getQueueAttributesRequest.getQueueUrl()));
        }

        java.util.List<String> attributeNamesList = getQueueAttributesRequest.getAttributeNames();
        int attributeNamesListIndex = 1;

        for (String attributeNamesListValue : attributeNamesList) {
            if (attributeNamesListValue != null) {
                request.addParameter("AttributeName." + attributeNamesListIndex, StringUtils.fromString(attributeNamesListValue));
            }

            attributeNamesListIndex++;
        }

        return request;
    }
}
