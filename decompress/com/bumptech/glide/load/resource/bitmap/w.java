// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import v2.l;
import android.graphics.Bitmap;
import e2.d;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import v2.k;
import c2.b;

public final class w extends f
{
    private static final byte[] c;
    private final int b;
    
    static {
        c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(b.a);
    }
    
    public w(final int b) {
        k.a(b > 0, "roundingRadius must be greater than 0.");
        this.b = b;
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        messageDigest.update(w.c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }
    
    @Override
    protected Bitmap c(final d d, final Bitmap bitmap, final int n, final int n2) {
        return y.o(d, bitmap, this.b);
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof w;
        boolean b2 = false;
        if (b) {
            final w w = (w)o;
            b2 = b2;
            if (this.b == w.b) {
                b2 = true;
            }
        }
        return b2;
    }
    
    @Override
    public int hashCode() {
        return l.o(-569625254, l.n(this.b));
    }
}
