// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash;

import java.util.regex.Matcher;
import java.text.ParseException;
import android.text.TextUtils;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.google.common.base.Charsets;
import java.io.InputStream;
import java.util.regex.Pattern;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.upstream.Allocator;
import android.os.Looper;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.util.Map;
import com.google.common.math.LongMath;
import java.math.RoundingMode;
import java.util.List;
import com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import android.os.SystemClock;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import y3.c;
import y3.b;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import android.os.Handler;
import java.io.IOException;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import android.util.SparseArray;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.BaseMediaSource;

public final class DashMediaSource extends BaseMediaSource
{
    private final long A;
    private final MediaSourceEventListener.EventDispatcher B;
    private final ParsingLoadable.Parser<? extends DashManifest> C;
    private final e D;
    private final Object E;
    private final SparseArray<DashMediaPeriod> F;
    private final Runnable G;
    private final Runnable H;
    private final PlayerEmsgHandler.PlayerEmsgCallback I;
    private final LoaderErrorThrower J;
    private DataSource K;
    private Loader L;
    private TransferListener M;
    private IOException N;
    private Handler O;
    private MediaItem.LiveConfiguration P;
    private Uri Q;
    private Uri R;
    private DashManifest S;
    private boolean T;
    private long U;
    private long V;
    private long W;
    private int X;
    private long Y;
    private int Z;
    private final MediaItem h;
    private final boolean i;
    private final DataSource.Factory j;
    private final DashChunkSource.Factory p;
    private final CompositeSequenceableLoaderFactory w;
    private final DrmSessionManager x;
    private final LoadErrorHandlingPolicy y;
    private final BaseUrlExclusionList z;
    
    static {
        ExoPlayerLibraryInfo.a("goog.exo.dash");
    }
    
    private DashMediaSource(final MediaItem h, final DashManifest s, final DataSource.Factory j, final ParsingLoadable.Parser<? extends DashManifest> c, final DashChunkSource.Factory p9, final CompositeSequenceableLoaderFactory w, final DrmSessionManager x, final LoadErrorHandlingPolicy y, final long a) {
        this.h = h;
        this.P = h.d;
        this.Q = Assertions.e(h.b).a;
        this.R = h.b.a;
        this.S = s;
        this.j = j;
        this.C = c;
        this.p = p9;
        this.x = x;
        this.y = y;
        this.A = a;
        this.w = w;
        this.z = new BaseUrlExclusionList();
        final boolean i = s != null;
        this.i = i;
        this.B = this.g0(null);
        this.E = new Object();
        this.F = (SparseArray<DashMediaPeriod>)new SparseArray();
        this.I = new c(null);
        this.Y = -9223372036854775807L;
        this.W = -9223372036854775807L;
        if (i) {
            Assertions.g(true ^ s.d);
            this.D = null;
            this.G = null;
            this.H = null;
            this.J = new LoaderErrorThrower.Dummy();
        }
        else {
            this.D = new e(null);
            this.J = new f();
            this.G = (Runnable)new y3.b(this);
            this.H = (Runnable)new y3.c(this);
        }
    }
    
    DashMediaSource(final MediaItem mediaItem, final DashManifest dashManifest, final DataSource.Factory factory, final ParsingLoadable.Parser parser, final DashChunkSource.Factory factory2, final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, final DrmSessionManager drmSessionManager, final LoadErrorHandlingPolicy loadErrorHandlingPolicy, final long n, final DashMediaSource$a initializationCallback) {
        this(mediaItem, dashManifest, factory, parser, factory2, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, n);
    }
    
    private static boolean A0(final Period period) {
        for (int i = 0; i < period.c.size(); ++i) {
            final DashSegmentIndex l = period.c.get(i).c.get(0).l();
            if (l == null || l.h()) {
                return true;
            }
        }
        return false;
    }
    
    private void B0() {
        this.M0(false);
    }
    
    private void C0() {
        SntpClient.j(this.L, (SntpClient.InitializationCallback)new SntpClient.InitializationCallback(this) {
            final DashMediaSource a;
            
            @Override
            public void a(final IOException ex) {
                DashMediaSource.s0(this.a, ex);
            }
            
            @Override
            public void b() {
                DashMediaSource.r0(this.a, SntpClient.h());
            }
        });
    }
    
