// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.util.Collection;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.util.Util;
import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.util.ArrayList;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.Format;
import java.util.List;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import java.io.IOException;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;

public class DefaultDashChunkSource implements DashChunkSource
{
    private final LoaderErrorThrower a;
    private final BaseUrlExclusionList b;
    private final int[] c;
    private final int d;
    private final DataSource e;
    private final long f;
    private final int g;
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler h;
    protected final RepresentationHolder[] i;
    private ExoTrackSelection j;
    private DashManifest k;
    private int l;
    private IOException m;
    private boolean n;
    
    public DefaultDashChunkSource(final ChunkExtractor.Factory factory, final LoaderErrorThrower a, final DashManifest k, final BaseUrlExclusionList b, int i, final int[] c, final ExoTrackSelection j, final int d, final DataSource e, long g, final int g2, final boolean b2, final List<Format> list, final PlayerEmsgHandler.PlayerTrackEmsgHandler h, final PlayerId playerId) {
        this.a = a;
        this.k = k;
        this.b = b;
        this.c = c;
        this.j = j;
        this.d = d;
        this.e = e;
        this.l = i;
        this.f = g;
        this.g = g2;
        this.h = h;
        g = k.g(i);
        final ArrayList<Representation> n = this.n();
        this.i = new RepresentationHolder[j.length()];
        Representation representation;
        BaseUrl l;
        RepresentationHolder[] m;
        for (i = 0; i < this.i.length; ++i) {
            representation = n.get(j.g(i));
            l = b.j((List<BaseUrl>)representation.c);
            m = this.i;
            if (l == null) {
                l = ((List<BaseUrl>)representation.c).get(0);
            }
            m[i] = new RepresentationHolder(g, representation, l, factory.a(d, representation.b, b2, list, h, playerId), 0L, representation.l());
        }
    }
    
