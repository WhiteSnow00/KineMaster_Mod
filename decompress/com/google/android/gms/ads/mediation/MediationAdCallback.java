// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

public interface MediationAdCallback
{
    void onAdClosed();
    
    void onAdOpened();
    
    void reportAdClicked();
    
    void reportAdImpression();
}
