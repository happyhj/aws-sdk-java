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

import java.io.Serializable;

/**
 * <p>
 * A complex type that controls the countries in which your content is
 * distributed. For more information about geo restriction, go to
 * Customizing Error Responses in the Amazon CloudFront Developer Guide.
 * CloudFront determines the location of your users using MaxMind GeoIP
 * databases. For information about the accuracy of these databases, see
 * How accurate are your GeoIP databases? on the MaxMind website.
 * </p>
 */
public class GeoRestriction implements Serializable {

    /**
     * The method that you want to use to restrict distribution of your
     * content by country: - none: No geo restriction is enabled, meaning
     * access to content is not restricted by client geo location. -
     * blacklist: The Location elements specify the countries in which you do
     * not want CloudFront to distribute your content. - whitelist: The
     * Location elements specify the countries in which you want CloudFront
     * to distribute your content.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>blacklist, whitelist, none
     */
    private String restrictionType;

    /**
     * When geo restriction is enabled, this is the number of countries in
     * your whitelist or blacklist. Otherwise, when it is not enabled,
     * Quantity is 0, and you can omit Items.
     */
    private Integer quantity;

    /**
     * A complex type that contains a Location element for each country in
     * which you want CloudFront either to distribute your content
     * (whitelist) or not distribute your content (blacklist). The Location
     * element is a two-letter, uppercase country code for a country that you
     * want to include in your blacklist or whitelist. Include one Location
     * element for each country. CloudFront and MaxMind both use ISO 3166
     * country codes. For the current list of countries and the corresponding
     * codes, see ISO 3166-1-alpha-2 code on the International Organization
     * for Standardization website. You can also refer to the country list in
     * the CloudFront console, which includes both country names and codes.
     */
    private com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> items;

    /**
     * Default constructor for a new GeoRestriction object.  Callers should use the
     * setter or fluent setter (with...) methods to initialize this object after creating it.
     */
    public GeoRestriction() {}
    
    /**
     * Constructs a new GeoRestriction object.
     * Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param restrictionType The method that you want to use to restrict
     * distribution of your content by country: - none: No geo restriction is
     * enabled, meaning access to content is not restricted by client geo
     * location. - blacklist: The Location elements specify the countries in
     * which you do not want CloudFront to distribute your content. -
     * whitelist: The Location elements specify the countries in which you
     * want CloudFront to distribute your content.
     */
    public GeoRestriction(String restrictionType) {
        setRestrictionType(restrictionType);
    }

    /**
     * Constructs a new GeoRestriction object.
     * Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param restrictionType The method that you want to use to restrict
     * distribution of your content by country: - none: No geo restriction is
     * enabled, meaning access to content is not restricted by client geo
     * location. - blacklist: The Location elements specify the countries in
     * which you do not want CloudFront to distribute your content. -
     * whitelist: The Location elements specify the countries in which you
     * want CloudFront to distribute your content.
     */
    public GeoRestriction(GeoRestrictionType restrictionType) {
        this.restrictionType = restrictionType.toString();
    }

    /**
     * The method that you want to use to restrict distribution of your
     * content by country: - none: No geo restriction is enabled, meaning
     * access to content is not restricted by client geo location. -
     * blacklist: The Location elements specify the countries in which you do
     * not want CloudFront to distribute your content. - whitelist: The
     * Location elements specify the countries in which you want CloudFront
     * to distribute your content.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>blacklist, whitelist, none
     *
     * @return The method that you want to use to restrict distribution of your
     *         content by country: - none: No geo restriction is enabled, meaning
     *         access to content is not restricted by client geo location. -
     *         blacklist: The Location elements specify the countries in which you do
     *         not want CloudFront to distribute your content. - whitelist: The
     *         Location elements specify the countries in which you want CloudFront
     *         to distribute your content.
     *
     * @see GeoRestrictionType
     */
    public String getRestrictionType() {
        return restrictionType;
    }
    
