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
import com.amazonaws.services.dynamodb.model.KeysAndAttributes;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Keys And Attributes JSON Unmarshaller
 * @deprecated Use {@link com.amazonaws.services.dynamodbv2.model.transform.KeysAndAttributesJsonUnmarshaller} instead.
 */
@Deprecated
public class KeysAndAttributesJsonUnmarshaller implements Unmarshaller<KeysAndAttributes, JsonUnmarshallerContext> {



    public KeysAndAttributes unmarshall(JsonUnmarshallerContext context) throws Exception {
        KeysAndAttributes keysAndAttributes = new KeysAndAttributes();



        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null) token = context.nextToken();

        while (true) {
            if (token == null) break;


            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("Keys", targetDepth)) {
                    keysAndAttributes.setKeys(new ListUnmarshaller<Key>(KeyJsonUnmarshaller.getInstance()).unmarshall(context));
                }
                if (context.testExpression("AttributesToGet", targetDepth)) {
                    keysAndAttributes.setAttributesToGet(new ListUnmarshaller<String>(StringJsonUnmarshaller.getInstance()).unmarshall(context));
                }
                if (context.testExpression("ConsistentRead", targetDepth)) {
                    context.nextToken();
                    keysAndAttributes.setConsistentRead(BooleanJsonUnmarshaller.getInstance().unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getCurrentDepth() <= originalDepth) break;
            }


            token = context.nextToken();
        }

        return keysAndAttributes;
    }

    private static KeysAndAttributesJsonUnmarshaller instance;
    public static KeysAndAttributesJsonUnmarshaller getInstance() {
        if (instance == null) instance = new KeysAndAttributesJsonUnmarshaller();
        return instance;
    }
}
