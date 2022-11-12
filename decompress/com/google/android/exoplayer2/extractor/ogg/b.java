// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;

final class b extends g
{
    private FlacStreamMetadata n;
    private a o;
    
    private int n(final ParsableByteArray parsableByteArray) {
        final int n = (parsableByteArray.d()[2] & 0xFF) >> 4;
        if (n == 6 || n == 7) {
            parsableByteArray.Q(4);
            parsableByteArray.K();
        }
        final int j = FlacFrameReader.j(parsableByteArray, n);
        parsableByteArray.P(0);
        return j;
    }
    
    private static boolean o(final byte[] array) {
        boolean b = false;
        if (array[0] == -1) {
            b = true;
        }
        return b;
    }
    
    public static boolean p(final ParsableByteArray parsableByteArray) {
        return parsableByteArray.a() >= 5 && parsableByteArray.D() == 127 && parsableByteArray.F() == 1179402563L;
    }
    
    @Override
    protected long f(final ParsableByteArray parsableByteArray) {
        if (!o(parsableByteArray.d())) {
            return -1L;
        }
        return this.n(parsableByteArray);
    }
    
    @Override
    protected boolean i(final ParsableByteArray parsableByteArray, final long n, final g.b b) {
        final byte[] d = parsableByteArray.d();
        final FlacStreamMetadata n2 = this.n;
        if (n2 == null) {
            final FlacStreamMetadata n3 = new FlacStreamMetadata(d, 17);
            this.n = n3;
            b.a = n3.g(Arrays.copyOfRange(d, 9, parsableByteArray.f()), null);
            return true;
        }
        if ((d[0] & 0x7F) == 0x3) {
            final FlacStreamMetadata.SeekTable g = FlacMetadataReader.g(parsableByteArray);
            final FlacStreamMetadata b2 = n2.b(g);
            this.n = b2;
            this.o = new a(b2, g);
            return true;
        }
        if (o(d)) {
            final a o = this.o;
            if (o != null) {
                o.d(n);
                b.b = this.o;
            }
            Assertions.e(b.a);
            return false;
        }
        return true;
    }
    
    @Override
    protected void l(final boolean b) {
        super.l(b);
        if (b) {
            this.n = null;
            this.o = null;
        }
    }
    
    private static final class a implements e
    {
        private FlacStreamMetadata a;
        private FlacStreamMetadata.SeekTable b;
        private long c;
        private long d;
        
        public a(final FlacStreamMetadata a, final FlacStreamMetadata.SeekTable b) {
            this.a = a;
            this.b = b;
            this.c = -1L;
            this.d = -1L;
        }
        
        @Override
        public long a(final ExtractorInput extractorInput) {
            final long d = this.d;
            if (d >= 0L) {
                final long n = -(d + 2L);
                this.d = -1L;
                return n;
            }
            return -1L;
        }
        
        @Override
        public SeekMap b() {
            Assertions.g(this.c != -1L);
            return new FlacSeekTableSeekMap(this.a, this.c);
        }
        
        @Override
        public void c(final long n) {
            final long[] a = this.b.a;
            this.d = a[Util.i(a, n, true, true)];
        }
        
        public void d(final long c) {
            this.c = c;
        }
    }
}
