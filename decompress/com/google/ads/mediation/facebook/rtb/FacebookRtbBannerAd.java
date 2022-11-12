// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation.facebook.rtb;

import com.facebook.ads.Ad;
import android.content.Context;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import com.facebook.ads.ExtraHints;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import android.util.Log;
import com.google.android.gms.ads.AdError;
import android.text.TextUtils;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.ads.AdView;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.facebook.ads.AdListener;
import com.google.android.gms.ads.mediation.MediationBannerAd;

public class FacebookRtbBannerAd implements MediationBannerAd, AdListener
{
    private final MediationBannerAdConfiguration a;
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> b;
    private AdView c;
    private FrameLayout d;
    private MediationBannerAdCallback e;
    
    public FacebookRtbBannerAd(final MediationBannerAdConfiguration a, final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public View a() {
        return (View)this.d;
    }
    
    public void c() {
        final String placementID = FacebookMediationAdapter.getPlacementID(this.a.c());
        if (TextUtils.isEmpty((CharSequence)placementID)) {
            final AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            Log.e(FacebookMediationAdapter.TAG, adError.c());
            this.b.a(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(this.a);
        try {
            this.c = new AdView(this.a.b(), placementID, this.a.a());
            if (!TextUtils.isEmpty((CharSequence)this.a.d())) {
                this.c.setExtraHints(new ExtraHints.Builder().mediationData(this.a.d()).build());
            }
            final Context b = this.a.b();
            final FrameLayout$LayoutParams layoutParams = new FrameLayout$LayoutParams(this.a.f().d(b), -2);
            this.d = new FrameLayout(b);
            this.c.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            this.d.addView((View)this.c);
            final AdView c = this.c;
            c.loadAd(c.buildLoadAdConfig().withAdListener(this).withBid(this.a.a()).build());
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to create banner ad: ");
            sb.append(ex.getMessage());
            final AdError adError2 = new AdError(111, sb.toString(), "com.google.ads.mediation.facebook");
            Log.e(FacebookMediationAdapter.TAG, adError2.c());
            this.b.a(adError2);
        }
    }
    
    @Override
    public void onAdClicked(final Ad ad) {
        final MediationBannerAdCallback e = this.e;
        if (e != null) {
            e.reportAdClicked();
            this.e.onAdOpened();
            this.e.onAdLeftApplication();
        }
    }
    
    @Override
    public void onAdLoaded(final Ad ad) {
        this.e = this.b.onSuccess(this);
    }
    
    @Override
    public void onError(final Ad ad, final com.facebook.ads.AdError adError) {
        final AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        Log.w(FacebookMediationAdapter.TAG, adError2.c());
        this.b.a(adError2);
    }
    
    @Override
    public void onLoggingImpression(final Ad ad) {
        final MediationBannerAdCallback e = this.e;
        if (e != null) {
            e.reportAdImpression();
        }
    }
}
