// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import com.google.common.collect.ImmutableCollection;
import java.util.AbstractCollection;
import java.net.BindException;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.SeekParameters;
import java.io.Closeable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import java.util.Collection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Format;
import com.google.common.collect.ImmutableList$Builder;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Util;
import javax.net.SocketFactory;
import android.net.Uri;
import java.io.IOException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.common.collect.ImmutableList;
import java.util.List;
import android.os.Handler;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.source.MediaPeriod;

final class h implements MediaPeriod
{
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private final Allocator a;
    private final Handler b;
    private final b c;
    private final RtspClient d;
    private final List<e> e;
    private final List<d> f;
    private final c g;
    private final RtpDataChannel.Factory h;
    private Callback i;
    private ImmutableList<TrackGroup> j;
    private IOException p;
    private RtspMediaSource.RtspPlaybackException w;
    private long x;
    private long y;
    private long z;
    
    public h(final Allocator a, final RtpDataChannel.Factory h, final Uri uri, final c g, final String s, final SocketFactory socketFactory, final boolean b) {
        this.a = a;
        this.h = h;
        this.g = g;
        this.b = Util.w();
        final b c = new b(null);
        this.c = c;
        this.d = new RtspClient((RtspClient.SessionInfoListener)c, (RtspClient.PlaybackEventListener)c, s, uri, socketFactory, b);
        this.e = new ArrayList<e>();
        this.f = new ArrayList<d>();
        this.y = -9223372036854775807L;
        this.x = -9223372036854775807L;
        this.z = -9223372036854775807L;
    }
    
    static RtpDataLoadable A(final h h, final Uri uri) {
        return h.P(uri);
    }
    
    static RtpDataChannel.Factory B(final h h) {
        return h.h;
    }
    
    static void C(final h h) {
        h.S();
    }
    
    static Allocator D(final h h) {
        return h.a;
    }
    
    static b E(final h h) {
        return h.c;
    }
    
    static void F(final h h) {
        h.a0();
    }
    
    static void G(final h h) {
        h.T();
    }
    
    static List H(final h h) {
        return h.e;
    }
    
    static Handler I(final h h) {
        return h.b;
    }
    
    static boolean J(final h h) {
        return h.G;
    }
    
    static boolean K(final h h, final boolean g) {
        return h.G = g;
    }
    
    static void L(final h h) {
        h.W();
    }
    
    static boolean M(final h h) {
        return h.D;
    }
    
    static IOException N(final h h, final IOException p2) {
        return h.p = p2;
    }
    
    private static ImmutableList<TrackGroup> O(final ImmutableList<e> list) {
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        for (int i = 0; i < ((AbstractCollection)list).size(); ++i) {
            immutableList$Builder.i((Object)new TrackGroup(Integer.toString(i), new Format[] { Assertions.e(e.b(((List<e>)list).get(i)).F()) }));
        }
        return (ImmutableList<TrackGroup>)immutableList$Builder.l();
    }
    
    private RtpDataLoadable P(final Uri uri) {
        for (int i = 0; i < this.e.size(); ++i) {
            if (!com.google.android.exoplayer2.source.rtsp.h.e.a(this.e.get(i))) {
                final d a = this.e.get(i).a;
                if (a.c().equals((Object)uri)) {
                    return com.google.android.exoplayer2.source.rtsp.h.d.b(a);
                }
            }
        }
        return null;
    }
    
    private boolean R() {
        return this.y != -9223372036854775807L;
    }
    
    private void S() {
        if (!this.C) {
            if (!this.D) {
                for (int i = 0; i < this.e.size(); ++i) {
                    if (com.google.android.exoplayer2.source.rtsp.h.e.b(this.e.get(i)).F() == null) {
                        return;
                    }
                }
                this.D = true;
                this.j = O((ImmutableList<e>)ImmutableList.copyOf((Collection)this.e));
                Assertions.e(this.i).o(this);
            }
        }
    }
    
    private void T() {
        boolean b = true;
        for (int i = 0; i < this.f.size(); ++i) {
            b &= this.f.get(i).e();
        }
        if (b && this.E) {
            this.d.N0(this.f);
        }
    }
    
