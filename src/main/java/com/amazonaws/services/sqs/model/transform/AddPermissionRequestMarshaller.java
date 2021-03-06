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
 * Add Permission Request Marshaller
 */
public class AddPermissionRequestMarshaller implements Marshaller<Request<AddPermissionRequest>, AddPermissionRequest> {

    public Request<AddPermissionRequest> marshall(AddPermissionRequest addPermissionRequest) {

        if (addPermissionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<AddPermissionRequest> request = new DefaultRequest<AddPermissionRequest>(addPermissionRequest, "AmazonSQS");
        request.addParameter("Action", "AddPermission");
        request.addParameter("Version", "2012-11-05");

        if (addPermissionRequest.getQueueUrl() != null) {
            request.addParameter("QueueUrl", StringUtils.fromString(addPermissionRequest.getQueueUrl()));
        }
        if (addPermissionRequest.getLabel() != null) {
            request.addParameter("Label", StringUtils.fromString(addPermissionRequest.getLabel()));
        }

        java.util.List<String> aWSAccountIdsList = addPermissionRequest.getAWSAccountIds();
        int aWSAccountIdsListIndex = 1;

        for (String aWSAccountIdsListValue : aWSAccountIdsList) {
            if (aWSAccountIdsListValue != null) {
                request.addParameter("AWSAccountId." + aWSAccountIdsListIndex, StringUtils.fromString(aWSAccountIdsListValue));
            }

            aWSAccountIdsListIndex++;
        }

        java.util.List<String> actionsList = addPermissionRequest.getActions();
        int actionsListIndex = 1;

        for (String actionsListValue : actionsList) {
            if (actionsListValue != null) {
                request.addParameter("ActionName." + actionsListIndex, StringUtils.fromString(actionsListValue));
            }

            actionsListIndex++;
        }

        return request;
    }
}
