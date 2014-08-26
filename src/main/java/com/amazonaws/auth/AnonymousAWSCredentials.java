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
package com.amazonaws.auth;

import com.amazonaws.credential.AWSCredentials;


/**
 * Basic implementation of the AWSCredentials interface that allows use of "anonymous"
 * credentials.  Using anonymous credentials will result in requests not being signed
 * before sending to the service.  Any service that does not accept unsigned requests
 * will return a service exception in this case.
 */
public class AnonymousAWSCredentials implements AWSCredentials {

    /* (non-Javadoc)
     * @see com.amazonaws.auth.AWSCredentials#getAWSAccessKeyId()
     */
    public String getAWSAccessKeyId() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.amazonaws.auth.AWSCredentials#getAWSSecretKey()
     */
    public String getAWSSecretKey() {
        return null;
    }
}
