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
package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

import com.amazonaws.network.request.AmazonWebServiceRequest;

/**
 * Container for the parameters to the {@link com.amazonaws.services.securitytoken.AWSSecurityTokenService#getFederationToken(GetFederationTokenRequest) GetFederationToken operation}.
 * <p>
 * Returns a set of temporary security credentials (consisting of an
 * access key ID, a secret access key, and a security token) for a
 * federated user. A typical use is in a proxy application that gets
 * temporary security credentials on behalf of distributed applications
 * inside a corporate network. Because you must call the
 * <code>GetFederationToken</code> action using the long-term security
 * credentials of an IAM user, this call is appropriate in contexts where
 * those credentials can be safely stored, usually in a server-based
 * application.
 * </p>
 * <p>
 * <b>Note:</b> Do not use this call in mobile applications or
 * client-based web applications that directly get temporary security
 * credentials. For those types of applications, use
 * <code>AssumeRoleWithWebIdentity</code> .
 * </p>
 * <p>
 * The <code>GetFederationToken</code> action must be called by using the
 * long-term AWS security credentials of an IAM user. You can also call
 * <code>GetFederationToken</code> using the security credentials of an
 * AWS account (root), but this is not recommended. Instead, we recommend
 * that you create an IAM user for the purpose of the proxy application
 * and then attach a policy to the IAM user that limits federated users
 * to only the actions and resources they need access to. For more
 * information, see
 * <a href="http://docs.aws.amazon.com/IAM/latest/UserGuide/IAMBestPractices.html"> IAM Best Practices </a>
 * in <i>Using IAM</i> .
 * </p>
 * <p>
 * The temporary security credentials that are obtained by using the
 * long-term credentials of an IAM user are valid for the specified
 * duration, between 900 seconds (15 minutes) and 129600 seconds (36
 * hours). Temporary credentials that are obtained by using AWS account
 * (root) credentials have a maximum duration of 3600 seconds (1 hour)
 * </p>
 * <p>
 * <b>Permissions</b>
 * </p>
 * <p>
 * The permissions for the temporary security credentials returned by
 * <code>GetFederationToken</code> are determined by a combination of the
 * following:
 * </p>
 * 
 * <ul>
 * <li>The policy or policies that are attached to the IAM user whose
 * credentials are used to call <code>GetFederationToken</code> .</li>
 * <li>The policy that is passed as a parameter in the call.</li>
 * 
 * </ul>
 * <p>
 * The passed policy is attached to the temporary security credentials
 * that result from the <code>GetFederationToken</code> API call--that
 * is, to the <i>federated user</i> . When the federated user makes an
 * AWS request, AWS evaluates the policy attached to the federated user
 * in combination with the policy or policies attached to the IAM user
 * whose credentials were used to call <code>GetFederationToken</code> .
 * AWS allows the federated user's request only when both the federated
 * user <i> and </i> the IAM user are explicitly allowed to perform the
 * requested action. The passed policy cannot grant more permissions than
 * those that are defined in the IAM user policy.
 * </p>
 * <p>
 * A typical use case is that the permissions of the IAM user whose
 * credentials are used to call <code>GetFederationToken</code> are
 * designed to allow access to all the actions and resources that any
 * federated user will need. Then, for individual users, you pass a
 * policy to the operation that scopes down the permissions to a level
 * that's appropriate to that individual user, using a policy that allows
 * only a subset of permissions that are granted to the IAM user.
 * </p>
 * <p>
 * If you do not pass a policy, the resulting temporary security
 * credentials have no effective permissions. The only exception is when
 * the temporary security credentials are used to access a resource that
 * has a resource-based policy that specifically allows the federated
 * user to access the resource.
 * </p>
 * <p>
 * For more information about how permissions work, see
 * <a href="http://docs.aws.amazon.com/STS/latest/UsingSTS/permissions-get-federation-token.html"> Permissions for GetFederationToken </a> in <i>Using Temporary Security Credentials</i> . For information about using <code>GetFederationToken</code> to create temporary security credentials, see <a href="http://docs.aws.amazon.com/STS/latest/UsingSTS/CreatingFedTokens.html"> Creating Temporary Credentials to Enable Access for Federated Users </a>
 * in <i>Using Temporary Security Credentials</i> .
 * </p>
 *
 * @see com.amazonaws.services.securitytoken.AWSSecurityTokenService#getFederationToken(GetFederationTokenRequest)
 */
