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
package com.amazonaws.services.autoscaling.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.autoscaling.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Create Launch Configuration Request Marshaller
 */
public class CreateLaunchConfigurationRequestMarshaller implements Marshaller<Request<CreateLaunchConfigurationRequest>, CreateLaunchConfigurationRequest> {

    public Request<CreateLaunchConfigurationRequest> marshall(CreateLaunchConfigurationRequest createLaunchConfigurationRequest) {

        if (createLaunchConfigurationRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CreateLaunchConfigurationRequest> request = new DefaultRequest<CreateLaunchConfigurationRequest>(createLaunchConfigurationRequest, "AmazonAutoScaling");
        request.addParameter("Action", "CreateLaunchConfiguration");
        request.addParameter("Version", "2011-01-01");

        if (createLaunchConfigurationRequest.getLaunchConfigurationName() != null) {
            request.addParameter("LaunchConfigurationName", StringUtils.fromString(createLaunchConfigurationRequest.getLaunchConfigurationName()));
        }
        if (createLaunchConfigurationRequest.getImageId() != null) {
            request.addParameter("ImageId", StringUtils.fromString(createLaunchConfigurationRequest.getImageId()));
        }
        if (createLaunchConfigurationRequest.getKeyName() != null) {
            request.addParameter("KeyName", StringUtils.fromString(createLaunchConfigurationRequest.getKeyName()));
        }

        java.util.List<String> securityGroupsList = createLaunchConfigurationRequest.getSecurityGroups();
        int securityGroupsListIndex = 1;

        for (String securityGroupsListValue : securityGroupsList) {
            if (securityGroupsListValue != null) {
                request.addParameter("SecurityGroups.member." + securityGroupsListIndex, StringUtils.fromString(securityGroupsListValue));
            }

            securityGroupsListIndex++;
        }
        if (createLaunchConfigurationRequest.getUserData() != null) {
            request.addParameter("UserData", StringUtils.fromString(createLaunchConfigurationRequest.getUserData()));
        }
        if (createLaunchConfigurationRequest.getInstanceId() != null) {
            request.addParameter("InstanceId", StringUtils.fromString(createLaunchConfigurationRequest.getInstanceId()));
        }
        if (createLaunchConfigurationRequest.getInstanceType() != null) {
            request.addParameter("InstanceType", StringUtils.fromString(createLaunchConfigurationRequest.getInstanceType()));
        }
        if (createLaunchConfigurationRequest.getKernelId() != null) {
            request.addParameter("KernelId", StringUtils.fromString(createLaunchConfigurationRequest.getKernelId()));
        }
        if (createLaunchConfigurationRequest.getRamdiskId() != null) {
            request.addParameter("RamdiskId", StringUtils.fromString(createLaunchConfigurationRequest.getRamdiskId()));
        }

        java.util.List<BlockDeviceMapping> blockDeviceMappingsList = createLaunchConfigurationRequest.getBlockDeviceMappings();
        int blockDeviceMappingsListIndex = 1;

        for (BlockDeviceMapping blockDeviceMappingsListValue : blockDeviceMappingsList) {
            BlockDeviceMapping blockDeviceMappingMember = blockDeviceMappingsListValue;
            if (blockDeviceMappingMember != null) {
                if (blockDeviceMappingMember.getVirtualName() != null) {
                    request.addParameter("BlockDeviceMappings.member." + blockDeviceMappingsListIndex + ".VirtualName", StringUtils.fromString(blockDeviceMappingMember.getVirtualName()));
                }
                if (blockDeviceMappingMember.getDeviceName() != null) {
                    request.addParameter("BlockDeviceMappings.member." + blockDeviceMappingsListIndex + ".DeviceName", StringUtils.fromString(blockDeviceMappingMember.getDeviceName()));
                }
                Ebs ebsEbs = blockDeviceMappingMember.getEbs();
                if (ebsEbs != null) {
                    if (ebsEbs.getSnapshotId() != null) {
                        request.addParameter("BlockDeviceMappings.member." + blockDeviceMappingsListIndex + ".Ebs.SnapshotId", StringUtils.fromString(ebsEbs.getSnapshotId()));
                    }
                    if (ebsEbs.getVolumeSize() != null) {
                        request.addParameter("BlockDeviceMappings.member." + blockDeviceMappingsListIndex + ".Ebs.VolumeSize", StringUtils.fromInteger(ebsEbs.getVolumeSize()));
                    }
                    if (ebsEbs.getVolumeType() != null) {
                        request.addParameter("BlockDeviceMappings.member." + blockDeviceMappingsListIndex + ".Ebs.VolumeType", StringUtils.fromString(ebsEbs.getVolumeType()));
                    }
                    if (ebsEbs.isDeleteOnTermination() != null) {
                        request.addParameter("BlockDeviceMappings.member." + blockDeviceMappingsListIndex + ".Ebs.DeleteOnTermination", StringUtils.fromBoolean(ebsEbs.isDeleteOnTermination()));
                    }
                    if (ebsEbs.getIops() != null) {
                        request.addParameter("BlockDeviceMappings.member." + blockDeviceMappingsListIndex + ".Ebs.Iops", StringUtils.fromInteger(ebsEbs.getIops()));
                    }
                }
                if (blockDeviceMappingMember.isNoDevice() != null) {
                    request.addParameter("BlockDeviceMappings.member." + blockDeviceMappingsListIndex + ".NoDevice", StringUtils.fromBoolean(blockDeviceMappingMember.isNoDevice()));
                }
            }

            blockDeviceMappingsListIndex++;
        }
        InstanceMonitoring instanceMonitoringInstanceMonitoring = createLaunchConfigurationRequest.getInstanceMonitoring();
        if (instanceMonitoringInstanceMonitoring != null) {
            if (instanceMonitoringInstanceMonitoring.isEnabled() != null) {
                request.addParameter("InstanceMonitoring.Enabled", StringUtils.fromBoolean(instanceMonitoringInstanceMonitoring.isEnabled()));
            }
        }
        if (createLaunchConfigurationRequest.getSpotPrice() != null) {
            request.addParameter("SpotPrice", StringUtils.fromString(createLaunchConfigurationRequest.getSpotPrice()));
        }
        if (createLaunchConfigurationRequest.getIamInstanceProfile() != null) {
            request.addParameter("IamInstanceProfile", StringUtils.fromString(createLaunchConfigurationRequest.getIamInstanceProfile()));
        }
        if (createLaunchConfigurationRequest.isEbsOptimized() != null) {
            request.addParameter("EbsOptimized", StringUtils.fromBoolean(createLaunchConfigurationRequest.isEbsOptimized()));
        }
        if (createLaunchConfigurationRequest.isAssociatePublicIpAddress() != null) {
            request.addParameter("AssociatePublicIpAddress", StringUtils.fromBoolean(createLaunchConfigurationRequest.isAssociatePublicIpAddress()));
        }
        if (createLaunchConfigurationRequest.getPlacementTenancy() != null) {
            request.addParameter("PlacementTenancy", StringUtils.fromString(createLaunchConfigurationRequest.getPlacementTenancy()));
        }

        return request;
    }
}
