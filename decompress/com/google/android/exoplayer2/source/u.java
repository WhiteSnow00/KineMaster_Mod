// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import java.io.InterruptedIOException;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import java.io.IOException;
import java.util.Arrays;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.HashMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.upstream.DataSource;
import android.net.Uri;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import java.util.Map;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.extractor.ExtractorOutput;

final class u implements MediaPeriod, ExtractorOutput, Loader.Callback<a>, ReleaseCallback, UpstreamFormatChangedListener
{
    private static final Map<String, String> X;
    private static final Format Y;
    private final Handler A;
    private MediaPeriod.Callback B;
    private IcyHeaders C;
    private SampleQueue[] D;
    private d[] E;
    private boolean F;
    private boolean G;
    private boolean H;
    private e I;
    private SeekMap J;
    private long K;
    private boolean L;
    private int M;
    private boolean N;
    private boolean O;
    private int P;
    private boolean Q;
    private long R;
    private long S;
    private boolean T;
    private int U;
    private boolean V;
    private boolean W;
    private final Uri a;
    private final DataSource b;
    private final DrmSessionManager c;
    private final LoadErrorHandlingPolicy d;
    private final MediaSourceEventListener.EventDispatcher e;
    private final DrmSessionEventListener.EventDispatcher f;
    private final b g;
    private final Allocator h;
    private final String i;
    private final long j;
    private final Loader p;
    private final ProgressiveMediaExtractor w;
    private final ConditionVariable x;
    private final Runnable y;
    private final Runnable z;
    
    static {
        X = J();
        Y = new Format.Builder().S("icy").e0("application/x-icy").E();
    }
    
