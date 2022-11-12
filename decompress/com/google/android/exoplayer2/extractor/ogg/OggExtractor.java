// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import q3.a;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public class OggExtractor implements Extractor
{
    public static final ExtractorsFactory d;
    private ExtractorOutput a;
    private g b;
    private boolean c;
    
    static {
        d = (ExtractorsFactory)a.b;
    }
    
    public static Extractor[] c() {
        return f();
    }
    
    private static Extractor[] f() {
        return new Extractor[] { new OggExtractor() };
    }
    
    private static ParsableByteArray g(final ParsableByteArray parsableByteArray) {
        parsableByteArray.P(0);
        return parsableByteArray;
    }
    
    private boolean h(final ExtractorInput extractorInput) throws IOException {
        final d d = new d();
        if (d.a(extractorInput, true)) {
            if ((d.b & 0x2) == 0x2) {
                final int min = Math.min(d.i, 8);
                final ParsableByteArray parsableByteArray = new ParsableByteArray(min);
                extractorInput.r(parsableByteArray.d(), 0, min);
                if (com.google.android.exoplayer2.extractor.ogg.b.p(g(parsableByteArray))) {
                    this.b = new b();
                }
                else if (h.r(g(parsableByteArray))) {
                    this.b = new h();
                }
                else {
                    if (!f.p(g(parsableByteArray))) {
                        return false;
                    }
                    this.b = new f();
                }
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void a(final long n, final long n2) {
        final g b = this.b;
        if (b != null) {
            b.m(n, n2);
        }
    }
    
    @Override
    public void b(final ExtractorOutput a) {
        this.a = a;
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        try {
            return this.h(extractorInput);
        }
        catch (final ParserException ex) {
            return false;
        }
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        Assertions.i(this.a);
        if (this.b == null) {
            if (!this.h(extractorInput)) {
                throw ParserException.createForMalformedContainer("Failed to determine bitstream type", null);
            }
            extractorInput.h();
        }
        if (!this.c) {
            final TrackOutput e = this.a.e(0, 1);
            this.a.o();
            this.b.d(this.a, e);
            this.c = true;
        }
        return this.b.g(extractorInput, positionHolder);
    }
    
    @Override
    public void release() {
    }
}