    private void K0(final IOException ex) {
        Log.d("DashMediaSource", "Failed to resolve time offset.", ex);
        this.M0(true);
    }
    
    private void L0(final long w) {
        this.W = w;
        this.M0(true);
    }
    
    private void M0(final boolean b) {
        for (int i = 0; i < this.F.size(); ++i) {
            final int key = this.F.keyAt(i);
            if (key >= this.Z) {
                ((DashMediaPeriod)this.F.valueAt(i)).K(this.S, key - this.Z);
            }
        }
        final Period d = this.S.d(0);
        final int n = this.S.e() - 1;
        final Period d2 = this.S.d(n);
        final long g = this.S.g(n);
        final long c0 = Util.C0(Util.b0(this.W));
        final long w0 = w0(d, this.S.g(0), c0);
        final long v0 = v0(d2, g, c0);
        final boolean b2 = this.S.d && !A0(d2);
        long max = w0;
        if (b2) {
            final long f = this.S.f;
            max = w0;
            if (f != -9223372036854775807L) {
                max = Math.max(w0, v0 - Util.C0(f));
            }
        }
        final long n2 = v0 - max;
        final DashManifest s = this.S;
        long min;
        long n5;
        if (s.d) {
            Assertions.g(s.a != -9223372036854775807L);
            final long n3 = c0 - Util.C0(this.S.a) - max;
            this.T0(n3, n2);
            final long a = this.S.a;
            final long f2 = Util.f1(max);
            final long n4 = n3 - Util.C0(this.P.a);
            min = Math.min(5000000L, n2 / 2L);
            n5 = a + f2;
            if (n4 >= min) {
                min = n4;
            }
        }
        else {
            n5 = -9223372036854775807L;
            min = 0L;
        }
        final long c2 = Util.C0(d.b);
        final DashManifest s2 = this.S;
        final long a2 = s2.a;
        final long w2 = this.W;
        final int z = this.Z;
        final MediaItem h = this.h;
        MediaItem.LiveConfiguration p;
        if (s2.d) {
            p = this.P;
        }
        else {
            p = null;
        }
        this.n0(new b(a2, n5, w2, z, max - c2, n2, min, s2, h, p));
        if (!this.i) {
            this.O.removeCallbacks(this.H);
            if (b2) {
                this.O.postDelayed(this.H, x0(this.S, Util.b0(this.W)));
            }
            if (this.T) {
                this.S0();
            }
            else if (b) {
                final DashManifest s3 = this.S;
                if (s3.d) {
                    final long e = s3.e;
                    if (e != -9223372036854775807L) {
                        long n6 = e;
                        if (e == 0L) {
                            n6 = 5000L;
                        }
                        this.Q0(Math.max(0L, this.U + n6 - SystemClock.elapsedRealtime()));
                    }
                }
            }
        }
    }
    
    private void N0(final UtcTimingElement utcTimingElement) {
        final String a = utcTimingElement.a;
        if (!Util.c(a, "urn:mpeg:dash:utc:direct:2014") && !Util.c(a, "urn:mpeg:dash:utc:direct:2012")) {
            if (!Util.c(a, "urn:mpeg:dash:utc:http-iso:2014") && !Util.c(a, "urn:mpeg:dash:utc:http-iso:2012")) {
                if (!Util.c(a, "urn:mpeg:dash:utc:http-xsdate:2014") && !Util.c(a, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                    if (!Util.c(a, "urn:mpeg:dash:utc:ntp:2014") && !Util.c(a, "urn:mpeg:dash:utc:ntp:2012")) {
                        this.K0(new IOException("Unsupported UTC timing scheme"));
                    }
                    else {
                        this.C0();
                    }
                }
                else {
                    this.P0(utcTimingElement, new h(null));
                }
            }
            else {
                this.P0(utcTimingElement, new d());
            }
        }
        else {
            this.O0(utcTimingElement);
        }
    }
    
    private void O0(final UtcTimingElement utcTimingElement) {
        try {
            this.L0(Util.J0(utcTimingElement.b) - this.V);
        }
        catch (final ParserException ex) {
            this.K0(ex);
        }
    }
    
    private void P0(final UtcTimingElement utcTimingElement, final ParsingLoadable.Parser<Long> parser) {
        this.R0(new ParsingLoadable<Object>(this.K, Uri.parse(utcTimingElement.b), 5, (ParsingLoadable.Parser<?>)parser), (Loader.Callback<ParsingLoadable<Object>>)new g(null), 1);
    }
    
    private void Q0(final long n) {
        this.O.postDelayed(this.G, n);
    }
    
    private <T> void R0(final ParsingLoadable<T> parsingLoadable, final Loader.Callback<ParsingLoadable<T>> callback, final int n) {
        this.B.z(new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, this.L.n(parsingLoadable, callback, n)), parsingLoadable.c);
    }
    
