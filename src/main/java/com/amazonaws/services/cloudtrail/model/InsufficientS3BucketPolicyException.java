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
package com.amazonaws.services.cloudtrail.model;

import com.amazonaws.exception.AmazonServiceException;

/**
 * <p>
 * This exception is thrown when the policy on the S3 bucket is not
 * sufficient.
 * </p>
 */        
public class InsufficientS3BucketPolicyException extends AmazonServiceException {
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs a new InsufficientS3BucketPolicyException with the specified error
     * message.
     * 
     * @param message Describes the error encountered.
     */
    public InsufficientS3BucketPolicyException(String message) {
        super(message);
    }
    
}
    