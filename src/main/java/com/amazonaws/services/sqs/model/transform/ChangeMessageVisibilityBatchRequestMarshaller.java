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
 * Change Message Visibility Batch Request Marshaller
 */
public class ChangeMessageVisibilityBatchRequestMarshaller implements Marshaller<Request<ChangeMessageVisibilityBatchRequest>, ChangeMessageVisibilityBatchRequest> {

    public Request<ChangeMessageVisibilityBatchRequest> marshall(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) {

        if (changeMessageVisibilityBatchRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ChangeMessageVisibilityBatchRequest> request = new DefaultRequest<ChangeMessageVisibilityBatchRequest>(changeMessageVisibilityBatchRequest, "AmazonSQS");
        request.addParameter("Action", "ChangeMessageVisibilityBatch");
        request.addParameter("Version", "2012-11-05");

        if (changeMessageVisibilityBatchRequest.getQueueUrl() != null) {
            request.addParameter("QueueUrl", StringUtils.fromString(changeMessageVisibilityBatchRequest.getQueueUrl()));
        }

        java.util.List<ChangeMessageVisibilityBatchRequestEntry> entriesList = changeMessageVisibilityBatchRequest.getEntries();
        int entriesListIndex = 1;

        for (ChangeMessageVisibilityBatchRequestEntry entriesListValue : entriesList) {
            ChangeMessageVisibilityBatchRequestEntry changeMessageVisibilityBatchRequestEntryMember = entriesListValue;
            if (changeMessageVisibilityBatchRequestEntryMember != null) {
                if (changeMessageVisibilityBatchRequestEntryMember.getId() != null) {
                    request.addParameter("ChangeMessageVisibilityBatchRequestEntry." + entriesListIndex + ".Id", StringUtils.fromString(changeMessageVisibilityBatchRequestEntryMember.getId()));
                }
                if (changeMessageVisibilityBatchRequestEntryMember.getReceiptHandle() != null) {
                    request.addParameter("ChangeMessageVisibilityBatchRequestEntry." + entriesListIndex + ".ReceiptHandle", StringUtils.fromString(changeMessageVisibilityBatchRequestEntryMember.getReceiptHandle()));
                }
                if (changeMessageVisibilityBatchRequestEntryMember.getVisibilityTimeout() != null) {
                    request.addParameter("ChangeMessageVisibilityBatchRequestEntry." + entriesListIndex + ".VisibilityTimeout", StringUtils.fromInteger(changeMessageVisibilityBatchRequestEntryMember.getVisibilityTimeout()));
                }
            }

            entriesListIndex++;
        }

        return request;
    }
}
