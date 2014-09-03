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
package com.amazonaws.services.cognitoidentity.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Create Identity Pool Request Marshaller
 */
public class CreateIdentityPoolRequestMarshaller implements Marshaller<Request<CreateIdentityPoolRequest>, CreateIdentityPoolRequest> {

    public Request<CreateIdentityPoolRequest> marshall(CreateIdentityPoolRequest createIdentityPoolRequest) {
        if (createIdentityPoolRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CreateIdentityPoolRequest> request = new DefaultRequest<CreateIdentityPoolRequest>(createIdentityPoolRequest, "AmazonCognitoIdentity");
        String target = "AWSCognitoIdentityService.CreateIdentityPool";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (createIdentityPoolRequest.getIdentityPoolName() != null) {
                jsonWriter.key("IdentityPoolName").value(createIdentityPoolRequest.getIdentityPoolName());
            }
            if (createIdentityPoolRequest.isAllowUnauthenticatedIdentities() != null) {
                jsonWriter.key("AllowUnauthenticatedIdentities").value(createIdentityPoolRequest.isAllowUnauthenticatedIdentities());
            }
            if (createIdentityPoolRequest.getSupportedLoginProviders() != null) {
                jsonWriter.key("SupportedLoginProviders");
                jsonWriter.object();
                for (Map.Entry<String, String> supportedLoginProvidersListValue : createIdentityPoolRequest.getSupportedLoginProviders().entrySet()) {
                    if (supportedLoginProvidersListValue.getValue() != null) {
                        jsonWriter.key(supportedLoginProvidersListValue.getKey());

                        jsonWriter.value(supportedLoginProvidersListValue.getValue());
                    }
                }
                jsonWriter.endObject();
            }

          jsonWriter.endObject();

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes(UTF8);
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
          request.addHeader("Content-Type", "application/x-amz-json-1.0");
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
