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
package com.amazonaws.services.route53domains.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.route53domains.model.UpdateDomainContactPrivacyRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Update Domain Contact Privacy Request Marshaller
 */
public class UpdateDomainContactPrivacyRequestMarshaller implements Marshaller<Request<UpdateDomainContactPrivacyRequest>, UpdateDomainContactPrivacyRequest> {

    public Request<UpdateDomainContactPrivacyRequest> marshall(UpdateDomainContactPrivacyRequest updateDomainContactPrivacyRequest) {
        if (updateDomainContactPrivacyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateDomainContactPrivacyRequest> request = new DefaultRequest<UpdateDomainContactPrivacyRequest>(updateDomainContactPrivacyRequest, "AmazonRoute53Domains");
        String target = "Route53Domains_v20140515.UpdateDomainContactPrivacy";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (updateDomainContactPrivacyRequest.getDomainName() != null) {
                jsonWriter.key("DomainName").value(updateDomainContactPrivacyRequest.getDomainName());
            }
            if (updateDomainContactPrivacyRequest.isAdminPrivacy() != null) {
                jsonWriter.key("AdminPrivacy").value(updateDomainContactPrivacyRequest.isAdminPrivacy());
            }
            if (updateDomainContactPrivacyRequest.isRegistrantPrivacy() != null) {
                jsonWriter.key("RegistrantPrivacy").value(updateDomainContactPrivacyRequest.isRegistrantPrivacy());
            }
            if (updateDomainContactPrivacyRequest.isTechPrivacy() != null) {
                jsonWriter.key("TechPrivacy").value(updateDomainContactPrivacyRequest.isTechPrivacy());
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
