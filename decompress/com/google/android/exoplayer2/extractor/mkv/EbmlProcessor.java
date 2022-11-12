// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mkv;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.ParserException;

public interface EbmlProcessor
{
    void a(final int p0) throws ParserException;
    
    void b(final int p0, final double p1) throws ParserException;
    
    void c(final int p0, final long p1) throws ParserException;
    
    int d(final int p0);
    
    boolean e(final int p0);
    
    void f(final int p0, final int p1, final ExtractorInput p2) throws IOException;
    
    void g(final int p0, final String p1) throws ParserException;
    
    void h(final int p0, final long p1, final long p2) throws ParserException;
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ java.lang.annotation.ElementType.TYPE_USE })
    public @interface ElementType {
    }
}
