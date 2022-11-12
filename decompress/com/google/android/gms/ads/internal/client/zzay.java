// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzbhs;
import com.google.android.gms.internal.ads.zzbhr;

public final class zzay
{
    private static final zzay d;
    private final zzbhr a;
    private final zzbhs b;
    private final zzbhw c;
    
    static {
        d = new zzay();
    }
    
    protected zzay() {
        final zzbhr a = new zzbhr();
        final zzbhs b = new zzbhs();
        final zzbhw c = new zzbhw();
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static zzbhr a() {
        return zzay.d.a;
    }
    
    public static zzbhs b() {
        return zzay.d.b;
    }
    
    public static zzbhw c() {
        return zzay.d.c;
    }
}
