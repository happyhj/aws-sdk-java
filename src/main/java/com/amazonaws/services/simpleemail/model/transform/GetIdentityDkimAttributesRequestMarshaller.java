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
package com.amazonaws.services.simpleemail.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Get Identity Dkim Attributes Request Marshaller
 */
public class GetIdentityDkimAttributesRequestMarshaller implements Marshaller<Request<GetIdentityDkimAttributesRequest>, GetIdentityDkimAttributesRequest> {

    public Request<GetIdentityDkimAttributesRequest> marshall(GetIdentityDkimAttributesRequest getIdentityDkimAttributesRequest) {

        if (getIdentityDkimAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<GetIdentityDkimAttributesRequest> request = new DefaultRequest<GetIdentityDkimAttributesRequest>(getIdentityDkimAttributesRequest, "AmazonSimpleEmailService");
        request.addParameter("Action", "GetIdentityDkimAttributes");
        request.addParameter("Version", "2010-12-01");

        java.util.List<String> identitiesList = getIdentityDkimAttributesRequest.getIdentities();
        int identitiesListIndex = 1;

        for (String identitiesListValue : identitiesList) {
            if (identitiesListValue != null) {
                request.addParameter("Identities.member." + identitiesListIndex, StringUtils.fromString(identitiesListValue));
            }

            identitiesListIndex++;
        }

        return request;
    }
}
