// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.PositionHolder;

public final class BundledHlsMediaChunkExtractor implements HlsMediaChunkExtractor
{
    private static final PositionHolder d;
    final Extractor a;
    private final Format b;
    private final TimestampAdjuster c;
    
    static {
        d = new PositionHolder();
    }
    
    public BundledHlsMediaChunkExtractor(final Extractor a, final Format b, final TimestampAdjuster c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public boolean a(final ExtractorInput extractorInput) throws IOException {
        return this.a.e(extractorInput, BundledHlsMediaChunkExtractor.d) == 0;
    }
    
    @Override
    public void b(final ExtractorOutput extractorOutput) {
        this.a.b(extractorOutput);
    }
    
    @Override
    public void c() {
        this.a.a(0L, 0L);
    }
    
    @Override
    public boolean d() {
        final Extractor a = this.a;
        return a instanceof TsExtractor || a instanceof FragmentedMp4Extractor;
    }
    
    @Override
    public boolean e() {
        final Extractor a = this.a;
        return a instanceof AdtsExtractor || a instanceof Ac3Extractor || a instanceof Ac4Extractor || a instanceof Mp3Extractor;
    }
    
    @Override
    public HlsMediaChunkExtractor f() {
        Assertions.g(this.d() ^ true);
        final Extractor a = this.a;
        Extractor extractor;
        if (a instanceof WebvttExtractor) {
            extractor = new WebvttExtractor(this.b.c, this.c);
        }
        else if (a instanceof AdtsExtractor) {
            extractor = new AdtsExtractor();
        }
        else if (a instanceof Ac3Extractor) {
            extractor = new Ac3Extractor();
        }
        else if (a instanceof Ac4Extractor) {
            extractor = new Ac4Extractor();
        }
        else {
            if (!(a instanceof Mp3Extractor)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpected extractor type for recreation: ");
                sb.append(this.a.getClass().getSimpleName());
                throw new IllegalStateException(sb.toString());
            }
            extractor = new Mp3Extractor();
        }
        return new BundledHlsMediaChunkExtractor(extractor, this.b, this.c);
    }
}
