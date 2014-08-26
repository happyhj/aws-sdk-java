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

import static com.fasterxml.jackson.core.JsonToken.END_ARRAY;
import static com.fasterxml.jackson.core.JsonToken.END_OBJECT;
import static com.fasterxml.jackson.core.JsonToken.FIELD_NAME;
import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;

import com.amazonaws.services.dynamodb.model.AttributeValue;
import com.amazonaws.services.dynamodb.model.QueryResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Query Result JSON Unmarshaller
 * @deprecated Use {@link com.amazonaws.services.dynamodbv2.model.transform.QueryResultJsonUnmarshaller} instead.
 */
@Deprecated
public class QueryResultJsonUnmarshaller implements Unmarshaller<QueryResult, JsonUnmarshallerContext> {



    public QueryResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        QueryResult queryResult = new QueryResult();



        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null) token = context.nextToken();

        while (true) {
            if (token == null) break;


            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("Items", targetDepth)) {
                    queryResult.setItems(new ListUnmarshaller<java.util.Map<String,AttributeValue>>(new MapUnmarshaller<String,AttributeValue>(StringJsonUnmarshaller.getInstance(), AttributeValueJsonUnmarshaller.getInstance())).unmarshall(context));
                }
                if (context.testExpression("Count", targetDepth)) {
                    context.nextToken();
                    queryResult.setCount(IntegerJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("LastEvaluatedKey", targetDepth)) {
                    context.nextToken();
                    queryResult.setLastEvaluatedKey(KeyJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("ConsumedCapacityUnits", targetDepth)) {
                    context.nextToken();
                    queryResult.setConsumedCapacityUnits(DoubleJsonUnmarshaller.getInstance().unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getCurrentDepth() <= originalDepth) break;
            }


            token = context.nextToken();
        }

        return queryResult;
    }

    private static QueryResultJsonUnmarshaller instance;
    public static QueryResultJsonUnmarshaller getInstance() {
        if (instance == null) instance = new QueryResultJsonUnmarshaller();
        return instance;
    }
}