    private void W() {
        this.d.J0();
        final RtpDataChannel.Factory b = this.h.b();
        if (b == null) {
            this.w = new RtspMediaSource.RtspPlaybackException("No fallback data channel factory for TCP retry");
            return;
        }
        final ArrayList list = new ArrayList(this.e.size());
        final ArrayList list2 = new ArrayList(this.f.size());
        final int n = 0;
        for (int i = 0; i < this.e.size(); ++i) {
            final e e = this.e.get(i);
            if (!com.google.android.exoplayer2.source.rtsp.h.e.a(e)) {
                final e e2 = new e(e.a.a, i, b);
                list.add(e2);
                e2.j();
                if (this.f.contains(e.a)) {
                    list2.add(e2.a);
                }
            }
            else {
                list.add(e);
            }
        }
        final ImmutableList copy = ImmutableList.copyOf((Collection)this.e);
        this.e.clear();
        this.e.addAll(list);
        this.f.clear();
        this.f.addAll(list2);
        for (int j = n; j < ((AbstractCollection)copy).size(); ++j) {
            ((List<e>)copy).get(j).c();
        }
    }
    
    private boolean X(final long n) {
        for (int i = 0; i < this.e.size(); ++i) {
            if (!com.google.android.exoplayer2.source.rtsp.h.e.b(this.e.get(i)).Z(n, false)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean Z() {
        return this.B;
    }
    
    static int a(final h h) {
        return h.F++;
    }
    
    private void a0() {
        this.A = true;
        for (int i = 0; i < this.e.size(); ++i) {
            this.A &= com.google.android.exoplayer2.source.rtsp.h.e.a(this.e.get(i));
        }
    }
    
    static RtspMediaSource.RtspPlaybackException e(final h h) {
        return h.w;
    }
    
    static RtspMediaSource.RtspPlaybackException l(final h h, final RtspMediaSource.RtspPlaybackException w) {
        return h.w = w;
    }
    
    static RtspClient m(final h h) {
        return h.d;
    }
    
    static List o(final h h) {
        return h.f;
    }
    
    static c r(final h h) {
        return h.g;
    }
    
    static boolean s(final h h) {
        return h.R();
    }
    
    static boolean t(final h h, final boolean b) {
        return h.B = b;
    }
    
    static long u(final h h) {
        return h.y;
    }
    
    static long v(final h h, final long y) {
        return h.y = y;
    }
    
    static long w(final h h) {
        return h.x;
    }
    
    static long x(final h h, final long x) {
        return h.x = x;
    }
    
    static long y(final h h) {
        return h.z;
    }
    
    static long z(final h h, final long z) {
        return h.z = z;
    }
    
    boolean Q(final int n) {
        return !this.Z() && this.e.get(n).e();
    }
    
    int U(final int n, final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n2) {
        if (this.Z()) {
            return -3;
        }
        return this.e.get(n).f(formatHolder, decoderInputBuffer, n2);
    }
    
    public void V() {
        for (int i = 0; i < this.e.size(); ++i) {
            this.e.get(i).g();
        }
        Util.n(this.d);
        this.C = true;
    }
    
    int Y(final int n, final long n2) {
        if (this.Z()) {
            return -3;
        }
        return this.e.get(n).i(n2);
    }
    
    @Override
    public long b() {
        return this.f();
    }
    
    @Override
    public long c(final long n, final SeekParameters seekParameters) {
        return n;
    }
    
    @Override
    public boolean d(final long n) {
        return this.isLoading();
    }
    
    @Override
    public long f() {
        if (this.A || this.e.isEmpty()) {
            return Long.MIN_VALUE;
        }
        final long x = this.x;
        if (x != -9223372036854775807L) {
            return x;
        }
        long n = Long.MAX_VALUE;
        boolean b = true;
        long min;
        for (int i = 0; i < this.e.size(); ++i, n = min) {
            final e e = this.e.get(i);
            min = n;
            if (!com.google.android.exoplayer2.source.rtsp.h.e.a(e)) {
                min = Math.min(n, e.d());
                b = false;
            }
        }
        if (!b) {
            final long n2 = n;
            if (n != Long.MIN_VALUE) {
                return n2;
            }
        }
        return 0L;
    }
    
    @Override
    public void g(final long n) {
    }
    
    @Override
    public long h(final long n) {
        if (this.f() == 0L && !this.G) {
            return this.z = n;
        }
        int i = 0;
        this.q(n, false);
        this.x = n;
        if (this.R()) {
            final int c0 = this.d.C0();
            if (c0 == 1) {
                return n;
            }
            if (c0 == 2) {
                this.y = n;
                this.d.K0(n);
                return n;
            }
            throw new IllegalStateException();
        }
        else {
            if (this.X(n)) {
                return n;
            }
            this.y = n;
            this.d.K0(n);
            while (i < this.e.size()) {
                this.e.get(i).h(n);
                ++i;
            }
            return n;
        }
    }
    
    @Override
    public long i() {
        if (this.B) {
            this.B = false;
            return 0L;
        }
        return -9223372036854775807L;
    }
    
    @Override
    public boolean isLoading() {
        return this.A ^ true;
    }
    
    @Override
    public void j(final Callback i, final long n) {
        this.i = i;
        try {
            this.d.R0();
        }
        catch (final IOException p2) {
            this.p = p2;
            Util.n(this.d);
        }
    }
    
    @Override
    public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, final long n) {
        final int n2 = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array3[i] != null && (array[i] == null || !array2[i])) {
                array3[i] = null;
            }
        }
        this.f.clear();
        int n3 = 0;
        int j;
        while (true) {
            j = n2;
            if (n3 >= array.length) {
                break;
            }
            final ExoTrackSelection exoTrackSelection = array[n3];
            if (exoTrackSelection != null) {
                final TrackGroup l = exoTrackSelection.l();
                final int index = Assertions.e(this.j).indexOf((Object)l);
                this.f.add(Assertions.e(this.e.get(index)).a);
                if (this.j.contains((Object)l) && array3[n3] == null) {
                    array3[n3] = new f(index);
                    array4[n3] = true;
                }
            }
            ++n3;
        }
        while (j < this.e.size()) {
            final e e = this.e.get(j);
            if (!this.f.contains(e.a)) {
                e.c();
            }
            ++j;
        }
        this.E = true;
        this.T();
        return n;
    }
    