    private void S0() {
        this.O.removeCallbacks(this.G);
        if (this.L.i()) {
            return;
        }
        if (this.L.j()) {
            this.T = true;
            return;
        }
        synchronized (this.E) {
            final Uri q = this.Q;
            monitorexit(this.E);
            this.T = false;
            this.R0(new ParsingLoadable<Object>(this.K, q, 4, (ParsingLoadable.Parser<?>)this.C), (Loader.Callback<ParsingLoadable<Object>>)this.D, this.y.b(4));
        }
    }
    
    private void T0(final long n, final long n2) {
        final long f1 = Util.f1(n);
        final long c = this.h.d.c;
        long n4 = 0L;
        Label_0089: {
            long n3 = 0L;
            Label_0036: {
                if (c == -9223372036854775807L) {
                    final ServiceDescriptionElement j = this.S.j;
                    if (j != null) {
                        final long c2 = j.c;
                        if (c2 != -9223372036854775807L) {
                            n3 = Math.min(f1, c2);
                            break Label_0036;
                        }
                    }
                    n4 = f1;
                    break Label_0089;
                }
                n3 = Math.min(f1, c);
            }
            n4 = n3;
        }
        long f2;
        final long n5 = f2 = Util.f1(n - n2);
        if (n5 < 0L) {
            f2 = n5;
            if (n4 > 0L) {
                f2 = 0L;
            }
        }
        final long c3 = this.S.c;
        long min = f2;
        if (c3 != -9223372036854775807L) {
            min = Math.min(f2 + c3, f1);
        }
        final long b = this.h.d.b;
        long n6;
        if (b != -9223372036854775807L) {
            n6 = Util.r(b, min, f1);
        }
        else {
            final ServiceDescriptionElement i = this.S.j;
            n6 = min;
            if (i != null) {
                final long b2 = i.b;
                n6 = min;
                if (b2 != -9223372036854775807L) {
                    n6 = Util.r(b2, min, f1);
                }
            }
        }
        long n7 = n4;
        if (n6 > n4) {
            n7 = n6;
        }
        long n8 = this.P.a;
        Label_0339: {
            if (n8 == -9223372036854775807L) {
                final DashManifest s = this.S;
                final ServiceDescriptionElement k = s.j;
                if (k != null) {
                    n8 = k.a;
                    if (n8 != -9223372036854775807L) {
                        break Label_0339;
                    }
                }
                n8 = s.g;
                if (n8 == -9223372036854775807L) {
                    n8 = this.A;
                }
            }
        }
        long n9 = n8;
        if (n8 < n6) {
            n9 = n6;
        }
        long r = n9;
        if (n9 > n7) {
            r = Util.r(Util.f1(n - Math.min(5000000L, n2 / 2L)), n6, n7);
        }
        final MediaItem.LiveConfiguration d = this.h.d;
        float n10 = d.d;
        if (n10 == -3.4028235E38f) {
            final ServiceDescriptionElement l = this.S.j;
            if (l != null) {
                n10 = l.d;
            }
            else {
                n10 = -3.4028235E38f;
            }
        }
        float n11 = d.e;
        if (n11 == -3.4028235E38f) {
            final ServiceDescriptionElement m = this.S.j;
            if (m != null) {
                n11 = m.e;
            }
            else {
                n11 = -3.4028235E38f;
            }
        }
        float n12 = n11;
        float n13 = n10;
        Label_0571: {
            if (n10 == -3.4028235E38f) {
                n12 = n11;
                n13 = n10;
                if (n11 == -3.4028235E38f) {
                    final ServiceDescriptionElement j2 = this.S.j;
                    if (j2 != null) {
                        n12 = n11;
                        n13 = n10;
                        if (j2.a != -9223372036854775807L) {
                            break Label_0571;
                        }
                    }
                    n12 = 1.0f;
                    n13 = 1.0f;
                }
            }
        }
        this.P = new MediaItem.LiveConfiguration.Builder().k(r).i(n6).g(n7).j(n13).h(n12).f();
    }
    
