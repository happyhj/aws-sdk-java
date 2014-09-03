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
 * Get Group Request Marshaller
 */
public class GetGroupRequestMarshaller implements Marshaller<Request<GetGroupRequest>, GetGroupRequest> {

    public Request<GetGroupRequest> marshall(GetGroupRequest getGroupRequest) {

        if (getGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<GetGroupRequest> request = new DefaultRequest<GetGroupRequest>(getGroupRequest, "AmazonIdentityManagement");
        request.addParameter("Action", "GetGroup");
        request.addParameter("Version", "2010-05-08");

        if (getGroupRequest.getGroupName() != null) {
            request.addParameter("GroupName", StringUtils.fromString(getGroupRequest.getGroupName()));
        }
        if (getGroupRequest.getMarker() != null) {
            request.addParameter("Marker", StringUtils.fromString(getGroupRequest.getMarker()));
        }
        if (getGroupRequest.getMaxItems() != null) {
            request.addParameter("MaxItems", StringUtils.fromInteger(getGroupRequest.getMaxItems()));
        }

        return request;
    }
}
