// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzajk;
import com.google.android.gms.internal.ads.zzajf;

final class f implements zzajf
{
    final String a;
    final h b;
    
    f(final zzbo zzbo, final String a, final h b) {
        this.a = a;
        this.b = b;
    }
    
    public final void zza(final zzajk zzajk) {
        final String a = this.a;
        final String string = ((Throwable)zzajk).toString();
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed to load URL: ");
        sb.append(a);
        sb.append("\n");
        sb.append(string);
        zzcfi.zzj(sb.toString());
        this.b.zza(null);
    }
}
