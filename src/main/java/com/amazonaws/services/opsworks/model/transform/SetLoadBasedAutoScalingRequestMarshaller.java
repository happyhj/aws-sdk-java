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
package com.amazonaws.services.opsworks.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.opsworks.model.AutoScalingThresholds;
import com.amazonaws.services.opsworks.model.SetLoadBasedAutoScalingRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Set Load Based Auto Scaling Request Marshaller
 */
public class SetLoadBasedAutoScalingRequestMarshaller implements Marshaller<Request<SetLoadBasedAutoScalingRequest>, SetLoadBasedAutoScalingRequest> {

    public Request<SetLoadBasedAutoScalingRequest> marshall(SetLoadBasedAutoScalingRequest setLoadBasedAutoScalingRequest) {
        if (setLoadBasedAutoScalingRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<SetLoadBasedAutoScalingRequest> request = new DefaultRequest<SetLoadBasedAutoScalingRequest>(setLoadBasedAutoScalingRequest, "AWSOpsWorks");
        String target = "OpsWorks_20130218.SetLoadBasedAutoScaling";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (setLoadBasedAutoScalingRequest.getLayerId() != null) {
                jsonWriter.key("LayerId").value(setLoadBasedAutoScalingRequest.getLayerId());
            }
            if (setLoadBasedAutoScalingRequest.isEnable() != null) {
                jsonWriter.key("Enable").value(setLoadBasedAutoScalingRequest.isEnable());
            }
            AutoScalingThresholds upScaling = setLoadBasedAutoScalingRequest.getUpScaling();
            if (upScaling != null) {

                jsonWriter.key("UpScaling");
                jsonWriter.object();

                if (upScaling.getInstanceCount() != null) {
                    jsonWriter.key("InstanceCount").value(upScaling.getInstanceCount());
                }
                if (upScaling.getThresholdsWaitTime() != null) {
                    jsonWriter.key("ThresholdsWaitTime").value(upScaling.getThresholdsWaitTime());
                }
                if (upScaling.getIgnoreMetricsTime() != null) {
                    jsonWriter.key("IgnoreMetricsTime").value(upScaling.getIgnoreMetricsTime());
                }
                if (upScaling.getCpuThreshold() != null) {
                    jsonWriter.key("CpuThreshold").value(upScaling.getCpuThreshold());
                }
                if (upScaling.getMemoryThreshold() != null) {
                    jsonWriter.key("MemoryThreshold").value(upScaling.getMemoryThreshold());
                }
                if (upScaling.getLoadThreshold() != null) {
                    jsonWriter.key("LoadThreshold").value(upScaling.getLoadThreshold());
                }
                jsonWriter.endObject();
            }
            AutoScalingThresholds downScaling = setLoadBasedAutoScalingRequest.getDownScaling();
            if (downScaling != null) {

                jsonWriter.key("DownScaling");
                jsonWriter.object();

                if (downScaling.getInstanceCount() != null) {
                    jsonWriter.key("InstanceCount").value(downScaling.getInstanceCount());
                }
                if (downScaling.getThresholdsWaitTime() != null) {
                    jsonWriter.key("ThresholdsWaitTime").value(downScaling.getThresholdsWaitTime());
                }
                if (downScaling.getIgnoreMetricsTime() != null) {
                    jsonWriter.key("IgnoreMetricsTime").value(downScaling.getIgnoreMetricsTime());
                }
                if (downScaling.getCpuThreshold() != null) {
                    jsonWriter.key("CpuThreshold").value(downScaling.getCpuThreshold());
                }
                if (downScaling.getMemoryThreshold() != null) {
                    jsonWriter.key("MemoryThreshold").value(downScaling.getMemoryThreshold());
                }
                if (downScaling.getLoadThreshold() != null) {
                    jsonWriter.key("LoadThreshold").value(downScaling.getLoadThreshold());
                }
                jsonWriter.endObject();
            }

          jsonWriter.endObject();

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes(UTF8);
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
          request.addHeader("Content-Type", "application/x-amz-json-1.1");
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
