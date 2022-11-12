// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import c2.f;

public class g implements f<ByteBuffer, Bitmap>
{
    private final l a;
    
    public g(final l a) {
        this.a = a;
    }
    
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((ByteBuffer)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.d((ByteBuffer)o, e);
    }
    
    public s<Bitmap> c(final ByteBuffer byteBuffer, final int n, final int n2, final e e) throws IOException {
        return this.a.g(byteBuffer, n, n2, e);
    }
    
    public boolean d(final ByteBuffer byteBuffer, final e e) {
        return this.a.q(byteBuffer);
    }
}
