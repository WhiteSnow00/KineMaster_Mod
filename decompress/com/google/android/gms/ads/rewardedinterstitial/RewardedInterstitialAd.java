// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.rewardedinterstitial;

import com.google.android.gms.ads.OnUserEarnedRewardListener;
import android.app.Activity;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.FullScreenContentCallback;
import android.os.Bundle;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.internal.ads.zzcbx;
import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.ads.AdRequest;
import android.content.Context;

public abstract class RewardedInterstitialAd
{
    public static void load(final Context context, final String s, final AdRequest adRequest, final RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        Preconditions.l(context, "Context cannot be null.");
        Preconditions.l(s, "AdUnitId cannot be null.");
        Preconditions.l(adRequest, "AdRequest cannot be null.");
        Preconditions.l(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbhy.zzc(context);
        if ((boolean)zzbjm.zzi.zze() && (boolean)zzay.c().zzb(zzbhy.zziq)) {
            zzcex.zzb.execute(new zza(context, s, adRequest, rewardedInterstitialAdLoadCallback));
            return;
        }
        new zzcbx(context, s).zza(adRequest.a(), rewardedInterstitialAdLoadCallback);
    }
    
    public static void load(final Context context, final String s, final AdManagerAdRequest adManagerAdRequest, final RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        Preconditions.l(context, "Context cannot be null.");
        Preconditions.l(s, "AdUnitId cannot be null.");
        Preconditions.l(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.l(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbhy.zzc(context);
        if ((boolean)zzbjm.zzi.zze() && (boolean)zzay.c().zzb(zzbhy.zziq)) {
            zzcex.zzb.execute(new zzb(context, s, adManagerAdRequest, rewardedInterstitialAdLoadCallback));
            return;
        }
        new zzcbx(context, s).zza(adManagerAdRequest.a(), rewardedInterstitialAdLoadCallback);
    }
    
    public abstract Bundle getAdMetadata();
    
    public abstract String getAdUnitId();
    
    public abstract FullScreenContentCallback getFullScreenContentCallback();
    
    public abstract OnAdMetadataChangedListener getOnAdMetadataChangedListener();
    
    public abstract OnPaidEventListener getOnPaidEventListener();
    
    public abstract ResponseInfo getResponseInfo();
    
    public abstract RewardItem getRewardItem();
    
    public abstract void setFullScreenContentCallback(final FullScreenContentCallback p0);
    
    public abstract void setImmersiveMode(final boolean p0);
    
    public abstract void setOnAdMetadataChangedListener(final OnAdMetadataChangedListener p0);
    
    public abstract void setOnPaidEventListener(final OnPaidEventListener p0);
    
    public abstract void setServerSideVerificationOptions(final ServerSideVerificationOptions p0);
    
    public abstract void show(final Activity p0, final OnUserEarnedRewardListener p1);
}
