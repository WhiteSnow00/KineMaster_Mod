// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import android.os.SystemClock;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import java.util.Arrays;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.common.collect.Iterables;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import android.util.Pair;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import java.util.Collection;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.io.IOException;
import com.google.android.exoplayer2.analytics.PlayerId;
import java.util.List;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.Format;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;

class HlsChunkSource
{
    private final HlsExtractorFactory a;
    private final DataSource b;
    private final DataSource c;
    private final TimestampAdjusterProvider d;
    private final Uri[] e;
    private final Format[] f;
    private final HlsPlaylistTracker g;
    private final TrackGroup h;
    private final List<Format> i;
    private final FullSegmentEncryptionKeyCache j;
    private final PlayerId k;
    private boolean l;
    private byte[] m;
    private IOException n;
    private Uri o;
    private boolean p;
    private ExoTrackSelection q;
    private long r;
    private boolean s;
    
    public HlsChunkSource(final HlsExtractorFactory a, final HlsPlaylistTracker g, final Uri[] e, final Format[] f, final HlsDataSourceFactory hlsDataSourceFactory, final TransferListener transferListener, final TimestampAdjusterProvider d, final List<Format> i, final PlayerId k) {
        this.a = a;
        this.g = g;
        this.e = e;
        this.f = f;
        this.d = d;
        this.i = i;
        this.k = k;
        this.j = new FullSegmentEncryptionKeyCache(4);
        this.m = Util.f;
        this.r = -9223372036854775807L;
        final DataSource a2 = hlsDataSourceFactory.a(1);
        this.b = a2;
        if (transferListener != null) {
            a2.e(transferListener);
        }
        this.c = hlsDataSourceFactory.a(3);
        this.h = new TrackGroup(f);
        final ArrayList list = new ArrayList();
        for (int j = 0; j < e.length; ++j) {
            if ((f[j].e & 0x4000) == 0x0) {
                list.add(j);
            }
        }
        this.q = new c(this.h, Ints.n((Collection)list));
    }
    
    private static Uri d(final HlsMediaPlaylist hlsMediaPlaylist, final HlsMediaPlaylist.SegmentBase segmentBase) {
        if (segmentBase != null) {
            final String g = segmentBase.g;
            if (g != null) {
                return UriUtil.e(hlsMediaPlaylist.a, g);
            }
        }
        return null;
    }
    
    private Pair<Long, Integer> f(final com.google.android.exoplayer2.source.hls.b b, final boolean b2, final HlsMediaPlaylist hlsMediaPlaylist, long n, long n2) {
        int n3 = -1;
        if (b != null && !b2) {
            Pair pair;
            if (b.h()) {
                if (b.o == -1) {
                    n = b.g();
                }
                else {
                    n = b.j;
                }
                final int o = b.o;
                if (o != -1) {
                    n3 = o + 1;
                }
                pair = new Pair((Object)n, (Object)n3);
            }
            else {
                pair = new Pair((Object)b.j, (Object)b.o);
            }
            return (Pair<Long, Integer>)pair;
        }
        final long u = hlsMediaPlaylist.u;
        long g = n2;
        if (b != null) {
            if (this.p) {
                g = n2;
            }
            else {
                g = b.g;
            }
        }
        if (!hlsMediaPlaylist.o && g >= u + n) {
            return (Pair<Long, Integer>)new Pair((Object)(hlsMediaPlaylist.k + hlsMediaPlaylist.r.size()), (Object)(-1));
        }
        final long n4 = g - n;
        final List<HlsMediaPlaylist.Segment> r = hlsMediaPlaylist.r;
        final boolean h = this.g.h();
        int n5 = 0;
        final int g2 = Util.g(r, n4, true, !h || b == null);
        n2 = g2 + hlsMediaPlaylist.k;
        int n6 = n3;
        n = n2;
        if (g2 >= 0) {
            final HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.r.get(g2);
            List<HlsMediaPlaylist.Part> list;
            if (n4 < segment.e + segment.c) {
                list = segment.x;
            }
            else {
                list = hlsMediaPlaylist.s;
            }
            while (true) {
                n6 = n3;
                n = n2;
                if (n5 >= list.size()) {
                    break;
                }
                final HlsMediaPlaylist.Part part = list.get(n5);
                if (n4 < part.e + part.c) {
                    n6 = n3;
                    n = n2;
                    if (part.w) {
                        if (list == hlsMediaPlaylist.s) {
                            n = 1L;
                        }
                        else {
                            n = 0L;
                        }
                        n += n2;
                        n6 = n5;
                        break;
                    }
                    break;
                }
                else {
                    ++n5;
                }
            }
        }
        return (Pair<Long, Integer>)new Pair((Object)n, (Object)n6);
    }
    
