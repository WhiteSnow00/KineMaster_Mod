// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdSize;
import android.os.Bundle;
import android.content.Context;
import android.view.View;

@Deprecated
public interface MediationBannerAdapter extends MediationAdapter
{
    View getBannerView();
    
    void onDestroy();
    
    void onPause();
    
    void onResume();
    
    void requestBannerAd(final Context p0, final MediationBannerListener p1, final Bundle p2, final AdSize p3, final MediationAdRequest p4, final Bundle p5);
}
