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
package com.amazonaws.services.dynamodbv2.model.transform;

import static com.amazonaws.stringutil.StringUtils.UTF8;

import java.io.StringWriter;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Batch Get Item Request Marshaller
 */
public class BatchGetItemRequestMarshaller implements Marshaller<Request<BatchGetItemRequest>, BatchGetItemRequest> {

    public Request<BatchGetItemRequest> marshall(BatchGetItemRequest batchGetItemRequest) {
        if (batchGetItemRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<BatchGetItemRequest> request = new DefaultRequest<BatchGetItemRequest>(batchGetItemRequest, "AmazonDynamoDBv2");
        String target = "DynamoDB_20120810.BatchGetItem";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (batchGetItemRequest.getRequestItems() != null) {
                jsonWriter.key("RequestItems");
                jsonWriter.object();
                for (Map.Entry<String, KeysAndAttributes> requestItemsListValue : batchGetItemRequest.getRequestItems().entrySet()) {
                    if (requestItemsListValue.getValue() != null) {
                        jsonWriter.key(requestItemsListValue.getKey());

                        jsonWriter.object();

                        com.amazonaws.serviceinternal.ListWithAutoConstructFlag<java.util.Map<String,AttributeValue>> keysList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<java.util.Map<String,AttributeValue>>)(requestItemsListValue.getValue().getKeys());
                        if (keysList != null && !(keysList.isAutoConstruct() && keysList.isEmpty())) {

                            jsonWriter.key("Keys");
                            jsonWriter.array();

                            for (java.util.Map<String,AttributeValue> keysListValue : keysList) {
                                if (keysListValue != null) {
                                        jsonWriter.object();
                                        for (Map.Entry<String, AttributeValue> memberListValue : keysListValue.entrySet()) {
                                            if (memberListValue.getValue() != null) {
                                                jsonWriter.key(memberListValue.getKey());

                                                jsonWriter.object();
                                                if (memberListValue.getValue().getS() != null) {
                                                    jsonWriter.key("S").value(memberListValue.getValue().getS());
                                                }
                                                if (memberListValue.getValue().getN() != null) {
                                                    jsonWriter.key("N").value(memberListValue.getValue().getN());
                                                }
                                                if (memberListValue.getValue().getB() != null) {
                                                    jsonWriter.key("B").value(memberListValue.getValue().getB());
                                                }

                                                com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> sSList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(memberListValue.getValue().getSS());
                                                if (sSList != null && !(sSList.isAutoConstruct() && sSList.isEmpty())) {

                                                    jsonWriter.key("SS");
                                                    jsonWriter.array();

                                                    for (String sSListValue : sSList) {
                                                        if (sSListValue != null) {
                                                            jsonWriter.value(sSListValue);
                                                        }
                                                    }
                                                    jsonWriter.endArray();
                                                }

                                                com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> nSList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(memberListValue.getValue().getNS());
                                                if (nSList != null && !(nSList.isAutoConstruct() && nSList.isEmpty())) {

                                                    jsonWriter.key("NS");
                                                    jsonWriter.array();

                                                    for (String nSListValue : nSList) {
                                                        if (nSListValue != null) {
                                                            jsonWriter.value(nSListValue);
                                                        }
                                                    }
                                                    jsonWriter.endArray();
                                                }

                                                com.amazonaws.serviceinternal.ListWithAutoConstructFlag<java.nio.ByteBuffer> bSList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<java.nio.ByteBuffer>)(memberListValue.getValue().getBS());
                                                if (bSList != null && !(bSList.isAutoConstruct() && bSList.isEmpty())) {

                                                    jsonWriter.key("BS");
                                                    jsonWriter.array();

                                                    for (java.nio.ByteBuffer bSListValue : bSList) {
                                                        if (bSListValue != null) {
                                                            jsonWriter.value(bSListValue);
                                                        }
                                                    }
                                                    jsonWriter.endArray();
                                                }
                                                jsonWriter.endObject();
                                            }
                                        }
                                        jsonWriter.endObject();
                                }
                            }
                            jsonWriter.endArray();
                        }

                        com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> attributesToGetList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(requestItemsListValue.getValue().getAttributesToGet());
                        if (attributesToGetList != null && !(attributesToGetList.isAutoConstruct() && attributesToGetList.isEmpty())) {

                            jsonWriter.key("AttributesToGet");
                            jsonWriter.array();

                            for (String attributesToGetListValue : attributesToGetList) {
                                if (attributesToGetListValue != null) {
                                    jsonWriter.value(attributesToGetListValue);
                                }
                            }
                            jsonWriter.endArray();
                        }
                        if (requestItemsListValue.getValue().isConsistentRead() != null) {
                            jsonWriter.key("ConsistentRead").value(requestItemsListValue.getValue().isConsistentRead());
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endObject();
            }
            if (batchGetItemRequest.getReturnConsumedCapacity() != null) {
                jsonWriter.key("ReturnConsumedCapacity").value(batchGetItemRequest.getReturnConsumedCapacity());
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