    public static void p0(final DashMediaSource dashMediaSource) {
        dashMediaSource.S0();
    }
    
    public static void q0(final DashMediaSource dashMediaSource) {
        dashMediaSource.B0();
    }
    
    static void r0(final DashMediaSource dashMediaSource, final long n) {
        dashMediaSource.L0(n);
    }
    
    static void s0(final DashMediaSource dashMediaSource, final IOException ex) {
        dashMediaSource.K0(ex);
    }
    
    static Loader t0(final DashMediaSource dashMediaSource) {
        return dashMediaSource.L;
    }
    
    static IOException u0(final DashMediaSource dashMediaSource) {
        return dashMediaSource.N;
    }
    
    private static long v0(final Period period, final long n, final long n2) {
        final long c0 = Util.C0(period.b);
        final boolean z0 = z0(period);
        long n3 = Long.MAX_VALUE;
        long min;
        for (int i = 0; i < period.c.size(); ++i, n3 = min) {
            final AdaptationSet set = period.c.get(i);
            final List<Representation> c2 = set.c;
            if (z0) {
                min = n3;
                if (set.b == 3) {
                    continue;
                }
            }
            if (c2.isEmpty()) {
                min = n3;
            }
            else {
                final DashSegmentIndex l = c2.get(0).l();
                if (l == null) {
                    return c0 + n;
                }
                final long j = l.j(n, n2);
                if (j == 0L) {
                    return c0;
                }
                final long n4 = l.b(n, n2) + j - 1L;
                min = Math.min(n3, l.a(n4, n) + (l.c(n4) + c0));
            }
        }
        return n3;
    }
    
    private static long w0(final Period period, final long n, final long n2) {
        final long c0 = Util.C0(period.b);
        final boolean z0 = z0(period);
        long n3 = c0;
        long max;
        for (int i = 0; i < period.c.size(); ++i, n3 = max) {
            final AdaptationSet set = period.c.get(i);
            final List<Representation> c2 = set.c;
            if (z0) {
                max = n3;
                if (set.b == 3) {
                    continue;
                }
            }
            if (c2.isEmpty()) {
                max = n3;
            }
            else {
                final DashSegmentIndex l = c2.get(0).l();
                if (l == null) {
                    return c0;
                }
                if (l.j(n, n2) == 0L) {
                    return c0;
                }
                max = Math.max(n3, l.c(l.b(n, n2)) + c0);
            }
        }
        return n3;
    }
    
    private static long x0(final DashManifest dashManifest, long n) {
        final int n2 = dashManifest.e() - 1;
        final Period d = dashManifest.d(n2);
        final long c0 = Util.C0(d.b);
        final long g = dashManifest.g(n2);
        final long c2 = Util.C0(n);
        final long c3 = Util.C0(dashManifest.a);
        long c4 = Util.C0(5000L);
        for (int i = 0; i < d.c.size(); ++i, c4 = n) {
            final List<Representation> c5 = d.c.get(i).c;
            if (c5.isEmpty()) {
                n = c4;
            }
            else {
                final DashSegmentIndex l = c5.get(0).l();
                n = c4;
                if (l != null) {
                    final long n3 = c3 + c0 + l.d(g, c2) - c2;
                    if (n3 >= c4 - 100000L) {
                        n = c4;
                        if (n3 <= c4) {
                            continue;
                        }
                        n = c4;
                        if (n3 >= c4 + 100000L) {
                            continue;
                        }
                    }
                    n = n3;
                }
            }
        }
        return LongMath.b(c4, 1000L, RoundingMode.CEILING);
    }
    
    private long y0() {
        return Math.min((this.X - 1) * 1000, 5000);
    }
    
    private static boolean z0(final Period period) {
        for (int i = 0; i < period.c.size(); ++i) {
            final int b = period.c.get(i).b;
            if (b == 1 || b == 2) {
                return true;
            }
        }
        return false;
    }
    
    void D0(final long y) {
        final long y2 = this.Y;
        if (y2 == -9223372036854775807L || y2 < y) {
            this.Y = y;
        }
    }
    