    private static d g(final HlsMediaPlaylist hlsMediaPlaylist, final long n, int n2) {
        final int n3 = (int)(n - hlsMediaPlaylist.k);
        final int size = hlsMediaPlaylist.r.size();
        d d = null;
        if (n3 == size) {
            if (n2 == -1) {
                n2 = 0;
            }
            if (n2 < hlsMediaPlaylist.s.size()) {
                d = new d(hlsMediaPlaylist.s.get(n2), n, n2);
            }
            return d;
        }
        final HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.r.get(n3);
        if (n2 == -1) {
            return new d(segment, n, -1);
        }
        if (n2 < segment.x.size()) {
            return new d(segment.x.get(n2), n, n2);
        }
        n2 = n3 + 1;
        if (n2 < hlsMediaPlaylist.r.size()) {
            return new d(hlsMediaPlaylist.r.get(n2), n + 1L, -1);
        }
        if (!hlsMediaPlaylist.s.isEmpty()) {
            return new d(hlsMediaPlaylist.s.get(0), n + 1L, 0);
        }
        return null;
    }
    
    static List<HlsMediaPlaylist.SegmentBase> i(final HlsMediaPlaylist hlsMediaPlaylist, final long n, final int n2) {
        final int n3 = (int)(n - hlsMediaPlaylist.k);
        if (n3 >= 0 && hlsMediaPlaylist.r.size() >= n3) {
            final ArrayList list = new ArrayList();
            final int size = hlsMediaPlaylist.r.size();
            final int n4 = 0;
            int n5 = n2;
            if (n3 < size) {
                int n6 = n3;
                if (n2 != -1) {
                    final HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.r.get(n3);
                    if (n2 == 0) {
                        list.add(segment);
                    }
                    else if (n2 < segment.x.size()) {
                        final List<HlsMediaPlaylist.Part> x = segment.x;
                        list.addAll(x.subList(n2, x.size()));
                    }
                    n6 = n3 + 1;
                }
                final List<HlsMediaPlaylist.Segment> r = hlsMediaPlaylist.r;
                list.addAll(r.subList(n6, r.size()));
                n5 = 0;
            }
            if (hlsMediaPlaylist.n != -9223372036854775807L) {
                if (n5 == -1) {
                    n5 = n4;
                }
                if (n5 < hlsMediaPlaylist.s.size()) {
                    final List<HlsMediaPlaylist.Part> s = hlsMediaPlaylist.s;
                    list.addAll(s.subList(n5, s.size()));
                }
            }
            return (List<HlsMediaPlaylist.SegmentBase>)Collections.unmodifiableList((List<?>)list);
        }
        return (List<HlsMediaPlaylist.SegmentBase>)ImmutableList.of();
    }
    
    private Chunk l(final Uri uri, final int n) {
        if (uri == null) {
            return null;
        }
        final byte[] c = this.j.c(uri);
        if (c != null) {
            this.j.b(uri, c);
            return null;
        }
        return new a(this.c, new DataSpec.Builder().i(uri).b(1).a(), this.f[n], this.q.t(), this.q.i(), this.m);
    }
    
    private long s(final long n) {
        final long r = this.r;
        long n2 = -9223372036854775807L;
        if (r != -9223372036854775807L) {
            n2 = r - n;
        }
        return n2;
    }
    
