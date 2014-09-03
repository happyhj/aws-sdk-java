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
import com.amazonaws.services.opsworks.model.DescribeRdsDbInstancesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Describe Rds Db Instances Request Marshaller
 */
public class DescribeRdsDbInstancesRequestMarshaller implements Marshaller<Request<DescribeRdsDbInstancesRequest>, DescribeRdsDbInstancesRequest> {

    public Request<DescribeRdsDbInstancesRequest> marshall(DescribeRdsDbInstancesRequest describeRdsDbInstancesRequest) {
        if (describeRdsDbInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeRdsDbInstancesRequest> request = new DefaultRequest<DescribeRdsDbInstancesRequest>(describeRdsDbInstancesRequest, "AWSOpsWorks");
        String target = "OpsWorks_20130218.DescribeRdsDbInstances";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (describeRdsDbInstancesRequest.getStackId() != null) {
                jsonWriter.key("StackId").value(describeRdsDbInstancesRequest.getStackId());
            }

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> rdsDbInstanceArnsList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(describeRdsDbInstancesRequest.getRdsDbInstanceArns());
            if (rdsDbInstanceArnsList != null && !(rdsDbInstanceArnsList.isAutoConstruct() && rdsDbInstanceArnsList.isEmpty())) {

                jsonWriter.key("RdsDbInstanceArns");
                jsonWriter.array();

                for (String rdsDbInstanceArnsListValue : rdsDbInstanceArnsList) {
                    if (rdsDbInstanceArnsListValue != null) {
                        jsonWriter.value(rdsDbInstanceArnsListValue);
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
