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
 * Receive Message Request Marshaller
 */
public class ReceiveMessageRequestMarshaller implements Marshaller<Request<ReceiveMessageRequest>, ReceiveMessageRequest> {

    public Request<ReceiveMessageRequest> marshall(ReceiveMessageRequest receiveMessageRequest) {

        if (receiveMessageRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ReceiveMessageRequest> request = new DefaultRequest<ReceiveMessageRequest>(receiveMessageRequest, "AmazonSQS");
        request.addParameter("Action", "ReceiveMessage");
        request.addParameter("Version", "2012-11-05");

        if (receiveMessageRequest.getQueueUrl() != null) {
            request.addParameter("QueueUrl", StringUtils.fromString(receiveMessageRequest.getQueueUrl()));
        }

        java.util.List<String> attributeNamesList = receiveMessageRequest.getAttributeNames();
        int attributeNamesListIndex = 1;

        for (String attributeNamesListValue : attributeNamesList) {
            if (attributeNamesListValue != null) {
                request.addParameter("AttributeName." + attributeNamesListIndex, StringUtils.fromString(attributeNamesListValue));
            }

            attributeNamesListIndex++;
        }

        java.util.List<String> messageAttributeNamesList = receiveMessageRequest.getMessageAttributeNames();
        int messageAttributeNamesListIndex = 1;

        for (String messageAttributeNamesListValue : messageAttributeNamesList) {
            if (messageAttributeNamesListValue != null) {
                request.addParameter("MessageAttributeName." + messageAttributeNamesListIndex, StringUtils.fromString(messageAttributeNamesListValue));
            }

            messageAttributeNamesListIndex++;
        }
        if (receiveMessageRequest.getMaxNumberOfMessages() != null) {
            request.addParameter("MaxNumberOfMessages", StringUtils.fromInteger(receiveMessageRequest.getMaxNumberOfMessages()));
        }
        if (receiveMessageRequest.getVisibilityTimeout() != null) {
            request.addParameter("VisibilityTimeout", StringUtils.fromInteger(receiveMessageRequest.getVisibilityTimeout()));
        }
        if (receiveMessageRequest.getWaitTimeSeconds() != null) {
            request.addParameter("WaitTimeSeconds", StringUtils.fromInteger(receiveMessageRequest.getWaitTimeSeconds()));
        }

        return request;
    }
}
