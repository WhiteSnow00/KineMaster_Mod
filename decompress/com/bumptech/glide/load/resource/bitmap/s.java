// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.ImageDecoder;
import v2.a;
import java.io.IOException;
import c2.e;
import android.graphics.Bitmap;
import java.io.InputStream;
import c2.f;

public final class s implements f<InputStream, Bitmap>
{
    private final d a;
    
    public s() {
        this.a = new d();
    }
    
    @Override
    public /* bridge */ com.bumptech.glide.load.engine.s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((InputStream)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.d((InputStream)o, e);
    }
    
    public com.bumptech.glide.load.engine.s<Bitmap> c(final InputStream inputStream, final int n, final int n2, final e e) throws IOException {
        return this.a.c(ImageDecoder.createSource(v2.a.b(inputStream)), n, n2, e);
    }
    
    public boolean d(final InputStream inputStream, final e e) throws IOException {
        return true;
    }
}
