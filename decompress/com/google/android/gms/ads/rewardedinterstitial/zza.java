// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.rewardedinterstitial;

import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzcbx;
import com.google.android.gms.ads.AdRequest;
import android.content.Context;

public final class zza implements Runnable
{
    public final Context a;
    public final String b;
    public final AdRequest c;
    public final RewardedInterstitialAdLoadCallback d;
    
    public zza(final Context a, final String b, final AdRequest c, final RewardedInterstitialAdLoadCallback d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        final Context a = this.a;
        final String b = this.b;
        final AdRequest c = this.c;
        final RewardedInterstitialAdLoadCallback d = this.d;
        try {
            new zzcbx(a, b).zza(c.a(), d);
        }
        catch (final IllegalStateException ex) {
            zzbyx.zza(a).zzd((Throwable)ex, "RewardedInterstitialAd.load");
        }
    }
}
