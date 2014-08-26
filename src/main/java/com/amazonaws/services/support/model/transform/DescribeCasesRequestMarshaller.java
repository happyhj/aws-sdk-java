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
import com.amazonaws.method.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.support.model.DescribeCasesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;

/**
 * Describe Cases Request Marshaller
 */
public class DescribeCasesRequestMarshaller implements Marshaller<Request<DescribeCasesRequest>, DescribeCasesRequest> {

    public Request<DescribeCasesRequest> marshall(DescribeCasesRequest describeCasesRequest) {
        if (describeCasesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<DescribeCasesRequest> request = new DefaultRequest<DescribeCasesRequest>(describeCasesRequest, "AWSSupport");
        String target = "AWSSupport_20130415.DescribeCases";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();

            com.amazonaws.internal.ListWithAutoConstructFlag<String> caseIdListList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(describeCasesRequest.getCaseIdList());
            if (caseIdListList != null && !(caseIdListList.isAutoConstruct() && caseIdListList.isEmpty())) {

                jsonWriter.key("caseIdList");
                jsonWriter.array();

                for (String caseIdListListValue : caseIdListList) {
                    if (caseIdListListValue != null) {
                        jsonWriter.value(caseIdListListValue);
                    }
                }
                jsonWriter.endArray();
            }
            if (describeCasesRequest.getDisplayId() != null) {
                jsonWriter.key("displayId").value(describeCasesRequest.getDisplayId());
            }
            if (describeCasesRequest.getAfterTime() != null) {
                jsonWriter.key("afterTime").value(describeCasesRequest.getAfterTime());
            }
            if (describeCasesRequest.getBeforeTime() != null) {
                jsonWriter.key("beforeTime").value(describeCasesRequest.getBeforeTime());
            }
            if (describeCasesRequest.isIncludeResolvedCases() != null) {
                jsonWriter.key("includeResolvedCases").value(describeCasesRequest.isIncludeResolvedCases());
            }
            if (describeCasesRequest.getNextToken() != null) {
                jsonWriter.key("nextToken").value(describeCasesRequest.getNextToken());
            }
            if (describeCasesRequest.getMaxResults() != null) {
                jsonWriter.key("maxResults").value(describeCasesRequest.getMaxResults());
            }
            if (describeCasesRequest.getLanguage() != null) {
                jsonWriter.key("language").value(describeCasesRequest.getLanguage());
            }
            if (describeCasesRequest.isIncludeCommunications() != null) {
                jsonWriter.key("includeCommunications").value(describeCasesRequest.isIncludeCommunications());
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
