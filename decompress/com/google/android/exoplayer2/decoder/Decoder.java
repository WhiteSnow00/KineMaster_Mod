// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

public interface Decoder<I, O, E extends DecoderException>
{
    O b() throws E, DecoderException;
    
    void c(final I p0) throws E, DecoderException;
    
    I d() throws E, DecoderException;
    
    void flush();
    
    String getName();
    
    void release();
}
