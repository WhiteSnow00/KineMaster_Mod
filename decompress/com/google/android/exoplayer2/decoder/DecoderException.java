// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

public class DecoderException extends Exception
{
    public DecoderException(final String s) {
        super(s);
    }
    
    public DecoderException(final String s, final Throwable t) {
        super(s, t);
    }
    
    public DecoderException(final Throwable t) {
        super(t);
    }
}
