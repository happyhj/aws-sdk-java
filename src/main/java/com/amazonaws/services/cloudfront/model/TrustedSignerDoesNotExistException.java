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
package com.amazonaws.services.cloudfront.model;

import com.amazonaws.exception.AmazonServiceException;

/**
 * <p>
 * One or more of your trusted signers do not exist.
 * </p>
 */        
public class TrustedSignerDoesNotExistException extends AmazonServiceException {
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs a new TrustedSignerDoesNotExistException with the specified error
     * message.
     * 
     * @param message Describes the error encountered.
     */
    public TrustedSignerDoesNotExistException(String message) {
        super(message);
    }
    
}
    