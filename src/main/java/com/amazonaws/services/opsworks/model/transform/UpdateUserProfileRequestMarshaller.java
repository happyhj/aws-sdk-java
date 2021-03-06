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
import com.amazonaws.services.opsworks.model.UpdateUserProfileRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Update User Profile Request Marshaller
 */
public class UpdateUserProfileRequestMarshaller implements Marshaller<Request<UpdateUserProfileRequest>, UpdateUserProfileRequest> {

    public Request<UpdateUserProfileRequest> marshall(UpdateUserProfileRequest updateUserProfileRequest) {
        if (updateUserProfileRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateUserProfileRequest> request = new DefaultRequest<UpdateUserProfileRequest>(updateUserProfileRequest, "AWSOpsWorks");
        String target = "OpsWorks_20130218.UpdateUserProfile";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (updateUserProfileRequest.getIamUserArn() != null) {
                jsonWriter.key("IamUserArn").value(updateUserProfileRequest.getIamUserArn());
            }
            if (updateUserProfileRequest.getSshUsername() != null) {
                jsonWriter.key("SshUsername").value(updateUserProfileRequest.getSshUsername());
            }
            if (updateUserProfileRequest.getSshPublicKey() != null) {
                jsonWriter.key("SshPublicKey").value(updateUserProfileRequest.getSshPublicKey());
            }
            if (updateUserProfileRequest.isAllowSelfManagement() != null) {
                jsonWriter.key("AllowSelfManagement").value(updateUserProfileRequest.isAllowSelfManagement());
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
