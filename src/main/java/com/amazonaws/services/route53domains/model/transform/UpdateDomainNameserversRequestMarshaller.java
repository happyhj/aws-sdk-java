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
import com.amazonaws.services.route53domains.model.Nameserver;
import com.amazonaws.services.route53domains.model.UpdateDomainNameserversRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Update Domain Nameservers Request Marshaller
 */
public class UpdateDomainNameserversRequestMarshaller implements Marshaller<Request<UpdateDomainNameserversRequest>, UpdateDomainNameserversRequest> {

    public Request<UpdateDomainNameserversRequest> marshall(UpdateDomainNameserversRequest updateDomainNameserversRequest) {
        if (updateDomainNameserversRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateDomainNameserversRequest> request = new DefaultRequest<UpdateDomainNameserversRequest>(updateDomainNameserversRequest, "AmazonRoute53Domains");
        String target = "Route53Domains_v20140515.UpdateDomainNameservers";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (updateDomainNameserversRequest.getDomainName() != null) {
                jsonWriter.key("DomainName").value(updateDomainNameserversRequest.getDomainName());
            }

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Nameserver> nameserversList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Nameserver>)(updateDomainNameserversRequest.getNameservers());
            if (nameserversList != null && !(nameserversList.isAutoConstruct() && nameserversList.isEmpty())) {

                jsonWriter.key("Nameservers");
                jsonWriter.array();

                for (Nameserver nameserversListValue : nameserversList) {
                    if (nameserversListValue != null) {
                        jsonWriter.object();
                        if (nameserversListValue.getName() != null) {
                            jsonWriter.key("Name").value(nameserversListValue.getName());
                        }

                        com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> glueIpsList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(nameserversListValue.getGlueIps());
                        if (glueIpsList != null && !(glueIpsList.isAutoConstruct() && glueIpsList.isEmpty())) {

                            jsonWriter.key("GlueIps");
                            jsonWriter.array();

                            for (String glueIpsListValue : glueIpsList) {
                                if (glueIpsListValue != null) {
                                    jsonWriter.value(glueIpsListValue);
                                }
                            }
                            jsonWriter.endArray();
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
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
