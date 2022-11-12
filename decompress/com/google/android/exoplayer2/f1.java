// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.MediaSource;

final class f1
{
    public final MediaSource.MediaPeriodId a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    
    f1(final MediaSource.MediaPeriodId a, final long b, final long c, final long d, final long e, final boolean f, final boolean g, final boolean h, final boolean i) {
        final boolean b2 = false;
        Assertions.a(!i || g);
        Assertions.a(!h || g);
        boolean b3 = false;
        Label_0096: {
            if (f) {
                b3 = b2;
                if (g) {
                    break Label_0096;
                }
                b3 = b2;
                if (h) {
                    break Label_0096;
                }
                b3 = b2;
                if (i) {
                    break Label_0096;
                }
            }
            b3 = true;
        }
        Assertions.a(b3);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    public f1 a(final long n) {
        f1 f1;
        if (n == this.c) {
            f1 = this;
        }
        else {
            f1 = new f1(this.a, this.b, n, this.d, this.e, this.f, this.g, this.h, this.i);
        }
        return f1;
    }
    
    public f1 b(final long n) {
        f1 f1;
        if (n == this.b) {
            f1 = this;
        }
        else {
            f1 = new f1(this.a, n, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }
        return f1;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && f1.class == o.getClass()) {
            final f1 f1 = (f1)o;
            if (this.b != f1.b || this.c != f1.c || this.d != f1.d || this.e != f1.e || this.f != f1.f || this.g != f1.g || this.h != f1.h || this.i != f1.i || !Util.c(this.a, f1.a)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((((((((527 + this.a.hashCode()) * 31 + (int)this.b) * 31 + (int)this.c) * 31 + (int)this.d) * 31 + (int)this.e) * 31 + (this.f ? 1 : 0)) * 31 + (this.g ? 1 : 0)) * 31 + (this.h ? 1 : 0)) * 31 + (this.i ? 1 : 0);
    }
}
