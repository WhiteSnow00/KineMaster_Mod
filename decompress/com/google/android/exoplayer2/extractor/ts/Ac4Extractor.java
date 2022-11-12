// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.PositionHolder;
import java.io.IOException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import r3.b;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public final class Ac4Extractor implements Extractor
{
    public static final ExtractorsFactory d;
    private final Ac4Reader a;
    private final ParsableByteArray b;
    private boolean c;
    
    static {
        d = (ExtractorsFactory)b.b;
    }
    
    public Ac4Extractor() {
        this.a = new Ac4Reader();
        this.b = new ParsableByteArray(16384);
    }
    
    public static Extractor[] c() {
        return f();
    }
    
    private static Extractor[] f() {
        return new Extractor[] { new Ac4Extractor() };
    }
    
    @Override
    public void a(final long n, final long n2) {
        this.c = false;
        this.a.c();
    }
    
    @Override
    public void b(final ExtractorOutput extractorOutput) {
        this.a.d(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.o();
        extractorOutput.l(new SeekMap.Unseekable(-9223372036854775807L));
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int n = 0;
        while (true) {
            extractorInput.r(parsableByteArray.d(), 0, 10);
            parsableByteArray.P(0);
            if (parsableByteArray.G() != 4801587) {
                break;
            }
            parsableByteArray.Q(3);
            final int c = parsableByteArray.C();
            n += c + 10;
            extractorInput.m(c);
        }
        extractorInput.h();
        extractorInput.m(n);
        int n2 = 0;
        int n3 = n;
        while (true) {
            extractorInput.r(parsableByteArray.d(), 0, 7);
            parsableByteArray.P(0);
            final int j = parsableByteArray.J();
            if (j != 44096 && j != 44097) {
                extractorInput.h();
                if (++n3 - n >= 8192) {
                    return false;
                }
                extractorInput.m(n3);
                n2 = 0;
            }
            else {
                if (++n2 >= 4) {
                    return true;
                }
                final int e = Ac4Util.e(parsableByteArray.d(), j);
                if (e == -1) {
                    return false;
                }
                extractorInput.m(e - 7);
            }
        }
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final int read = extractorInput.read(this.b.d(), 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.b.P(0);
        this.b.O(read);
        if (!this.c) {
            this.a.f(0L, 4);
            this.c = true;
        }
        this.a.b(this.b);
        return 0;
    }
    
    @Override
    public void release() {
    }
}