    /**
     * The method that you want to use to restrict distribution of your
     * content by country: - none: No geo restriction is enabled, meaning
     * access to content is not restricted by client geo location. -
     * blacklist: The Location elements specify the countries in which you do
     * not want CloudFront to distribute your content. - whitelist: The
     * Location elements specify the countries in which you want CloudFront
     * to distribute your content.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>blacklist, whitelist, none
     *
     * @param restrictionType The method that you want to use to restrict distribution of your
     *         content by country: - none: No geo restriction is enabled, meaning
     *         access to content is not restricted by client geo location. -
     *         blacklist: The Location elements specify the countries in which you do
     *         not want CloudFront to distribute your content. - whitelist: The
     *         Location elements specify the countries in which you want CloudFront
     *         to distribute your content.
     *
     * @see GeoRestrictionType
     */
    public void setRestrictionType(String restrictionType) {
        this.restrictionType = restrictionType;
    }
    
    /**
     * The method that you want to use to restrict distribution of your
     * content by country: - none: No geo restriction is enabled, meaning
     * access to content is not restricted by client geo location. -
     * blacklist: The Location elements specify the countries in which you do
     * not want CloudFront to distribute your content. - whitelist: The
     * Location elements specify the countries in which you want CloudFront
     * to distribute your content.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>blacklist, whitelist, none
     *
     * @param restrictionType The method that you want to use to restrict distribution of your
     *         content by country: - none: No geo restriction is enabled, meaning
     *         access to content is not restricted by client geo location. -
     *         blacklist: The Location elements specify the countries in which you do
     *         not want CloudFront to distribute your content. - whitelist: The
     *         Location elements specify the countries in which you want CloudFront
     *         to distribute your content.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see GeoRestrictionType
     */
    public GeoRestriction withRestrictionType(String restrictionType) {
        this.restrictionType = restrictionType;
        return this;
    }

    /**
     * The method that you want to use to restrict distribution of your
     * content by country: - none: No geo restriction is enabled, meaning
     * access to content is not restricted by client geo location. -
     * blacklist: The Location elements specify the countries in which you do
     * not want CloudFront to distribute your content. - whitelist: The
     * Location elements specify the countries in which you want CloudFront
     * to distribute your content.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>blacklist, whitelist, none
     *
     * @param restrictionType The method that you want to use to restrict distribution of your
     *         content by country: - none: No geo restriction is enabled, meaning
     *         access to content is not restricted by client geo location. -
     *         blacklist: The Location elements specify the countries in which you do
     *         not want CloudFront to distribute your content. - whitelist: The
     *         Location elements specify the countries in which you want CloudFront
     *         to distribute your content.
     *
     * @see GeoRestrictionType
     */
    public void setRestrictionType(GeoRestrictionType restrictionType) {
        this.restrictionType = restrictionType.toString();
    }
    
    /**
     * The method that you want to use to restrict distribution of your
     * content by country: - none: No geo restriction is enabled, meaning
     * access to content is not restricted by client geo location. -
     * blacklist: The Location elements specify the countries in which you do
     * not want CloudFront to distribute your content. - whitelist: The
     * Location elements specify the countries in which you want CloudFront
     * to distribute your content.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>blacklist, whitelist, none
     *
     * @param restrictionType The method that you want to use to restrict distribution of your
     *         content by country: - none: No geo restriction is enabled, meaning
     *         access to content is not restricted by client geo location. -
     *         blacklist: The Location elements specify the countries in which you do
     *         not want CloudFront to distribute your content. - whitelist: The
     *         Location elements specify the countries in which you want CloudFront
     *         to distribute your content.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see GeoRestrictionType
     */
    public GeoRestriction withRestrictionType(GeoRestrictionType restrictionType) {
        this.restrictionType = restrictionType.toString();
        return this;
    }

