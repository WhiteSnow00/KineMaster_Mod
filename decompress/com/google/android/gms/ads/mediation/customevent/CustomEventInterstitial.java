// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation.customevent;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import android.content.Context;

@Deprecated
public interface CustomEventInterstitial extends CustomEvent
{
    void onDestroy();
    
    void onPause();
    
    void onResume();
    
    void requestInterstitialAd(final Context p0, final CustomEventInterstitialListener p1, final String p2, final MediationAdRequest p3, final Bundle p4);
    
    void showInterstitial();
}
