// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation.facebook.rtb;

import com.facebook.ads.Ad;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.ExtraHints;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import android.text.TextUtils;
import android.util.Log;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.AdError;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import com.facebook.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;

public class FacebookRtbInterstitialAd implements MediationInterstitialAd, InterstitialAdExtendedListener
{
    private final MediationInterstitialAdConfiguration a;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> b;
    private InterstitialAd c;
    private MediationInterstitialAdCallback d;
    private final AtomicBoolean e;
    private final AtomicBoolean f;
    
    public FacebookRtbInterstitialAd(final MediationInterstitialAdConfiguration a, final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> b) {
        this.e = new AtomicBoolean();
        this.f = new AtomicBoolean();
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void a(final Context context) {
        this.e.set(true);
        if (!this.c.show()) {
            final AdError adError = new AdError(110, "Failed to present interstitial ad.", "com.google.ads.mediation.facebook");
            Log.w(FacebookMediationAdapter.TAG, adError.toString());
            final MediationInterstitialAdCallback d = this.d;
            if (d != null) {
                d.onAdFailedToShow(adError);
            }
        }
    }
    
    public void b() {
        final String placementID = FacebookMediationAdapter.getPlacementID(this.a.c());
        if (TextUtils.isEmpty((CharSequence)placementID)) {
            final AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty. ", "com.google.ads.mediation.facebook");
            Log.e(FacebookMediationAdapter.TAG, adError.c());
            this.b.a(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(this.a);
        this.c = new InterstitialAd(this.a.b(), placementID);
        if (!TextUtils.isEmpty((CharSequence)this.a.d())) {
            this.c.setExtraHints(new ExtraHints.Builder().mediationData(this.a.d()).build());
        }
        final InterstitialAd c = this.c;
        c.loadAd(c.buildLoadAdConfig().withBid(this.a.a()).withAdListener(this).build());
    }
    
    @Override
    public void onAdClicked(final Ad ad) {
        final MediationInterstitialAdCallback d = this.d;
        if (d != null) {
            d.reportAdClicked();
            this.d.onAdLeftApplication();
        }
    }
    
    @Override
    public void onAdLoaded(final Ad ad) {
        this.d = this.b.onSuccess(this);
    }
    
    @Override
    public void onError(final Ad ad, final com.facebook.ads.AdError adError) {
        final AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        Log.w(FacebookMediationAdapter.TAG, adError2.c());
        if (this.e.get()) {
            final MediationInterstitialAdCallback d = this.d;
            if (d != null) {
                d.onAdOpened();
                this.d.onAdClosed();
            }
            return;
        }
        this.b.a(adError2);
    }
    
    @Override
    public void onInterstitialActivityDestroyed() {
        if (!this.f.getAndSet(true)) {
            final MediationInterstitialAdCallback d = this.d;
            if (d != null) {
                d.onAdClosed();
            }
        }
    }
    
    @Override
    public void onInterstitialDismissed(final Ad ad) {
        if (!this.f.getAndSet(true)) {
            final MediationInterstitialAdCallback d = this.d;
            if (d != null) {
                d.onAdClosed();
            }
        }
    }
    
    @Override
    public void onInterstitialDisplayed(final Ad ad) {
        final MediationInterstitialAdCallback d = this.d;
        if (d != null) {
            d.onAdOpened();
        }
    }
    
    @Override
    public void onLoggingImpression(final Ad ad) {
        final MediationInterstitialAdCallback d = this.d;
        if (d != null) {
            d.reportAdImpression();
        }
    }
    
    @Override
    public void onRewardedAdCompleted() {
    }
    
    @Override
    public void onRewardedAdServerFailed() {
    }
    
    @Override
    public void onRewardedAdServerSucceeded() {
    }
}
