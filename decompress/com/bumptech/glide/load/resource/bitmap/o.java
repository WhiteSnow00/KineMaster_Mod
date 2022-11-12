// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.InputStream;
import java.io.IOException;
import v2.a;
import e2.b;
import java.nio.ByteBuffer;
import com.bumptech.glide.load.ImageHeaderParser;

public final class o implements ImageHeaderParser
{
    @Override
    public ImageType a(final ByteBuffer byteBuffer) {
        return ImageType.UNKNOWN;
    }
    
    @Override
    public int b(final ByteBuffer byteBuffer, final b b) throws IOException {
        return this.d(a.g(byteBuffer), b);
    }
    
    @Override
    public ImageType c(final InputStream inputStream) {
        return ImageType.UNKNOWN;
    }
    
    @Override
    public int d(final InputStream inputStream, final b b) throws IOException {
        int e;
        if ((e = new androidx.exifinterface.media.a(inputStream).e("Orientation", 1)) == 0) {
            e = -1;
        }
        return e;
    }
}
