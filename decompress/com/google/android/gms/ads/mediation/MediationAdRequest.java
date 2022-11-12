// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import java.util.Set;
import java.util.Date;

@Deprecated
public interface MediationAdRequest
{
    @Deprecated
    Date getBirthday();
    
    @Deprecated
    int getGender();
    
    Set<String> getKeywords();
    
    @Deprecated
    boolean isDesignedForFamilies();
    
    boolean isTesting();
    
    int taggedForChildDirectedTreatment();
}
