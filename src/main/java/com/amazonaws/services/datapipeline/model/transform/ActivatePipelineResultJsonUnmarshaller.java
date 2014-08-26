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

package com.amazonaws.services.datapipeline.model.transform;

import com.amazonaws.services.datapipeline.model.ActivatePipelineResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * Activate Pipeline Result JSON Unmarshaller
 */
public class ActivatePipelineResultJsonUnmarshaller implements Unmarshaller<ActivatePipelineResult, JsonUnmarshallerContext> {

    public ActivatePipelineResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        ActivatePipelineResult activatePipelineResult = new ActivatePipelineResult();

        return activatePipelineResult;
    }

    private static ActivatePipelineResultJsonUnmarshaller instance;
    public static ActivatePipelineResultJsonUnmarshaller getInstance() {
        if (instance == null) instance = new ActivatePipelineResultJsonUnmarshaller();
        return instance;
    }
}
    