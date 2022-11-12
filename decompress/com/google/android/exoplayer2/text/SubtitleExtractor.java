// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.IndexSeekMap;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.primitives.Ints;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.io.InterruptedIOException;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.util.List;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.Extractor;

public class SubtitleExtractor implements Extractor
{
    private final SubtitleDecoder a;
    private final CueEncoder b;
    private final ParsableByteArray c;
    private final Format d;
    private final List<Long> e;
    private final List<ParsableByteArray> f;
    private ExtractorOutput g;
    private TrackOutput h;
    private int i;
    private int j;
    private long k;
    
    public SubtitleExtractor(final SubtitleDecoder a, final Format format) {
        this.a = a;
        this.b = new CueEncoder();
        this.c = new ParsableByteArray();
        this.d = format.b().e0("text/x-exoplayer-cues").I(format.w).E();
        this.e = new ArrayList<Long>();
        this.f = new ArrayList<ParsableByteArray>();
        this.j = 0;
        this.k = -9223372036854775807L;
    }
    
    private void c() throws IOException {
        try {
            SubtitleInputBuffer subtitleInputBuffer;
            for (subtitleInputBuffer = ((Decoder<SubtitleInputBuffer, O, E>)this.a).d(); subtitleInputBuffer == null; subtitleInputBuffer = ((Decoder<SubtitleInputBuffer, O, E>)this.a).d()) {
                Thread.sleep(5L);
            }
            subtitleInputBuffer.s(this.i);
            final ByteBuffer d = subtitleInputBuffer.d;
            final byte[] d2 = this.c.d();
            final int i = this.i;
            final int n = 0;
            d.put(d2, 0, i);
            subtitleInputBuffer.d.limit(this.i);
            ((Decoder<SubtitleInputBuffer, O, E>)this.a).c(subtitleInputBuffer);
            SubtitleOutputBuffer subtitleOutputBuffer = ((Decoder<I, SubtitleOutputBuffer, E>)this.a).b();
            int j;
            while (true) {
                j = n;
                if (subtitleOutputBuffer != null) {
                    break;
                }
                Thread.sleep(5L);
                subtitleOutputBuffer = ((Decoder<I, SubtitleOutputBuffer, E>)this.a).b();
            }
            while (j < subtitleOutputBuffer.f()) {
                final byte[] a = this.b.a(subtitleOutputBuffer.c(subtitleOutputBuffer.d(j)));
                this.e.add(subtitleOutputBuffer.d(j));
                this.f.add(new ParsableByteArray(a));
                ++j;
            }
            subtitleOutputBuffer.r();
        }
        catch (final SubtitleDecoderException ex) {
            throw ParserException.createForMalformedContainer("SubtitleDecoder failed.", ex);
        }
        catch (final InterruptedException ex2) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
    
    private boolean f(final ExtractorInput extractorInput) throws IOException {
        final int b = this.c.b();
        final int i = this.i;
        if (b == i) {
            this.c.c(i + 1024);
        }
        final int read = extractorInput.read(this.c.d(), this.i, this.c.b() - this.i);
        if (read != -1) {
            this.i += read;
        }
        final long length = extractorInput.getLength();
        return (length != -1L && this.i == length) || read == -1;
    }
    
    private boolean g(final ExtractorInput extractorInput) throws IOException {
        int d;
        if (extractorInput.getLength() != -1L) {
            d = Ints.d(extractorInput.getLength());
        }
        else {
            d = 1024;
        }
        return extractorInput.a(d) == -1;
    }
    
    private void h() {
        Assertions.i(this.h);
        Assertions.g(this.e.size() == this.f.size());
        final long k = this.k;
        int i;
        if (k == -9223372036854775807L) {
            i = 0;
        }
        else {
            i = Util.g(this.e, k, true, true);
        }
        while (i < this.f.size()) {
            final ParsableByteArray parsableByteArray = this.f.get(i);
            parsableByteArray.P(0);
            final int length = parsableByteArray.d().length;
            this.h.c(parsableByteArray, length);
            this.h.e(this.e.get(i), 1, length, 0, null);
            ++i;
        }
    }
    
    @Override
    public void a(final long n, final long k) {
        final int j = this.j;
        Assertions.g(j != 0 && j != 5);
        this.k = k;
        if (this.j == 2) {
            this.j = 1;
        }
        if (this.j == 4) {
            this.j = 3;
        }
    }
    
    @Override
    public void b(final ExtractorOutput g) {
        Assertions.g(this.j == 0);
        this.g = g;
        this.h = g.e(0, 3);
        this.g.o();
        this.g.l(new IndexSeekMap(new long[] { 0L }, new long[] { 0L }, -9223372036854775807L));
        this.h.d(this.d);
        this.j = 1;
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        return true;
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final int j = this.j;
        Assertions.g(j != 0 && j != 5);
        if (this.j == 1) {
            final ParsableByteArray c = this.c;
            int d;
            if (extractorInput.getLength() != -1L) {
                d = Ints.d(extractorInput.getLength());
            }
            else {
                d = 1024;
            }
            c.L(d);
            this.i = 0;
            this.j = 2;
        }
        if (this.j == 2 && this.f(extractorInput)) {
            this.c();
            this.h();
            this.j = 4;
        }
        if (this.j == 3 && this.g(extractorInput)) {
            this.h();
            this.j = 4;
        }
        if (this.j == 4) {
            return -1;
        }
        return 0;
    }
    
    @Override
    public void release() {
        if (this.j == 5) {
            return;
        }
        this.a.release();
        this.j = 5;
    }
}
