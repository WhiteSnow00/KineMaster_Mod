// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcfi;
import android.util.Pair;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfuw;

final class f implements zzfuw
{
    final zzz a;
    
    f(final zzz a) {
        this.a = a;
    }
    
    public final void zza(final Throwable t) {
        zzt.p().zzt(t, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        final zzz a = this.a;
        zzf.c(zzz.Q1(a), zzz.P1(a), "sgf", new Pair((Object)"sgf_reason", (Object)t.getMessage()));
        zzcfi.zzh("Failed to initialize webview for loading SDKCore. ", t);
    }
    
    public final void zzb(final Object o) {
        final zzal zzal = (zzal)o;
        zzcfi.zze("Initialized webview successfully for SDKCore.");
    }
}
