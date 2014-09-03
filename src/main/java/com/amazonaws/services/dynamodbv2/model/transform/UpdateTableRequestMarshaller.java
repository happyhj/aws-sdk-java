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
import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexUpdate;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalSecondaryIndexAction;
import com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.utility.StringInputStream;

/**
 * Update Table Request Marshaller
 */
public class UpdateTableRequestMarshaller implements Marshaller<Request<UpdateTableRequest>, UpdateTableRequest> {

    public Request<UpdateTableRequest> marshall(UpdateTableRequest updateTableRequest) {
        if (updateTableRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateTableRequest> request = new DefaultRequest<UpdateTableRequest>(updateTableRequest, "AmazonDynamoDBv2");
        String target = "DynamoDB_20120810.UpdateTable";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (updateTableRequest.getTableName() != null) {
                jsonWriter.key("TableName").value(updateTableRequest.getTableName());
            }
            ProvisionedThroughput provisionedThroughput = updateTableRequest.getProvisionedThroughput();
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

            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<GlobalSecondaryIndexUpdate> globalSecondaryIndexUpdatesList = (com.amazonaws.serviceinternal.ListWithAutoConstructFlag<GlobalSecondaryIndexUpdate>)(updateTableRequest.getGlobalSecondaryIndexUpdates());
            if (globalSecondaryIndexUpdatesList != null && !(globalSecondaryIndexUpdatesList.isAutoConstruct() && globalSecondaryIndexUpdatesList.isEmpty())) {

                jsonWriter.key("GlobalSecondaryIndexUpdates");
                jsonWriter.array();

                for (GlobalSecondaryIndexUpdate globalSecondaryIndexUpdatesListValue : globalSecondaryIndexUpdatesList) {
                    if (globalSecondaryIndexUpdatesListValue != null) {
                        jsonWriter.object();
                        UpdateGlobalSecondaryIndexAction update = globalSecondaryIndexUpdatesListValue.getUpdate();
                        if (update != null) {

                            jsonWriter.key("Update");
                            jsonWriter.object();

                            if (update.getIndexName() != null) {
                                jsonWriter.key("IndexName").value(update.getIndexName());
                            }
                            ProvisionedThroughput provisionedThroughput2 = update.getProvisionedThroughput();
                            if (provisionedThroughput2 != null) {

                                jsonWriter.key("ProvisionedThroughput");
                                jsonWriter.object();

                                if (provisionedThroughput2.getReadCapacityUnits() != null) {
                                    jsonWriter.key("ReadCapacityUnits").value(provisionedThroughput2.getReadCapacityUnits());
                                }
                                if (provisionedThroughput2.getWriteCapacityUnits() != null) {
                                    jsonWriter.key("WriteCapacityUnits").value(provisionedThroughput2.getWriteCapacityUnits());
                                }
                                jsonWriter.endObject();
                            }
                            jsonWriter.endObject();
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
          request.addHeader("Content-Type", "application/x-amz-json-1.0");
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