public class GetFederationTokenRequest extends AmazonWebServiceRequest implements Serializable {

    /**
     * The name of the federated user. The name is used as an identifier for
     * the temporary security credentials (such as <code>Bob</code>). For
     * example, you can reference the federated user name in a resource-based
     * policy, such as in an Amazon S3 bucket policy.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>2 - 32<br/>
     * <b>Pattern: </b>[\w+=,.@-]*<br/>
     */
    private String name;

    /**
     * An IAM policy in JSON format that is passed with the
     * <code>GetFederationToken</code> call and evaluated along with the
     * policy or policies that are attached to the IAM user whose credentials
     * are used to call <code>GetFederationToken</code>. The passed policy is
     * used to scope down the permissions that are available to the IAM user,
     * by allowing only a subset of the permissions that are granted to the
     * IAM user. The passed policy cannot grant more permissions than those
     * granted to the IAM user. The final permissions for the federated user
     * are the most restrictive set based on the intersection of the passed
     * policy and the IAM user policy. <p>If you do not pass a policy, the
     * resulting temporary security credentials have no effective
     * permissions. The only exception is when the temporary security
     * credentials are used to access a resource that has a resource-based
     * policy that specifically allows the federated user to access the
     * resource. <p>For more information about how permissions work, see <a
     * href="http://docs.aws.amazon.com/STS/latest/UsingSTS/permissions-get-federation-token.html">Permissions
     * for GetFederationToken</a> in <i>Using Temporary Security
     * Credentials</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2048<br/>
     * <b>Pattern: </b>[&#92;u0009&#92;u000A&#92;u000D&#92;u0020-&#92;u00FF]+<br/>
     */
    private String policy;

    /**
     * The duration, in seconds, that the session should last. Acceptable
     * durations for federation sessions range from 900 seconds (15 minutes)
     * to 129600 seconds (36 hours), with 43200 seconds (12 hours) as the
     * default. Sessions obtained using AWS account (root) credentials are
     * restricted to a maximum of 3600 seconds (one hour). If the specified
     * duration is longer than one hour, the session obtained by using AWS
     * account (root) credentials defaults to one hour.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>900 - 129600<br/>
     */
    private Integer durationSeconds;

    /**
     * Default constructor for a new GetFederationTokenRequest object.  Callers should use the
     * setter or fluent setter (with...) methods to initialize this object after creating it.
     */
    public GetFederationTokenRequest() {}
    
    /**
     * Constructs a new GetFederationTokenRequest object.
     * Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param name The name of the federated user. The name is used as an
     * identifier for the temporary security credentials (such as
     * <code>Bob</code>). For example, you can reference the federated user
     * name in a resource-based policy, such as in an Amazon S3 bucket
     * policy.
     */
    public GetFederationTokenRequest(String name) {
        setName(name);
    }

    /**
     * The name of the federated user. The name is used as an identifier for
     * the temporary security credentials (such as <code>Bob</code>). For
     * example, you can reference the federated user name in a resource-based
     * policy, such as in an Amazon S3 bucket policy.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>2 - 32<br/>
     * <b>Pattern: </b>[\w+=,.@-]*<br/>
     *
     * @return The name of the federated user. The name is used as an identifier for
     *         the temporary security credentials (such as <code>Bob</code>). For
     *         example, you can reference the federated user name in a resource-based
     *         policy, such as in an Amazon S3 bucket policy.
     */
    public String getName() {
        return name;
    }
    
