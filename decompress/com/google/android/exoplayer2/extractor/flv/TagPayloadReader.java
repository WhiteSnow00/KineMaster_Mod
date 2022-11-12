// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.TrackOutput;

abstract class TagPayloadReader
{
    protected final TrackOutput a;
    
    protected TagPayloadReader(final TrackOutput a) {
        this.a = a;
    }
    
    public final boolean a(final ParsableByteArray parsableByteArray, final long n) throws ParserException {
        return this.b(parsableByteArray) && this.c(parsableByteArray, n);
    }
    
    protected abstract boolean b(final ParsableByteArray p0) throws ParserException;
    
    protected abstract boolean c(final ParsableByteArray p0, final long p1) throws ParserException;
    
    public static final class UnsupportedFormatException extends ParserException
    {
        public UnsupportedFormatException(final String s) {
            super(s, null, false, 1);
        }
    }
}
