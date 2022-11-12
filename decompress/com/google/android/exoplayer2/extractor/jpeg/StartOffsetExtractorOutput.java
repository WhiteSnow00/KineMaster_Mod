// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;

public final class StartOffsetExtractorOutput implements ExtractorOutput
{
    private final long a;
    private final ExtractorOutput b;
    
    public StartOffsetExtractorOutput(final long a, final ExtractorOutput b) {
        this.a = a;
        this.b = b;
    }
    
    static long a(final StartOffsetExtractorOutput startOffsetExtractorOutput) {
        return startOffsetExtractorOutput.a;
    }
    
    @Override
    public TrackOutput e(final int n, final int n2) {
        return this.b.e(n, n2);
    }
    
    @Override
    public void l(final SeekMap seekMap) {
        this.b.l(new SeekMap(this, seekMap) {
            final SeekMap a;
            final StartOffsetExtractorOutput b;
            
            @Override
            public SeekPoints f(final long n) {
                final SeekPoints f = this.a.f(n);
                final SeekPoint a = f.a;
                final SeekPoint seekPoint = new SeekPoint(a.a, a.b + StartOffsetExtractorOutput.a(this.b));
                final SeekPoint b = f.b;
                return new SeekPoints(seekPoint, new SeekPoint(b.a, b.b + StartOffsetExtractorOutput.a(this.b)));
            }
            
            @Override
            public boolean h() {
                return this.a.h();
            }
            
            @Override
            public long i() {
                return this.a.i();
            }
        });
    }
    
    @Override
    public void o() {
        this.b.o();
    }
}