    /**
     * The name of the federated user. The name is used as an identifier for
     * the temporary security credentials (such as <code>Bob</code>). For
     * example, you can reference the federated user name in a resource-based
     * policy, such as in an Amazon S3 bucket policy.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>2 - 32<br/>
     * <b>Pattern: </b>[\w+=,.@-]*<br/>
     *
     * @param name The name of the federated user. The name is used as an identifier for
     *         the temporary security credentials (such as <code>Bob</code>). For
     *         example, you can reference the federated user name in a resource-based
     *         policy, such as in an Amazon S3 bucket policy.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * The name of the federated user. The name is used as an identifier for
     * the temporary security credentials (such as <code>Bob</code>). For
     * example, you can reference the federated user name in a resource-based
     * policy, such as in an Amazon S3 bucket policy.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>2 - 32<br/>
     * <b>Pattern: </b>[\w+=,.@-]*<br/>
     *
     * @param name The name of the federated user. The name is used as an identifier for
     *         the temporary security credentials (such as <code>Bob</code>). For
     *         example, you can reference the federated user name in a resource-based
     *         policy, such as in an Amazon S3 bucket policy.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public GetFederationTokenRequest withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * An IAM policy in JSON format that is passed with the
     * <code>GetFederationToken</code> call and evaluated along with the
     * policy or policies that are attached to the IAM user whose credentials
     * are used to call <code>GetFederationToken</code>. The passed policy is
     * used to scope down the permissions that are available to the IAM user,
     * by allowing only a subset of the permissions that are granted to the
     * IAM user. The passed policy cannot grant more permissions than those
     * granted to the IAM user. The final permissions for the federated user
     * are the most restrictive set based on the intersection of the passed
     * policy and the IAM user policy. <p>If you do not pass a policy, the
     * resulting temporary security credentials have no effective
     * permissions. The only exception is when the temporary security
     * credentials are used to access a resource that has a resource-based
     * policy that specifically allows the federated user to access the
     * resource. <p>For more information about how permissions work, see <a
     * href="http://docs.aws.amazon.com/STS/latest/UsingSTS/permissions-get-federation-token.html">Permissions
     * for GetFederationToken</a> in <i>Using Temporary Security
     * Credentials</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2048<br/>
     * <b>Pattern: </b>[&#92;u0009&#92;u000A&#92;u000D&#92;u0020-&#92;u00FF]+<br/>
     *
     * @return An IAM policy in JSON format that is passed with the
     *         <code>GetFederationToken</code> call and evaluated along with the
     *         policy or policies that are attached to the IAM user whose credentials
     *         are used to call <code>GetFederationToken</code>. The passed policy is
     *         used to scope down the permissions that are available to the IAM user,
     *         by allowing only a subset of the permissions that are granted to the
     *         IAM user. The passed policy cannot grant more permissions than those
     *         granted to the IAM user. The final permissions for the federated user
     *         are the most restrictive set based on the intersection of the passed
     *         policy and the IAM user policy. <p>If you do not pass a policy, the
     *         resulting temporary security credentials have no effective
     *         permissions. The only exception is when the temporary security
     *         credentials are used to access a resource that has a resource-based
     *         policy that specifically allows the federated user to access the
     *         resource. <p>For more information about how permissions work, see <a
     *         href="http://docs.aws.amazon.com/STS/latest/UsingSTS/permissions-get-federation-token.html">Permissions
     *         for GetFederationToken</a> in <i>Using Temporary Security
     *         Credentials</i>.
     */
    public String getPolicy() {
        return policy;
    }
    
