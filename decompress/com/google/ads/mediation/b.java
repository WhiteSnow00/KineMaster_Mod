// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.AdListener;

@VisibleForTesting
final class b extends AdListener implements AppEventListener, zza
{
    @VisibleForTesting
    final AbstractAdViewAdapter a;
    @VisibleForTesting
    final MediationBannerListener b;
    
    public b(final AbstractAdViewAdapter a, final MediationBannerListener b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void d(final String s, final String s2) {
        this.b.zzd(this.a, s, s2);
    }
    
    @Override
    public final void onAdClicked() {
        this.b.onAdClicked(this.a);
    }
    
    @Override
    public final void onAdClosed() {
        this.b.onAdClosed(this.a);
    }
    
    @Override
    public final void onAdFailedToLoad(final LoadAdError loadAdError) {
        this.b.onAdFailedToLoad(this.a, loadAdError);
    }
    
    @Override
    public final void onAdLoaded() {
        this.b.onAdLoaded(this.a);
    }
    
    @Override
    public final void onAdOpened() {
        this.b.onAdOpened(this.a);
    }
}
