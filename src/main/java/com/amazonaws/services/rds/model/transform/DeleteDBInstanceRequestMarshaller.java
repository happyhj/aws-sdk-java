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
package com.amazonaws.services.rds.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.rds.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Delete D B Instance Request Marshaller
 */
public class DeleteDBInstanceRequestMarshaller implements Marshaller<Request<DeleteDBInstanceRequest>, DeleteDBInstanceRequest> {

    public Request<DeleteDBInstanceRequest> marshall(DeleteDBInstanceRequest deleteDBInstanceRequest) {

        if (deleteDBInstanceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DeleteDBInstanceRequest> request = new DefaultRequest<DeleteDBInstanceRequest>(deleteDBInstanceRequest, "AmazonRDS");
        request.addParameter("Action", "DeleteDBInstance");
        request.addParameter("Version", "2013-09-09");

        if (deleteDBInstanceRequest.getDBInstanceIdentifier() != null) {
            request.addParameter("DBInstanceIdentifier", StringUtils.fromString(deleteDBInstanceRequest.getDBInstanceIdentifier()));
        }
        if (deleteDBInstanceRequest.isSkipFinalSnapshot() != null) {
            request.addParameter("SkipFinalSnapshot", StringUtils.fromBoolean(deleteDBInstanceRequest.isSkipFinalSnapshot()));
        }
        if (deleteDBInstanceRequest.getFinalDBSnapshotIdentifier() != null) {
            request.addParameter("FinalDBSnapshotIdentifier", StringUtils.fromString(deleteDBInstanceRequest.getFinalDBSnapshotIdentifier()));
        }

        return request;
    }
}