    /**
     * An IAM policy in JSON format that is passed with the
     * <code>GetFederationToken</code> call and evaluated along with the
     * policy or policies that are attached to the IAM user whose credentials
     * are used to call <code>GetFederationToken</code>. The passed policy is
     * used to scope down the permissions that are available to the IAM user,
     * by allowing only a subset of the permissions that are granted to the
     * IAM user. The passed policy cannot grant more permissions than those
     * granted to the IAM user. The final permissions for the federated user
     * are the most restrictive set based on the intersection of the passed
     * policy and the IAM user policy. <p>If you do not pass a policy, the
     * resulting temporary security credentials have no effective
     * permissions. The only exception is when the temporary security
     * credentials are used to access a resource that has a resource-based
     * policy that specifically allows the federated user to access the
     * resource. <p>For more information about how permissions work, see <a
     * href="http://docs.aws.amazon.com/STS/latest/UsingSTS/permissions-get-federation-token.html">Permissions
     * for GetFederationToken</a> in <i>Using Temporary Security
     * Credentials</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2048<br/>
     * <b>Pattern: </b>[&#92;u0009&#92;u000A&#92;u000D&#92;u0020-&#92;u00FF]+<br/>
     *
     * @param policy An IAM policy in JSON format that is passed with the
     *         <code>GetFederationToken</code> call and evaluated along with the
     *         policy or policies that are attached to the IAM user whose credentials
     *         are used to call <code>GetFederationToken</code>. The passed policy is
     *         used to scope down the permissions that are available to the IAM user,
     *         by allowing only a subset of the permissions that are granted to the
     *         IAM user. The passed policy cannot grant more permissions than those
     *         granted to the IAM user. The final permissions for the federated user
     *         are the most restrictive set based on the intersection of the passed
     *         policy and the IAM user policy. <p>If you do not pass a policy, the
     *         resulting temporary security credentials have no effective
     *         permissions. The only exception is when the temporary security
     *         credentials are used to access a resource that has a resource-based
     *         policy that specifically allows the federated user to access the
     *         resource. <p>For more information about how permissions work, see <a
     *         href="http://docs.aws.amazon.com/STS/latest/UsingSTS/permissions-get-federation-token.html">Permissions
     *         for GetFederationToken</a> in <i>Using Temporary Security
     *         Credentials</i>.
     */
    public void setPolicy(String policy) {
        this.policy = policy;
    }
    
    /**
     * An IAM policy in JSON format that is passed with the
     * <code>GetFederationToken</code> call and evaluated along with the
     * policy or policies that are attached to the IAM user whose credentials
     * are used to call <code>GetFederationToken</code>. The passed policy is
     * used to scope down the permissions that are available to the IAM user,
     * by allowing only a subset of the permissions that are granted to the
     * IAM user. The passed policy cannot grant more permissions than those
     * granted to the IAM user. The final permissions for the federated user
     * are the most restrictive set based on the intersection of the passed
     * policy and the IAM user policy. <p>If you do not pass a policy, the
     * resulting temporary security credentials have no effective
     * permissions. The only exception is when the temporary security
     * credentials are used to access a resource that has a resource-based
     * policy that specifically allows the federated user to access the
     * resource. <p>For more information about how permissions work, see <a
     * href="http://docs.aws.amazon.com/STS/latest/UsingSTS/permissions-get-federation-token.html">Permissions
     * for GetFederationToken</a> in <i>Using Temporary Security
     * Credentials</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2048<br/>
     * <b>Pattern: </b>[&#92;u0009&#92;u000A&#92;u000D&#92;u0020-&#92;u00FF]+<br/>
     *
     * @param policy An IAM policy in JSON format that is passed with the
     *         <code>GetFederationToken</code> call and evaluated along with the
     *         policy or policies that are attached to the IAM user whose credentials
     *         are used to call <code>GetFederationToken</code>. The passed policy is
     *         used to scope down the permissions that are available to the IAM user,
     *         by allowing only a subset of the permissions that are granted to the
     *         IAM user. The passed policy cannot grant more permissions than those
     *         granted to the IAM user. The final permissions for the federated user
     *         are the most restrictive set based on the intersection of the passed
     *         policy and the IAM user policy. <p>If you do not pass a policy, the
     *         resulting temporary security credentials have no effective
     *         permissions. The only exception is when the temporary security
     *         credentials are used to access a resource that has a resource-based
     *         policy that specifically allows the federated user to access the
     *         resource. <p>For more information about how permissions work, see <a
     *         href="http://docs.aws.amazon.com/STS/latest/UsingSTS/permissions-get-federation-token.html">Permissions
     *         for GetFederationToken</a> in <i>Using Temporary Security
     *         Credentials</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public GetFederationTokenRequest withPolicy(String policy) {
        this.policy = policy;
        return this;
    }

    /**
     * The duration, in seconds, that the session should last. Acceptable
     * durations for federation sessions range from 900 seconds (15 minutes)
     * to 129600 seconds (36 hours), with 43200 seconds (12 hours) as the
     * default. Sessions obtained using AWS account (root) credentials are
     * restricted to a maximum of 3600 seconds (one hour). If the specified
     * duration is longer than one hour, the session obtained by using AWS
     * account (root) credentials defaults to one hour.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>900 - 129600<br/>
     *
     * @return The duration, in seconds, that the session should last. Acceptable
     *         durations for federation sessions range from 900 seconds (15 minutes)
     *         to 129600 seconds (36 hours), with 43200 seconds (12 hours) as the
     *         default. Sessions obtained using AWS account (root) credentials are
     *         restricted to a maximum of 3600 seconds (one hour). If the specified
     *         duration is longer than one hour, the session obtained by using AWS
     *         account (root) credentials defaults to one hour.
     */
    public Integer getDurationSeconds() {
        return durationSeconds;
    }
    
