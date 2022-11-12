// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import e2.d;
import java.security.MessageDigest;
import c2.b;

public class i extends f
{
    private static final byte[] b;
    
    static {
        b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(c2.b.a);
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        messageDigest.update(i.b);
    }
    
    @Override
    protected Bitmap c(final d d, final Bitmap bitmap, final int n, final int n2) {
        return y.b(d, bitmap, n, n2);
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof i;
    }
    
    @Override
    public int hashCode() {
        return -599754482;
    }
}
