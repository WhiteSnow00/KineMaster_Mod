// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.common.base.Function;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.util.UUID;
import java.util.ArrayList;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import android.util.Pair;
import com.google.android.exoplayer2.util.NalUnitUtil;
import java.util.Collections;
import java.util.ArrayDeque;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.ParsableByteArray;
import android.util.SparseArray;
import java.util.List;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public class FragmentedMp4Extractor implements Extractor
{
    public static final ExtractorsFactory I;
    private static final byte[] J;
    private static final Format K;
    private int A;
    private int B;
    private int C;
    private boolean D;
    private ExtractorOutput E;
    private TrackOutput[] F;
    private TrackOutput[] G;
    private boolean H;
    private final int a;
    private final Track b;
    private final List<Format> c;
    private final SparseArray<b> d;
    private final ParsableByteArray e;
    private final ParsableByteArray f;
    private final ParsableByteArray g;
    private final byte[] h;
    private final ParsableByteArray i;
    private final TimestampAdjuster j;
    private final EventMessageEncoder k;
    private final ParsableByteArray l;
    private final ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a.a> m;
    private final ArrayDeque<a> n;
    private final TrackOutput o;
    private int p;
    private int q;
    private long r;
    private int s;
    private ParsableByteArray t;
    private long u;
    private int v;
    private long w;
    private long x;
    private long y;
    private b z;
    
    static {
        I = (ExtractorsFactory)p3.a.b;
        J = new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
        K = new Format.Builder().e0("application/x-emsg").E();
    }
    
    public FragmentedMp4Extractor() {
        this(0);
    }
    
    public FragmentedMp4Extractor(final int n) {
        this(n, null);
    }
    
    public FragmentedMp4Extractor(final int n, final TimestampAdjuster timestampAdjuster) {
        this(n, timestampAdjuster, null, Collections.emptyList());
    }
    
    public FragmentedMp4Extractor(final int n, final TimestampAdjuster timestampAdjuster, final Track track) {
        this(n, timestampAdjuster, track, Collections.emptyList());
    }
    
    public FragmentedMp4Extractor(final int n, final TimestampAdjuster timestampAdjuster, final Track track, final List<Format> list) {
        this(n, timestampAdjuster, track, list, null);
    }
    
    public FragmentedMp4Extractor(final int a, final TimestampAdjuster j, final Track b, final List<Format> list, final TrackOutput o) {
        this.a = a;
        this.j = j;
        this.b = b;
        this.c = Collections.unmodifiableList((List<? extends Format>)list);
        this.o = o;
        this.k = new EventMessageEncoder();
        this.l = new ParsableByteArray(16);
        this.e = new ParsableByteArray(NalUnitUtil.a);
        this.f = new ParsableByteArray(5);
        this.g = new ParsableByteArray();
        final byte[] h = new byte[16];
        this.h = h;
        this.i = new ParsableByteArray(h);
        this.m = new ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a.a>();
        this.n = new ArrayDeque<a>();
        this.d = (SparseArray<b>)new SparseArray();
        this.x = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.E = ExtractorOutput.n;
        this.F = new TrackOutput[0];
        this.G = new TrackOutput[0];
    }
    
    private static Pair<Long, ChunkIndex> A(final ParsableByteArray parsableByteArray, long n) throws ParserException {
        parsableByteArray.P(8);
        final int c = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        parsableByteArray.Q(4);
        final long f = parsableByteArray.F();
        long n2;
        long n3;
        if (c == 0) {
            n2 = parsableByteArray.F();
            n3 = parsableByteArray.F();
        }
        else {
            n2 = parsableByteArray.I();
            n3 = parsableByteArray.I();
        }
        n += n3;
        final long o0 = Util.O0(n2, 1000000L, f);
        parsableByteArray.Q(2);
        final int j = parsableByteArray.J();
        final int[] array = new int[j];
        final long[] array2 = new long[j];
        final long[] array3 = new long[j];
        final long[] array4 = new long[j];
        long o2 = o0;
        for (int i = 0; i < j; ++i) {
            final int n4 = parsableByteArray.n();
            if ((n4 & Integer.MIN_VALUE) != 0x0) {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
            }
            final long f2 = parsableByteArray.F();
            array[i] = (n4 & Integer.MAX_VALUE);
            array2[i] = n;
            array4[i] = o2;
            n2 += f2;
            o2 = Util.O0(n2, 1000000L, f);
            array3[i] = o2 - array4[i];
            parsableByteArray.Q(4);
            n += array[i];
        }
        return (Pair<Long, ChunkIndex>)Pair.create((Object)o0, (Object)new ChunkIndex(array, array2, array3, array4));
    }
    
    private static long B(final ParsableByteArray parsableByteArray) {
        parsableByteArray.P(8);
        long n;
        if (com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n()) == 1) {
            n = parsableByteArray.I();
        }
        else {
            n = parsableByteArray.F();
        }
        return n;
    }
    
    private static b C(final ParsableByteArray parsableByteArray, final SparseArray<b> sparseArray, final boolean b) {
        parsableByteArray.P(8);
        final int b2 = com.google.android.exoplayer2.extractor.mp4.a.b(parsableByteArray.n());
        final int n = parsableByteArray.n();
        Object o;
        if (b) {
            o = sparseArray.valueAt(0);
        }
        else {
            o = sparseArray.get(n);
        }
        final b b3 = (b)o;
        if (b3 == null) {
            return null;
        }
        if ((b2 & 0x1) != 0x0) {
            final long i = parsableByteArray.I();
            final h b4 = b3.b;
            b4.c = i;
            b4.d = i;
        }
        final c e = b3.e;
        int a;
        if ((b2 & 0x2) != 0x0) {
            a = parsableByteArray.n() - 1;
        }
        else {
            a = e.a;
        }
        int n2;
        if ((b2 & 0x8) != 0x0) {
            n2 = parsableByteArray.n();
        }
        else {
            n2 = e.b;
        }
        int n3;
        if ((b2 & 0x10) != 0x0) {
            n3 = parsableByteArray.n();
        }
        else {
            n3 = e.c;
        }
        int n4;
        if ((b2 & 0x20) != 0x0) {
            n4 = parsableByteArray.n();
        }
        else {
            n4 = e.d;
        }
        b3.b.a = new c(a, n2, n3, n4);
        return b3;
    }
    
    private static void D(final com.google.android.exoplayer2.extractor.mp4.a.a a, final SparseArray<b> sparseArray, final boolean b, int i, final byte[] array) throws ParserException {
        final b c = C(Assertions.e(a.g(1952868452)).b, sparseArray, b);
        if (c == null) {
            return;
        }
        final h b2 = c.b;
        final long q = b2.q;
        final boolean r = b2.r;
        c.k();
        FragmentedMp4Extractor.b.b(c, true);
        final com.google.android.exoplayer2.extractor.mp4.a.b g = a.g(1952867444);
        if (g != null && (i & 0x2) == 0x0) {
            b2.q = B(g.b);
            b2.r = true;
        }
        else {
            b2.q = q;
            b2.r = r;
        }
        G(a, c, i);
        final TrackEncryptionBox a2 = c.d.a.a(Assertions.e(b2.a).a);
        final com.google.android.exoplayer2.extractor.mp4.a.b g2 = a.g(1935763834);
        if (g2 != null) {
            w(Assertions.e(a2), g2.b, b2);
        }
        final com.google.android.exoplayer2.extractor.mp4.a.b g3 = a.g(1935763823);
        if (g3 != null) {
            v(g3.b, b2);
        }
        final com.google.android.exoplayer2.extractor.mp4.a.b g4 = a.g(1936027235);
        if (g4 != null) {
            z(g4.b, b2);
        }
        String b3;
        if (a2 != null) {
            b3 = a2.b;
        }
        else {
            b3 = null;
        }
        x(a, b3, b2);
        int size;
        com.google.android.exoplayer2.extractor.mp4.a.b b4;
        for (size = a.c.size(), i = 0; i < size; ++i) {
            b4 = a.c.get(i);
            if (b4.a == 1970628964) {
                H(b4.b, b2, array);
            }
        }
    }
    
    private static Pair<Integer, c> E(final ParsableByteArray parsableByteArray) {
        parsableByteArray.P(12);
        return (Pair<Integer, c>)Pair.create((Object)parsableByteArray.n(), (Object)new c(parsableByteArray.n() - 1, parsableByteArray.n(), parsableByteArray.n(), parsableByteArray.n()));
    }
    
    private static int F(final b b, int n, int n2, final ParsableByteArray parsableByteArray, int i) throws ParserException {
        parsableByteArray.P(8);
        final int b2 = com.google.android.exoplayer2.extractor.mp4.a.b(parsableByteArray.n());
        final Track a = b.d.a;
        final h b3 = b.b;
        final c c = Util.j(b3.a);
        b3.h[n] = parsableByteArray.H();
        final long[] g = b3.g;
        g[n] = b3.c;
        if ((b2 & 0x1) != 0x0) {
            g[n] += parsableByteArray.n();
        }
        final boolean b4 = (b2 & 0x4) != 0x0;
        int n3 = c.d;
        if (b4) {
            n3 = parsableByteArray.n();
        }
        final boolean b5 = (b2 & 0x100) != 0x0;
        final boolean b6 = (b2 & 0x200) != 0x0;
        final boolean b7 = (b2 & 0x400) != 0x0;
        final boolean b8 = (b2 & 0x800) != 0x0;
        final long[] h = a.h;
        long n4;
        if (h != null && h.length == 1 && h[0] == 0L) {
            n4 = Util.j(a.i)[0];
        }
        else {
            n4 = 0L;
        }
        final int[] j = b3.i;
        final long[] k = b3.j;
        final boolean[] l = b3.k;
        if (a.b == 2 && (n2 & 0x1) != 0x0) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        final int n5 = i + b3.h[n];
        final long c2 = a.c;
        long q = b3.q;
        while (i < n5) {
            if (b5) {
                n = parsableByteArray.n();
            }
            else {
                n = c.b;
            }
            final int f = f(n);
            if (b6) {
                n = parsableByteArray.n();
            }
            else {
                n = c.c;
            }
            final int f2 = f(n);
            if (b7) {
                n = parsableByteArray.n();
            }
            else if (i == 0 && b4) {
                n = n3;
            }
            else {
                n = c.d;
            }
            int n6;
            if (b8) {
                n6 = parsableByteArray.n();
            }
            else {
                n6 = 0;
            }
            k[i] = Util.O0(n6 + q - n4, 1000000L, c2);
            if (!b3.r) {
                k[i] += b.d.h;
            }
            j[i] = f2;
            l[i] = ((n >> 16 & 0x1) == 0x0 && (n2 == 0 || i == 0));
            q += f;
            ++i;
        }
        b3.q = q;
        return n5;
    }
    
    private static void G(final com.google.android.exoplayer2.extractor.mp4.a.a a, final b b, final int n) throws ParserException {
        final List<com.google.android.exoplayer2.extractor.mp4.a.b> c = a.c;
        final int size = c.size();
        final int n2 = 0;
        int i = 0;
        int n4;
        int n3 = n4 = 0;
        while (i < size) {
            final com.google.android.exoplayer2.extractor.mp4.a.b b2 = c.get(i);
            int n5 = n3;
            int n6 = n4;
            if (b2.a == 1953658222) {
                final ParsableByteArray b3 = b2.b;
                b3.P(12);
                final int h = b3.H();
                n5 = n3;
                n6 = n4;
                if (h > 0) {
                    n6 = n4 + h;
                    n5 = n3 + 1;
                }
            }
            ++i;
            n3 = n5;
            n4 = n6;
        }
        b.h = 0;
        b.g = 0;
        b.f = 0;
        b.b.e(n3, n4);
        int n7 = 0;
        int n8 = 0;
        int n9;
        int f;
        for (int j = n2; j < size; ++j, n7 = n9, n8 = f) {
            final com.google.android.exoplayer2.extractor.mp4.a.b b4 = c.get(j);
            n9 = n7;
            f = n8;
            if (b4.a == 1953658222) {
                f = F(b, n7, n, b4.b, n8);
                n9 = n7 + 1;
            }
        }
    }
    
    private static void H(final ParsableByteArray parsableByteArray, final h h, final byte[] array) throws ParserException {
        parsableByteArray.P(8);
        parsableByteArray.j(array, 0, 16);
        if (!Arrays.equals(array, FragmentedMp4Extractor.J)) {
            return;
        }
        y(parsableByteArray, 16, h);
    }
    
    private void I(final long n) throws ParserException {
        while (!this.m.isEmpty() && this.m.peek().b == n) {
            this.n(this.m.pop());
        }
        this.g();
    }
    
    private boolean J(final ExtractorInput extractorInput) throws IOException {
        if (this.s == 0) {
            if (!extractorInput.i(this.l.d(), 0, 8, true)) {
                return false;
            }
            this.s = 8;
            this.l.P(0);
            this.r = this.l.F();
            this.q = this.l.n();
        }
        final long r = this.r;
        if (r == 1L) {
            extractorInput.readFully(this.l.d(), 8, 8);
            this.s += 8;
            this.r = this.l.I();
        }
        else if (r == 0L) {
            long n2;
            final long n = n2 = extractorInput.getLength();
            if (n == -1L) {
                n2 = n;
                if (!this.m.isEmpty()) {
                    n2 = this.m.peek().b;
                }
            }
            if (n2 != -1L) {
                this.r = n2 - extractorInput.getPosition() + this.s;
            }
        }
        if (this.r < this.s) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        final long c = extractorInput.getPosition() - this.s;
        final int q = this.q;
        if ((q == 1836019558 || q == 1835295092) && !this.H) {
            this.E.l(new SeekMap.Unseekable(this.x, c));
            this.H = true;
        }
        if (this.q == 1836019558) {
            for (int size = this.d.size(), i = 0; i < size; ++i) {
                final h b = ((b)this.d.valueAt(i)).b;
                b.b = c;
                b.d = c;
                b.c = c;
            }
        }
        final int q2 = this.q;
        if (q2 == 1835295092) {
            this.z = null;
            this.u = c + this.r;
            this.p = 2;
            return true;
        }
        if (N(q2)) {
            final long n3 = extractorInput.getPosition() + this.r - 8L;
            this.m.push(new com.google.android.exoplayer2.extractor.mp4.a.a(this.q, n3));
            if (this.r == this.s) {
                this.I(n3);
            }
            else {
                this.g();
            }
        }
        else if (O(this.q)) {
            if (this.s != 8) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
            }
            final long r2 = this.r;
            if (r2 > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
            }
            final ParsableByteArray t = new ParsableByteArray((int)r2);
            System.arraycopy(this.l.d(), 0, t.d(), 0, 8);
            this.t = t;
            this.p = 1;
        }
        else {
            if (this.r > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.t = null;
            this.p = 1;
        }
        return true;
    }
    
    private void K(final ExtractorInput extractorInput) throws IOException {
        final int n = (int)this.r - this.s;
        final ParsableByteArray t = this.t;
        if (t != null) {
            extractorInput.readFully(t.d(), 8, n);
            this.p(new com.google.android.exoplayer2.extractor.mp4.a.b(this.q, t), extractorInput.getPosition());
        }
        else {
            extractorInput.o(n);
        }
        this.I(extractorInput.getPosition());
    }
    
    private void L(final ExtractorInput extractorInput) throws IOException {
        final int size = this.d.size();
        long n = Long.MAX_VALUE;
        int i = 0;
        b b = null;
        while (i < size) {
            final h b2 = ((b)this.d.valueAt(i)).b;
            long n2 = n;
            b b3 = b;
            if (b2.p) {
                final long d = b2.d;
                n2 = n;
                b3 = b;
                if (d < n) {
                    b3 = (b)this.d.valueAt(i);
                    n2 = d;
                }
            }
            ++i;
            n = n2;
            b = b3;
        }
        if (b == null) {
            this.p = 3;
            return;
        }
        final int n3 = (int)(n - extractorInput.getPosition());
        if (n3 >= 0) {
            extractorInput.o(n3);
            b.b.a(extractorInput);
            return;
        }
        throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
    }
    
    private boolean M(final ExtractorInput extractorInput) throws IOException {
        b z;
        if ((z = this.z) == null) {
            z = j(this.d);
            if (z == null) {
                final int n = (int)(this.u - extractorInput.getPosition());
                if (n >= 0) {
                    extractorInput.o(n);
                    this.g();
                    return false;
                }
                throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", null);
            }
            else {
                int n2;
                if ((n2 = (int)(z.d() - extractorInput.getPosition())) < 0) {
                    Log.i("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    n2 = 0;
                }
                extractorInput.o(n2);
                this.z = z;
            }
        }
        if (this.p == 3) {
            final int f = z.f();
            this.A = f;
            if (z.f < z.i) {
                extractorInput.o(f);
                z.m();
                if (!z.h()) {
                    this.z = null;
                }
                this.p = 3;
                return true;
            }
            if (z.d.a.g == 1) {
                this.A = f - 8;
                extractorInput.o(8);
            }
            if ("audio/ac4".equals(z.d.a.f.w)) {
                this.B = z.i(this.A, 7);
                Ac4Util.a(this.A, this.i);
                z.a.c(this.i, 7);
                this.B += 7;
            }
            else {
                this.B = z.i(this.A, 0);
            }
            this.A += this.B;
            this.p = 4;
            this.C = 0;
        }
        final Track a = z.d.a;
        final TrackOutput a2 = z.a;
        final long e = z.e();
        final TimestampAdjuster j = this.j;
        long a3 = e;
        if (j != null) {
            a3 = j.a(e);
        }
        if (a.j != 0) {
            final byte[] d = this.f.d();
            d[0] = 0;
            d[2] = (d[1] = 0);
            final int i = a.j;
            final int n3 = 4 - i;
            while (this.B < this.A) {
                final int c = this.C;
                if (c == 0) {
                    extractorInput.readFully(d, n3, i + 1);
                    this.f.P(0);
                    final int n4 = this.f.n();
                    if (n4 < 1) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                    }
                    this.C = n4 - 1;
                    this.e.P(0);
                    a2.c(this.e, 4);
                    a2.c(this.f, 1);
                    this.D = (this.G.length > 0 && NalUnitUtil.g(a.f.w, d[4]));
                    this.B += 5;
                    this.A += n3;
                }
                else {
                    int n5;
                    if (this.D) {
                        this.g.L(c);
                        extractorInput.readFully(this.g.d(), 0, this.C);
                        a2.c(this.g, this.C);
                        n5 = this.C;
                        final int q = NalUnitUtil.q(this.g.d(), this.g.f());
                        this.g.P("video/hevc".equals(a.f.w) ? 1 : 0);
                        this.g.O(q);
                        CeaUtil.a(a3, this.g, this.G);
                    }
                    else {
                        n5 = a2.b(extractorInput, c, false);
                    }
                    this.B += n5;
                    this.C -= n5;
                }
            }
        }
        else {
            while (true) {
                final int b = this.B;
                final int a4 = this.A;
                if (b >= a4) {
                    break;
                }
                this.B += a2.b(extractorInput, a4 - b, false);
            }
        }
        final int c2 = z.c();
        final TrackEncryptionBox g = z.g();
        Object c3;
        if (g != null) {
            c3 = g.c;
        }
        else {
            c3 = null;
        }
        a2.e(a3, c2, this.A, 0, (TrackOutput.CryptoData)c3);
        this.s(a3);
        if (!z.h()) {
            this.z = null;
        }
        this.p = 3;
        return true;
    }
    
    private static boolean N(final int n) {
        return n == 1836019574 || n == 1953653099 || n == 1835297121 || n == 1835626086 || n == 1937007212 || n == 1836019558 || n == 1953653094 || n == 1836475768 || n == 1701082227;
    }
    
    private static boolean O(final int n) {
        return n == 1751411826 || n == 1835296868 || n == 1836476516 || n == 1936286840 || n == 1937011556 || n == 1937011827 || n == 1668576371 || n == 1937011555 || n == 1937011578 || n == 1937013298 || n == 1937007471 || n == 1668232756 || n == 1937011571 || n == 1952867444 || n == 1952868452 || n == 1953196132 || n == 1953654136 || n == 1953658222 || n == 1886614376 || n == 1935763834 || n == 1935763823 || n == 1936027235 || n == 1970628964 || n == 1935828848 || n == 1936158820 || n == 1701606260 || n == 1835362404 || n == 1701671783;
    }
    
    public static Extractor[] c() {
        return l();
    }
    
    private static int f(final int n) throws ParserException {
        if (n >= 0) {
            return n;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected negative value: ");
        sb.append(n);
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }
    
    private void g() {
        this.p = 0;
        this.s = 0;
    }
    
    private c h(final SparseArray<c> sparseArray, final int n) {
        if (sparseArray.size() == 1) {
            return (c)sparseArray.valueAt(0);
        }
        return Assertions.e(sparseArray.get(n));
    }
    
    private static DrmInitData i(final List<com.google.android.exoplayer2.extractor.mp4.a.b> list) {
        final int size = list.size();
        final DrmInitData drmInitData = null;
        int i = 0;
        List<DrmInitData.SchemeData> list2 = null;
        while (i < size) {
            final com.google.android.exoplayer2.extractor.mp4.a.b b = list.get(i);
            List<DrmInitData.SchemeData> list3 = list2;
            if (b.a == 1886614376) {
                if ((list3 = list2) == null) {
                    list3 = new ArrayList<DrmInitData.SchemeData>();
                }
                final byte[] d = b.b.d();
                final UUID f = PsshAtomUtil.f(d);
                if (f == null) {
                    Log.i("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                }
                else {
                    ((ArrayList<DrmInitData.SchemeData>)list3).add(new DrmInitData.SchemeData(f, "video/mp4", d));
                }
            }
            ++i;
            list2 = list3;
        }
        DrmInitData drmInitData2;
        if (list2 == null) {
            drmInitData2 = drmInitData;
        }
        else {
            drmInitData2 = new DrmInitData(list2);
        }
        return drmInitData2;
    }
    
    private static b j(final SparseArray<b> sparseArray) {
        final int size = sparseArray.size();
        b b = null;
        long n = Long.MAX_VALUE;
        b b3;
        long n2;
        for (int i = 0; i < size; ++i, b = b3, n = n2) {
            final b b2 = (b)sparseArray.valueAt(i);
            if (!FragmentedMp4Extractor.b.a(b2)) {
                b3 = b;
                n2 = n;
                if (b2.f == b2.d.b) {
                    continue;
                }
            }
            if (FragmentedMp4Extractor.b.a(b2) && b2.h == b2.b.e) {
                b3 = b;
                n2 = n;
            }
            else {
                final long d = b2.d();
                b3 = b;
                n2 = n;
                if (d < n) {
                    b3 = b2;
                    n2 = d;
                }
            }
        }
        return b;
    }
    
    private void k() {
        final TrackOutput[] f = new TrackOutput[2];
        this.F = f;
        final TrackOutput o = this.o;
        final int n = 0;
        int n2;
        if (o != null) {
            f[0] = o;
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        final int a = this.a;
        int n3 = 100;
        int n4 = n2;
        if ((a & 0x4) != 0x0) {
            f[n2] = this.E.e(100, 5);
            n4 = n2 + 1;
            n3 = 101;
        }
        final TrackOutput[] f2 = Util.H0(this.F, n4);
        this.F = f2;
        for (int length = f2.length, i = 0; i < length; ++i) {
            f2[i].d(FragmentedMp4Extractor.K);
        }
        this.G = new TrackOutput[this.c.size()];
        for (int j = n; j < this.G.length; ++j, ++n3) {
            final TrackOutput e = this.E.e(n3, 3);
            e.d(this.c.get(j));
            this.G[j] = e;
        }
    }
    
    private static Extractor[] l() {
        return new Extractor[] { new FragmentedMp4Extractor() };
    }
    
    private void n(final com.google.android.exoplayer2.extractor.mp4.a.a a) throws ParserException {
        final int a2 = a.a;
        if (a2 == 1836019574) {
            this.r(a);
        }
        else if (a2 == 1836019558) {
            this.q(a);
        }
        else if (!this.m.isEmpty()) {
            this.m.peek().d(a);
        }
    }
    
    private void o(final ParsableByteArray parsableByteArray) {
        if (this.F.length == 0) {
            return;
        }
        parsableByteArray.P(8);
        final int c = com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n());
        long o0;
        long n;
        long n2;
        String s;
        String s2;
        long o2;
        if (c != 0) {
            if (c != 1) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Skipping unsupported emsg version: ");
                sb.append(c);
                Log.i("FragmentedMp4Extractor", sb.toString());
                return;
            }
            final long f = parsableByteArray.F();
            o0 = Util.O0(parsableByteArray.I(), 1000000L, f);
            n = Util.O0(parsableByteArray.F(), 1000L, f);
            n2 = parsableByteArray.F();
            s = Assertions.e(parsableByteArray.x());
            s2 = Assertions.e(parsableByteArray.x());
            o2 = -9223372036854775807L;
        }
        else {
            s = Assertions.e(parsableByteArray.x());
            s2 = Assertions.e(parsableByteArray.x());
            final long f2 = parsableByteArray.F();
            o2 = Util.O0(parsableByteArray.F(), 1000000L, f2);
            final long y = this.y;
            if (y != -9223372036854775807L) {
                o0 = y + o2;
            }
            else {
                o0 = -9223372036854775807L;
            }
            n = Util.O0(parsableByteArray.F(), 1000L, f2);
            n2 = parsableByteArray.F();
        }
        final byte[] array = new byte[parsableByteArray.a()];
        final int a = parsableByteArray.a();
        final int n3 = 0;
        parsableByteArray.j(array, 0, a);
        final ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.k.a(new EventMessage(s, s2, n, n2, array)));
        final int a2 = parsableByteArray2.a();
        for (final TrackOutput trackOutput : this.F) {
            parsableByteArray2.P(0);
            trackOutput.c(parsableByteArray2, a2);
        }
        if (o0 == -9223372036854775807L) {
            this.n.addLast(new a(o2, true, a2));
            this.v += a2;
        }
        else if (!this.n.isEmpty()) {
            this.n.addLast(new a(o0, false, a2));
            this.v += a2;
        }
        else {
            final TimestampAdjuster j = this.j;
            long a3 = o0;
            if (j != null) {
                a3 = j.a(o0);
            }
            final TrackOutput[] f4 = this.F;
            for (int length2 = f4.length, k = n3; k < length2; ++k) {
                f4[k].e(a3, 1, a2, 0, null);
            }
        }
    }
    
    private void p(final com.google.android.exoplayer2.extractor.mp4.a.b b, final long n) throws ParserException {
        if (!this.m.isEmpty()) {
            this.m.peek().e(b);
        }
        else {
            final int a = b.a;
            if (a == 1936286840) {
                final Pair<Long, ChunkIndex> a2 = A(b.b, n);
                this.y = (long)a2.first;
                this.E.l((SeekMap)a2.second);
                this.H = true;
            }
            else if (a == 1701671783) {
                this.o(b.b);
            }
        }
    }
    
    private void q(final com.google.android.exoplayer2.extractor.mp4.a.a a) throws ParserException {
        final SparseArray<b> d = this.d;
        final Track b = this.b;
        final int n = 0;
        u(a, d, b != null, this.a, this.h);
        final DrmInitData i = i(a.c);
        if (i != null) {
            for (int size = this.d.size(), j = 0; j < size; ++j) {
                ((b)this.d.valueAt(j)).n(i);
            }
        }
        if (this.w != -9223372036854775807L) {
            for (int size2 = this.d.size(), k = n; k < size2; ++k) {
                ((b)this.d.valueAt(k)).l(this.w);
            }
            this.w = -9223372036854775807L;
        }
    }
    
    private void r(final com.google.android.exoplayer2.extractor.mp4.a.a a) throws ParserException {
        final Track b = this.b;
        final boolean b2 = true;
        final int n = 0;
        final int n2 = 0;
        Assertions.h(b == null, "Unexpected moov box.");
        final DrmInitData i = i(a.c);
        final com.google.android.exoplayer2.extractor.mp4.a.a a2 = Assertions.e(a.f(1836475768));
        final SparseArray sparseArray = new SparseArray();
        final int size = a2.c.size();
        long t = -9223372036854775807L;
        for (int j = 0; j < size; ++j) {
            final com.google.android.exoplayer2.extractor.mp4.a.b b3 = a2.c.get(j);
            final int a3 = b3.a;
            if (a3 == 1953654136) {
                final Pair<Integer, c> e = E(b3.b);
                sparseArray.put((int)e.first, (Object)e.second);
            }
            else if (a3 == 1835362404) {
                t = t(b3.b);
            }
        }
        final List<i> a4 = com.google.android.exoplayer2.extractor.mp4.b.A(a, new GaplessInfoHolder(), t, i, (this.a & 0x10) != 0x0, false, (Function<Track, Track>)new d(this));
        final int size2 = a4.size();
        if (this.d.size() == 0) {
            for (int k = n2; k < size2; ++k) {
                final i l = a4.get(k);
                final Track a5 = l.a;
                this.d.put(a5.a, (Object)new b(this.E.e(k, a5.b), l, this.h((SparseArray<c>)sparseArray, a5.a)));
                this.x = Math.max(this.x, a5.e);
            }
            this.E.o();
        }
        else {
            Assertions.g(this.d.size() == size2 && b2);
            for (int n3 = n; n3 < size2; ++n3) {
                final i m = a4.get(n3);
                final Track a6 = m.a;
                ((b)this.d.get(a6.a)).j(m, this.h((SparseArray<c>)sparseArray, a6.a));
            }
        }
    }
    
    private void s(final long n) {
        while (!this.n.isEmpty()) {
            final a a = this.n.removeFirst();
            this.v -= a.c;
            long a2;
            final long n2 = a2 = a.a;
            if (a.b) {
                a2 = n2 + n;
            }
            final TimestampAdjuster j = this.j;
            long a3 = a2;
            if (j != null) {
                a3 = j.a(a2);
            }
            final TrackOutput[] f = this.F;
            for (int length = f.length, i = 0; i < length; ++i) {
                f[i].e(a3, 1, a.c, this.v, null);
            }
        }
    }
    
    private static long t(final ParsableByteArray parsableByteArray) {
        parsableByteArray.P(8);
        long n;
        if (com.google.android.exoplayer2.extractor.mp4.a.c(parsableByteArray.n()) == 0) {
            n = parsableByteArray.F();
        }
        else {
            n = parsableByteArray.I();
        }
        return n;
    }
    
    private static void u(final com.google.android.exoplayer2.extractor.mp4.a.a a, final SparseArray<b> sparseArray, final boolean b, final int n, final byte[] array) throws ParserException {
        for (int size = a.d.size(), i = 0; i < size; ++i) {
            final com.google.android.exoplayer2.extractor.mp4.a.a a2 = a.d.get(i);
            if (a2.a == 1953653094) {
                D(a2, sparseArray, b, n, array);
            }
        }
    }
    
    private static void v(final ParsableByteArray parsableByteArray, final h h) throws ParserException {
        parsableByteArray.P(8);
        final int n = parsableByteArray.n();
        if ((com.google.android.exoplayer2.extractor.mp4.a.b(n) & 0x1) == 0x1) {
            parsableByteArray.Q(8);
        }
        final int h2 = parsableByteArray.H();
        if (h2 == 1) {
            final int c = com.google.android.exoplayer2.extractor.mp4.a.c(n);
            final long d = h.d;
            long n2;
            if (c == 0) {
                n2 = parsableByteArray.F();
            }
            else {
                n2 = parsableByteArray.I();
            }
            h.d = d + n2;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected saio entry count: ");
        sb.append(h2);
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }
    
    private static void w(final TrackEncryptionBox trackEncryptionBox, final ParsableByteArray parsableByteArray, final h h) throws ParserException {
        final int d = trackEncryptionBox.d;
        parsableByteArray.P(8);
        final int b = com.google.android.exoplayer2.extractor.mp4.a.b(parsableByteArray.n());
        boolean b2 = true;
        if ((b & 0x1) == 0x1) {
            parsableByteArray.Q(8);
        }
        final int d2 = parsableByteArray.D();
        final int h2 = parsableByteArray.H();
        if (h2 <= h.f) {
            int n3;
            if (d2 == 0) {
                final boolean[] m = h.m;
                int n = 0;
                int n2 = 0;
                while (true) {
                    n3 = n2;
                    if (n >= h2) {
                        break;
                    }
                    final int d3 = parsableByteArray.D();
                    n2 += d3;
                    m[n] = (d3 > d);
                    ++n;
                }
            }
            else {
                if (d2 <= d) {
                    b2 = false;
                }
                n3 = d2 * h2 + 0;
                Arrays.fill(h.m, 0, h2, b2);
            }
            Arrays.fill(h.m, h2, h.f, false);
            if (n3 > 0) {
                h.d(n3);
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Saiz sample count ");
        sb.append(h2);
        sb.append(" is greater than fragment sample count");
        sb.append(h.f);
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }
    
    private static void x(final com.google.android.exoplayer2.extractor.mp4.a.a a, final String s, final h h) throws ParserException {
        final byte[] array = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        ParsableByteArray parsableByteArray3;
        ParsableByteArray parsableByteArray4;
        for (int i = 0; i < a.c.size(); ++i, parsableByteArray = parsableByteArray3, parsableByteArray2 = parsableByteArray4) {
            final com.google.android.exoplayer2.extractor.mp4.a.b b = a.c.get(i);
            final ParsableByteArray b2 = b.b;
            final int a2 = b.a;
            if (a2 == 1935828848) {
                b2.P(12);
                parsableByteArray3 = parsableByteArray;
                parsableByteArray4 = parsableByteArray2;
                if (b2.n() == 1936025959) {
                    parsableByteArray3 = b2;
                    parsableByteArray4 = parsableByteArray2;
                }
            }
            else {
                parsableByteArray3 = parsableByteArray;
                parsableByteArray4 = parsableByteArray2;
                if (a2 == 1936158820) {
                    b2.P(12);
                    parsableByteArray3 = parsableByteArray;
                    parsableByteArray4 = parsableByteArray2;
                    if (b2.n() == 1936025959) {
                        parsableByteArray4 = b2;
                        parsableByteArray3 = parsableByteArray;
                    }
                }
            }
        }
        if (parsableByteArray == null || parsableByteArray2 == null) {
            return;
        }
        parsableByteArray.P(8);
        final int c = a.c(parsableByteArray.n());
        parsableByteArray.Q(4);
        if (c == 1) {
            parsableByteArray.Q(4);
        }
        if (parsableByteArray.n() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
        }
        parsableByteArray2.P(8);
        final int c2 = a.c(parsableByteArray2.n());
        parsableByteArray2.Q(4);
        if (c2 == 1) {
            if (parsableByteArray2.F() == 0L) {
                throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
            }
        }
        else if (c2 >= 2) {
            parsableByteArray2.Q(4);
        }
        if (parsableByteArray2.F() != 1L) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
        }
        parsableByteArray2.Q(1);
        final int d = parsableByteArray2.D();
        final boolean b3 = parsableByteArray2.D() == 1;
        if (!b3) {
            return;
        }
        final int d2 = parsableByteArray2.D();
        final byte[] array2 = new byte[16];
        parsableByteArray2.j(array2, 0, 16);
        byte[] array3 = array;
        if (d2 == 0) {
            final int d3 = parsableByteArray2.D();
            array3 = new byte[d3];
            parsableByteArray2.j(array3, 0, d3);
        }
        h.l = true;
        h.n = new TrackEncryptionBox(b3, s, d2, array2, (d & 0xF0) >> 4, d & 0xF, array3);
    }
    
    private static void y(final ParsableByteArray parsableByteArray, int n, final h h) throws ParserException {
        parsableByteArray.P(n + 8);
        n = com.google.android.exoplayer2.extractor.mp4.a.b(parsableByteArray.n());
        if ((n & 0x1) != 0x0) {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        final boolean b = (n & 0x2) != 0x0;
        n = parsableByteArray.H();
        if (n == 0) {
            Arrays.fill(h.m, 0, h.f, false);
            return;
        }
        if (n == h.f) {
            Arrays.fill(h.m, 0, n, b);
            h.d(parsableByteArray.a());
            h.b(parsableByteArray);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Senc sample count ");
        sb.append(n);
        sb.append(" is different from fragment sample count");
        sb.append(h.f);
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }
    
    private static void z(final ParsableByteArray parsableByteArray, final h h) throws ParserException {
        y(parsableByteArray, 0, h);
    }
    
    @Override
    public void a(final long n, final long w) {
        for (int size = this.d.size(), i = 0; i < size; ++i) {
            ((b)this.d.valueAt(i)).k();
        }
        this.n.clear();
        this.v = 0;
        this.w = w;
        this.m.clear();
        this.g();
    }
    
    @Override
    public void b(final ExtractorOutput e) {
        this.E = e;
        this.g();
        this.k();
        final Track b = this.b;
        if (b != null) {
            this.d.put(0, (Object)new b(e.e(0, b.b), new i(this.b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new c(0, 0, 0, 0)));
            this.E.o();
        }
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        return com.google.android.exoplayer2.extractor.mp4.g.b(extractorInput);
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        while (true) {
            final int p2 = this.p;
            if (p2 != 0) {
                if (p2 != 1) {
                    if (p2 != 2) {
                        if (this.M(extractorInput)) {
                            return 0;
                        }
                        continue;
                    }
                    else {
                        this.L(extractorInput);
                    }
                }
                else {
                    this.K(extractorInput);
                }
            }
            else {
                if (!this.J(extractorInput)) {
                    return -1;
                }
                continue;
            }
        }
    }
    
    protected Track m(final Track track) {
        return track;
    }
    
    @Override
    public void release() {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Flags {
    }
    
    private static final class a
    {
        public final long a;
        public final boolean b;
        public final int c;
        
        public a(final long a, final boolean b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    private static final class b
    {
        public final TrackOutput a;
        public final h b;
        public final ParsableByteArray c;
        public i d;
        public c e;
        public int f;
        public int g;
        public int h;
        public int i;
        private final ParsableByteArray j;
        private final ParsableByteArray k;
        private boolean l;
        
        public b(final TrackOutput a, final i d, final c e) {
            this.a = a;
            this.d = d;
            this.e = e;
            this.b = new h();
            this.c = new ParsableByteArray();
            this.j = new ParsableByteArray(1);
            this.k = new ParsableByteArray();
            this.j(d, e);
        }
        
        static boolean a(final b b) {
            return b.l;
        }
        
        static boolean b(final b b, final boolean l) {
            return b.l = l;
        }
        
        public int c() {
            int n;
            if (!this.l) {
                n = this.d.g[this.f];
            }
            else if (this.b.k[this.f]) {
                n = 1;
            }
            else {
                n = 0;
            }
            int n2 = n;
            if (this.g() != null) {
                n2 = (n | 0x40000000);
            }
            return n2;
        }
        
        public long d() {
            long n;
            if (!this.l) {
                n = this.d.c[this.f];
            }
            else {
                n = this.b.g[this.h];
            }
            return n;
        }
        
        public long e() {
            long c;
            if (!this.l) {
                c = this.d.f[this.f];
            }
            else {
                c = this.b.c(this.f);
            }
            return c;
        }
        
        public int f() {
            int n;
            if (!this.l) {
                n = this.d.d[this.f];
            }
            else {
                n = this.b.i[this.f];
            }
            return n;
        }
        
        public TrackEncryptionBox g() {
            final boolean l = this.l;
            final TrackEncryptionBox trackEncryptionBox = null;
            if (!l) {
                return null;
            }
            final int a = Util.j(this.b.a).a;
            TrackEncryptionBox trackEncryptionBox2 = this.b.n;
            if (trackEncryptionBox2 == null) {
                trackEncryptionBox2 = this.d.a.a(a);
            }
            TrackEncryptionBox trackEncryptionBox3 = trackEncryptionBox;
            if (trackEncryptionBox2 != null) {
                trackEncryptionBox3 = trackEncryptionBox;
                if (trackEncryptionBox2.a) {
                    trackEncryptionBox3 = trackEncryptionBox2;
                }
            }
            return trackEncryptionBox3;
        }
        
        public boolean h() {
            ++this.f;
            if (!this.l) {
                return false;
            }
            final int g = this.g + 1;
            this.g = g;
            final int[] h = this.b.h;
            final int h2 = this.h;
            if (g == h[h2]) {
                this.h = h2 + 1;
                this.g = 0;
                return false;
            }
            return true;
        }
        
        public int i(int j, int n) {
            final TrackEncryptionBox g = this.g();
            if (g == null) {
                return 0;
            }
            int n2 = g.d;
            ParsableByteArray parsableByteArray;
            if (n2 != 0) {
                parsableByteArray = this.b.o;
            }
            else {
                final byte[] array = Util.j(g.e);
                this.k.N(array, array.length);
                parsableByteArray = this.k;
                n2 = array.length;
            }
            final boolean g2 = this.b.g(this.f);
            final boolean b = g2 || n != 0;
            final byte[] d = this.j.d();
            int n3;
            if (b) {
                n3 = 128;
            }
            else {
                n3 = 0;
            }
            d[0] = (byte)(n3 | n2);
            this.j.P(0);
            this.a.f(this.j, 1, 1);
            this.a.f(parsableByteArray, n2, 1);
            if (!b) {
                return n2 + 1;
            }
            if (!g2) {
                this.c.L(8);
                final byte[] d2 = this.c.d();
                d2[0] = 0;
                d2[1] = 1;
                d2[2] = (byte)(n >> 8 & 0xFF);
                d2[3] = (byte)(n & 0xFF);
                d2[4] = (byte)(j >> 24 & 0xFF);
                d2[5] = (byte)(j >> 16 & 0xFF);
                d2[6] = (byte)(j >> 8 & 0xFF);
                d2[7] = (byte)(j & 0xFF);
                this.a.f(this.c, 8, 1);
                return n2 + 1 + 8;
            }
            final ParsableByteArray o = this.b.o;
            j = o.J();
            o.Q(-2);
            j = j * 6 + 2;
            ParsableByteArray c = o;
            if (n != 0) {
                this.c.L(j);
                final byte[] d3 = this.c.d();
                o.j(d3, 0, j);
                n += ((d3[2] & 0xFF) << 8 | (d3[3] & 0xFF));
                d3[2] = (byte)(n >> 8 & 0xFF);
                d3[3] = (byte)(n & 0xFF);
                c = this.c;
            }
            this.a.f(c, j, 1);
            return n2 + 1 + j;
        }
        
        public void j(final i d, final c e) {
            this.d = d;
            this.e = e;
            this.a.d(d.a.f);
            this.k();
        }
        
        public void k() {
            this.b.f();
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }
        
        public void l(final long n) {
            int f = this.f;
            while (true) {
                final h b = this.b;
                if (f >= b.f || b.c(f) >= n) {
                    break;
                }
                if (this.b.k[f]) {
                    this.i = f;
                }
                ++f;
            }
        }
        
        public void m() {
            final TrackEncryptionBox g = this.g();
            if (g == null) {
                return;
            }
            final ParsableByteArray o = this.b.o;
            final int d = g.d;
            if (d != 0) {
                o.Q(d);
            }
            if (this.b.g(this.f)) {
                o.Q(o.J() * 6);
            }
        }
        
        public void n(DrmInitData c) {
            final TrackEncryptionBox a = this.d.a.a(Util.j(this.b.a).a);
            String b;
            if (a != null) {
                b = a.b;
            }
            else {
                b = null;
            }
            c = c.c(b);
            this.a.d(this.d.a.f.b().M(c).E());
        }
    }
}
