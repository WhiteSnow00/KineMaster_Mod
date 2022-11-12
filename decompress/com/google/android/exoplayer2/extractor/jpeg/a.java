// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ForwardingExtractorInput;

final class a extends ForwardingExtractorInput
{
    private final long b;
    
    public a(final ExtractorInput extractorInput, final long b) {
        super(extractorInput);
        Assertions.a(extractorInput.getPosition() >= b);
        this.b = b;
    }
    
    @Override
    public long getLength() {
        return super.getLength() - this.b;
    }
    
    @Override
    public long getPosition() {
        return super.getPosition() - this.b;
    }
    
    @Override
    public long k() {
        return super.k() - this.b;
    }
}
