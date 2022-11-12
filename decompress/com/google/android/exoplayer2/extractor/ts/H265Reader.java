// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.util.Collections;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.TrackOutput;

public final class H265Reader implements ElementaryStreamReader
{
    private final SeiReader a;
    private String b;
    private TrackOutput c;
    private a d;
    private boolean e;
    private final boolean[] f;
    private final com.google.android.exoplayer2.extractor.ts.a g;
    private final com.google.android.exoplayer2.extractor.ts.a h;
    private final com.google.android.exoplayer2.extractor.ts.a i;
    private final com.google.android.exoplayer2.extractor.ts.a j;
    private final com.google.android.exoplayer2.extractor.ts.a k;
    private long l;
    private long m;
    private final ParsableByteArray n;
    
    public H265Reader(final SeiReader a) {
        this.a = a;
        this.f = new boolean[3];
        this.g = new com.google.android.exoplayer2.extractor.ts.a(32, 128);
        this.h = new com.google.android.exoplayer2.extractor.ts.a(33, 128);
        this.i = new com.google.android.exoplayer2.extractor.ts.a(34, 128);
        this.j = new com.google.android.exoplayer2.extractor.ts.a(39, 128);
        this.k = new com.google.android.exoplayer2.extractor.ts.a(40, 128);
        this.m = -9223372036854775807L;
        this.n = new ParsableByteArray();
    }
    
    private void a() {
        Assertions.i(this.c);
        Util.j(this.d);
    }
    
    private void g(final long n, int n2, final int n3, final long n4) {
        this.d.a(n, n2, this.e);
        if (!this.e) {
            this.g.b(n3);
            this.h.b(n3);
            this.i.b(n3);
            if (this.g.c() && this.h.c() && this.i.c()) {
                this.c.d(i(this.b, this.g, this.h, this.i));
                this.e = true;
            }
        }
        if (this.j.b(n3)) {
            final com.google.android.exoplayer2.extractor.ts.a j = this.j;
            n2 = NalUnitUtil.q(j.d, j.e);
            this.n.N(this.j.d, n2);
            this.n.Q(5);
            this.a.a(n4, this.n);
        }
        if (this.k.b(n3)) {
            final com.google.android.exoplayer2.extractor.ts.a k = this.k;
            n2 = NalUnitUtil.q(k.d, k.e);
            this.n.N(this.k.d, n2);
            this.n.Q(5);
            this.a.a(n4, this.n);
        }
    }
    
    private void h(final byte[] array, final int n, final int n2) {
        this.d.e(array, n, n2);
        if (!this.e) {
            this.g.a(array, n, n2);
            this.h.a(array, n, n2);
            this.i.a(array, n, n2);
        }
        this.j.a(array, n, n2);
        this.k.a(array, n, n2);
    }
    
