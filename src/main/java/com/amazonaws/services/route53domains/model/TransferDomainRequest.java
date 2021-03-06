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
package com.amazonaws.services.route53domains.model;

import java.io.Serializable;

import com.amazonaws.network.request.AmazonWebServiceRequest;

/**
 * Container for the parameters to the {@link com.amazonaws.services.route53domains.AmazonRoute53Domains#transferDomain(TransferDomainRequest) TransferDomain operation}.
 * <p>
 * This operation transfers a domain from another registrar to Amazon
 * Route 53. Domains are registered by the AWS registrar, Gandi upon
 * transfer.
 * </p>
 * <p>
 * To transfer a domain, you need to meet all the domain transfer
 * criteria, including the following:
 * </p>
 * 
 * <ul>
 * <li>You must supply nameservers to transfer a domain.</li>
 * <li>You must disable the domain transfer lock (if any) before
 * transferring the domain.</li>
 * <li>A minimum of 60 days must have elapsed since the domain's
 * registration or last transfer.</li>
 * 
 * </ul>
 * <p>
 * We recommend you use the Amazon Route 53 as the DNS service for your
 * domain. You can create a hosted zone in Amazon Route 53 for your
 * current domain before transferring your domain.
 * </p>
 * <p>
 * Note that upon transfer, the domain duration is extended for a year if
 * not otherwise specified. Autorenew is enabled by default.
 * </p>
 * <p>
 * If the transfer is successful, this method returns an operation ID
 * that you can use to track the progress and completion of the action.
 * If the request is not completed successfully, the domain registrant
 * will be notified by email.
 * </p>
 * <p>
 * Transferring domains charges your AWS account an amount based on the
 * top-level domain. For more information, see
 * <a href="http://aws.amazon.com/route53/pricing/"> Amazon Route 53 Pricing </a>
 * .
 * </p>
 *
 * @see com.amazonaws.services.route53domains.AmazonRoute53Domains#transferDomain(TransferDomainRequest)
 */
public class TransferDomainRequest extends AmazonWebServiceRequest implements Serializable {

    /**
     * The name of a domain. <p>Type: String <p>Default: None <p>Constraints:
     * The domain name can contain only the letters a through z, the numbers
     * 0 through 9, and hyphen (-). Internationalized Domain Names are not
     * supported. <p>Required: Yes
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_\-.]*<br/>
     */
    private String domainName;

    /**
     * Reserved for future use.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 3<br/>
     */
    private String idnLangCode;

    /**
     * The number of years the domain will be registered. Domains are
     * registered for a minimum of one year. The maximum period depends on
     * the top-level domain. <p>Type: Integer <p>Default: 1 <p>Valid values:
     * Integer from 1 to 10 <p>Required: Yes
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - 10<br/>
     */
    private Integer durationInYears;

    /**
     * Contains details for the host and glue IP addresses. <p>Type: Complex
     * <p>Children: <code>GlueIps</code>, <code>Name</code>
     */
    private com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Nameserver> nameservers;

    /**
     * The authorization code for the domain. You get this value from the
     * current registrar. <p>Type: String <p>Required: Yes
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 1024<br/>
     */
    private String authCode;

    /**
     * Indicates whether the domain will be automatically renewed (true) or
     * not (false). Autorenewal only takes effect after the account is
     * charged. <p>Type: Boolean <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Default: true <p>Required: No
     */
    private Boolean autoRenew;

    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     */
    private ContactDetail adminContact;

    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     */
    private ContactDetail registrantContact;

    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     */
    private ContactDetail techContact;

    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     */
    private Boolean privacyProtectAdminContact;

    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     */
    private Boolean privacyProtectRegistrantContact;

    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     */
    private Boolean privacyProtectTechContact;

