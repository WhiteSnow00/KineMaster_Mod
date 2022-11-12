// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DataSourceUtil;
import java.util.Arrays;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.SeekParameters;
import java.io.IOException;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;

final class y implements MediaPeriod, Loader.Callback<c>
{
    private final DataSpec a;
    private final DataSource.Factory b;
    private final TransferListener c;
    private final LoadErrorHandlingPolicy d;
    private final MediaSourceEventListener.EventDispatcher e;
    private final TrackGroupArray f;
    private final ArrayList<b> g;
    private final long h;
    final Loader i;
    final Format j;
    final boolean p;
    boolean w;
    byte[] x;
    int y;
    
    public y(final DataSpec a, final DataSource.Factory b, final TransferListener c, final Format j, final long h, final LoadErrorHandlingPolicy d, final MediaSourceEventListener.EventDispatcher e, final boolean p8) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.j = j;
        this.h = h;
        this.d = d;
        this.e = e;
        this.p = p8;
        this.f = new TrackGroupArray(new TrackGroup[] { new TrackGroup(new Format[] { j }) });
        this.g = new ArrayList<b>();
        this.i = new Loader("SingleSampleMediaPeriod");
    }
    
    static MediaSourceEventListener.EventDispatcher a(final y y) {
        return y.e;
    }
    
    @Override
    public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
        this.l((c)loadable, n, n2);
    }
    
    @Override
    public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
        return this.m((c)loadable, n, n2, ex, n3);
    }
    
    @Override
    public long b() {
        long n;
        if (!this.w && !this.i.j()) {
            n = 0L;
        }
        else {
            n = Long.MIN_VALUE;
        }
        return n;
    }
    
    @Override
    public long c(final long n, final SeekParameters seekParameters) {
        return n;
    }
    
    @Override
    public boolean d(long n) {
        if (!this.w && !this.i.j() && !this.i.i()) {
            final DataSource dataSource = this.b.createDataSource();
            final TransferListener c = this.c;
            if (c != null) {
                dataSource.e(c);
            }
            final c c2 = new c(this.a, dataSource);
            n = this.i.n(c2, (Loader.Callback<c>)this, this.d.b(1));
            this.e.A(new LoadEventInfo(c2.a, this.a, n), 1, -1, this.j, 0, null, 0L, this.h);
            return true;
        }
        return false;
    }
    
    public void e(final c c, final long n, final long n2, final boolean b) {
        final StatsDataSource b2 = com.google.android.exoplayer2.source.y.c.b(c);
        final LoadEventInfo loadEventInfo = new LoadEventInfo(c.a, c.b, b2.s(), b2.t(), n, n2, b2.j());
        this.d.d(c.a);
        this.e.r(loadEventInfo, 1, -1, null, 0, null, 0L, this.h);
    }
    
    @Override
    public long f() {
        long n;
        if (this.w) {
            n = Long.MIN_VALUE;
        }
        else {
            n = 0L;
        }
        return n;
    }
    
    @Override
    public void g(final long n) {
    }
    
    @Override
    public long h(final long n) {
        for (int i = 0; i < this.g.size(); ++i) {
            this.g.get(i).c();
        }
        return n;
    }
    
    @Override
    public long i() {
        return -9223372036854775807L;
    }
    
    @Override
    public boolean isLoading() {
        return this.i.j();
    }
    
    @Override
    public void j(final MediaPeriod.Callback callback, final long n) {
        callback.o(this);
    }
    
    @Override
    public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, final long n) {
        for (int i = 0; i < array.length; ++i) {
            if (array3[i] != null && (array[i] == null || !array2[i])) {
                this.g.remove(array3[i]);
                array3[i] = null;
            }
            if (array3[i] == null && array[i] != null) {
                final b b = new b(null);
                this.g.add(b);
                array3[i] = b;
                array4[i] = true;
            }
        }
        return n;
    }
    
    public void l(final c c, final long n, final long n2) {
        this.y = (int)com.google.android.exoplayer2.source.y.c.b(c).j();
        this.x = Assertions.e(com.google.android.exoplayer2.source.y.c.d(c));
        this.w = true;
        final StatsDataSource b = com.google.android.exoplayer2.source.y.c.b(c);
        final LoadEventInfo loadEventInfo = new LoadEventInfo(c.a, c.b, b.s(), b.t(), n, n2, this.y);
        this.d.d(c.a);
        this.e.u(loadEventInfo, 1, -1, this.j, 0, null, 0L, this.h);
    }
    
    public LoadErrorAction m(final c c, long a, final long n, final IOException ex, int n2) {
        final StatsDataSource b = com.google.android.exoplayer2.source.y.c.b(c);
        final LoadEventInfo loadEventInfo = new LoadEventInfo(c.a, c.b, b.s(), b.t(), a, n, b.j());
        a = this.d.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, this.j, 0, null, 0L, Util.f1(this.h)), ex, n2));
        final long n3 = lcmp(a, -9223372036854775807L);
        if (n3 != 0 && n2 < this.d.b(1)) {
            n2 = 0;
        }
        else {
            n2 = 1;
        }
        Loader.LoadErrorAction loadErrorAction;
        if (this.p && n2 != 0) {
            Log.j("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", ex);
            this.w = true;
            loadErrorAction = Loader.f;
        }
        else if (n3 != 0) {
            loadErrorAction = Loader.h(false, a);
        }
        else {
            loadErrorAction = Loader.g;
        }
        final boolean b2 = loadErrorAction.c() ^ true;
        this.e.w(loadEventInfo, 1, -1, this.j, 0, null, 0L, this.h, ex, b2);
        if (b2) {
            this.d.d(c.a);
        }
        return loadErrorAction;
    }
    
    @Override
    public void n() {
    }
    
    public void o() {
        this.i.l();
    }
    
    @Override
    public TrackGroupArray p() {
        return this.f;
    }
    
    @Override
    public void q(final long n, final boolean b) {
    }
    
    @Override
    public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
        this.e((c)loadable, n, n2, b);
    }
    
    private final class b implements SampleStream
    {
        private int a;
        private boolean b;
        final y c;
        
        private b(final y c) {
            this.c = c;
        }
        
        b(final y y, final y$a object) {
            this(y);
        }
        
        private void b() {
            if (!this.b) {
                com.google.android.exoplayer2.source.y.a(this.c).i(MimeTypes.k(this.c.j.w), this.c.j, 0, null, 0L);
                this.b = true;
            }
        }
        
        @Override
        public void a() throws IOException {
            final y c = this.c;
            if (!c.p) {
                c.i.a();
            }
        }
        
        public void c() {
            if (this.a == 2) {
                this.a = 1;
            }
        }
        
        @Override
        public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
            this.b();
            final y c = this.c;
            final boolean w = c.w;
            if (w && c.x == null) {
                this.a = 2;
            }
            final int a = this.a;
            if (a == 2) {
                decoderInputBuffer.g(4);
                return -4;
            }
            if ((n & 0x2) != 0x0 || a == 0) {
                formatHolder.b = c.j;
                this.a = 1;
                return -5;
            }
            if (!w) {
                return -3;
            }
            Assertions.e(c.x);
            decoderInputBuffer.g(1);
            decoderInputBuffer.f = 0L;
            if ((n & 0x4) == 0x0) {
                decoderInputBuffer.s(this.c.y);
                final ByteBuffer d = decoderInputBuffer.d;
                final y c2 = this.c;
                d.put(c2.x, 0, c2.y);
            }
            if ((n & 0x1) == 0x0) {
                this.a = 2;
            }
            return -4;
        }
        
        @Override
        public boolean isReady() {
            return this.c.w;
        }
        
        @Override
        public int l(final long n) {
            this.b();
            if (n > 0L && this.a != 2) {
                this.a = 2;
                return 1;
            }
            return 0;
        }
    }
    
    static final class c implements Loadable
    {
        public final long a;
        public final DataSpec b;
        private final StatsDataSource c;
        private byte[] d;
        
        public c(final DataSpec b, final DataSource dataSource) {
            this.a = LoadEventInfo.a();
            this.b = b;
            this.c = new StatsDataSource(dataSource);
        }
        
        static StatsDataSource b(final c c) {
            return c.c;
        }
        
        static byte[] d(final c c) {
            return c.d;
        }
        
        @Override
        public void a() throws IOException {
            this.c.u();
            try {
                this.c.b(this.b);
                int n;
                StatsDataSource c;
                byte[] d2;
                for (int i = 0; i != -1; i = c.read(d2, n, d2.length - n)) {
                    n = (int)this.c.j();
                    final byte[] d = this.d;
                    if (d == null) {
                        this.d = new byte[1024];
                    }
                    else if (n == d.length) {
                        this.d = Arrays.copyOf(d, d.length * 2);
                    }
                    c = this.c;
                    d2 = this.d;
                }
            }
            finally {
                DataSourceUtil.a(this.c);
            }
        }
        
        @Override
        public void c() {
        }
    }
}
