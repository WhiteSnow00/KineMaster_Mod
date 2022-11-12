// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.ParserException;
import com.google.common.collect.Iterables;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.util.Map;
import com.google.android.exoplayer2.source.LoadEventInfo;
import java.io.IOException;
import java.util.Iterator;
import com.google.android.exoplayer2.util.Assertions;
import android.os.SystemClock;
import android.net.Uri$Builder;
import java.util.List;
import z3.a;
import android.os.Handler;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.util.concurrent.CopyOnWriteArrayList;
import android.net.Uri;
import java.util.HashMap;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.Loader;

public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Callback<ParsingLoadable<HlsPlaylist>>
{
    public static final Factory A;
    private final HlsDataSourceFactory a;
    private final HlsPlaylistParserFactory b;
    private final LoadErrorHandlingPolicy c;
    private final HashMap<Uri, c> d;
    private final CopyOnWriteArrayList<PlaylistEventListener> e;
    private final double f;
    private MediaSourceEventListener.EventDispatcher g;
    private Loader h;
    private Handler i;
    private PrimaryPlaylistListener j;
    private HlsMultivariantPlaylist p;
    private Uri w;
    private HlsMediaPlaylist x;
    private boolean y;
    private long z;
    
    static {
        A = (Factory)a.a;
    }
    
    public DefaultHlsPlaylistTracker(final HlsDataSourceFactory hlsDataSourceFactory, final LoadErrorHandlingPolicy loadErrorHandlingPolicy, final HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory, 3.5);
    }
    
    public DefaultHlsPlaylistTracker(final HlsDataSourceFactory a, final LoadErrorHandlingPolicy c, final HlsPlaylistParserFactory b, final double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.f = f;
        this.e = new CopyOnWriteArrayList<PlaylistEventListener>();
        this.d = new HashMap<Uri, c>();
        this.z = -9223372036854775807L;
    }
    
    static MediaSourceEventListener.EventDispatcher B(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.g;
    }
    
    static LoadErrorHandlingPolicy C(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.c;
    }
    
    private void D(final List<Uri> list) {
        for (int size = list.size(), i = 0; i < size; ++i) {
            final Uri uri = list.get(i);
            this.d.put(uri, new c(uri));
        }
    }
    
    private static HlsMediaPlaylist.Segment E(final HlsMediaPlaylist hlsMediaPlaylist, final HlsMediaPlaylist hlsMediaPlaylist2) {
        final int n = (int)(hlsMediaPlaylist2.k - hlsMediaPlaylist.k);
        final List<HlsMediaPlaylist.Segment> r = hlsMediaPlaylist.r;
        HlsMediaPlaylist.Segment segment;
        if (n < r.size()) {
            segment = (HlsMediaPlaylist.Segment)r.get(n);
        }
        else {
            segment = null;
        }
        return segment;
    }
    
    private HlsMediaPlaylist F(final HlsMediaPlaylist hlsMediaPlaylist, final HlsMediaPlaylist hlsMediaPlaylist2) {
        if (!hlsMediaPlaylist2.f(hlsMediaPlaylist)) {
            HlsMediaPlaylist d = hlsMediaPlaylist;
            if (hlsMediaPlaylist2.o) {
                d = hlsMediaPlaylist.d();
            }
            return d;
        }
        return hlsMediaPlaylist2.c(this.H(hlsMediaPlaylist, hlsMediaPlaylist2), this.G(hlsMediaPlaylist, hlsMediaPlaylist2));
    }
    
    private int G(final HlsMediaPlaylist hlsMediaPlaylist, final HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.i) {
            return hlsMediaPlaylist2.j;
        }
        final HlsMediaPlaylist x = this.x;
        int j;
        if (x != null) {
            j = x.j;
        }
        else {
            j = 0;
        }
        if (hlsMediaPlaylist == null) {
            return j;
        }
        final HlsMediaPlaylist.Segment e = E(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (e != null) {
            return hlsMediaPlaylist.j + e.d - ((HlsMediaPlaylist.Segment)hlsMediaPlaylist2.r.get(0)).d;
        }
        return j;
    }
    
    private long H(final HlsMediaPlaylist hlsMediaPlaylist, final HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.p) {
            return hlsMediaPlaylist2.h;
        }
        final HlsMediaPlaylist x = this.x;
        long h;
        if (x != null) {
            h = x.h;
        }
        else {
            h = 0L;
        }
        if (hlsMediaPlaylist == null) {
            return h;
        }
        final int size = hlsMediaPlaylist.r.size();
        final HlsMediaPlaylist.Segment e = E(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (e != null) {
            return hlsMediaPlaylist.h + e.e;
        }
        if (size == hlsMediaPlaylist2.k - hlsMediaPlaylist.k) {
            return hlsMediaPlaylist.e();
        }
        return h;
    }
    
    private Uri I(final Uri uri) {
        final HlsMediaPlaylist x = this.x;
        Uri build = uri;
        if (x != null) {
            build = uri;
            if (x.v.e) {
                final HlsMediaPlaylist.RenditionReport renditionReport = x.t.get(uri);
                build = uri;
                if (renditionReport != null) {
                    final Uri$Builder buildUpon = uri.buildUpon();
                    buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(renditionReport.b));
                    final int c = renditionReport.c;
                    if (c != -1) {
                        buildUpon.appendQueryParameter("_HLS_part", String.valueOf(c));
                    }
                    build = buildUpon.build();
                }
            }
        }
        return build;
    }
    
    private boolean J(final Uri uri) {
        final List<HlsMultivariantPlaylist.Variant> e = this.p.e;
        for (int i = 0; i < e.size(); ++i) {
            if (uri.equals((Object)((HlsMultivariantPlaylist.Variant)e.get(i)).a)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean K() {
        final List<HlsMultivariantPlaylist.Variant> e = this.p.e;
        final int size = e.size();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; ++i) {
            final c c = Assertions.e(this.d.get(e.get(i).a));
            if (elapsedRealtime > DefaultHlsPlaylistTracker.c.d(c)) {
                final Uri e2 = DefaultHlsPlaylistTracker.c.e(c);
                this.w = e2;
                DefaultHlsPlaylistTracker.c.f(c, this.I(e2));
                return true;
            }
        }
        return false;
    }
    
    private void M(final Uri w) {
        if (!w.equals((Object)this.w) && this.J(w)) {
            final HlsMediaPlaylist x = this.x;
            if (x == null || !x.o) {
                this.w = w;
                final c c = this.d.get(w);
                final HlsMediaPlaylist g = DefaultHlsPlaylistTracker.c.g(c);
                if (g != null && g.o) {
                    this.x = g;
                    this.j.y(g);
                }
                else {
                    DefaultHlsPlaylistTracker.c.f(c, this.I(w));
                }
            }
        }
    }
    
    private boolean N(final Uri uri, final LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, final boolean b) {
        final Iterator<PlaylistEventListener> iterator = this.e.iterator();
        boolean b2 = false;
        while (iterator.hasNext()) {
            b2 |= (iterator.next().e(uri, loadErrorInfo, b) ^ true);
        }
        return b2;
    }
    
    private void R(final Uri uri, final HlsMediaPlaylist x) {
        if (uri.equals((Object)this.w)) {
            if (this.x == null) {
                this.y = (x.o ^ true);
                this.z = x.h;
            }
            this.x = x;
            this.j.y(x);
        }
        final Iterator<PlaylistEventListener> iterator = this.e.iterator();
        while (iterator.hasNext()) {
            iterator.next().a();
        }
    }
    
    static boolean m(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, final Uri uri, final LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, final boolean b) {
        return defaultHlsPlaylistTracker.N(uri, loadErrorInfo, b);
    }
    
    static Handler n(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.i;
    }
    
    static HlsMultivariantPlaylist o(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.p;
    }
    
    static HlsPlaylistParserFactory p(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.b;
    }
    
    static HlsMediaPlaylist q(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, final HlsMediaPlaylist hlsMediaPlaylist, final HlsMediaPlaylist hlsMediaPlaylist2) {
        return defaultHlsPlaylistTracker.F(hlsMediaPlaylist, hlsMediaPlaylist2);
    }
    
    static void r(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, final Uri uri, final HlsMediaPlaylist hlsMediaPlaylist) {
        defaultHlsPlaylistTracker.R(uri, hlsMediaPlaylist);
    }
    
    static double s(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.f;
    }
    
    static Uri t(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.w;
    }
    
    static boolean u(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.K();
    }
    
    static CopyOnWriteArrayList w(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.e;
    }
    
    static HlsMediaPlaylist x(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.x;
    }
    
    static HashMap y(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.d;
    }
    
    static HlsDataSourceFactory z(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.a;
    }
    
    @Override
    public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
        this.P((ParsingLoadable<HlsPlaylist>)loadable, n, n2);
    }
    
    @Override
    public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
        return this.Q((ParsingLoadable<HlsPlaylist>)loadable, n, n2, ex, n3);
    }
    
    public void O(final ParsingLoadable<HlsPlaylist> parsingLoadable, final long n, final long n2, final boolean b) {
        final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), n, n2, parsingLoadable.b());
        this.c.d(parsingLoadable.a);
        this.g.q(loadEventInfo, 4);
    }
    
    public void P(final ParsingLoadable<HlsPlaylist> parsingLoadable, final long n, final long n2) {
        final HlsPlaylist hlsPlaylist = (HlsPlaylist)parsingLoadable.e();
        final boolean b = hlsPlaylist instanceof HlsMediaPlaylist;
        HlsMultivariantPlaylist e;
        if (b) {
            e = HlsMultivariantPlaylist.e(hlsPlaylist.a);
        }
        else {
            e = (HlsMultivariantPlaylist)hlsPlaylist;
        }
        this.p = e;
        this.w = ((HlsMultivariantPlaylist.Variant)e.e.get(0)).a;
        this.e.add(new b(null));
        this.D(e.d);
        final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), n, n2, parsingLoadable.b());
        final c c = this.d.get(this.w);
        if (b) {
            DefaultHlsPlaylistTracker.c.c(c, (HlsMediaPlaylist)hlsPlaylist, loadEventInfo);
        }
        else {
            c.m();
        }
        this.c.d(parsingLoadable.a);
        this.g.t(loadEventInfo, 4);
    }
    
    public LoadErrorAction Q(final ParsingLoadable<HlsPlaylist> parsingLoadable, long a, final long n, final IOException ex, final int n2) {
        final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), a, n, parsingLoadable.b());
        a = this.c.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable.c), ex, n2));
        final boolean b = a == -9223372036854775807L;
        this.g.x(loadEventInfo, parsingLoadable.c, ex, b);
        if (b) {
            this.c.d(parsingLoadable.a);
        }
        Loader.LoadErrorAction loadErrorAction;
        if (b) {
            loadErrorAction = Loader.g;
        }
        else {
            loadErrorAction = Loader.h(false, a);
        }
        return loadErrorAction;
    }
    
    @Override
    public void a(final PlaylistEventListener playlistEventListener) {
        this.e.remove(playlistEventListener);
    }
    
    @Override
    public void b(final Uri uri) throws IOException {
        this.d.get(uri).p();
    }
    
    @Override
    public long c() {
        return this.z;
    }
    
    @Override
    public HlsMultivariantPlaylist d() {
        return this.p;
    }
    
    @Override
    public void e(final Uri uri) {
        this.d.get(uri).m();
    }
    
    @Override
    public void f(final PlaylistEventListener playlistEventListener) {
        Assertions.e(playlistEventListener);
        this.e.add(playlistEventListener);
    }
    
    @Override
    public boolean g(final Uri uri) {
        return this.d.get(uri).k();
    }
    
    @Override
    public boolean h() {
        return this.y;
    }
    
    @Override
    public boolean i(final Uri uri, final long n) {
        final c c = this.d.get(uri);
        return c != null && (DefaultHlsPlaylistTracker.c.b(c, n) ^ true);
    }
    
    @Override
    public void j(final Uri uri, final MediaSourceEventListener.EventDispatcher g, final PrimaryPlaylistListener j) {
        this.i = Util.w();
        this.g = g;
        this.j = j;
        final ParsingLoadable parsingLoadable = new ParsingLoadable(this.a.a(4), uri, 4, (ParsingLoadable.Parser<? extends T>)this.b.a());
        Assertions.g(this.h == null);
        final Loader h = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.h = h;
        g.z(new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, h.n(parsingLoadable, (Loader.Callback<ParsingLoadable>)this, this.c.b(parsingLoadable.c))), parsingLoadable.c);
    }
    
    @Override
    public void k() throws IOException {
        final Loader h = this.h;
        if (h != null) {
            h.a();
        }
        final Uri w = this.w;
        if (w != null) {
            this.b(w);
        }
    }
    
    @Override
    public HlsMediaPlaylist l(final Uri uri, final boolean b) {
        final HlsMediaPlaylist j = this.d.get(uri).j();
        if (j != null && b) {
            this.M(uri);
        }
        return j;
    }
    
    @Override
    public void stop() {
        this.w = null;
        this.x = null;
        this.p = null;
        this.z = -9223372036854775807L;
        this.h.l();
        this.h = null;
        final Iterator<c> iterator = this.d.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().u();
        }
        this.i.removeCallbacksAndMessages((Object)null);
        this.i = null;
        this.d.clear();
    }
    
    @Override
    public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
        this.O((ParsingLoadable<HlsPlaylist>)loadable, n, n2, b);
    }
    
    private class b implements PlaylistEventListener
    {
        final DefaultHlsPlaylistTracker a;
        
        private b(final DefaultHlsPlaylistTracker a) {
            this.a = a;
        }
        
        b(final DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, final DefaultHlsPlaylistTracker$a object) {
            this(defaultHlsPlaylistTracker);
        }
        
        @Override
        public void a() {
            DefaultHlsPlaylistTracker.w(this.a).remove(this);
        }
        
        @Override
        public boolean e(final Uri uri, final LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, final boolean b) {
            if (DefaultHlsPlaylistTracker.x(this.a) == null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                final List<HlsMultivariantPlaylist.Variant> e = Util.j(DefaultHlsPlaylistTracker.o(this.a)).e;
                int i = 0;
                int n = 0;
                while (i < e.size()) {
                    final c c = DefaultHlsPlaylistTracker.y(this.a).get(e.get(i).a);
                    int n2 = n;
                    if (c != null) {
                        n2 = n;
                        if (elapsedRealtime < DefaultHlsPlaylistTracker.c.d(c)) {
                            n2 = n + 1;
                        }
                    }
                    ++i;
                    n = n2;
                }
                final LoadErrorHandlingPolicy.FallbackSelection c2 = DefaultHlsPlaylistTracker.C(this.a).c(new LoadErrorHandlingPolicy.FallbackOptions(1, 0, DefaultHlsPlaylistTracker.o(this.a).e.size(), n), loadErrorInfo);
                if (c2 != null && c2.a == 2) {
                    final c c3 = DefaultHlsPlaylistTracker.y(this.a).get(uri);
                    if (c3 != null) {
                        DefaultHlsPlaylistTracker.c.b(c3, c2.b);
                    }
                }
            }
            return false;
        }
    }
    
    private final class c implements Callback<ParsingLoadable<HlsPlaylist>>
    {
        private final Uri a;
        private final Loader b;
        private final DataSource c;
        private HlsMediaPlaylist d;
        private long e;
        private long f;
        private long g;
        private long h;
        private boolean i;
        private IOException j;
        final DefaultHlsPlaylistTracker p;
        
        public c(final DefaultHlsPlaylistTracker p2, final Uri a) {
            this.p = p2;
            this.a = a;
            this.b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
            this.c = DefaultHlsPlaylistTracker.z(p2).a(4);
        }
        
        public static void a(final c c, final Uri uri) {
            c.l(uri);
        }
        
        static boolean b(final c c, final long n) {
            return c.h(n);
        }
        
        static void c(final c c, final HlsMediaPlaylist hlsMediaPlaylist, final LoadEventInfo loadEventInfo) {
            c.t(hlsMediaPlaylist, loadEventInfo);
        }
        
        static long d(final c c) {
            return c.h;
        }
        
        static Uri e(final c c) {
            return c.a;
        }
        
        static void f(final c c, final Uri uri) {
            c.o(uri);
        }
        
        static HlsMediaPlaylist g(final c c) {
            return c.d;
        }
        
        private boolean h(final long n) {
            this.h = SystemClock.elapsedRealtime() + n;
            return this.a.equals((Object)DefaultHlsPlaylistTracker.t(this.p)) && !DefaultHlsPlaylistTracker.u(this.p);
        }
        
        private Uri i() {
            final HlsMediaPlaylist d = this.d;
            if (d != null) {
                final HlsMediaPlaylist.ServerControl v = d.v;
                if (v.a != -9223372036854775807L || v.e) {
                    final Uri$Builder buildUpon = this.a.buildUpon();
                    final HlsMediaPlaylist d2 = this.d;
                    if (d2.v.e) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(d2.k + d2.r.size()));
                        final HlsMediaPlaylist d3 = this.d;
                        if (d3.n != -9223372036854775807L) {
                            final List<HlsMediaPlaylist.Part> s = d3.s;
                            int size;
                            final int n = size = s.size();
                            if (!s.isEmpty()) {
                                size = n;
                                if (((HlsMediaPlaylist.Part)Iterables.h((Iterable)s)).x) {
                                    size = n - 1;
                                }
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    final HlsMediaPlaylist.ServerControl v2 = this.d.v;
                    if (v2.a != -9223372036854775807L) {
                        String s2;
                        if (v2.b) {
                            s2 = "v2";
                        }
                        else {
                            s2 = "YES";
                        }
                        buildUpon.appendQueryParameter("_HLS_skip", s2);
                    }
                    return buildUpon.build();
                }
            }
            return this.a;
        }
        
        private void l(final Uri uri) {
            this.i = false;
            this.n(uri);
        }
        
        private void n(final Uri uri) {
            final ParsingLoadable parsingLoadable = new ParsingLoadable(this.c, uri, 4, (ParsingLoadable.Parser<? extends T>)DefaultHlsPlaylistTracker.p(this.p).b(DefaultHlsPlaylistTracker.o(this.p), this.d));
            DefaultHlsPlaylistTracker.B(this.p).z(new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, this.b.n(parsingLoadable, (Loader.Callback<ParsingLoadable>)this, DefaultHlsPlaylistTracker.C(this.p).b(parsingLoadable.c))), parsingLoadable.c);
        }
        
        private void o(final Uri uri) {
            this.h = 0L;
            if (!this.i && !this.b.j()) {
                if (!this.b.i()) {
                    final long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (elapsedRealtime < this.g) {
                        this.i = true;
                        DefaultHlsPlaylistTracker.n(this.p).postDelayed((Runnable)new com.google.android.exoplayer2.source.hls.playlist.a(this, uri), this.g - elapsedRealtime);
                    }
                    else {
                        this.n(uri);
                    }
                }
            }
        }
        
        private void t(HlsMediaPlaylist d, final LoadEventInfo loadEventInfo) {
            final HlsMediaPlaylist d2 = this.d;
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.e = elapsedRealtime;
            final HlsMediaPlaylist q = DefaultHlsPlaylistTracker.q(this.p, d2, d);
            this.d = q;
            boolean b = false;
            final PlaylistResetException ex = null;
            if (q != d2) {
                this.j = null;
                this.f = elapsedRealtime;
                DefaultHlsPlaylistTracker.r(this.p, this.a, q);
            }
            else if (!q.o) {
                final long k = d.k;
                final long n = d.r.size();
                final HlsMediaPlaylist d3 = this.d;
                IOException j;
                boolean b2;
                if (k + n < d3.k) {
                    j = new PlaylistResetException(this.a);
                    b2 = true;
                }
                else {
                    j = ex;
                    if (elapsedRealtime - this.f > Util.f1(d3.m) * DefaultHlsPlaylistTracker.s(this.p)) {
                        j = new PlaylistStuckException(this.a);
                    }
                    b2 = false;
                }
                if (j != null) {
                    this.j = j;
                    DefaultHlsPlaylistTracker.m(this.p, this.a, new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(4), j, 1), b2);
                }
            }
            long m = 0L;
            d = this.d;
            if (!d.v.e) {
                if (d != d2) {
                    m = d.m;
                }
                else {
                    m = d.m / 2L;
                }
            }
            this.g = elapsedRealtime + Util.f1(m);
            if (this.d.n != -9223372036854775807L || this.a.equals((Object)DefaultHlsPlaylistTracker.t(this.p))) {
                b = true;
            }
            if (b && !this.d.o) {
                this.o(this.i());
            }
        }
        
        @Override
        public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
            this.r((ParsingLoadable<HlsPlaylist>)loadable, n, n2);
        }
        
        @Override
        public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
            return this.s((ParsingLoadable<HlsPlaylist>)loadable, n, n2, ex, n3);
        }
        
        public HlsMediaPlaylist j() {
            return this.d;
        }
        
        public boolean k() {
            final HlsMediaPlaylist d = this.d;
            boolean b = false;
            if (d == null) {
                return false;
            }
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            final long max = Math.max(30000L, Util.f1(this.d.u));
            final HlsMediaPlaylist d2 = this.d;
            if (!d2.o) {
                final int d3 = d2.d;
                if (d3 != 2 && d3 != 1 && this.e + max <= elapsedRealtime) {
                    return b;
                }
            }
            b = true;
            return b;
        }
        
        public void m() {
            this.o(this.a);
        }
        
        public void p() throws IOException {
            this.b.a();
            final IOException j = this.j;
            if (j == null) {
                return;
            }
            throw j;
        }
        
        public void q(final ParsingLoadable<HlsPlaylist> parsingLoadable, final long n, final long n2, final boolean b) {
            final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), n, n2, parsingLoadable.b());
            DefaultHlsPlaylistTracker.C(this.p).d(parsingLoadable.a);
            DefaultHlsPlaylistTracker.B(this.p).q(loadEventInfo, 4);
        }
        
        public void r(final ParsingLoadable<HlsPlaylist> parsingLoadable, final long n, final long n2) {
            final HlsPlaylist hlsPlaylist = (HlsPlaylist)parsingLoadable.e();
            final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), n, n2, parsingLoadable.b());
            if (hlsPlaylist instanceof HlsMediaPlaylist) {
                this.t((HlsMediaPlaylist)hlsPlaylist, loadEventInfo);
                DefaultHlsPlaylistTracker.B(this.p).t(loadEventInfo, 4);
            }
            else {
                this.j = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
                DefaultHlsPlaylistTracker.B(this.p).x(loadEventInfo, 4, this.j, true);
            }
            DefaultHlsPlaylistTracker.C(this.p).d(parsingLoadable.a);
        }
        
        public LoadErrorAction s(final ParsingLoadable<HlsPlaylist> parsingLoadable, long a, final long n, final IOException ex, final int n2) {
            final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), a, n, parsingLoadable.b());
            final boolean b = parsingLoadable.f().getQueryParameter("_HLS_msn") != null;
            final boolean b2 = ex instanceof HlsPlaylistParser.DeltaUpdateException;
            if (b || b2) {
                int responseCode = Integer.MAX_VALUE;
                if (ex instanceof HttpDataSource.InvalidResponseCodeException) {
                    responseCode = ((HttpDataSource.InvalidResponseCodeException)ex).responseCode;
                }
                if (b2 || responseCode == 400 || responseCode == 503) {
                    this.g = SystemClock.elapsedRealtime();
                    this.m();
                    Util.j(DefaultHlsPlaylistTracker.B(this.p)).x(loadEventInfo, parsingLoadable.c, ex, true);
                    return Loader.f;
                }
            }
            final LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable.c), ex, n2);
            Loader.LoadErrorAction loadErrorAction;
            if (DefaultHlsPlaylistTracker.m(this.p, this.a, loadErrorInfo, false)) {
                a = DefaultHlsPlaylistTracker.C(this.p).a(loadErrorInfo);
                if (a != -9223372036854775807L) {
                    loadErrorAction = Loader.h(false, a);
                }
                else {
                    loadErrorAction = Loader.g;
                }
            }
            else {
                loadErrorAction = Loader.f;
            }
            final boolean b3 = true ^ loadErrorAction.c();
            DefaultHlsPlaylistTracker.B(this.p).x(loadEventInfo, parsingLoadable.c, ex, b3);
            if (b3) {
                DefaultHlsPlaylistTracker.C(this.p).d(parsingLoadable.a);
            }
            return loadErrorAction;
        }
        
        public void u() {
            this.b.l();
        }
        
        @Override
        public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
            this.q((ParsingLoadable<HlsPlaylist>)loadable, n, n2, b);
        }
    }
}
