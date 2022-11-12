// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import java.security.MessageDigest;
import c2.b;

final class c implements b
{
    private final b b;
    private final b c;
    
    c(final b b, final b c) {
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        this.b.b(messageDigest);
        this.c.b(messageDigest);
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof c;
        boolean b3;
        final boolean b2 = b3 = false;
        if (b) {
            final c c = (c)o;
            b3 = b2;
            if (this.b.equals(c.b)) {
                b3 = b2;
                if (this.c.equals(c.c)) {
                    b3 = true;
                }
            }
        }
        return b3;
    }
    
    @Override
    public int hashCode() {
        return this.b.hashCode() * 31 + this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DataCacheKey{sourceKey=");
        sb.append(this.b);
        sb.append(", signature=");
        sb.append(this.c);
        sb.append('}');
        return sb.toString();
    }
}
