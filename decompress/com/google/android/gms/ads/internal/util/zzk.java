// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzfnu;
import com.google.android.gms.ads.internal.zzt;
import android.content.Context;
import com.google.android.gms.internal.ads.zzcfa;

public final class zzk implements zzcfa
{
    public final Context a;
    public final String b;
    
    public zzk(final Context a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public final boolean zza(final String s) {
        final Context a = this.a;
        final String b = this.b;
        final zzfnu i = zzs.i;
        zzt.q();
        zzs.g(a, b, s);
        return true;
    }
}
