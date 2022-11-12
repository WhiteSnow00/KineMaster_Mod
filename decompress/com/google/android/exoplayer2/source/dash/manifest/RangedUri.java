// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.UriUtil;
import android.net.Uri;

public final class RangedUri
{
    public final long a;
    public final long b;
    private final String c;
    private int d;
    
    public RangedUri(final String s, final long a, final long b) {
        String c = s;
        if (s == null) {
            c = "";
        }
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public RangedUri a(final RangedUri rangedUri, final String s) {
        final String c = this.c(s);
        if (rangedUri != null) {
            if (c.equals(rangedUri.c(s))) {
                final long b = this.b;
                long n = -1L;
                if (b != -1L) {
                    final long a = this.a;
                    if (a + b == rangedUri.a) {
                        final long b2 = rangedUri.b;
                        if (b2 != -1L) {
                            n = b + b2;
                        }
                        return new RangedUri(c, a, n);
                    }
                }
                final long b3 = rangedUri.b;
                if (b3 != -1L) {
                    final long a2 = rangedUri.a;
                    if (a2 + b3 == this.a) {
                        if (b != -1L) {
                            n = b3 + b;
                        }
                        return new RangedUri(c, a2, n);
                    }
                }
            }
        }
        return null;
    }
    
    public Uri b(final String s) {
        return UriUtil.e(s, this.c);
    }
    
    public String c(final String s) {
        return UriUtil.d(s, this.c);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && RangedUri.class == o.getClass()) {
            final RangedUri rangedUri = (RangedUri)o;
            if (this.a != rangedUri.a || this.b != rangedUri.b || !this.c.equals(rangedUri.c)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        if (this.d == 0) {
            this.d = ((527 + (int)this.a) * 31 + (int)this.b) * 31 + this.c.hashCode();
        }
        return this.d;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("RangedUri(referenceUri=");
        sb.append(this.c);
        sb.append(", start=");
        sb.append(this.a);
        sb.append(", length=");
        sb.append(this.b);
        sb.append(")");
        return sb.toString();
    }
}