    /**
     * The name of a domain. <p>Type: String <p>Default: None <p>Constraints:
     * The domain name can contain only the letters a through z, the numbers
     * 0 through 9, and hyphen (-). Internationalized Domain Names are not
     * supported. <p>Required: Yes
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_\-.]*<br/>
     *
     * @return The name of a domain. <p>Type: String <p>Default: None <p>Constraints:
     *         The domain name can contain only the letters a through z, the numbers
     *         0 through 9, and hyphen (-). Internationalized Domain Names are not
     *         supported. <p>Required: Yes
     */
    public String getDomainName() {
        return domainName;
    }
    
    /**
     * The name of a domain. <p>Type: String <p>Default: None <p>Constraints:
     * The domain name can contain only the letters a through z, the numbers
     * 0 through 9, and hyphen (-). Internationalized Domain Names are not
     * supported. <p>Required: Yes
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_\-.]*<br/>
     *
     * @param domainName The name of a domain. <p>Type: String <p>Default: None <p>Constraints:
     *         The domain name can contain only the letters a through z, the numbers
     *         0 through 9, and hyphen (-). Internationalized Domain Names are not
     *         supported. <p>Required: Yes
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
    
    /**
     * The name of a domain. <p>Type: String <p>Default: None <p>Constraints:
     * The domain name can contain only the letters a through z, the numbers
     * 0 through 9, and hyphen (-). Internationalized Domain Names are not
     * supported. <p>Required: Yes
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_\-.]*<br/>
     *
     * @param domainName The name of a domain. <p>Type: String <p>Default: None <p>Constraints:
     *         The domain name can contain only the letters a through z, the numbers
     *         0 through 9, and hyphen (-). Internationalized Domain Names are not
     *         supported. <p>Required: Yes
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    /**
     * Reserved for future use.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 3<br/>
     *
     * @return Reserved for future use.
     */
    public String getIdnLangCode() {
        return idnLangCode;
    }
    
    /**
     * Reserved for future use.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 3<br/>
     *
     * @param idnLangCode Reserved for future use.
     */
    public void setIdnLangCode(String idnLangCode) {
        this.idnLangCode = idnLangCode;
    }
    
    /**
     * Reserved for future use.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 3<br/>
     *
     * @param idnLangCode Reserved for future use.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withIdnLangCode(String idnLangCode) {
        this.idnLangCode = idnLangCode;
        return this;
    }

    /**
     * The number of years the domain will be registered. Domains are
     * registered for a minimum of one year. The maximum period depends on
     * the top-level domain. <p>Type: Integer <p>Default: 1 <p>Valid values:
     * Integer from 1 to 10 <p>Required: Yes
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - 10<br/>
     *
     * @return The number of years the domain will be registered. Domains are
     *         registered for a minimum of one year. The maximum period depends on
     *         the top-level domain. <p>Type: Integer <p>Default: 1 <p>Valid values:
     *         Integer from 1 to 10 <p>Required: Yes
     */
    public Integer getDurationInYears() {
        return durationInYears;
    }
    
    /**
     * The number of years the domain will be registered. Domains are
     * registered for a minimum of one year. The maximum period depends on
     * the top-level domain. <p>Type: Integer <p>Default: 1 <p>Valid values:
     * Integer from 1 to 10 <p>Required: Yes
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - 10<br/>
     *
     * @param durationInYears The number of years the domain will be registered. Domains are
     *         registered for a minimum of one year. The maximum period depends on
     *         the top-level domain. <p>Type: Integer <p>Default: 1 <p>Valid values:
     *         Integer from 1 to 10 <p>Required: Yes
     */
    public void setDurationInYears(Integer durationInYears) {
        this.durationInYears = durationInYears;
    }
    
