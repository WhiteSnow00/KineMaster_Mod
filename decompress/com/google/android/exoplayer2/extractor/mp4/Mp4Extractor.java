// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.extractor.SeekPoint;
import android.util.Pair;
import com.google.common.base.Function;
import com.google.android.exoplayer2.drm.DrmInitData;
import p3.c;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.TrueHdSampleRechunker;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.extractor.PositionHolder;
import java.io.IOException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import java.util.ArrayList;
import p3.b;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import java.util.ArrayDeque;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.Extractor;

public final class Mp4Extractor implements Extractor, SeekMap
{
    public static final ExtractorsFactory y;
    private final int a;
    private final ParsableByteArray b;
    private final ParsableByteArray c;
    private final ParsableByteArray d;
    private final ParsableByteArray e;
    private final ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a.a> f;
    private final f g;
    private final List<Metadata.Entry> h;
    private int i;
    private int j;
    private long k;
    private int l;
    private ParsableByteArray m;
    private int n;
    private int o;
    private int p;
    private int q;
    private ExtractorOutput r;
    private a[] s;
    private long[][] t;
    private int u;
    private long v;
    private int w;
    private MotionPhotoMetadata x;
    
    static {
        y = (ExtractorsFactory)b.b;
    }
    
    public Mp4Extractor() {
        this(0);
    }
    
    public Mp4Extractor(int n) {
        this.a = n;
        if ((n & 0x4) != 0x0) {
            n = 3;
        }
        else {
            n = 0;
        }
        this.i = n;
        this.g = new f();
        this.h = new ArrayList<Metadata.Entry>();
        this.e = new ParsableByteArray(16);
        this.f = new ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a.a>();
        this.b = new ParsableByteArray(NalUnitUtil.a);
        this.c = new ParsableByteArray(4);
        this.d = new ParsableByteArray();
        this.n = -1;
        this.r = ExtractorOutput.n;
        this.s = new a[0];
    }
    
    private boolean A(final ExtractorInput extractorInput) throws IOException {
        if (this.l == 0) {
            if (!extractorInput.i(this.e.d(), 0, 8, true)) {
                this.w();
                return false;
            }
            this.l = 8;
            this.e.P(0);
            this.k = this.e.F();
            this.j = this.e.n();
        }
        final long k = this.k;
        if (k == 1L) {
            extractorInput.readFully(this.e.d(), 8, 8);
            this.l += 8;
            this.k = this.e.I();
        }
        else if (k == 0L) {
            long n2;
            final long n = n2 = extractorInput.getLength();
            if (n == -1L) {
                final com.google.android.exoplayer2.extractor.mp4.a.a a = this.f.peek();
                n2 = n;
                if (a != null) {
                    n2 = a.b;
                }
            }
            if (n2 != -1L) {
                this.k = n2 - extractorInput.getPosition() + this.l;
            }
        }
        if (this.k >= this.l) {
            if (E(this.j)) {
                final long position = extractorInput.getPosition();
                final long i = this.k;
                final int l = this.l;
                final long n3 = position + i - l;
                if (i != l && this.j == 1835365473) {
                    this.u(extractorInput);
                }
                this.f.push(new com.google.android.exoplayer2.extractor.mp4.a.a(this.j, n3));
                if (this.k == this.l) {
                    this.v(n3);
                }
                else {
                    this.n();
                }
            }
            else if (F(this.j)) {
                Assertions.g(this.l == 8);
                Assertions.g(this.k <= 2147483647L);
                final ParsableByteArray m = new ParsableByteArray((int)this.k);
                System.arraycopy(this.e.d(), 0, m.d(), 0, 8);
                this.m = m;
                this.i = 1;
            }
            else {
                this.z(extractorInput.getPosition() - this.l);
                this.m = null;
                this.i = 1;
            }
            return true;
        }
        throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
    }
    
    private boolean B(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final long n = this.k - this.l;
        final long position = extractorInput.getPosition();
        final ParsableByteArray m = this.m;
        boolean b = true;
        boolean b2 = false;
        Label_0150: {
            if (m != null) {
                extractorInput.readFully(m.d(), this.l, (int)n);
                if (this.j == 1718909296) {
                    this.w = x(m);
                }
                else if (!this.f.isEmpty()) {
                    this.f.peek().e(new com.google.android.exoplayer2.extractor.mp4.a.b(this.j, m));
                }
            }
            else {
                if (n >= 262144L) {
                    positionHolder.a = extractorInput.getPosition() + n;
                    b2 = true;
                    break Label_0150;
                }
                extractorInput.o((int)n);
            }
            b2 = false;
        }
        this.v(position + n);
        if (!b2 || this.i == 2) {
            b = false;
        }
        return b;
    }
    
