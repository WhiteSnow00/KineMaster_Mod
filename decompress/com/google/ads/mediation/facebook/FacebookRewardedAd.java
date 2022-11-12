// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation.facebook;

import com.google.android.gms.ads.rewarded.RewardItem;
import com.facebook.ads.Ad;
import com.facebook.ads.ExtraHints;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import android.text.TextUtils;
import com.facebook.ads.AdExperienceType;
import android.util.Log;
import com.google.android.gms.ads.AdError;
import com.facebook.ads.RewardedVideoAdListener;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import com.facebook.ads.RewardedVideoAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.facebook.ads.RewardedVideoAdExtendedListener;
import com.google.android.gms.ads.mediation.MediationRewardedAd;

public class FacebookRewardedAd implements MediationRewardedAd, RewardedVideoAdExtendedListener
{
    private final MediationRewardedAdConfiguration a;
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> b;
    private RewardedVideoAd c;
    private final AtomicBoolean d;
    private MediationRewardedAdCallback e;
    private boolean f;
    private final AtomicBoolean g;
    
    public FacebookRewardedAd(final MediationRewardedAdConfiguration a, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> b) {
        this.d = new AtomicBoolean();
        this.f = false;
        this.g = new AtomicBoolean();
        this.a = a;
        this.b = b;
    }
    
    static void b(final FacebookRewardedAd facebookRewardedAd, final Context context, final String s) {
        facebookRewardedAd.d(context, s);
    }
    
    static MediationAdLoadCallback c(final FacebookRewardedAd facebookRewardedAd) {
        return facebookRewardedAd.b;
    }
    
    private void d(final Context context, final String s) {
        final RewardedVideoAd c = new RewardedVideoAd(context, s);
        (this.c = c).loadAd(c.buildLoadAdConfig().withAdListener(this).withAdExperience(this.e()).build());
    }
    
    @Override
    public void a(final Context context) {
        this.d.set(true);
        if (!this.c.show()) {
            final AdError adError = new AdError(110, "Failed to present rewarded ad.", "com.google.ads.mediation.facebook");
            Log.w(FacebookMediationAdapter.TAG, adError.c());
            final MediationRewardedAdCallback e = this.e;
            if (e != null) {
                e.onAdFailedToShow(adError);
            }
            this.c.destroy();
            return;
        }
        final MediationRewardedAdCallback e2 = this.e;
        if (e2 != null) {
            e2.onVideoStart();
            this.e.onAdOpened();
        }
    }
    
    AdExperienceType e() {
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED;
    }
    
    public void f() {
        final Context b = this.a.b();
        final String placementID = FacebookMediationAdapter.getPlacementID(this.a.c());
        if (TextUtils.isEmpty((CharSequence)placementID)) {
            final AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            Log.e(FacebookMediationAdapter.TAG, adError.c());
            this.b.a(adError);
            return;
        }
        final String a = this.a.a();
        if (!TextUtils.isEmpty((CharSequence)a)) {
            this.f = true;
        }
        FacebookMediationAdapter.setMixedAudience(this.a);
        if (this.f) {
            this.c = new RewardedVideoAd(b, placementID);
            if (!TextUtils.isEmpty((CharSequence)this.a.d())) {
                this.c.setExtraHints(new ExtraHints.Builder().mediationData(this.a.d()).build());
            }
            final RewardedVideoAd c = this.c;
            c.loadAd(c.buildLoadAdConfig().withAdListener(this).withBid(a).withAdExperience(this.e()).build());
        }
        else {
            com.google.ads.mediation.facebook.a.a().b(b, placementID, (a.a)new a.a(this, b, placementID) {
                final Context a;
                final String b;
                final FacebookRewardedAd c;
                
                @Override
                public void a(final AdError adError) {
                    Log.w(FacebookMediationAdapter.TAG, adError.c());
                    if (FacebookRewardedAd.c(this.c) != null) {
                        FacebookRewardedAd.c(this.c).a(adError);
                    }
                }
                
                @Override
                public void b() {
                    FacebookRewardedAd.b(this.c, this.a, this.b);
                }
            });
        }
    }
    
    @Override
    public void onAdClicked(final Ad ad) {
        final MediationRewardedAdCallback e = this.e;
        if (e != null) {
            e.reportAdClicked();
        }
    }
    
    @Override
    public void onAdLoaded(final Ad ad) {
        final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> b = this.b;
        if (b != null) {
            this.e = b.onSuccess(this);
        }
    }
    
    @Override
    public void onError(final Ad ad, final com.facebook.ads.AdError adError) {
        final AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        if (this.d.get()) {
            Log.w(FacebookMediationAdapter.TAG, adError2.c());
            final MediationRewardedAdCallback e = this.e;
            if (e != null) {
                e.onAdFailedToShow(adError2);
            }
        }
        else {
            Log.w(FacebookMediationAdapter.TAG, adError2.c());
            final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> b = this.b;
            if (b != null) {
                b.a(adError2);
            }
        }
        this.c.destroy();
    }
    
    @Override
    public void onLoggingImpression(final Ad ad) {
        final MediationRewardedAdCallback e = this.e;
        if (e != null) {
            e.reportAdImpression();
        }
    }
    
    @Override
    public void onRewardedVideoActivityDestroyed() {
        if (!this.g.getAndSet(true)) {
            final MediationRewardedAdCallback e = this.e;
            if (e != null) {
                e.onAdClosed();
            }
        }
        final RewardedVideoAd c = this.c;
        if (c != null) {
            c.destroy();
        }
    }
    
    @Override
    public void onRewardedVideoClosed() {
        if (!this.g.getAndSet(true)) {
            final MediationRewardedAdCallback e = this.e;
            if (e != null) {
                e.onAdClosed();
            }
        }
        final RewardedVideoAd c = this.c;
        if (c != null) {
            c.destroy();
        }
    }
    
    @Override
    public void onRewardedVideoCompleted() {
        this.e.onVideoComplete();
        this.e.onUserEarnedReward(new FacebookReward());
    }
}