    private static Format i(final String s, final com.google.android.exoplayer2.extractor.ts.a a, final com.google.android.exoplayer2.extractor.ts.a a2, final com.google.android.exoplayer2.extractor.ts.a a3) {
        final int e = a.e;
        final byte[] array = new byte[a2.e + e + a3.e];
        System.arraycopy(a.d, 0, array, 0, e);
        System.arraycopy(a2.d, 0, array, a.e, a2.e);
        System.arraycopy(a3.d, 0, array, a.e + a2.e, a3.e);
        final ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(a2.d, 0, a2.e);
        parsableNalUnitBitArray.l(44);
        final int e2 = parsableNalUnitBitArray.e(3);
        parsableNalUnitBitArray.k();
        final int e3 = parsableNalUnitBitArray.e(2);
        final boolean d = parsableNalUnitBitArray.d();
        final int e4 = parsableNalUnitBitArray.e(5);
        int i = 0;
        int n = 0;
        while (i < 32) {
            int n2 = n;
            if (parsableNalUnitBitArray.d()) {
                n2 = (n | 1 << i);
            }
            ++i;
            n = n2;
        }
        final int[] array2 = new int[6];
        for (int j = 0; j < 6; ++j) {
            array2[j] = parsableNalUnitBitArray.e(8);
        }
        final int e5 = parsableNalUnitBitArray.e(8);
        int k = 0;
        int n3 = 0;
        while (k < e2) {
            int n4 = n3;
            if (parsableNalUnitBitArray.d()) {
                n4 = n3 + 89;
            }
            n3 = n4;
            if (parsableNalUnitBitArray.d()) {
                n3 = n4 + 8;
            }
            ++k;
        }
        parsableNalUnitBitArray.l(n3);
        if (e2 > 0) {
            parsableNalUnitBitArray.l((8 - e2) * 2);
        }
        parsableNalUnitBitArray.h();
        final int h = parsableNalUnitBitArray.h();
        if (h == 3) {
            parsableNalUnitBitArray.k();
        }
        final int h2 = parsableNalUnitBitArray.h();
        final int h3 = parsableNalUnitBitArray.h();
        int n5 = h2;
        int n6 = h3;
        if (parsableNalUnitBitArray.d()) {
            final int h4 = parsableNalUnitBitArray.h();
            final int h5 = parsableNalUnitBitArray.h();
            final int h6 = parsableNalUnitBitArray.h();
            final int h7 = parsableNalUnitBitArray.h();
            int n7;
            if (h != 1 && h != 2) {
                n7 = 1;
            }
            else {
                n7 = 2;
            }
            int n8;
            if (h == 1) {
                n8 = 2;
            }
            else {
                n8 = 1;
            }
            n5 = h2 - n7 * (h4 + h5);
            n6 = h3 - n8 * (h6 + h7);
        }
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        final int h8 = parsableNalUnitBitArray.h();
        int l;
        if (parsableNalUnitBitArray.d()) {
            l = 0;
        }
        else {
            l = e2;
        }
        while (l <= e2) {
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            ++l;
        }
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        if (parsableNalUnitBitArray.d() && parsableNalUnitBitArray.d()) {
            j(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.l(2);
        if (parsableNalUnitBitArray.d()) {
            parsableNalUnitBitArray.l(8);
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.k();
        }
        k(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.d()) {
            for (int n9 = 0; n9 < parsableNalUnitBitArray.h(); ++n9) {
                parsableNalUnitBitArray.l(h8 + 4 + 1);
            }
        }
        parsableNalUnitBitArray.l(2);
        float n11;
        final float n10 = n11 = 1.0f;
        int n12 = n6;
        if (parsableNalUnitBitArray.d()) {
            float n13 = n10;
            if (parsableNalUnitBitArray.d()) {
                final int e6 = parsableNalUnitBitArray.e(8);
                if (e6 == 255) {
                    final int e7 = parsableNalUnitBitArray.e(16);
                    final int e8 = parsableNalUnitBitArray.e(16);
                    n13 = n10;
                    if (e7 != 0) {
                        n13 = n10;
                        if (e8 != 0) {
                            n13 = e7 / (float)e8;
                        }
                    }
                }
                else {
                    final float[] b = NalUnitUtil.b;
                    if (e6 < b.length) {
                        n13 = b[e6];
                    }
                    else {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected aspect_ratio_idc value: ");
                        sb.append(e6);
                        Log.i("H265Reader", sb.toString());
                        n13 = n10;
                    }
                }
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.k();
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.l(4);
                if (parsableNalUnitBitArray.d()) {
                    parsableNalUnitBitArray.l(24);
                }
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.h();
                parsableNalUnitBitArray.h();
            }
            parsableNalUnitBitArray.k();
            n11 = n13;
            n12 = n6;
            if (parsableNalUnitBitArray.d()) {
                n12 = n6 * 2;
                n11 = n13;
            }
        }
        return new Format.Builder().S(s).e0("video/hevc").I(CodecSpecificDataUtil.c(e3, d, e4, n, array2, e5)).j0(n5).Q(n12).a0(n11).T(Collections.singletonList(array)).E();
    }
    
    private static void j(final ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i = 0; i < 4; ++i) {
            int n2;
            for (int j = 0; j < 6; j += n2) {
                final boolean d = parsableNalUnitBitArray.d();
                final int n = 1;
                if (!d) {
                    parsableNalUnitBitArray.h();
                }
                else {
                    final int min = Math.min(64, 1 << (i << 1) + 4);
                    if (i > 1) {
                        parsableNalUnitBitArray.g();
                    }
                    for (int k = 0; k < min; ++k) {
                        parsableNalUnitBitArray.g();
                    }
                }
                n2 = n;
                if (i == 3) {
                    n2 = 3;
                }
            }
        }
    }
    
    private static void k(final ParsableNalUnitBitArray parsableNalUnitBitArray) {
        final int h = parsableNalUnitBitArray.h();
        int i = 0;
        int n;
        int d = n = 0;
        while (i < h) {
            if (i != 0) {
                d = (parsableNalUnitBitArray.d() ? 1 : 0);
            }
            int n3;
            if (d != 0) {
                parsableNalUnitBitArray.k();
                parsableNalUnitBitArray.h();
                int n2 = 0;
                while (true) {
                    n3 = n;
                    if (n2 > n) {
                        break;
                    }
                    if (parsableNalUnitBitArray.d()) {
                        parsableNalUnitBitArray.k();
                    }
                    ++n2;
                }
            }
            else {
                final int h2 = parsableNalUnitBitArray.h();
                final int h3 = parsableNalUnitBitArray.h();
                for (int j = 0; j < h2; ++j) {
                    parsableNalUnitBitArray.h();
                    parsableNalUnitBitArray.k();
                }
                for (int k = 0; k < h3; ++k) {
                    parsableNalUnitBitArray.h();
                    parsableNalUnitBitArray.k();
                }
                n3 = h2 + h3;
            }
            ++i;
            n = n3;
        }
    }
    
    private void l(final long n, final int n2, final int n3, final long n4) {
        this.d.g(n, n2, n3, n4, this.e);
        if (!this.e) {
            this.g.e(n3);
            this.h.e(n3);
            this.i.e(n3);
        }
        this.j.e(n3);
        this.k.e(n3);
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) {
        this.a();
        while (parsableByteArray.a() > 0) {
            int i = parsableByteArray.e();
            final int f = parsableByteArray.f();
            final byte[] d = parsableByteArray.d();
            this.l += parsableByteArray.a();
            this.c.c(parsableByteArray, parsableByteArray.a());
            while (i < f) {
                final int c = NalUnitUtil.c(d, i, f, this.f);
                if (c == f) {
                    this.h(d, i, f);
                    return;
                }
                final int e = NalUnitUtil.e(d, c);
                final int n = c - i;
                if (n > 0) {
                    this.h(d, i, c);
                }
                final int n2 = f - c;
                final long n3 = this.l - n2;
                int n4;
                if (n < 0) {
                    n4 = -n;
                }
                else {
                    n4 = 0;
                }
                this.g(n3, n2, n4, this.m);
                this.l(n3, n2, e, this.m);
                i = c + 3;
            }
        }
    }
    
    @Override
    public void c() {
        this.l = 0L;
        this.m = -9223372036854775807L;
        NalUnitUtil.a(this.f);
        this.g.d();
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        final a d = this.d;
        if (d != null) {
            d.f();
        }
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.b = trackIdGenerator.b();
        final TrackOutput e = extractorOutput.e(trackIdGenerator.c(), 2);
        this.c = e;
        this.d = new a(e);
        this.a.b(extractorOutput, trackIdGenerator);
    }
    
    @Override
    public void e() {
    }
    
    @Override
    public void f(final long m, final int n) {
        if (m != -9223372036854775807L) {
            this.m = m;
        }
    }
    
    private static final class a
    {
        private final TrackOutput a;
        private long b;
        private boolean c;
        private int d;
        private long e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private long k;
        private long l;
        private boolean m;
        
        public a(final TrackOutput a) {
            this.a = a;
        }
        
        private static boolean b(final int n) {
            return (32 <= n && n <= 35) || n == 39;
        }
        
        private static boolean c(final int n) {
            return n < 32 || n == 40;
        }
        
        private void d(final int n) {
            final long l = this.l;
            if (l == -9223372036854775807L) {
                return;
            }
            this.a.e(l, this.m ? 1 : 0, (int)(this.b - this.k), n, null);
        }
        
        public void a(final long n, final int n2, final boolean b) {
            if (this.j && this.g) {
                this.m = this.c;
                this.j = false;
            }
            else if (this.h || this.g) {
                if (b && this.i) {
                    this.d(n2 + (int)(n - this.b));
                }
                this.k = this.b;
                this.l = this.e;
                this.m = this.c;
                this.i = true;
            }
        }
        
        public void e(final byte[] array, final int n, final int n2) {
            if (this.f) {
                final int d = this.d;
                final int n3 = n + 2 - d;
                if (n3 < n2) {
                    this.g = ((array[n3] & 0x80) != 0x0);
                    this.f = false;
                }
                else {
                    this.d = d + (n2 - n);
                }
            }
        }
        
        public void f() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }
        
        public void g(final long b, final int n, final int n2, final long e, final boolean b2) {
            final boolean b3 = false;
            this.g = false;
            this.h = false;
            this.e = e;
            this.d = 0;
            this.b = b;
            if (!c(n2)) {
                if (this.i && !this.j) {
                    if (b2) {
                        this.d(n);
                    }
                    this.i = false;
                }
                if (b(n2)) {
                    this.h = (this.j ^ true);
                    this.j = true;
                }
            }
            boolean f = false;
            Label_0137: {
                if (!(this.c = (n2 >= 16 && n2 <= 21))) {
                    f = b3;
                    if (n2 > 9) {
                        break Label_0137;
                    }
                }
                f = true;
            }
            this.f = f;
        }
    }
}