    private int C(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final long position = extractorInput.getPosition();
        if (this.n == -1 && (this.n = this.q(position)) == -1) {
            return -1;
        }
        final a a = this.s[this.n];
        final TrackOutput c = a.c;
        final int e = a.e;
        final i b = a.b;
        final long a2 = b.c[e];
        final int n = b.d[e];
        final TrueHdSampleRechunker d = a.d;
        final long n2 = a2 - position + this.o;
        if (n2 >= 0L && n2 < 262144L) {
            long n3 = n2;
            int n4 = n;
            if (a.a.g == 1) {
                n3 = n2 + 8L;
                n4 = n - 8;
            }
            extractorInput.o((int)n3);
            final Track a3 = a.a;
            int n6;
            if (a3.j != 0) {
                final byte[] d2 = this.c.d();
                d2[0] = 0;
                d2[2] = (d2[1] = 0);
                final int j = a.a.j;
                final int n5 = 4 - j;
                while (true) {
                    n6 = n4;
                    if (this.p >= n4) {
                        break;
                    }
                    final int q = this.q;
                    if (q == 0) {
                        extractorInput.readFully(d2, n5, j);
                        this.o += j;
                        this.c.P(0);
                        final int n7 = this.c.n();
                        if (n7 < 0) {
                            throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                        }
                        this.q = n7;
                        this.b.P(0);
                        c.c(this.b, 4);
                        this.p += 4;
                        n4 += n5;
                    }
                    else {
                        final int b2 = c.b(extractorInput, q, false);
                        this.o += b2;
                        this.p += b2;
                        this.q -= b2;
                    }
                }
            }
            else {
                int n8;
                if ("audio/ac4".equals(a3.f.w)) {
                    if (this.p == 0) {
                        Ac4Util.a(n4, this.d);
                        c.c(this.d, 7);
                        this.p += 7;
                    }
                    n8 = n4 + 7;
                }
                else {
                    n8 = n4;
                    if (d != null) {
                        d.d(extractorInput);
                        n8 = n4;
                    }
                }
                while (true) {
                    final int p2 = this.p;
                    if (p2 >= (n6 = n8)) {
                        break;
                    }
                    final int b3 = c.b(extractorInput, n8 - p2, false);
                    this.o += b3;
                    this.p += b3;
                    this.q -= b3;
                }
            }
            final i b4 = a.b;
            final long n9 = b4.f[e];
            final int n10 = b4.g[e];
            if (d != null) {
                d.c(c, n9, n10, n6, 0, null);
                if (e + 1 == a.b.b) {
                    d.a(c, null);
                }
            }
            else {
                c.e(n9, n10, n6, 0, null);
            }
            ++a.e;
            this.n = -1;
            this.o = 0;
            this.p = 0;
            return this.q = 0;
        }
        positionHolder.a = a2;
        return 1;
    }
    
    private int D(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final int c = this.g.c(extractorInput, positionHolder, this.h);
        if (c == 1 && positionHolder.a == 0L) {
            this.n();
        }
        return c;
    }
    
    private static boolean E(final int n) {
        return n == 1836019574 || n == 1953653099 || n == 1835297121 || n == 1835626086 || n == 1937007212 || n == 1701082227 || n == 1835365473;
    }
    
    private static boolean F(final int n) {
        return n == 1835296868 || n == 1836476516 || n == 1751411826 || n == 1937011556 || n == 1937011827 || n == 1937011571 || n == 1668576371 || n == 1701606260 || n == 1937011555 || n == 1937011578 || n == 1937013298 || n == 1937007471 || n == 1668232756 || n == 1953196132 || n == 1718909296 || n == 1969517665 || n == 1801812339 || n == 1768715124;
    }
    
    private void G(final a a, final long n) {
        final i b = a.b;
        int e;
        if ((e = b.a(n)) == -1) {
            e = b.b(n);
        }
        a.e = e;
    }
    
    public static Track j(final Track track) {
        return r(track);
    }
    
    public static Extractor[] k() {
        return s();
    }
    
