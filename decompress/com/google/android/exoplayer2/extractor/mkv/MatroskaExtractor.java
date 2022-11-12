// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.List;
import android.util.Pair;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteOrder;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Locale;
import com.google.android.exoplayer2.extractor.TrueHdSampleRechunker;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.upstream.DataReader;
import java.util.Arrays;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.NalUnitUtil;
import java.util.Collections;
import java.util.HashMap;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.LongArray;
import java.util.Map;
import java.util.UUID;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;

public class MatroskaExtractor implements Extractor
{
    public static final ExtractorsFactory c0;
    private static final byte[] d0;
    private static final byte[] e0;
    private static final byte[] f0;
    private static final byte[] g0;
    private static final UUID h0;
    private static final Map<String, Integer> i0;
    private long A;
    private long B;
    private LongArray C;
    private LongArray D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private int Y;
    private byte Z;
    private final com.google.android.exoplayer2.extractor.mkv.b a;
    private boolean a0;
    private final e b;
    private ExtractorOutput b0;
    private final SparseArray<Track> c;
    private final boolean d;
    private final ParsableByteArray e;
    private final ParsableByteArray f;
    private final ParsableByteArray g;
    private final ParsableByteArray h;
    private final ParsableByteArray i;
    private final ParsableByteArray j;
    private final ParsableByteArray k;
    private final ParsableByteArray l;
    private final ParsableByteArray m;
    private final ParsableByteArray n;
    private ByteBuffer o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private Track u;
    private boolean v;
    private int w;
    private long x;
    private boolean y;
    private long z;
    
