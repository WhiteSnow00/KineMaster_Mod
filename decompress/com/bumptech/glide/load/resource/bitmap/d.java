// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder;
import j2.a;
import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import e2.e;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder$Source;
import c2.f;

public final class d implements f<ImageDecoder$Source, Bitmap>
{
    private final e2.d a;
    
    public d() {
        this.a = new e();
    }
    
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final c2.e e) throws IOException {
        return this.c((ImageDecoder$Source)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final c2.e e) throws IOException {
        return this.d((ImageDecoder$Source)o, e);
    }
    
    public s<Bitmap> c(final ImageDecoder$Source imageDecoder$Source, final int n, final int n2, final c2.e e) throws IOException {
        final Bitmap decodeBitmap = ImageDecoder.decodeBitmap(imageDecoder$Source, (ImageDecoder$OnHeaderDecodedListener)new a(n, n2, e));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Decoded [");
            sb.append(decodeBitmap.getWidth());
            sb.append("x");
            sb.append(decodeBitmap.getHeight());
            sb.append("] for [");
            sb.append(n);
            sb.append("x");
            sb.append(n2);
            sb.append("]");
            Log.v("BitmapImageDecoder", sb.toString());
        }
        return new com.bumptech.glide.load.resource.bitmap.e(decodeBitmap, this.a);
    }
    
    public boolean d(final ImageDecoder$Source imageDecoder$Source, final c2.e e) throws IOException {
        return true;
    }
}
