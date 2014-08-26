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
import com.amazonaws.services.dynamodb.model.PutRequest;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Put Request JSON Unmarshaller
 * @deprecated Use {@link com.amazonaws.services.dynamodbv2.model.transform.PutRequestJsonUnmarshaller} instead.
 */
@Deprecated
public class PutRequestJsonUnmarshaller implements Unmarshaller<PutRequest, JsonUnmarshallerContext> {



    public PutRequest unmarshall(JsonUnmarshallerContext context) throws Exception {
        PutRequest putRequest = new PutRequest();



        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null) token = context.nextToken();

        while (true) {
            if (token == null) break;


            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("Item", targetDepth)) {
                    putRequest.setItem(new MapUnmarshaller<String,AttributeValue>(StringJsonUnmarshaller.getInstance(), AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getCurrentDepth() <= originalDepth) break;
            }


            token = context.nextToken();
        }

        return putRequest;
    }

    private static PutRequestJsonUnmarshaller instance;
    public static PutRequestJsonUnmarshaller getInstance() {
        if (instance == null) instance = new PutRequestJsonUnmarshaller();
        return instance;
    }
}