    /**
     * The number of years the domain will be registered. Domains are
     * registered for a minimum of one year. The maximum period depends on
     * the top-level domain. <p>Type: Integer <p>Default: 1 <p>Valid values:
     * Integer from 1 to 10 <p>Required: Yes
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Range: </b>1 - 10<br/>
     *
     * @param durationInYears The number of years the domain will be registered. Domains are
     *         registered for a minimum of one year. The maximum period depends on
     *         the top-level domain. <p>Type: Integer <p>Default: 1 <p>Valid values:
     *         Integer from 1 to 10 <p>Required: Yes
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withDurationInYears(Integer durationInYears) {
        this.durationInYears = durationInYears;
        return this;
    }

    /**
     * Contains details for the host and glue IP addresses. <p>Type: Complex
     * <p>Children: <code>GlueIps</code>, <code>Name</code>
     *
     * @return Contains details for the host and glue IP addresses. <p>Type: Complex
     *         <p>Children: <code>GlueIps</code>, <code>Name</code>
     */
    public java.util.List<Nameserver> getNameservers() {
        if (nameservers == null) {
              nameservers = new com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Nameserver>();
              nameservers.setAutoConstruct(true);
        }
        return nameservers;
    }
    
    /**
     * Contains details for the host and glue IP addresses. <p>Type: Complex
     * <p>Children: <code>GlueIps</code>, <code>Name</code>
     *
     * @param nameservers Contains details for the host and glue IP addresses. <p>Type: Complex
     *         <p>Children: <code>GlueIps</code>, <code>Name</code>
     */
    public void setNameservers(java.util.Collection<Nameserver> nameservers) {
        if (nameservers == null) {
            this.nameservers = null;
            return;
        }
        com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Nameserver> nameserversCopy = new com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Nameserver>(nameservers.size());
        nameserversCopy.addAll(nameservers);
        this.nameservers = nameserversCopy;
    }
    
    /**
     * Contains details for the host and glue IP addresses. <p>Type: Complex
     * <p>Children: <code>GlueIps</code>, <code>Name</code>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param nameservers Contains details for the host and glue IP addresses. <p>Type: Complex
     *         <p>Children: <code>GlueIps</code>, <code>Name</code>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withNameservers(Nameserver... nameservers) {
        if (getNameservers() == null) setNameservers(new java.util.ArrayList<Nameserver>(nameservers.length));
        for (Nameserver value : nameservers) {
            getNameservers().add(value);
        }
        return this;
    }
    
    /**
     * Contains details for the host and glue IP addresses. <p>Type: Complex
     * <p>Children: <code>GlueIps</code>, <code>Name</code>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param nameservers Contains details for the host and glue IP addresses. <p>Type: Complex
     *         <p>Children: <code>GlueIps</code>, <code>Name</code>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withNameservers(java.util.Collection<Nameserver> nameservers) {
        if (nameservers == null) {
            this.nameservers = null;
        } else {
            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Nameserver> nameserversCopy = new com.amazonaws.serviceinternal.ListWithAutoConstructFlag<Nameserver>(nameservers.size());
            nameserversCopy.addAll(nameservers);
            this.nameservers = nameserversCopy;
        }

        return this;
    }

    /**
     * The authorization code for the domain. You get this value from the
     * current registrar. <p>Type: String <p>Required: Yes
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 1024<br/>
     *
     * @return The authorization code for the domain. You get this value from the
     *         current registrar. <p>Type: String <p>Required: Yes
     */
    public String getAuthCode() {
        return authCode;
    }
    
    /**
     * The authorization code for the domain. You get this value from the
     * current registrar. <p>Type: String <p>Required: Yes
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 1024<br/>
     *
     * @param authCode The authorization code for the domain. You get this value from the
     *         current registrar. <p>Type: String <p>Required: Yes
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    
    /**
     * The authorization code for the domain. You get this value from the
     * current registrar. <p>Type: String <p>Required: Yes
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>0 - 1024<br/>
     *
     * @param authCode The authorization code for the domain. You get this value from the
     *         current registrar. <p>Type: String <p>Required: Yes
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withAuthCode(String authCode) {
        this.authCode = authCode;
        return this;
    }

    /**
     * Indicates whether the domain will be automatically renewed (true) or
     * not (false). Autorenewal only takes effect after the account is
     * charged. <p>Type: Boolean <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Default: true <p>Required: No
     *
     * @return Indicates whether the domain will be automatically renewed (true) or
     *         not (false). Autorenewal only takes effect after the account is
     *         charged. <p>Type: Boolean <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Default: true <p>Required: No
     */
    public Boolean isAutoRenew() {
        return autoRenew;
    }
    
