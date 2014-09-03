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
package com.amazonaws.services.dynamodb.model.transform;


import java.io.StringWriter;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.dynamodb.model.AttributeValue;
import com.amazonaws.services.dynamodb.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodb.model.Key;
import com.amazonaws.services.dynamodb.model.KeysAndAttributes;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Batch Get Item Request Marshaller
 * @deprecated Use {@link com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemRequestMarshaller} instead.
 */
@Deprecated
public class BatchGetItemRequestMarshaller implements Marshaller<Request<BatchGetItemRequest>, BatchGetItemRequest> {

    

    public Request<BatchGetItemRequest> marshall(BatchGetItemRequest batchGetItemRequest) {
    if (batchGetItemRequest == null) {
        throw new AmazonClientException("Invalid argument passed to marshall(...)");
    }

        Request<BatchGetItemRequest> request = new DefaultRequest<BatchGetItemRequest>(batchGetItemRequest, "AmazonDynamoDB");
        String target = "DynamoDB_20111205.BatchGetItem";
        request.addHeader("X-Amz-Target", target);
        request.addHeader("Content-Type", "application/x-amz-json-1.0");

        
        request.setHttpMethod(HttpMethodName.POST);


        String uriResourcePath = ""; 

        uriResourcePath = uriResourcePath.replaceAll("//", "/");

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

                        java.util.List<Key> keysList = requestItemsListValue.getValue().getKeys();
                        if (keysList != null && keysList.size() > 0) {

                            jsonWriter.key("Keys");
                            jsonWriter.array();

                            for (Key keysListValue : keysList) {
                                if (keysListValue != null) {
                                    jsonWriter.object();
                                    AttributeValue hashKeyElement = keysListValue.getHashKeyElement();
                                    if (hashKeyElement != null) {

                                        jsonWriter.key("HashKeyElement");
                                        jsonWriter.object();

                                        if (hashKeyElement.getS() != null) {
                                            jsonWriter.key("S").value(hashKeyElement.getS());
                                        }
                                        if (hashKeyElement.getN() != null) {
                                            jsonWriter.key("N").value(hashKeyElement.getN());
                                        }
                                        if (hashKeyElement.getB() != null) {
                                            jsonWriter.key("B").value(hashKeyElement.getB());
                                        }

                                        java.util.List<String> sSList = hashKeyElement.getSS();
                                        if (sSList != null && sSList.size() > 0) {

                                            jsonWriter.key("SS");
                                            jsonWriter.array();

                                            for (String sSListValue : sSList) {
                                                if (sSListValue != null) {
                                                    jsonWriter.value(sSListValue);
                                                }
                                            }
                                            jsonWriter.endArray();
                                        }

                                        java.util.List<String> nSList = hashKeyElement.getNS();
                                        if (nSList != null && nSList.size() > 0) {

                                            jsonWriter.key("NS");
                                            jsonWriter.array();

                                            for (String nSListValue : nSList) {
                                                if (nSListValue != null) {
                                                    jsonWriter.value(nSListValue);
                                                }
                                            }
                                            jsonWriter.endArray();
                                        }

                                        java.util.List<java.nio.ByteBuffer> bSList = hashKeyElement.getBS();
                                        if (bSList != null && bSList.size() > 0) {

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
                                    AttributeValue rangeKeyElement = keysListValue.getRangeKeyElement();
                                    if (rangeKeyElement != null) {

                                        jsonWriter.key("RangeKeyElement");
                                        jsonWriter.object();

                                        if (rangeKeyElement.getS() != null) {
                                            jsonWriter.key("S").value(rangeKeyElement.getS());
                                        }
                                        if (rangeKeyElement.getN() != null) {
                                            jsonWriter.key("N").value(rangeKeyElement.getN());
                                        }
                                        if (rangeKeyElement.getB() != null) {
                                            jsonWriter.key("B").value(rangeKeyElement.getB());
                                        }

                                        java.util.List<String> sSList = rangeKeyElement.getSS();
                                        if (sSList != null && sSList.size() > 0) {

                                            jsonWriter.key("SS");
                                            jsonWriter.array();

                                            for (String sSListValue : sSList) {
                                                if (sSListValue != null) {
                                                    jsonWriter.value(sSListValue);
                                                }
                                            }
                                            jsonWriter.endArray();
                                        }

                                        java.util.List<String> nSList = rangeKeyElement.getNS();
                                        if (nSList != null && nSList.size() > 0) {

                                            jsonWriter.key("NS");
                                            jsonWriter.array();

                                            for (String nSListValue : nSList) {
                                                if (nSListValue != null) {
                                                    jsonWriter.value(nSListValue);
                                                }
                                            }
                                            jsonWriter.endArray();
                                        }

                                        java.util.List<java.nio.ByteBuffer> bSList = rangeKeyElement.getBS();
                                        if (bSList != null && bSList.size() > 0) {

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
                                    jsonWriter.endObject();
                                }
                            }
                            jsonWriter.endArray();
                        }

                        java.util.List<String> attributesToGetList = requestItemsListValue.getValue().getAttributesToGet();
                        if (attributesToGetList != null && attributesToGetList.size() > 0) {

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

          jsonWriter.endObject();
          

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes("UTF-8");
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }
        

        return request;
    }

    private String getString(String s) {
        if (s == null) return "";
        return s;
    }
}
