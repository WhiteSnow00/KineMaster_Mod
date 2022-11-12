// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.admanager;

import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.internal.ads.zzbrb;
import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public abstract class AdManagerInterstitialAd extends InterstitialAd
{
    public static void load(final Context context, final String s, final AdManagerAdRequest adManagerAdRequest, final AdManagerInterstitialAdLoadCallback adManagerInterstitialAdLoadCallback) {
        Preconditions.l(context, "Context cannot be null.");
        Preconditions.l(s, "AdUnitId cannot be null.");
        Preconditions.l(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.l(adManagerInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbhy.zzc(context);
        if ((boolean)zzbjm.zzf.zze() && (boolean)zzay.c().zzb(zzbhy.zziq)) {
            zzcex.zzb.execute(new zzc(context, s, adManagerAdRequest, adManagerInterstitialAdLoadCallback));
            return;
        }
        new zzbrb(context, s).zza(adManagerAdRequest.a(), (AdLoadCallback)adManagerInterstitialAdLoadCallback);
    }
    
    public abstract AppEventListener getAppEventListener();
    
    public abstract void setAppEventListener(final AppEventListener p0);
}
