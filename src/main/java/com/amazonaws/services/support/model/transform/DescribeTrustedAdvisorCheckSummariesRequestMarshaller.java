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
package com.amazonaws.services.support.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.support.model.DescribeTrustedAdvisorCheckSummariesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Describe Trusted Advisor Check Summaries Request Marshaller
 */
public class DescribeTrustedAdvisorCheckSummariesRequestMarshaller implements Marshaller<Request<DescribeTrustedAdvisorCheckSummariesRequest>, DescribeTrustedAdvisorCheckSummariesRequest> {

    public Request<DescribeTrustedAdvisorCheckSummariesRequest> marshall(DescribeTrustedAdvisorCheckSummariesRequest describeTrustedAdvisorCheckSummariesRequest) {
        if (describeTrustedAdvisorCheckSummariesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeTrustedAdvisorCheckSummariesRequest> request = new DefaultRequest<DescribeTrustedAdvisorCheckSummariesRequest>(describeTrustedAdvisorCheckSummariesRequest, "AWSSupport");
        String target = "AWSSupport_20130415.DescribeTrustedAdvisorCheckSummaries";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> checkIdsList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(describeTrustedAdvisorCheckSummariesRequest.getCheckIds());
            if (checkIdsList != null && !(checkIdsList.isAutoConstruct() && checkIdsList.isEmpty())) {

                jsonWriter.key("checkIds");
                jsonWriter.array();

                for (String checkIdsListValue : checkIdsList) {
                    if (checkIdsListValue != null) {
                        jsonWriter.value(checkIdsListValue);
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
