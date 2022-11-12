// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

public abstract class DecoderOutputBuffer extends Buffer
{
    public long b;
    public int c;
    
    public abstract void r();
    
    public interface Owner<S extends DecoderOutputBuffer>
    {
        void a(final S p0);
    }
}
