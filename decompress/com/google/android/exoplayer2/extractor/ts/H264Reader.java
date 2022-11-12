// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.util.List;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.NalUnitUtil;
import java.util.Arrays;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.TrackOutput;

public final class H264Reader implements ElementaryStreamReader
{
    private final SeiReader a;
    private final boolean b;
    private final boolean c;
    private final a d;
    private final a e;
    private final a f;
    private long g;
    private final boolean[] h;
    private String i;
    private TrackOutput j;
    private b k;
    private boolean l;
    private long m;
    private boolean n;
    private final ParsableByteArray o;
    
    public H264Reader(final SeiReader a, final boolean b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = new boolean[3];
        this.d = new a(7, 128);
        this.e = new a(8, 128);
        this.f = new a(6, 128);
        this.m = -9223372036854775807L;
        this.o = new ParsableByteArray();
    }
    
    private void a() {
        Assertions.i(this.j);
        Util.j(this.k);
    }
    
    private void g(final long n, final int n2, int q, final long n3) {
        if (!this.l || this.k.c()) {
            this.d.b(q);
            this.e.b(q);
            if (!this.l) {
                if (this.d.c() && this.e.c()) {
                    final ArrayList list = new ArrayList();
                    final a d = this.d;
                    list.add(Arrays.copyOf(d.d, d.e));
                    final a e = this.e;
                    list.add(Arrays.copyOf(e.d, e.e));
                    final a d2 = this.d;
                    final NalUnitUtil.SpsData l = NalUnitUtil.l(d2.d, 3, d2.e);
                    final a e2 = this.e;
                    final NalUnitUtil.PpsData j = NalUnitUtil.j(e2.d, 3, e2.e);
                    this.j.d(new Format.Builder().S(this.i).e0("video/avc").I(CodecSpecificDataUtil.a(l.a, l.b, l.c)).j0(l.f).Q(l.g).a0(l.h).T(list).E());
                    this.l = true;
                    this.k.f(l);
                    this.k.e(j);
                    this.d.d();
                    this.e.d();
                }
            }
            else if (this.d.c()) {
                final a d3 = this.d;
                this.k.f(NalUnitUtil.l(d3.d, 3, d3.e));
                this.d.d();
            }
            else if (this.e.c()) {
                final a e3 = this.e;
                this.k.e(NalUnitUtil.j(e3.d, 3, e3.e));
                this.e.d();
            }
        }
        if (this.f.b(q)) {
            final a f = this.f;
            q = NalUnitUtil.q(f.d, f.e);
            this.o.N(this.f.d, q);
            this.o.P(4);
            this.a.a(n3, this.o);
        }
        if (this.k.b(n, n2, this.l, this.n)) {
            this.n = false;
        }
    }
    
    private void h(final byte[] array, final int n, final int n2) {
        if (!this.l || this.k.c()) {
            this.d.a(array, n, n2);
            this.e.a(array, n, n2);
        }
        this.f.a(array, n, n2);
        this.k.a(array, n, n2);
    }
    
    private void i(final long n, final int n2, final long n3) {
        if (!this.l || this.k.c()) {
            this.d.e(n2);
            this.e.e(n2);
        }
        this.f.e(n2);
        this.k.h(n, n2, n3);
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) {
        this.a();
        int e = parsableByteArray.e();
        final int f = parsableByteArray.f();
        final byte[] d = parsableByteArray.d();
        this.g += parsableByteArray.a();
        this.j.c(parsableByteArray, parsableByteArray.a());
        while (true) {
            final int c = NalUnitUtil.c(d, e, f, this.h);
            if (c == f) {
                break;
            }
            final int f2 = NalUnitUtil.f(d, c);
            final int n = c - e;
            if (n > 0) {
                this.h(d, e, c);
            }
            final int n2 = f - c;
            final long n3 = this.g - n2;
            int n4;
            if (n < 0) {
                n4 = -n;
            }
            else {
                n4 = 0;
            }
            this.g(n3, n2, n4, this.m);
            this.i(n3, f2, this.m);
            e = c + 3;
        }
        this.h(d, e, f);
    }
    
    @Override
    public void c() {
        this.g = 0L;
        this.n = false;
        this.m = -9223372036854775807L;
        NalUnitUtil.a(this.h);
        this.d.d();
        this.e.d();
        this.f.d();
        final b k = this.k;
        if (k != null) {
            k.g();
        }
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.i = trackIdGenerator.b();
        final TrackOutput e = extractorOutput.e(trackIdGenerator.c(), 2);
        this.j = e;
        this.k = new b(e, this.b, this.c);
        this.a.b(extractorOutput, trackIdGenerator);
    }
    
