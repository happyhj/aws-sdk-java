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
package com.amazonaws.services.datapipeline.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.datapipeline.model.Operator;
import com.amazonaws.services.datapipeline.model.Query;
import com.amazonaws.services.datapipeline.model.QueryObjectsRequest;
import com.amazonaws.services.datapipeline.model.Selector;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Query Objects Request Marshaller
 */
public class QueryObjectsRequestMarshaller implements Marshaller<Request<QueryObjectsRequest>, QueryObjectsRequest> {

    public Request<QueryObjectsRequest> marshall(QueryObjectsRequest queryObjectsRequest) {
        if (queryObjectsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<QueryObjectsRequest> request = new DefaultRequest<QueryObjectsRequest>(queryObjectsRequest, "DataPipeline");
        String target = "DataPipeline.QueryObjects";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (queryObjectsRequest.getPipelineId() != null) {
                jsonWriter.key("pipelineId").value(queryObjectsRequest.getPipelineId());
            }
            Query query = queryObjectsRequest.getQuery();
            if (query != null) {

                jsonWriter.key("query");
                jsonWriter.object();

                com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Selector> selectorsList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Selector>)(query.getSelectors());
                if (selectorsList != null && !(selectorsList.isAutoConstruct() && selectorsList.isEmpty())) {

                    jsonWriter.key("selectors");
                    jsonWriter.array();

                    for (Selector selectorsListValue : selectorsList) {
                        if (selectorsListValue != null) {
                            jsonWriter.object();
                            if (selectorsListValue.getFieldName() != null) {
                                jsonWriter.key("fieldName").value(selectorsListValue.getFieldName());
                            }
                            Operator operator = selectorsListValue.getOperator();
                            if (operator != null) {

                                jsonWriter.key("operator");
                                jsonWriter.object();

                                if (operator.getType() != null) {
                                    jsonWriter.key("type").value(operator.getType());
                                }

                                com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> valuesList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(operator.getValues());
                                if (valuesList != null && !(valuesList.isAutoConstruct() && valuesList.isEmpty())) {

                                    jsonWriter.key("values");
                                    jsonWriter.array();

                                    for (String valuesListValue : valuesList) {
                                        if (valuesListValue != null) {
                                            jsonWriter.value(valuesListValue);
                                        }
                                    }
                                    jsonWriter.endArray();
                                }
                                jsonWriter.endObject();
                            }
                            jsonWriter.endObject();
                        }
                    }
                    jsonWriter.endArray();
                }
                jsonWriter.endObject();
            }
            if (queryObjectsRequest.getSphere() != null) {
                jsonWriter.key("sphere").value(queryObjectsRequest.getSphere());
            }
            if (queryObjectsRequest.getMarker() != null) {
                jsonWriter.key("marker").value(queryObjectsRequest.getMarker());
            }
            if (queryObjectsRequest.getLimit() != null) {
                jsonWriter.key("limit").value(queryObjectsRequest.getLimit());
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