    public u(final Uri a, final DataSource b, final ProgressiveMediaExtractor w, final DrmSessionManager c, final DrmSessionEventListener.EventDispatcher f, final LoadErrorHandlingPolicy d, final MediaSourceEventListener.EventDispatcher e, final b g, final Allocator h, final String i, final int n) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.f = f;
        this.d = d;
        this.e = e;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = n;
        this.p = new Loader("ProgressiveMediaPeriod");
        this.w = w;
        this.x = new ConditionVariable();
        this.y = new q(this);
        this.z = new s(this);
        this.A = Util.w();
        this.E = new d[0];
        this.D = new SampleQueue[0];
        this.S = -9223372036854775807L;
        this.K = -9223372036854775807L;
        this.M = 1;
    }
    
    static String B(final u u) {
        return u.i;
    }
    
    static void C(final u u) {
        u.Y();
    }
    
    static IcyHeaders D(final u u) {
        return u.C;
    }
    
    static IcyHeaders E(final u u, final IcyHeaders c) {
        return u.C = c;
    }
    
    static Format F() {
        return u.Y;
    }
    
    static long G(final u u) {
        return u.j;
    }
    
    private void H() {
        Assertions.g(this.G);
        Assertions.e(this.I);
        Assertions.e(this.J);
    }
    
    private boolean I(final a a, int i) {
        if (!this.Q) {
            final SeekMap j = this.J;
            if (j == null || j.i() == -9223372036854775807L) {
                final boolean g = this.G;
                i = 0;
                if (g && !this.j0()) {
                    this.T = true;
                    return false;
                }
                this.O = this.G;
                this.R = 0L;
                this.U = 0;
                for (SampleQueue[] d = this.D; i < d.length; ++i) {
                    d[i].V();
                }
                u.a.h(a, 0L, 0L);
                return true;
            }
        }
        this.U = i;
        return true;
    }
    
    private static Map<String, String> J() {
        final HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return (Map<String, String>)Collections.unmodifiableMap((Map<?, ?>)hashMap);
    }
    
    private int K() {
        final SampleQueue[] d = this.D;
        final int length = d.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            n += d[i].G();
            ++i;
        }
        return n;
    }
    
    private long M(final boolean b) {
        long n = Long.MIN_VALUE;
        long max;
        for (int i = 0; i < this.D.length; ++i, n = max) {
            if (!b) {
                max = n;
                if (!Assertions.e(this.I).c[i]) {
                    continue;
                }
            }
            max = Math.max(n, this.D[i].z());
        }
        return n;
    }
    
    private boolean O() {
        return this.S != -9223372036854775807L;
    }
    
    private void Q() {
        if (!this.W) {
            ((SequenceableLoader.Callback<u>)Assertions.e(this.B)).l(this);
        }
    }
    
    private void R() {
        this.Q = true;
    }
    
    private void S(final SeekMap seekMap) {
        this.g0(seekMap);
    }
    
    private void T() {
        if (!this.W && !this.G && this.F) {
            if (this.J != null) {
                final SampleQueue[] d = this.D;
                for (int length = d.length, i = 0; i < length; ++i) {
                    if (d[i].F() == null) {
                        return;
                    }
                }
                this.x.d();
                final int length2 = this.D.length;
                final TrackGroup[] array = new TrackGroup[length2];
                final boolean[] array2 = new boolean[length2];
                for (int j = 0; j < length2; ++j) {
                    final Format format = Assertions.e(this.D[j].F());
                    final String w = format.w;
                    final boolean o = MimeTypes.o(w);
                    final boolean b = o || MimeTypes.s(w);
                    array2[j] = b;
                    this.H |= b;
                    final IcyHeaders c = this.C;
                    Format e = format;
                    if (c != null) {
                        Format e2 = null;
                        Label_0266: {
                            if (!o) {
                                e2 = format;
                                if (!this.E[j].b) {
                                    break Label_0266;
                                }
                            }
                            final Metadata k = format.j;
                            Metadata a;
                            if (k == null) {
                                a = new Metadata(new Metadata.Entry[] { c });
                            }
                            else {
                                a = k.a(c);
                            }
                            e2 = format.b().X(a).E();
                        }
                        e = e2;
                        if (o) {
                            e = e2;
                            if (e2.f == -1) {
                                e = e2;
                                if (e2.g == -1) {
                                    e = e2;
                                    if (c.a != -1) {
                                        e = e2.b().G(c.a).E();
                                    }
                                }
                            }
                        }
                    }
                    array[j] = new TrackGroup(Integer.toString(j), new Format[] { e.c(this.c.a(e)) });
                }
                this.I = new e(new TrackGroupArray(array), array2);
                this.G = true;
                Assertions.e(this.B).o(this);
            }
        }
    }
    
    private void U(final int n) {
        this.H();
        final e i = this.I;
        final boolean[] d = i.d;
        if (!d[n]) {
            final Format c = i.a.b(n).c(0);
            this.e.i(MimeTypes.k(c.w), c, 0, null, this.R);
            d[n] = true;
        }
    }
    
    private void V(int i) {
        this.H();
        final boolean[] b = this.I.b;
        if (this.T && b[i]) {
            final SampleQueue sampleQueue = this.D[i];
            i = 0;
            if (!sampleQueue.K(false)) {
                this.S = 0L;
                this.T = false;
                this.O = true;
                this.R = 0L;
                this.U = 0;
                for (SampleQueue[] d = this.D; i < d.length; ++i) {
                    d[i].V();
                }
                ((SequenceableLoader.Callback<u>)Assertions.e(this.B)).l(this);
            }
        }
    }
    
    private void Y() {
        this.A.post((Runnable)new r(this));
    }
    
    private TrackOutput c0(final d d) {
        final int length = this.D.length;
        for (int i = 0; i < length; ++i) {
            if (d.equals(this.E[i])) {
                return this.D[i];
            }
        }
        final SampleQueue k = SampleQueue.k(this.h, this.c, this.f);
        k.d0((SampleQueue.UpstreamFormatChangedListener)this);
        final d[] e = this.E;
        final int n = length + 1;
        final d[] array = Arrays.copyOf(e, n);
        array[length] = d;
        this.E = Util.k(array);
        final SampleQueue[] array2 = Arrays.copyOf(this.D, n);
        array2[length] = k;
        this.D = Util.k(array2);
        return k;
    }
    
    private boolean f0(final boolean[] array, final long n) {
        for (int length = this.D.length, i = 0; i < length; ++i) {
            if (!this.D[i].Z(n, false) && (array[i] || !this.H)) {
                return false;
            }
        }
        return true;
    }
    
    private void g0(final SeekMap seekMap) {
        SeekMap j;
        if (this.C == null) {
            j = seekMap;
        }
        else {
            j = new SeekMap.Unseekable(-9223372036854775807L);
        }
        this.J = j;
        this.K = seekMap.i();
        final boolean q = this.Q;
        int m = 1;
        final boolean l = !q && seekMap.i() == -9223372036854775807L;
        this.L = l;
        if (l) {
            m = 7;
        }
        this.M = m;
        this.g.R(this.K, seekMap.h(), this.L);
        if (!this.G) {
            this.T();
        }
    }
    
    private void i0() {
        final a a = new a(this.a, this.b, this.w, this, this.x);
        if (this.G) {
            Assertions.g(this.O());
            final long k = this.K;
            if (k != -9223372036854775807L && this.S > k) {
                this.V = true;
                this.S = -9223372036854775807L;
                return;
            }
            u.a.h(a, Assertions.e(this.J).f(this.S).a.b, this.S);
            final SampleQueue[] d = this.D;
            for (int length = d.length, i = 0; i < length; ++i) {
                d[i].b0(this.S);
            }
            this.S = -9223372036854775807L;
        }
        this.U = this.K();
        this.e.A(new LoadEventInfo(u.a.e(a), u.a.f(a), this.p.n(a, (Loader.Callback<a>)this, this.d.b(this.M))), 1, -1, null, 0, null, u.a.g(a), this.K);
    }
    
    private boolean j0() {
        return this.O || this.O();
    }
    
    public static void r(final u u) {
        u.T();
    }
    
    public static void s(final u u) {
        u.R();
    }
    
    public static void t(final u u, final SeekMap seekMap) {
        u.S(seekMap);
    }
    
    public static void u(final u u) {
        u.Q();
    }
    
    static Runnable w(final u u) {
        return u.z;
    }
    
    static Handler x(final u u) {
        return u.A;
    }
    
    static long y(final u u, final boolean b) {
        return u.M(b);
    }
    
    static Map z() {
        return u.X;
    }
    
    @Override
    public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
        this.a0((a)loadable, n, n2);
    }
    
    @Override
    public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
        return this.b0((a)loadable, n, n2, ex, n3);
    }
    
    TrackOutput N() {
        return this.c0(new d(0, true));
    }
    
    boolean P(final int n) {
        return !this.j0() && this.D[n].K(this.V);
    }
    
    void W() throws IOException {
        this.p.k(this.d.b(this.M));
    }
    
    void X(final int n) throws IOException {
        this.D[n].N();
        this.W();
    }
    
    public void Z(final a a, final long n, final long n2, final boolean b) {
        final StatsDataSource d = u.a.d(a);
        final LoadEventInfo loadEventInfo = new LoadEventInfo(u.a.e(a), u.a.f(a), d.s(), d.t(), n, n2, d.j());
        this.d.d(u.a.e(a));
        this.e.r(loadEventInfo, 1, -1, null, 0, null, u.a.g(a), this.K);
        if (!b) {
            final SampleQueue[] d2 = this.D;
            for (int length = d2.length, i = 0; i < length; ++i) {
                d2[i].V();
            }
            if (this.P > 0) {
                ((SequenceableLoader.Callback<u>)Assertions.e(this.B)).l(this);
            }
        }
    }
    
    @Override
    public void a(final Format format) {
        this.A.post(this.y);
    }
    
    public void a0(final a a, final long n, final long n2) {
        if (this.K == -9223372036854775807L) {
            final SeekMap j = this.J;
            if (j != null) {
                final boolean h = j.h();
                final long m = this.M(true);
                long k;
                if (m == Long.MIN_VALUE) {
                    k = 0L;
                }
                else {
                    k = m + 10000L;
                }
                this.K = k;
                this.g.R(k, h, this.L);
            }
        }
        final StatsDataSource d = u.a.d(a);
        final LoadEventInfo loadEventInfo = new LoadEventInfo(u.a.e(a), u.a.f(a), d.s(), d.t(), n, n2, d.j());
        this.d.d(u.a.e(a));
        this.e.u(loadEventInfo, 1, -1, null, 0, null, u.a.g(a), this.K);
        this.V = true;
        ((SequenceableLoader.Callback<u>)Assertions.e(this.B)).l(this);
    }
    
    @Override
    public long b() {
        return this.f();
    }
    
    public LoadErrorAction b0(final a a, long a2, final long n, final IOException ex, int k) {
        final StatsDataSource d = u.a.d(a);
        final LoadEventInfo loadEventInfo = new LoadEventInfo(u.a.e(a), u.a.f(a), d.s(), d.t(), a2, n, d.j());
        a2 = this.d.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, null, 0, null, Util.f1(u.a.g(a)), Util.f1(this.K)), ex, k));
        Loader.LoadErrorAction loadErrorAction;
        if (a2 == -9223372036854775807L) {
            loadErrorAction = Loader.g;
        }
        else {
            k = this.K();
            final boolean b = k > this.U;
            if (this.I(a, k)) {
                loadErrorAction = Loader.h(b, a2);
            }
            else {
                loadErrorAction = Loader.f;
            }
        }
        final boolean b2 = loadErrorAction.c() ^ true;
        this.e.w(loadEventInfo, 1, -1, null, 0, null, u.a.g(a), this.K, ex, b2);
        if (b2) {
            this.d.d(u.a.e(a));
        }
        return loadErrorAction;
    }
    
    @Override
    public long c(final long n, final SeekParameters seekParameters) {
        this.H();
        if (!this.J.h()) {
            return 0L;
        }
        final SeekMap.SeekPoints f = this.J.f(n);
        return seekParameters.a(n, f.a.a, f.b.a);
    }
    
    @Override
    public boolean d(final long n) {
        if (!this.V && !this.p.i() && !this.T && (!this.G || this.P != 0)) {
            boolean f = this.x.f();
            if (!this.p.j()) {
                this.i0();
                f = true;
            }
            return f;
        }
        return false;
    }
    
    int d0(final int n, final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, int s) {
        if (this.j0()) {
            return -3;
        }
        this.U(n);
        s = this.D[n].S(formatHolder, decoderInputBuffer, s, this.V);
        if (s == -3) {
            this.V(n);
        }
        return s;
    }
    
    @Override
    public TrackOutput e(final int n, final int n2) {
        return this.c0(new d(n, false));
    }
    
    public void e0() {
        if (this.G) {
            final SampleQueue[] d = this.D;
            for (int length = d.length, i = 0; i < length; ++i) {
                d[i].R();
            }
        }
        this.p.m((Loader.ReleaseCallback)this);
        this.A.removeCallbacksAndMessages((Object)null);
        this.B = null;
        this.W = true;
    }
    
    @Override
    public long f() {
        this.H();
        if (this.V || this.P == 0) {
            return Long.MIN_VALUE;
        }
        if (this.O()) {
            return this.S;
        }
        long n3;
        if (this.H) {
            final int length = this.D.length;
            int n = 0;
            long n2 = Long.MAX_VALUE;
            while (true) {
                n3 = n2;
                if (n >= length) {
                    break;
                }
                final e i = this.I;
                long min = n2;
                if (i.b[n]) {
                    min = n2;
                    if (i.c[n]) {
                        min = n2;
                        if (!this.D[n].J()) {
                            min = Math.min(n2, this.D[n].z());
                        }
                    }
                }
                ++n;
                n2 = min;
            }
        }
        else {
            n3 = Long.MAX_VALUE;
        }
        long m = n3;
        if (n3 == Long.MAX_VALUE) {
            m = this.M(false);
        }
        long r = m;
        if (m == Long.MIN_VALUE) {
            r = this.R;
        }
        return r;
    }
    
    @Override
    public void g(final long n) {
    }
    
    @Override
    public long h(long s) {
        this.H();
        final boolean[] b = this.I.b;
        if (!this.J.h()) {
            s = 0L;
        }
        int i = 0;
        final int n = 0;
        this.O = false;
        this.R = s;
        if (this.O()) {
            return this.S = s;
        }
        if (this.M != 7 && this.f0(b, s)) {
            return s;
        }
        this.T = false;
        this.S = s;
        this.V = false;
        if (this.p.j()) {
            final SampleQueue[] d = this.D;
            for (int length = d.length, j = n; j < length; ++j) {
                d[j].r();
            }
            this.p.f();
        }
        else {
            this.p.g();
            for (SampleQueue[] d2 = this.D; i < d2.length; ++i) {
                d2[i].V();
            }
        }
        return s;
    }
    
    int h0(final int n, final long n2) {
        if (this.j0()) {
            return 0;
        }
        this.U(n);
        final SampleQueue sampleQueue = this.D[n];
        final int e = sampleQueue.E(n2, this.V);
        sampleQueue.e0(e);
        if (e == 0) {
            this.V(n);
        }
        return e;
    }
    
    @Override
    public long i() {
        if (this.O && (this.V || this.K() > this.U)) {
            this.O = false;
            return this.R;
        }
        return -9223372036854775807L;
    }
    
    @Override
    public boolean isLoading() {
        return this.p.j() && this.x.e();
    }
    
    @Override
    public void j(final MediaPeriod.Callback b, final long n) {
        this.B = b;
        this.x.f();
        this.i0();
    }
    
    @Override
    public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, long h) {
        this.H();
        final e i = this.I;
        final TrackGroupArray a = i.a;
        final boolean[] c = i.c;
        final int p5 = this.P;
        final int n = 0;
        final int n2 = 0;
        final int n3 = 0;
        for (int j = 0; j < array.length; ++j) {
            if (array3[j] != null && (array[j] == null || !array2[j])) {
                final int b = u.c.b((c)array3[j]);
                Assertions.g(c[b]);
                --this.P;
                c[b] = false;
                array3[j] = null;
            }
        }
        final boolean b2 = this.N ? (p5 == 0) : (h != 0L);
        int k = 0;
        int n4 = b2 ? 1 : 0;
        while (k < array.length) {
            int n5 = n4;
            if (array3[k] == null) {
                n5 = n4;
                if (array[k] != null) {
                    final ExoTrackSelection exoTrackSelection = array[k];
                    Assertions.g(exoTrackSelection.length() == 1);
                    Assertions.g(exoTrackSelection.g(0) == 0);
                    final int c2 = a.c(exoTrackSelection.l());
                    Assertions.g(c[c2] ^ true);
                    ++this.P;
                    c[c2] = true;
                    array3[k] = new c(c2);
                    array4[k] = true;
                    if ((n5 = n4) == 0) {
                        final SampleQueue sampleQueue = this.D[c2];
                        if (!sampleQueue.Z(h, true) && sampleQueue.C() != 0) {
                            n5 = 1;
                        }
                        else {
                            n5 = 0;
                        }
                    }
                }
            }
            ++k;
            n4 = n5;
        }
        long n6;
        if (this.P == 0) {
            this.T = false;
            this.O = false;
            if (this.p.j()) {
                final SampleQueue[] d = this.D;
                for (int length = d.length, l = n3; l < length; ++l) {
                    d[l].r();
                }
                this.p.f();
                n6 = h;
            }
            else {
                final SampleQueue[] d2 = this.D;
                final int length2 = d2.length;
                int n7 = n;
                while (true) {
                    n6 = h;
                    if (n7 >= length2) {
                        break;
                    }
                    d2[n7].V();
                    ++n7;
                }
            }
        }
        else {
            n6 = h;
            if (n4 != 0) {
                h = this.h(h);
                int n8 = n2;
                while (true) {
                    n6 = h;
                    if (n8 >= array3.length) {
                        break;
                    }
                    if (array3[n8] != null) {
                        array4[n8] = true;
                    }
                    ++n8;
                }
            }
        }
        this.N = true;
        return n6;
    }
    
    @Override
    public void l(final SeekMap seekMap) {
        this.A.post((Runnable)new t(this, seekMap));
    }
    
    @Override
    public void m() {
        final SampleQueue[] d = this.D;
        for (int length = d.length, i = 0; i < length; ++i) {
            d[i].T();
        }
        this.w.release();
    }
    
    @Override
    public void n() throws IOException {
        this.W();
        if (this.V && !this.G) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }
    
    @Override
    public void o() {
        this.F = true;
        this.A.post(this.y);
    }
    
    @Override
    public TrackGroupArray p() {
        this.H();
        return this.I.a;
    }
    
    @Override
    public void q(final long n, final boolean b) {
        this.H();
        if (this.O()) {
            return;
        }
        final boolean[] c = this.I.c;
        for (int length = this.D.length, i = 0; i < length; ++i) {
            this.D[i].q(n, b, c[i]);
        }
    }
    
    @Override
    public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
        this.Z((a)loadable, n, n2, b);
    }
    
    final class a implements Loadable, Listener
    {
        private final long a;
        private final Uri b;
        private final StatsDataSource c;
        private final ProgressiveMediaExtractor d;
        private final ExtractorOutput e;
        private final ConditionVariable f;
        private final PositionHolder g;
        private volatile boolean h;
        private boolean i;
        private long j;
        private DataSpec k;
        private TrackOutput l;
        private boolean m;
        final u n;
        
        public a(final u n, final Uri b, final DataSource dataSource, final ProgressiveMediaExtractor d, final ExtractorOutput e, final ConditionVariable f) {
            this.n = n;
            this.b = b;
            this.c = new StatsDataSource(dataSource);
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = new PositionHolder();
            this.i = true;
            this.a = LoadEventInfo.a();
            this.k = this.i(0L);
        }
        
        static StatsDataSource d(final a a) {
            return a.c;
        }
        
        static long e(final a a) {
            return a.a;
        }
        
        static DataSpec f(final a a) {
            return a.k;
        }
        
        static long g(final a a) {
            return a.j;
        }
        
        static void h(final a a, final long n, final long n2) {
            a.j(n, n2);
        }
        
        private DataSpec i(final long n) {
            return new DataSpec.Builder().i(this.b).h(n).f(u.B(this.n)).b(6).e(u.z()).a();
        }
        
        private void j(final long a, final long j) {
            this.g.a = a;
            this.j = j;
            this.i = true;
            this.m = false;
        }
        
        @Override
        public void a() throws IOException {
            int i = 0;
            while (i == 0 && !this.h) {
                int b = i;
                try {
                    final long a = this.g.a;
                    b = i;
                    final DataSpec j = this.i(a);
                    b = i;
                    this.k = j;
                    b = i;
                    long b2;
                    final long n = b2 = this.c.b(j);
                    if (n != -1L) {
                        b2 = n + a;
                        b = i;
                        u.C(this.n);
                    }
                    b = i;
                    u.E(this.n, IcyHeaders.a(this.c.g()));
                    b = i;
                    DataSource c;
                    final StatsDataSource statsDataSource = (StatsDataSource)(c = this.c);
                    b = i;
                    if (u.D(this.n) != null) {
                        c = statsDataSource;
                        b = i;
                        if (u.D(this.n).f != -1) {
                            b = i;
                            c = new(com.google.android.exoplayer2.source.IcyDataSource.class)();
                            b = i;
                            new IcyDataSource(this.c, u.D(this.n).f, (IcyDataSource.Listener)this);
                            b = i;
                            final TrackOutput n2 = this.n.N();
                            b = i;
                            this.l = n2;
                            b = i;
                            n2.d(u.F());
                        }
                    }
                    b = i;
                    final ProgressiveMediaExtractor d = this.d;
                    b = i;
                    final Uri b3 = this.b;
                    b = i;
                    final Map<String, List<String>> g = this.c.g();
                    b = i;
                    final ExtractorOutput e = this.e;
                    final long n3 = a;
                    b = i;
                    d.d(c, b3, g, a, b2, e);
                    b = i;
                    if (u.D(this.n) != null) {
                        b = i;
                        this.d.c();
                    }
                    int n4 = i;
                    long e2 = n3;
                    b = i;
                    if (this.i) {
                        b = i;
                        this.d.a(n3, this.j);
                        b = i;
                        this.i = false;
                        e2 = n3;
                        n4 = i;
                    }
                Label_0336:
                    while (true) {
                        final long n5 = e2;
                        i = n4;
                        while (i == 0) {
                            b = i;
                            if (!this.h) {
                                b = i;
                                try {
                                    this.f.a();
                                    b = i;
                                    n4 = (b = this.d.b(this.g));
                                    e2 = this.d.e();
                                    i = n4;
                                    b = n4;
                                    if (e2 > u.G(this.n) + n5) {
                                        b = n4;
                                        this.f.d();
                                        b = n4;
                                        u.x(this.n).post(u.w(this.n));
                                        continue Label_0336;
                                    }
                                    continue;
                                }
                                catch (final InterruptedException ex) {
                                    b = i;
                                    b = i;
                                    final InterruptedIOException ex2 = new InterruptedIOException();
                                    b = i;
                                    throw ex2;
                                }
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    if (i == 1) {
                        b = 0;
                    }
                    else {
                        b = i;
                        if (this.d.e() != -1L) {
                            this.g.a = this.d.e();
                            b = i;
                        }
                    }
                    DataSourceUtil.a(this.c);
                    i = b;
                    continue;
                }
                finally {
                    if (b != 1 && this.d.e() != -1L) {
                        this.g.a = this.d.e();
                    }
                    DataSourceUtil.a(this.c);
                }
                break;
            }
        }
        
        @Override
        public void b(final ParsableByteArray parsableByteArray) {
            long n;
            if (!this.m) {
                n = this.j;
            }
            else {
                n = Math.max(u.y(this.n, true), this.j);
            }
            final int a = parsableByteArray.a();
            final TrackOutput trackOutput = Assertions.e(this.l);
            trackOutput.c(parsableByteArray, a);
            trackOutput.e(n, 1, a, 0, null);
            this.m = true;
        }
        
        @Override
        public void c() {
            this.h = true;
        }
    }
    
    interface b
    {
        void R(final long p0, final boolean p1, final boolean p2);
    }
    
    private final class c implements SampleStream
    {
        private final int a;
        final u b;
        
        public c(final u b, final int a) {
            this.b = b;
            this.a = a;
        }
        
        static int b(final c c) {
            return c.a;
        }
        
        @Override
        public void a() throws IOException {
            this.b.X(this.a);
        }
        
        @Override
        public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
            return this.b.d0(this.a, formatHolder, decoderInputBuffer, n);
        }
        
        @Override
        public boolean isReady() {
            return this.b.P(this.a);
        }
        
        @Override
        public int l(final long n) {
            return this.b.h0(this.a, n);
        }
    }
    
    private static final class d
    {
        public final int a;
        public final boolean b;
        
        public d(final int a, final boolean b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && d.class == o.getClass()) {
                final d d = (d)o;
                if (this.a != d.a || this.b != d.b) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return this.a * 31 + (this.b ? 1 : 0);
        }
    }
    
    private static final class e
    {
        public final TrackGroupArray a;
        public final boolean[] b;
        public final boolean[] c;
        public final boolean[] d;
        
        public e(final TrackGroupArray a, final boolean[] b) {
            this.a = a;
            this.b = b;
            final int a2 = a.a;
            this.c = new boolean[a2];
            this.d = new boolean[a2];
        }
    }
}
