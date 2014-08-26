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
package com.amazonaws.services.redshift.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.internal.ListWithAutoConstructFlag;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.redshift.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Create Event Subscription Request Marshaller
 */
public class CreateEventSubscriptionRequestMarshaller implements Marshaller<Request<CreateEventSubscriptionRequest>, CreateEventSubscriptionRequest> {

    public Request<CreateEventSubscriptionRequest> marshall(CreateEventSubscriptionRequest createEventSubscriptionRequest) {

        if (createEventSubscriptionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CreateEventSubscriptionRequest> request = new DefaultRequest<CreateEventSubscriptionRequest>(createEventSubscriptionRequest, "AmazonRedshift");
        request.addParameter("Action", "CreateEventSubscription");
        request.addParameter("Version", "2012-12-01");

        if (createEventSubscriptionRequest.getSubscriptionName() != null) {
            request.addParameter("SubscriptionName", StringUtils.fromString(createEventSubscriptionRequest.getSubscriptionName()));
        }
        if (createEventSubscriptionRequest.getSnsTopicArn() != null) {
            request.addParameter("SnsTopicArn", StringUtils.fromString(createEventSubscriptionRequest.getSnsTopicArn()));
        }
        if (createEventSubscriptionRequest.getSourceType() != null) {
            request.addParameter("SourceType", StringUtils.fromString(createEventSubscriptionRequest.getSourceType()));
        }

        java.util.List<String> sourceIdsList = createEventSubscriptionRequest.getSourceIds();
        int sourceIdsListIndex = 1;

        for (String sourceIdsListValue : sourceIdsList) {
            if (sourceIdsListValue != null) {
                request.addParameter("SourceIds.SourceId." + sourceIdsListIndex, StringUtils.fromString(sourceIdsListValue));
            }

            sourceIdsListIndex++;
        }

        java.util.List<String> eventCategoriesList = createEventSubscriptionRequest.getEventCategories();
        int eventCategoriesListIndex = 1;

        for (String eventCategoriesListValue : eventCategoriesList) {
            if (eventCategoriesListValue != null) {
                request.addParameter("EventCategories.EventCategory." + eventCategoriesListIndex, StringUtils.fromString(eventCategoriesListValue));
            }

            eventCategoriesListIndex++;
        }
        if (createEventSubscriptionRequest.getSeverity() != null) {
            request.addParameter("Severity", StringUtils.fromString(createEventSubscriptionRequest.getSeverity()));
        }
        if (createEventSubscriptionRequest.isEnabled() != null) {
            request.addParameter("Enabled", StringUtils.fromBoolean(createEventSubscriptionRequest.isEnabled()));
        }

        return request;
    }
}
