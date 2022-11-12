// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.ttml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.text.Layout$Alignment;

final class TtmlStyle
{
    private String a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private float k;
    private String l;
    private int m;
    private int n;
    private Layout$Alignment o;
    private Layout$Alignment p;
    private int q;
    private TextEmphasis r;
    private float s;
    
    public TtmlStyle() {
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.m = -1;
        this.n = -1;
        this.q = -1;
        this.s = Float.MAX_VALUE;
    }
    
    private TtmlStyle r(final TtmlStyle ttmlStyle, final boolean b) {
        if (ttmlStyle != null) {
            if (!this.c && ttmlStyle.c) {
                this.w(ttmlStyle.b);
            }
            if (this.h == -1) {
                this.h = ttmlStyle.h;
            }
            if (this.i == -1) {
                this.i = ttmlStyle.i;
            }
            if (this.a == null) {
                final String a = ttmlStyle.a;
                if (a != null) {
                    this.a = a;
                }
            }
            if (this.f == -1) {
                this.f = ttmlStyle.f;
            }
            if (this.g == -1) {
                this.g = ttmlStyle.g;
            }
            if (this.n == -1) {
                this.n = ttmlStyle.n;
            }
            if (this.o == null) {
                final Layout$Alignment o = ttmlStyle.o;
                if (o != null) {
                    this.o = o;
                }
            }
            if (this.p == null) {
                final Layout$Alignment p2 = ttmlStyle.p;
                if (p2 != null) {
                    this.p = p2;
                }
            }
            if (this.q == -1) {
                this.q = ttmlStyle.q;
            }
            if (this.j == -1) {
                this.j = ttmlStyle.j;
                this.k = ttmlStyle.k;
            }
            if (this.r == null) {
                this.r = ttmlStyle.r;
            }
            if (this.s == Float.MAX_VALUE) {
                this.s = ttmlStyle.s;
            }
            if (b && !this.e && ttmlStyle.e) {
                this.u(ttmlStyle.d);
            }
            if (b && this.m == -1) {
                final int m = ttmlStyle.m;
                if (m != -1) {
                    this.m = m;
                }
            }
        }
        return this;
    }
    
    public TtmlStyle A(final String l) {
        this.l = l;
        return this;
    }
    
    public TtmlStyle B(final boolean i) {
        this.i = (i ? 1 : 0);
        return this;
    }
    
    public TtmlStyle C(final boolean f) {
        this.f = (f ? 1 : 0);
        return this;
    }
    
    public TtmlStyle D(final Layout$Alignment p) {
        this.p = p;
        return this;
    }
    
    public TtmlStyle E(final int n) {
        this.n = n;
        return this;
    }
    
    public TtmlStyle F(final int m) {
        this.m = m;
        return this;
    }
    
    public TtmlStyle G(final float s) {
        this.s = s;
        return this;
    }
    
    public TtmlStyle H(final Layout$Alignment o) {
        this.o = o;
        return this;
    }
    
    public TtmlStyle I(final boolean q) {
        this.q = (q ? 1 : 0);
        return this;
    }
    
    public TtmlStyle J(final TextEmphasis r) {
        this.r = r;
        return this;
    }
    
    public TtmlStyle K(final boolean g) {
        this.g = (g ? 1 : 0);
        return this;
    }
    
    public TtmlStyle a(final TtmlStyle ttmlStyle) {
        return this.r(ttmlStyle, true);
    }
    
    public int b() {
        if (this.e) {
            return this.d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }
    
    public int c() {
        if (this.c) {
            return this.b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }
    
    public String d() {
        return this.a;
    }
    
    public float e() {
        return this.k;
    }
    
    public int f() {
        return this.j;
    }
    
    public String g() {
        return this.l;
    }
    
    public Layout$Alignment h() {
        return this.p;
    }
    
    public int i() {
        return this.n;
    }
    
    public int j() {
        return this.m;
    }
    
    public float k() {
        return this.s;
    }
    
    public int l() {
        final int h = this.h;
        if (h == -1 && this.i == -1) {
            return -1;
        }
        int n = false ? 1 : 0;
        final boolean b = h == 1;
        if (this.i == 1) {
            n = 2;
        }
        return (b ? 1 : 0) | n;
    }
    
    public Layout$Alignment m() {
        return this.o;
    }
    
    public boolean n() {
        final int q = this.q;
        boolean b = true;
        if (q != 1) {
            b = false;
        }
        return b;
    }
    
    public TextEmphasis o() {
        return this.r;
    }
    
    public boolean p() {
        return this.e;
    }
    
    public boolean q() {
        return this.c;
    }
    
    public boolean s() {
        final int f = this.f;
        boolean b = true;
        if (f != 1) {
            b = false;
        }
        return b;
    }
    
    public boolean t() {
        final int g = this.g;
        boolean b = true;
        if (g != 1) {
            b = false;
        }
        return b;
    }
    
    public TtmlStyle u(final int d) {
        this.d = d;
        this.e = true;
        return this;
    }
    
    public TtmlStyle v(final boolean h) {
        this.h = (h ? 1 : 0);
        return this;
    }
    
    public TtmlStyle w(final int b) {
        this.b = b;
        this.c = true;
        return this;
    }
    
    public TtmlStyle x(final String a) {
        this.a = a;
        return this;
    }
    
    public TtmlStyle y(final float k) {
        this.k = k;
        return this;
    }
    
    public TtmlStyle z(final int j) {
        this.j = j;
        return this;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface FontSizeUnit {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface RubyType {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface StyleFlags {
    }
}
