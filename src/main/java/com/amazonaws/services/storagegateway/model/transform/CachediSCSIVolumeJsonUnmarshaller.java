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

import com.amazonaws.services.storagegateway.model.CachediSCSIVolume;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Cachedi S C S I Volume JSON Unmarshaller
 */
public class CachediSCSIVolumeJsonUnmarshaller implements Unmarshaller<CachediSCSIVolume, JsonUnmarshallerContext> {

    public CachediSCSIVolume unmarshall(JsonUnmarshallerContext context) throws Exception {
        CachediSCSIVolume cachediSCSIVolume = new CachediSCSIVolume();

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
                    cachediSCSIVolume.setVolumeARN(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("VolumeId", targetDepth)) {
                    context.nextToken();
                    cachediSCSIVolume.setVolumeId(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("VolumeType", targetDepth)) {
                    context.nextToken();
                    cachediSCSIVolume.setVolumeType(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("VolumeStatus", targetDepth)) {
                    context.nextToken();
                    cachediSCSIVolume.setVolumeStatus(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("VolumeSizeInBytes", targetDepth)) {
                    context.nextToken();
                    cachediSCSIVolume.setVolumeSizeInBytes(LongJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("VolumeProgress", targetDepth)) {
                    context.nextToken();
                    cachediSCSIVolume.setVolumeProgress(DoubleJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("SourceSnapshotId", targetDepth)) {
                    context.nextToken();
                    cachediSCSIVolume.setSourceSnapshotId(StringJsonUnmarshaller.getInstance().unmarshall(context));
                }
                if (context.testExpression("VolumeiSCSIAttributes", targetDepth)) {
                    context.nextToken();
                    cachediSCSIVolume.setVolumeiSCSIAttributes(VolumeiSCSIAttributesJsonUnmarshaller.getInstance().unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth) break;
                }
            }

            token = context.nextToken();
        }
        
        return cachediSCSIVolume;
    }

    private static CachediSCSIVolumeJsonUnmarshaller instance;
    public static CachediSCSIVolumeJsonUnmarshaller getInstance() {
        if (instance == null) instance = new CachediSCSIVolumeJsonUnmarshaller();
        return instance;
    }
}
    