    private void w(final HlsMediaPlaylist hlsMediaPlaylist) {
        long r;
        if (hlsMediaPlaylist.o) {
            r = -9223372036854775807L;
        }
        else {
            r = hlsMediaPlaylist.e() - this.g.c();
        }
        this.r = r;
    }
    
    public MediaChunkIterator[] a(final com.google.android.exoplayer2.source.hls.b b, final long n) {
        int d;
        if (b == null) {
            d = -1;
        }
        else {
            d = this.h.d(b.d);
        }
        final int length = this.q.length();
        final MediaChunkIterator[] array = new MediaChunkIterator[length];
        for (int i = 0; i < length; ++i) {
            final int g = this.q.g(i);
            final Uri uri = this.e[g];
            if (!this.g.g(uri)) {
                array[i] = MediaChunkIterator.a;
            }
            else {
                final HlsMediaPlaylist l = this.g.l(uri, false);
                Assertions.e(l);
                final long n2 = l.h - this.g.c();
                final Pair<Long, Integer> f = this.f(b, g != d, l, n2, n);
                array[i] = new b(l.a, n2, i(l, (long)f.first, (int)f.second));
            }
        }
        return array;
    }
    
    public long b(long e, final SeekParameters seekParameters) {
        final int a = this.q.a();
        final Uri[] e2 = this.e;
        HlsMediaPlaylist l;
        if (a < e2.length && a != -1) {
            l = this.g.l(e2[this.q.r()], true);
        }
        else {
            l = null;
        }
        long n = e;
        if (l != null) {
            n = e;
            if (!l.r.isEmpty()) {
                if (!l.c) {
                    n = e;
                }
                else {
                    final long n2 = l.h - this.g.c();
                    final long n3 = e - n2;
                    final int g = Util.g(l.r, n3, true, true);
                    final long e3 = ((HlsMediaPlaylist.Segment)l.r.get(g)).e;
                    if (g != l.r.size() - 1) {
                        e = ((HlsMediaPlaylist.Segment)l.r.get(g + 1)).e;
                    }
                    else {
                        e = e3;
                    }
                    n = seekParameters.a(n3, e3, e) + n2;
                }
            }
        }
        return n;
    }
    
    public int c(final com.google.android.exoplayer2.source.hls.b b) {
        final int o = b.o;
        int n = 1;
        if (o == -1) {
            return 1;
        }
        final HlsMediaPlaylist hlsMediaPlaylist = Assertions.e(this.g.l(this.e[this.h.d(b.d)], false));
        final int n2 = (int)(b.j - hlsMediaPlaylist.k);
        if (n2 < 0) {
            return 1;
        }
        List<HlsMediaPlaylist.Part> list;
        if (n2 < hlsMediaPlaylist.r.size()) {
            list = ((HlsMediaPlaylist.Segment)hlsMediaPlaylist.r.get(n2)).x;
        }
        else {
            list = hlsMediaPlaylist.s;
        }
        if (b.o >= list.size()) {
            return 2;
        }
        final HlsMediaPlaylist.Part part = list.get(b.o);
        if (part.x) {
            return 0;
        }
        if (!Util.c(Uri.parse(UriUtil.d(hlsMediaPlaylist.a, part.a)), b.b.a)) {
            n = 2;
        }
        return n;
    }
    
