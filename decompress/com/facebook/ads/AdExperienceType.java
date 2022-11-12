// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public enum AdExperienceType
{
    private static final AdExperienceType[] $VALUES;
    
    AD_EXPERIENCE_TYPE_INTERSTITIAL("ad_experience_config_interstitial"), 
    AD_EXPERIENCE_TYPE_REWARDED("ad_experience_config_rewarded"), 
    AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL("ad_experience_config_rewarded_interstitial");
    
    private String adExperienceType;
    
    private AdExperienceType(final String adExperienceType) {
        this.adExperienceType = adExperienceType;
    }
    
    public String getAdExperienceType() {
        return this.adExperienceType;
    }
}
