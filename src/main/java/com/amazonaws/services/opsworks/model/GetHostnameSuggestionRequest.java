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
package com.amazonaws.services.opsworks.model;

import java.io.Serializable;

import com.amazonaws.network.request.AmazonWebServiceRequest;

/**
 * Container for the parameters to the {@link com.amazonaws.services.opsworks.AWSOpsWorks#getHostnameSuggestion(GetHostnameSuggestionRequest) GetHostnameSuggestion operation}.
 * <p>
 * Gets a generated host name for the specified layer, based on the
 * current host name theme.
 * </p>
 * <p>
 * <b>Required Permissions</b> : To use this action, an IAM user must
 * have a Manage permissions level for the stack, or an attached policy
 * that explicitly grants permissions. For more information on user
 * permissions, see
 * <a href="http://docs.aws.amazon.com/opsworks/latest/userguide/opsworks-security-users.html"> Managing User Permissions </a>
 * .
 * </p>
 *
 * @see com.amazonaws.services.opsworks.AWSOpsWorks#getHostnameSuggestion(GetHostnameSuggestionRequest)
 */
public class GetHostnameSuggestionRequest extends AmazonWebServiceRequest implements Serializable {

    /**
     * The layer ID.
     */
    private String layerId;

    /**
     * The layer ID.
     *
     * @return The layer ID.
     */
    public String getLayerId() {
        return layerId;
    }
    
    /**
     * The layer ID.
     *
     * @param layerId The layer ID.
     */
    public void setLayerId(String layerId) {
        this.layerId = layerId;
    }
    
    /**
     * The layer ID.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param layerId The layer ID.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public GetHostnameSuggestionRequest withLayerId(String layerId) {
        this.layerId = layerId;
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
        if (getLayerId() != null) sb.append("LayerId: " + getLayerId() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getLayerId() == null) ? 0 : getLayerId().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof GetHostnameSuggestionRequest == false) return false;
        GetHostnameSuggestionRequest other = (GetHostnameSuggestionRequest)obj;
        
        if (other.getLayerId() == null ^ this.getLayerId() == null) return false;
        if (other.getLayerId() != null && other.getLayerId().equals(this.getLayerId()) == false) return false; 
        return true;
    }
    
}
    