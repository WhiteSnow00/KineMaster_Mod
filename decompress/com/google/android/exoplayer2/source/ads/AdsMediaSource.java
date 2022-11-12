// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.util.Util;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.LoadEventInfo;
import java.util.ArrayList;
import java.util.List;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.io.IOException;
import java.util.Arrays;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import android.os.Looper;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.Timeline;
import android.os.Handler;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.CompositeMediaSource;

public final class AdsMediaSource extends CompositeMediaSource<MediaPeriodId>
{
    private static final MediaPeriodId H;
    private final Object A;
    private final Handler B;
    private final Timeline.Period C;
    private c D;
    private Timeline E;
    private AdPlaybackState F;
    private a[][] G;
    private final MediaSource p;
    private final Factory w;
    private final AdsLoader x;
    private final AdViewProvider y;
    private final DataSpec z;
    
    static {
        H = new MediaSource.MediaPeriodId(new Object());
    }
    
    public AdsMediaSource(final MediaSource p6, final DataSpec z, final Object a, final Factory w, final AdsLoader x, final AdViewProvider y) {
        this.p = p6;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.A = a;
        this.B = new Handler(Looper.getMainLooper());
        this.C = new Timeline.Period();
        this.G = new a[0][];
        x.e(w.b());
    }
    
    public static void A0(final AdsMediaSource adsMediaSource, final c c) {
        adsMediaSource.K0(c);
    }
    
    static Handler B0(final AdsMediaSource adsMediaSource) {
        return adsMediaSource.B;
    }
    
    static MediaSourceEventListener.EventDispatcher C0(final AdsMediaSource adsMediaSource, final MediaPeriodId mediaPeriodId) {
        return adsMediaSource.g0(mediaPeriodId);
    }
    
    static AdsLoader D0(final AdsMediaSource adsMediaSource) {
        return adsMediaSource.x;
    }
    
    static void E0(final AdsMediaSource adsMediaSource, final Object o, final MediaSource mediaSource) {
        adsMediaSource.x0((MediaPeriodId)o, mediaSource);
    }
    
    static Timeline.Period F0(final AdsMediaSource adsMediaSource) {
        return adsMediaSource.C;
    }
    
    static void G0(final AdsMediaSource adsMediaSource, final Object o) {
        adsMediaSource.y0((MediaPeriodId)o);
    }
    
    private long[][] H0() {
        final long[][] array = new long[this.G.length][];
        int n = 0;
        while (true) {
            final a[][] g = this.G;
            if (n >= g.length) {
                break;
            }
            array[n] = new long[g[n].length];
            int n2 = 0;
            while (true) {
                final a[][] g2 = this.G;
                if (n2 >= g2[n].length) {
                    break;
                }
                final a a = g2[n][n2];
                final long[] array2 = array[n];
                long b;
                if (a == null) {
                    b = -9223372036854775807L;
                }
                else {
                    b = a.b();
                }
                array2[n2] = b;
                ++n2;
            }
            ++n;
        }
        return array;
    }
    
    private void J0(final c c) {
        this.x.b(this, this.z, this.A, this.y, (AdsLoader.EventListener)c);
    }
    
    private void K0(final c c) {
        this.x.d(this, (AdsLoader.EventListener)c);
    }
    
    private void L0() {
        final AdPlaybackState f = this.F;
        if (f == null) {
            return;
        }
        for (int i = 0; i < this.G.length; ++i) {
            int n = 0;
            while (true) {
                final a[][] g = this.G;
                if (n >= g[i].length) {
                    break;
                }
                final a a = g[i][n];
                final AdPlaybackState.AdGroup c = f.c(i);
                if (a != null && !a.d()) {
                    final Uri[] c2 = c.c;
                    if (n < c2.length) {
                        final Uri uri = c2[n];
                        if (uri != null) {
                            final MediaItem.Builder j = new MediaItem.Builder().i(uri);
                            final MediaItem.LocalConfiguration b = this.p.F().b;
                            if (b != null) {
                                j.c(b.c);
                            }
                            a.e(this.w.a(j.a()), uri);
                        }
                    }
                }
                ++n;
            }
        }
    }
    
    private void M0() {
        final Timeline e = this.E;
        final AdPlaybackState f = this.F;
        if (f != null && e != null) {
            if (f.b == 0) {
                this.n0(e);
            }
            else {
                this.F = f.h(this.H0());
                this.n0(new SinglePeriodAdTimeline(e, this.F));
            }
        }
    }
    
