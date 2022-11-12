// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import java.io.IOException;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.SeekParameters;
import android.text.TextUtils;
import java.util.HashMap;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.Collection;
import com.google.common.primitives.Ints;
import java.util.Collections;
import com.google.android.exoplayer2.Format;
import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import java.util.HashSet;
import java.util.ArrayList;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Map;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import java.util.List;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.SampleStream;
import java.util.IdentityHashMap;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.MediaPeriod;

public final class HlsMediaPeriod implements MediaPeriod, HlsSampleStreamWrapper.Callback, PlaylistEventListener
{
    private final PlayerId A;
    private MediaPeriod.Callback B;
    private int C;
    private TrackGroupArray D;
    private HlsSampleStreamWrapper[] E;
    private HlsSampleStreamWrapper[] F;
    private int[][] G;
    private int H;
    private SequenceableLoader I;
    private final HlsExtractorFactory a;
    private final HlsPlaylistTracker b;
    private final HlsDataSourceFactory c;
    private final TransferListener d;
    private final DrmSessionManager e;
    private final DrmSessionEventListener.EventDispatcher f;
    private final LoadErrorHandlingPolicy g;
    private final MediaSourceEventListener.EventDispatcher h;
    private final Allocator i;
    private final IdentityHashMap<SampleStream, Integer> j;
    private final TimestampAdjusterProvider p;
    private final CompositeSequenceableLoaderFactory w;
    private final boolean x;
    private final int y;
    private final boolean z;
    
    public HlsMediaPeriod(final HlsExtractorFactory a, final HlsPlaylistTracker b, final HlsDataSourceFactory c, final TransferListener d, final DrmSessionManager e, final DrmSessionEventListener.EventDispatcher f, final LoadErrorHandlingPolicy g, final MediaSourceEventListener.EventDispatcher h, final Allocator i, final CompositeSequenceableLoaderFactory w, final boolean x, final int y, final boolean z, final PlayerId a2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.A = a2;
        this.I = w.a(new SequenceableLoader[0]);
        this.j = new IdentityHashMap<SampleStream, Integer>();
        this.p = new TimestampAdjusterProvider();
        this.E = new HlsSampleStreamWrapper[0];
        this.F = new HlsSampleStreamWrapper[0];
        this.G = new int[0][];
    }
    
