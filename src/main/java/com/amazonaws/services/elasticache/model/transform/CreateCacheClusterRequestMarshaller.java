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
 * Create Cache Cluster Request Marshaller
 */
public class CreateCacheClusterRequestMarshaller implements Marshaller<Request<CreateCacheClusterRequest>, CreateCacheClusterRequest> {

    public Request<CreateCacheClusterRequest> marshall(CreateCacheClusterRequest createCacheClusterRequest) {

        if (createCacheClusterRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CreateCacheClusterRequest> request = new DefaultRequest<CreateCacheClusterRequest>(createCacheClusterRequest, "AmazonElastiCache");
        request.addParameter("Action", "CreateCacheCluster");
        request.addParameter("Version", "2014-07-15");

        if (createCacheClusterRequest.getCacheClusterId() != null) {
            request.addParameter("CacheClusterId", StringUtils.fromString(createCacheClusterRequest.getCacheClusterId()));
        }
        if (createCacheClusterRequest.getReplicationGroupId() != null) {
            request.addParameter("ReplicationGroupId", StringUtils.fromString(createCacheClusterRequest.getReplicationGroupId()));
        }
        if (createCacheClusterRequest.getNumCacheNodes() != null) {
            request.addParameter("NumCacheNodes", StringUtils.fromInteger(createCacheClusterRequest.getNumCacheNodes()));
        }
        if (createCacheClusterRequest.getCacheNodeType() != null) {
            request.addParameter("CacheNodeType", StringUtils.fromString(createCacheClusterRequest.getCacheNodeType()));
        }
        if (createCacheClusterRequest.getEngine() != null) {
            request.addParameter("Engine", StringUtils.fromString(createCacheClusterRequest.getEngine()));
        }
        if (createCacheClusterRequest.getEngineVersion() != null) {
            request.addParameter("EngineVersion", StringUtils.fromString(createCacheClusterRequest.getEngineVersion()));
        }
        if (createCacheClusterRequest.getCacheParameterGroupName() != null) {
            request.addParameter("CacheParameterGroupName", StringUtils.fromString(createCacheClusterRequest.getCacheParameterGroupName()));
        }
        if (createCacheClusterRequest.getCacheSubnetGroupName() != null) {
            request.addParameter("CacheSubnetGroupName", StringUtils.fromString(createCacheClusterRequest.getCacheSubnetGroupName()));
        }

        java.util.List<String> cacheSecurityGroupNamesList = createCacheClusterRequest.getCacheSecurityGroupNames();
        int cacheSecurityGroupNamesListIndex = 1;

        for (String cacheSecurityGroupNamesListValue : cacheSecurityGroupNamesList) {
            if (cacheSecurityGroupNamesListValue != null) {
                request.addParameter("CacheSecurityGroupNames.CacheSecurityGroupName." + cacheSecurityGroupNamesListIndex, StringUtils.fromString(cacheSecurityGroupNamesListValue));
            }

            cacheSecurityGroupNamesListIndex++;
        }

        java.util.List<String> securityGroupIdsList = createCacheClusterRequest.getSecurityGroupIds();
        int securityGroupIdsListIndex = 1;

        for (String securityGroupIdsListValue : securityGroupIdsList) {
            if (securityGroupIdsListValue != null) {
                request.addParameter("SecurityGroupIds.SecurityGroupId." + securityGroupIdsListIndex, StringUtils.fromString(securityGroupIdsListValue));
            }

            securityGroupIdsListIndex++;
        }

        java.util.List<String> snapshotArnsList = createCacheClusterRequest.getSnapshotArns();
        int snapshotArnsListIndex = 1;

        for (String snapshotArnsListValue : snapshotArnsList) {
            if (snapshotArnsListValue != null) {
                request.addParameter("SnapshotArns.SnapshotArn." + snapshotArnsListIndex, StringUtils.fromString(snapshotArnsListValue));
            }

            snapshotArnsListIndex++;
        }
        if (createCacheClusterRequest.getSnapshotName() != null) {
            request.addParameter("SnapshotName", StringUtils.fromString(createCacheClusterRequest.getSnapshotName()));
        }
        if (createCacheClusterRequest.getAZMode() != null) {
            request.addParameter("AZMode", StringUtils.fromString(createCacheClusterRequest.getAZMode()));
        }
        if (createCacheClusterRequest.getPreferredAvailabilityZone() != null) {
            request.addParameter("PreferredAvailabilityZone", StringUtils.fromString(createCacheClusterRequest.getPreferredAvailabilityZone()));
        }

        java.util.List<String> preferredAvailabilityZonesList = createCacheClusterRequest.getPreferredAvailabilityZones();
        int preferredAvailabilityZonesListIndex = 1;

        for (String preferredAvailabilityZonesListValue : preferredAvailabilityZonesList) {
            if (preferredAvailabilityZonesListValue != null) {
                request.addParameter("PreferredAvailabilityZones.PreferredAvailabilityZone." + preferredAvailabilityZonesListIndex, StringUtils.fromString(preferredAvailabilityZonesListValue));
            }

            preferredAvailabilityZonesListIndex++;
        }
        if (createCacheClusterRequest.getPreferredMaintenanceWindow() != null) {
            request.addParameter("PreferredMaintenanceWindow", StringUtils.fromString(createCacheClusterRequest.getPreferredMaintenanceWindow()));
        }
        if (createCacheClusterRequest.getPort() != null) {
            request.addParameter("Port", StringUtils.fromInteger(createCacheClusterRequest.getPort()));
        }
        if (createCacheClusterRequest.getNotificationTopicArn() != null) {
            request.addParameter("NotificationTopicArn", StringUtils.fromString(createCacheClusterRequest.getNotificationTopicArn()));
        }
        if (createCacheClusterRequest.isAutoMinorVersionUpgrade() != null) {
            request.addParameter("AutoMinorVersionUpgrade", StringUtils.fromBoolean(createCacheClusterRequest.isAutoMinorVersionUpgrade()));
        }
        if (createCacheClusterRequest.getSnapshotRetentionLimit() != null) {
            request.addParameter("SnapshotRetentionLimit", StringUtils.fromInteger(createCacheClusterRequest.getSnapshotRetentionLimit()));
        }
        if (createCacheClusterRequest.getSnapshotWindow() != null) {
            request.addParameter("SnapshotWindow", StringUtils.fromString(createCacheClusterRequest.getSnapshotWindow()));
        }

        return request;
    }
}
