// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.AdSize;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import android.content.Context;
import com.google.android.gms.internal.ads.zzcfi;
import java.util.Objects;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;

@KeepForSdkWithMembers
@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{
    @VisibleForTesting
    static final AdError e;
    private View a;
    @VisibleForTesting
    CustomEventBanner b;
    @VisibleForTesting
    CustomEventInterstitial c;
    @VisibleForTesting
    CustomEventNative d;
    
    static {
        e = new AdError(0, "Could not instantiate custom event adapter", "com.google.android.gms.ads");
    }
    
    private static Object a(final Class clazz, final String s) {
        Objects.requireNonNull(s);
        try {
            return clazz.cast(Class.forName(s).getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]));
        }
        finally {
            final Throwable t;
            final String message = t.getMessage();
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(s);
            sb.append(". ");
            sb.append(message);
            zzcfi.zzj(sb.toString());
            return null;
        }
    }
    
    @Override
    public View getBannerView() {
        return this.a;
    }
    
    @Override
    public void onDestroy() {
        final CustomEventBanner b = this.b;
        if (b != null) {
            b.onDestroy();
        }
        final CustomEventInterstitial c = this.c;
        if (c != null) {
            c.onDestroy();
        }
        final CustomEventNative d = this.d;
        if (d != null) {
            d.onDestroy();
        }
    }
    
    @Override
    public void onPause() {
        final CustomEventBanner b = this.b;
        if (b != null) {
            b.onPause();
        }
        final CustomEventInterstitial c = this.c;
        if (c != null) {
            c.onPause();
        }
        final CustomEventNative d = this.d;
        if (d != null) {
            d.onPause();
        }
    }
    
    @Override
    public void onResume() {
        final CustomEventBanner b = this.b;
        if (b != null) {
            b.onResume();
        }
        final CustomEventInterstitial c = this.c;
        if (c != null) {
            c.onResume();
        }
        final CustomEventNative d = this.d;
        if (d != null) {
            d.onResume();
        }
    }
    
    @Override
    public void requestBannerAd(final Context context, final MediationBannerListener mediationBannerListener, final Bundle bundle, final AdSize adSize, final MediationAdRequest mediationAdRequest, Bundle bundle2) {
        final CustomEventBanner b = (CustomEventBanner)a(CustomEventBanner.class, bundle.getString("class_name"));
        this.b = b;
        if (b == null) {
            mediationBannerListener.onAdFailedToLoad(this, CustomEventAdapter.e);
            return;
        }
        if (bundle2 == null) {
            bundle2 = null;
        }
        else {
            bundle2 = bundle2.getBundle(bundle.getString("class_name"));
        }
        final CustomEventBanner b2 = this.b;
        Objects.requireNonNull(b2);
        b2.requestBannerAd(context, new a(this, mediationBannerListener), bundle.getString("parameter"), adSize, mediationAdRequest, bundle2);
    }
    
    @Override
    public void requestInterstitialAd(final Context context, final MediationInterstitialListener mediationInterstitialListener, final Bundle bundle, final MediationAdRequest mediationAdRequest, Bundle bundle2) {
        final CustomEventInterstitial c = (CustomEventInterstitial)a(CustomEventInterstitial.class, bundle.getString("class_name"));
        this.c = c;
        if (c == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, CustomEventAdapter.e);
            return;
        }
        if (bundle2 == null) {
            bundle2 = null;
        }
        else {
            bundle2 = bundle2.getBundle(bundle.getString("class_name"));
        }
        final CustomEventInterstitial c2 = this.c;
        Objects.requireNonNull(c2);
        c2.requestInterstitialAd(context, new b(this, this, mediationInterstitialListener), bundle.getString("parameter"), mediationAdRequest, bundle2);
    }
    
    @Override
    public void requestNativeAd(final Context context, final MediationNativeListener mediationNativeListener, final Bundle bundle, final NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        final CustomEventNative d = (CustomEventNative)a(CustomEventNative.class, bundle.getString("class_name"));
        this.d = d;
        if (d == null) {
            mediationNativeListener.onAdFailedToLoad(this, CustomEventAdapter.e);
            return;
        }
        if (bundle2 == null) {
            bundle2 = null;
        }
        else {
            bundle2 = bundle2.getBundle(bundle.getString("class_name"));
        }
        final CustomEventNative d2 = this.d;
        Objects.requireNonNull(d2);
        d2.requestNativeAd(context, new c(this, mediationNativeListener), bundle.getString("parameter"), nativeMediationAdRequest, bundle2);
    }
    
    @Override
    public void showInterstitial() {
        final CustomEventInterstitial c = this.c;
        if (c != null) {
            c.showInterstitial();
        }
    }
}