    static {
        c0 = c.b;
        d0 = new byte[] { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
        e0 = Util.n0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        f0 = new byte[] { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
        g0 = new byte[] { 87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10 };
        h0 = new UUID(72057594037932032L, -9223371306706625679L);
        final HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        i0 = Collections.unmodifiableMap((Map<?, ?>)hashMap);
    }
    
    public MatroskaExtractor() {
        this(0);
    }
    
    public MatroskaExtractor(final int n) {
        this(new a(), n);
    }
    
    MatroskaExtractor(final com.google.android.exoplayer2.extractor.mkv.b a, final int n) {
        this.q = -1L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        (this.a = a).b(new b(null));
        this.d = ((n & 0x1) == 0x0);
        this.b = new e();
        this.c = (SparseArray<Track>)new SparseArray();
        this.g = new ParsableByteArray(4);
        this.h = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new ParsableByteArray(4);
        this.e = new ParsableByteArray(NalUnitUtil.a);
        this.f = new ParsableByteArray(4);
        this.j = new ParsableByteArray();
        this.k = new ParsableByteArray();
        this.l = new ParsableByteArray(8);
        this.m = new ParsableByteArray();
        this.n = new ParsableByteArray();
        this.L = new int[1];
    }
    
    private static Extractor[] A() {
        return new Extractor[] { new MatroskaExtractor() };
    }
    
    private boolean B(final PositionHolder positionHolder, long a) {
        if (this.y) {
            this.A = a;
            positionHolder.a = this.z;
            this.y = false;
            return true;
        }
        if (this.v) {
            a = this.A;
            if (a != -1L) {
                positionHolder.a = a;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }
    
    private void C(final ExtractorInput extractorInput, final int n) throws IOException {
        if (this.g.f() >= n) {
            return;
        }
        if (this.g.b() < n) {
            final ParsableByteArray g = this.g;
            g.c(Math.max(g.b() * 2, n));
        }
        extractorInput.readFully(this.g.d(), this.g.f(), n - this.g.f());
        this.g.O(n);
    }
    
    private void D() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = 0;
        this.a0 = false;
        this.j.L(0);
    }
    
    private long E(final long n) throws ParserException {
        final long r = this.r;
        if (r != -9223372036854775807L) {
            return Util.O0(n, r, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }
    
    private static void F(final String s, final long n, final byte[] array) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n2 = -1;
        switch (hashCode) {
            case 1422270023: {
                if (!s.equals("S_TEXT/UTF8")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case 1045209816: {
                if (!s.equals("S_TEXT/WEBVTT")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case 738597099: {
                if (!s.equals("S_TEXT/ASS")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        byte[] array2 = null;
        int n3 = 0;
        switch (n2) {
            default: {
                throw new IllegalArgumentException();
            }
            case 2: {
                array2 = s(n, "%02d:%02d:%02d,%03d", 1000L);
                n3 = 19;
                break;
            }
            case 1: {
                array2 = s(n, "%02d:%02d:%02d.%03d", 1000L);
                n3 = 25;
                break;
            }
            case 0: {
                array2 = s(n, "%01d:%02d:%02d:%02d", 10000L);
                n3 = 21;
                break;
            }
        }
        System.arraycopy(array2, 0, array, n3, array2.length);
    }
    
    private int I(final ExtractorInput extractorInput, final Track track, int n, final boolean b) throws IOException {
        if ("S_TEXT/UTF8".equals(track.b)) {
            this.J(extractorInput, MatroskaExtractor.d0, n);
            return this.q();
        }
        if ("S_TEXT/ASS".equals(track.b)) {
            this.J(extractorInput, MatroskaExtractor.f0, n);
            return this.q();
        }
        if ("S_TEXT/WEBVTT".equals(track.b)) {
            this.J(extractorInput, MatroskaExtractor.g0, n);
            return this.q();
        }
        final TrackOutput x = track.X;
        final boolean v = this.V;
        final boolean b2 = true;
        if (!v) {
            if (track.h) {
                this.O &= 0xBFFFFFFF;
                final boolean w = this.W;
                int n2 = 128;
                if (!w) {
                    extractorInput.readFully(this.g.d(), 0, 1);
                    ++this.S;
                    if ((this.g.d()[0] & 0x80) == 0x80) {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                    this.Z = this.g.d()[0];
                    this.W = true;
                }
                final byte z = this.Z;
                if ((z & 0x1) == 0x1) {
                    final boolean b3 = (z & 0x2) == 0x2;
                    this.O |= 0x40000000;
                    if (!this.a0) {
                        extractorInput.readFully(this.l.d(), 0, 8);
                        this.S += 8;
                        this.a0 = true;
                        final byte[] d = this.g.d();
                        if (!b3) {
                            n2 = 0;
                        }
                        d[0] = (byte)(n2 | 0x8);
                        this.g.P(0);
                        x.f(this.g, 1, 1);
                        ++this.T;
                        this.l.P(0);
                        x.f(this.l, 8, 1);
                        this.T += 8;
                    }
                    if (b3) {
                        if (!this.X) {
                            extractorInput.readFully(this.g.d(), 0, 1);
                            ++this.S;
                            this.g.P(0);
                            this.Y = this.g.D();
                            this.X = true;
                        }
                        final int n3 = this.Y * 4;
                        this.g.L(n3);
                        extractorInput.readFully(this.g.d(), 0, n3);
                        this.S += n3;
                        final short n4 = (short)(this.Y / 2 + 1);
                        final int n5 = n4 * 6 + 2;
                        final ByteBuffer o = this.o;
                        if (o == null || o.capacity() < n5) {
                            this.o = ByteBuffer.allocate(n5);
                        }
                        this.o.position(0);
                        this.o.putShort(n4);
                        int n6 = 0;
                        int n7 = 0;
                        int y;
                        while (true) {
                            y = this.Y;
                            if (n6 >= y) {
                                break;
                            }
                            final int h = this.g.H();
                            if (n6 % 2 == 0) {
                                this.o.putShort((short)(h - n7));
                            }
                            else {
                                this.o.putInt(h - n7);
                            }
                            ++n6;
                            n7 = h;
                        }
                        final int n8 = n - this.S - n7;
                        if (y % 2 == 1) {
                            this.o.putInt(n8);
                        }
                        else {
                            this.o.putShort((short)n8);
                            this.o.putInt(0);
                        }
                        this.m.N(this.o.array(), n5);
                        x.f(this.m, n5, 1);
                        this.T += n5;
                    }
                }
            }
            else {
                final byte[] i = track.i;
                if (i != null) {
                    this.j.N(i, i.length);
                }
            }
            if (Track.e(track, b)) {
                this.O |= 0x10000000;
                this.n.L(0);
                final int n9 = this.j.f() + n - this.S;
                this.g.L(4);
                this.g.d()[0] = (byte)(n9 >> 24 & 0xFF);
                this.g.d()[1] = (byte)(n9 >> 16 & 0xFF);
                this.g.d()[2] = (byte)(n9 >> 8 & 0xFF);
                this.g.d()[3] = (byte)(n9 & 0xFF);
                x.f(this.g, 4, 2);
                this.T += 4;
            }
            this.V = true;
        }
        n += this.j.f();
        if (!"V_MPEG4/ISO/AVC".equals(track.b) && !"V_MPEGH/ISO/HEVC".equals(track.b)) {
            if (track.T != null) {
                Assertions.g(this.j.f() == 0 && b2);
                track.T.d(extractorInput);
            }
            while (true) {
                final int s = this.S;
                if (s >= n) {
                    break;
                }
                final int k = this.K(extractorInput, x, n - s);
                this.S += k;
                this.T += k;
            }
        }
        else {
            final byte[] d2 = this.f.d();
            d2[0] = 0;
            d2[2] = (d2[1] = 0);
            final int y2 = track.Y;
            while (this.S < n) {
                final int u = this.U;
                if (u == 0) {
                    this.L(extractorInput, d2, 4 - y2, y2);
                    this.S += y2;
                    this.f.P(0);
                    this.U = this.f.H();
                    this.e.P(0);
                    x.c(this.e, 4);
                    this.T += 4;
                }
                else {
                    final int j = this.K(extractorInput, x, u);
                    this.S += j;
                    this.T += j;
                    this.U -= j;
                }
            }
        }
        if ("A_VORBIS".equals(track.b)) {
            this.h.P(0);
            x.c(this.h, 4);
            this.T += 4;
        }
        return this.q();
    }
    
    private void J(final ExtractorInput extractorInput, final byte[] array, final int n) throws IOException {
        final int n2 = array.length + n;
        if (this.k.b() < n2) {
            this.k.M(Arrays.copyOf(array, n2 + n));
        }
        else {
            System.arraycopy(array, 0, this.k.d(), 0, array.length);
        }
        extractorInput.readFully(this.k.d(), array.length, n);
        this.k.P(0);
        this.k.O(n2);
    }
    
    private int K(final ExtractorInput extractorInput, final TrackOutput trackOutput, int n) throws IOException {
        final int a = this.j.a();
        if (a > 0) {
            n = Math.min(n, a);
            trackOutput.c(this.j, n);
        }
        else {
            n = trackOutput.b(extractorInput, n, false);
        }
        return n;
    }
    
    private void L(final ExtractorInput extractorInput, final byte[] array, final int n, final int n2) throws IOException {
        final int min = Math.min(n2, this.j.a());
        extractorInput.readFully(array, n + min, n2 - min);
        if (min > 0) {
            this.j.j(array, n, min);
        }
    }
    
    public static Extractor[] c() {
        return A();
    }
    
    static byte[] f() {
        return MatroskaExtractor.e0;
    }
    
    static Map g() {
        return MatroskaExtractor.i0;
    }
    
    static UUID h() {
        return MatroskaExtractor.h0;
    }
    
    private void i(final int n) throws ParserException {
        if (this.C != null && this.D != null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Element ");
        sb.append(n);
        sb.append(" must be in a Cues");
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }
    
    private void j(final int n) throws ParserException {
        if (this.u != null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Element ");
        sb.append(n);
        sb.append(" must be in a TrackEntry");
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }
    
    private void k() {
        Assertions.i(this.b0);
    }
    
    private SeekMap m(final LongArray longArray, final LongArray longArray2) {
        if (this.q != -1L && this.t != -9223372036854775807L && longArray != null && longArray.c() != 0 && longArray2 != null && longArray2.c() == longArray.c()) {
            final int c = longArray.c();
            final int[] array = new int[c];
            final long[] array2 = new long[c];
            final long[] array3 = new long[c];
            final long[] array4 = new long[c];
            final int n = 0;
            int n2 = 0;
            int n3;
            while (true) {
                n3 = n;
                if (n2 >= c) {
                    break;
                }
                array4[n2] = longArray.b(n2);
                array2[n2] = this.q + longArray2.b(n2);
                ++n2;
            }
            int n4;
            while (true) {
                n4 = c - 1;
                if (n3 >= n4) {
                    break;
                }
                final int n5 = n3 + 1;
                array[n3] = (int)(array2[n5] - array2[n3]);
                array3[n3] = array4[n5] - array4[n3];
                n3 = n5;
            }
            array[n4] = (int)(this.q + this.p - array2[n4]);
            array3[n4] = this.t - array4[n4];
            final long n6 = array3[n4];
            int[] copy = array;
            long[] copy2 = array2;
            long[] copy3 = array3;
            long[] copy4 = array4;
            if (n6 <= 0L) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Discarding last cue point with unexpected duration: ");
                sb.append(n6);
                Log.i("MatroskaExtractor", sb.toString());
                copy = Arrays.copyOf(array, n4);
                copy2 = Arrays.copyOf(array2, n4);
                copy3 = Arrays.copyOf(array3, n4);
                copy4 = Arrays.copyOf(array4, n4);
            }
            return new ChunkIndex(copy, copy2, copy3, copy4);
        }
        return new SeekMap.Unseekable(this.t);
    }
    
    private void n(final Track track, final long n, final int n2, int f, final int n3) {
        final TrueHdSampleRechunker t = track.T;
        if (t != null) {
            t.c(track.X, n, n2, f, n3, track.j);
        }
        else {
            int n4 = 0;
            Label_0238: {
                if (!"S_TEXT/UTF8".equals(track.b) && !"S_TEXT/ASS".equals(track.b)) {
                    n4 = f;
                    if (!"S_TEXT/WEBVTT".equals(track.b)) {
                        break Label_0238;
                    }
                }
                if (this.K > 1) {
                    Log.i("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                    n4 = f;
                }
                else {
                    final long i = this.I;
                    if (i == -9223372036854775807L) {
                        Log.i("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                        n4 = f;
                    }
                    else {
                        F(track.b, i, this.k.d());
                        for (int j = this.k.e(); j < this.k.f(); ++j) {
                            if (this.k.d()[j] == 0) {
                                this.k.O(j);
                                break;
                            }
                        }
                        final TrackOutput x = track.X;
                        final ParsableByteArray k = this.k;
                        x.c(k, k.f());
                        n4 = f + this.k.f();
                    }
                }
            }
            f = n4;
            if ((0x10000000 & n2) != 0x0) {
                if (this.K > 1) {
                    this.n.L(0);
                    f = n4;
                }
                else {
                    f = this.n.f();
                    track.X.f(this.n, f, 2);
                    f += n4;
                }
            }
            track.X.e(n, n2, f, n3, track.j);
        }
        this.F = true;
    }
    
    private static int[] p(final int[] array, final int n) {
        if (array == null) {
            return new int[n];
        }
        if (array.length >= n) {
            return array;
        }
        return new int[Math.max(array.length * 2, n)];
    }
    
    private int q() {
        final int t = this.T;
        this.D();
        return t;
    }
    
    private static byte[] s(long n, final String s, final long n2) {
        Assertions.a(n != -9223372036854775807L);
        final int n3 = (int)(n / 3600000000L);
        n -= n3 * 3600L * 1000000L;
        final int n4 = (int)(n / 60000000L);
        n -= n4 * 60L * 1000000L;
        final int n5 = (int)(n / 1000000L);
        return Util.n0(String.format(Locale.US, s, n3, n4, n5, (int)((n - n5 * 1000000L) / n2)));
    }
    
    private static boolean y(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1951062397: {
                if (!s.equals("A_OPUS")) {
                    break;
                }
                n = 32;
                break;
            }
            case 1950789798: {
                if (!s.equals("A_FLAC")) {
                    break;
                }
                n = 31;
                break;
            }
            case 1950749482: {
                if (!s.equals("A_EAC3")) {
                    break;
                }
                n = 30;
                break;
            }
            case 1809237540: {
                if (!s.equals("V_MPEG2")) {
                    break;
                }
                n = 29;
                break;
            }
            case 1422270023: {
                if (!s.equals("S_TEXT/UTF8")) {
                    break;
                }
                n = 28;
                break;
            }
            case 1045209816: {
                if (!s.equals("S_TEXT/WEBVTT")) {
                    break;
                }
                n = 27;
                break;
            }
            case 855502857: {
                if (!s.equals("V_MPEGH/ISO/HEVC")) {
                    break;
                }
                n = 26;
                break;
            }
            case 738597099: {
                if (!s.equals("S_TEXT/ASS")) {
                    break;
                }
                n = 25;
                break;
            }
            case 725957860: {
                if (!s.equals("A_PCM/INT/LIT")) {
                    break;
                }
                n = 24;
                break;
            }
            case 725948237: {
                if (!s.equals("A_PCM/INT/BIG")) {
                    break;
                }
                n = 23;
                break;
            }
            case 635596514: {
                if (!s.equals("A_PCM/FLOAT/IEEE")) {
                    break;
                }
                n = 22;
                break;
            }
            case 542569478: {
                if (!s.equals("A_DTS/EXPRESS")) {
                    break;
                }
                n = 21;
                break;
            }
            case 444813526: {
                if (!s.equals("V_THEORA")) {
                    break;
                }
                n = 20;
                break;
            }
            case 99146302: {
                if (!s.equals("S_HDMV/PGS")) {
                    break;
                }
                n = 19;
                break;
            }
            case 82338134: {
                if (!s.equals("V_VP9")) {
                    break;
                }
                n = 18;
                break;
            }
            case 82338133: {
                if (!s.equals("V_VP8")) {
                    break;
                }
                n = 17;
                break;
            }
            case 82318131: {
                if (!s.equals("V_AV1")) {
                    break;
                }
                n = 16;
                break;
            }
            case 62927045: {
                if (!s.equals("A_DTS")) {
                    break;
                }
                n = 15;
                break;
            }
            case 62923603: {
                if (!s.equals("A_AC3")) {
                    break;
                }
                n = 14;
                break;
            }
            case 62923557: {
                if (!s.equals("A_AAC")) {
                    break;
                }
                n = 13;
                break;
            }
            case -356037306: {
                if (!s.equals("A_DTS/LOSSLESS")) {
                    break;
                }
                n = 12;
                break;
            }
            case -425012669: {
                if (!s.equals("S_VOBSUB")) {
                    break;
                }
                n = 11;
                break;
            }
            case -538363109: {
                if (!s.equals("V_MPEG4/ISO/AVC")) {
                    break;
                }
                n = 10;
                break;
            }
            case -538363189: {
                if (!s.equals("V_MPEG4/ISO/ASP")) {
                    break;
                }
                n = 9;
                break;
            }
            case -933872740: {
                if (!s.equals("S_DVBSUB")) {
                    break;
                }
                n = 8;
                break;
            }
            case -1373388978: {
                if (!s.equals("V_MS/VFW/FOURCC")) {
                    break;
                }
                n = 7;
                break;
            }
            case -1482641357: {
                if (!s.equals("A_MPEG/L3")) {
                    break;
                }
                n = 6;
                break;
            }
            case -1482641358: {
                if (!s.equals("A_MPEG/L2")) {
                    break;
                }
                n = 5;
                break;
            }
            case -1730367663: {
                if (!s.equals("A_VORBIS")) {
                    break;
                }
                n = 4;
                break;
            }
            case -1784763192: {
                if (!s.equals("A_TRUEHD")) {
                    break;
                }
                n = 3;
                break;
            }
            case -1985379776: {
                if (!s.equals("A_MS/ACM")) {
                    break;
                }
                n = 2;
                break;
            }
            case -2095575984: {
                if (!s.equals("V_MPEG4/ISO/SP")) {
                    break;
                }
                n = 1;
                break;
            }
            case -2095576542: {
                if (!s.equals("V_MPEG4/ISO/AP")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return false;
            }
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32: {
                return true;
            }
        }
    }
    
    protected void G(final int n, final long q, final long p3) throws ParserException {
        this.k();
        if (n != 160) {
            if (n != 174) {
                if (n != 187) {
                    if (n != 19899) {
                        if (n != 20533) {
                            if (n != 21968) {
                                if (n != 408125543) {
                                    if (n != 475249515) {
                                        if (n == 524531317) {
                                            if (!this.v) {
                                                if (this.d && this.z != -1L) {
                                                    this.y = true;
                                                }
                                                else {
                                                    this.b0.l(new SeekMap.Unseekable(this.t));
                                                    this.v = true;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        this.C = new LongArray();
                                        this.D = new LongArray();
                                    }
                                }
                                else {
                                    final long q2 = this.q;
                                    if (q2 != -1L && q2 != q) {
                                        throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
                                    }
                                    this.q = q;
                                    this.p = p3;
                                }
                            }
                            else {
                                this.t(n).x = true;
                            }
                        }
                        else {
                            this.t(n).h = true;
                        }
                    }
                    else {
                        this.w = -1;
                        this.x = -1L;
                    }
                }
                else {
                    this.E = false;
                }
            }
            else {
                this.u = new Track();
            }
        }
        else {
            this.Q = false;
            this.R = 0L;
        }
    }
    
    protected void H(final int n, final String s) throws ParserException {
        if (n != 134) {
            if (n != 17026) {
                if (n != 21358) {
                    if (n == 2274716) {
                        Track.d(this.t(n), s);
                    }
                }
                else {
                    this.t(n).a = s;
                }
            }
            else if (!"webm".equals(s)) {
                if (!"matroska".equals(s)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("DocType ");
                    sb.append(s);
                    sb.append(" not supported");
                    throw ParserException.createForMalformedContainer(sb.toString(), null);
                }
            }
        }
        else {
            this.t(n).b = s;
        }
    }
    
    @Override
    public void a(final long n, final long n2) {
        this.B = -9223372036854775807L;
        int i = 0;
        this.G = 0;
        this.a.reset();
        this.b.e();
        this.D();
        while (i < this.c.size()) {
            ((Track)this.c.valueAt(i)).n();
            ++i;
        }
    }
    
    @Override
    public final void b(final ExtractorOutput b0) {
        this.b0 = b0;
    }
    
    @Override
    public final boolean d(final ExtractorInput extractorInput) throws IOException {
        return new d().b(extractorInput);
    }
    
    @Override
    public final int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        int i = 0;
        this.F = false;
        boolean a = true;
        while (a && !this.F) {
            final boolean b = a = this.a.a(extractorInput);
            if (b) {
                a = b;
                if (this.B(positionHolder, extractorInput.getPosition())) {
                    return 1;
                }
                continue;
            }
        }
        if (!a) {
            while (i < this.c.size()) {
                final Track track = (Track)this.c.valueAt(i);
                Track.a(track);
                track.j();
                ++i;
            }
            return -1;
        }
        return 0;
    }
    
    protected void l(int n, int o, final ExtractorInput extractorInput) throws IOException {
        if (n != 161 && n != 163) {
            if (n != 165) {
                if (n != 16877) {
                    if (n != 16981) {
                        if (n != 18402) {
                            if (n != 21419) {
                                if (n != 25506) {
                                    if (n != 30322) {
                                        final StringBuilder sb = new StringBuilder();
                                        sb.append("Unexpected id: ");
                                        sb.append(n);
                                        throw ParserException.createForMalformedContainer(sb.toString(), null);
                                    }
                                    this.j(n);
                                    extractorInput.readFully(this.u.v = new byte[o], 0, o);
                                }
                                else {
                                    this.j(n);
                                    extractorInput.readFully(this.u.k = new byte[o], 0, o);
                                }
                            }
                            else {
                                Arrays.fill(this.i.d(), (byte)0);
                                extractorInput.readFully(this.i.d(), 4 - o, o);
                                this.i.P(0);
                                this.w = (int)this.i.F();
                            }
                        }
                        else {
                            final byte[] array = new byte[o];
                            extractorInput.readFully(array, 0, o);
                            this.t(n).j = new TrackOutput.CryptoData(1, array, 0, 0);
                        }
                    }
                    else {
                        this.j(n);
                        extractorInput.readFully(this.u.i = new byte[o], 0, o);
                    }
                }
                else {
                    this.v(this.t(n), extractorInput, o);
                }
            }
            else {
                if (this.G != 2) {
                    return;
                }
                this.w((Track)this.c.get(this.M), this.P, extractorInput, o);
            }
        }
        else {
            if (this.G == 0) {
                this.M = (int)this.b.d(extractorInput, false, true, 8);
                this.N = this.b.b();
                this.I = -9223372036854775807L;
                this.G = 1;
                this.g.L(0);
            }
            final Track track = (Track)this.c.get(this.M);
            if (track == null) {
                extractorInput.o(o - this.N);
                this.G = 0;
                return;
            }
            Track.a(track);
            if (this.G == 1) {
                this.C(extractorInput, 3);
                final int n2 = (this.g.d()[2] & 0x6) >> 1;
                if (n2 == 0) {
                    this.K = 1;
                    (this.L = p(this.L, 1))[0] = o - this.N - 3;
                }
                else {
                    int n3 = 4;
                    this.C(extractorInput, 4);
                    final int k = (this.g.d()[3] & 0xFF) + 1;
                    this.K = k;
                    final int[] p3 = p(this.L, k);
                    this.L = p3;
                    if (n2 == 2) {
                        final int n4 = this.N;
                        final int i = this.K;
                        Arrays.fill(p3, 0, i, (o - n4 - 4) / i);
                    }
                    else if (n2 == 1) {
                        int n5 = 0;
                        int n6 = 0;
                        int j;
                        while (true) {
                            j = this.K;
                            if (n5 >= j - 1) {
                                break;
                            }
                            this.L[n5] = 0;
                            int n7 = n3;
                            int l;
                            int[] m;
                            do {
                                n3 = n7 + 1;
                                this.C(extractorInput, n3);
                                l = (this.g.d()[n3 - 1] & 0xFF);
                                m = this.L;
                                m[n5] += l;
                                n7 = n3;
                            } while (l == 255);
                            n6 += m[n5];
                            ++n5;
                        }
                        this.L[j - 1] = o - this.N - n3 - n6;
                    }
                    else {
                        if (n2 != 3) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unexpected lacing value: ");
                            sb2.append(n2);
                            throw ParserException.createForMalformedContainer(sb2.toString(), null);
                        }
                        int n8 = 0;
                        int n9 = 0;
                    Label_0751:
                        while (true) {
                            final int k2 = this.K;
                            if (n8 >= k2 - 1) {
                                this.L[k2 - 1] = o - this.N - n3 - n9;
                                break;
                            }
                            this.L[n8] = 0;
                            ++n3;
                            this.C(extractorInput, n3);
                            final byte[] d = this.g.d();
                            int n10 = n3 - 1;
                            if (d[n10] != 0) {
                                int n11 = 0;
                                while (true) {
                                    while (n11 < 8) {
                                        final int n12 = 1 << 7 - n11;
                                        if ((this.g.d()[n10] & n12) != 0x0) {
                                            n3 += n11;
                                            this.C(extractorInput, n3);
                                            long n13 = ~n12 & (this.g.d()[n10] & 0xFF);
                                            ++n10;
                                            long n14;
                                            while (true) {
                                                n14 = n13;
                                                if (n10 >= n3) {
                                                    break;
                                                }
                                                n13 = (n14 << 8 | (long)(this.g.d()[n10] & 0xFF));
                                                ++n10;
                                            }
                                            long n15 = n14;
                                            if (n8 > 0) {
                                                n15 = n14 - ((1L << n11 * 7 + 6) - 1L);
                                            }
                                            if (n15 >= -2147483648L && n15 <= 2147483647L) {
                                                int n16 = (int)n15;
                                                final int[] l2 = this.L;
                                                if (n8 != 0) {
                                                    n16 += l2[n8 - 1];
                                                }
                                                l2[n8] = n16;
                                                n9 += l2[n8];
                                                ++n8;
                                                continue Label_0751;
                                            }
                                            throw ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
                                        }
                                        else {
                                            ++n11;
                                        }
                                    }
                                    long n15 = 0L;
                                    continue;
                                }
                            }
                            throw ParserException.createForMalformedContainer("No valid varint length mask found", null);
                        }
                    }
                }
                final byte b = this.g.d()[0];
                o = this.g.d()[1];
                this.H = this.B + this.E(b << 8 | (o & 0xFF));
                if (track.d != 2 && (n != 163 || (this.g.d()[2] & 0x80) != 0x80)) {
                    o = 0;
                }
                else {
                    o = 1;
                }
                this.O = o;
                this.G = 2;
                this.J = 0;
            }
            if (n == 163) {
                while (true) {
                    n = this.J;
                    if (n >= this.K) {
                        break;
                    }
                    n = this.I(extractorInput, track, this.L[n], false);
                    this.n(track, this.J * track.e / 1000 + this.H, this.O, n, 0);
                    ++this.J;
                }
                this.G = 0;
            }
            else {
                while (true) {
                    n = this.J;
                    if (n >= this.K) {
                        break;
                    }
                    final int[] l3 = this.L;
                    l3[n] = this.I(extractorInput, track, l3[n], true);
                    ++this.J;
                }
            }
        }
    }
    
    protected void o(int i) throws ParserException {
        this.k();
        if (i != 160) {
            if (i != 174) {
                if (i == 19899) {
                    i = this.w;
                    if (i != -1) {
                        final long x = this.x;
                        if (x != -1L) {
                            if (i == 475249515) {
                                this.z = x;
                            }
                            return;
                        }
                    }
                    throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
                }
                if (i != 25152) {
                    if (i != 28032) {
                        if (i != 357149030) {
                            if (i != 374648427) {
                                if (i == 475249515) {
                                    if (!this.v) {
                                        this.b0.l(this.m(this.C, this.D));
                                        this.v = true;
                                    }
                                    this.C = null;
                                    this.D = null;
                                }
                            }
                            else {
                                if (this.c.size() == 0) {
                                    throw ParserException.createForMalformedContainer("No valid tracks were found", null);
                                }
                                this.b0.o();
                            }
                        }
                        else {
                            if (this.r == -9223372036854775807L) {
                                this.r = 1000000L;
                            }
                            final long s = this.s;
                            if (s != -9223372036854775807L) {
                                this.t = this.E(s);
                            }
                        }
                    }
                    else {
                        this.j(i);
                        final Track u = this.u;
                        if (u.h) {
                            if (u.i != null) {
                                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
                            }
                        }
                    }
                }
                else {
                    this.j(i);
                    final Track u2 = this.u;
                    if (u2.h) {
                        if (u2.j == null) {
                            throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                        }
                        u2.l = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(com.google.android.exoplayer2.C.a, "video/webm", this.u.j.b) });
                    }
                }
            }
            else {
                final Track track = Assertions.i(this.u);
                final String b = track.b;
                if (b == null) {
                    throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
                }
                if (y(b)) {
                    track.i(this.b0, track.c);
                    this.c.put(track.c, (Object)track);
                }
                this.u = null;
            }
        }
        else {
            if (this.G != 2) {
                return;
            }
            final Track track2 = (Track)this.c.get(this.M);
            Track.a(track2);
            if (this.R > 0L && "A_OPUS".equals(track2.b)) {
                this.n.M(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int j = 0;
            i = 0;
            while (j < this.K) {
                i += this.L[j];
                ++j;
            }
            final int n = 0;
            int n2 = i;
            long h;
            long n3;
            int o;
            int n4;
            int n5;
            for (i = n; i < this.K; ++i) {
                h = this.H;
                n3 = track2.e * i / 1000;
                n4 = (o = this.O);
                if (i == 0) {
                    o = n4;
                    if (!this.Q) {
                        o = (n4 | 0x1);
                    }
                }
                n5 = this.L[i];
                n2 -= n5;
                this.n(track2, h + n3, o, n5, n2);
            }
            this.G = 0;
        }
    }
    
    protected void r(final int n, final double n2) throws ParserException {
        Label_0287: {
            if (n != 181) {
                if (n != 17545) {
                    switch (n) {
                        default: {
                            switch (n) {
                                default: {
                                    break Label_0287;
                                }
                                case 30325: {
                                    this.t(n).u = (float)n2;
                                    break Label_0287;
                                }
                                case 30324: {
                                    this.t(n).t = (float)n2;
                                    break Label_0287;
                                }
                                case 30323: {
                                    this.t(n).s = (float)n2;
                                    break Label_0287;
                                }
                            }
                            break;
                        }
                        case 21978: {
                            this.t(n).M = (float)n2;
                            break;
                        }
                        case 21977: {
                            this.t(n).L = (float)n2;
                            break;
                        }
                        case 21976: {
                            this.t(n).K = (float)n2;
                            break;
                        }
                        case 21975: {
                            this.t(n).J = (float)n2;
                            break;
                        }
                        case 21974: {
                            this.t(n).I = (float)n2;
                            break;
                        }
                        case 21973: {
                            this.t(n).H = (float)n2;
                            break;
                        }
                        case 21972: {
                            this.t(n).G = (float)n2;
                            break;
                        }
                        case 21971: {
                            this.t(n).F = (float)n2;
                            break;
                        }
                        case 21970: {
                            this.t(n).E = (float)n2;
                            break;
                        }
                        case 21969: {
                            this.t(n).D = (float)n2;
                            break;
                        }
                    }
                }
                else {
                    this.s = (long)n2;
                }
            }
            else {
                this.t(n).Q = (int)n2;
            }
        }
    }
    
    @Override
    public final void release() {
    }
    
    protected Track t(final int n) throws ParserException {
        this.j(n);
        return this.u;
    }
    
    protected int u(final int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325: {
                return 5;
            }
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322: {
                return 4;
            }
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317: {
                return 1;
            }
            case 134:
            case 17026:
            case 21358:
            case 2274716: {
                return 3;
            }
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729: {
                return 2;
            }
        }
    }
    
    protected void v(final Track track, final ExtractorInput extractorInput, final int n) throws IOException {
        if (Track.b(track) != 1685485123 && Track.b(track) != 1685480259) {
            extractorInput.o(n);
        }
        else {
            extractorInput.readFully(track.N = new byte[n], 0, n);
        }
    }
    
    protected void w(final Track track, final int n, final ExtractorInput extractorInput, final int n2) throws IOException {
        if (n == 4 && "V_VP9".equals(track.b)) {
            this.n.L(n2);
            extractorInput.readFully(this.n.d(), 0, n2);
        }
        else {
            extractorInput.o(n2);
        }
    }
    
    protected void x(int n, final long n2) throws ParserException {
        Label_1303: {
            if (n != 20529) {
                if (n != 20530) {
                    final boolean b = false;
                    boolean u = false;
                    switch (n) {
                        default: {
                            switch (n) {
                                default: {
                                    break Label_1303;
                                }
                                case 21949: {
                                    this.t(n).C = (int)n2;
                                    break Label_1303;
                                }
                                case 21948: {
                                    this.t(n).B = (int)n2;
                                    break Label_1303;
                                }
                                case 21947: {
                                    this.j(n);
                                    this.u.x = true;
                                    n = ColorInfo.b((int)n2);
                                    if (n != -1) {
                                        this.u.y = n;
                                        break Label_1303;
                                    }
                                    break Label_1303;
                                }
                                case 21946: {
                                    this.j(n);
                                    n = ColorInfo.c((int)n2);
                                    if (n != -1) {
                                        this.u.z = n;
                                        break Label_1303;
                                    }
                                    break Label_1303;
                                }
                                case 21945: {
                                    this.j(n);
                                    n = (int)n2;
                                    if (n == 1) {
                                        this.u.A = 2;
                                        break Label_1303;
                                    }
                                    if (n != 2) {
                                        break Label_1303;
                                    }
                                    this.u.A = 1;
                                    break Label_1303;
                                }
                            }
                            break;
                        }
                        case 2807729: {
                            this.r = n2;
                            break;
                        }
                        case 2352003: {
                            this.t(n).e = (int)n2;
                            break;
                        }
                        case 30321: {
                            this.j(n);
                            n = (int)n2;
                            if (n == 0) {
                                this.u.r = 0;
                                break;
                            }
                            if (n == 1) {
                                this.u.r = 1;
                                break;
                            }
                            if (n == 2) {
                                this.u.r = 2;
                                break;
                            }
                            if (n != 3) {
                                break;
                            }
                            this.u.r = 3;
                            break;
                        }
                        case 30114: {
                            this.R = n2;
                            break;
                        }
                        case 25188: {
                            this.t(n).P = (int)n2;
                            break;
                        }
                        case 22203: {
                            this.t(n).S = n2;
                            break;
                        }
                        case 22186: {
                            this.t(n).R = n2;
                            break;
                        }
                        case 21998: {
                            this.t(n).f = (int)n2;
                            break;
                        }
                        case 21930: {
                            final Track t = this.t(n);
                            if (n2 == 1L) {
                                u = true;
                            }
                            t.U = u;
                            break;
                        }
                        case 21690: {
                            this.t(n).p = (int)n2;
                            break;
                        }
                        case 21682: {
                            this.t(n).q = (int)n2;
                            break;
                        }
                        case 21680: {
                            this.t(n).o = (int)n2;
                            break;
                        }
                        case 21432: {
                            final int n3 = (int)n2;
                            this.j(n);
                            if (n3 == 0) {
                                this.u.w = 0;
                                break;
                            }
                            if (n3 == 1) {
                                this.u.w = 2;
                                break;
                            }
                            if (n3 == 3) {
                                this.u.w = 1;
                                break;
                            }
                            if (n3 != 15) {
                                break;
                            }
                            this.u.w = 3;
                            break;
                        }
                        case 21420: {
                            this.x = n2 + this.q;
                            break;
                        }
                        case 18408: {
                            if (n2 == 1L) {
                                break;
                            }
                            final StringBuilder sb = new StringBuilder();
                            sb.append("AESSettingsCipherMode ");
                            sb.append(n2);
                            sb.append(" not supported");
                            throw ParserException.createForMalformedContainer(sb.toString(), null);
                        }
                        case 18401: {
                            if (n2 == 5L) {
                                break;
                            }
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("ContentEncAlgo ");
                            sb2.append(n2);
                            sb2.append(" not supported");
                            throw ParserException.createForMalformedContainer(sb2.toString(), null);
                        }
                        case 17143: {
                            if (n2 == 1L) {
                                break;
                            }
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("EBMLReadVersion ");
                            sb3.append(n2);
                            sb3.append(" not supported");
                            throw ParserException.createForMalformedContainer(sb3.toString(), null);
                        }
                        case 17029: {
                            if (n2 >= 1L && n2 <= 2L) {
                                break;
                            }
                            final StringBuilder sb4 = new StringBuilder();
                            sb4.append("DocTypeReadVersion ");
                            sb4.append(n2);
                            sb4.append(" not supported");
                            throw ParserException.createForMalformedContainer(sb4.toString(), null);
                        }
                        case 16980: {
                            if (n2 == 3L) {
                                break;
                            }
                            final StringBuilder sb5 = new StringBuilder();
                            sb5.append("ContentCompAlgo ");
                            sb5.append(n2);
                            sb5.append(" not supported");
                            throw ParserException.createForMalformedContainer(sb5.toString(), null);
                        }
                        case 16871: {
                            Track.c(this.t(n), (int)n2);
                            break;
                        }
                        case 251: {
                            this.Q = true;
                            break;
                        }
                        case 241: {
                            if (!this.E) {
                                this.i(n);
                                this.D.a(n2);
                                this.E = true;
                                break;
                            }
                            break;
                        }
                        case 238: {
                            this.P = (int)n2;
                            break;
                        }
                        case 231: {
                            this.B = this.E(n2);
                            break;
                        }
                        case 215: {
                            this.t(n).c = (int)n2;
                            break;
                        }
                        case 186: {
                            this.t(n).n = (int)n2;
                            break;
                        }
                        case 179: {
                            this.i(n);
                            this.C.a(this.E(n2));
                            break;
                        }
                        case 176: {
                            this.t(n).m = (int)n2;
                            break;
                        }
                        case 159: {
                            this.t(n).O = (int)n2;
                            break;
                        }
                        case 155: {
                            this.I = this.E(n2);
                            break;
                        }
                        case 136: {
                            final Track t2 = this.t(n);
                            boolean v = b;
                            if (n2 == 1L) {
                                v = true;
                            }
                            t2.V = v;
                            break;
                        }
                        case 131: {
                            this.t(n).d = (int)n2;
                            break;
                        }
                    }
                }
                else if (n2 != 1L) {
                    final StringBuilder sb6 = new StringBuilder();
                    sb6.append("ContentEncodingScope ");
                    sb6.append(n2);
                    sb6.append(" not supported");
                    throw ParserException.createForMalformedContainer(sb6.toString(), null);
                }
            }
            else if (n2 != 0L) {
                final StringBuilder sb7 = new StringBuilder();
                sb7.append("ContentEncodingOrder ");
                sb7.append(n2);
                sb7.append(" not supported");
                throw ParserException.createForMalformedContainer(sb7.toString(), null);
            }
        }
    }
    
    protected boolean z(final int n) {
        return n == 357149030 || n == 524531317 || n == 475249515 || n == 374648427;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Flags {
    }
    
    protected static final class Track
    {
        public int A;
        public int B;
        public int C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public float L;
        public float M;
        public byte[] N;
        public int O;
        public int P;
        public int Q;
        public long R;
        public long S;
        public TrueHdSampleRechunker T;
        public boolean U;
        public boolean V;
        private String W;
        public TrackOutput X;
        public int Y;
        public String a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        private int g;
        public boolean h;
        public byte[] i;
        public TrackOutput.CryptoData j;
        public byte[] k;
        public DrmInitData l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public float s;
        public float t;
        public float u;
        public byte[] v;
        public int w;
        public boolean x;
        public int y;
        public int z;
        
        protected Track() {
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = -1;
            this.s = 0.0f;
            this.t = 0.0f;
            this.u = 0.0f;
            this.v = null;
            this.w = -1;
            this.x = false;
            this.y = -1;
            this.z = -1;
            this.A = -1;
            this.B = 1000;
            this.C = 200;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = -1.0f;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = -1.0f;
            this.O = 1;
            this.P = -1;
            this.Q = 8000;
            this.R = 0L;
            this.S = 0L;
            this.V = true;
            this.W = "eng";
        }
        
        static void a(final Track track) {
            track.f();
        }
        
        static int b(final Track track) {
            return track.g;
        }
        
        static int c(final Track track, final int g) {
            return track.g = g;
        }
        
        static String d(final Track track, final String w) {
            return track.W = w;
        }
        
        static boolean e(final Track track, final boolean b) {
            return track.o(b);
        }
        
        private void f() {
            Assertions.e(this.X);
        }
        
        private byte[] g(final String s) throws ParserException {
            final byte[] k = this.k;
            if (k != null) {
                return k;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Missing CodecPrivate for codec ");
            sb.append(s);
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        }
        
        private byte[] h() {
            if (this.D != -1.0f && this.E != -1.0f && this.F != -1.0f && this.G != -1.0f && this.H != -1.0f && this.I != -1.0f && this.J != -1.0f && this.K != -1.0f && this.L != -1.0f && this.M != -1.0f) {
                final byte[] array = new byte[25];
                final ByteBuffer order = ByteBuffer.wrap(array).order(ByteOrder.LITTLE_ENDIAN);
                order.put((byte)0);
                order.putShort((short)(this.D * 50000.0f + 0.5f));
                order.putShort((short)(this.E * 50000.0f + 0.5f));
                order.putShort((short)(this.F * 50000.0f + 0.5f));
                order.putShort((short)(this.G * 50000.0f + 0.5f));
                order.putShort((short)(this.H * 50000.0f + 0.5f));
                order.putShort((short)(this.I * 50000.0f + 0.5f));
                order.putShort((short)(this.J * 50000.0f + 0.5f));
                order.putShort((short)(this.K * 50000.0f + 0.5f));
                order.putShort((short)(this.L + 0.5f));
                order.putShort((short)(this.M + 0.5f));
                order.putShort((short)this.B);
                order.putShort((short)this.C);
                return array;
            }
            return null;
        }
        
        private static Pair<String, List<byte[]>> k(final ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.Q(16);
                final long t = parsableByteArray.t();
                if (t == 1482049860L) {
                    return (Pair<String, List<byte[]>>)new Pair((Object)"video/divx", (Object)null);
                }
                if (t == 859189832L) {
                    return (Pair<String, List<byte[]>>)new Pair((Object)"video/3gpp", (Object)null);
                }
                if (t == 826496599L) {
                    int i = parsableByteArray.e() + 20;
                    for (byte[] d = parsableByteArray.d(); i < d.length - 4; ++i) {
                        if (d[i] == 0 && d[i + 1] == 0 && d[i + 2] == 1 && d[i + 3] == 15) {
                            return (Pair<String, List<byte[]>>)new Pair((Object)"video/wvc1", (Object)Collections.singletonList(Arrays.copyOfRange(d, i, d.length)));
                        }
                    }
                    throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
                }
                Log.i("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return (Pair<String, List<byte[]>>)new Pair((Object)"video/x-unknown", (Object)null);
            }
            catch (final ArrayIndexOutOfBoundsException ex) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }
        
        private static boolean l(final ParsableByteArray parsableByteArray) throws ParserException {
            try {
                final int v = parsableByteArray.v();
                boolean b = true;
                if (v == 1) {
                    return true;
                }
                if (v == 65534) {
                    parsableByteArray.P(24);
                    if (parsableByteArray.w() != MatroskaExtractor.h().getMostSignificantBits() || parsableByteArray.w() != MatroskaExtractor.h().getLeastSignificantBits()) {
                        b = false;
                    }
                    return b;
                }
                return false;
            }
            catch (final ArrayIndexOutOfBoundsException ex) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
            }
        }
        
        private static List<byte[]> m(final byte[] array) throws ParserException {
            Label_0213: {
                if (array[0] != 2) {
                    break Label_0213;
                }
                int n = 0;
                int n2;
                for (n2 = 1; (array[n2] & 0xFF) == 0xFF; ++n2) {
                    n += 255;
                }
                final int n3 = n2 + 1;
                final int n4 = n + (array[n2] & 0xFF);
                int n5 = 0;
                int n6;
                for (n6 = n3; (array[n6] & 0xFF) == 0xFF; ++n6) {
                    n5 += 255;
                }
                final int n7 = n6 + 1;
                final byte b = array[n6];
                Label_0205: {
                    if (array[n7] != 1) {
                        break Label_0205;
                    }
                    try {
                        final byte[] array2 = new byte[n4];
                        System.arraycopy(array, n7, array2, 0, n4);
                        final int n8 = n7 + n4;
                        if (array[n8] != 3) {
                            throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                        }
                        final int n9 = n8 + (n5 + (b & 0xFF));
                        if (array[n9] == 5) {
                            final byte[] array3 = new byte[array.length - n9];
                            System.arraycopy(array, n9, array3, 0, array.length - n9);
                            final ArrayList list = new ArrayList(2);
                            list.add(array2);
                            list.add(array3);
                            return list;
                        }
                        throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                        throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                        throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                    }
                    catch (final ArrayIndexOutOfBoundsException ex) {
                        throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                    }
                }
            }
        }
        
        private boolean o(final boolean b) {
            if ("A_OPUS".equals(this.b)) {
                return b;
            }
            return this.f > 0;
        }
        
        public void i(final ExtractorOutput extractorOutput, final int n) throws ParserException {
            final String b = this.b;
            b.hashCode();
            int n2 = 0;
            Label_0982: {
                switch (b) {
                    case "A_OPUS": {
                        n2 = 32;
                        break Label_0982;
                    }
                    case "A_FLAC": {
                        n2 = 31;
                        break Label_0982;
                    }
                    case "A_EAC3": {
                        n2 = 30;
                        break Label_0982;
                    }
                    case "V_MPEG2": {
                        n2 = 29;
                        break Label_0982;
                    }
                    case "S_TEXT/UTF8": {
                        n2 = 28;
                        break Label_0982;
                    }
                    case "S_TEXT/WEBVTT": {
                        n2 = 27;
                        break Label_0982;
                    }
                    case "V_MPEGH/ISO/HEVC": {
                        n2 = 26;
                        break Label_0982;
                    }
                    case "S_TEXT/ASS": {
                        n2 = 25;
                        break Label_0982;
                    }
                    case "A_PCM/INT/LIT": {
                        n2 = 24;
                        break Label_0982;
                    }
                    case "A_PCM/INT/BIG": {
                        n2 = 23;
                        break Label_0982;
                    }
                    case "A_PCM/FLOAT/IEEE": {
                        n2 = 22;
                        break Label_0982;
                    }
                    case "A_DTS/EXPRESS": {
                        n2 = 21;
                        break Label_0982;
                    }
                    case "V_THEORA": {
                        n2 = 20;
                        break Label_0982;
                    }
                    case "S_HDMV/PGS": {
                        n2 = 19;
                        break Label_0982;
                    }
                    case "V_VP9": {
                        n2 = 18;
                        break Label_0982;
                    }
                    case "V_VP8": {
                        n2 = 17;
                        break Label_0982;
                    }
                    case "V_AV1": {
                        n2 = 16;
                        break Label_0982;
                    }
                    case "A_DTS": {
                        n2 = 15;
                        break Label_0982;
                    }
                    case "A_AC3": {
                        n2 = 14;
                        break Label_0982;
                    }
                    case "A_AAC": {
                        n2 = 13;
                        break Label_0982;
                    }
                    case "A_DTS/LOSSLESS": {
                        n2 = 12;
                        break Label_0982;
                    }
                    case "S_VOBSUB": {
                        n2 = 11;
                        break Label_0982;
                    }
                    case "V_MPEG4/ISO/AVC": {
                        n2 = 10;
                        break Label_0982;
                    }
                    case "V_MPEG4/ISO/ASP": {
                        n2 = 9;
                        break Label_0982;
                    }
                    case "S_DVBSUB": {
                        n2 = 8;
                        break Label_0982;
                    }
                    case "V_MS/VFW/FOURCC": {
                        n2 = 7;
                        break Label_0982;
                    }
                    case "A_MPEG/L3": {
                        n2 = 6;
                        break Label_0982;
                    }
                    case "A_MPEG/L2": {
                        n2 = 5;
                        break Label_0982;
                    }
                    case "A_VORBIS": {
                        n2 = 4;
                        break Label_0982;
                    }
                    case "A_TRUEHD": {
                        n2 = 3;
                        break Label_0982;
                    }
                    case "A_MS/ACM": {
                        n2 = 2;
                        break Label_0982;
                    }
                    case "V_MPEG4/ISO/SP": {
                        n2 = 1;
                        break Label_0982;
                    }
                    case "V_MPEG4/ISO/AP": {
                        n2 = 0;
                        break Label_0982;
                    }
                    default:
                        break;
                }
                n2 = -1;
            }
            final int n3 = 4096;
            String s = "audio/raw";
            final ColorInfo colorInfo = null;
            String s2 = null;
            String c = null;
            int n5 = 0;
            int n6 = 0;
            Object o2 = null;
        Label_2262:
            while (true) {
                Label_2216: {
                    int n4 = 0;
                    List<byte[]> m = null;
                    Label_2039: {
                        Label_2006: {
                            Label_1987: {
                                List<byte[]> list = null;
                                String s5 = null;
                                Label_1890: {
                                    Object o = null;
                                    Label_1717: {
                                        String s4 = null;
                                        Label_1696: {
                                            switch (n2) {
                                                default: {
                                                    throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", null);
                                                }
                                                case 32: {
                                                    n4 = 5760;
                                                    m = new ArrayList<byte[]>(3);
                                                    m.add(this.g(this.b));
                                                    final ByteBuffer allocate = ByteBuffer.allocate(8);
                                                    final ByteOrder little_ENDIAN = ByteOrder.LITTLE_ENDIAN;
                                                    m.add(allocate.order(little_ENDIAN).putLong(this.R).array());
                                                    m.add(ByteBuffer.allocate(8).order(little_ENDIAN).putLong(this.S).array());
                                                    s2 = "audio/opus";
                                                    break Label_2039;
                                                }
                                                case 31: {
                                                    o = Collections.singletonList(this.g(this.b));
                                                    final String s3 = "audio/flac";
                                                    break Label_1987;
                                                }
                                                case 30: {
                                                    s4 = "audio/eac3";
                                                    break Label_1696;
                                                }
                                                case 29: {
                                                    s4 = "video/mpeg2";
                                                    break Label_1696;
                                                }
                                                case 28: {
                                                    s4 = "application/x-subrip";
                                                    break Label_1696;
                                                }
                                                case 27: {
                                                    o = null;
                                                    c = null;
                                                    final String s3 = "text/vtt";
                                                    break Label_1710;
                                                }
                                                case 26: {
                                                    final HevcConfig a = HevcConfig.a(new ParsableByteArray(this.g(this.b)));
                                                    list = a.a;
                                                    this.Y = a.b;
                                                    s5 = a.f;
                                                    s2 = "video/hevc";
                                                    break Label_1890;
                                                }
                                                case 25: {
                                                    o = ImmutableList.of((Object)MatroskaExtractor.f(), (Object)this.g(this.b));
                                                    c = null;
                                                    final String s3 = "text/x-ssa";
                                                    break Label_1710;
                                                }
                                                case 24: {
                                                    if ((n5 = Util.c0(this.P)) == 0) {
                                                        final StringBuilder sb = new StringBuilder();
                                                        sb.append("Unsupported little endian PCM bit depth: ");
                                                        sb.append(this.P);
                                                        sb.append(". Setting mimeType to ");
                                                        sb.append("audio/x-unknown");
                                                        Log.i("MatroskaExtractor", sb.toString());
                                                        break Label_2216;
                                                    }
                                                    break;
                                                }
                                                case 23: {
                                                    final int p2 = this.P;
                                                    if (p2 == 8) {
                                                        o = null;
                                                        c = null;
                                                        n5 = 3;
                                                        break Label_1717;
                                                    }
                                                    if (p2 == 16) {
                                                        n5 = 268435456;
                                                        break;
                                                    }
                                                    final StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("Unsupported big endian PCM bit depth: ");
                                                    sb2.append(this.P);
                                                    sb2.append(". Setting mimeType to ");
                                                    sb2.append("audio/x-unknown");
                                                    Log.i("MatroskaExtractor", sb2.toString());
                                                    break Label_2216;
                                                }
                                                case 22: {
                                                    if (this.P == 32) {
                                                        o = null;
                                                        c = null;
                                                        n5 = 4;
                                                        break Label_1717;
                                                    }
                                                    final StringBuilder sb3 = new StringBuilder();
                                                    sb3.append("Unsupported floating point PCM bit depth: ");
                                                    sb3.append(this.P);
                                                    sb3.append(". Setting mimeType to ");
                                                    sb3.append("audio/x-unknown");
                                                    Log.i("MatroskaExtractor", sb3.toString());
                                                    break Label_2216;
                                                }
                                                case 20: {
                                                    s4 = "video/x-unknown";
                                                    break Label_1696;
                                                }
                                                case 19: {
                                                    o = null;
                                                    c = null;
                                                    final String s3 = "application/pgs";
                                                    break Label_1710;
                                                }
                                                case 18: {
                                                    s4 = "video/x-vnd.on2.vp9";
                                                    break Label_1696;
                                                }
                                                case 17: {
                                                    s4 = "video/x-vnd.on2.vp8";
                                                    break Label_1696;
                                                }
                                                case 16: {
                                                    s4 = "video/av01";
                                                    break Label_1696;
                                                }
                                                case 15:
                                                case 21: {
                                                    s4 = "audio/vnd.dts";
                                                    break Label_1696;
                                                }
                                                case 14: {
                                                    s4 = "audio/ac3";
                                                    break Label_1696;
                                                }
                                                case 13: {
                                                    o = Collections.singletonList(this.g(this.b));
                                                    final AacUtil.Config f = AacUtil.f(this.k);
                                                    this.Q = f.a;
                                                    this.O = f.b;
                                                    c = f.c;
                                                    final String s3 = "audio/mp4a-latm";
                                                    break Label_1710;
                                                }
                                                case 12: {
                                                    s4 = "audio/vnd.dts.hd";
                                                    break Label_1696;
                                                }
                                                case 11: {
                                                    o = ImmutableList.of((Object)this.g(this.b));
                                                    c = null;
                                                    final String s3 = "application/vobsub";
                                                    break Label_1710;
                                                }
                                                case 10: {
                                                    final AvcConfig b2 = AvcConfig.b(new ParsableByteArray(this.g(this.b)));
                                                    list = b2.a;
                                                    this.Y = b2.b;
                                                    s5 = b2.f;
                                                    s2 = "video/avc";
                                                    break Label_1890;
                                                }
                                                case 8: {
                                                    final byte[] array = new byte[4];
                                                    System.arraycopy(this.g(this.b), 0, array, 0, 4);
                                                    o = ImmutableList.of((Object)array);
                                                    final String s3 = "application/dvbsubs";
                                                    break Label_1987;
                                                }
                                                case 7: {
                                                    final Pair<String, List<byte[]>> k = k(new ParsableByteArray(this.g(this.b)));
                                                    final String s3 = (String)k.first;
                                                    o = k.second;
                                                    break Label_1987;
                                                }
                                                case 6: {
                                                    s2 = "audio/mpeg";
                                                    break Label_2006;
                                                }
                                                case 5: {
                                                    s2 = "audio/mpeg-L2";
                                                    break Label_2006;
                                                }
                                                case 4: {
                                                    n4 = 8192;
                                                    m = m(this.g(this.b));
                                                    s2 = "audio/vorbis";
                                                    break Label_2039;
                                                }
                                                case 3: {
                                                    this.T = new TrueHdSampleRechunker();
                                                    s4 = "audio/true-hd";
                                                    break Label_1696;
                                                }
                                                case 2: {
                                                    if (!l(new ParsableByteArray(this.g(this.b)))) {
                                                        final StringBuilder sb4 = new StringBuilder();
                                                        sb4.append("Non-PCM MS/ACM is unsupported. Setting mimeType to ");
                                                        sb4.append("audio/x-unknown");
                                                        Log.i("MatroskaExtractor", sb4.toString());
                                                        break Label_2216;
                                                    }
                                                    if ((n5 = Util.c0(this.P)) == 0) {
                                                        final StringBuilder sb5 = new StringBuilder();
                                                        sb5.append("Unsupported PCM bit depth: ");
                                                        sb5.append(this.P);
                                                        sb5.append(". Setting mimeType to ");
                                                        sb5.append("audio/x-unknown");
                                                        Log.i("MatroskaExtractor", sb5.toString());
                                                        break Label_2216;
                                                    }
                                                    break;
                                                }
                                                case 0:
                                                case 1:
                                                case 9: {
                                                    final byte[] i = this.k;
                                                    if (i == null) {
                                                        o = null;
                                                    }
                                                    else {
                                                        o = Collections.singletonList(i);
                                                    }
                                                    final String s3 = "video/mp4v-es";
                                                    break Label_1987;
                                                }
                                            }
                                            o = null;
                                            c = null;
                                            break Label_1717;
                                        }
                                        final List list2 = null;
                                        c = null;
                                        final String s3 = s4;
                                        o = list2;
                                        n5 = -1;
                                        s = s3;
                                    }
                                    n6 = -1;
                                    o2 = o;
                                    s2 = s;
                                    break Label_2262;
                                }
                                n5 = -1;
                                n6 = -1;
                                final String s6 = s5;
                                o2 = list;
                                c = s6;
                                break Label_2262;
                            }
                            c = null;
                            continue;
                        }
                        m = null;
                        n4 = n3;
                    }
                    final String s7 = null;
                    n6 = n4;
                    n5 = -1;
                    o2 = m;
                    c = s7;
                    break Label_2262;
                }
                Object o = null;
                c = null;
                final String s3 = "audio/x-unknown";
                continue;
            }
            final byte[] n7 = this.N;
            String c2 = c;
            String s8 = s2;
            if (n7 != null) {
                final DolbyVisionConfig a2 = DolbyVisionConfig.a(new ParsableByteArray(n7));
                c2 = c;
                s8 = s2;
                if (a2 != null) {
                    c2 = a2.c;
                    s8 = "video/dolby-vision";
                }
            }
            final boolean v = this.V;
            int n8;
            if (this.U) {
                n8 = 2;
            }
            else {
                n8 = 0;
            }
            final Format.Builder builder = new Format.Builder();
            int n9;
            if (MimeTypes.o(s8)) {
                builder.H(this.O).f0(this.Q).Y(n5);
                n9 = 1;
            }
            else if (MimeTypes.s(s8)) {
                if (this.q == 0) {
                    int o3;
                    if ((o3 = this.o) == -1) {
                        o3 = this.m;
                    }
                    this.o = o3;
                    int p3;
                    if ((p3 = this.p) == -1) {
                        p3 = this.n;
                    }
                    this.p = p3;
                }
                final int n10 = -1;
                final float n11 = -1.0f;
                final int o4 = this.o;
                float n12 = n11;
                if (o4 != -1) {
                    final int p4 = this.p;
                    n12 = n11;
                    if (p4 != -1) {
                        n12 = this.n * o4 / (float)(this.m * p4);
                    }
                }
                ColorInfo colorInfo2 = colorInfo;
                if (this.x) {
                    colorInfo2 = new ColorInfo(this.y, this.A, this.z, this.h());
                }
                int intValue = n10;
                if (this.a != null) {
                    intValue = n10;
                    if (MatroskaExtractor.g().containsKey(this.a)) {
                        intValue = MatroskaExtractor.g().get(this.a);
                    }
                }
                int n13 = intValue;
                if (this.r == 0) {
                    n13 = intValue;
                    if (Float.compare(this.s, 0.0f) == 0) {
                        n13 = intValue;
                        if (Float.compare(this.t, 0.0f) == 0) {
                            if (Float.compare(this.u, 0.0f) == 0) {
                                n13 = 0;
                            }
                            else if (Float.compare(this.t, 90.0f) == 0) {
                                n13 = 90;
                            }
                            else if (Float.compare(this.t, -180.0f) != 0 && Float.compare(this.t, 180.0f) != 0) {
                                n13 = intValue;
                                if (Float.compare(this.t, -90.0f) == 0) {
                                    n13 = 270;
                                }
                            }
                            else {
                                n13 = 180;
                            }
                        }
                    }
                }
                builder.j0(this.m).Q(this.n).a0(n12).d0(n13).b0(this.v).h0(this.w).J(colorInfo2);
                n9 = 2;
            }
            else {
                if (!"application/x-subrip".equals(s8) && !"text/x-ssa".equals(s8) && !"text/vtt".equals(s8) && !"application/vobsub".equals(s8) && !"application/pgs".equals(s8) && !"application/dvbsubs".equals(s8)) {
                    throw ParserException.createForMalformedContainer("Unexpected MIME type.", null);
                }
                n9 = 3;
            }
            if (this.a != null && !MatroskaExtractor.g().containsKey(this.a)) {
                builder.U(this.a);
            }
            (this.X = extractorOutput.e(this.c, n9)).d(builder.R(n).e0(s8).W(n6).V(this.W).g0(n8 | ((v | false) ? 1 : 0)).T((List<byte[]>)o2).I(c2).M(this.l).E());
        }
        
        public void j() {
            final TrueHdSampleRechunker t = this.T;
            if (t != null) {
                t.a(this.X, this.j);
            }
        }
        
        public void n() {
            final TrueHdSampleRechunker t = this.T;
            if (t != null) {
                t.b();
            }
        }
    }
    
    private final class b implements EbmlProcessor
    {
        final MatroskaExtractor a;
        
        private b(final MatroskaExtractor a) {
            this.a = a;
        }
        
        b(final MatroskaExtractor matroskaExtractor, final MatroskaExtractor$a object) {
            this(matroskaExtractor);
        }
        
        @Override
        public void a(final int n) throws ParserException {
            this.a.o(n);
        }
        
        @Override
        public void b(final int n, final double n2) throws ParserException {
            this.a.r(n, n2);
        }
        
        @Override
        public void c(final int n, final long n2) throws ParserException {
            this.a.x(n, n2);
        }
        
        @Override
        public int d(final int n) {
            return this.a.u(n);
        }
        
        @Override
        public boolean e(final int n) {
            return this.a.z(n);
        }
        
        @Override
        public void f(final int n, final int n2, final ExtractorInput extractorInput) throws IOException {
            this.a.l(n, n2, extractorInput);
        }
        
        @Override
        public void g(final int n, final String s) throws ParserException {
            this.a.H(n, s);
        }
        
        @Override
        public void h(final int n, final long n2, final long n3) throws ParserException {
            this.a.G(n, n2, n3);
        }
    }
}