    public void e(long n, long n2, final List<com.google.android.exoplayer2.source.hls.b> list, final boolean b, final HlsChunkHolder hlsChunkHolder) {
        com.google.android.exoplayer2.source.hls.b b2;
        if (list.isEmpty()) {
            b2 = null;
        }
        else {
            b2 = (com.google.android.exoplayer2.source.hls.b)Iterables.h((Iterable)list);
        }
        int d;
        if (b2 == null) {
            d = -1;
        }
        else {
            d = this.h.d(b2.d);
        }
        final long n3 = n2 - n;
        final long s = this.s(n);
        long max = n3;
        long max2 = s;
        if (b2 != null) {
            max = n3;
            max2 = s;
            if (!this.p) {
                final long d2 = b2.d();
                max = Math.max(0L, n3 - d2);
                max2 = s;
                if (s != -9223372036854775807L) {
                    max2 = Math.max(0L, s - d2);
                    max = max;
                }
            }
        }
        this.q.q(n, max, max2, list, this.a(b2, n2));
        final int r = this.q.r();
        final boolean b3 = d != r;
        Uri uri = this.e[r];
        if (!this.g.g(uri)) {
            hlsChunkHolder.c = uri;
            this.s &= uri.equals((Object)this.o);
            this.o = uri;
            return;
        }
        HlsMediaPlaylist hlsMediaPlaylist = this.g.l(uri, true);
        Assertions.e(hlsMediaPlaylist);
        this.p = hlsMediaPlaylist.c;
        this.w(hlsMediaPlaylist);
        final long n4 = hlsMediaPlaylist.h - this.g.c();
        final Pair<Long, Integer> f = this.f(b2, b3, hlsMediaPlaylist, n4, n2);
        n = (long)f.first;
        int n5 = (int)f.second;
        if (n < hlsMediaPlaylist.k && b2 != null && b3) {
            uri = this.e[d];
            hlsMediaPlaylist = this.g.l(uri, true);
            Assertions.e(hlsMediaPlaylist);
            final long n6 = hlsMediaPlaylist.h - this.g.c();
            final Pair<Long, Integer> f2 = this.f(b2, false, hlsMediaPlaylist, n6, n2);
            n = (long)f2.first;
            n5 = (int)f2.second;
            n2 = n6;
        }
        else {
            n2 = n4;
            d = r;
        }
        if (n < hlsMediaPlaylist.k) {
            this.n = new BehindLiveWindowException();
            return;
        }
        d g;
        if ((g = g(hlsMediaPlaylist, n, n5)) == null) {
            if (!hlsMediaPlaylist.o) {
                hlsChunkHolder.c = uri;
                this.s &= uri.equals((Object)this.o);
                this.o = uri;
                return;
            }
            if (b || hlsMediaPlaylist.r.isEmpty()) {
                hlsChunkHolder.b = true;
                return;
            }
            g = new d((HlsMediaPlaylist.SegmentBase)Iterables.h((Iterable)hlsMediaPlaylist.r), hlsMediaPlaylist.k + hlsMediaPlaylist.r.size() - 1L, -1);
        }
        this.s = false;
        this.o = null;
        final Uri d3 = d(hlsMediaPlaylist, g.a.b);
        if ((hlsChunkHolder.a = this.l(d3, d)) != null) {
            return;
        }
        final Uri d4 = d(hlsMediaPlaylist, g.a);
        if ((hlsChunkHolder.a = this.l(d4, d)) != null) {
            return;
        }
        final boolean w = b.w(b2, uri, hlsMediaPlaylist, g, n2);
        if (w && g.d) {
            return;
        }
        hlsChunkHolder.a = b.j(this.a, this.b, this.f[d], n2, hlsMediaPlaylist, g, uri, this.i, this.q.t(), this.q.i(), this.l, this.d, b2, this.j.a(d4), this.j.a(d3), w, this.k);
    }
    
    public int h(final long n, final List<? extends MediaChunk> list) {
        if (this.n == null && this.q.length() >= 2) {
            return this.q.o(n, list);
        }
        return list.size();
    }
    
    public TrackGroup j() {
        return this.h;
    }
    
    public ExoTrackSelection k() {
        return this.q;
    }
    
    public boolean m(final Chunk chunk, final long n) {
        final ExoTrackSelection q = this.q;
        return q.b(q.k(this.h.d(chunk.d)), n);
    }
    
    public void n() throws IOException {
        final IOException n = this.n;
        if (n == null) {
            final Uri o = this.o;
            if (o != null && this.s) {
                this.g.b(o);
            }
            return;
        }
        throw n;
    }
    
    public boolean o(final Uri uri) {
        return Util.s(this.e, uri);
    }
    
