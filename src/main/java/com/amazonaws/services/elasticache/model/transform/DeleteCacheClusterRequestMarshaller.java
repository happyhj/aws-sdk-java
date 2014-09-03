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
package com.amazonaws.services.elasticache.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.elasticache.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Delete Cache Cluster Request Marshaller
 */
public class DeleteCacheClusterRequestMarshaller implements Marshaller<Request<DeleteCacheClusterRequest>, DeleteCacheClusterRequest> {

    public Request<DeleteCacheClusterRequest> marshall(DeleteCacheClusterRequest deleteCacheClusterRequest) {

        if (deleteCacheClusterRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DeleteCacheClusterRequest> request = new DefaultRequest<DeleteCacheClusterRequest>(deleteCacheClusterRequest, "AmazonElastiCache");
        request.addParameter("Action", "DeleteCacheCluster");
        request.addParameter("Version", "2014-07-15");

        if (deleteCacheClusterRequest.getCacheClusterId() != null) {
            request.addParameter("CacheClusterId", StringUtils.fromString(deleteCacheClusterRequest.getCacheClusterId()));
        }
        if (deleteCacheClusterRequest.getFinalSnapshotIdentifier() != null) {
            request.addParameter("FinalSnapshotIdentifier", StringUtils.fromString(deleteCacheClusterRequest.getFinalSnapshotIdentifier()));
        }

        return request;
    }
}