    @Override
    public void n() throws IOException {
        final IOException p = this.p;
        if (p == null) {
            return;
        }
        throw p;
    }
    
    @Override
    public TrackGroupArray p() {
        Assertions.g(this.D);
        return new TrackGroupArray((TrackGroup[])((ImmutableCollection)Assertions.e(this.j)).toArray((Object[])new TrackGroup[0]));
    }
    
    @Override
    public void q(final long n, final boolean b) {
        if (this.R()) {
            return;
        }
        for (int i = 0; i < this.e.size(); ++i) {
            final e e = this.e.get(i);
            if (!com.google.android.exoplayer2.source.rtsp.h.e.a(e)) {
                com.google.android.exoplayer2.source.rtsp.h.e.b(e).q(n, b, true);
            }
        }
    }
    
    private final class b implements ExtractorOutput, Loader.Callback<RtpDataLoadable>, UpstreamFormatChangedListener, SessionInfoListener, PlaybackEventListener
    {
        final h a;
        
        private b(final h a) {
            this.a = a;
        }
        
        b(final h h, final h$a object) {
            this(h);
        }
        
        public static void h(final h h) {
            j(h);
        }
        
        public static void i(final h h) {
            k(h);
        }
        
        private static void j(final h h) {
            h.C(h);
        }
        
        private static void k(final h h) {
            h.C(h);
        }
        
        @Override
        public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
            this.n((RtpDataLoadable)loadable, n, n2);
        }
        
