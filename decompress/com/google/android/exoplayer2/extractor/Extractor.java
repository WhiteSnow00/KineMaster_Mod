// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.io.IOException;

public interface Extractor
{
    void a(final long p0, final long p1);
    
    void b(final ExtractorOutput p0);
    
    boolean d(final ExtractorInput p0) throws IOException;
    
    int e(final ExtractorInput p0, final PositionHolder p1) throws IOException;
    
    void release();
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface ReadResult {
    }
}
