// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaij;
import java.util.Collections;
import com.google.android.gms.internal.ads.zzajf;
import com.google.android.gms.internal.ads.zzajg;
import com.google.android.gms.internal.ads.zzcfh;
import java.util.Map;
import com.google.android.gms.internal.ads.zzakg;

final class g extends zzakg
{
    final byte[] a;
    final Map b;
    final zzcfh c;
    
    g(final zzbo zzbo, final int n, final String s, final zzajg zzajg, final zzajf zzajf, final byte[] a, final Map b, final zzcfh c) {
        this.a = a;
        this.b = b;
        this.c = c;
        super(n, s, zzajg, zzajf);
    }
    
    public final Map zzl() throws zzaij {
        Map<Object, Object> map;
        if ((map = this.b) == null) {
            map = Collections.emptyMap();
        }
        return map;
    }
    
    protected final /* bridge */ void zzo(final Object o) {
        this.zzz((String)o);
    }
    
    public final byte[] zzx() throws zzaij {
        byte[] a;
        if ((a = this.a) == null) {
            a = null;
        }
        return a;
    }
    
    protected final void zzz(final String s) {
        this.c.zzg(s);
        super.zzz(s);
    }
}
