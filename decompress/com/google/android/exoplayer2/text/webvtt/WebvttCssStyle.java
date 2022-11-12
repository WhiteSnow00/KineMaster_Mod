// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.webvtt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.util.HashSet;
import java.util.Arrays;
import com.google.common.base.Ascii;
import java.util.Collection;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Set;

public final class WebvttCssStyle
{
    private String a;
    private String b;
    private Set<String> c;
    private String d;
    private String e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float o;
    private int p;
    private boolean q;
    
    public WebvttCssStyle() {
        this.a = "";
        this.b = "";
        this.c = Collections.emptySet();
        this.d = "";
        this.e = null;
        this.g = false;
        this.i = false;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.p = -1;
        this.q = false;
    }
    
    private static int B(final int n, final String s, final String s2, final int n2) {
        if (!s.isEmpty()) {
            int n3 = -1;
            if (n != -1) {
                if (s.equals(s2)) {
                    n3 = n + n2;
                }
                return n3;
            }
        }
        return n;
    }
    
    public WebvttCssStyle A(final boolean k) {
        this.k = (k ? 1 : 0);
        return this;
    }
    
    public int a() {
        if (this.i) {
            return this.h;
        }
        throw new IllegalStateException("Background color not defined.");
    }
    
    public boolean b() {
        return this.q;
    }
    
    public int c() {
        if (this.g) {
            return this.f;
        }
        throw new IllegalStateException("Font color not defined");
    }
    
    public String d() {
        return this.e;
    }
    
    public float e() {
        return this.o;
    }
    
    public int f() {
        return this.n;
    }
    
    public int g() {
        return this.p;
    }
    
    public int h(final String s, final String s2, final Set<String> set, final String s3) {
        if (this.a.isEmpty() && this.b.isEmpty() && this.c.isEmpty() && this.d.isEmpty()) {
            return TextUtils.isEmpty((CharSequence)s2) ? 1 : 0;
        }
        final int b = B(B(B(0, this.a, s, 1073741824), this.b, s2, 2), this.d, s3, 4);
        if (b != -1 && set.containsAll(this.c)) {
            return b + this.c.size() * 4;
        }
        return 0;
    }
    
    public int i() {
        final int l = this.l;
        if (l == -1 && this.m == -1) {
            return -1;
        }
        int n = false ? 1 : 0;
        final boolean b = l == 1;
        if (this.m == 1) {
            n = 2;
        }
        return (b ? 1 : 0) | n;
    }
    
    public boolean j() {
        return this.i;
    }
    
    public boolean k() {
        return this.g;
    }
    
    public boolean l() {
        final int j = this.j;
        boolean b = true;
        if (j != 1) {
            b = false;
        }
        return b;
    }
    
    public boolean m() {
        final int k = this.k;
        boolean b = true;
        if (k != 1) {
            b = false;
        }
        return b;
    }
    
    public WebvttCssStyle n(final int h) {
        this.h = h;
        this.i = true;
        return this;
    }
    
    public WebvttCssStyle o(final boolean l) {
        this.l = (l ? 1 : 0);
        return this;
    }
    
    public WebvttCssStyle p(final boolean q) {
        this.q = q;
        return this;
    }
    
    public WebvttCssStyle q(final int f) {
        this.f = f;
        this.g = true;
        return this;
    }
    
    public WebvttCssStyle r(String e) {
        if (e == null) {
            e = null;
        }
        else {
            e = Ascii.e(e);
        }
        this.e = e;
        return this;
    }
    
    public WebvttCssStyle s(final float o) {
        this.o = o;
        return this;
    }
    
    public WebvttCssStyle t(final int n) {
        this.n = n;
        return this;
    }
    
    public WebvttCssStyle u(final boolean m) {
        this.m = (m ? 1 : 0);
        return this;
    }
    
    public WebvttCssStyle v(final int p) {
        this.p = p;
        return this;
    }
    
    public void w(final String[] array) {
        this.c = new HashSet<String>(Arrays.asList(array));
    }
    
    public void x(final String a) {
        this.a = a;
    }
    
    public void y(final String b) {
        this.b = b;
    }
    
    public void z(final String d) {
        this.d = d;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface FontSizeUnit {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface StyleFlags {
    }
}
