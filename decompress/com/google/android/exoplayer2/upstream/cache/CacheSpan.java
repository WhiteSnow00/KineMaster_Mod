// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import java.io.File;

public class CacheSpan implements Comparable<CacheSpan>
{
    public final String a;
    public final long b;
    public final long c;
    public final boolean d;
    public final File e;
    public final long f;
    
    public CacheSpan(final String a, final long b, final long c, final long f, final File e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = (e != null);
        this.e = e;
        this.f = f;
    }
    
    public int a(final CacheSpan cacheSpan) {
        if (!this.a.equals(cacheSpan.a)) {
            return this.a.compareTo(cacheSpan.a);
        }
        final long n = lcmp(this.b - cacheSpan.b, 0L);
        int n2;
        if (n == 0) {
            n2 = 0;
        }
        else if (n < 0) {
            n2 = -1;
        }
        else {
            n2 = 1;
        }
        return n2;
    }
    
    public boolean c() {
        return this.d ^ true;
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.a((CacheSpan)o);
    }
    
    public boolean d() {
        return this.c == -1L;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.c);
        sb.append("]");
        return sb.toString();
    }
}
