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
 * Delete Cluster Subnet Group Request Marshaller
 */
public class DeleteClusterSubnetGroupRequestMarshaller implements Marshaller<Request<DeleteClusterSubnetGroupRequest>, DeleteClusterSubnetGroupRequest> {

    public Request<DeleteClusterSubnetGroupRequest> marshall(DeleteClusterSubnetGroupRequest deleteClusterSubnetGroupRequest) {

        if (deleteClusterSubnetGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DeleteClusterSubnetGroupRequest> request = new DefaultRequest<DeleteClusterSubnetGroupRequest>(deleteClusterSubnetGroupRequest, "AmazonRedshift");
        request.addParameter("Action", "DeleteClusterSubnetGroup");
        request.addParameter("Version", "2012-12-01");

        if (deleteClusterSubnetGroupRequest.getClusterSubnetGroupName() != null) {
            request.addParameter("ClusterSubnetGroupName", StringUtils.fromString(deleteClusterSubnetGroupRequest.getClusterSubnetGroupName()));
        }

        return request;
    }
}
