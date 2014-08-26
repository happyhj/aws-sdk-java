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

package com.amazonaws.services.storagegateway.model.transform;

import static com.fasterxml.jackson.core.JsonToken.END_ARRAY;
import static com.fasterxml.jackson.core.JsonToken.END_OBJECT;
import static com.fasterxml.jackson.core.JsonToken.FIELD_NAME;
import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;
import static com.fasterxml.jackson.core.JsonToken.VALUE_NULL;

import com.amazonaws.services.storagegateway.model.VolumeRecoveryPointInfo;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Volume Recovery Point Info JSON Unmarshaller
 */
public class VolumeRecoveryPointInfoJsonUnmarshaller implements Unmarshaller<VolumeRecoveryPointInfo, JsonUnmarshallerContext> {

    public VolumeRecoveryPointInfo unmarshall(JsonUnmarshallerContext context) throws Exception {
        VolumeRecoveryPointInfo volumeRecoveryPointInfo = new VolumeRecoveryPointInfo();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null) token = context.nextToken();
        if (token == VALUE_NULL) return null;

        while (true) {
            if (token == null) break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("VolumeARN", targetDepth)) {
                    context.nextToken();
                    volumeRecoveryPointInfo.setVolumeARN(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("VolumeSizeInBytes", targetDepth)) {
                    context.nextToken();
                    volumeRecoveryPointInfo.setVolumeSizeInBytes(LongJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("VolumeUsageInBytes", targetDepth)) {
                    context.nextToken();
                    volumeRecoveryPointInfo.setVolumeUsageInBytes(LongJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("VolumeRecoveryPointTime", targetDepth)) {
                    context.nextToken();
                    volumeRecoveryPointInfo.setVolumeRecoveryPointTime(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth) break;
                }
            }

            token = context.nextToken();
        }
        
        return volumeRecoveryPointInfo;
    }

    private static VolumeRecoveryPointInfoJsonUnmarshaller instance;
    public static VolumeRecoveryPointInfoJsonUnmarshaller getInstance() {
        if (instance == null) instance = new VolumeRecoveryPointInfoJsonUnmarshaller();
        return instance;
    }
}
    