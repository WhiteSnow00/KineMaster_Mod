// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.content.Context;

@Deprecated
public interface MediationInterstitialAdapter extends MediationAdapter
{
    void onDestroy();
    
    void onPause();
    
    void onResume();
    
    void requestInterstitialAd(final Context p0, final MediationInterstitialListener p1, final Bundle p2, final MediationAdRequest p3, final Bundle p4);
    
    void showInterstitial();
}