    public void p(final Chunk chunk) {
        if (chunk instanceof a) {
            final a a = (a)chunk;
            this.m = a.h();
            this.j.b(a.b.a, Assertions.e(a.j()));
        }
    }
    
    public boolean q(final Uri uri, final long n) {
        final boolean b = false;
        int n2 = 0;
        while (true) {
            final Uri[] e = this.e;
            if (n2 >= e.length) {
                n2 = -1;
                break;
            }
            if (e[n2].equals((Object)uri)) {
                break;
            }
            ++n2;
        }
        if (n2 == -1) {
            return true;
        }
        final int k = this.q.k(n2);
        if (k == -1) {
            return true;
        }
        this.s |= uri.equals((Object)this.o);
        if (n != -9223372036854775807L) {
            boolean b2 = b;
            if (!this.q.b(k, n)) {
                return b2;
            }
            b2 = b;
            if (!this.g.i(uri, n)) {
                return b2;
            }
        }
        return true;
    }
    
    public void r() {
        this.n = null;
    }
    
    public void t(final boolean l) {
        this.l = l;
    }
    
    public void u(final ExoTrackSelection q) {
        this.q = q;
    }
    
    public boolean v(final long n, final Chunk chunk, final List<? extends MediaChunk> list) {
        return this.n == null && this.q.d(n, chunk, list);
    }
    
    public static final class HlsChunkHolder
    {
        public Chunk a;
        public boolean b;
        public Uri c;
        
        public HlsChunkHolder() {
            this.a();
        }
        
        public void a() {
            this.a = null;
            this.b = false;
            this.c = null;
        }
    }
    
    private static final class a extends DataChunk
    {
        private byte[] l;
        
        public a(final DataSource dataSource, final DataSpec dataSpec, final Format format, final int n, final Object o, final byte[] array) {
            super(dataSource, dataSpec, 3, format, n, o, array);
        }
        
        @Override
        protected void g(final byte[] array, final int n) {
            this.l = Arrays.copyOf(array, n);
        }
        
        public byte[] j() {
            return this.l;
        }
    }
    
    static final class b extends BaseMediaChunkIterator
    {
        private final List<HlsMediaPlaylist.SegmentBase> e;
        private final long f;
        private final String g;
        
        public b(final String g, final long f, final List<HlsMediaPlaylist.SegmentBase> e) {
            super(0L, e.size() - 1);
            this.g = g;
            this.f = f;
            this.e = e;
        }
        
        @Override
        public long a() {
            this.c();
            return this.f + this.e.get((int)this.d()).e;
        }
        
        @Override
        public long b() {
            this.c();
            final HlsMediaPlaylist.SegmentBase segmentBase = this.e.get((int)this.d());
            return this.f + segmentBase.e + segmentBase.c;
        }
    }
    
    private static final class c extends BaseTrackSelection
    {
        private int h;
        
        public c(final TrackGroup trackGroup, final int[] array) {
            super(trackGroup, array);
            this.h = this.p(trackGroup.c(array[0]));
        }
        
        @Override
        public int a() {
            return this.h;
        }
        
        @Override
        public Object i() {
            return null;
        }
        
        @Override
        public void q(long elapsedRealtime, final long n, final long n2, final List<? extends MediaChunk> list, final MediaChunkIterator[] array) {
            elapsedRealtime = SystemClock.elapsedRealtime();
            if (!this.c(this.h, elapsedRealtime)) {
                return;
            }
            for (int i = super.b - 1; i >= 0; --i) {
                if (!this.c(i, elapsedRealtime)) {
                    this.h = i;
                    return;
                }
            }
            throw new IllegalStateException();
        }
        
        @Override
        public int t() {
            return 0;
        }
    }
    
    static final class d
    {
        public final HlsMediaPlaylist.SegmentBase a;
        public final long b;
        public final int c;
        public final boolean d;
        
        public d(final HlsMediaPlaylist.SegmentBase a, final long b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = (a instanceof HlsMediaPlaylist.Part && ((HlsMediaPlaylist.Part)a).x);
        }
    }
}