    private void r(final long n, final List<HlsMultivariantPlaylist.Rendition> list, final List<HlsSampleStreamWrapper> list2, final List<int[]> list3, final Map<String, DrmInitData> map) {
        final ArrayList list4 = new ArrayList(list.size());
        final ArrayList list5 = new ArrayList(list.size());
        final ArrayList list6 = new ArrayList(list.size());
        final HashSet set = new HashSet();
        for (int i = 0; i < list.size(); ++i) {
            final String d = list.get(i).d;
            if (set.add(d)) {
                list4.clear();
                list5.clear();
                list6.clear();
                int j = 0;
                int n2 = 1;
                while (j < list.size()) {
                    int n3 = n2;
                    if (Util.c(d, ((HlsMultivariantPlaylist.Rendition)list.get(j)).d)) {
                        final HlsMultivariantPlaylist.Rendition rendition = list.get(j);
                        list6.add(j);
                        list4.add(rendition.a);
                        list5.add(rendition.b);
                        n3 = (n2 & ((Util.K(rendition.b.i, 1) == 1) ? 1 : 0));
                    }
                    ++j;
                    n2 = n3;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("audio:");
                sb.append(d);
                final String string = sb.toString();
                final HlsSampleStreamWrapper u = this.u(string, 1, list4.toArray(Util.k(new Uri[0])), (Format[])list5.toArray(new Format[0]), null, Collections.emptyList(), map, n);
                list3.add(Ints.n((Collection)list6));
                list2.add(u);
                if (this.x && n2 != 0) {
                    u.c0(new TrackGroup[] { new TrackGroup(string, (Format[])list5.toArray(new Format[0])) }, 0, new int[0]);
                }
            }
        }
    }
    
    private void s(final HlsMultivariantPlaylist hlsMultivariantPlaylist, final long n, final List<HlsSampleStreamWrapper> list, final List<int[]> list2, final Map<String, DrmInitData> map) {
        final int size = hlsMultivariantPlaylist.e.size();
        final int[] array = new int[size];
        int i = 0;
        int n3;
        int n2 = n3 = 0;
        while (i < hlsMultivariantPlaylist.e.size()) {
            final Format b = ((HlsMultivariantPlaylist.Variant)hlsMultivariantPlaylist.e.get(i)).b;
            if (b.C <= 0 && Util.L(b.i, 2) == null) {
                if (Util.L(b.i, 1) != null) {
                    array[i] = 1;
                    ++n3;
                }
                else {
                    array[i] = -1;
                }
            }
            else {
                array[i] = 2;
                ++n2;
            }
            ++i;
        }
        boolean b2;
        boolean b3;
        if (n2 > 0) {
            b2 = true;
            b3 = false;
        }
        else if (n3 < size) {
            n2 = size - n3;
            b2 = false;
            b3 = true;
        }
        else {
            b2 = false;
            b3 = false;
            n2 = size;
        }
        final Uri[] array2 = new Uri[n2];
        final Format[] array3 = new Format[n2];
        final int[] array4 = new int[n2];
        int j = 0;
        int n4 = 0;
        while (j < hlsMultivariantPlaylist.e.size()) {
            int n5 = 0;
            Label_0303: {
                if (b2) {
                    n5 = n4;
                    if (array[j] != 2) {
                        break Label_0303;
                    }
                }
                if (b3) {
                    n5 = n4;
                    if (array[j] == 1) {
                        break Label_0303;
                    }
                }
                final HlsMultivariantPlaylist.Variant variant = hlsMultivariantPlaylist.e.get(j);
                array2[n4] = variant.a;
                array3[n4] = variant.b;
                array4[n4] = j;
                n5 = n4 + 1;
            }
            ++j;
            n4 = n5;
        }
        final String k = array3[0].i;
        final int l = Util.K(k, 2);
        final int m = Util.K(k, 1);
        final boolean b4 = (m == 1 || (m == 0 && hlsMultivariantPlaylist.g.isEmpty())) && l <= 1 && m + l > 0;
        int n6;
        if (!b2 && m > 0) {
            n6 = 1;
        }
        else {
            n6 = 0;
        }
        final HlsSampleStreamWrapper u = this.u("main", n6, array2, array3, hlsMultivariantPlaylist.j, hlsMultivariantPlaylist.k, map, n);
        list.add(u);
        list2.add(array4);
        if (this.x && b4) {
            final ArrayList list3 = new ArrayList();
            if (l > 0) {
                final Format[] array5 = new Format[n2];
                for (int n7 = 0; n7 < n2; ++n7) {
                    array5[n7] = x(array3[n7]);
                }
                list3.add(new TrackGroup("main", array5));
                if (m > 0 && (hlsMultivariantPlaylist.j != null || hlsMultivariantPlaylist.g.isEmpty())) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("main");
                    sb.append(":audio");
                    list3.add(new TrackGroup(sb.toString(), new Format[] { v(array3[0], hlsMultivariantPlaylist.j, false) }));
                }
                final List<Format> k2 = hlsMultivariantPlaylist.k;
                if (k2 != null) {
                    for (int n8 = 0; n8 < k2.size(); ++n8) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("main");
                        sb2.append(":cc:");
                        sb2.append(n8);
                        list3.add(new TrackGroup(sb2.toString(), new Format[] { k2.get(n8) }));
                    }
                }
            }
            else {
                final Format[] array6 = new Format[n2];
                for (int n9 = 0; n9 < n2; ++n9) {
                    array6[n9] = v(array3[n9], hlsMultivariantPlaylist.j, true);
                }
                list3.add(new TrackGroup("main", array6));
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("main");
            sb3.append(":id3");
            final TrackGroup trackGroup = new TrackGroup(sb3.toString(), new Format[] { new Format.Builder().S("ID3").e0("application/id3").E() });
            list3.add(trackGroup);
            u.c0((TrackGroup[])list3.toArray(new TrackGroup[0]), 0, list3.indexOf(trackGroup));
        }
    }
    
