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

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.json.JSONWriter;
import com.amazonaws.network.HttpMethodName;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndex;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndex;
import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Create Table Request Marshaller
 */
public class CreateTableRequestMarshaller implements Marshaller<Request<CreateTableRequest>, CreateTableRequest> {

    public Request<CreateTableRequest> marshall(CreateTableRequest createTableRequest) {
        if (createTableRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CreateTableRequest> request = new DefaultRequest<CreateTableRequest>(createTableRequest, "AmazonDynamoDBv2");
        String target = "DynamoDB_20120810.CreateTable";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<AttributeDefinition> attributeDefinitionsList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<AttributeDefinition>)(createTableRequest.getAttributeDefinitions());
            if (attributeDefinitionsList != null && !(attributeDefinitionsList.isAutoConstruct() && attributeDefinitionsList.isEmpty())) {

                jsonWriter.key("AttributeDefinitions");
                jsonWriter.array();

                for (AttributeDefinition attributeDefinitionsListValue : attributeDefinitionsList) {
                    if (attributeDefinitionsListValue != null) {
                        jsonWriter.object();
                        if (attributeDefinitionsListValue.getAttributeName() != null) {
                            jsonWriter.key("AttributeName").value(attributeDefinitionsListValue.getAttributeName());
                        }
                        if (attributeDefinitionsListValue.getAttributeType() != null) {
                            jsonWriter.key("AttributeType").value(attributeDefinitionsListValue.getAttributeType());
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }
            if (createTableRequest.getTableName() != null) {
                jsonWriter.key("TableName").value(createTableRequest.getTableName());
            }

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<KeySchemaElement> keySchemaList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<KeySchemaElement>)(createTableRequest.getKeySchema());
            if (keySchemaList != null && !(keySchemaList.isAutoConstruct() && keySchemaList.isEmpty())) {

                jsonWriter.key("KeySchema");
                jsonWriter.array();

                for (KeySchemaElement keySchemaListValue : keySchemaList) {
                    if (keySchemaListValue != null) {
                        jsonWriter.object();
                        if (keySchemaListValue.getAttributeName() != null) {
                            jsonWriter.key("AttributeName").value(keySchemaListValue.getAttributeName());
                        }
                        if (keySchemaListValue.getKeyType() != null) {
                            jsonWriter.key("KeyType").value(keySchemaListValue.getKeyType());
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<LocalSecondaryIndex> localSecondaryIndexesList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<LocalSecondaryIndex>)(createTableRequest.getLocalSecondaryIndexes());
            if (localSecondaryIndexesList != null && !(localSecondaryIndexesList.isAutoConstruct() && localSecondaryIndexesList.isEmpty())) {

                jsonWriter.key("LocalSecondaryIndexes");
                jsonWriter.array();

                for (LocalSecondaryIndex localSecondaryIndexesListValue : localSecondaryIndexesList) {
                    if (localSecondaryIndexesListValue != null) {
                        jsonWriter.object();
                        if (localSecondaryIndexesListValue.getIndexName() != null) {
                            jsonWriter.key("IndexName").value(localSecondaryIndexesListValue.getIndexName());
                        }

                        com.amazonaws.serviceinternal.ListWithAutoConstructFlag<KeySchemaElement> keySchema2List = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<KeySchemaElement>)(localSecondaryIndexesListValue.getKeySchema());
                        if (keySchema2List != null && !(keySchema2List.isAutoConstruct() && keySchema2List.isEmpty())) {

                            jsonWriter.key("KeySchema");
                            jsonWriter.array();

                            for (KeySchemaElement keySchema2ListValue : keySchema2List) {
                                if (keySchema2ListValue != null) {
                                    jsonWriter.object();
                                    if (keySchema2ListValue.getAttributeName() != null) {
                                        jsonWriter.key("AttributeName").value(keySchema2ListValue.getAttributeName());
                                    }
                                    if (keySchema2ListValue.getKeyType() != null) {
                                        jsonWriter.key("KeyType").value(keySchema2ListValue.getKeyType());
                                    }
                                    jsonWriter.endObject();
                                }
                            }
                            jsonWriter.endArray();
                        }
                        Projection projection = localSecondaryIndexesListValue.getProjection();
                        if (projection != null) {

                            jsonWriter.key("Projection");
                            jsonWriter.object();

                            if (projection.getProjectionType() != null) {
                                jsonWriter.key("ProjectionType").value(projection.getProjectionType());
                            }

                            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> nonKeyAttributesList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(projection.getNonKeyAttributes());
                            if (nonKeyAttributesList != null && !(nonKeyAttributesList.isAutoConstruct() && nonKeyAttributesList.isEmpty())) {

                                jsonWriter.key("NonKeyAttributes");
                                jsonWriter.array();

                                for (String nonKeyAttributesListValue : nonKeyAttributesList) {
                                    if (nonKeyAttributesListValue != null) {
                                        jsonWriter.value(nonKeyAttributesListValue);
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

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<GlobalSecondaryIndex> globalSecondaryIndexesList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<GlobalSecondaryIndex>)(createTableRequest.getGlobalSecondaryIndexes());
            if (globalSecondaryIndexesList != null && !(globalSecondaryIndexesList.isAutoConstruct() && globalSecondaryIndexesList.isEmpty())) {

                jsonWriter.key("GlobalSecondaryIndexes");
                jsonWriter.array();

                for (GlobalSecondaryIndex globalSecondaryIndexesListValue : globalSecondaryIndexesList) {
                    if (globalSecondaryIndexesListValue != null) {
                        jsonWriter.object();
                        if (globalSecondaryIndexesListValue.getIndexName() != null) {
                            jsonWriter.key("IndexName").value(globalSecondaryIndexesListValue.getIndexName());
                        }

                        com.amazonaws.serviceinternal.ListWithAutoConstructFlag<KeySchemaElement> keySchema2List = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<KeySchemaElement>)(globalSecondaryIndexesListValue.getKeySchema());
                        if (keySchema2List != null && !(keySchema2List.isAutoConstruct() && keySchema2List.isEmpty())) {

                            jsonWriter.key("KeySchema");
                            jsonWriter.array();

                            for (KeySchemaElement keySchema2ListValue : keySchema2List) {
                                if (keySchema2ListValue != null) {
                                    jsonWriter.object();
                                    if (keySchema2ListValue.getAttributeName() != null) {
                                        jsonWriter.key("AttributeName").value(keySchema2ListValue.getAttributeName());
                                    }
                                    if (keySchema2ListValue.getKeyType() != null) {
                                        jsonWriter.key("KeyType").value(keySchema2ListValue.getKeyType());
                                    }
                                    jsonWriter.endObject();
                                }
                            }
                            jsonWriter.endArray();
                        }
                        Projection projection = globalSecondaryIndexesListValue.getProjection();
                        if (projection != null) {

                            jsonWriter.key("Projection");
                            jsonWriter.object();

                            if (projection.getProjectionType() != null) {
                                jsonWriter.key("ProjectionType").value(projection.getProjectionType());
                            }

                            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> nonKeyAttributesList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>)(projection.getNonKeyAttributes());
                            if (nonKeyAttributesList != null && !(nonKeyAttributesList.isAutoConstruct() && nonKeyAttributesList.isEmpty())) {

                                jsonWriter.key("NonKeyAttributes");
                                jsonWriter.array();

                                for (String nonKeyAttributesListValue : nonKeyAttributesList) {
                                    if (nonKeyAttributesListValue != null) {
                                        jsonWriter.value(nonKeyAttributesListValue);
                                    }
                                }
                                jsonWriter.endArray();
                            }
                            jsonWriter.endObject();
                        }
                        ProvisionedThroughput provisionedThroughput = globalSecondaryIndexesListValue.getProvisionedThroughput();
                        if (provisionedThroughput != null) {

                            jsonWriter.key("ProvisionedThroughput");
                            jsonWriter.object();

                            if (provisionedThroughput.getReadCapacityUnits() != null) {
                                jsonWriter.key("ReadCapacityUnits").value(provisionedThroughput.getReadCapacityUnits());
                            }
                            if (provisionedThroughput.getWriteCapacityUnits() != null) {
                                jsonWriter.key("WriteCapacityUnits").value(provisionedThroughput.getWriteCapacityUnits());
                            }
                            jsonWriter.endObject();
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }
            ProvisionedThroughput provisionedThroughput = createTableRequest.getProvisionedThroughput();
            if (provisionedThroughput != null) {

                jsonWriter.key("ProvisionedThroughput");
                jsonWriter.object();

                if (provisionedThroughput.getReadCapacityUnits() != null) {
                    jsonWriter.key("ReadCapacityUnits").value(provisionedThroughput.getReadCapacityUnits());
                }
                if (provisionedThroughput.getWriteCapacityUnits() != null) {
                    jsonWriter.key("WriteCapacityUnits").value(provisionedThroughput.getWriteCapacityUnits());
                }
                jsonWriter.endObject();
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