    void E0() {
        this.O.removeCallbacks(this.H);
        this.S0();
    }
    
    @Override
    public MediaItem F() {
        return this.h;
    }
    
    void F0(final ParsingLoadable<?> parsingLoadable, final long n, final long n2) {
        final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), n, n2, parsingLoadable.b());
        this.y.d(parsingLoadable.a);
        this.B.q(loadEventInfo, parsingLoadable.c);
    }
    
    void G0(final ParsingLoadable<DashManifest> parsingLoadable, final long v, final long n) {
        final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), v, n, parsingLoadable.b());
        this.y.d(parsingLoadable.a);
        this.B.t(loadEventInfo, parsingLoadable.c);
        final DashManifest s = parsingLoadable.e();
        final DashManifest s2 = this.S;
        final int n2 = 0;
        int e;
        if (s2 == null) {
            e = 0;
        }
        else {
            e = s2.e();
        }
        long b;
        int n3;
        for (b = s.d(0).b, n3 = 0; n3 < e && this.S.d(n3).b < b; ++n3) {}
        if (s.d) {
            boolean b2 = false;
            Label_0270: {
                if (e - n3 > s.e()) {
                    Log.i("DashMediaSource", "Loaded out of sync manifest");
                }
                else {
                    final long y = this.Y;
                    if (y == -9223372036854775807L || s.h * 1000L > y) {
                        b2 = false;
                        break Label_0270;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Loaded stale dynamic manifest: ");
                    sb.append(s.h);
                    sb.append(", ");
                    sb.append(this.Y);
                    Log.i("DashMediaSource", sb.toString());
                }
                b2 = true;
            }
            if (b2) {
                if (this.X++ < this.y.b(parsingLoadable.c)) {
                    this.Q0(this.y0());
                }
                else {
                    this.N = new DashManifestStaleException();
                }
                return;
            }
            this.X = 0;
        }
        this.S = s;
        this.T &= s.d;
        this.U = v - n;
        this.V = v;
        final Object e2 = this.E;
        monitorenter(e2);
        int n4 = n2;
        try {
            if (parsingLoadable.b.a == this.Q) {
                n4 = 1;
            }
            if (n4 != 0) {
                final Uri k = this.S.k;
                Uri f;
                if (k != null) {
                    f = k;
                }
                else {
                    f = parsingLoadable.f();
                }
                this.Q = f;
            }
            monitorexit(e2);
            if (e == 0) {
                final DashManifest s3 = this.S;
                if (s3.d) {
                    final UtcTimingElement i = s3.i;
                    if (i != null) {
                        this.N0(i);
                    }
                    else {
                        this.C0();
                    }
                }
                else {
                    this.M0(true);
                }
            }
            else {
                this.Z += n3;
                this.M0(true);
            }
        }
        finally {
            monitorexit(e2);
        }
    }
    
    Loader.LoadErrorAction H0(final ParsingLoadable<DashManifest> parsingLoadable, long a, final long n, final IOException ex, final int n2) {
        final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), a, n, parsingLoadable.b());
        a = this.y.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable.c), ex, n2));
        Loader.LoadErrorAction loadErrorAction;
        if (a == -9223372036854775807L) {
            loadErrorAction = Loader.g;
        }
        else {
            loadErrorAction = Loader.h(false, a);
        }
        final boolean b = loadErrorAction.c() ^ true;
        this.B.x(loadEventInfo, parsingLoadable.c, ex, b);
        if (b) {
            this.y.d(parsingLoadable.a);
        }
        return loadErrorAction;
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        final DashMediaPeriod dashMediaPeriod = (DashMediaPeriod)mediaPeriod;
        dashMediaPeriod.G();
        this.F.remove(dashMediaPeriod.a);
    }
    
    void I0(final ParsingLoadable<Long> parsingLoadable, final long n, final long n2) {
        final LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), n, n2, parsingLoadable.b());
        this.y.d(parsingLoadable.a);
        this.B.t(loadEventInfo, parsingLoadable.c);
        this.L0((long)parsingLoadable.e() - n);
    }
    
    Loader.LoadErrorAction J0(final ParsingLoadable<Long> parsingLoadable, final long n, final long n2, final IOException ex) {
        this.B.x(new LoadEventInfo(parsingLoadable.a, parsingLoadable.b, parsingLoadable.f(), parsingLoadable.d(), n, n2, parsingLoadable.b()), parsingLoadable.c, ex, true);
        this.y.d(parsingLoadable.a);
        this.K0(ex);
        return Loader.f;
    }
    
    @Override
    public void U() throws IOException {
        this.J.a();
    }
    
    @Override
    protected void m0(final TransferListener m) {
        this.M = m;
        this.x.prepare();
        this.x.b(Looper.myLooper(), this.k0());
        if (this.i) {
            this.M0(false);
        }
        else {
            this.K = this.j.createDataSource();
            this.L = new Loader("DashMediaSource");
            this.O = Util.w();
            this.S0();
        }
    }
    
    @Override
    protected void o0() {
        this.T = false;
        this.K = null;
        final Loader l = this.L;
        if (l != null) {
            l.l();
            this.L = null;
        }
        this.U = 0L;
        this.V = 0L;
        DashManifest s;
        if (this.i) {
            s = this.S;
        }
        else {
            s = null;
        }
        this.S = s;
        this.Q = this.R;
        this.N = null;
        final Handler o = this.O;
        if (o != null) {
            o.removeCallbacksAndMessages((Object)null);
            this.O = null;
        }
        this.W = -9223372036854775807L;
        this.X = 0;
        this.Y = -9223372036854775807L;
        this.Z = 0;
        this.F.clear();
        this.z.i();
        this.x.release();
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        final int n2 = (int)mediaPeriodId.a - this.Z;
        final DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(n2 + this.Z, this.S, this.z, n2, this.p, this.M, this.x, this.e0(mediaPeriodId), this.y, this.h0(mediaPeriodId, this.S.d(n2).b), this.W, this.J, allocator, this.w, this.I, this.k0());
        this.F.put(dashMediaPeriod.a, (Object)dashMediaPeriod);
        return dashMediaPeriod;
    }
    
    public static final class Factory implements MediaSourceFactory
    {
        private final DashChunkSource.Factory a;
        private final DataSource.Factory b;
        private DrmSessionManagerProvider c;
        private CompositeSequenceableLoaderFactory d;
        private LoadErrorHandlingPolicy e;
        private long f;
        private ParsingLoadable.Parser<? extends DashManifest> g;
        
        public Factory(final DashChunkSource.Factory factory, final DataSource.Factory b) {
            this.a = Assertions.e(factory);
            this.b = b;
            this.c = new DefaultDrmSessionManagerProvider();
            this.e = new DefaultLoadErrorHandlingPolicy();
            this.f = 30000L;
            this.d = new DefaultCompositeSequenceableLoaderFactory();
        }
        
        public Factory(final DataSource.Factory factory) {
            this(new DefaultDashChunkSource.Factory(factory), factory);
        }
        
        @Override
        public /* bridge */ MediaSource a(final MediaItem mediaItem) {
            return this.e(mediaItem);
        }
        
        @Override
        public int[] b() {
            return new int[] { 0 };
        }
        
        @Override
        public /* bridge */ MediaSource.Factory c(final DrmSessionManagerProvider drmSessionManagerProvider) {
            return this.f(drmSessionManagerProvider);
        }
        
        @Override
        public /* bridge */ MediaSource.Factory d(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this.g(loadErrorHandlingPolicy);
        }
        
        public DashMediaSource e(final MediaItem mediaItem) {
            Assertions.e(mediaItem.b);
            ParsingLoadable.Parser<? extends DashManifest> g;
            if ((g = this.g) == null) {
                g = new DashManifestParser();
            }
            final List<StreamKey> e = mediaItem.b.e;
            if (!e.isEmpty()) {
                g = new FilteringManifestParser<DashManifest>(g, e);
            }
            return new DashMediaSource(mediaItem, null, this.b, g, this.a, this.d, this.c.a(mediaItem), this.e, this.f, null);
        }
        
        public Factory f(final DrmSessionManagerProvider drmSessionManagerProvider) {
            this.c = Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
        
        public Factory g(final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.e = Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }
    
    private static final class b extends Timeline
    {
        private final long c;
        private final long d;
        private final long e;
        private final int f;
        private final long g;
        private final long h;
        private final long i;
        private final DashManifest j;
        private final MediaItem p;
        private final MediaItem.LiveConfiguration w;
        
        public b(final long c, final long d, final long e, final int f, final long g, final long h, final long i, final DashManifest j, final MediaItem p10, final MediaItem.LiveConfiguration w) {
            final boolean d2 = j.d;
            final boolean b = true;
            Assertions.g(d2 == (w != null) && b);
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
            this.p = p10;
            this.w = w;
        }
        
        private long y(long n) {
            final long i = this.i;
            if (!z(this.j)) {
                return i;
            }
            long n2 = i;
            if (n > 0L) {
                n = (n2 = i + n);
                if (n > this.h) {
                    return -9223372036854775807L;
                }
            }
            long n3;
            int n4;
            for (n3 = this.g + n2, n = this.j.g(0), n4 = 0; n4 < this.j.e() - 1 && n3 >= n; n3 -= n, ++n4, n = this.j.g(n4)) {}
            final com.google.android.exoplayer2.source.dash.manifest.Period d = this.j.d(n4);
            final int a = d.a(2);
            if (a == -1) {
                return n2;
            }
            final DashSegmentIndex l = d.c.get(a).c.get(0).l();
            long n5 = n2;
            if (l != null) {
                if (l.g(n) == 0L) {
                    n5 = n2;
                }
                else {
                    n5 = n2 + l.c(l.f(n3, n)) - n3;
                }
            }
            return n5;
        }
        
        private static boolean z(final DashManifest dashManifest) {
            return dashManifest.d && dashManifest.e != -9223372036854775807L && dashManifest.b == -9223372036854775807L;
        }
        
        @Override
        public int f(final Object o) {
            final boolean b = o instanceof Integer;
            final int n = -1;
            if (!b) {
                return -1;
            }
            final int n2 = (int)o - this.f;
            int n3 = n;
            if (n2 >= 0) {
                if (n2 >= this.m()) {
                    n3 = n;
                }
                else {
                    n3 = n2;
                }
            }
            return n3;
        }
        
        @Override
        public Period k(final int n, final Period period, final boolean b) {
            Assertions.c(n, 0, this.m());
            Object value = null;
            String a;
            if (b) {
                a = this.j.d(n).a;
            }
            else {
                a = null;
            }
            if (b) {
                value = this.f + n;
            }
            return period.w(a, value, 0, this.j.g(n), Util.C0(this.j.d(n).b - this.j.d(0).b) - this.g);
        }
        
        @Override
        public int m() {
            return this.j.e();
        }
        
        @Override
        public Object q(final int n) {
            Assertions.c(n, 0, this.m());
            return this.f + n;
        }
        
        @Override
        public Window s(final int n, final Window window, long y) {
            Assertions.c(n, 0, 1);
            y = this.y(y);
            final Object c = Window.C;
            final MediaItem p3 = this.p;
            final DashManifest j = this.j;
            return window.k(c, p3, j, this.c, this.d, this.e, true, z(j), this.w, y, this.h, 0, this.m() - 1, this.g);
        }
        
        @Override
        public int t() {
            return 1;
        }
    }
    
    private final class c implements PlayerEmsgCallback
    {
        final DashMediaSource a;
        
        private c(final DashMediaSource a) {
            this.a = a;
        }
        
        c(final DashMediaSource dashMediaSource, final DashMediaSource$a initializationCallback) {
            this(dashMediaSource);
        }
        
        @Override
        public void a(final long n) {
            this.a.D0(n);
        }
        
        @Override
        public void b() {
            this.a.E0();
        }
    }
    
    static final class d implements Parser<Long>
    {
        private static final Pattern a;
        
        static {
            a = Pattern.compile("(.+?)(Z|((\\+|-|\u2212)(\\d\\d)(:?(\\d\\d))?))");
        }
        
        @Override
        public /* bridge */ Object a(final Uri uri, final InputStream inputStream) throws IOException {
            return this.b(uri, inputStream);
        }
        
        public Long b(final Uri uri, final InputStream inputStream) throws IOException {
            final String line = new BufferedReader(new InputStreamReader(inputStream, Charsets.c)).readLine();
            try {
                final Matcher matcher = d.a.matcher(line);
                if (matcher.matches()) {
                    final String group = matcher.group(1);
                    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    final long time = simpleDateFormat.parse(group).getTime();
                    long n;
                    if ("Z".equals(matcher.group(2))) {
                        n = time;
                    }
                    else {
                        long n2;
                        if ("+".equals(matcher.group(4))) {
                            n2 = 1L;
                        }
                        else {
                            n2 = -1L;
                        }
                        final long long1 = Long.parseLong(matcher.group(5));
                        final String group2 = matcher.group(7);
                        long long2;
                        if (TextUtils.isEmpty((CharSequence)group2)) {
                            long2 = 0L;
                        }
                        else {
                            long2 = Long.parseLong(group2);
                        }
                        n = time - n2 * ((long1 * 60L + long2) * 60L * 1000L);
                    }
                    return n;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Couldn't parse timestamp: ");
                sb.append(line);
                throw ParserException.createForMalformedManifest(sb.toString(), null);
            }
            catch (final ParseException ex) {
                throw ParserException.createForMalformedManifest(null, ex);
            }
        }
    }
    
    private final class e implements Callback<ParsingLoadable<DashManifest>>
    {
        final DashMediaSource a;
        
        private e(final DashMediaSource a) {
            this.a = a;
        }
        
        e(final DashMediaSource dashMediaSource, final DashMediaSource$a initializationCallback) {
            this(dashMediaSource);
        }
        
        @Override
        public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
            this.b((ParsingLoadable<DashManifest>)loadable, n, n2);
        }
        
        @Override
        public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
            return this.c((ParsingLoadable<DashManifest>)loadable, n, n2, ex, n3);
        }
        
        public void a(final ParsingLoadable<DashManifest> parsingLoadable, final long n, final long n2, final boolean b) {
            this.a.F0(parsingLoadable, n, n2);
        }
        
        public void b(final ParsingLoadable<DashManifest> parsingLoadable, final long n, final long n2) {
            this.a.G0(parsingLoadable, n, n2);
        }
        
        public LoadErrorAction c(final ParsingLoadable<DashManifest> parsingLoadable, final long n, final long n2, final IOException ex, final int n3) {
            return this.a.H0(parsingLoadable, n, n2, ex, n3);
        }
        
        @Override
        public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
            this.a((ParsingLoadable<DashManifest>)loadable, n, n2, b);
        }
    }
    
    final class f implements LoaderErrorThrower
    {
        final DashMediaSource a;
        
        f(final DashMediaSource a) {
            this.a = a;
        }
        
        private void b() throws IOException {
            if (DashMediaSource.u0(this.a) == null) {
                return;
            }
            throw DashMediaSource.u0(this.a);
        }
        
        @Override
        public void a() throws IOException {
            DashMediaSource.t0(this.a).a();
            this.b();
        }
    }
    
    private final class g implements Callback<ParsingLoadable<Long>>
    {
        final DashMediaSource a;
        
        private g(final DashMediaSource a) {
            this.a = a;
        }
        
        g(final DashMediaSource dashMediaSource, final DashMediaSource$a initializationCallback) {
            this(dashMediaSource);
        }
        
        @Override
        public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
            this.b((ParsingLoadable<Long>)loadable, n, n2);
        }
        
        @Override
        public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
            return this.c((ParsingLoadable<Long>)loadable, n, n2, ex, n3);
        }
        
        public void a(final ParsingLoadable<Long> parsingLoadable, final long n, final long n2, final boolean b) {
            this.a.F0(parsingLoadable, n, n2);
        }
        
        public void b(final ParsingLoadable<Long> parsingLoadable, final long n, final long n2) {
            this.a.I0(parsingLoadable, n, n2);
        }
        
        public LoadErrorAction c(final ParsingLoadable<Long> parsingLoadable, final long n, final long n2, final IOException ex, final int n3) {
            return this.a.J0(parsingLoadable, n, n2, ex);
        }
        
        @Override
        public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
            this.a((ParsingLoadable<Long>)loadable, n, n2, b);
        }
    }
    
    private static final class h implements Parser<Long>
    {
        private h() {
        }
        
        h(final DashMediaSource$a initializationCallback) {
            this();
        }
        
        @Override
        public /* bridge */ Object a(final Uri uri, final InputStream inputStream) throws IOException {
            return this.b(uri, inputStream);
        }
        
        public Long b(final Uri uri, final InputStream inputStream) throws IOException {
            return Util.J0(new BufferedReader(new InputStreamReader(inputStream)).readLine());
        }
    }
}
