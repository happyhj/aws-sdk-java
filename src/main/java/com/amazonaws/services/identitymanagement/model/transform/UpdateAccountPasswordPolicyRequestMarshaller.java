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
package com.amazonaws.services.identitymanagement.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.exception.AmazonClientException;
import com.amazonaws.network.request.DefaultRequest;
import com.amazonaws.network.type.Request;
import com.amazonaws.serviceinternal.ListWithAutoConstructFlag;
import com.amazonaws.services.identitymanagement.model.*;
import com.amazonaws.stringutil.StringUtils;
import com.amazonaws.transform.Marshaller;

/**
 * Update Account Password Policy Request Marshaller
 */
public class UpdateAccountPasswordPolicyRequestMarshaller implements Marshaller<Request<UpdateAccountPasswordPolicyRequest>, UpdateAccountPasswordPolicyRequest> {

    public Request<UpdateAccountPasswordPolicyRequest> marshall(UpdateAccountPasswordPolicyRequest updateAccountPasswordPolicyRequest) {

        if (updateAccountPasswordPolicyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateAccountPasswordPolicyRequest> request = new DefaultRequest<UpdateAccountPasswordPolicyRequest>(updateAccountPasswordPolicyRequest, "AmazonIdentityManagement");
        request.addParameter("Action", "UpdateAccountPasswordPolicy");
        request.addParameter("Version", "2010-05-08");

        if (updateAccountPasswordPolicyRequest.getMinimumPasswordLength() != null) {
            request.addParameter("MinimumPasswordLength", StringUtils.fromInteger(updateAccountPasswordPolicyRequest.getMinimumPasswordLength()));
        }
        if (updateAccountPasswordPolicyRequest.isRequireSymbols() != null) {
            request.addParameter("RequireSymbols", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.isRequireSymbols()));
        }
        if (updateAccountPasswordPolicyRequest.isRequireNumbers() != null) {
            request.addParameter("RequireNumbers", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.isRequireNumbers()));
        }
        if (updateAccountPasswordPolicyRequest.isRequireUppercaseCharacters() != null) {
            request.addParameter("RequireUppercaseCharacters", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.isRequireUppercaseCharacters()));
        }
        if (updateAccountPasswordPolicyRequest.isRequireLowercaseCharacters() != null) {
            request.addParameter("RequireLowercaseCharacters", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.isRequireLowercaseCharacters()));
        }
        if (updateAccountPasswordPolicyRequest.isAllowUsersToChangePassword() != null) {
            request.addParameter("AllowUsersToChangePassword", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.isAllowUsersToChangePassword()));
        }
        if (updateAccountPasswordPolicyRequest.getMaxPasswordAge() != null) {
            request.addParameter("MaxPasswordAge", StringUtils.fromInteger(updateAccountPasswordPolicyRequest.getMaxPasswordAge()));
        }
        if (updateAccountPasswordPolicyRequest.getPasswordReusePrevention() != null) {
            request.addParameter("PasswordReusePrevention", StringUtils.fromInteger(updateAccountPasswordPolicyRequest.getPasswordReusePrevention()));
        }
        if (updateAccountPasswordPolicyRequest.isHardExpiry() != null) {
            request.addParameter("HardExpiry", StringUtils.fromBoolean(updateAccountPasswordPolicyRequest.isHardExpiry()));
        }

        return request;
    }
}
