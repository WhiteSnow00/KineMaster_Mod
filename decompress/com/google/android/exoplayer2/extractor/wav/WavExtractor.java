// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.PositionHolder;
import android.util.Pair;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.audio.WavUtil;
import java.io.IOException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import s3.a;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public final class WavExtractor implements Extractor
{
    public static final ExtractorsFactory h;
    private ExtractorOutput a;
    private TrackOutput b;
    private int c;
    private long d;
    private b e;
    private int f;
    private long g;
    
    static {
        h = (ExtractorsFactory)s3.a.b;
    }
    
    public WavExtractor() {
        this.c = 0;
        this.d = -1L;
        this.f = -1;
        this.g = -1L;
    }
    
    public static Extractor[] c() {
        return g();
    }
    
    private void f() {
        Assertions.i(this.b);
        Util.j(this.a);
    }
    
    private static Extractor[] g() {
        return new Extractor[] { new WavExtractor() };
    }
    
    private void h(final ExtractorInput extractorInput) throws IOException {
        Assertions.g(extractorInput.getPosition() == 0L);
        final int f = this.f;
        if (f != -1) {
            extractorInput.o(f);
            this.c = 4;
            return;
        }
        if (com.google.android.exoplayer2.extractor.wav.b.a(extractorInput)) {
            extractorInput.o((int)(extractorInput.k() - extractorInput.getPosition()));
            this.c = 1;
            return;
        }
        throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav file type.", null);
    }
    
    private void i(final ExtractorInput extractorInput) throws IOException {
        final com.google.android.exoplayer2.extractor.wav.a b = com.google.android.exoplayer2.extractor.wav.b.b(extractorInput);
        final int a = b.a;
        if (a == 17) {
            this.e = (b)new a(this.a, this.b, b);
        }
        else if (a == 6) {
            this.e = (b)new c(this.a, this.b, b, "audio/g711-alaw", -1);
        }
        else if (a == 7) {
            this.e = (b)new c(this.a, this.b, b, "audio/g711-mlaw", -1);
        }
        else {
            final int a2 = WavUtil.a(a, b.f);
            if (a2 == 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unsupported WAV format type: ");
                sb.append(b.a);
                throw ParserException.createForUnsupportedContainerFeature(sb.toString());
            }
            this.e = (b)new c(this.a, this.b, b, "audio/raw", a2);
        }
        this.c = 3;
    }
    
    private void j(final ExtractorInput extractorInput) throws IOException {
        this.d = com.google.android.exoplayer2.extractor.wav.b.c(extractorInput);
        this.c = 2;
    }
    
    private int k(final ExtractorInput extractorInput) throws IOException {
        final long g = this.g;
        int n = 0;
        Assertions.g(g != -1L);
        if (Assertions.e(this.e).b(extractorInput, this.g - extractorInput.getPosition())) {
            n = -1;
        }
        return n;
    }
    
    private void l(final ExtractorInput extractorInput) throws IOException {
        final Pair<Long, Long> e = com.google.android.exoplayer2.extractor.wav.b.e(extractorInput);
        this.f = ((Long)e.first).intValue();
        final long longValue = (long)e.second;
        final long d = this.d;
        long n = longValue;
        if (d != -1L) {
            n = longValue;
            if (longValue == 4294967295L) {
                n = d;
            }
        }
        this.g = this.f + n;
        final long length = extractorInput.getLength();
        if (length != -1L && this.g > length) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Data exceeds input length: ");
            sb.append(this.g);
            sb.append(", ");
            sb.append(length);
            Log.i("WavExtractor", sb.toString());
            this.g = length;
        }
        Assertions.e(this.e).a(this.f, this.g);
        this.c = 4;
    }
    
    @Override
    public void a(final long n, final long n2) {
        int c;
        if (n == 0L) {
            c = 0;
        }
        else {
            c = 4;
        }
        this.c = c;
        final b e = this.e;
        if (e != null) {
            e.c(n2);
        }
    }
    
    @Override
    public void b(final ExtractorOutput a) {
        this.a = a;
        this.b = a.e(0, 1);
        a.o();
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        return com.google.android.exoplayer2.extractor.wav.b.a(extractorInput);
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        this.f();
        final int c = this.c;
        if (c == 0) {
            this.h(extractorInput);
            return 0;
        }
        if (c == 1) {
            this.j(extractorInput);
            return 0;
        }
        if (c == 2) {
            this.i(extractorInput);
            return 0;
        }
        if (c == 3) {
            this.l(extractorInput);
            return 0;
        }
        if (c == 4) {
            return this.k(extractorInput);
        }
        throw new IllegalStateException();
    }
    
    @Override
    public void release() {
    }
    
    private static final class a implements b
    {
        private static final int[] m;
        private static final int[] n;
        private final ExtractorOutput a;
        private final TrackOutput b;
        private final com.google.android.exoplayer2.extractor.wav.a c;
        private final int d;
        private final byte[] e;
        private final ParsableByteArray f;
        private final int g;
        private final Format h;
        private int i;
        private long j;
        private int k;
        private long l;
        
        static {
            m = new int[] { -1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8 };
            n = new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767 };
        }
        
        public a(final ExtractorOutput a, final TrackOutput b, final com.google.android.exoplayer2.extractor.wav.a c) throws ParserException {
            this.a = a;
            this.b = b;
            this.c = c;
            final int max = Math.max(1, c.c / 10);
            this.g = max;
            final ParsableByteArray parsableByteArray = new ParsableByteArray(c.g);
            parsableByteArray.v();
            final int v = parsableByteArray.v();
            this.d = v;
            final int b2 = c.b;
            final int n = (c.e - b2 * 4) * 8 / (c.f * b2) + 1;
            if (v == n) {
                final int l = Util.l(max, v);
                this.e = new byte[c.e * l];
                this.f = new ParsableByteArray(l * h(v, b2));
                final int n2 = c.c * c.e * 8 / v;
                this.h = new Format.Builder().e0("audio/raw").G(n2).Z(n2).W(h(max, b2)).H(c.b).f0(c.c).Y(2).E();
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected frames per block: ");
            sb.append(n);
            sb.append("; got: ");
            sb.append(v);
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        }
        
        private void d(final byte[] array, int g, final ParsableByteArray parsableByteArray) {
            for (int i = 0; i < g; ++i) {
                for (int j = 0; j < this.c.b; ++j) {
                    this.e(array, i, j, parsableByteArray.d());
                }
            }
            g = this.g(this.d * g);
            parsableByteArray.P(0);
            parsableByteArray.O(g);
        }
        
        private void e(final byte[] array, int i, int q, final byte[] array2) {
            final com.google.android.exoplayer2.extractor.wav.a c = this.c;
            final int e = c.e;
            final int b = c.b;
            final int n = i * e + q * 4;
            final int n2 = e / b;
            int q2 = (short)((array[n + 1] & 0xFF) << 8 | (array[n] & 0xFF));
            final int min = Math.min(array[n + 2] & 0xFF, 88);
            int n3 = WavExtractor.a.n[min];
            int n4 = (i * this.d * b + q) * 2;
            array2[n4] = (byte)(q2 & 0xFF);
            array2[n4 + 1] = (byte)(q2 >> 8);
            i = 0;
            q = min;
            while (i < (n2 - 4) * 2) {
                final int n5 = array[i / 8 * b * 4 + (b * 4 + n) + i / 2 % 4] & 0xFF;
                int n6;
                if (i % 2 == 0) {
                    n6 = (n5 & 0xF);
                }
                else {
                    n6 = n5 >> 4;
                }
                int n7 = ((n6 & 0x7) * 2 + 1) * n3 >> 3;
                if ((n6 & 0x8) != 0x0) {
                    n7 = -n7;
                }
                q2 = Util.q(q2 + n7, -32768, 32767);
                n4 += b * 2;
                array2[n4] = (byte)(q2 & 0xFF);
                array2[n4 + 1] = (byte)(q2 >> 8);
                final int n8 = WavExtractor.a.m[n6];
                final int[] n9 = WavExtractor.a.n;
                q = Util.q(q + n8, 0, n9.length - 1);
                n3 = n9[q];
                ++i;
            }
        }
        
        private int f(final int n) {
            return n / (this.c.b * 2);
        }
        
        private int g(final int n) {
            return h(n, this.c.b);
        }
        
        private static int h(final int n, final int n2) {
            return n * 2 * n2;
        }
        
        private void i(final int n) {
            final long j = this.j;
            final long o0 = Util.O0(this.l, 1000000L, this.c.c);
            final int g = this.g(n);
            this.b.e(j + o0, 1, g, this.k - g, null);
            this.l += n;
            this.k -= g;
        }
        
        @Override
        public void a(final int n, final long n2) {
            this.a.l(new com.google.android.exoplayer2.extractor.wav.c(this.c, this.d, n, n2));
            this.b.d(this.h);
        }
        
        @Override
        public boolean b(final ExtractorInput extractorInput, final long n) throws IOException {
            final int n2 = Util.l(this.g - this.f(this.k), this.d) * this.c.e;
            while (true) {
                Label_0036: {
                    if (n == 0L) {
                        break Label_0036;
                    }
                    final boolean b = false;
                    while (!b) {
                        final int i = this.i;
                        if (i >= n2) {
                            break;
                        }
                        final int read = extractorInput.read(this.e, this.i, (int)Math.min(n2 - i, n));
                        if (read == -1) {
                            break Label_0036;
                        }
                        this.i += read;
                    }
                    final int n3 = this.i / this.c.e;
                    if (n3 > 0) {
                        this.d(this.e, n3, this.f);
                        this.i -= n3 * this.c.e;
                        final int f = this.f.f();
                        this.b.c(this.f, f);
                        final int k = this.k + f;
                        this.k = k;
                        final int f2 = this.f(k);
                        final int g = this.g;
                        if (f2 >= g) {
                            this.i(g);
                        }
                    }
                    if (b) {
                        final int f3 = this.f(this.k);
                        if (f3 > 0) {
                            this.i(f3);
                        }
                    }
                    return b;
                }
                final boolean b = true;
                continue;
            }
        }
        
        @Override
        public void c(final long j) {
            this.i = 0;
            this.j = j;
            this.k = 0;
            this.l = 0L;
        }
    }
    
    private interface b
    {
        void a(final int p0, final long p1) throws ParserException;
        
        boolean b(final ExtractorInput p0, final long p1) throws IOException;
        
        void c(final long p0);
    }
    
    private static final class c implements b
    {
        private final ExtractorOutput a;
        private final TrackOutput b;
        private final com.google.android.exoplayer2.extractor.wav.a c;
        private final Format d;
        private final int e;
        private long f;
        private int g;
        private long h;
        
        public c(final ExtractorOutput a, final TrackOutput b, final com.google.android.exoplayer2.extractor.wav.a c, final String s, final int n) throws ParserException {
            this.a = a;
            this.b = b;
            this.c = c;
            final int n2 = c.b * c.f / 8;
            if (c.e == n2) {
                final int c2 = c.c;
                final int n3 = c2 * n2 * 8;
                final int max = Math.max(n2, c2 * n2 / 10);
                this.e = max;
                this.d = new Format.Builder().e0(s).G(n3).Z(n3).W(max).H(c.b).f0(c.c).Y(n).E();
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected block size: ");
            sb.append(n2);
            sb.append("; got: ");
            sb.append(c.e);
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        }
        
        @Override
        public void a(final int n, final long n2) {
            this.a.l(new com.google.android.exoplayer2.extractor.wav.c(this.c, 1, n, n2));
            this.b.d(this.d);
        }
        
        @Override
        public boolean b(final ExtractorInput extractorInput, long f) throws IOException {
            long n;
            boolean b;
            while (true) {
                n = lcmp(f, 0L);
                b = true;
                if (n <= 0) {
                    break;
                }
                final int g = this.g;
                final int e = this.e;
                if (g >= e) {
                    break;
                }
                final int b2 = this.b.b(extractorInput, (int)Math.min(e - g, f), true);
                if (b2 == -1) {
                    f = 0L;
                }
                else {
                    this.g += b2;
                    f -= b2;
                }
            }
            final com.google.android.exoplayer2.extractor.wav.a c = this.c;
            final int e2 = c.e;
            final int n2 = this.g / e2;
            if (n2 > 0) {
                f = this.f;
                final long o0 = Util.O0(this.h, 1000000L, c.c);
                final int n3 = n2 * e2;
                final int g2 = this.g - n3;
                this.b.e(f + o0, 1, n3, g2, null);
                this.h += n2;
                this.g = g2;
            }
            if (n > 0) {
                b = false;
            }
            return b;
        }
        
        @Override
        public void c(final long f) {
            this.f = f;
            this.g = 0;
            this.h = 0L;
        }
    }
}