    public static void z0(final AdsMediaSource adsMediaSource, final c c) {
        adsMediaSource.J0(c);
    }
    
    @Override
    public MediaItem F() {
        return this.p.F();
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
        final MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod)mediaPeriod;
        final MediaPeriodId a = maskingMediaPeriod.a;
        if (a.b()) {
            final a a2 = Assertions.e(this.G[a.b][a.c]);
            a2.h(maskingMediaPeriod);
            if (a2.f()) {
                a2.g();
                this.G[a.b][a.c] = null;
            }
        }
        else {
            maskingMediaPeriod.v();
        }
    }
    
    protected MediaPeriodId I0(MediaPeriodId mediaPeriodId, final MediaPeriodId mediaPeriodId2) {
        if (!mediaPeriodId.b()) {
            mediaPeriodId = mediaPeriodId2;
        }
        return mediaPeriodId;
    }
    
    protected void N0(final MediaPeriodId mediaPeriodId, final MediaSource mediaSource, final Timeline e) {
        if (mediaPeriodId.b()) {
            Assertions.e(this.G[mediaPeriodId.b][mediaPeriodId.c]).c(e);
        }
        else {
            final int m = e.m();
            boolean b = true;
            if (m != 1) {
                b = false;
            }
            Assertions.a(b);
            this.E = e;
        }
        this.M0();
    }
    
    @Override
    protected void m0(final TransferListener transferListener) {
        super.m0(transferListener);
        final c d = new c();
        this.D = d;
        this.x0(AdsMediaSource.H, this.p);
        this.B.post((Runnable)new com.google.android.exoplayer2.source.ads.a(this, d));
    }
    
    @Override
    protected void o0() {
        super.o0();
        final c c = Assertions.e(this.D);
        this.D = null;
        c.a();
        this.E = null;
        this.F = null;
        this.G = new a[0][];
        this.B.post((Runnable)new com.google.android.exoplayer2.source.ads.b(this, c));
    }
    
    @Override
    protected /* bridge */ MediaPeriodId s0(final Object o, final MediaPeriodId mediaPeriodId) {
        return this.I0((MediaPeriodId)o, mediaPeriodId);
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        if (Assertions.e(this.F).b > 0 && mediaPeriodId.b()) {
            final int b = mediaPeriodId.b;
            final int c = mediaPeriodId.c;
            final a[][] g = this.G;
            if (g[b].length <= c) {
                g[b] = Arrays.copyOf(g[b], c + 1);
            }
            a a;
            if ((a = this.G[b][c]) == null) {
                a = new a(mediaPeriodId);
                this.G[b][c] = a;
                this.L0();
            }
            return a.a(mediaPeriodId, allocator, n);
        }
        final MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, n);
        maskingMediaPeriod.w(this.p);
        maskingMediaPeriod.a(mediaPeriodId);
        return maskingMediaPeriod;
    }
    
    @Override
    protected /* bridge */ void w0(final Object o, final MediaSource mediaSource, final Timeline timeline) {
        this.N0((MediaPeriodId)o, mediaSource, timeline);
    }
    
    public static final class AdLoadException extends IOException
    {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;
        
        private AdLoadException(final int type, final Exception ex) {
            super(ex);
            this.type = type;
        }
        
        public static AdLoadException createForAd(final Exception ex) {
            return new AdLoadException(0, ex);
        }
        
        public static AdLoadException createForAdGroup(final Exception ex, final int n) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to load ad group ");
            sb.append(n);
            return new AdLoadException(1, new IOException(sb.toString(), ex));
        }
        
        public static AdLoadException createForAllAds(final Exception ex) {
            return new AdLoadException(2, ex);
        }
        
        public static AdLoadException createForUnexpected(final RuntimeException ex) {
            return new AdLoadException(3, ex);
        }
        
        public RuntimeException getRuntimeExceptionForUnexpected() {
            Assertions.g(this.type == 3);
            return Assertions.e(this.getCause());
        }
        
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        @Target({ ElementType.TYPE_USE })
        public @interface Type {
        }
    }
    
    private final class a
    {
        private final MediaPeriodId a;
        private final List<MaskingMediaPeriod> b;
        private Uri c;
        private MediaSource d;
        private Timeline e;
        final AdsMediaSource f;
        
        public a(final AdsMediaSource f, final MediaPeriodId a) {
            this.f = f;
            this.a = a;
            this.b = new ArrayList<MaskingMediaPeriod>();
        }
        
        public MediaPeriod a(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
            final MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, n);
            this.b.add(maskingMediaPeriod);
            final MediaSource d = this.d;
            if (d != null) {
                maskingMediaPeriod.w(d);
                maskingMediaPeriod.x((MaskingMediaPeriod.PrepareListener)this.f.new b(Assertions.e(this.c)));
            }
            final Timeline e = this.e;
            if (e != null) {
                maskingMediaPeriod.a(new MediaSource.MediaPeriodId(e.q(0), mediaPeriodId.d));
            }
            return maskingMediaPeriod;
        }
        
        public long b() {
            final Timeline e = this.e;
            long n;
            if (e == null) {
                n = -9223372036854775807L;
            }
            else {
                n = e.j(0, AdsMediaSource.F0(this.f)).n();
            }
            return n;
        }
        
        public void c(final Timeline e) {
            final int m = e.m();
            int i = 0;
            boolean b = true;
            if (m != 1) {
                b = false;
            }
            Assertions.a(b);
            if (this.e == null) {
                final Object q = e.q(0);
                while (i < this.b.size()) {
                    final MaskingMediaPeriod maskingMediaPeriod = this.b.get(i);
                    maskingMediaPeriod.a(new MediaSource.MediaPeriodId(q, maskingMediaPeriod.a.d));
                    ++i;
                }
            }
            this.e = e;
        }
        
        public boolean d() {
            return this.d != null;
        }
        
        public void e(final MediaSource d, final Uri c) {
            this.d = d;
            this.c = c;
            for (int i = 0; i < this.b.size(); ++i) {
                final MaskingMediaPeriod maskingMediaPeriod = this.b.get(i);
                maskingMediaPeriod.w(d);
                maskingMediaPeriod.x((MaskingMediaPeriod.PrepareListener)this.f.new b(c));
            }
            AdsMediaSource.E0(this.f, this.a, d);
        }
        
        public boolean f() {
            return this.b.isEmpty();
        }
        
        public void g() {
            if (this.d()) {
                AdsMediaSource.G0(this.f, this.a);
            }
        }
        
        public void h(final MaskingMediaPeriod maskingMediaPeriod) {
            this.b.remove(maskingMediaPeriod);
            maskingMediaPeriod.v();
        }
    }
    
    private final class b implements PrepareListener
    {
        private final Uri a;
        final AdsMediaSource b;
        
        public b(final AdsMediaSource b, final Uri a) {
            this.b = b;
            this.a = a;
        }
        
        public static void c(final b b, final MediaPeriodId mediaPeriodId, final IOException ex) {
            b.f(mediaPeriodId, ex);
        }
        
        public static void d(final b b, final MediaPeriodId mediaPeriodId) {
            b.e(mediaPeriodId);
        }
        
        private void e(final MediaPeriodId mediaPeriodId) {
            AdsMediaSource.D0(this.b).a(this.b, mediaPeriodId.b, mediaPeriodId.c);
        }
        
        private void f(final MediaPeriodId mediaPeriodId, final IOException ex) {
            AdsMediaSource.D0(this.b).c(this.b, mediaPeriodId.b, mediaPeriodId.c, ex);
        }
        
        @Override
        public void a(final MediaPeriodId mediaPeriodId) {
            AdsMediaSource.B0(this.b).post((Runnable)new com.google.android.exoplayer2.source.ads.c(this, mediaPeriodId));
        }
        
        @Override
        public void b(final MediaPeriodId mediaPeriodId, final IOException ex) {
            AdsMediaSource.C0(this.b, mediaPeriodId).x(new LoadEventInfo(LoadEventInfo.a(), new DataSpec(this.a), SystemClock.elapsedRealtime()), 6, AdLoadException.createForAd(ex), true);
            AdsMediaSource.B0(this.b).post((Runnable)new d(this, mediaPeriodId, ex));
        }
    }
    
    private final class c implements EventListener
    {
        private final Handler a;
        private volatile boolean b;
        final AdsMediaSource c;
        
        public c(final AdsMediaSource c) {
            this.c = c;
            this.a = Util.w();
        }
        
        public void a() {
            this.b = true;
            this.a.removeCallbacksAndMessages((Object)null);
        }
    }
}
