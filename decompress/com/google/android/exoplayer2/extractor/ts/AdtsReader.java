// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableBitArray;

public final class AdtsReader implements ElementaryStreamReader
{
    private static final byte[] v;
    private final boolean a;
    private final ParsableBitArray b;
    private final ParsableByteArray c;
    private final String d;
    private String e;
    private TrackOutput f;
    private TrackOutput g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private TrackOutput t;
    private long u;
    
    static {
        v = new byte[] { 73, 68, 51 };
    }
    
    public AdtsReader(final boolean b) {
        this(b, null);
    }
    
    public AdtsReader(final boolean a, final String d) {
        this.b = new ParsableBitArray(new byte[7]);
        this.c = new ParsableByteArray(Arrays.copyOf(AdtsReader.v, 10));
        this.s();
        this.m = -1;
        this.n = -1;
        this.q = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.a = a;
        this.d = d;
    }
    
    private void a() {
        Assertions.e(this.f);
        Util.j(this.t);
        Util.j(this.g);
    }
    
    private void g(final ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() == 0) {
            return;
        }
        this.b.a[0] = parsableByteArray.d()[parsableByteArray.e()];
        this.b.p(2);
        final int h = this.b.h(4);
        final int n = this.n;
        if (n != -1 && h != n) {
            this.q();
            return;
        }
        if (!this.l) {
            this.l = true;
            this.m = this.o;
            this.n = h;
        }
        this.t();
    }
    
    private boolean h(final ParsableByteArray parsableByteArray, int n) {
        parsableByteArray.P(n + 1);
        final byte[] a = this.b.a;
        final boolean b = true;
        boolean b2 = true;
        if (!this.w(parsableByteArray, a, 1)) {
            return false;
        }
        this.b.p(4);
        final int h = this.b.h(1);
        final int m = this.m;
        if (m != -1 && h != m) {
            return false;
        }
        if (this.n != -1) {
            if (!this.w(parsableByteArray, this.b.a, 1)) {
                return true;
            }
            this.b.p(2);
            if (this.b.h(4) != this.n) {
                return false;
            }
            parsableByteArray.P(n + 2);
        }
        if (!this.w(parsableByteArray, this.b.a, 4)) {
            return true;
        }
        this.b.p(14);
        final int h2 = this.b.h(13);
        if (h2 < 7) {
            return false;
        }
        final byte[] d = parsableByteArray.d();
        final int f = parsableByteArray.f();
        n += h2;
        if (n >= f) {
            return true;
        }
        if (d[n] == -1) {
            if (++n == f) {
                return true;
            }
            if (!this.l((byte)(-1), d[n]) || (d[n] & 0x8) >> 3 != h) {
                b2 = false;
            }
            return b2;
        }
        else {
            if (d[n] != 73) {
                return false;
            }
            final int n2 = n + 1;
            if (n2 == f) {
                return true;
            }
            if (d[n2] != 68) {
                return false;
            }
            n += 2;
            return n == f || (d[n] == 51 && b);
        }
    }
    
    private boolean i(final ParsableByteArray parsableByteArray, final byte[] array, final int n) {
        final int min = Math.min(parsableByteArray.a(), n - this.i);
        parsableByteArray.j(array, this.i, min);
        final int i = this.i + min;
        this.i = i;
        return i == n;
    }
    
    private void j(final ParsableByteArray parsableByteArray) {
        final byte[] d = parsableByteArray.d();
        int i = parsableByteArray.e();
        while (i < parsableByteArray.f()) {
            final int n = i + 1;
            final int n2 = d[i] & 0xFF;
            if (this.j == 512 && this.l((byte)(-1), (byte)n2) && (this.l || this.h(parsableByteArray, n - 2))) {
                this.o = (n2 & 0x8) >> 3;
                boolean k = true;
                if ((n2 & 0x1) != 0x0) {
                    k = false;
                }
                this.k = k;
                if (!this.l) {
                    this.r();
                }
                else {
                    this.t();
                }
                parsableByteArray.P(n);
                return;
            }
            final int j = this.j;
            final int n3 = n2 | j;
            if (n3 != 329) {
                if (n3 != 511) {
                    if (n3 != 836) {
                        if (n3 == 1075) {
                            this.u();
                            parsableByteArray.P(n);
                            return;
                        }
                        i = n;
                        if (j == 256) {
                            continue;
                        }
                        this.j = 256;
                        i = n - 1;
                    }
                    else {
                        this.j = 1024;
                        i = n;
                    }
                }
                else {
                    this.j = 512;
                    i = n;
                }
            }
            else {
                this.j = 768;
                i = n;
            }
        }
        parsableByteArray.P(i);
    }
    
    private boolean l(final byte b, final byte b2) {
        return m((b & 0xFF) << 8 | (b2 & 0xFF));
    }
    
    public static boolean m(final int n) {
        return (n & 0xFFF6) == 0xFFF0;
    }
    
    private void n() throws ParserException {
        this.b.p(0);
        if (!this.p) {
            final int n = this.b.h(2) + 1;
            int n2;
            if ((n2 = n) != 2) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Detected audio object type: ");
                sb.append(n);
                sb.append(", but assuming AAC LC.");
                Log.i("AdtsReader", sb.toString());
                n2 = 2;
            }
            this.b.r(5);
            final byte[] b = AacUtil.b(n2, this.n, this.b.h(3));
            final AacUtil.Config f = AacUtil.f(b);
            final Format e = new Format.Builder().S(this.e).e0("audio/mp4a-latm").I(f.c).H(f.b).f0(f.a).T(Collections.singletonList(b)).V(this.d).E();
            this.q = 1024000000L / e.K;
            this.f.d(e);
            this.p = true;
        }
        else {
            this.b.r(10);
        }
        this.b.r(4);
        int n3 = this.b.h(13) - 2 - 5;
        if (this.k) {
            n3 -= 2;
        }
        this.v(this.f, this.q, 0, n3);
    }
    
    private void o() {
        this.g.c(this.c, 10);
        this.c.P(6);
        this.v(this.g, 0L, 10, this.c.C() + 10);
    }
    
    private void p(final ParsableByteArray parsableByteArray) {
        final int min = Math.min(parsableByteArray.a(), this.r - this.i);
        this.t.c(parsableByteArray, min);
        final int i = this.i + min;
        this.i = i;
        final int r = this.r;
        if (i == r) {
            final long s = this.s;
            if (s != -9223372036854775807L) {
                this.t.e(s, 1, r, 0, null);
                this.s += this.u;
            }
            this.s();
        }
    }
    
    private void q() {
        this.l = false;
        this.s();
    }
    
    private void r() {
        this.h = 1;
        this.i = 0;
    }
    
    private void s() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }
    
    private void t() {
        this.h = 3;
        this.i = 0;
    }
    
    private void u() {
        this.h = 2;
        this.i = AdtsReader.v.length;
        this.r = 0;
        this.c.P(0);
    }
    
    private void v(final TrackOutput t, final long u, final int i, final int r) {
        this.h = 4;
        this.i = i;
        this.t = t;
        this.u = u;
        this.r = r;
    }
    
    private boolean w(final ParsableByteArray parsableByteArray, final byte[] array, final int n) {
        if (parsableByteArray.a() < n) {
            return false;
        }
        parsableByteArray.j(array, 0, n);
        return true;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) throws ParserException {
        this.a();
        while (parsableByteArray.a() > 0) {
            final int h = this.h;
            if (h != 0) {
                if (h != 1) {
                    if (h != 2) {
                        if (h != 3) {
                            if (h != 4) {
                                throw new IllegalStateException();
                            }
                            this.p(parsableByteArray);
                        }
                        else {
                            int n;
                            if (this.k) {
                                n = 7;
                            }
                            else {
                                n = 5;
                            }
                            if (!this.i(parsableByteArray, this.b.a, n)) {
                                continue;
                            }
                            this.n();
                        }
                    }
                    else {
                        if (!this.i(parsableByteArray, this.c.d(), 10)) {
                            continue;
                        }
                        this.o();
                    }
                }
                else {
                    this.g(parsableByteArray);
                }
            }
            else {
                this.j(parsableByteArray);
            }
        }
    }
    
    @Override
    public void c() {
        this.s = -9223372036854775807L;
        this.q();
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.e = trackIdGenerator.b();
        final TrackOutput e = extractorOutput.e(trackIdGenerator.c(), 1);
        this.f = e;
        this.t = e;
        if (this.a) {
            trackIdGenerator.a();
            (this.g = extractorOutput.e(trackIdGenerator.c(), 5)).d(new Format.Builder().S(trackIdGenerator.b()).e0("application/id3").E());
        }
        else {
            this.g = new DummyTrackOutput();
        }
    }
    
    @Override
    public void e() {
    }
    
    @Override
    public void f(final long s, final int n) {
        if (s != -9223372036854775807L) {
            this.s = s;
        }
    }
    
    public long k() {
        return this.q;
    }
}
