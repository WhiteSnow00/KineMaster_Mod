// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.appopen;

import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.ads.AdRequest;
import android.content.Context;

public final class zzb implements Runnable
{
    public final Context a;
    public final String b;
    public final AdRequest c;
    public final int d;
    public final AppOpenAd.AppOpenAdLoadCallback e;
    
    public zzb(final Context a, final String b, final AdRequest c, final int d, final AppOpenAd.AppOpenAdLoadCallback e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public final void run() {
        final Context a = this.a;
        final String b = this.b;
        final AdRequest c = this.c;
        final int d = this.d;
        final AppOpenAd.AppOpenAdLoadCallback e = this.e;
        try {
            new zzbcn(a, b, c.a(), d, e).zza();
        }
        catch (final IllegalStateException ex) {
            zzbyx.zza(a).zzd((Throwable)ex, "AppOpenAd.load");
        }
    }
}
