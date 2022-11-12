// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

public final class DummyExtractorOutput implements ExtractorOutput
{
    @Override
    public TrackOutput e(final int n, final int n2) {
        return new DummyTrackOutput();
    }
    
    @Override
    public void l(final SeekMap seekMap) {
    }
    
    @Override
    public void o() {
    }
}
