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
package com.amazonaws.services.redshift.model;

import com.amazonaws.exception.AmazonServiceException;

/**
 * <p>
 * The cluster parameter group action can not be completed because
 * another task is in progress that involves the parameter group. Wait a
 * few moments and try the operation again.
 * </p>
 */        
public class InvalidClusterParameterGroupStateException extends AmazonServiceException {
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs a new InvalidClusterParameterGroupStateException with the specified error
     * message.
     * 
     * @param message Describes the error encountered.
     */
    public InvalidClusterParameterGroupStateException(String message) {
        super(message);
    }
    
}
    