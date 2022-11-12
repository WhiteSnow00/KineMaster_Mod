// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.rewarded;

import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzcbm;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import android.content.Context;

public final class zzb implements Runnable
{
    public final Context a;
    public final String b;
    public final AdManagerAdRequest c;
    public final RewardedAdLoadCallback d;
    
    public zzb(final Context a, final String b, final AdManagerAdRequest c, final RewardedAdLoadCallback d) {
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
        final RewardedAdLoadCallback d = this.d;
        try {
            new zzcbm(a, b).zza(c.a(), d);
        }
        catch (final IllegalStateException ex) {
            zzbyx.zza(a).zzd((Throwable)ex, "RewardedAd.loadAdManager");
        }
    }
}