    /**
     * When geo restriction is enabled, this is the number of countries in
     * your whitelist or blacklist. Otherwise, when it is not enabled,
     * Quantity is 0, and you can omit Items.
     *
     * @return When geo restriction is enabled, this is the number of countries in
     *         your whitelist or blacklist. Otherwise, when it is not enabled,
     *         Quantity is 0, and you can omit Items.
     */
    public Integer getQuantity() {
        return quantity;
    }
    
    /**
     * When geo restriction is enabled, this is the number of countries in
     * your whitelist or blacklist. Otherwise, when it is not enabled,
     * Quantity is 0, and you can omit Items.
     *
     * @param quantity When geo restriction is enabled, this is the number of countries in
     *         your whitelist or blacklist. Otherwise, when it is not enabled,
     *         Quantity is 0, and you can omit Items.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    /**
     * When geo restriction is enabled, this is the number of countries in
     * your whitelist or blacklist. Otherwise, when it is not enabled,
     * Quantity is 0, and you can omit Items.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param quantity When geo restriction is enabled, this is the number of countries in
     *         your whitelist or blacklist. Otherwise, when it is not enabled,
     *         Quantity is 0, and you can omit Items.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public GeoRestriction withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * A complex type that contains a Location element for each country in
     * which you want CloudFront either to distribute your content
     * (whitelist) or not distribute your content (blacklist). The Location
     * element is a two-letter, uppercase country code for a country that you
     * want to include in your blacklist or whitelist. Include one Location
     * element for each country. CloudFront and MaxMind both use ISO 3166
     * country codes. For the current list of countries and the corresponding
     * codes, see ISO 3166-1-alpha-2 code on the International Organization
     * for Standardization website. You can also refer to the country list in
     * the CloudFront console, which includes both country names and codes.
     *
     * @return A complex type that contains a Location element for each country in
     *         which you want CloudFront either to distribute your content
     *         (whitelist) or not distribute your content (blacklist). The Location
     *         element is a two-letter, uppercase country code for a country that you
     *         want to include in your blacklist or whitelist. Include one Location
     *         element for each country. CloudFront and MaxMind both use ISO 3166
     *         country codes. For the current list of countries and the corresponding
     *         codes, see ISO 3166-1-alpha-2 code on the International Organization
     *         for Standardization website. You can also refer to the country list in
     *         the CloudFront console, which includes both country names and codes.
     */
    public java.util.List<String> getItems() {
        if (items == null) {
              items = new com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>();
              items.setAutoConstruct(true);
        }
        return items;
    }
    
    /**
     * A complex type that contains a Location element for each country in
     * which you want CloudFront either to distribute your content
     * (whitelist) or not distribute your content (blacklist). The Location
     * element is a two-letter, uppercase country code for a country that you
     * want to include in your blacklist or whitelist. Include one Location
     * element for each country. CloudFront and MaxMind both use ISO 3166
     * country codes. For the current list of countries and the corresponding
     * codes, see ISO 3166-1-alpha-2 code on the International Organization
     * for Standardization website. You can also refer to the country list in
     * the CloudFront console, which includes both country names and codes.
     *
     * @param items A complex type that contains a Location element for each country in
     *         which you want CloudFront either to distribute your content
     *         (whitelist) or not distribute your content (blacklist). The Location
     *         element is a two-letter, uppercase country code for a country that you
     *         want to include in your blacklist or whitelist. Include one Location
     *         element for each country. CloudFront and MaxMind both use ISO 3166
     *         country codes. For the current list of countries and the corresponding
     *         codes, see ISO 3166-1-alpha-2 code on the International Organization
     *         for Standardization website. You can also refer to the country list in
     *         the CloudFront console, which includes both country names and codes.
     */
    public void setItems(java.util.Collection<String> items) {
        if (items == null) {
            this.items = null;
            return;
        }
        com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> itemsCopy = new com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>(items.size());
        itemsCopy.addAll(items);
        this.items = itemsCopy;
    }
    