    private void t(final long n) {
        final HlsMultivariantPlaylist hlsMultivariantPlaylist = Assertions.e(this.b.d());
        Map<String, DrmInitData> map;
        if (this.z) {
            map = w(hlsMultivariantPlaylist.m);
        }
        else {
            map = Collections.emptyMap();
        }
        final boolean empty = hlsMultivariantPlaylist.e.isEmpty();
        final List<HlsMultivariantPlaylist.Rendition> g = hlsMultivariantPlaylist.g;
        final List<HlsMultivariantPlaylist.Rendition> h = hlsMultivariantPlaylist.h;
        final int n2 = 0;
        this.C = 0;
        final ArrayList<HlsSampleStreamWrapper> list = new ArrayList<HlsSampleStreamWrapper>();
        final ArrayList<int[]> list2 = new ArrayList<int[]>();
        if (empty ^ true) {
            this.s(hlsMultivariantPlaylist, n, list, list2, map);
        }
        this.r(n, g, list, list2, map);
        this.H = list.size();
        for (int i = 0; i < h.size(); ++i) {
            final HlsMultivariantPlaylist.Rendition rendition = h.get(i);
            final StringBuilder sb = new StringBuilder();
            sb.append("subtitle:");
            sb.append(i);
            sb.append(":");
            sb.append(rendition.d);
            final String string = sb.toString();
            final HlsSampleStreamWrapper u = this.u(string, 3, new Uri[] { rendition.a }, new Format[] { rendition.b }, null, Collections.emptyList(), map, n);
            list2.add(new int[] { i });
            list.add(u);
            u.c0(new TrackGroup[] { new TrackGroup(string, new Format[] { rendition.b }) }, 0, new int[0]);
        }
        this.E = list.toArray(new HlsSampleStreamWrapper[0]);
        this.G = list2.toArray(new int[0][]);
        this.C = this.E.length;
        for (int j = 0; j < this.H; ++j) {
            this.E[j].l0(true);
        }
        final HlsSampleStreamWrapper[] e = this.E;
        for (int length = e.length, k = n2; k < length; ++k) {
            e[k].y();
        }
        this.F = this.E;
    }
    
    private HlsSampleStreamWrapper u(final String s, final int n, final Uri[] array, final Format[] array2, final Format format, final List<Format> list, final Map<String, DrmInitData> map, final long n2) {
        return new HlsSampleStreamWrapper(s, n, (HlsSampleStreamWrapper.Callback)this, new HlsChunkSource(this.a, this.b, array, array2, this.c, this.d, this.p, list, this.A), map, this.i, n2, format, this.e, this.f, this.g, this.h, this.y);
    }
    
    private static Format v(final Format format, final Format format2, final boolean b) {
        int g = -1;
        Metadata j;
        int n;
        int n2;
        int n3;
        String c;
        String s;
        String s2;
        if (format2 != null) {
            final String i = format2.i;
            j = format2.j;
            n = format2.J;
            n2 = format2.d;
            n3 = format2.e;
            c = format2.c;
            s = format2.b;
            s2 = i;
        }
        else {
            final String l = Util.L(format.i, 1);
            final Metadata k = format.j;
            if (b) {
                n = format.J;
                n2 = format.d;
                n3 = format.e;
                final String c2 = format.c;
                s = format.b;
                final Metadata metadata = k;
                s2 = l;
                j = metadata;
                c = c2;
            }
            else {
                c = null;
                n2 = 0;
                n = -1;
                final String s3 = l;
                s = null;
                n3 = 0;
                j = k;
                s2 = s3;
            }
        }
        final String g2 = MimeTypes.g(s2);
        int f;
        if (b) {
            f = format.f;
        }
        else {
            f = -1;
        }
        if (b) {
            g = format.g;
        }
        return new Format.Builder().S(format.a).U(s).K(format.p).e0(g2).I(s2).X(j).G(f).Z(g).H(n).g0(n2).c0(n3).V(c).E();
    }
    
    private static Map<String, DrmInitData> w(final List<DrmInitData> list) {
        final ArrayList list2 = new ArrayList((Collection<? extends E>)list);
        final HashMap hashMap = new HashMap();
        int i = 0;
        while (i < list2.size()) {
            DrmInitData f = list.get(i);
            final String c = f.c;
            int j = ++i;
            while (j < list2.size()) {
                final DrmInitData drmInitData = list2.get(j);
                if (TextUtils.equals((CharSequence)drmInitData.c, (CharSequence)c)) {
                    f = f.f(drmInitData);
                    list2.remove(j);
                }
                else {
                    ++j;
                }
            }
            hashMap.put(c, f);
        }
        return hashMap;
    }
    
