// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.interstitial;

import android.app.Activity;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.internal.ads.zzbrb;
import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.ads.AdRequest;
import android.content.Context;

public abstract class InterstitialAd
{
    public static void load(final Context context, final String s, final AdRequest adRequest, final InterstitialAdLoadCallback interstitialAdLoadCallback) {
        Preconditions.l(context, "Context cannot be null.");
        Preconditions.l(s, "AdUnitId cannot be null.");
        Preconditions.l(adRequest, "AdRequest cannot be null.");
        Preconditions.l(interstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbhy.zzc(context);
        if ((boolean)zzbjm.zzf.zze() && (boolean)zzay.c().zzb(zzbhy.zziq)) {
            zzcex.zzb.execute(new zza(context, s, adRequest, interstitialAdLoadCallback));
            return;
        }
        new zzbrb(context, s).zza(adRequest.a(), (AdLoadCallback)interstitialAdLoadCallback);
    }
    
    public abstract String getAdUnitId();
    
    public abstract FullScreenContentCallback getFullScreenContentCallback();
    
    public abstract OnPaidEventListener getOnPaidEventListener();
    
    public abstract ResponseInfo getResponseInfo();
    
    public abstract void setFullScreenContentCallback(final FullScreenContentCallback p0);
    
    public abstract void setImmersiveMode(final boolean p0);
    
    public abstract void setOnPaidEventListener(final OnPaidEventListener p0);
    
    public abstract void show(final Activity p0);
}
