// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation;

import android.app.Activity;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.common.util.VisibleForTesting;
import android.view.View;
import java.util.Iterator;
import java.util.Set;
import java.util.Date;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.AdRequest;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import android.content.Context;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.internal.ads.zzcne;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;

public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zzcne, zzb
{
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdLoader adLoader;
    protected AdView mAdView;
    protected InterstitialAd mInterstitialAd;
    
    AdRequest buildAdRequest(final Context context, final MediationAdRequest mediationAdRequest, final Bundle bundle, final Bundle bundle2) {
        final AdRequest.Builder builder = new AdRequest.Builder();
        final Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.f(birthday);
        }
        final int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.g(gender);
        }
        final Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            final Iterator<String> iterator = keywords.iterator();
            while (iterator.hasNext()) {
                builder.a(iterator.next());
            }
        }
        if (mediationAdRequest.isTesting()) {
            zzaw.b();
            builder.e(zzcfb.zzw(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            final int taggedForChildDirectedTreatment = mediationAdRequest.taggedForChildDirectedTreatment();
            boolean b = true;
            if (taggedForChildDirectedTreatment != 1) {
                b = false;
            }
            builder.i(b);
        }
        builder.h(mediationAdRequest.isDesignedForFamilies());
        builder.b(AdMobAdapter.class, this.buildExtrasBundle(bundle, bundle2));
        return builder.c();
    }
    
    protected abstract Bundle buildExtrasBundle(final Bundle p0, final Bundle p1);
    
    public String getAdUnitId(final Bundle bundle) {
        return bundle.getString("pubid");
    }
    
    @Override
    public View getBannerView() {
        return (View)this.mAdView;
    }
    
    @VisibleForTesting
    InterstitialAd getInterstitialAd() {
        return this.mInterstitialAd;
    }
    
    public Bundle getInterstitialAdapterInfo() {
        final zza zza = new zza();
        zza.b(1);
        return zza.a();
    }
    
    public zzdk getVideoController() {
        final AdView mAdView = this.mAdView;
        if (mAdView != null) {
            return mAdView.e().d();
        }
        return null;
    }
    
    @VisibleForTesting
    AdLoader.Builder newAdLoader(final Context context, final String s) {
        return new AdLoader.Builder(context, s);
    }
    
    @Override
    public void onDestroy() {
        final AdView mAdView = this.mAdView;
        if (mAdView != null) {
            mAdView.a();
            this.mAdView = null;
        }
        if (this.mInterstitialAd != null) {
            this.mInterstitialAd = null;
        }
        if (this.adLoader != null) {
            this.adLoader = null;
        }
    }
    
    @Override
    public void onImmersiveModeUpdated(final boolean immersiveMode) {
        final InterstitialAd mInterstitialAd = this.mInterstitialAd;
        if (mInterstitialAd != null) {
            mInterstitialAd.setImmersiveMode(immersiveMode);
        }
    }
    
    @Override
    public void onPause() {
        final AdView mAdView = this.mAdView;
        if (mAdView != null) {
            mAdView.c();
        }
    }
    
    @Override
    public void onResume() {
        final AdView mAdView = this.mAdView;
        if (mAdView != null) {
            mAdView.d();
        }
    }
    
    @Override
    public void requestBannerAd(final Context context, final MediationBannerListener mediationBannerListener, final Bundle bundle, final AdSize adSize, final MediationAdRequest mediationAdRequest, final Bundle bundle2) {
        (this.mAdView = new AdView(context)).setAdSize(new AdSize(adSize.c(), adSize.a()));
        this.mAdView.setAdUnitId(this.getAdUnitId(bundle));
        this.mAdView.setAdListener(new b(this, mediationBannerListener));
        this.mAdView.b(this.buildAdRequest(context, mediationAdRequest, bundle2, bundle));
    }
    
    public void requestInterstitialAd(final Context context, final MediationInterstitialListener mediationInterstitialListener, final Bundle bundle, final MediationAdRequest mediationAdRequest, final Bundle bundle2) {
        InterstitialAd.load(context, this.getAdUnitId(bundle), this.buildAdRequest(context, mediationAdRequest, bundle2, bundle), new c(this, mediationInterstitialListener));
    }
    
    @Override
    public void requestNativeAd(final Context context, final MediationNativeListener mediationNativeListener, final Bundle bundle, final NativeMediationAdRequest nativeMediationAdRequest, final Bundle bundle2) {
        final e e = new e(this, mediationNativeListener);
        final AdLoader.Builder e2 = this.newAdLoader(context, bundle.getString("pubid")).e(e);
        e2.f(nativeMediationAdRequest.getNativeAdOptions());
        e2.g(nativeMediationAdRequest.getNativeAdRequestOptions());
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            e2.d(e);
        }
        if (nativeMediationAdRequest.zzb()) {
            for (final String s : nativeMediationAdRequest.zza().keySet()) {
                NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener;
                if (!(boolean)nativeMediationAdRequest.zza().get(s)) {
                    onCustomClickListener = null;
                }
                else {
                    onCustomClickListener = e;
                }
                e2.b(s, e, onCustomClickListener);
            }
        }
        (this.adLoader = e2.a()).a(this.buildAdRequest(context, nativeMediationAdRequest, bundle2, bundle));
    }
    
    public void showInterstitial() {
        final InterstitialAd mInterstitialAd = this.mInterstitialAd;
        if (mInterstitialAd != null) {
            mInterstitialAd.show(null);
        }
    }
}