        @Override
        public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
            return this.p((RtpDataLoadable)loadable, n, n2, ex, n3);
        }
        
        @Override
        public void a(final Format format) {
            h.I(this.a).post((Runnable)new j(this.a));
        }
        
        @Override
        public void b(final String s, final Throwable t) {
            final h a = this.a;
            IOException ex;
            if (t == null) {
                ex = new IOException(s);
            }
            else {
                ex = new IOException(s, t);
            }
            h.N(a, ex);
        }
        
        @Override
        public void c(final RtspMediaSource.RtspPlaybackException ex) {
            h.l(this.a, ex);
        }
        
        @Override
        public void d() {
            h.m(this.a).S0(0L);
        }
        
        @Override
        public TrackOutput e(final int n, final int n2) {
            return e.b(Assertions.e((e)h.H(this.a).get(n)));
        }
        
        @Override
        public void f(final long n, final ImmutableList<t> list) {
            final ArrayList list2 = new ArrayList(((AbstractCollection)list).size());
            final int n2 = 0;
            for (int i = 0; i < ((AbstractCollection)list).size(); ++i) {
                list2.add(Assertions.e(((List<t>)list).get(i).c.getPath()));
            }
            int n3 = 0;
            int j;
            while (true) {
                j = n2;
                if (n3 >= h.o(this.a).size()) {
                    break;
                }
                if (!list2.contains(((h.d)h.o(this.a).get(n3)).c().getPath())) {
                    h.r(this.a).a();
                    if (h.s(this.a)) {
                        h.t(this.a, true);
                        h.v(this.a, -9223372036854775807L);
                        h.x(this.a, -9223372036854775807L);
                        h.z(this.a, -9223372036854775807L);
                    }
                }
                ++n3;
            }
            while (j < ((AbstractCollection)list).size()) {
                final t t = ((List<t>)list).get(j);
                final RtpDataLoadable a = h.A(this.a, t.c);
                if (a != null) {
                    a.h(t.a);
                    a.g(t.b);
                    if (h.s(this.a) && h.u(this.a) == h.w(this.a)) {
                        a.f(n, t.a);
                    }
                }
                ++j;
            }
            if (h.s(this.a)) {
                if (h.u(this.a) == h.w(this.a)) {
                    h.v(this.a, -9223372036854775807L);
                    h.x(this.a, -9223372036854775807L);
                }
                else {
                    h.v(this.a, -9223372036854775807L);
                    final h a2 = this.a;
                    a2.h(h.w(a2));
                }
            }
            else if (h.y(this.a) != -9223372036854775807L) {
                final h a3 = this.a;
                a3.h(h.y(a3));
                h.z(this.a, -9223372036854775807L);
            }
        }
        
        @Override
        public void g(final q q, final ImmutableList<l> list) {
            for (int i = 0; i < ((AbstractCollection)list).size(); ++i) {
                final l l = ((List<l>)list).get(i);
                final h a = this.a;
                final e e = a.new e(l, i, h.B(a));
                h.H(this.a).add(e);
                e.j();
            }
            h.r(this.a).b(q);
        }
        
        @Override
        public void l(final SeekMap seekMap) {
        }
        
        public void m(final RtpDataLoadable rtpDataLoadable, final long n, final long n2, final boolean b) {
        }
        
        public void n(final RtpDataLoadable rtpDataLoadable, final long n, final long n2) {
            if (this.a.f() == 0L) {
                if (!h.J(this.a)) {
                    h.L(this.a);
                    h.K(this.a, true);
                }
                return;
            }
            for (int i = 0; i < h.H(this.a).size(); ++i) {
                final e e = h.H(this.a).get(i);
                if (d.b(e.a) == rtpDataLoadable) {
                    e.c();
                    break;
                }
            }
        }
        
        @Override
        public void o() {
            h.I(this.a).post((Runnable)new i(this.a));
        }
        
        public LoadErrorAction p(final RtpDataLoadable rtpDataLoadable, final long n, final long n2, final IOException ex, final int n3) {
            if (!h.M(this.a)) {
                h.N(this.a, ex);
            }
            else if (ex.getCause() instanceof BindException) {
                if (h.a(this.a) < 3) {
                    return Loader.d;
                }
            }
            else {
                h.l(this.a, new RtspMediaSource.RtspPlaybackException(rtpDataLoadable.b.b.toString(), ex));
            }
            return Loader.f;
        }
        
        @Override
        public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
            this.m((RtpDataLoadable)loadable, n, n2, b);
        }
    }
    
    interface c
    {
        default void a() {
        }
        
        void b(final q p0);
    }
    
    final class d
    {
        public final l a;
        private final RtpDataLoadable b;
        private String c;
        final h d;
        
        public d(final h d, final l a, final int n, final RtpDataChannel.Factory factory) {
            this.d = d;
            this.a = a;
            this.b = new RtpDataLoadable(n, a, (RtpDataLoadable.EventListener)new k(this), com.google.android.exoplayer2.source.rtsp.h.E(d), factory);
        }
        
        public static void a(final d d, final String s, final RtpDataChannel rtpDataChannel) {
            d.f(s, rtpDataChannel);
        }
        
        static RtpDataLoadable b(final d d) {
            return d.b;
        }
        
        private void f(final String c, final RtpDataChannel rtpDataChannel) {
            this.c = c;
            final RtspMessageChannel.InterleavedBinaryDataListener l = rtpDataChannel.l();
            if (l != null) {
                com.google.android.exoplayer2.source.rtsp.h.m(this.d).G0(rtpDataChannel.d(), l);
                com.google.android.exoplayer2.source.rtsp.h.K(this.d, true);
            }
            com.google.android.exoplayer2.source.rtsp.h.G(this.d);
        }
        
        public Uri c() {
            return this.b.b.b;
        }
        
        public String d() {
            Assertions.i(this.c);
            return this.c;
        }
        
        public boolean e() {
            return this.c != null;
        }
    }
    
    private final class e
    {
        public final d a;
        private final Loader b;
        private final SampleQueue c;
        private boolean d;
        private boolean e;
        final h f;
        
        public e(final h f, final l l, final int n, final RtpDataChannel.Factory factory) {
            this.f = f;
            this.a = f.new d(l, n, factory);
            final StringBuilder sb = new StringBuilder();
            sb.append("ExoPlayer:RtspMediaPeriod:RtspLoaderWrapper ");
            sb.append(n);
            this.b = new Loader(sb.toString());
            (this.c = SampleQueue.l(com.google.android.exoplayer2.source.rtsp.h.D(f))).d0((SampleQueue.UpstreamFormatChangedListener)com.google.android.exoplayer2.source.rtsp.h.E(f));
        }
        
        static boolean a(final e e) {
            return e.d;
        }
        
        static SampleQueue b(final e e) {
            return e.c;
        }
        
        public void c() {
            if (!this.d) {
                com.google.android.exoplayer2.source.rtsp.h.d.b(this.a).c();
                this.d = true;
                com.google.android.exoplayer2.source.rtsp.h.F(this.f);
            }
        }
        
        public long d() {
            return this.c.z();
        }
        
        public boolean e() {
            return this.c.K(this.d);
        }
        
        public int f(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
            return this.c.S(formatHolder, decoderInputBuffer, n, this.d);
        }
        
        public void g() {
            if (this.e) {
                return;
            }
            this.b.l();
            this.c.T();
            this.e = true;
        }
        
        public void h(final long n) {
            if (!this.d) {
                com.google.android.exoplayer2.source.rtsp.h.d.b(this.a).e();
                this.c.V();
                this.c.b0(n);
            }
        }
        
        public int i(final long n) {
            final int e = this.c.E(n, this.d);
            this.c.e0(e);
            return e;
        }
        
        public void j() {
            this.b.n(com.google.android.exoplayer2.source.rtsp.h.d.b(this.a), (Loader.Callback<RtpDataLoadable>)com.google.android.exoplayer2.source.rtsp.h.E(this.f), 0);
        }
    }
    
    private final class f implements SampleStream
    {
        private final int a;
        final h b;
        
        public f(final h b, final int a) {
            this.b = b;
            this.a = a;
        }
        
        @Override
        public void a() throws RtspMediaSource.RtspPlaybackException {
            if (com.google.android.exoplayer2.source.rtsp.h.e(this.b) == null) {
                return;
            }
            throw com.google.android.exoplayer2.source.rtsp.h.e(this.b);
        }
        
        @Override
        public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
            return this.b.U(this.a, formatHolder, decoderInputBuffer, n);
        }
        
        @Override
        public boolean isReady() {
            return this.b.Q(this.a);
        }
        
        @Override
        public int l(final long n) {
            return this.b.Y(this.a, n);
        }
    }
}
