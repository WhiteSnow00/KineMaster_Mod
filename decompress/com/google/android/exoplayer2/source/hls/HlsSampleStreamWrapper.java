// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import java.io.EOFException;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import java.util.Objects;
import com.google.android.exoplayer2.SeekParameters;
import android.net.Uri;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.source.LoadEventInfo;
import java.io.IOException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.source.SampleStream;
import java.util.Iterator;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Map;
import java.util.ArrayList;
import android.os.Handler;
import java.util.Set;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.upstream.Loader;

final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, ReleaseCallback, SequenceableLoader, ExtractorOutput, UpstreamFormatChangedListener
{
    private static final Set<Integer> j0;
    private final Runnable A;
    private final Runnable B;
    private final Handler C;
    private final ArrayList<com.google.android.exoplayer2.source.hls.c> D;
    private final Map<String, DrmInitData> E;
    private Chunk F;
    private c[] G;
    private int[] H;
    private Set<Integer> I;
    private SparseIntArray J;
    private TrackOutput K;
    private int L;
    private int M;
    private boolean N;
    private boolean O;
    private int P;
    private Format Q;
    private Format R;
    private boolean S;
    private TrackGroupArray T;
    private Set<TrackGroup> U;
    private int[] V;
    private int W;
    private boolean X;
    private boolean[] Y;
    private boolean[] Z;
    private final String a;
    private long a0;
    private final int b;
    private long b0;
    private final Callback c;
    private boolean c0;
    private final HlsChunkSource d;
    private boolean d0;
    private final Allocator e;
    private boolean e0;
    private final Format f;
    private boolean f0;
    private final DrmSessionManager g;
    private long g0;
    private final DrmSessionEventListener.EventDispatcher h;
    private DrmInitData h0;
    private final LoadErrorHandlingPolicy i;
    private com.google.android.exoplayer2.source.hls.b i0;
    private final Loader j;
    private final MediaSourceEventListener.EventDispatcher p;
    private final int w;
    private final HlsChunkSource.HlsChunkHolder x;
    private final ArrayList<com.google.android.exoplayer2.source.hls.b> y;
    private final List<com.google.android.exoplayer2.source.hls.b> z;
    
    static {
        j0 = Collections.unmodifiableSet((Set<? extends Integer>)new HashSet<Integer>(Arrays.asList(1, 2, 5)));
    }
    
    public HlsSampleStreamWrapper(final String a, final int b, final Callback c, final HlsChunkSource d, final Map<String, DrmInitData> e, final Allocator e2, final long n, final Format f, final DrmSessionManager g, final DrmSessionEventListener.EventDispatcher h, final LoadErrorHandlingPolicy i, final MediaSourceEventListener.EventDispatcher p13, final int w) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.E = e;
        this.e = e2;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.p = p13;
        this.w = w;
        this.j = new Loader("Loader:HlsSampleStreamWrapper");
        this.x = new HlsChunkSource.HlsChunkHolder();
        this.H = new int[0];
        final Set<Integer> j0 = HlsSampleStreamWrapper.j0;
        this.I = new HashSet<Integer>(j0.size());
        this.J = new SparseIntArray(j0.size());
        this.G = new c[0];
        this.Z = new boolean[0];
        this.Y = new boolean[0];
        final ArrayList y = new ArrayList();
        this.y = y;
        this.z = (List<com.google.android.exoplayer2.source.hls.b>)Collections.unmodifiableList((List<?>)y);
        this.D = new ArrayList<com.google.android.exoplayer2.source.hls.c>();
        this.A = new f(this);
        this.B = new e(this);
        this.C = Util.w();
        this.a0 = n;
        this.b0 = n;
    }
    
    private SampleQueue B(final int n, final int l) {
        final int length = this.G.length;
        boolean b2;
        final boolean b = b2 = true;
        if (l != 1) {
            b2 = (l == 2 && b);
        }
        final c c = new c(this.e, this.g, this.h, this.E, null);
        c.b0(this.a0);
        if (b2) {
            c.i0(this.h0);
        }
        c.a0(this.g0);
        final com.google.android.exoplayer2.source.hls.b i0 = this.i0;
        if (i0 != null) {
            c.j0(i0);
        }
        c.d0((SampleQueue.UpstreamFormatChangedListener)this);
        final int[] h = this.H;
        final int n2 = length + 1;
        (this.H = Arrays.copyOf(h, n2))[length] = n;
        this.G = Util.F0(this.G, c);
        final boolean[] copy = Arrays.copyOf(this.Z, n2);
        (this.Z = copy)[length] = b2;
        this.X |= copy[length];
        this.I.add(l);
        this.J.append(l, length);
        if (K(l) > K(this.L)) {
            this.M = length;
            this.L = l;
        }
        this.Y = Arrays.copyOf(this.Y, n2);
        return c;
    }
    
    private TrackGroupArray C(final TrackGroup[] array) {
        for (int i = 0; i < array.length; ++i) {
            final TrackGroup trackGroup = array[i];
            final Format[] array2 = new Format[trackGroup.a];
            for (int j = 0; j < trackGroup.a; ++j) {
                final Format c = trackGroup.c(j);
                array2[j] = c.c(this.g.a(c));
            }
            array[i] = new TrackGroup(trackGroup.b, array2);
        }
        return new TrackGroupArray(array);
    }
    
    private static Format D(final Format format, final Format format2, final boolean b) {
        if (format == null) {
            return format2;
        }
        final int k = MimeTypes.k(format2.w);
        String s;
        String s2;
        if (Util.K(format.i, k) == 1) {
            s = Util.L(format.i, k);
            s2 = MimeTypes.g(s);
        }
        else {
            s = MimeTypes.d(format.i, format2.w);
            s2 = format2.w;
        }
        final Format.Builder c0 = format2.b().S(format.a).U(format.b).V(format.c).g0(format.d).c0(format.e);
        int f;
        if (b) {
            f = format.f;
        }
        else {
            f = -1;
        }
        final Format.Builder g = c0.G(f);
        int g2;
        if (b) {
            g2 = format.g;
        }
        else {
            g2 = -1;
        }
        final Format.Builder i = g.Z(g2).I(s);
        if (k == 2) {
            i.j0(format.B).Q(format.C).P(format.D);
        }
        if (s2 != null) {
            i.e0(s2);
        }
        final int j = format.J;
        if (j != -1 && k == 1) {
            i.H(j);
        }
        final Metadata l = format.j;
        if (l != null) {
            final Metadata m = format2.j;
            Metadata b2 = l;
            if (m != null) {
                b2 = m.b(l);
            }
            i.X(b2);
        }
        return i.E();
    }
    
    private void E(int i) {
        Assertions.g(this.j.j() ^ true);
        while (true) {
            while (i < this.y.size()) {
                if (this.x(i)) {
                    if (i == -1) {
                        return;
                    }
                    final long h = this.I().h;
                    final com.google.android.exoplayer2.source.hls.b f = this.F(i);
                    if (this.y.isEmpty()) {
                        this.b0 = this.a0;
                    }
                    else {
                        ((com.google.android.exoplayer2.source.hls.b)Iterables.h((Iterable)this.y)).o();
                    }
                    this.e0 = false;
                    this.p.D(this.L, f.g, h);
                    return;
                }
                else {
                    ++i;
                }
            }
            i = -1;
            continue;
        }
    }
    
    private com.google.android.exoplayer2.source.hls.b F(int i) {
        final com.google.android.exoplayer2.source.hls.b b = this.y.get(i);
        final ArrayList<com.google.android.exoplayer2.source.hls.b> y = this.y;
        Util.N0((List<Object>)y, i, y.size());
        for (i = 0; i < this.G.length; ++i) {
            this.G[i].u(b.m(i));
        }
        return b;
    }
    
    private boolean G(final com.google.android.exoplayer2.source.hls.b b) {
        final int k = b.k;
        for (int length = this.G.length, i = 0; i < length; ++i) {
            if (this.Y[i] && this.G[i].Q() == k) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean H(final Format format, final Format format2) {
        final String w = format.w;
        final String w2 = format2.w;
        final int k = MimeTypes.k(w);
        final boolean b = true;
        boolean b2 = true;
        if (k != 3) {
            if (k != MimeTypes.k(w2)) {
                b2 = false;
            }
            return b2;
        }
        return Util.c(w, w2) && ((!"application/cea-608".equals(w) && !"application/cea-708".equals(w)) || (format.O == format2.O && b));
    }
    
    private com.google.android.exoplayer2.source.hls.b I() {
        final ArrayList<com.google.android.exoplayer2.source.hls.b> y = this.y;
        return y.get(y.size() - 1);
    }
    
    private TrackOutput J(final int n, final int n2) {
        Assertions.a(HlsSampleStreamWrapper.j0.contains(n2));
        final int value = this.J.get(n2, -1);
        if (value == -1) {
            return null;
        }
        if (this.I.add(n2)) {
            this.H[value] = n;
        }
        TrackOutput z;
        if (this.H[value] == n) {
            z = this.G[value];
        }
        else {
            z = z(n, n2);
        }
        return z;
    }
    
    private static int K(final int n) {
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 3;
        }
        if (n != 3) {
            return 0;
        }
        return 1;
    }
    
    private void M(final com.google.android.exoplayer2.source.hls.b i0) {
        this.i0 = i0;
        this.Q = i0.d;
        this.b0 = -9223372036854775807L;
        this.y.add(i0);
        final ImmutableList$Builder builder = ImmutableList.builder();
        final c[] g = this.G;
        final int length = g.length;
        final int n = 0;
        for (int j = 0; j < length; ++j) {
            builder.i((Object)g[j].G());
        }
        i0.n(this, (ImmutableList<Integer>)builder.l());
        final c[] g2 = this.G;
        for (int length2 = g2.length, k = n; k < length2; ++k) {
            final c c = g2[k];
            c.j0(i0);
            if (i0.n) {
                c.g0();
            }
        }
    }
    
    private static boolean N(final Chunk chunk) {
        return chunk instanceof com.google.android.exoplayer2.source.hls.b;
    }
    
    private boolean O() {
        return this.b0 != -9223372036854775807L;
    }
    
    private void R() {
        final int a = this.T.a;
        Arrays.fill(this.V = new int[a], -1);
        for (int i = 0; i < a; ++i) {
            int n = 0;
            while (true) {
                final c[] g = this.G;
                if (n >= g.length) {
                    break;
                }
                if (H(Assertions.i(g[n].F()), this.T.b(i).c(0))) {
                    this.V[i] = n;
                    break;
                }
                ++n;
            }
        }
        final Iterator<com.google.android.exoplayer2.source.hls.c> iterator = this.D.iterator();
        while (iterator.hasNext()) {
            iterator.next().b();
        }
    }
    
    private void S() {
        if (!this.S && this.V == null) {
            if (this.N) {
                final c[] g = this.G;
                for (int length = g.length, i = 0; i < length; ++i) {
                    if (g[i].F() == null) {
                        return;
                    }
                }
                if (this.T != null) {
                    this.R();
                }
                else {
                    this.w();
                    this.k0();
                    this.c.onPrepared();
                }
            }
        }
    }
    
    private void b0() {
        this.N = true;
        this.S();
    }
    
    private void f0() {
        final c[] g = this.G;
        for (int length = g.length, i = 0; i < length; ++i) {
            g[i].W(this.c0);
        }
        this.c0 = false;
    }
    
    private boolean g0(final long n) {
        for (int length = this.G.length, i = 0; i < length; ++i) {
            if (!this.G[i].Z(n, false) && (this.Z[i] || !this.X)) {
                return false;
            }
        }
        return true;
    }
    
    private void k0() {
        this.O = true;
    }
    
    private void p0(final SampleStream[] array) {
        this.D.clear();
        for (final SampleStream sampleStream : array) {
            if (sampleStream != null) {
                this.D.add((com.google.android.exoplayer2.source.hls.c)sampleStream);
            }
        }
    }
    
    public static void r(final HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        hlsSampleStreamWrapper.b0();
    }
    
    public static void s(final HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        hlsSampleStreamWrapper.S();
    }
    
    private void t() {
        Assertions.g(this.O);
        Assertions.e(this.T);
        Assertions.e(this.U);
    }
    
    private void w() {
        final int length = this.G.length;
        boolean b = false;
        int n = -2;
        int n2 = -1;
        int n3 = 0;
        while (true) {
            int n4 = 2;
            if (n3 >= length) {
                break;
            }
            final String w = Assertions.i(this.G[n3].F()).w;
            if (!MimeTypes.s(w)) {
                if (MimeTypes.o(w)) {
                    n4 = 1;
                }
                else if (MimeTypes.r(w)) {
                    n4 = 3;
                }
                else {
                    n4 = -2;
                }
            }
            int n5;
            int n6;
            if (K(n4) > K(n)) {
                n5 = n3;
                n6 = n4;
            }
            else {
                n6 = n;
                n5 = n2;
                if (n4 == n) {
                    n6 = n;
                    if ((n5 = n2) != -1) {
                        n5 = -1;
                        n6 = n;
                    }
                }
            }
            ++n3;
            n = n6;
            n2 = n5;
        }
        final TrackGroup j = this.d.j();
        final int a = j.a;
        this.W = -1;
        this.V = new int[length];
        for (int i = 0; i < length; ++i) {
            this.V[i] = i;
        }
        final TrackGroup[] array = new TrackGroup[length];
        for (int k = 0; k < length; ++k) {
            final Format format = Assertions.i(this.G[k].F());
            if (k == n2) {
                final Format[] array2 = new Format[a];
                for (int l = 0; l < a; ++l) {
                    Format format3;
                    final Format format2 = format3 = j.c(l);
                    if (n == 1) {
                        final Format f = this.f;
                        format3 = format2;
                        if (f != null) {
                            format3 = format2.k(f);
                        }
                    }
                    Format format4;
                    if (a == 1) {
                        format4 = format.k(format3);
                    }
                    else {
                        format4 = D(format3, format, true);
                    }
                    array2[l] = format4;
                }
                array[k] = new TrackGroup(this.a, array2);
                this.W = k;
            }
            else {
                Format f2;
                if (n == 2 && MimeTypes.o(format.w)) {
                    f2 = this.f;
                }
                else {
                    f2 = null;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(":muxed:");
                int n7;
                if (k < n2) {
                    n7 = k;
                }
                else {
                    n7 = k - 1;
                }
                sb.append(n7);
                array[k] = new TrackGroup(sb.toString(), new Format[] { D(f2, format, false) });
            }
        }
        this.T = this.C(array);
        if (this.U == null) {
            b = true;
        }
        Assertions.g(b);
        this.U = Collections.emptySet();
    }
    
    private boolean x(int i) {
        for (int j = i; j < this.y.size(); ++j) {
            if (this.y.get(j).n) {
                return false;
            }
        }
        final com.google.android.exoplayer2.source.hls.b b = this.y.get(i);
        for (i = 0; i < this.G.length; ++i) {
            if (this.G[i].C() > b.m(i)) {
                return false;
            }
        }
        return true;
    }
    
    private static DummyTrackOutput z(final int n, final int n2) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Unmapped track with id ");
        sb.append(n);
        sb.append(" of type ");
        sb.append(n2);
        Log.i("HlsSampleStreamWrapper", sb.toString());
        return new DummyTrackOutput();
    }
    
    @Override
    public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
        this.W((Chunk)loadable, n, n2);
    }
    
    @Override
    public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
        return this.X((Chunk)loadable, n, n2, ex, n3);
    }
    
    public boolean P(final int n) {
        return !this.O() && this.G[n].K(this.e0);
    }
    
    public boolean Q() {
        return this.L == 2;
    }
    
    public void T() throws IOException {
        this.j.a();
        this.d.n();
    }
    
    public void U(final int n) throws IOException {
        this.T();
        this.G[n].N();
    }
    
    public void V(final Chunk chunk, final long n, final long n2, final boolean b) {
        this.F = null;
        final LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), n, n2, chunk.b());
        this.i.d(chunk.a);
        this.p.r(loadEventInfo, chunk.c, this.b, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h);
        if (!b) {
            if (this.O() || this.P == 0) {
                this.f0();
            }
            if (this.P > 0) {
                ((SequenceableLoader.Callback<HlsSampleStreamWrapper>)this.c).l(this);
            }
        }
    }
    
    public void W(final Chunk chunk, final long n, final long n2) {
        this.F = null;
        this.d.p(chunk);
        final LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), n, n2, chunk.b());
        this.i.d(chunk.a);
        this.p.u(loadEventInfo, chunk.c, this.b, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h);
        if (!this.O) {
            this.d(this.a0);
        }
        else {
            ((SequenceableLoader.Callback<HlsSampleStreamWrapper>)this.c).l(this);
        }
    }
    
    public LoadErrorAction X(final Chunk chunk, long a, final long n, final IOException ex, final int n2) {
        final boolean n3 = N(chunk);
        if (n3 && !((com.google.android.exoplayer2.source.hls.b)chunk).q() && ex instanceof HttpDataSource.InvalidResponseCodeException) {
            final int responseCode = ((HttpDataSource.InvalidResponseCodeException)ex).responseCode;
            if (responseCode == 410 || responseCode == 404) {
                return Loader.d;
            }
        }
        final long b = chunk.b();
        final LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), a, n, b);
        final LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(chunk.c, this.b, chunk.d, chunk.e, chunk.f, Util.f1(chunk.g), Util.f1(chunk.h)), ex, n2);
        final LoadErrorHandlingPolicy.FallbackSelection c = this.i.c(TrackSelectionUtil.c(this.d.k()), loadErrorInfo);
        boolean b2 = false;
        final boolean b3 = c != null && c.a == 2 && this.d.m(chunk, c.b);
        Loader.LoadErrorAction loadErrorAction;
        if (b3) {
            if (n3 && b == 0L) {
                final ArrayList<com.google.android.exoplayer2.source.hls.b> y = this.y;
                if (y.remove(y.size() - 1) == chunk) {
                    b2 = true;
                }
                Assertions.g(b2);
                if (this.y.isEmpty()) {
                    this.b0 = this.a0;
                }
                else {
                    ((com.google.android.exoplayer2.source.hls.b)Iterables.h((Iterable)this.y)).o();
                }
            }
            loadErrorAction = Loader.f;
        }
        else {
            a = this.i.a(loadErrorInfo);
            if (a != -9223372036854775807L) {
                loadErrorAction = Loader.h(false, a);
            }
            else {
                loadErrorAction = Loader.g;
            }
        }
        final boolean b4 = loadErrorAction.c() ^ true;
        this.p.w(loadEventInfo, chunk.c, this.b, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h, ex, b4);
        if (b4) {
            this.F = null;
            this.i.d(chunk.a);
        }
        if (b3) {
            if (!this.O) {
                this.d(this.a0);
            }
            else {
                ((SequenceableLoader.Callback<HlsSampleStreamWrapper>)this.c).l(this);
            }
        }
        return loadErrorAction;
    }
    
    public void Y() {
        this.I.clear();
    }
    
    public boolean Z(final Uri uri, final LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, final boolean b) {
        final boolean o = this.d.o(uri);
        final boolean b2 = true;
        if (!o) {
            return true;
        }
        if (!b) {
            final LoadErrorHandlingPolicy.FallbackSelection c = this.i.c(TrackSelectionUtil.c(this.d.k()), loadErrorInfo);
            if (c != null && c.a == 2) {
                final long b3 = c.b;
                return this.d.q(uri, b3) && b3 != -9223372036854775807L && b2;
            }
        }
        final long b3 = -9223372036854775807L;
        return this.d.q(uri, b3) && b3 != -9223372036854775807L && b2;
    }
    
    @Override
    public void a(final Format format) {
        this.C.post(this.A);
    }
    
    public void a0() {
        if (this.y.isEmpty()) {
            return;
        }
        final com.google.android.exoplayer2.source.hls.b b = (com.google.android.exoplayer2.source.hls.b)Iterables.h((Iterable)this.y);
        final int c = this.d.c(b);
        if (c == 1) {
            b.v();
        }
        else if (c == 2 && !this.e0 && this.j.j()) {
            this.j.f();
        }
    }
    
    @Override
    public long b() {
        if (this.O()) {
            return this.b0;
        }
        long h;
        if (this.e0) {
            h = Long.MIN_VALUE;
        }
        else {
            h = this.I().h;
        }
        return h;
    }
    
    public long c(final long n, final SeekParameters seekParameters) {
        return this.d.b(n, seekParameters);
    }
    
    public void c0(final TrackGroup[] array, final int w, final int... array2) {
        this.T = this.C(array);
        this.U = new HashSet<TrackGroup>();
        for (int length = array2.length, i = 0; i < length; ++i) {
            this.U.add(this.T.b(array2[i]));
        }
        this.W = w;
        final Handler c = this.C;
        final Callback c2 = this.c;
        Objects.requireNonNull(c2);
        c.post((Runnable)new d(c2));
        this.k0();
    }
    
    @Override
    public boolean d(long n) {
        if (this.e0 || this.j.j() || this.j.i()) {
            return false;
        }
        Object z;
        long n3;
        if (this.O()) {
            final List<Object> emptyList = (List<Object>)Collections.emptyList();
            final long b0 = this.b0;
            final c[] g = this.G;
            final int length = g.length;
            int n2 = 0;
            while (true) {
                z = emptyList;
                n3 = b0;
                if (n2 >= length) {
                    break;
                }
                g[n2].b0(this.b0);
                ++n2;
            }
        }
        else {
            z = this.z;
            final com.google.android.exoplayer2.source.hls.b i = this.I();
            if (i.h()) {
                n3 = i.h;
            }
            else {
                n3 = Math.max(this.a0, i.g);
            }
        }
        this.x.a();
        this.d.e(n, n3, (List<com.google.android.exoplayer2.source.hls.b>)z, this.O || !((List)z).isEmpty(), this.x);
        final HlsChunkSource.HlsChunkHolder x = this.x;
        final boolean b2 = x.b;
        final Chunk a = x.a;
        final Uri c = x.c;
        if (b2) {
            this.b0 = -9223372036854775807L;
            return this.e0 = true;
        }
        if (a == null) {
            if (c != null) {
                this.c.m(c);
            }
            return false;
        }
        if (N(a)) {
            this.M((com.google.android.exoplayer2.source.hls.b)a);
        }
        this.F = a;
        n = this.j.n((com.google.android.exoplayer2.source.hls.b)a, (Loader.Callback<com.google.android.exoplayer2.source.hls.b>)this, this.i.b(a.c));
        this.p.A(new LoadEventInfo(a.a, a.b, n), a.c, this.b, a.d, a.e, a.f, a.g, a.h);
        return true;
    }
    
    public int d0(int n, final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, int s) {
        if (this.O()) {
            return -3;
        }
        final boolean empty = this.y.isEmpty();
        final int n2 = 0;
        if (!empty) {
            int n3;
            for (n3 = 0; n3 < this.y.size() - 1 && this.G(this.y.get(n3)); ++n3) {}
            Util.N0(this.y, 0, n3);
            final com.google.android.exoplayer2.source.hls.b b = this.y.get(0);
            final Format d = b.d;
            if (!d.equals(this.R)) {
                this.p.i(this.b, d, b.e, b.f, b.g);
            }
            this.R = d;
        }
        if (!this.y.isEmpty() && !this.y.get(0).q()) {
            return -3;
        }
        s = this.G[n].S(formatHolder, decoderInputBuffer, s, this.e0);
        if (s == -5) {
            Format k = Assertions.e(formatHolder.b);
            if (n == this.M) {
                int q;
                for (q = this.G[n].Q(), n = n2; n < this.y.size() && this.y.get(n).k != q; ++n) {}
                Format d2;
                if (n < this.y.size()) {
                    d2 = this.y.get(n).d;
                }
                else {
                    d2 = Assertions.e(this.Q);
                }
                k = k.k(d2);
            }
            formatHolder.b = k;
        }
        return s;
    }
    
    @Override
    public TrackOutput e(final int n, final int n2) {
        TrackOutput j;
        if (HlsSampleStreamWrapper.j0.contains(n2)) {
            j = this.J(n, n2);
        }
        else {
            int n3 = 0;
            while (true) {
                final c[] g = this.G;
                if (n3 >= g.length) {
                    j = null;
                    break;
                }
                if (this.H[n3] == n) {
                    j = g[n3];
                    break;
                }
                ++n3;
            }
        }
        TrackOutput b = j;
        if (j == null) {
            if (this.f0) {
                return z(n, n2);
            }
            b = this.B(n, n2);
        }
        if (n2 == 5) {
            if (this.K == null) {
                this.K = new b(b, this.w);
            }
            return this.K;
        }
        return b;
    }
    
    public void e0() {
        if (this.O) {
            final c[] g = this.G;
            for (int length = g.length, i = 0; i < length; ++i) {
                g[i].R();
            }
        }
        this.j.m((Loader.ReleaseCallback)this);
        this.C.removeCallbacksAndMessages((Object)null);
        this.S = true;
        this.D.clear();
    }
    
    @Override
    public long f() {
        if (this.e0) {
            return Long.MIN_VALUE;
        }
        if (this.O()) {
            return this.b0;
        }
        final long a0 = this.a0;
        com.google.android.exoplayer2.source.hls.b i = this.I();
        if (!i.h()) {
            if (this.y.size() > 1) {
                final ArrayList<com.google.android.exoplayer2.source.hls.b> y = this.y;
                i = y.get(y.size() - 2);
            }
            else {
                i = null;
            }
        }
        long n = a0;
        if (i != null) {
            n = Math.max(a0, i.h);
        }
        long n2 = n;
        if (this.N) {
            final c[] g = this.G;
            final int length = g.length;
            int n3 = 0;
            while (true) {
                n2 = n;
                if (n3 >= length) {
                    break;
                }
                n = Math.max(n, g[n3].z());
                ++n3;
            }
        }
        return n2;
    }
    
    @Override
    public void g(final long n) {
        if (!this.j.i()) {
            if (!this.O()) {
                if (this.j.j()) {
                    Assertions.e(this.F);
                    if (this.d.v(n, this.F, this.z)) {
                        this.j.f();
                    }
                    return;
                }
                int size;
                for (size = this.z.size(); size > 0 && this.d.c(this.z.get(size - 1)) == 2; --size) {}
                if (size < this.z.size()) {
                    this.E(size);
                }
                final int h = this.d.h(n, this.z);
                if (h < this.y.size()) {
                    this.E(h);
                }
            }
        }
    }
    
    public boolean h0(final long b0, final boolean b2) {
        this.a0 = b0;
        if (this.O()) {
            this.b0 = b0;
            return true;
        }
        final boolean n = this.N;
        int i = 0;
        if (n && !b2 && this.g0(b0)) {
            return false;
        }
        this.b0 = b0;
        this.e0 = false;
        this.y.clear();
        if (this.j.j()) {
            if (this.N) {
                for (c[] g = this.G; i < g.length; ++i) {
                    g[i].r();
                }
            }
            this.j.f();
        }
        else {
            this.j.g();
            this.f0();
        }
        return true;
    }
    
    public boolean i0(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, final long n, boolean b) {
        this.t();
        final int p5 = this.P;
        final int n2 = 0;
        final int n3 = 0;
        for (int i = 0; i < array.length; ++i) {
            final com.google.android.exoplayer2.source.hls.c c = (com.google.android.exoplayer2.source.hls.c)array3[i];
            if (c != null && (array[i] == null || !array2[i])) {
                --this.P;
                c.d();
                array3[i] = null;
            }
        }
        boolean b2 = b || (this.d0 ? (p5 == 0) : (n != this.a0));
        ExoTrackSelection k;
        final ExoTrackSelection exoTrackSelection = k = this.d.k();
        ExoTrackSelection exoTrackSelection3;
        boolean b3;
        for (int j = 0; j < array.length; ++j, k = exoTrackSelection3, b2 = b3) {
            final ExoTrackSelection exoTrackSelection2 = array[j];
            if (exoTrackSelection2 == null) {
                exoTrackSelection3 = k;
                b3 = b2;
            }
            else {
                final int c2 = this.T.c(exoTrackSelection2.l());
                if (c2 == this.W) {
                    this.d.u(exoTrackSelection2);
                    k = exoTrackSelection2;
                }
                exoTrackSelection3 = k;
                b3 = b2;
                if (array3[j] == null) {
                    ++this.P;
                    array3[j] = new com.google.android.exoplayer2.source.hls.c(this, c2);
                    array4[j] = true;
                    exoTrackSelection3 = k;
                    b3 = b2;
                    if (this.V != null) {
                        ((com.google.android.exoplayer2.source.hls.c)array3[j]).b();
                        exoTrackSelection3 = k;
                        if (!(b3 = b2)) {
                            final c c3 = this.G[this.V[c2]];
                            b3 = (!c3.Z(n, true) && c3.C() != 0);
                            exoTrackSelection3 = k;
                        }
                    }
                }
            }
        }
        boolean b4;
        if (this.P == 0) {
            this.d.r();
            this.R = null;
            this.c0 = true;
            this.y.clear();
            if (this.j.j()) {
                if (this.N) {
                    final c[] g = this.G;
                    for (int length = g.length, l = n3; l < length; ++l) {
                        g[l].r();
                    }
                }
                this.j.f();
                b4 = b2;
            }
            else {
                this.f0();
                b4 = b2;
            }
        }
        else {
            if (!this.y.isEmpty() && !Util.c(k, exoTrackSelection)) {
                boolean b5 = false;
                Label_0567: {
                    if (!this.d0) {
                        long n4 = 0L;
                        if (n < 0L) {
                            n4 = -n;
                        }
                        final com.google.android.exoplayer2.source.hls.b m = this.I();
                        k.q(n, n4, -9223372036854775807L, this.z, this.d.a(m, n));
                        if (k.r() == this.d.j().d(m.d)) {
                            b5 = false;
                            break Label_0567;
                        }
                    }
                    b5 = true;
                }
                if (b5) {
                    this.c0 = true;
                    b = true;
                    b2 = true;
                }
            }
            if (b4 = b2) {
                this.h0(n, b);
                int n5 = n2;
                while (true) {
                    b4 = b2;
                    if (n5 >= array3.length) {
                        break;
                    }
                    if (array3[n5] != null) {
                        array4[n5] = true;
                    }
                    ++n5;
                }
            }
        }
        this.p0(array3);
        this.d0 = true;
        return b4;
    }
    
    @Override
    public boolean isLoading() {
        return this.j.j();
    }
    
    public void j0(final DrmInitData h0) {
        if (!Util.c(this.h0, h0)) {
            this.h0 = h0;
            int n = 0;
            while (true) {
                final c[] g = this.G;
                if (n >= g.length) {
                    break;
                }
                if (this.Z[n]) {
                    g[n].i0(h0);
                }
                ++n;
            }
        }
    }
    
    @Override
    public void l(final SeekMap seekMap) {
    }
    
    public void l0(final boolean b) {
        this.d.t(b);
    }
    
    @Override
    public void m() {
        final c[] g = this.G;
        for (int length = g.length, i = 0; i < length; ++i) {
            g[i].T();
        }
    }
    
    public void m0(final long g0) {
        if (this.g0 != g0) {
            this.g0 = g0;
            final c[] g2 = this.G;
            for (int length = g2.length, i = 0; i < length; ++i) {
                g2[i].a0(g0);
            }
        }
    }
    
    public void n() throws IOException {
        this.T();
        if (this.e0 && !this.O) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }
    
    public int n0(final int n, final long n2) {
        if (this.O()) {
            return 0;
        }
        final c c = this.G[n];
        final int e = c.E(n2, this.e0);
        final com.google.android.exoplayer2.source.hls.b b = (com.google.android.exoplayer2.source.hls.b)Iterables.i((Iterable)this.y, (Object)null);
        int min = e;
        if (b != null) {
            min = e;
            if (!b.q()) {
                min = Math.min(e, b.m(n) - c.C());
            }
        }
        c.e0(min);
        return min;
    }
    
    @Override
    public void o() {
        this.f0 = true;
        this.C.post(this.B);
    }
    
    public void o0(int n) {
        this.t();
        Assertions.e(this.V);
        n = this.V[n];
        Assertions.g(this.Y[n]);
        this.Y[n] = false;
    }
    
    public TrackGroupArray p() {
        this.t();
        return this.T;
    }
    
    public void q(final long n, final boolean b) {
        if (this.N) {
            if (!this.O()) {
                for (int length = this.G.length, i = 0; i < length; ++i) {
                    this.G[i].q(n, b, this.Y[i]);
                }
            }
        }
    }
    
    public int u(final int n) {
        this.t();
        Assertions.e(this.V);
        final int n2 = this.V[n];
        int n3 = -2;
        if (n2 == -1) {
            if (this.U.contains(this.T.b(n))) {
                n3 = -3;
            }
            return n3;
        }
        final boolean[] y = this.Y;
        if (y[n2]) {
            return -2;
        }
        y[n2] = true;
        return n2;
    }
    
    @Override
    public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
        this.V((Chunk)loadable, n, n2, b);
    }
    
    public void y() {
        if (!this.O) {
            this.d(this.a0);
        }
    }
    
    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper>
    {
        void m(final Uri p0);
        
        void onPrepared();
    }
    
    private static class b implements TrackOutput
    {
        private static final Format g;
        private static final Format h;
        private final EventMessageDecoder a;
        private final TrackOutput b;
        private final Format c;
        private Format d;
        private byte[] e;
        private int f;
        
        static {
            g = new Format.Builder().e0("application/id3").E();
            h = new Format.Builder().e0("application/x-emsg").E();
        }
        
        public b(final TrackOutput b, final int n) {
            this.a = new EventMessageDecoder();
            this.b = b;
            if (n != 1) {
                if (n != 3) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown metadataType: ");
                    sb.append(n);
                    throw new IllegalArgumentException(sb.toString());
                }
                this.c = b.h;
            }
            else {
                this.c = b.g;
            }
            this.e = new byte[0];
            this.f = 0;
        }
        
        private boolean g(final EventMessage eventMessage) {
            final Format m = eventMessage.M();
            return m != null && Util.c(this.c.w, m.w);
        }
        
        private void h(final int n) {
            final byte[] e = this.e;
            if (e.length < n) {
                this.e = Arrays.copyOf(e, n + n / 2);
            }
        }
        
        private ParsableByteArray i(final int n, final int f) {
            final int n2 = this.f - f;
            final ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.e, n2 - n, n2));
            final byte[] e = this.e;
            System.arraycopy(e, n2, e, 0, f);
            this.f = f;
            return parsableByteArray;
        }
        
        @Override
        public int a(final DataReader dataReader, int read, final boolean b, final int n) throws IOException {
            this.h(this.f + read);
            read = dataReader.read(this.e, this.f, read);
            if (read != -1) {
                this.f += read;
                return read;
            }
            if (b) {
                return -1;
            }
            throw new EOFException();
        }
        
        @Override
        public void d(final Format d) {
            this.d = d;
            this.b.d(this.c);
        }
        
        @Override
        public void e(final long n, final int n2, int a, final int n3, final CryptoData cryptoData) {
            Assertions.e(this.d);
            ParsableByteArray i = this.i(a, n3);
            if (!Util.c(this.d.w, this.c.w)) {
                if (!"application/x-emsg".equals(this.d.w)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Ignoring sample for unsupported format: ");
                    sb.append(this.d.w);
                    Log.i("HlsSampleStreamWrapper", sb.toString());
                    return;
                }
                final EventMessage c = this.a.c(i);
                if (!this.g(c)) {
                    Log.i("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.c.w, c.M()));
                    return;
                }
                i = new ParsableByteArray(Assertions.e(c.C1()));
            }
            a = i.a();
            this.b.c(i, a);
            this.b.e(n, n2, a, n3, cryptoData);
        }
        
        @Override
        public void f(final ParsableByteArray parsableByteArray, final int n, final int n2) {
            this.h(this.f + n);
            parsableByteArray.j(this.e, this.f, n);
            this.f += n;
        }
    }
    
    private static final class c extends SampleQueue
    {
        private final Map<String, DrmInitData> H;
        private DrmInitData I;
        
        private c(final Allocator allocator, final DrmSessionManager drmSessionManager, final DrmSessionEventListener.EventDispatcher eventDispatcher, final Map<String, DrmInitData> h) {
            super(allocator, drmSessionManager, eventDispatcher);
            this.H = h;
        }
        
        c(final Allocator allocator, final DrmSessionManager drmSessionManager, final DrmSessionEventListener.EventDispatcher eventDispatcher, final Map map, final HlsSampleStreamWrapper$a object) {
            this(allocator, drmSessionManager, eventDispatcher, map);
        }
        
        private Metadata h0(final Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            final int d = metadata.d();
            final int n = 0;
            int i = 0;
            while (true) {
                while (i < d) {
                    final Metadata.Entry c = metadata.c(i);
                    if (c instanceof PrivFrame && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame)c).b)) {
                        final int n2 = i;
                        if (n2 == -1) {
                            return metadata;
                        }
                        if (d == 1) {
                            return null;
                        }
                        final Metadata.Entry[] array = new Metadata.Entry[d - 1];
                        for (int j = n; j < d; ++j) {
                            if (j != n2) {
                                int n3;
                                if (j < n2) {
                                    n3 = j;
                                }
                                else {
                                    n3 = j - 1;
                                }
                                array[n3] = metadata.c(j);
                            }
                        }
                        return new Metadata(array);
                    }
                    else {
                        ++i;
                    }
                }
                final int n2 = -1;
                continue;
            }
        }
        
        @Override
        public void e(final long n, final int n2, final int n3, final int n4, final CryptoData cryptoData) {
            super.e(n, n2, n3, n4, cryptoData);
        }
        
        public void i0(final DrmInitData i) {
            this.I = i;
            this.I();
        }
        
        public void j0(final b b) {
            this.f0(b.k);
        }
        
        public Format w(final Format format) {
            DrmInitData drmInitData = this.I;
            if (drmInitData == null) {
                drmInitData = format.z;
            }
            DrmInitData drmInitData2 = drmInitData;
            if (drmInitData != null) {
                final DrmInitData drmInitData3 = this.H.get(drmInitData.c);
                drmInitData2 = drmInitData;
                if (drmInitData3 != null) {
                    drmInitData2 = drmInitData3;
                }
            }
            final Metadata h0 = this.h0(format.j);
            if (drmInitData2 == format.z) {
                final Format e = format;
                if (h0 == format.j) {
                    return super.w(e);
                }
            }
            final Format e = format.b().M(drmInitData2).X(h0).E();
            return super.w(e);
        }
    }
}
