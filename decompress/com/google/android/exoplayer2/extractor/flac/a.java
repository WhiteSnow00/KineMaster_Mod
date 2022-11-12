// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.flac;

import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import java.util.Objects;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;

final class a extends BinarySearchSeeker
{
    public a(final FlacStreamMetadata flacStreamMetadata, final int n, final long n2, final long n3) {
        Objects.requireNonNull(flacStreamMetadata);
        super((SeekTimestampConverter)new m3.a(flacStreamMetadata), (TimestampSeeker)new b(flacStreamMetadata, n, null), flacStreamMetadata.f(), 0L, flacStreamMetadata.j, n2, n3, flacStreamMetadata.d(), Math.max(6, flacStreamMetadata.c));
    }
    
    private static final class b implements TimestampSeeker
    {
        private final FlacStreamMetadata a;
        private final int b;
        private final FlacFrameReader.SampleNumberHolder c;
        
        private b(final FlacStreamMetadata a, final int b) {
            this.a = a;
            this.b = b;
            this.c = new FlacFrameReader.SampleNumberHolder();
        }
        
        b(final FlacStreamMetadata flacStreamMetadata, final int n, final a$a object) {
            this(flacStreamMetadata, n);
        }
        
        private long c(final ExtractorInput extractorInput) throws IOException {
            while (extractorInput.k() < extractorInput.getLength() - 6L && !FlacFrameReader.h(extractorInput, this.a, this.b, this.c)) {
                extractorInput.m(1);
            }
            if (extractorInput.k() >= extractorInput.getLength() - 6L) {
                extractorInput.m((int)(extractorInput.getLength() - extractorInput.k()));
                return this.a.j;
            }
            return this.c.a;
        }
        
        @Override
        public TimestampSearchResult a(final ExtractorInput extractorInput, final long n) throws IOException {
            final long position = extractorInput.getPosition();
            final long c = this.c(extractorInput);
            final long k = extractorInput.k();
            extractorInput.m(Math.max(6, this.a.c));
            final long c2 = this.c(extractorInput);
            final long i = extractorInput.k();
            if (c <= n && c2 > n) {
                return TimestampSearchResult.e(k);
            }
            if (c2 <= n) {
                return TimestampSearchResult.f(c2, i);
            }
            return TimestampSearchResult.d(c, position);
        }
    }
}
