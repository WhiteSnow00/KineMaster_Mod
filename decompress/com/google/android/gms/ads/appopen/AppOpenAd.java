// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.appopen;

import com.google.android.gms.ads.AdLoadCallback;
import android.app.Activity;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.ads.AdRequest;
import android.content.Context;

public abstract class AppOpenAd
{
    public static final int APP_OPEN_AD_ORIENTATION_LANDSCAPE = 2;
    public static final int APP_OPEN_AD_ORIENTATION_PORTRAIT = 1;
    
    public static void load(final Context context, final String s, final AdRequest adRequest, @AppOpenAdOrientation final int n, final AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.l(context, "Context cannot be null.");
        Preconditions.l(s, "adUnitId cannot be null.");
        Preconditions.l(adRequest, "AdRequest cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbhy.zzc(context);
        if ((boolean)zzbjm.zzd.zze() && (boolean)zzay.c().zzb(zzbhy.zziq)) {
            zzcex.zzb.execute(new zzb(context, s, adRequest, n, appOpenAdLoadCallback));
            return;
        }
        new zzbcn(context, s, adRequest.a(), n, appOpenAdLoadCallback).zza();
    }
    
    public static void load(final Context context, final String s, final AdManagerAdRequest adManagerAdRequest, @AppOpenAdOrientation final int n, final AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.l(context, "Context cannot be null.");
        Preconditions.l(s, "adUnitId cannot be null.");
        Preconditions.l(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbhy.zzc(context);
        if ((boolean)zzbjm.zzd.zze() && (boolean)zzay.c().zzb(zzbhy.zziq)) {
            zzcex.zzb.execute(new zza(context, s, adManagerAdRequest, n, appOpenAdLoadCallback));
            return;
        }
        new zzbcn(context, s, adManagerAdRequest.a(), n, appOpenAdLoadCallback).zza();
    }
    
    public abstract String getAdUnitId();
    
    public abstract FullScreenContentCallback getFullScreenContentCallback();
    
    public abstract OnPaidEventListener getOnPaidEventListener();
    
    public abstract ResponseInfo getResponseInfo();
    
    public abstract void setFullScreenContentCallback(final FullScreenContentCallback p0);
    
    public abstract void setImmersiveMode(final boolean p0);
    
    public abstract void setOnPaidEventListener(final OnPaidEventListener p0);
    
    public abstract void show(final Activity p0);
    
    public abstract static class AppOpenAdLoadCallback extends AdLoadCallback<AppOpenAd>
    {
    }
    
    public @interface AppOpenAdOrientation {
    }
}