    /**
     * Indicates whether the domain will be automatically renewed (true) or
     * not (false). Autorenewal only takes effect after the account is
     * charged. <p>Type: Boolean <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Default: true <p>Required: No
     *
     * @param autoRenew Indicates whether the domain will be automatically renewed (true) or
     *         not (false). Autorenewal only takes effect after the account is
     *         charged. <p>Type: Boolean <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Default: true <p>Required: No
     */
    public void setAutoRenew(Boolean autoRenew) {
        this.autoRenew = autoRenew;
    }
    
    /**
     * Indicates whether the domain will be automatically renewed (true) or
     * not (false). Autorenewal only takes effect after the account is
     * charged. <p>Type: Boolean <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Default: true <p>Required: No
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param autoRenew Indicates whether the domain will be automatically renewed (true) or
     *         not (false). Autorenewal only takes effect after the account is
     *         charged. <p>Type: Boolean <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Default: true <p>Required: No
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withAutoRenew(Boolean autoRenew) {
        this.autoRenew = autoRenew;
        return this;
    }

    /**
     * Indicates whether the domain will be automatically renewed (true) or
     * not (false). Autorenewal only takes effect after the account is
     * charged. <p>Type: Boolean <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Default: true <p>Required: No
     *
     * @return Indicates whether the domain will be automatically renewed (true) or
     *         not (false). Autorenewal only takes effect after the account is
     *         charged. <p>Type: Boolean <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Default: true <p>Required: No
     */
    public Boolean getAutoRenew() {
        return autoRenew;
    }

    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     *
     * @return Provides detailed contact information. <p>Type: Complex <p>Children:
     *         <code>FirstName</code>, <code>MiddleName</code>,
     *         <code>LastName</code>, <code>ContactType</code>,
     *         <code>OrganizationName</code>, <code>AddressLine1</code>,
     *         <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     *         <code>CountryCode</code>, <code>ZipCode</code>,
     *         <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     *         <code>ExtraParams</code> <p>Required: Yes
     */
    public ContactDetail getAdminContact() {
        return adminContact;
    }
    
    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     *
     * @param adminContact Provides detailed contact information. <p>Type: Complex <p>Children:
     *         <code>FirstName</code>, <code>MiddleName</code>,
     *         <code>LastName</code>, <code>ContactType</code>,
     *         <code>OrganizationName</code>, <code>AddressLine1</code>,
     *         <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     *         <code>CountryCode</code>, <code>ZipCode</code>,
     *         <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     *         <code>ExtraParams</code> <p>Required: Yes
     */
    public void setAdminContact(ContactDetail adminContact) {
        this.adminContact = adminContact;
    }
    
    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param adminContact Provides detailed contact information. <p>Type: Complex <p>Children:
     *         <code>FirstName</code>, <code>MiddleName</code>,
     *         <code>LastName</code>, <code>ContactType</code>,
     *         <code>OrganizationName</code>, <code>AddressLine1</code>,
     *         <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     *         <code>CountryCode</code>, <code>ZipCode</code>,
     *         <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     *         <code>ExtraParams</code> <p>Required: Yes
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withAdminContact(ContactDetail adminContact) {
        this.adminContact = adminContact;
        return this;
    }

    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     *
     * @return Provides detailed contact information. <p>Type: Complex <p>Children:
     *         <code>FirstName</code>, <code>MiddleName</code>,
     *         <code>LastName</code>, <code>ContactType</code>,
     *         <code>OrganizationName</code>, <code>AddressLine1</code>,
     *         <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     *         <code>CountryCode</code>, <code>ZipCode</code>,
     *         <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     *         <code>ExtraParams</code> <p>Required: Yes
     */
    public ContactDetail getRegistrantContact() {
        return registrantContact;
    }
    
    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     *
     * @param registrantContact Provides detailed contact information. <p>Type: Complex <p>Children:
     *         <code>FirstName</code>, <code>MiddleName</code>,
     *         <code>LastName</code>, <code>ContactType</code>,
     *         <code>OrganizationName</code>, <code>AddressLine1</code>,
     *         <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     *         <code>CountryCode</code>, <code>ZipCode</code>,
     *         <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     *         <code>ExtraParams</code> <p>Required: Yes
     */
    public void setRegistrantContact(ContactDetail registrantContact) {
        this.registrantContact = registrantContact;
    }
    
    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param registrantContact Provides detailed contact information. <p>Type: Complex <p>Children:
     *         <code>FirstName</code>, <code>MiddleName</code>,
     *         <code>LastName</code>, <code>ContactType</code>,
     *         <code>OrganizationName</code>, <code>AddressLine1</code>,
     *         <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     *         <code>CountryCode</code>, <code>ZipCode</code>,
     *         <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     *         <code>ExtraParams</code> <p>Required: Yes
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withRegistrantContact(ContactDetail registrantContact) {
        this.registrantContact = registrantContact;
        return this;
    }

    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     *
     * @return Provides detailed contact information. <p>Type: Complex <p>Children:
     *         <code>FirstName</code>, <code>MiddleName</code>,
     *         <code>LastName</code>, <code>ContactType</code>,
     *         <code>OrganizationName</code>, <code>AddressLine1</code>,
     *         <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     *         <code>CountryCode</code>, <code>ZipCode</code>,
     *         <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     *         <code>ExtraParams</code> <p>Required: Yes
     */
    public ContactDetail getTechContact() {
        return techContact;
    }
    
    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     *
     * @param techContact Provides detailed contact information. <p>Type: Complex <p>Children:
     *         <code>FirstName</code>, <code>MiddleName</code>,
     *         <code>LastName</code>, <code>ContactType</code>,
     *         <code>OrganizationName</code>, <code>AddressLine1</code>,
     *         <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     *         <code>CountryCode</code>, <code>ZipCode</code>,
     *         <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     *         <code>ExtraParams</code> <p>Required: Yes
     */
    public void setTechContact(ContactDetail techContact) {
        this.techContact = techContact;
    }
    
