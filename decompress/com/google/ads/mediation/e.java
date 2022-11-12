// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.AdListener;

@VisibleForTesting
final class e extends AdListener implements OnUnifiedNativeAdLoadedListener, OnCustomTemplateAdLoadedListener, OnCustomClickListener
{
    @VisibleForTesting
    final AbstractAdViewAdapter a;
    @VisibleForTesting
    final MediationNativeListener b;
    
    public e(final AbstractAdViewAdapter a, final MediationNativeListener b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a(final NativeCustomTemplateAd nativeCustomTemplateAd) {
        this.b.zzc(this.a, nativeCustomTemplateAd);
    }
    
    @Override
    public final void b(final NativeCustomTemplateAd nativeCustomTemplateAd, final String s) {
        this.b.zze(this.a, nativeCustomTemplateAd, s);
    }
    
    @Override
    public final void c(final UnifiedNativeAd unifiedNativeAd) {
        this.b.onAdLoaded(this.a, new a(unifiedNativeAd));
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
    public final void onAdImpression() {
        this.b.onAdImpression(this.a);
    }
    
    @Override
    public final void onAdLoaded() {
    }
    
    @Override
    public final void onAdOpened() {
        this.b.onAdOpened(this.a);
    }
}
