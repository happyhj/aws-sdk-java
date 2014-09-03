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
package com.amazonaws.services.cloudfront_2012_03_15.model.transform;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.cloudfront_2012_03_15.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;
import com.amazonaws.utility.XMLWriter;

/**
 * Get Distribution Request Marshaller
 */
public class GetDistributionRequestMarshaller implements Marshaller<Request<GetDistributionRequest>, GetDistributionRequest> {

    public Request<GetDistributionRequest> marshall(GetDistributionRequest getDistributionRequest) {
        if (getDistributionRequest == null) { 
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<GetDistributionRequest> request = new DefaultRequest<GetDistributionRequest>(getDistributionRequest, "AmazonCloudFront");
        request.setHttpMethod(HttpMethodName.GET);

        String uriResourcePath = "2012-03-15/distribution/{Id}"; 
        uriResourcePath = uriResourcePath.replace("{Id}", getString(getDistributionRequest.getId())); 

        if (uriResourcePath.contains("?")) {
            String queryString = uriResourcePath.substring(uriResourcePath.indexOf("?") + 1);
            uriResourcePath    = uriResourcePath.substring(0, uriResourcePath.indexOf("?"));

            for (String s : queryString.split("[;&]")) {
                String[] nameValuePair = s.split("=");
                if (nameValuePair.length == 2) {
                    request.addParameter(nameValuePair[0], nameValuePair[1]);
                } else {
                    request.addParameter(s, null);
                }
            }
        }

        request.setResourcePath(uriResourcePath);

        

        return request;
    }

    private String getString(String s) {
        if (s == null) return "";
        return s;
    }
}
