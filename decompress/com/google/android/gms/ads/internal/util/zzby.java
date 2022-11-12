// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzt;
import android.content.Context;
import com.google.android.gms.internal.ads.zzcfn;

public final class zzby extends zzb
{
    private final zzcfn a;
    private final String b;
    
    public zzby(final Context context, final String s, final String b) {
        final String y = zzt.q().y(context, s);
        this.a = new zzcfn(y);
        this.b = b;
    }
    
    @Override
    public final void zza() {
        this.a.zza(this.b);
    }
}