    private static int l(final int n) {
        if (n == 1751476579) {
            return 2;
        }
        if (n != 1903435808) {
            return 0;
        }
        return 1;
    }
    
    private static long[][] m(final a[] array) {
        final long[][] array2 = new long[array.length][];
        final int[] array3 = new int[array.length];
        final long[] array4 = new long[array.length];
        final boolean[] array5 = new boolean[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = new long[array[i].b.b];
            array4[i] = array[i].b.f[0];
        }
        long n = 0L;
        int j = 0;
        while (j < array.length) {
            long n2 = Long.MAX_VALUE;
            int n3 = -1;
            long n4;
            int n5;
            for (int k = 0; k < array.length; ++k, n2 = n4, n3 = n5) {
                n4 = n2;
                n5 = n3;
                if (!array5[k]) {
                    n4 = n2;
                    n5 = n3;
                    if (array4[k] <= n2) {
                        n4 = array4[k];
                        n5 = k;
                    }
                }
            }
            int n6 = array3[n3];
            array2[n3][n6] = n;
            n += array[n3].b.d[n6];
            ++n6;
            if ((array3[n3] = n6) < array2[n3].length) {
                array4[n3] = array[n3].b.f[n6];
            }
            else {
                array5[n3] = true;
                ++j;
            }
        }
        return array2;
    }
    
    private void n() {
        this.i = 0;
        this.l = 0;
    }
    
    private static int p(final i i, final long n) {
        int n2;
        if ((n2 = i.a(n)) == -1) {
            n2 = i.b(n);
        }
        return n2;
    }
    
    private int q(final long n) {
        int n2 = -1;
        int n3 = -1;
        int n4 = 0;
        long n5 = Long.MAX_VALUE;
        int n6 = 1;
        long n7 = Long.MAX_VALUE;
        int n8 = 1;
        long n9 = Long.MAX_VALUE;
        while (true) {
            final a[] s = this.s;
            if (n4 >= s.length) {
                break;
            }
            final a a = s[n4];
            final int e = a.e;
            final i b = a.b;
            long n10;
            if (e == b.b) {
                n10 = n5;
            }
            else {
                final long n11 = b.c[e];
                final long n12 = Util.j(this.t)[n4][e];
                final long n13 = n11 - n;
                final boolean b2 = n13 < 0L || n13 >= 262144L;
                int n14 = 0;
                long n15 = 0L;
                int n16 = 0;
                long n17 = 0L;
                Label_0212: {
                    if (b2 || n8 == 0) {
                        n14 = n3;
                        n15 = n7;
                        n16 = n8;
                        n17 = n9;
                        if ((b2 ? 1 : 0) != n8) {
                            break Label_0212;
                        }
                        n14 = n3;
                        n15 = n7;
                        n16 = n8;
                        n17 = n9;
                        if (n13 >= n9) {
                            break Label_0212;
                        }
                    }
                    n16 = (b2 ? 1 : 0);
                    n17 = n13;
                    n14 = n4;
                    n15 = n12;
                }
                n3 = n14;
                n10 = n5;
                n7 = n15;
                n8 = n16;
                n9 = n17;
                if (n12 < n5) {
                    n2 = n4;
                    n9 = n17;
                    n8 = n16;
                    n7 = n15;
                    n6 = (b2 ? 1 : 0);
                    n10 = n12;
                    n3 = n14;
                }
            }
            ++n4;
            n5 = n10;
        }
        if (n5 == Long.MAX_VALUE || n6 == 0 || n7 < n5 + 10485760L) {
            n2 = n3;
        }
        return n2;
    }
    
    private static Track r(final Track track) {
        return track;
    }
    
    private static Extractor[] s() {
        return new Extractor[] { new Mp4Extractor() };
    }
    
    private static long t(final i i, final long n, final long n2) {
        final int p3 = p(i, n);
        if (p3 == -1) {
            return n2;
        }
        return Math.min(i.c[p3], n2);
    }
    
    private void u(final ExtractorInput extractorInput) throws IOException {
        this.d.L(8);
        extractorInput.r(this.d.d(), 0, 8);
        com.google.android.exoplayer2.extractor.mp4.b.e(this.d);
        extractorInput.o(this.d.e());
        extractorInput.h();
    }
    
