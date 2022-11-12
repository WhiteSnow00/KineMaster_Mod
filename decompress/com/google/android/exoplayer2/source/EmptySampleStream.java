// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;

public final class EmptySampleStream implements SampleStream
{
    @Override
    public void a() {
    }
    
    @Override
    public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
        decoderInputBuffer.q(4);
        return -4;
    }
    
    @Override
    public boolean isReady() {
        return true;
    }
    
    @Override
    public int l(final long n) {
        return 0;
    }
}
