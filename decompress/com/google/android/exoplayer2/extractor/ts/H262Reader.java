// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.Arrays;
import com.google.android.exoplayer2.Format;
import android.util.Pair;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.TrackOutput;

public final class H262Reader implements ElementaryStreamReader
{
    private static final double[] q;
    private String a;
    private TrackOutput b;
    private final f c;
    private final ParsableByteArray d;
    private final com.google.android.exoplayer2.extractor.ts.a e;
    private final boolean[] f;
    private final a g;
    private long h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;
    
    static {
        q = new double[] { 23.976023976023978, 24.0, 25.0, 29.97002997002997, 30.0, 50.0, 59.94005994005994, 60.0 };
    }
    
    public H262Reader() {
        this(null);
    }
    
    H262Reader(final f c) {
        this.c = c;
        this.f = new boolean[4];
        this.g = new a(128);
        if (c != null) {
            this.e = new com.google.android.exoplayer2.extractor.ts.a(178, 128);
            this.d = new ParsableByteArray();
        }
        else {
            this.e = null;
            this.d = null;
        }
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }
    
    private static Pair<Format, Long> a(final a a, final String s) {
        final byte[] copy = Arrays.copyOf(a.d, a.b);
        final byte b = copy[4];
        final int n = copy[5] & 0xFF;
        final byte b2 = copy[6];
        final int n2 = (b & 0xFF) << 4 | n >> 4;
        final int n3 = (n & 0xF) << 8 | (b2 & 0xFF);
        final int n4 = (copy[7] & 0xF0) >> 4;
        float n5 = 0.0f;
        Label_0162: {
            float n6;
            int n7;
            if (n4 != 2) {
                if (n4 != 3) {
                    if (n4 != 4) {
                        n5 = 1.0f;
                        break Label_0162;
                    }
                    n6 = (float)(n3 * 121);
                    n7 = n2 * 100;
                }
                else {
                    n6 = (float)(n3 * 16);
                    n7 = n2 * 9;
                }
            }
            else {
                n6 = (float)(n3 * 4);
                n7 = n2 * 3;
            }
            n5 = n6 / n7;
        }
        final Format e = new Format.Builder().S(s).e0("video/mpeg2").j0(n2).Q(n3).a0(n5).T(Collections.singletonList(copy)).E();
        final long n8 = 0L;
        final int n9 = (copy[7] & 0xF) - 1;
        long n10 = n8;
        if (n9 >= 0) {
            final double[] q = H262Reader.q;
            n10 = n8;
            if (n9 < q.length) {
                final double n11 = q[n9];
                final int n12 = a.c + 9;
                final int n13 = (copy[n12] & 0x60) >> 5;
                final int n14 = copy[n12] & 0x1F;
                double n15 = n11;
                if (n13 != n14) {
                    n15 = n11 * ((n13 + 1.0) / (n14 + 1));
                }
                n10 = (long)(1000000.0 / n15);
            }
        }
        return (Pair<Format, Long>)Pair.create((Object)e, (Object)n10);
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) {
        Assertions.i(this.b);
        int e = parsableByteArray.e();
        final int f = parsableByteArray.f();
        final byte[] d = parsableByteArray.d();
        this.h += parsableByteArray.a();
        this.b.c(parsableByteArray, parsableByteArray.a());
        while (true) {
            final int c = NalUnitUtil.c(d, e, f, this.f);
            if (c == f) {
                break;
            }
            final byte[] d2 = parsableByteArray.d();
            final int n = c + 3;
            final int n2 = d2[n] & 0xFF;
            final int n3 = c - e;
            final boolean j = this.j;
            boolean p = false;
            if (!j) {
                if (n3 > 0) {
                    this.g.a(d, e, c);
                }
                int n4;
                if (n3 < 0) {
                    n4 = -n3;
                }
                else {
                    n4 = 0;
                }
                if (this.g.b(n2, n4)) {
                    final Pair<Format, Long> a = a(this.g, Assertions.e(this.a));
                    this.b.d((Format)a.first);
                    this.k = (long)a.second;
                    this.j = true;
                }
            }
            final com.google.android.exoplayer2.extractor.ts.a e2 = this.e;
            if (e2 != null) {
                int n5;
                if (n3 > 0) {
                    e2.a(d, e, c);
                    n5 = 0;
                }
                else {
                    n5 = -n3;
                }
                if (this.e.b(n5)) {
                    final com.google.android.exoplayer2.extractor.ts.a e3 = this.e;
                    Util.j(this.d).N(this.e.d, NalUnitUtil.q(e3.d, e3.e));
                    Util.j(this.c).a(this.n, this.d);
                }
                if (n2 == 178 && parsableByteArray.d()[c + 2] == 1) {
                    this.e.e(n2);
                }
            }
            if (n2 != 0 && n2 != 179) {
                if (n2 == 184) {
                    this.o = true;
                }
            }
            else {
                final int n6 = f - c;
                if (this.p && this.j) {
                    final long n7 = this.n;
                    if (n7 != -9223372036854775807L) {
                        this.b.e(n7, this.o ? 1 : 0, (int)(this.h - this.m) - n6, n6, null);
                    }
                }
                if (!this.i || this.p) {
                    this.m = this.h - n6;
                    long l = this.l;
                    if (l == -9223372036854775807L) {
                        final long n8 = this.n;
                        if (n8 != -9223372036854775807L) {
                            l = n8 + this.k;
                        }
                        else {
                            l = -9223372036854775807L;
                        }
                    }
                    this.n = l;
                    this.o = false;
                    this.l = -9223372036854775807L;
                    this.i = true;
                }
                if (n2 == 0) {
                    p = true;
                }
                this.p = p;
            }
            e = n;
        }
        if (!this.j) {
            this.g.a(d, e, f);
        }
        final com.google.android.exoplayer2.extractor.ts.a e4 = this.e;
        if (e4 != null) {
            e4.a(d, e, f);
        }
    }
    