    private void v(final long n) throws ParserException {
        while (!this.f.isEmpty() && this.f.peek().b == n) {
            final com.google.android.exoplayer2.extractor.mp4.a.a a = this.f.pop();
            if (a.a == 1836019574) {
                this.y(a);
                this.f.clear();
                this.i = 2;
            }
            else {
                if (this.f.isEmpty()) {
                    continue;
                }
                this.f.peek().d(a);
            }
        }
        if (this.i != 2) {
            this.n();
        }
    }
    
    private void w() {
        if (this.w == 2 && (this.a & 0x2) != 0x0) {
            final TrackOutput e = this.r.e(0, 4);
            Metadata metadata;
            if (this.x == null) {
                metadata = null;
            }
            else {
                metadata = new Metadata(new Metadata.Entry[] { this.x });
            }
            e.d(new Format.Builder().X(metadata).E());
            this.r.o();
            this.r.l(new Unseekable(-9223372036854775807L));
        }
    }
    
    private static int x(final ParsableByteArray parsableByteArray) {
        parsableByteArray.P(8);
        final int l = l(parsableByteArray.n());
        if (l != 0) {
            return l;
        }
        parsableByteArray.Q(4);
        while (parsableByteArray.a() > 0) {
            final int i = l(parsableByteArray.n());
            if (i != 0) {
                return i;
            }
        }
        return 0;
    }
    
    private void y(final com.google.android.exoplayer2.extractor.mp4.a.a a) throws ParserException {
        final ArrayList list = new ArrayList();
        final boolean b = this.w == 1;
        final GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        final com.google.android.exoplayer2.extractor.mp4.a.b g = a.g(1969517665);
        Metadata metadata;
        Metadata metadata2;
        if (g != null) {
            final Pair<Metadata, Metadata> b2 = com.google.android.exoplayer2.extractor.mp4.b.B(g);
            metadata = (Metadata)b2.first;
            metadata2 = (Metadata)b2.second;
            if (metadata != null) {
                gaplessInfoHolder.c(metadata);
            }
        }
        else {
            metadata2 = null;
            metadata = null;
        }
        final com.google.android.exoplayer2.extractor.mp4.a.a f = a.f(1835365473);
        Metadata n;
        if (f != null) {
            n = com.google.android.exoplayer2.extractor.mp4.b.n(f);
        }
        else {
            n = null;
        }
        final List<i> a2 = com.google.android.exoplayer2.extractor.mp4.b.A(a, gaplessInfoHolder, -9223372036854775807L, null, (this.a & 0x1) != 0x0, b, (Function<Track, Track>)p3.c.a);
        final int size = a2.size();
        long max = -9223372036854775807L;
        int i = 0;
        int u = -1;
        while (i < size) {
            final i j = a2.get(i);
            if (j.b != 0) {
                final Track a3 = j.a;
                long n2 = a3.e;
                if (n2 == -9223372036854775807L) {
                    n2 = j.h;
                }
                max = Math.max(max, n2);
                final a a4 = new a(a3, j, this.r.e(i, a3.b));
                int n3;
                if ("audio/true-hd".equals(a3.f.w)) {
                    n3 = j.e * 16;
                }
                else {
                    n3 = j.e + 30;
                }
                final Format.Builder b3 = a3.f.b();
                b3.W(n3);
                if (a3.b == 2 && n2 > 0L) {
                    final int b4 = j.b;
                    if (b4 > 1) {
                        b3.P(b4 / (n2 / 1000000.0f));
                    }
                }
                com.google.android.exoplayer2.extractor.mp4.e.k(a3.b, gaplessInfoHolder, b3);
                final int b5 = a3.b;
                Metadata metadata3;
                if (this.h.isEmpty()) {
                    metadata3 = null;
                }
                else {
                    metadata3 = new Metadata((List<? extends Metadata.Entry>)this.h);
                }
                com.google.android.exoplayer2.extractor.mp4.e.l(b5, metadata, n, b3, metadata2, metadata3);
                a4.c.d(b3.E());
                int size2;
                if (a3.b == 2) {
                    if ((size2 = u) == -1) {
                        size2 = list.size();
                    }
                }
                else {
                    size2 = u;
                }
                list.add(a4);
                u = size2;
            }
            ++i;
        }
        this.u = u;
        this.v = max;
        final a[] s = (a[])list.toArray(new a[0]);
        this.s = s;
        this.t = m(s);
        this.r.o();
        this.r.l(this);
    }
    