    /**
     * Provides detailed contact information. <p>Type: Complex <p>Children:
     * <code>FirstName</code>, <code>MiddleName</code>,
     * <code>LastName</code>, <code>ContactType</code>,
     * <code>OrganizationName</code>, <code>AddressLine1</code>,
     * <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     * <code>CountryCode</code>, <code>ZipCode</code>,
     * <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     * <code>ExtraParams</code> <p>Required: Yes
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param techContact Provides detailed contact information. <p>Type: Complex <p>Children:
     *         <code>FirstName</code>, <code>MiddleName</code>,
     *         <code>LastName</code>, <code>ContactType</code>,
     *         <code>OrganizationName</code>, <code>AddressLine1</code>,
     *         <code>AddressLine2</code>, <code>City</code>, <code>State</code>,
     *         <code>CountryCode</code>, <code>ZipCode</code>,
     *         <code>PhoneNumber</code>, <code>Email</code>, <code>Fax</code>,
     *         <code>ExtraParams</code> <p>Required: Yes
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withTechContact(ContactDetail techContact) {
        this.techContact = techContact;
        return this;
    }

    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     *
     * @return Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     */
    public Boolean isPrivacyProtectAdminContact() {
        return privacyProtectAdminContact;
    }
    
    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     *
     * @param privacyProtectAdminContact Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     */
    public void setPrivacyProtectAdminContact(Boolean privacyProtectAdminContact) {
        this.privacyProtectAdminContact = privacyProtectAdminContact;
    }
    
    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param privacyProtectAdminContact Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withPrivacyProtectAdminContact(Boolean privacyProtectAdminContact) {
        this.privacyProtectAdminContact = privacyProtectAdminContact;
        return this;
    }

    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     *
     * @return Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     */
    public Boolean getPrivacyProtectAdminContact() {
        return privacyProtectAdminContact;
    }

    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     *
     * @return Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     */
    public Boolean isPrivacyProtectRegistrantContact() {
        return privacyProtectRegistrantContact;
    }
    
    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     *
     * @param privacyProtectRegistrantContact Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     */
    public void setPrivacyProtectRegistrantContact(Boolean privacyProtectRegistrantContact) {
        this.privacyProtectRegistrantContact = privacyProtectRegistrantContact;
    }
    
    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param privacyProtectRegistrantContact Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withPrivacyProtectRegistrantContact(Boolean privacyProtectRegistrantContact) {
        this.privacyProtectRegistrantContact = privacyProtectRegistrantContact;
        return this;
    }

    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     *
     * @return Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     */
    public Boolean getPrivacyProtectRegistrantContact() {
        return privacyProtectRegistrantContact;
    }

    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     *
     * @return Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     */
    public Boolean isPrivacyProtectTechContact() {
        return privacyProtectTechContact;
    }
    
    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     *
     * @param privacyProtectTechContact Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     */
    public void setPrivacyProtectTechContact(Boolean privacyProtectTechContact) {
        this.privacyProtectTechContact = privacyProtectTechContact;
    }
    
    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param privacyProtectTechContact Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TransferDomainRequest withPrivacyProtectTechContact(Boolean privacyProtectTechContact) {
        this.privacyProtectTechContact = privacyProtectTechContact;
        return this;
    }

