// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface MediationAdLoadCallback<MediationAdT, MediationAdCallbackT>
{
    void a(final AdError p0);
    
    MediationAdCallbackT onSuccess(final MediationAdT p0);
}