    private static Format x(final Format format) {
        final String l = Util.L(format.i, 2);
        return new Format.Builder().S(format.a).U(format.b).K(format.p).e0(MimeTypes.g(l)).I(l).X(format.j).G(format.f).Z(format.g).j0(format.B).Q(format.C).P(format.D).g0(format.d).c0(format.e).E();
    }
    
    @Override
    public void a() {
        final HlsSampleStreamWrapper[] e = this.E;
        for (int length = e.length, i = 0; i < length; ++i) {
            e[i].a0();
        }
        ((SequenceableLoader.Callback<HlsMediaPeriod>)this.B).l(this);
    }
    
    @Override
    public long b() {
        return this.I.b();
    }
    
    @Override
    public long c(final long n, final SeekParameters seekParameters) {
        final HlsSampleStreamWrapper[] f = this.F;
        final int length = f.length;
        int n2 = 0;
        long c;
        while (true) {
            c = n;
            if (n2 >= length) {
                break;
            }
            final HlsSampleStreamWrapper hlsSampleStreamWrapper = f[n2];
            if (hlsSampleStreamWrapper.Q()) {
                c = hlsSampleStreamWrapper.c(n, seekParameters);
                break;
            }
            ++n2;
        }
        return c;
    }
    
    @Override
    public boolean d(final long n) {
        if (this.D == null) {
            final HlsSampleStreamWrapper[] e = this.E;
            for (int length = e.length, i = 0; i < length; ++i) {
                e[i].y();
            }
            return false;
        }
        return this.I.d(n);
    }
    
    @Override
    public boolean e(final Uri uri, final LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, final boolean b) {
        final HlsSampleStreamWrapper[] e = this.E;
        final int length = e.length;
        boolean b2 = true;
        for (int i = 0; i < length; ++i) {
            b2 &= e[i].Z(uri, loadErrorInfo, b);
        }
        ((SequenceableLoader.Callback<HlsMediaPeriod>)this.B).l(this);
        return b2;
    }
    
    @Override
    public long f() {
        return this.I.f();
    }
    
    @Override
    public void g(final long n) {
        this.I.g(n);
    }
    
    @Override
    public long h(final long n) {
        final HlsSampleStreamWrapper[] f = this.F;
        if (f.length > 0) {
            final boolean h0 = f[0].h0(n, false);
            int n2 = 1;
            while (true) {
                final HlsSampleStreamWrapper[] f2 = this.F;
                if (n2 >= f2.length) {
                    break;
                }
                f2[n2].h0(n, h0);
                ++n2;
            }
            if (h0) {
                this.p.b();
            }
        }
        return n;
    }
    
    @Override
    public long i() {
        return -9223372036854775807L;
    }
    
    @Override
    public boolean isLoading() {
        return this.I.isLoading();
    }
    
    @Override
    public void j(final MediaPeriod.Callback b, final long n) {
        this.B = b;
        this.b.f((HlsPlaylistTracker.PlaylistEventListener)this);
        this.t(n);
    }
    