    @Override
    public void e() {
    }
    
    @Override
    public void f(final long m, int n) {
        if (m != -9223372036854775807L) {
            this.m = m;
        }
        final boolean n2 = this.n;
        if ((n & 0x2) != 0x0) {
            n = 1;
        }
        else {
            n = 0;
        }
        this.n = (((n2 ? 1 : 0) | n) != 0x0);
    }
    
    private static final class b
    {
        private final TrackOutput a;
        private final boolean b;
        private final boolean c;
        private final SparseArray<NalUnitUtil.SpsData> d;
        private final SparseArray<NalUnitUtil.PpsData> e;
        private final ParsableNalUnitBitArray f;
        private byte[] g;
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private a m;
        private a n;
        private boolean o;
        private long p;
        private long q;
        private boolean r;
        
        public b(final TrackOutput a, final boolean b, final boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = (SparseArray<NalUnitUtil.SpsData>)new SparseArray();
            this.e = (SparseArray<NalUnitUtil.PpsData>)new SparseArray();
            this.m = new a(null);
            this.n = new a(null);
            final byte[] g = new byte[128];
            this.g = g;
            this.f = new ParsableNalUnitBitArray(g, 0, 0);
            this.g();
        }
        
        private void d(final int n) {
            final long q = this.q;
            if (q == -9223372036854775807L) {
                return;
            }
            this.a.e(q, this.r ? 1 : 0, (int)(this.j - this.p), n, null);
        }
        
        public void a(final byte[] array, int h, int g) {
            if (!this.k) {
                return;
            }
            g -= h;
            final byte[] g2 = this.g;
            final int length = g2.length;
            final int h2 = this.h;
            if (length < h2 + g) {
                this.g = Arrays.copyOf(g2, (h2 + g) * 2);
            }
            System.arraycopy(array, h, this.g, this.h, g);
            h = this.h + g;
            this.h = h;
            this.f.i(this.g, 0, h);
            if (!this.f.b(8)) {
                return;
            }
            this.f.k();
            final int e = this.f.e(2);
            this.f.l(5);
            if (!this.f.c()) {
                return;
            }
            this.f.h();
            if (!this.f.c()) {
                return;
            }
            final int h3 = this.f.h();
            if (!this.c) {
                this.k = false;
                this.n.f(h3);
                return;
            }
            if (!this.f.c()) {
                return;
            }
            final int h4 = this.f.h();
            if (this.e.indexOfKey(h4) < 0) {
                this.k = false;
                return;
            }
            final NalUnitUtil.PpsData ppsData = (NalUnitUtil.PpsData)this.e.get(h4);
            final NalUnitUtil.SpsData spsData = (NalUnitUtil.SpsData)this.d.get(ppsData.b);
            if (spsData.i) {
                if (!this.f.b(2)) {
                    return;
                }
                this.f.l(2);
            }
            if (!this.f.b(spsData.k)) {
                return;
            }
            final int e2 = this.f.e(spsData.k);
            boolean d = false;
            boolean d2 = false;
            boolean b = false;
            Label_0389: {
                if (!spsData.j) {
                    if (!this.f.b(1)) {
                        return;
                    }
                    d = this.f.d();
                    if (d) {
                        if (!this.f.b(1)) {
                            return;
                        }
                        d2 = this.f.d();
                        b = true;
                        break Label_0389;
                    }
                }
                else {
                    d = false;
                }
                b = false;
                d2 = false;
            }
            final boolean b2 = this.i == 5;
            int h5;
            if (b2) {
                if (!this.f.c()) {
                    return;
                }
                h5 = this.f.h();
            }
            else {
                h5 = 0;
            }
            h = spsData.l;
            int g3 = 0;
            int g4 = 0;
            Label_0605: {
                Label_0599: {
                    if (h == 0) {
                        if (!this.f.b(spsData.m)) {
                            return;
                        }
                        h = this.f.e(spsData.m);
                        if (ppsData.c && !d) {
                            if (!this.f.c()) {
                                return;
                            }
                            g = this.f.g();
                            break Label_0599;
                        }
                    }
                    else if (h == 1 && !spsData.n) {
                        if (!this.f.c()) {
                            return;
                        }
                        g3 = this.f.g();
                        if (!ppsData.c || d) {
                            h = 0;
                            g = (g4 = 0);
                            break Label_0605;
                        }
                        if (!this.f.c()) {
                            return;
                        }
                        g4 = this.f.g();
                        h = 0;
                        g = 0;
                        break Label_0605;
                    }
                    else {
                        h = 0;
                    }
                    g = 0;
                }
                g3 = 0;
                g4 = 0;
            }
            this.n.e(spsData, e, h3, e2, h4, d, b, d2, b2, h5, h, g, g3, g4);
            this.k = false;
        }
        
