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

import com.amazonaws.services.dynamodb.model.Key;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Key JSON Unmarshaller
 * @deprecated {@link Key} is no longer supported in the latest service API.
 */
@Deprecated
public class KeyJsonUnmarshaller implements Unmarshaller<Key, JsonUnmarshallerContext> {



    public Key unmarshall(JsonUnmarshallerContext context) throws Exception {
        Key key = new Key();



        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null) token = context.nextToken();

        while (true) {
            if (token == null) break;


            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("HashKeyElement", targetDepth)) {
                    context.nextToken();
                    key.setHashKeyElement(AttributeValueJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("RangeKeyElement", targetDepth)) {
                    context.nextToken();
                    key.setRangeKeyElement(AttributeValueJsonUnmarshaller.getInstance().unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getCurrentDepth() <= originalDepth) break;
            }


            token = context.nextToken();
        }

        return key;
    }

    private static KeyJsonUnmarshaller instance;
    public static KeyJsonUnmarshaller getInstance() {
        if (instance == null) instance = new KeyJsonUnmarshaller();
        return instance;
    }
}