    /**
     * Whether you want to conceal contact information from WHOIS queries. If
     * you specify true, WHOIS ("who is") queries will return contact
     * information for our registrar partner, Gandi, instead of the contact
     * information that you enter. <p>Type: Boolean <p>Default:
     * <code>true</code> <p>Valid values: <code>true</code> |
     * <code>false</code> <p>Required: No
     *
     * @return Whether you want to conceal contact information from WHOIS queries. If
     *         you specify true, WHOIS ("who is") queries will return contact
     *         information for our registrar partner, Gandi, instead of the contact
     *         information that you enter. <p>Type: Boolean <p>Default:
     *         <code>true</code> <p>Valid values: <code>true</code> |
     *         <code>false</code> <p>Required: No
     */
    public Boolean getPrivacyProtectTechContact() {
        return privacyProtectTechContact;
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
        if (getDomainName() != null) sb.append("DomainName: " + getDomainName() + ",");
        if (getIdnLangCode() != null) sb.append("IdnLangCode: " + getIdnLangCode() + ",");
        if (getDurationInYears() != null) sb.append("DurationInYears: " + getDurationInYears() + ",");
        if (getNameservers() != null) sb.append("Nameservers: " + getNameservers() + ",");
        if (getAuthCode() != null) sb.append("AuthCode: " + getAuthCode() + ",");
        if (isAutoRenew() != null) sb.append("AutoRenew: " + isAutoRenew() + ",");
        if (getAdminContact() != null) sb.append("AdminContact: " + getAdminContact() + ",");
        if (getRegistrantContact() != null) sb.append("RegistrantContact: " + getRegistrantContact() + ",");
        if (getTechContact() != null) sb.append("TechContact: " + getTechContact() + ",");
        if (isPrivacyProtectAdminContact() != null) sb.append("PrivacyProtectAdminContact: " + isPrivacyProtectAdminContact() + ",");
        if (isPrivacyProtectRegistrantContact() != null) sb.append("PrivacyProtectRegistrantContact: " + isPrivacyProtectRegistrantContact() + ",");
        if (isPrivacyProtectTechContact() != null) sb.append("PrivacyProtectTechContact: " + isPrivacyProtectTechContact() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getDomainName() == null) ? 0 : getDomainName().hashCode()); 
        hashCode = prime * hashCode + ((getIdnLangCode() == null) ? 0 : getIdnLangCode().hashCode()); 
        hashCode = prime * hashCode + ((getDurationInYears() == null) ? 0 : getDurationInYears().hashCode()); 
        hashCode = prime * hashCode + ((getNameservers() == null) ? 0 : getNameservers().hashCode()); 
        hashCode = prime * hashCode + ((getAuthCode() == null) ? 0 : getAuthCode().hashCode()); 
        hashCode = prime * hashCode + ((isAutoRenew() == null) ? 0 : isAutoRenew().hashCode()); 
        hashCode = prime * hashCode + ((getAdminContact() == null) ? 0 : getAdminContact().hashCode()); 
        hashCode = prime * hashCode + ((getRegistrantContact() == null) ? 0 : getRegistrantContact().hashCode()); 
        hashCode = prime * hashCode + ((getTechContact() == null) ? 0 : getTechContact().hashCode()); 
        hashCode = prime * hashCode + ((isPrivacyProtectAdminContact() == null) ? 0 : isPrivacyProtectAdminContact().hashCode()); 
        hashCode = prime * hashCode + ((isPrivacyProtectRegistrantContact() == null) ? 0 : isPrivacyProtectRegistrantContact().hashCode()); 
        hashCode = prime * hashCode + ((isPrivacyProtectTechContact() == null) ? 0 : isPrivacyProtectTechContact().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof TransferDomainRequest == false) return false;
        TransferDomainRequest other = (TransferDomainRequest)obj;
        
