// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;

public final class zzbc
{
    public final String a;
    public final double b;
    public final double c;
    public final double d;
    public final int e;
    
    public zzbc(final String a, final double c, final double b, final double d, final int e) {
        this.a = a;
        this.c = c;
        this.b = b;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof zzbc)) {
            return false;
        }
        final zzbc zzbc = (zzbc)o;
        return Objects.b(this.a, zzbc.a) && this.b == zzbc.b && this.c == zzbc.c && this.e == zzbc.e && Double.compare(this.d, zzbc.d) == 0;
    }
    
    @Override
    public final int hashCode() {
        return Objects.c(this.a, this.b, this.c, this.d, this.e);
    }
    
    @Override
    public final String toString() {
        return Objects.d(this).a("name", this.a).a("minBound", this.c).a("maxBound", this.b).a("percent", this.d).a("count", this.e).toString();
    }
}
