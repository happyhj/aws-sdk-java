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
package com.amazonaws.services.ec2.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Create Network Acl Request Marshaller
 */
public class CreateNetworkAclRequestMarshaller implements Marshaller<Request<CreateNetworkAclRequest>, CreateNetworkAclRequest> {

    public Request<CreateNetworkAclRequest> marshall(CreateNetworkAclRequest createNetworkAclRequest) {

        if (createNetworkAclRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CreateNetworkAclRequest> request = new DefaultRequest<CreateNetworkAclRequest>(createNetworkAclRequest, "AmazonEC2");
        request.addParameter("Action", "CreateNetworkAcl");
        request.addParameter("Version", "2014-06-15");

        if (createNetworkAclRequest.getVpcId() != null) {
            request.addParameter("VpcId", StringUtils.fromString(createNetworkAclRequest.getVpcId()));
        }

        return request;
    }
}
