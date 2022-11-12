// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzt;
import javax.annotation.concurrent.GuardedBy;

public final class zzbz
{
    private long a;
    @GuardedBy
    private long b;
    private final Object c;
    
    public zzbz(final long a) {
        this.b = Long.MIN_VALUE;
        this.c = new Object();
        this.a = a;
    }
    
    public final void a(final long a) {
        synchronized (this.c) {
            this.a = a;
        }
    }
    
    public final boolean b() {
        synchronized (this.c) {
            final long c = zzt.a().c();
            if (this.b + this.a > c) {
                return false;
            }
            this.b = c;
            return true;
        }
    }
}
