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

package com.amazonaws.services.simpleworkflow.model.transform;

import static com.fasterxml.jackson.core.JsonToken.END_ARRAY;
import static com.fasterxml.jackson.core.JsonToken.END_OBJECT;
import static com.fasterxml.jackson.core.JsonToken.FIELD_NAME;
import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;
import static com.fasterxml.jackson.core.JsonToken.VALUE_NULL;

import com.amazonaws.services.simpleworkflow.model.WorkflowTypeInfo;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Workflow Type Info JSON Unmarshaller
 */
public class WorkflowTypeInfoJsonUnmarshaller implements Unmarshaller<WorkflowTypeInfo, JsonUnmarshallerContext> {

    public WorkflowTypeInfo unmarshall(JsonUnmarshallerContext context) throws Exception {
        WorkflowTypeInfo workflowTypeInfo = new WorkflowTypeInfo();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null) token = context.nextToken();
        if (token == VALUE_NULL) return null;

        while (true) {
            if (token == null) break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("workflowType", targetDepth)) {
                    context.nextToken();
                    workflowTypeInfo.setWorkflowType(WorkflowTypeJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("status", targetDepth)) {
                    context.nextToken();
                    workflowTypeInfo.setStatus(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("description", targetDepth)) {
                    context.nextToken();
                    workflowTypeInfo.setDescription(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("creationDate", targetDepth)) {
                    context.nextToken();
                    workflowTypeInfo.setCreationDate(DateJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("deprecationDate", targetDepth)) {
                    context.nextToken();
                    workflowTypeInfo.setDeprecationDate(DateJsonUnmarshaller.getInstance().unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth) break;
                }
            }

            token = context.nextToken();
        }
        
        return workflowTypeInfo;
    }

    private static WorkflowTypeInfoJsonUnmarshaller instance;
    public static WorkflowTypeInfoJsonUnmarshaller getInstance() {
        if (instance == null) instance = new WorkflowTypeInfoJsonUnmarshaller();
        return instance;
    }
}
    