        public boolean b(final long n, int n2, final boolean b, boolean d) {
            final int i = this.i;
            final int n3 = 0;
            if (i == 9 || (this.c && H264Reader.b.a.a(this.n, this.m))) {
                if (b && this.o) {
                    this.d(n2 + (int)(n - this.j));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            if (this.b) {
                d = this.n.d();
            }
            final boolean r = this.r;
            final int j = this.i;
            if (j != 5) {
                n2 = n3;
                if (!d) {
                    return this.r = (((r ? 1 : 0) | n2) != 0x0);
                }
                n2 = n3;
                if (j != 1) {
                    return this.r = (((r ? 1 : 0) | n2) != 0x0);
                }
            }
            n2 = 1;
            return this.r = (((r ? 1 : 0) | n2) != 0x0);
        }
        
        public boolean c() {
            return this.c;
        }
        
        public void e(final NalUnitUtil.PpsData ppsData) {
            this.e.append(ppsData.a, (Object)ppsData);
        }
        
        public void f(final NalUnitUtil.SpsData spsData) {
            this.d.append(spsData.d, (Object)spsData);
        }
        
        public void g() {
            this.k = false;
            this.o = false;
            this.n.b();
        }
        
        public void h(final long j, final int i, final long l) {
            this.i = i;
            this.l = l;
            this.j = j;
            if ((this.b && i == 1) || (this.c && (i == 5 || i == 1 || i == 2))) {
                final a m = this.m;
                this.m = this.n;
                (this.n = m).b();
                this.h = 0;
                this.k = true;
            }
        }
        
        private static final class a
        {
            private boolean a;
            private boolean b;
            private NalUnitUtil.SpsData c;
            private int d;
            private int e;
            private int f;
            private int g;
            private boolean h;
            private boolean i;
            private boolean j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;
            
            private a() {
            }
            
            a(final H264Reader$a object) {
                this();
            }
            
            static boolean a(final a a, final a a2) {
                return a.c(a2);
            }
            
            private boolean c(final a a) {
                final boolean a2 = this.a;
                final boolean b = false;
                if (!a2) {
                    return false;
                }
                if (!a.a) {
                    return true;
                }
                final NalUnitUtil.SpsData spsData = Assertions.i(this.c);
                final NalUnitUtil.SpsData spsData2 = Assertions.i(a.c);
                if (this.f == a.f && this.g == a.g && this.h == a.h && (!this.i || !a.i || this.j == a.j)) {
                    final int d = this.d;
                    final int d2 = a.d;
                    if (d == d2 || (d != 0 && d2 != 0)) {
                        final int l = spsData.l;
                        if ((l != 0 || spsData2.l != 0 || (this.m == a.m && this.n == a.n)) && (l != 1 || spsData2.l != 1 || (this.o == a.o && this.p == a.p))) {
                            final boolean k = this.k;
                            if (k == a.k) {
                                boolean b2 = b;
                                if (!k) {
                                    return b2;
                                }
                                b2 = b;
                                if (this.l == a.l) {
                                    return b2;
                                }
                            }
                        }
                    }
                }
                return true;
            }
            
            public void b() {
                this.b = false;
                this.a = false;
            }
            
            public boolean d() {
                if (this.b) {
                    final int e = this.e;
                    if (e == 7 || e == 2) {
                        return true;
                    }
                }
                return false;
            }
            
            public void e(final NalUnitUtil.SpsData c, final int d, final int e, final int f, final int g, final boolean h, final boolean i, final boolean j, final boolean k, final int l, final int m, final int n, final int o, final int p14) {
                this.c = c;
                this.d = d;
                this.e = e;
                this.f = f;
                this.g = g;
                this.h = h;
                this.i = i;
                this.j = j;
                this.k = k;
                this.l = l;
                this.m = m;
                this.n = n;
                this.o = o;
                this.p = p14;
                this.a = true;
                this.b = true;
            }
            
            public void f(final int e) {
                this.e = e;
                this.b = true;
            }
        }
    }
}