    /**
     * The duration, in seconds, that the session should last. Acceptable
     * durations for federation sessions range from 900 seconds (15 minutes)
     * to 129600 seconds (36 hours), with 43200 seconds (12 hours) as the
     * default. Sessions obtained using AWS account (root) credentials are
     * restricted to a maximum of 3600 seconds (one hour). If the specified
     * duration is longer than one hour, the session obtained by using AWS
     * account (root) credentials defaults to one hour.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>900 - 129600<br/>
     *
     * @param durationSeconds The duration, in seconds, that the session should last. Acceptable
     *         durations for federation sessions range from 900 seconds (15 minutes)
     *         to 129600 seconds (36 hours), with 43200 seconds (12 hours) as the
     *         default. Sessions obtained using AWS account (root) credentials are
     *         restricted to a maximum of 3600 seconds (one hour). If the specified
     *         duration is longer than one hour, the session obtained by using AWS
     *         account (root) credentials defaults to one hour.
     */
    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }
    
    /**
     * The duration, in seconds, that the session should last. Acceptable
     * durations for federation sessions range from 900 seconds (15 minutes)
     * to 129600 seconds (36 hours), with 43200 seconds (12 hours) as the
     * default. Sessions obtained using AWS account (root) credentials are
     * restricted to a maximum of 3600 seconds (one hour). If the specified
     * duration is longer than one hour, the session obtained by using AWS
     * account (root) credentials defaults to one hour.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>900 - 129600<br/>
     *
     * @param durationSeconds The duration, in seconds, that the session should last. Acceptable
     *         durations for federation sessions range from 900 seconds (15 minutes)
     *         to 129600 seconds (36 hours), with 43200 seconds (12 hours) as the
     *         default. Sessions obtained using AWS account (root) credentials are
     *         restricted to a maximum of 3600 seconds (one hour). If the specified
     *         duration is longer than one hour, the session obtained by using AWS
     *         account (root) credentials defaults to one hour.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public GetFederationTokenRequest withDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getName() != null) sb.append("Name: " + getName() + ",");
        if (getPolicy() != null) sb.append("Policy: " + getPolicy() + ",");
        if (getDurationSeconds() != null) sb.append("DurationSeconds: " + getDurationSeconds() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getName() == null) ? 0 : getName().hashCode()); 
        hashCode = prime * hashCode + ((getPolicy() == null) ? 0 : getPolicy().hashCode()); 
        hashCode = prime * hashCode + ((getDurationSeconds() == null) ? 0 : getDurationSeconds().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof GetFederationTokenRequest == false) return false;
        GetFederationTokenRequest other = (GetFederationTokenRequest)obj;
        
        if (other.getName() == null ^ this.getName() == null) return false;
        if (other.getName() != null && other.getName().equals(this.getName()) == false) return false; 
        if (other.getPolicy() == null ^ this.getPolicy() == null) return false;
        if (other.getPolicy() != null && other.getPolicy().equals(this.getPolicy()) == false) return false; 
        if (other.getDurationSeconds() == null ^ this.getDurationSeconds() == null) return false;
        if (other.getDurationSeconds() != null && other.getDurationSeconds().equals(this.getDurationSeconds()) == false) return false; 
        return true;
    }
    
}
    