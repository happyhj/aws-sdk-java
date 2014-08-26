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

import com.amazonaws.exception.AmazonServiceException;
import com.amazonaws.json.JSONObject;
import com.amazonaws.services.dynamodbv2.model.InternalServerErrorException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InternalServerErrorExceptionUnmarshaller extends JsonErrorUnmarshaller {

    public InternalServerErrorExceptionUnmarshaller() {
        super(InternalServerErrorException.class);
    }

    @Override
    public boolean match(String errorTypeFromHeader, JSONObject json) throws Exception {
        if (errorTypeFromHeader == null) {
            // Parse error type from the JSON content if it's not available in the response headers
            String errorCodeFromContent = parseErrorCode(json);
            return (errorCodeFromContent != null && errorCodeFromContent.equals("InternalServerError"));
        } else {
            return errorTypeFromHeader.equals("InternalServerError");
        }
    }

    @Override
    public AmazonServiceException unmarshall(JSONObject json) throws Exception {
        InternalServerErrorException e = (InternalServerErrorException)super.unmarshall(json);
        e.setErrorCode("InternalServerError");

        return e;
    }
}
    