        if (other.getDomainName() == null ^ this.getDomainName() == null) return false;
        if (other.getDomainName() != null && other.getDomainName().equals(this.getDomainName()) == false) return false; 
        if (other.getIdnLangCode() == null ^ this.getIdnLangCode() == null) return false;
        if (other.getIdnLangCode() != null && other.getIdnLangCode().equals(this.getIdnLangCode()) == false) return false; 
        if (other.getDurationInYears() == null ^ this.getDurationInYears() == null) return false;
        if (other.getDurationInYears() != null && other.getDurationInYears().equals(this.getDurationInYears()) == false) return false; 
        if (other.getNameservers() == null ^ this.getNameservers() == null) return false;
        if (other.getNameservers() != null && other.getNameservers().equals(this.getNameservers()) == false) return false; 
        if (other.getAuthCode() == null ^ this.getAuthCode() == null) return false;
        if (other.getAuthCode() != null && other.getAuthCode().equals(this.getAuthCode()) == false) return false; 
        if (other.isAutoRenew() == null ^ this.isAutoRenew() == null) return false;
        if (other.isAutoRenew() != null && other.isAutoRenew().equals(this.isAutoRenew()) == false) return false; 
        if (other.getAdminContact() == null ^ this.getAdminContact() == null) return false;
        if (other.getAdminContact() != null && other.getAdminContact().equals(this.getAdminContact()) == false) return false; 
        if (other.getRegistrantContact() == null ^ this.getRegistrantContact() == null) return false;
        if (other.getRegistrantContact() != null && other.getRegistrantContact().equals(this.getRegistrantContact()) == false) return false; 
        if (other.getTechContact() == null ^ this.getTechContact() == null) return false;
        if (other.getTechContact() != null && other.getTechContact().equals(this.getTechContact()) == false) return false; 
        if (other.isPrivacyProtectAdminContact() == null ^ this.isPrivacyProtectAdminContact() == null) return false;
        if (other.isPrivacyProtectAdminContact() != null && other.isPrivacyProtectAdminContact().equals(this.isPrivacyProtectAdminContact()) == false) return false; 
        if (other.isPrivacyProtectRegistrantContact() == null ^ this.isPrivacyProtectRegistrantContact() == null) return false;
        if (other.isPrivacyProtectRegistrantContact() != null && other.isPrivacyProtectRegistrantContact().equals(this.isPrivacyProtectRegistrantContact()) == false) return false; 
        if (other.isPrivacyProtectTechContact() == null ^ this.isPrivacyProtectTechContact() == null) return false;
        if (other.isPrivacyProtectTechContact() != null && other.isPrivacyProtectTechContact().equals(this.isPrivacyProtectTechContact()) == false) return false; 
        return true;
    }
    
}
    