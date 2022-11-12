// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

import java.nio.ByteBuffer;

public class SimpleDecoderOutputBuffer extends DecoderOutputBuffer
{
    private final Owner<SimpleDecoderOutputBuffer> d;
    public ByteBuffer e;
    
    @Override
    public void h() {
        super.h();
        final ByteBuffer e = this.e;
        if (e != null) {
            e.clear();
        }
    }
    
    @Override
    public void r() {
        this.d.a(this);
    }
}
