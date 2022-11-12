// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.admanager;

import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.internal.ads.zzbrb;
import android.content.Context;

public final class zzc implements Runnable
{
    public final Context a;
    public final String b;
    public final AdManagerAdRequest c;
    public final AdManagerInterstitialAdLoadCallback d;
    
    public zzc(final Context a, final String b, final AdManagerAdRequest c, final AdManagerInterstitialAdLoadCallback d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        final Context a = this.a;
        final String b = this.b;
        final AdManagerAdRequest c = this.c;
        final AdManagerInterstitialAdLoadCallback d = this.d;
        try {
            new zzbrb(a, b).zza(c.a(), (AdLoadCallback)d);
        }
        catch (final IllegalStateException ex) {
            zzbyx.zza(a).zzd((Throwable)ex, "AdManagerInterstitialAd.load");
        }
    }
}