    /**
     * A complex type that contains a Location element for each country in
     * which you want CloudFront either to distribute your content
     * (whitelist) or not distribute your content (blacklist). The Location
     * element is a two-letter, uppercase country code for a country that you
     * want to include in your blacklist or whitelist. Include one Location
     * element for each country. CloudFront and MaxMind both use ISO 3166
     * country codes. For the current list of countries and the corresponding
     * codes, see ISO 3166-1-alpha-2 code on the International Organization
     * for Standardization website. You can also refer to the country list in
     * the CloudFront console, which includes both country names and codes.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param items A complex type that contains a Location element for each country in
     *         which you want CloudFront either to distribute your content
     *         (whitelist) or not distribute your content (blacklist). The Location
     *         element is a two-letter, uppercase country code for a country that you
     *         want to include in your blacklist or whitelist. Include one Location
     *         element for each country. CloudFront and MaxMind both use ISO 3166
     *         country codes. For the current list of countries and the corresponding
     *         codes, see ISO 3166-1-alpha-2 code on the International Organization
     *         for Standardization website. You can also refer to the country list in
     *         the CloudFront console, which includes both country names and codes.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public GeoRestriction withItems(String... items) {
        if (getItems() == null) setItems(new java.util.ArrayList<String>(items.length));
        for (String value : items) {
            getItems().add(value);
        }
        return this;
    }
    
    /**
     * A complex type that contains a Location element for each country in
     * which you want CloudFront either to distribute your content
     * (whitelist) or not distribute your content (blacklist). The Location
     * element is a two-letter, uppercase country code for a country that you
     * want to include in your blacklist or whitelist. Include one Location
     * element for each country. CloudFront and MaxMind both use ISO 3166
     * country codes. For the current list of countries and the corresponding
     * codes, see ISO 3166-1-alpha-2 code on the International Organization
     * for Standardization website. You can also refer to the country list in
     * the CloudFront console, which includes both country names and codes.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param items A complex type that contains a Location element for each country in
     *         which you want CloudFront either to distribute your content
     *         (whitelist) or not distribute your content (blacklist). The Location
     *         element is a two-letter, uppercase country code for a country that you
     *         want to include in your blacklist or whitelist. Include one Location
     *         element for each country. CloudFront and MaxMind both use ISO 3166
     *         country codes. For the current list of countries and the corresponding
     *         codes, see ISO 3166-1-alpha-2 code on the International Organization
     *         for Standardization website. You can also refer to the country list in
     *         the CloudFront console, which includes both country names and codes.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public GeoRestriction withItems(java.util.Collection<String> items) {
        if (items == null) {
            this.items = null;
        } else {
            com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String> itemsCopy = new com.amazonaws.serviceinternal.ListWithAutoConstructFlag<String>(items.size());
            itemsCopy.addAll(items);
            this.items = itemsCopy;
        }

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
        if (getRestrictionType() != null) sb.append("RestrictionType: " + getRestrictionType() + ",");
        if (getQuantity() != null) sb.append("Quantity: " + getQuantity() + ",");
        if (getItems() != null) sb.append("Items: " + getItems() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getRestrictionType() == null) ? 0 : getRestrictionType().hashCode()); 
        hashCode = prime * hashCode + ((getQuantity() == null) ? 0 : getQuantity().hashCode()); 
        hashCode = prime * hashCode + ((getItems() == null) ? 0 : getItems().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof GeoRestriction == false) return false;
        GeoRestriction other = (GeoRestriction)obj;
        
        if (other.getRestrictionType() == null ^ this.getRestrictionType() == null) return false;
        if (other.getRestrictionType() != null && other.getRestrictionType().equals(this.getRestrictionType()) == false) return false; 
        if (other.getQuantity() == null ^ this.getQuantity() == null) return false;
        if (other.getQuantity() != null && other.getQuantity().equals(this.getQuantity()) == false) return false; 
        if (other.getItems() == null ^ this.getItems() == null) return false;
        if (other.getItems() != null && other.getItems().equals(this.getItems()) == false) return false; 
        return true;
    }
    
}
    