    @Override
    public void c() {
        NalUnitUtil.a(this.f);
        this.g.c();
        final com.google.android.exoplayer2.extractor.ts.a e = this.e;
        if (e != null) {
            e.d();
        }
        this.h = 0L;
        this.i = false;
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.a = trackIdGenerator.b();
        this.b = extractorOutput.e(trackIdGenerator.c(), 2);
        final f c = this.c;
        if (c != null) {
            c.b(extractorOutput, trackIdGenerator);
        }
    }
    
    @Override
    public void e() {
    }
    
    @Override
    public void f(final long l, final int n) {
        this.l = l;
    }
    
    private static final class a
    {
        private static final byte[] e;
        private boolean a;
        public int b;
        public int c;
        public byte[] d;
        
        static {
            e = new byte[] { 0, 0, 1 };
        }
        
        public a(final int n) {
            this.d = new byte[n];
        }
        
        public void a(final byte[] array, final int n, int n2) {
            if (!this.a) {
                return;
            }
            n2 -= n;
            final byte[] d = this.d;
            final int length = d.length;
            final int b = this.b;
            if (length < b + n2) {
                this.d = Arrays.copyOf(d, (b + n2) * 2);
            }
            System.arraycopy(array, n, this.d, this.b, n2);
            this.b += n2;
        }
        
        public boolean b(final int n, int n2) {
            if (this.a) {
                n2 = this.b - n2;
                this.b = n2;
                if (this.c != 0 || n != 181) {
                    this.a = false;
                    return true;
                }
                this.c = n2;
            }
            else if (n == 179) {
                this.a = true;
            }
            final byte[] e = H262Reader.a.e;
            this.a(e, 0, e.length);
            return false;
        }
        
        public void c() {
            this.a = false;
            this.b = 0;
            this.c = 0;
        }
    }
}