    @Override
    public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, final long n) {
        final int[] array5 = new int[array.length];
        final int[] array6 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            int intValue;
            if (array3[i] == null) {
                intValue = -1;
            }
            else {
                intValue = this.j.get(array3[i]);
            }
            array5[i] = intValue;
            array6[i] = -1;
            if (array[i] != null) {
                final TrackGroup l = array[i].l();
                int n2 = 0;
                while (true) {
                    final HlsSampleStreamWrapper[] e = this.E;
                    if (n2 >= e.length) {
                        break;
                    }
                    if (e[n2].p().c(l) != -1) {
                        array6[i] = n2;
                        break;
                    }
                    ++n2;
                }
            }
        }
        this.j.clear();
        final int length = array.length;
        final SampleStream[] array7 = new SampleStream[length];
        final SampleStream[] array8 = new SampleStream[array.length];
        final ExoTrackSelection[] array9 = new ExoTrackSelection[array.length];
        final HlsSampleStreamWrapper[] array10 = new HlsSampleStreamWrapper[this.E.length];
        int n3 = 0;
        int j = 0;
        boolean b = false;
        while (j < this.E.length) {
            for (int k = 0; k < array.length; ++k) {
                final int n4 = array5[k];
                final ExoTrackSelection exoTrackSelection = null;
                SampleStream sampleStream;
                if (n4 == j) {
                    sampleStream = array3[k];
                }
                else {
                    sampleStream = null;
                }
                array8[k] = sampleStream;
                ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
                if (array6[k] == j) {
                    exoTrackSelection2 = array[k];
                }
                array9[k] = exoTrackSelection2;
            }
            final HlsSampleStreamWrapper hlsSampleStreamWrapper = this.E[j];
            final boolean i2 = hlsSampleStreamWrapper.i0(array9, array2, array8, array4, n, b);
            int n5 = 0;
            int n6 = 0;
            boolean b2;
            while (true) {
                final int length2 = array.length;
                b2 = true;
                boolean b3 = true;
                if (n5 >= length2) {
                    break;
                }
                final SampleStream sampleStream2 = array8[n5];
                int n7;
                if (array6[n5] == j) {
                    Assertions.e(sampleStream2);
                    array7[n5] = sampleStream2;
                    this.j.put(sampleStream2, j);
                    n7 = 1;
                }
                else {
                    n7 = n6;
                    if (array5[n5] == j) {
                        if (sampleStream2 != null) {
                            b3 = false;
                        }
                        Assertions.g(b3);
                        n7 = n6;
                    }
                }
                ++n5;
                n6 = n7;
            }
            Label_0535: {
                if (n6 != 0) {
                    array10[n3] = hlsSampleStreamWrapper;
                    final int n8 = n3 + 1;
                    if (n3 == 0) {
                        hlsSampleStreamWrapper.l0(true);
                        if (!i2) {
                            final HlsSampleStreamWrapper[] f = this.F;
                            if (f.length != 0) {
                                n3 = n8;
                                if (hlsSampleStreamWrapper == f[0]) {
                                    break Label_0535;
                                }
                            }
                        }
                        this.p.b();
                        b = true;
                        n3 = n8;
                    }
                    else {
                        hlsSampleStreamWrapper.l0(j < this.H && b2);
                        n3 = n8;
                    }
                }
            }
            ++j;
        }
        System.arraycopy(array7, 0, array3, 0, length);
        final HlsSampleStreamWrapper[] f2 = Util.H0(array10, n3);
        this.F = f2;
        this.I = this.w.a((SequenceableLoader[])f2);
        return n;
    }
    
    @Override
    public /* bridge */ void l(final SequenceableLoader sequenceableLoader) {
        this.y((HlsSampleStreamWrapper)sequenceableLoader);
    }
    
    @Override
    public void m(final Uri uri) {
        this.b.e(uri);
    }
    
    @Override
    public void n() throws IOException {
        final HlsSampleStreamWrapper[] e = this.E;
        for (int length = e.length, i = 0; i < length; ++i) {
            e[i].n();
        }
    }
    
    @Override
    public void onPrepared() {
        final int c = this.C - 1;
        this.C = c;
        if (c > 0) {
            return;
        }
        final HlsSampleStreamWrapper[] e = this.E;
        final int length = e.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            n += e[i].p().a;
            ++i;
        }
        final TrackGroup[] array = new TrackGroup[n];
        final HlsSampleStreamWrapper[] e2 = this.E;
        final int length2 = e2.length;
        int j = 0;
        int n2 = 0;
        while (j < length2) {
            final HlsSampleStreamWrapper hlsSampleStreamWrapper = e2[j];
            for (int a = hlsSampleStreamWrapper.p().a, k = 0; k < a; ++k, ++n2) {
                array[n2] = hlsSampleStreamWrapper.p().b(k);
            }
            ++j;
        }
        this.D = new TrackGroupArray(array);
        this.B.o(this);
    }
    
    @Override
    public TrackGroupArray p() {
        return Assertions.e(this.D);
    }
    
    @Override
    public void q(final long n, final boolean b) {
        final HlsSampleStreamWrapper[] f = this.F;
        for (int length = f.length, i = 0; i < length; ++i) {
            f[i].q(n, b);
        }
    }
    
    public void y(final HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        ((SequenceableLoader.Callback<HlsMediaPeriod>)this.B).l(this);
    }
    
    public void z() {
        this.b.a((HlsPlaylistTracker.PlaylistEventListener)this);
        final HlsSampleStreamWrapper[] e = this.E;
        for (int length = e.length, i = 0; i < length; ++i) {
            e[i].e0();
        }
        this.B = null;
    }
}
