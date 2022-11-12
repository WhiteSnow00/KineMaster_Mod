// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import v2.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import c2.e;
import v2.h;
import c2.b;

final class u implements b
{
    private static final h<Class<?>, byte[]> j;
    private final e2.b b;
    private final b c;
    private final b d;
    private final int e;
    private final int f;
    private final Class<?> g;
    private final e h;
    private final c2.h<?> i;
    
    static {
        j = new h<Class<?>, byte[]>(50L);
    }
    
    u(final e2.b b, final b c, final b d, final int e, final int f, final c2.h<?> i, final Class<?> g, final e h) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.i = i;
        this.g = g;
        this.h = h;
    }
    
    private byte[] c() {
        final h<Class<?>, byte[]> j = u.j;
        byte[] bytes;
        if ((bytes = j.g(this.g)) == null) {
            bytes = this.g.getName().getBytes(c2.b.a);
            j.k(this.g, bytes);
        }
        return bytes;
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        final byte[] array = this.b.d(8, byte[].class);
        ByteBuffer.wrap(array).putInt(this.e).putInt(this.f).array();
        this.d.b(messageDigest);
        this.c.b(messageDigest);
        messageDigest.update(array);
        final c2.h<?> i = this.i;
        if (i != null) {
            i.b(messageDigest);
        }
        this.h.b(messageDigest);
        messageDigest.update(this.c());
        this.b.put(array);
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof u;
        boolean b3;
        final boolean b2 = b3 = false;
        if (b) {
            final u u = (u)o;
            b3 = b2;
            if (this.f == u.f) {
                b3 = b2;
                if (this.e == u.e) {
                    b3 = b2;
                    if (l.d(this.i, u.i)) {
                        b3 = b2;
                        if (this.g.equals(u.g)) {
                            b3 = b2;
                            if (this.c.equals(u.c)) {
                                b3 = b2;
                                if (this.d.equals(u.d)) {
                                    b3 = b2;
                                    if (this.h.equals(u.h)) {
                                        b3 = true;
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
        final int n = ((this.c.hashCode() * 31 + this.d.hashCode()) * 31 + this.e) * 31 + this.f;
        final c2.h<?> i = this.i;
        int n2 = n;
        if (i != null) {
            n2 = n * 31 + i.hashCode();
        }
        return (n2 * 31 + this.g.hashCode()) * 31 + this.h.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ResourceCacheKey{sourceKey=");
        sb.append(this.c);
        sb.append(", signature=");
        sb.append(this.d);
        sb.append(", width=");
        sb.append(this.e);
        sb.append(", height=");
        sb.append(this.f);
        sb.append(", decodedResourceClass=");
        sb.append(this.g);
        sb.append(", transformation='");
        sb.append(this.i);
        sb.append('\'');
        sb.append(", options=");
        sb.append(this.h);
        sb.append('}');
        return sb.toString();
    }
}
