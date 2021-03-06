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
package com.amazonaws.services.cloudsearchv2.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.cloudsearchv2.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Update Scaling Parameters Request Marshaller
 */
public class UpdateScalingParametersRequestMarshaller implements Marshaller<Request<UpdateScalingParametersRequest>, UpdateScalingParametersRequest> {

    public Request<UpdateScalingParametersRequest> marshall(UpdateScalingParametersRequest updateScalingParametersRequest) {

        if (updateScalingParametersRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateScalingParametersRequest> request = new DefaultRequest<UpdateScalingParametersRequest>(updateScalingParametersRequest, "AmazonCloudSearchv2");
        request.addParameter("Action", "UpdateScalingParameters");
        request.addParameter("Version", "2013-01-01");

        if (updateScalingParametersRequest.getDomainName() != null) {
            request.addParameter("DomainName", StringUtils.fromString(updateScalingParametersRequest.getDomainName()));
        }
        ScalingParameters scalingParametersScalingParameters = updateScalingParametersRequest.getScalingParameters();
        if (scalingParametersScalingParameters != null) {
            if (scalingParametersScalingParameters.getDesiredInstanceType() != null) {
                request.addParameter("ScalingParameters.DesiredInstanceType", StringUtils.fromString(scalingParametersScalingParameters.getDesiredInstanceType()));
            }
            if (scalingParametersScalingParameters.getDesiredReplicationCount() != null) {
                request.addParameter("ScalingParameters.DesiredReplicationCount", StringUtils.fromInteger(scalingParametersScalingParameters.getDesiredReplicationCount()));
            }
            if (scalingParametersScalingParameters.getDesiredPartitionCount() != null) {
                request.addParameter("ScalingParameters.DesiredPartitionCount", StringUtils.fromInteger(scalingParametersScalingParameters.getDesiredPartitionCount()));
            }
        }

        return request;
    }
}