    private LoadErrorHandlingPolicy.FallbackOptions k(final ExoTrackSelection exoTrackSelection, final List<BaseUrl> list) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final int length = exoTrackSelection.length();
        int i = 0;
        int n = 0;
        while (i < length) {
            int n2 = n;
            if (exoTrackSelection.c(i, elapsedRealtime)) {
                n2 = n + 1;
            }
            ++i;
            n = n2;
        }
        final int f = BaseUrlExclusionList.f(list);
        return new LoadErrorHandlingPolicy.FallbackOptions(f, f - this.b.g(list), length, n);
    }
    
    private long l(final long n, final long n2) {
        if (!this.k.d) {
            return -9223372036854775807L;
        }
        return Math.max(0L, Math.min(this.m(n), this.i[0].i(this.i[0].g(n))) - n2);
    }
    
    private long m(long n) {
        final DashManifest k = this.k;
        final long a = k.a;
        final long n2 = -9223372036854775807L;
        if (a == -9223372036854775807L) {
            n = n2;
        }
        else {
            n -= Util.C0(a + k.d(this.l).b);
        }
        return n;
    }
    
    private ArrayList<Representation> n() {
        final List<AdaptationSet> c = this.k.d(this.l).c;
        final ArrayList list = new ArrayList();
        final int[] c2 = this.c;
        for (int length = c2.length, i = 0; i < length; ++i) {
            list.addAll(c.get(c2[i]).c);
        }
        return list;
    }
    
    private long o(final RepresentationHolder representationHolder, final MediaChunk mediaChunk, long n, final long n2, final long n3) {
        if (mediaChunk != null) {
            n = mediaChunk.g();
        }
        else {
            n = Util.r(representationHolder.j(n), n2, n3);
        }
        return n;
    }
    
    private RepresentationHolder r(final int n) {
        final RepresentationHolder representationHolder = this.i[n];
        final BaseUrl j = this.b.j((List<BaseUrl>)representationHolder.b.c);
        RepresentationHolder d = representationHolder;
        if (j != null) {
            d = representationHolder;
            if (!j.equals(representationHolder.c)) {
                d = representationHolder.d(j);
                this.i[n] = d;
            }
        }
        return d;
    }
    
    @Override
    public void a() throws IOException {
        final IOException m = this.m;
        if (m == null) {
            this.a.a();
            return;
        }
        throw m;
    }
    
    @Override
    public void b(final ExoTrackSelection j) {
        this.j = j;
    }
    
    @Override
    public long c(final long n, final SeekParameters seekParameters) {
        for (final RepresentationHolder representationHolder : this.i) {
            if (representationHolder.d != null) {
                final long k = representationHolder.j(n);
                final long l = representationHolder.k(k);
                final long h = representationHolder.h();
                long m;
                if (l < n && (h == -1L || k < representationHolder.f() + h - 1L)) {
                    m = representationHolder.k(k + 1L);
                }
                else {
                    m = l;
                }
                return seekParameters.a(n, l, m);
            }
        }
        return n;
    }
    
    @Override
    public boolean d(final long n, final Chunk chunk, final List<? extends MediaChunk> list) {
        return this.m == null && this.j.d(n, chunk, list);
    }
    
    @Override
    public void f(final Chunk chunk) {
        if (chunk instanceof InitializationChunk) {
            final int p = this.j.p(chunk.d);
            final RepresentationHolder representationHolder = this.i[p];
            if (representationHolder.d == null) {
                final ChunkIndex c = representationHolder.a.c();
                if (c != null) {
                    this.i[p] = representationHolder.c(new DashWrappingSegmentIndex(c, representationHolder.b.d));
                }
            }
        }
        final PlayerEmsgHandler.PlayerTrackEmsgHandler h = this.h;
        if (h != null) {
            h.i(chunk);
        }
    }
    
    @Override
    public boolean g(final Chunk chunk, final boolean b, final LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, final LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final PlayerEmsgHandler.PlayerTrackEmsgHandler h = this.h;
        if (h != null && h.j(chunk)) {
            return true;
        }
        if (!this.k.d && chunk instanceof MediaChunk) {
            final IOException c = loadErrorInfo.c;
            if (c instanceof HttpDataSource.InvalidResponseCodeException && ((HttpDataSource.InvalidResponseCodeException)c).responseCode == 404) {
                final RepresentationHolder representationHolder = this.i[this.j.p(chunk.d)];
                final long h2 = representationHolder.h();
                if (h2 != -1L && h2 != 0L && ((MediaChunk)chunk).g() > representationHolder.f() + h2 - 1L) {
                    return this.n = true;
                }
            }
        }
        final RepresentationHolder representationHolder2 = this.i[this.j.p(chunk.d)];
        final BaseUrl j = this.b.j((List<BaseUrl>)representationHolder2.b.c);
        if (j != null && !representationHolder2.c.equals(j)) {
            return true;
        }
        final LoadErrorHandlingPolicy.FallbackOptions k = this.k(this.j, (List<BaseUrl>)representationHolder2.b.c);
        if (!k.a(2) && !k.a(1)) {
            return false;
        }
        final LoadErrorHandlingPolicy.FallbackSelection c2 = loadErrorHandlingPolicy.c(k, loadErrorInfo);
        boolean b3 = b2;
        if (c2 != null) {
            if (!k.a(c2.a)) {
                b3 = b2;
            }
            else {
                final int a = c2.a;
                if (a == 2) {
                    final ExoTrackSelection i = this.j;
                    b3 = i.b(i.p(chunk.d), c2.b);
                }
                else {
                    b3 = b2;
                    if (a == 1) {
                        this.b.e(representationHolder2.c, c2.b);
                        b3 = true;
                    }
                }
            }
        }
        return b3;
    }
    
    @Override
    public void h(final DashManifest k, int i) {
        try {
            this.k = k;
            this.l = i;
            final long g = k.g(i);
            final ArrayList<Representation> n = this.n();
            Representation representation;
            RepresentationHolder[] j;
            for (i = 0; i < this.i.length; ++i) {
                representation = n.get(this.j.g(i));
                j = this.i;
                j[i] = j[i].b(g, representation);
            }
        }
        catch (final BehindLiveWindowException m) {
            this.m = m;
        }
    }
    
    @Override
    public int i(final long n, final List<? extends MediaChunk> list) {
        if (this.m == null && this.j.length() >= 2) {
            return this.j.o(n, list);
        }
        return list.size();
    }
    
    @Override
    public void j(long n, final long n2, final List<? extends MediaChunk> list, final ChunkHolder chunkHolder) {
        if (this.m != null) {
            return;
        }
        final long n3 = n2 - n;
        final long c0 = Util.C0(this.k.a);
        final long c2 = Util.C0(this.k.d(this.l).b);
        final PlayerEmsgHandler.PlayerTrackEmsgHandler h = this.h;
        if (h != null && h.h(c0 + c2 + n2)) {
            return;
        }
        final long c3 = Util.C0(Util.b0(this.f));
        final long m = this.m(c3);
        MediaChunk mediaChunk;
        if (list.isEmpty()) {
            mediaChunk = null;
        }
        else {
            mediaChunk = list.get(list.size() - 1);
        }
        final int length = this.j.length();
        final MediaChunkIterator[] array = new MediaChunkIterator[length];
        for (int i = 0; i < length; ++i) {
            final RepresentationHolder representationHolder = this.i[i];
            if (representationHolder.d == null) {
                array[i] = MediaChunkIterator.a;
            }
            else {
                final long e = representationHolder.e(c3);
                final long g = representationHolder.g(c3);
                final long o = this.o(representationHolder, mediaChunk, n2, e, g);
                if (o < e) {
                    array[i] = MediaChunkIterator.a;
                }
                else {
                    array[i] = new RepresentationSegmentIterator(this.r(i), o, g, m);
                }
            }
        }
        this.j.q(n, n3, this.l(c3, n), list, array);
        final RepresentationHolder r = this.r(this.j.a());
        final ChunkExtractor a = r.a;
        if (a != null) {
            final Representation b = r.b;
            RangedUri n4;
            if (a.d() == null) {
                n4 = b.n();
            }
            else {
                n4 = null;
            }
            RangedUri j;
            if (r.d == null) {
                j = b.m();
            }
            else {
                j = null;
            }
            if (n4 != null || j != null) {
                chunkHolder.a = this.p(r, this.e, this.j.s(), this.j.t(), this.j.i(), n4, j);
                return;
            }
        }
        final long a2 = RepresentationHolder.a(r);
        n = -9223372036854775807L;
        final long n5 = lcmp(a2, -9223372036854775807L);
        final boolean b2 = n5 != 0;
        if (r.h() == 0L) {
            chunkHolder.b = b2;
            return;
        }
        final long e2 = r.e(c3);
        final long g2 = r.g(c3);
        final long o2 = this.o(r, mediaChunk, n2, e2, g2);
        if (o2 < e2) {
            this.m = new BehindLiveWindowException();
            return;
        }
        final long n6 = lcmp(o2, g2);
        if (n6 > 0 || (this.n && n6 >= 0)) {
            chunkHolder.b = b2;
            return;
        }
        if (b2 && r.k(o2) >= a2) {
            chunkHolder.b = true;
            return;
        }
        int n8;
        int n7 = n8 = (int)Math.min(this.g, g2 - o2 + 1L);
        if (n5 != 0) {
            while ((n8 = n7) > 1) {
                n8 = n7;
                if (r.k(n7 + o2 - 1L) < a2) {
                    break;
                }
                --n7;
            }
        }
        if (list.isEmpty()) {
            n = n2;
        }
        chunkHolder.a = this.q(r, this.e, this.d, this.j.s(), this.j.t(), this.j.i(), o2, n8, n, m);
    }
    
    protected Chunk p(final RepresentationHolder representationHolder, final DataSource dataSource, final Format format, final int n, final Object o, RangedUri rangedUri, RangedUri a) {
        final Representation b = representationHolder.b;
        if (rangedUri != null) {
            a = rangedUri.a(a, representationHolder.c.a);
            if (a != null) {
                rangedUri = a;
            }
        }
        else {
            rangedUri = a;
        }
        return new InitializationChunk(dataSource, DashUtil.a(b, representationHolder.c.a, rangedUri, 0), format, n, o, representationHolder.a);
    }
    
    protected Chunk q(final RepresentationHolder representationHolder, final DataSource dataSource, int n, final Format format, final int n2, final Object o, final long n3, int n4, long i, final long n5) {
        final Representation b = representationHolder.b;
        final long k = representationHolder.k(n3);
        RangedUri l = representationHolder.l(n3);
        final ChunkExtractor a = representationHolder.a;
        final int n6 = 0;
        final int n7 = 0;
        if (a == null) {
            i = representationHolder.i(n3);
            if (representationHolder.m(n3, n5)) {
                n4 = n7;
            }
            else {
                n4 = 8;
            }
            return new SingleSampleMediaChunk(dataSource, DashUtil.a(b, representationHolder.c.a, l, n4), format, n2, o, k, i, n3, n, format);
        }
        int j = 1;
        n = 1;
        while (j < n4) {
            final RangedUri a2 = l.a(representationHolder.l(j + n3), representationHolder.c.a);
            if (a2 == null) {
                break;
            }
            ++n;
            ++j;
            l = a2;
        }
        final long n8 = n + n3 - 1L;
        final long m = representationHolder.i(n8);
        long a3 = RepresentationHolder.a(representationHolder);
        if (a3 == -9223372036854775807L || a3 > m) {
            a3 = -9223372036854775807L;
        }
        if (representationHolder.m(n8, n5)) {
            n4 = n6;
        }
        else {
            n4 = 8;
        }
        return new ContainerMediaChunk(dataSource, DashUtil.a(b, representationHolder.c.a, l, n4), format, n2, o, k, m, i, a3, n3, n, -b.d, representationHolder.a);
    }
    
    @Override
    public void release() {
        final RepresentationHolder[] i = this.i;
        for (int length = i.length, j = 0; j < length; ++j) {
            final ChunkExtractor a = i[j].a;
            if (a != null) {
                a.release();
            }
        }
    }
    
    public static final class Factory implements DashChunkSource.Factory
    {
        private final DataSource.Factory a;
        private final int b;
        private final ChunkExtractor.Factory c;
        
        public Factory(final ChunkExtractor.Factory c, final DataSource.Factory a, final int b) {
            this.c = c;
            this.a = a;
            this.b = b;
        }
        
        public Factory(final DataSource.Factory factory) {
            this(factory, 1);
        }
        
        public Factory(final DataSource.Factory factory, final int n) {
            this(BundledChunkExtractor.j, factory, n);
        }
        
        @Override
        public DashChunkSource a(final LoaderErrorThrower loaderErrorThrower, final DashManifest dashManifest, final BaseUrlExclusionList list, final int n, final int[] array, final ExoTrackSelection exoTrackSelection, final int n2, final long n3, final boolean b, final List<Format> list2, final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, final TransferListener transferListener, final PlayerId playerId) {
            final DataSource dataSource = this.a.createDataSource();
            if (transferListener != null) {
                dataSource.e(transferListener);
            }
            return new DefaultDashChunkSource(this.c, loaderErrorThrower, dashManifest, list, n, array, exoTrackSelection, n2, dataSource, n3, this.b, b, list2, playerTrackEmsgHandler, playerId);
        }
    }
    
    protected static final class RepresentationHolder
    {
        final ChunkExtractor a;
        public final Representation b;
        public final BaseUrl c;
        public final DashSegmentIndex d;
        private final long e;
        private final long f;
        
        RepresentationHolder(final long e, final Representation b, final BaseUrl c, final ChunkExtractor a, final long f, final DashSegmentIndex d) {
            this.e = e;
            this.b = b;
            this.c = c;
            this.f = f;
            this.a = a;
            this.d = d;
        }
        
        static long a(final RepresentationHolder representationHolder) {
            return representationHolder.e;
        }
        
        RepresentationHolder b(final long n, final Representation representation) throws BehindLiveWindowException {
            final DashSegmentIndex l = this.b.l();
            final DashSegmentIndex i = representation.l();
            if (l == null) {
                return new RepresentationHolder(n, representation, this.c, this.a, this.f, l);
            }
            if (!l.h()) {
                return new RepresentationHolder(n, representation, this.c, this.a, this.f, i);
            }
            final long g = l.g(n);
            if (g == 0L) {
                return new RepresentationHolder(n, representation, this.c, this.a, this.f, i);
            }
            final long j = l.i();
            final long c = l.c(j);
            final long n2 = g + j - 1L;
            final long c2 = l.c(n2);
            final long a = l.a(n2, n);
            final long k = i.i();
            final long c3 = i.c(k);
            final long f = this.f;
            final long n3 = lcmp(c2 + a, c3);
            long f2;
            if (n3 == 0) {
                f2 = n2 + 1L;
            }
            else {
                if (n3 < 0) {
                    throw new BehindLiveWindowException();
                }
                if (c3 < c) {
                    final long n4 = f - (i.f(c, n) - j);
                    return new RepresentationHolder(n, representation, this.c, this.a, n4, i);
                }
                f2 = l.f(c3, n);
            }
            final long n4 = f + (f2 - k);
            return new RepresentationHolder(n, representation, this.c, this.a, n4, i);
        }
        
        RepresentationHolder c(final DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.e, this.b, this.c, this.a, this.f, dashSegmentIndex);
        }
        
        RepresentationHolder d(final BaseUrl baseUrl) {
            return new RepresentationHolder(this.e, this.b, baseUrl, this.a, this.f, this.d);
        }
        
        public long e(final long n) {
            return this.d.b(this.e, n) + this.f;
        }
        
        public long f() {
            return this.d.i() + this.f;
        }
        
        public long g(final long n) {
            return this.e(n) + this.d.j(this.e, n) - 1L;
        }
        
        public long h() {
            return this.d.g(this.e);
        }
        
        public long i(final long n) {
            return this.k(n) + this.d.a(n - this.f, this.e);
        }
        
        public long j(final long n) {
            return this.d.f(n, this.e) + this.f;
        }
        
        public long k(final long n) {
            return this.d.c(n - this.f);
        }
        
        public RangedUri l(final long n) {
            return this.d.e(n - this.f);
        }
        
        public boolean m(final long n, final long n2) {
            final boolean h = this.d.h();
            final boolean b = true;
            if (h) {
                return true;
            }
            boolean b2 = b;
            if (n2 != -9223372036854775807L) {
                b2 = (this.i(n) <= n2 && b);
            }
            return b2;
        }
    }
    
    protected static final class RepresentationSegmentIterator extends BaseMediaChunkIterator
    {
        private final RepresentationHolder e;
        private final long f;
        
        public RepresentationSegmentIterator(final RepresentationHolder e, final long n, final long n2, final long f) {
            super(n, n2);
            this.e = e;
            this.f = f;
        }
        
        @Override
        public long a() {
            this.c();
            return this.e.k(this.d());
        }
        
        @Override
        public long b() {
            this.c();
            return this.e.i(this.d());
        }
    }
}
