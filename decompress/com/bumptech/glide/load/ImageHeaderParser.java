// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load;

import java.io.InputStream;
import e2.b;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface ImageHeaderParser
{
    ImageType a(final ByteBuffer p0) throws IOException;
    
    int b(final ByteBuffer p0, final b p1) throws IOException;
    
    ImageType c(final InputStream p0) throws IOException;
    
    int d(final InputStream p0, final b p1) throws IOException;
    
    public enum ImageType
    {
        private static final ImageType[] $VALUES;
        
        ANIMATED_WEBP(true), 
        AVIF(true), 
        GIF(true), 
        JPEG(false), 
        PNG(false), 
        PNG_A(true), 
        RAW(false), 
        UNKNOWN(false), 
        WEBP(false), 
        WEBP_A(true);
        
        private final boolean hasAlpha;
        
        private ImageType(final boolean hasAlpha) {
            this.hasAlpha = hasAlpha;
        }
        
        public boolean hasAlpha() {
            return this.hasAlpha;
        }
        
        public boolean isWebp() {
            final int n = ImageHeaderParser$a.a[this.ordinal()];
            return n == 1 || n == 2 || n == 3;
        }
    }
}
