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
package com.amazonaws.services.identitymanagement.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.identitymanagement.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * List User Policies Request Marshaller
 */
public class ListUserPoliciesRequestMarshaller implements Marshaller<Request<ListUserPoliciesRequest>, ListUserPoliciesRequest> {

    public Request<ListUserPoliciesRequest> marshall(ListUserPoliciesRequest listUserPoliciesRequest) {

        if (listUserPoliciesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListUserPoliciesRequest> request = new DefaultRequest<ListUserPoliciesRequest>(listUserPoliciesRequest, "AmazonIdentityManagement");
        request.addParameter("Action", "ListUserPolicies");
        request.addParameter("Version", "2010-05-08");

        if (listUserPoliciesRequest.getUserName() != null) {
            request.addParameter("UserName", StringUtils.fromString(listUserPoliciesRequest.getUserName()));
        }
        if (listUserPoliciesRequest.getMarker() != null) {
            request.addParameter("Marker", StringUtils.fromString(listUserPoliciesRequest.getMarker()));
        }
        if (listUserPoliciesRequest.getMaxItems() != null) {
            request.addParameter("MaxItems", StringUtils.fromInteger(listUserPoliciesRequest.getMaxItems()));
        }

        return request;
    }
}