    private void z(final long n) {
        if (this.j == 1836086884) {
            final int l = this.l;
            this.x = new MotionPhotoMetadata(0L, n, -9223372036854775807L, n + l, this.k - l);
        }
    }
    
    @Override
    public void a(final long n, final long n2) {
        this.f.clear();
        int i = 0;
        this.l = 0;
        this.n = -1;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        if (n == 0L) {
            if (this.i != 3) {
                this.n();
            }
            else {
                this.g.g();
                this.h.clear();
            }
        }
        else {
            for (a[] s = this.s; i < s.length; ++i) {
                final a a = s[i];
                this.G(a, n2);
                final TrueHdSampleRechunker d = a.d;
                if (d != null) {
                    d.b();
                }
            }
        }
    }
    
    @Override
    public void b(final ExtractorOutput r) {
        this.r = r;
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        return com.google.android.exoplayer2.extractor.mp4.g.d(extractorInput, (this.a & 0x2) != 0x0);
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        while (true) {
            final int i = this.i;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return this.C(extractorInput, positionHolder);
                    }
                    if (i == 3) {
                        return this.D(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                }
                else {
                    if (this.B(extractorInput, positionHolder)) {
                        return 1;
                    }
                    continue;
                }
            }
            else {
                if (!this.A(extractorInput)) {
                    return -1;
                }
                continue;
            }
        }
    }
    
    @Override
    public SeekPoints f(final long n) {
        return this.o(n, -1);
    }
    
    @Override
    public boolean h() {
        return true;
    }
    
    @Override
    public long i() {
        return this.v;
    }
    
    public SeekPoints o(long n, int n2) {
        final a[] s = this.s;
        if (s.length == 0) {
            return new SeekPoints(SeekPoint.c);
        }
        int u;
        if (n2 != -1) {
            u = n2;
        }
        else {
            u = this.u;
        }
        long n5 = 0L;
        long n6 = 0L;
        long n7 = 0L;
        Label_0220: {
            if (u != -1) {
                final i b = s[u].b;
                final int p2 = p(b, n);
                if (p2 == -1) {
                    return new SeekPoints(SeekPoint.c);
                }
                final long n3 = b.f[p2];
                final long n4 = b.c[p2];
                n5 = n3;
                n6 = n4;
                if (n3 < n) {
                    n5 = n3;
                    n6 = n4;
                    if (p2 < b.b - 1) {
                        final int b2 = b.b(n);
                        n5 = n3;
                        n6 = n4;
                        if (b2 != -1) {
                            n5 = n3;
                            n6 = n4;
                            if (b2 != p2) {
                                n7 = b.f[b2];
                                n = b.c[b2];
                                n5 = n3;
                                n6 = n4;
                                break Label_0220;
                            }
                        }
                    }
                }
            }
            else {
                n6 = Long.MAX_VALUE;
                n5 = n;
            }
            n = -1L;
            n7 = -9223372036854775807L;
        }
        long n8 = n;
        long n9 = n6;
        if (n2 == -1) {
            n2 = 0;
            while (true) {
                final a[] s2 = this.s;
                n8 = n;
                n9 = n6;
                if (n2 >= s2.length) {
                    break;
                }
                long t = n;
                long n10 = n6;
                if (n2 != this.u) {
                    final i b3 = s2[n2].b;
                    final long t2 = t(b3, n5, n6);
                    t = n;
                    n10 = t2;
                    if (n7 != -9223372036854775807L) {
                        t = t(b3, n7, n);
                        n10 = t2;
                    }
                }
                ++n2;
                n = t;
                n6 = n10;
            }
        }
        final SeekPoint seekPoint = new SeekPoint(n5, n9);
        if (n7 == -9223372036854775807L) {
            return new SeekPoints(seekPoint);
        }
        return new SeekPoints(seekPoint, new SeekPoint(n7, n8));
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
        public final Track a;
        public final i b;
        public final TrackOutput c;
        public final TrueHdSampleRechunker d;
        public int e;
        
        public a(final Track a, final i b, final TrackOutput c) {
            this.a = a;
            this.b = b;
            this.c = c;
            TrueHdSampleRechunker d;
            if ("audio/true-hd".equals(a.f.w)) {
                d = new TrueHdSampleRechunker();
            }
            else {
                d = null;
            }
            this.d = d;
        }
    }
}
