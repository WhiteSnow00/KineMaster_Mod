// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

public interface ExtractorOutput
{
    public static final ExtractorOutput n = new ExtractorOutput() {
        @Override
        public TrackOutput e(final int n, final int n2) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void l(final SeekMap seekMap) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void o() {
            throw new UnsupportedOperationException();
        }
    };
    
    TrackOutput e(final int p0, final int p1);
    
    void l(final SeekMap p0);
    
    void o();
}
