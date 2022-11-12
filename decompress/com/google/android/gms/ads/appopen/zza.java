// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.appopen;

import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import android.content.Context;

public final class zza implements Runnable
{
    public final Context a;
    public final String b;
    public final AdManagerAdRequest c;
    public final int d;
    public final AppOpenAd.AppOpenAdLoadCallback e;
    
    public zza(final Context a, final String b, final AdManagerAdRequest c, final int d, final AppOpenAd.AppOpenAdLoadCallback e) {
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
        final AdManagerAdRequest c = this.c;
        final int d = this.d;
        final AppOpenAd.AppOpenAdLoadCallback e = this.e;
        try {
            new zzbcn(a, b, c.a(), d, e).zza();
        }
        catch (final IllegalStateException ex) {
            zzbyx.zza(a).zzd((Throwable)ex, "AppOpenAdManager.load");
        }
    }
}
