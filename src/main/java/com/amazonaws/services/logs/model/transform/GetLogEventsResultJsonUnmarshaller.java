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

package com.amazonaws.services.logs.model.transform;

import static com.fasterxml.jackson.core.JsonToken.END_ARRAY;
import static com.fasterxml.jackson.core.JsonToken.END_OBJECT;
import static com.fasterxml.jackson.core.JsonToken.FIELD_NAME;
import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;
import static com.fasterxml.jackson.core.JsonToken.VALUE_NULL;

import com.amazonaws.services.logs.model.GetLogEventsResult;
import com.amazonaws.services.logs.model.OutputLogEvent;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Get Log Events Result JSON Unmarshaller
 */
public class GetLogEventsResultJsonUnmarshaller implements Unmarshaller<GetLogEventsResult, JsonUnmarshallerContext> {

    public GetLogEventsResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        GetLogEventsResult getLogEventsResult = new GetLogEventsResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null) token = context.nextToken();
        if (token == VALUE_NULL) return null;

        while (true) {
            if (token == null) break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("events", targetDepth)) {
                    context.nextToken();
                    getLogEventsResult.setEvents(new ListUnmarshaller<OutputLogEvent>(OutputLogEventJsonUnmarshaller.getInstance()).unmarshall(context));
                }
                if (context.testExpression("nextForwardToken", targetDepth)) {
                    context.nextToken();
                    getLogEventsResult.setNextForwardToken(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("nextBackwardToken", targetDepth)) {
                    context.nextToken();
                    getLogEventsResult.setNextBackwardToken(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth) break;
                }
            }

            token = context.nextToken();
        }
        
        return getLogEventsResult;
    }

    private static GetLogEventsResultJsonUnmarshaller instance;
    public static GetLogEventsResultJsonUnmarshaller getInstance() {
        if (instance == null) instance = new GetLogEventsResultJsonUnmarshaller();
        return instance;
    }
}
    