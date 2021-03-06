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
package com.amazonaws.services.storagegateway.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.storagegateway.model.ActivateGatewayRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Activate Gateway Request Marshaller
 */
public class ActivateGatewayRequestMarshaller implements Marshaller<Request<ActivateGatewayRequest>, ActivateGatewayRequest> {

    public Request<ActivateGatewayRequest> marshall(ActivateGatewayRequest activateGatewayRequest) {
        if (activateGatewayRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ActivateGatewayRequest> request = new DefaultRequest<ActivateGatewayRequest>(activateGatewayRequest, "AWSStorageGateway");
        String target = "StorageGateway_20130630.ActivateGateway";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (activateGatewayRequest.getActivationKey() != null) {
                jsonWriter.key("ActivationKey").value(activateGatewayRequest.getActivationKey());
            }
            if (activateGatewayRequest.getGatewayName() != null) {
                jsonWriter.key("GatewayName").value(activateGatewayRequest.getGatewayName());
            }
            if (activateGatewayRequest.getGatewayTimezone() != null) {
                jsonWriter.key("GatewayTimezone").value(activateGatewayRequest.getGatewayTimezone());
            }
            if (activateGatewayRequest.getGatewayRegion() != null) {
                jsonWriter.key("GatewayRegion").value(activateGatewayRequest.getGatewayRegion());
            }
            if (activateGatewayRequest.getGatewayType() != null) {
                jsonWriter.key("GatewayType").value(activateGatewayRequest.getGatewayType());
            }
            if (activateGatewayRequest.getTapeDriveType() != null) {
                jsonWriter.key("TapeDriveType").value(activateGatewayRequest.getTapeDriveType());
            }
            if (activateGatewayRequest.getMediumChangerType() != null) {
                jsonWriter.key("MediumChangerType").value(activateGatewayRequest.getMediumChangerType());
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
