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
package com.amazonaws.services.directconnect.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.directconnect.model.CreatePublicVirtualInterfaceRequest;
import com.amazonaws.services.directconnect.model.NewPublicVirtualInterface;
import com.amazonaws.services.directconnect.model.RouteFilterPrefix;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Create Public Virtual Interface Request Marshaller
 */
public class CreatePublicVirtualInterfaceRequestMarshaller implements Marshaller<Request<CreatePublicVirtualInterfaceRequest>, CreatePublicVirtualInterfaceRequest> {

    public Request<CreatePublicVirtualInterfaceRequest> marshall(CreatePublicVirtualInterfaceRequest createPublicVirtualInterfaceRequest) {
        if (createPublicVirtualInterfaceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CreatePublicVirtualInterfaceRequest> request = new DefaultRequest<CreatePublicVirtualInterfaceRequest>(createPublicVirtualInterfaceRequest, "AmazonDirectConnect");
        String target = "OvertureService.CreatePublicVirtualInterface";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (createPublicVirtualInterfaceRequest.getConnectionId() != null) {
                jsonWriter.key("connectionId").value(createPublicVirtualInterfaceRequest.getConnectionId());
            }
            NewPublicVirtualInterface newPublicVirtualInterface = createPublicVirtualInterfaceRequest.getNewPublicVirtualInterface();
            if (newPublicVirtualInterface != null) {

                jsonWriter.key("newPublicVirtualInterface");
                jsonWriter.object();

                if (newPublicVirtualInterface.getVirtualInterfaceName() != null) {
                    jsonWriter.key("virtualInterfaceName").value(newPublicVirtualInterface.getVirtualInterfaceName());
                }
                if (newPublicVirtualInterface.getVlan() != null) {
                    jsonWriter.key("vlan").value(newPublicVirtualInterface.getVlan());
                }
                if (newPublicVirtualInterface.getAsn() != null) {
                    jsonWriter.key("asn").value(newPublicVirtualInterface.getAsn());
                }
                if (newPublicVirtualInterface.getAuthKey() != null) {
                    jsonWriter.key("authKey").value(newPublicVirtualInterface.getAuthKey());
                }
                if (newPublicVirtualInterface.getAmazonAddress() != null) {
                    jsonWriter.key("amazonAddress").value(newPublicVirtualInterface.getAmazonAddress());
                }
                if (newPublicVirtualInterface.getCustomerAddress() != null) {
                    jsonWriter.key("customerAddress").value(newPublicVirtualInterface.getCustomerAddress());
                }

                com.amazonaws.serviceinternal.ListWithAutoConstructFlag<RouteFilterPrefix> routeFilterPrefixesList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<RouteFilterPrefix>)(newPublicVirtualInterface.getRouteFilterPrefixes());
                if (routeFilterPrefixesList != null && !(routeFilterPrefixesList.isAutoConstruct() && routeFilterPrefixesList.isEmpty())) {

                    jsonWriter.key("routeFilterPrefixes");
                    jsonWriter.array();

                    for (RouteFilterPrefix routeFilterPrefixesListValue : routeFilterPrefixesList) {
                        if (routeFilterPrefixesListValue != null) {
                            jsonWriter.object();
                            if (routeFilterPrefixesListValue.getCidr() != null) {
                                jsonWriter.key("cidr").value(routeFilterPrefixesListValue.getCidr());
                            }
                            jsonWriter.endObject();
                        }
                    }
                    jsonWriter.endArray();
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
