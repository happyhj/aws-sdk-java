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
 * Send Message Batch Request Marshaller
 */
public class SendMessageBatchRequestMarshaller implements Marshaller<Request<SendMessageBatchRequest>, SendMessageBatchRequest> {

    public Request<SendMessageBatchRequest> marshall(SendMessageBatchRequest sendMessageBatchRequest) {

        if (sendMessageBatchRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<SendMessageBatchRequest> request = new DefaultRequest<SendMessageBatchRequest>(sendMessageBatchRequest, "AmazonSQS");
        request.addParameter("Action", "SendMessageBatch");
        request.addParameter("Version", "2012-11-05");

        if (sendMessageBatchRequest.getQueueUrl() != null) {
            request.addParameter("QueueUrl", StringUtils.fromString(sendMessageBatchRequest.getQueueUrl()));
        }

        java.util.List<SendMessageBatchRequestEntry> entriesList = sendMessageBatchRequest.getEntries();
        int entriesListIndex = 1;

        for (SendMessageBatchRequestEntry entriesListValue : entriesList) {
            SendMessageBatchRequestEntry sendMessageBatchRequestEntryMember = entriesListValue;
            if (sendMessageBatchRequestEntryMember != null) {
                if (sendMessageBatchRequestEntryMember.getId() != null) {
                    request.addParameter("SendMessageBatchRequestEntry." + entriesListIndex + ".Id", StringUtils.fromString(sendMessageBatchRequestEntryMember.getId()));
                }
                if (sendMessageBatchRequestEntryMember.getMessageBody() != null) {
                    request.addParameter("SendMessageBatchRequestEntry." + entriesListIndex + ".MessageBody", StringUtils.fromString(sendMessageBatchRequestEntryMember.getMessageBody()));
                }
                if (sendMessageBatchRequestEntryMember.getDelaySeconds() != null) {
                    request.addParameter("SendMessageBatchRequestEntry." + entriesListIndex + ".DelaySeconds", StringUtils.fromInteger(sendMessageBatchRequestEntryMember.getDelaySeconds()));
                }
                if (sendMessageBatchRequestEntryMember != null) {
                    if (sendMessageBatchRequestEntryMember.getMessageAttributes() != null) {
                        int messageAttributesListIndex = 1;
                        for (Map.Entry<String, MessageAttributeValue> messageAttributesListValue : sendMessageBatchRequestEntryMember.getMessageAttributes().entrySet()) {

                            if (messageAttributesListValue.getKey() != null) {
                                request.addParameter("SendMessageBatchRequestEntry." + entriesListIndex + ".MessageAttribute." + messageAttributesListIndex + ".Name", StringUtils.fromString(messageAttributesListValue.getKey()));
                            }
                            MessageAttributeValue messageAttributeValueValue = messageAttributesListValue.getValue();
                            if (messageAttributeValueValue != null) {
                                if (messageAttributeValueValue.getStringValue() != null) {
                                    request.addParameter("SendMessageBatchRequestEntry." + entriesListIndex + ".MessageAttribute." + messageAttributesListIndex + ".Value.StringValue", StringUtils.fromString(messageAttributeValueValue.getStringValue()));
                                }
                                if (messageAttributeValueValue.getBinaryValue() != null) {
                                    request.addParameter("SendMessageBatchRequestEntry." + entriesListIndex + ".MessageAttribute." + messageAttributesListIndex + ".Value.BinaryValue", StringUtils.fromByteBuffer(messageAttributeValueValue.getBinaryValue()));
                                }

                                java.util.List<String> stringListValuesList = messageAttributeValueValue.getStringListValues();
                                int stringListValuesListIndex = 1;

                                for (String stringListValuesListValue : stringListValuesList) {
                                    if (stringListValuesListValue != null) {
                                        request.addParameter("SendMessageBatchRequestEntry." + entriesListIndex + ".MessageAttribute." + messageAttributesListIndex + ".Value.StringListValue." + stringListValuesListIndex, StringUtils.fromString(stringListValuesListValue));
                                    }

                                    stringListValuesListIndex++;
                                }

                                java.util.List<java.nio.ByteBuffer> binaryListValuesList = messageAttributeValueValue.getBinaryListValues();
                                int binaryListValuesListIndex = 1;

                                for (java.nio.ByteBuffer binaryListValuesListValue : binaryListValuesList) {
                                    if (binaryListValuesListValue != null) {
                                        request.addParameter("SendMessageBatchRequestEntry." + entriesListIndex + ".MessageAttribute." + messageAttributesListIndex + ".Value.BinaryListValue." + binaryListValuesListIndex, StringUtils.fromByteBuffer(binaryListValuesListValue));
                                    }

                                    binaryListValuesListIndex++;
                                }
                                if (messageAttributeValueValue.getDataType() != null) {
                                    request.addParameter("SendMessageBatchRequestEntry." + entriesListIndex + ".MessageAttribute." + messageAttributesListIndex + ".Value.DataType", StringUtils.fromString(messageAttributeValueValue.getDataType()));
                                }
                            }
                            ++messageAttributesListIndex;
                        }
                    }
                }
            }

            entriesListIndex++;
        }

        return request;
    }
}
