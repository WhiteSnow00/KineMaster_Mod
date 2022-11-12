// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

public interface MediationInterstitialAdCallback extends MediationAdCallback
{
    void onAdFailedToShow(final AdError p0);
    
    void onAdLeftApplication();
}
