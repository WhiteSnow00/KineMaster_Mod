// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import java.security.MessageDigest;
import v2.k;
import c2.e;
import c2.h;
import java.util.Map;
import c2.b;

class l implements b
{
    private final Object b;
    private final int c;
    private final int d;
    private final Class<?> e;
    private final Class<?> f;
    private final b g;
    private final Map<Class<?>, h<?>> h;
    private final e i;
    private int j;
    
    l(final Object o, final b b, final int c, final int d, final Map<Class<?>, h<?>> map, final Class<?> clazz, final Class<?> clazz2, final e e) {
        this.b = k.d(o);
        this.g = k.e(b, "Signature must not be null");
        this.c = c;
        this.d = d;
        this.h = k.d(map);
        this.e = k.e(clazz, "Resource class must not be null");
        this.f = k.e(clazz2, "Transcode class must not be null");
        this.i = k.d(e);
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof l;
        boolean b3;
        final boolean b2 = b3 = false;
        if (b) {
            final l l = (l)o;
            b3 = b2;
            if (this.b.equals(l.b)) {
                b3 = b2;
                if (this.g.equals(l.g)) {
                    b3 = b2;
                    if (this.d == l.d) {
                        b3 = b2;
                        if (this.c == l.c) {
                            b3 = b2;
                            if (this.h.equals(l.h)) {
                                b3 = b2;
                                if (this.e.equals(l.e)) {
                                    b3 = b2;
                                    if (this.f.equals(l.f)) {
                                        b3 = b2;
                                        if (this.i.equals(l.i)) {
                                            b3 = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return b3;
    }
    
    @Override
    public int hashCode() {
        if (this.j == 0) {
            final int hashCode = this.b.hashCode();
            this.j = hashCode;
            final int j = ((hashCode * 31 + this.g.hashCode()) * 31 + this.c) * 31 + this.d;
            this.j = j;
            final int i = j * 31 + this.h.hashCode();
            this.j = i;
            final int k = i * 31 + this.e.hashCode();
            this.j = k;
            final int l = k * 31 + this.f.hashCode();
            this.j = l;
            this.j = l * 31 + this.i.hashCode();
        }
        return this.j;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("EngineKey{model=");
        sb.append(this.b);
        sb.append(", width=");
        sb.append(this.c);
        sb.append(", height=");
        sb.append(this.d);
        sb.append(", resourceClass=");
        sb.append(this.e);
        sb.append(", transcodeClass=");
        sb.append(this.f);
        sb.append(", signature=");
        sb.append(this.g);
        sb.append(", hashCode=");
        sb.append(this.j);
        sb.append(", transformations=");
        sb.append(this.h);
        sb.append(", options=");
        sb.append(this.i);
        sb.append('}');
        return sb.toString();
    }
}
