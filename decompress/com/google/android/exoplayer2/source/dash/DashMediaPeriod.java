// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.io.IOException;
import com.google.android.exoplayer2.SeekParameters;
import java.util.Iterator;
import java.util.Arrays;
import com.google.common.primitives.Ints;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import java.util.Collection;
import java.util.ArrayList;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.SampleStream;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import android.util.Pair;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.util.IdentityHashMap;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import java.util.List;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import java.util.regex.Pattern;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.MediaPeriod;

final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ReleaseCallback<DashChunkSource>
{
    private static final Pattern J;
    private static final Pattern K;
    private final DrmSessionEventListener.EventDispatcher A;
    private final PlayerId B;
    private MediaPeriod.Callback C;
    private ChunkSampleStream<DashChunkSource>[] D;
    private a[] E;
    private SequenceableLoader F;
    private DashManifest G;
    private int H;
    private List<EventStream> I;
    final int a;
    private final DashChunkSource.Factory b;
    private final TransferListener c;
    private final DrmSessionManager d;
    private final LoadErrorHandlingPolicy e;
    private final BaseUrlExclusionList f;
    private final long g;
    private final LoaderErrorThrower h;
    private final Allocator i;
    private final TrackGroupArray j;
    private final TrackGroupInfo[] p;
    private final CompositeSequenceableLoaderFactory w;
    private final PlayerEmsgHandler x;
    private final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler> y;
    private final MediaSourceEventListener.EventDispatcher z;
    
    static {
        J = Pattern.compile("CC([1-4])=(.+)");
        K = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    }
    
    public DashMediaPeriod(final int a, final DashManifest g, final BaseUrlExclusionList f, final int h, final DashChunkSource.Factory b, final TransferListener c, final DrmSessionManager d, final DrmSessionEventListener.EventDispatcher a2, final LoadErrorHandlingPolicy e, final MediaSourceEventListener.EventDispatcher z, final long g2, final LoaderErrorThrower h2, final Allocator i, final CompositeSequenceableLoaderFactory w, final PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, final PlayerId b2) {
        this.a = a;
        this.G = g;
        this.f = f;
        this.H = h;
        this.b = b;
        this.c = c;
        this.d = d;
        this.A = a2;
        this.e = e;
        this.z = z;
        this.g = g2;
        this.h = h2;
        this.i = i;
        this.w = w;
        this.B = b2;
        this.x = new PlayerEmsgHandler(g, playerEmsgCallback, i);
        this.D = D(0);
        this.E = new a[0];
        this.y = new IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler>();
        this.F = w.a((SequenceableLoader[])this.D);
        final Period d2 = g.d(h);
        final List<EventStream> d3 = d2.d;
        this.I = d3;
        final Pair<TrackGroupArray, TrackGroupInfo[]> t = t(d, d2.c, d3);
        this.j = (TrackGroupArray)t.first;
        this.p = (TrackGroupInfo[])t.second;
    }
    
    private int[] A(final ExoTrackSelection[] array) {
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != null) {
                array2[i] = this.j.c(array[i].l());
            }
            else {
                array2[i] = -1;
            }
        }
        return array2;
    }
    
    private static boolean B(final List<AdaptationSet> list, final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final List<Representation> c = list.get(array[i]).c;
            for (int j = 0; j < c.size(); ++j) {
                if (!((Representation)c.get(j)).e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static int C(final int n, final List<AdaptationSet> list, final int[][] array, final boolean[] array2, final Format[][] array3) {
        int i = 0;
        int n2 = 0;
        while (i < n) {
            int n3 = n2;
            if (B(list, array[i])) {
                array2[i] = true;
                n3 = n2 + 1;
            }
            array3[i] = x(list, array[i]);
            n2 = n3;
            if (array3[i].length != 0) {
                n2 = n3 + 1;
            }
            ++i;
        }
        return n2;
    }
    
    private static ChunkSampleStream<DashChunkSource>[] D(final int n) {
        return new ChunkSampleStream[n];
    }
    
    private static Format[] F(final Descriptor descriptor, final Pattern pattern, final Format format) {
        final String b = descriptor.b;
        if (b == null) {
            return new Format[] { format };
        }
        final String[] t0 = Util.T0(b, ";");
        final Format[] array = new Format[t0.length];
        for (int i = 0; i < t0.length; ++i) {
            final Matcher matcher = pattern.matcher(t0[i]);
            if (!matcher.matches()) {
                return new Format[] { format };
            }
            final int int1 = Integer.parseInt(matcher.group(1));
            final Format.Builder b2 = format.b();
            final StringBuilder sb = new StringBuilder();
            sb.append(format.a);
            sb.append(":");
            sb.append(int1);
            array[i] = b2.S(sb.toString()).F(int1).V(matcher.group(2)).E();
        }
        return array;
    }
    
    private void H(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == null || !array2[i]) {
                if (array3[i] instanceof ChunkSampleStream) {
                    ((ChunkSampleStream)array3[i]).O((ChunkSampleStream.ReleaseCallback)this);
                }
                else if (array3[i] instanceof EmbeddedSampleStream) {
                    ((EmbeddedSampleStream)array3[i]).c();
                }
                array3[i] = null;
            }
        }
    }
    
    private void I(final ExoTrackSelection[] array, final SampleStream[] array2, final int[] array3) {
        for (int i = 0; i < array.length; ++i) {
            if (array2[i] instanceof EmptySampleStream || array2[i] instanceof EmbeddedSampleStream) {
                final int z = this.z(i, array3);
                boolean b;
                if (z == -1) {
                    b = (array2[i] instanceof EmptySampleStream);
                }
                else {
                    b = (array2[i] instanceof EmbeddedSampleStream && ((EmbeddedSampleStream)array2[i]).a == array2[z]);
                }
                if (!b) {
                    if (array2[i] instanceof EmbeddedSampleStream) {
                        ((EmbeddedSampleStream)array2[i]).c();
                    }
                    array2[i] = null;
                }
            }
        }
    }
    
    private void J(final ExoTrackSelection[] array, final SampleStream[] array2, final boolean[] array3, final long n, final int[] array4) {
        final int n2 = 0;
        int n3 = 0;
        int i;
        while (true) {
            i = n2;
            if (n3 >= array.length) {
                break;
            }
            final ExoTrackSelection exoTrackSelection = array[n3];
            if (exoTrackSelection != null) {
                if (array2[n3] == null) {
                    array3[n3] = true;
                    final TrackGroupInfo trackGroupInfo = this.p[array4[n3]];
                    final int c = trackGroupInfo.c;
                    if (c == 0) {
                        array2[n3] = this.s(trackGroupInfo, exoTrackSelection, n);
                    }
                    else if (c == 2) {
                        array2[n3] = new a(this.I.get(trackGroupInfo.d), exoTrackSelection.l().c(0), this.G.d);
                    }
                }
                else if (array2[n3] instanceof ChunkSampleStream) {
                    ((ChunkSampleStream)array2[n3]).B().b(exoTrackSelection);
                }
            }
            ++n3;
        }
        while (i < array.length) {
            if (array2[i] == null && array[i] != null) {
                final TrackGroupInfo trackGroupInfo2 = this.p[array4[i]];
                if (trackGroupInfo2.c == 1) {
                    final int z = this.z(i, array4);
                    if (z == -1) {
                        array2[i] = new EmptySampleStream();
                    }
                    else {
                        array2[i] = ((ChunkSampleStream)array2[z]).R(n, trackGroupInfo2.b);
                    }
                }
            }
            ++i;
        }
    }
    
    private static void e(final List<EventStream> list, final TrackGroup[] array, final TrackGroupInfo[] array2, int n) {
        for (int i = 0; i < list.size(); ++i, ++n) {
            final EventStream eventStream = list.get(i);
            final Format e = new Format.Builder().S(eventStream.a()).e0("application/x-emsg").E();
            final StringBuilder sb = new StringBuilder();
            sb.append(eventStream.a());
            sb.append(":");
            sb.append(i);
            array[n] = new TrackGroup(sb.toString(), new Format[] { e });
            array2[n] = TrackGroupInfo.c(i);
        }
    }
    
    private static int r(final DrmSessionManager drmSessionManager, final List<AdaptationSet> list, final int[][] array, final int n, final boolean[] array2, final Format[][] array3, final TrackGroup[] array4, final TrackGroupInfo[] array5) {
        int i = 0;
        int n2 = 0;
        while (i < n) {
            final int[] array6 = array[i];
            final ArrayList list2 = new ArrayList();
            for (int length = array6.length, j = 0; j < length; ++j) {
                list2.addAll(list.get(array6[j]).c);
            }
            final int size = list2.size();
            final Format[] array7 = new Format[size];
            for (int k = 0; k < size; ++k) {
                final Format b = ((Representation)list2.get(k)).b;
                array7[k] = b.c(drmSessionManager.a(b));
            }
            final AdaptationSet set = list.get(array6[0]);
            final int a = set.a;
            String s;
            if (a != -1) {
                s = Integer.toString(a);
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append("unset:");
                sb.append(i);
                s = sb.toString();
            }
            int n3 = n2 + 1;
            int n4;
            if (array2[i]) {
                n4 = n3 + 1;
            }
            else {
                n4 = n3;
                n3 = -1;
            }
            int n6;
            if (array3[i].length != 0) {
                final int n5 = n4 + 1;
                n6 = n4;
                n4 = n5;
            }
            else {
                n6 = -1;
            }
            array4[n2] = new TrackGroup(s, array7);
            array5[n2] = TrackGroupInfo.d(set.b, array6, n2, n3, n6);
            if (n3 != -1) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(s);
                sb2.append(":emsg");
                final String string = sb2.toString();
                array4[n3] = new TrackGroup(string, new Format[] { new Format.Builder().S(string).e0("application/x-emsg").E() });
                array5[n3] = TrackGroupInfo.b(array6, n2);
            }
            if (n6 != -1) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(s);
                sb3.append(":cc");
                array4[n6] = new TrackGroup(sb3.toString(), array3[i]);
                array5[n6] = TrackGroupInfo.a(array6, n2);
            }
            ++i;
            n2 = n4;
        }
        return n2;
    }
    
    private ChunkSampleStream<DashChunkSource> s(final TrackGroupInfo trackGroupInfo, final ExoTrackSelection exoTrackSelection, final long n) {
        final int f = trackGroupInfo.f;
        final int n2 = 0;
        final boolean b = f != -1;
        final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = null;
        TrackGroup b2;
        int n3;
        if (b) {
            b2 = this.j.b(f);
            n3 = 1;
        }
        else {
            n3 = 0;
            b2 = null;
        }
        final int g = trackGroupInfo.g;
        final boolean b3 = g != -1;
        TrackGroup b4;
        if (b3) {
            b4 = this.j.b(g);
            n3 += b4.a;
        }
        else {
            b4 = null;
        }
        final Format[] array = new Format[n3];
        final int[] array2 = new int[n3];
        int n4;
        if (b) {
            array[0] = b2.c(0);
            array2[0] = 5;
            n4 = 1;
        }
        else {
            n4 = 0;
        }
        final ArrayList<Format> list = new ArrayList<Format>();
        if (b3) {
            for (int i = n2; i < b4.a; ++i) {
                array[n4] = b4.c(i);
                array2[n4] = 3;
                list.add(array[n4]);
                ++n4;
            }
        }
        TrackOutput k = playerTrackEmsgHandler;
        if (this.G.d) {
            k = playerTrackEmsgHandler;
            if (b) {
                k = this.x.k();
            }
        }
        final ChunkSampleStream chunkSampleStream = new ChunkSampleStream<DashChunkSource>(trackGroupInfo.b, array2, array, this.b.a(this.h, this.G, this.f, this.H, trackGroupInfo.a, exoTrackSelection, trackGroupInfo.b, this.g, b, list, (PlayerEmsgHandler.PlayerTrackEmsgHandler)k, this.c, this.B), (SequenceableLoader.Callback<ChunkSampleStream<ChunkSource>>)this, this.i, n, this.d, this.A, this.e, this.z);
        synchronized (this) {
            this.y.put((ChunkSampleStream<DashChunkSource>)chunkSampleStream, (PlayerEmsgHandler.PlayerTrackEmsgHandler)k);
            return (ChunkSampleStream<DashChunkSource>)chunkSampleStream;
        }
    }
    
    private static Pair<TrackGroupArray, TrackGroupInfo[]> t(final DrmSessionManager drmSessionManager, final List<AdaptationSet> list, final List<EventStream> list2) {
        final int[][] y = y(list);
        final int length = y.length;
        final boolean[] array = new boolean[length];
        final Format[][] array2 = new Format[length][];
        final int n = C(length, list, y, array, array2) + length + list2.size();
        final TrackGroup[] array3 = new TrackGroup[n];
        final TrackGroupInfo[] array4 = new TrackGroupInfo[n];
        e(list2, array3, array4, r(drmSessionManager, list, y, length, array, array2, array3, array4));
        return (Pair<TrackGroupArray, TrackGroupInfo[]>)Pair.create((Object)new TrackGroupArray(array3), (Object)array4);
    }
    
    private static Descriptor u(final List<Descriptor> list) {
        return v(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }
    
    private static Descriptor v(final List<Descriptor> list, final String s) {
        for (int i = 0; i < list.size(); ++i) {
            final Descriptor descriptor = list.get(i);
            if (s.equals(descriptor.a)) {
                return descriptor;
            }
        }
        return null;
    }
    
    private static Descriptor w(final List<Descriptor> list) {
        return v(list, "http://dashif.org/guidelines/trickmode");
    }
    
    private static Format[] x(final List<AdaptationSet> list, final int[] array) {
        for (final int n : array) {
            final AdaptationSet set = list.get(n);
            final List<Descriptor> d = list.get(n).d;
            for (int j = 0; j < d.size(); ++j) {
                final Descriptor descriptor = d.get(j);
                if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.a)) {
                    final Format.Builder e0 = new Format.Builder().e0("application/cea-608");
                    final StringBuilder sb = new StringBuilder();
                    sb.append(set.a);
                    sb.append(":cea608");
                    return F(descriptor, DashMediaPeriod.J, e0.S(sb.toString()).E());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.a)) {
                    final Format.Builder e2 = new Format.Builder().e0("application/cea-708");
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(set.a);
                    sb2.append(":cea708");
                    return F(descriptor, DashMediaPeriod.K, e2.S(sb2.toString()).E());
                }
            }
        }
        return new Format[0];
    }
    
    private static int[][] y(final List<AdaptationSet> list) {
        final int size = list.size();
        final SparseIntArray sparseIntArray = new SparseIntArray(size);
        final ArrayList list2 = new ArrayList(size);
        final SparseArray sparseArray = new SparseArray(size);
        final int n = 0;
        for (int i = 0; i < size; ++i) {
            sparseIntArray.put(((AdaptationSet)list.get(i)).a, i);
            final ArrayList list3 = new ArrayList();
            list3.add(i);
            list2.add((Object)list3);
            sparseArray.put(i, (Object)list3);
        }
        for (int j = 0; j < size; ++j) {
            final AdaptationSet set = list.get(j);
            Descriptor descriptor;
            if ((descriptor = w(set.e)) == null) {
                descriptor = w(set.f);
            }
            int value = 0;
            Label_0195: {
                if (descriptor != null) {
                    value = sparseIntArray.get(Integer.parseInt(descriptor.b), -1);
                    if (value != -1) {
                        break Label_0195;
                    }
                }
                value = j;
            }
            int n2 = value;
            if (value == j) {
                final Descriptor u = u(set.f);
                n2 = value;
                if (u != null) {
                    final String[] t0 = Util.T0(u.b, ",");
                    final int length = t0.length;
                    int n3 = 0;
                    while (true) {
                        n2 = value;
                        if (n3 >= length) {
                            break;
                        }
                        final int value2 = sparseIntArray.get(Integer.parseInt(t0[n3]), -1);
                        int min = value;
                        if (value2 != -1) {
                            min = Math.min(value, value2);
                        }
                        ++n3;
                        value = min;
                    }
                }
            }
            if (n2 != j) {
                final List list4 = (List)sparseArray.get(j);
                final List list5 = (List)sparseArray.get(n2);
                list5.addAll(list4);
                sparseArray.put(j, (Object)list5);
                list2.remove(list4);
            }
        }
        final int size2 = list2.size();
        final int[][] array = new int[size2][];
        for (int k = n; k < size2; ++k) {
            Arrays.sort(array[k] = Ints.n((Collection)list2.get(k)));
        }
        return array;
    }
    
    private int z(int i, final int[] array) {
        i = array[i];
        if (i == -1) {
            return -1;
        }
        final int e = this.p[i].e;
        int n;
        for (i = 0; i < array.length; ++i) {
            n = array[i];
            if (n == e && this.p[n].c == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public void E(final ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        ((SequenceableLoader.Callback<DashMediaPeriod>)this.C).l(this);
    }
    
    public void G() {
        this.x.o();
        final ChunkSampleStream<DashChunkSource>[] d = this.D;
        for (int length = d.length, i = 0; i < length; ++i) {
            d[i].O((ChunkSampleStream.ReleaseCallback<DashChunkSource>)this);
        }
        this.C = null;
    }
    
    public void K(final DashManifest g, final int h) {
        this.G = g;
        this.H = h;
        this.x.q(g);
        final ChunkSampleStream<DashChunkSource>[] d = this.D;
        if (d != null) {
            for (int length = d.length, i = 0; i < length; ++i) {
                d[i].B().h(g, h);
            }
            ((SequenceableLoader.Callback<DashMediaPeriod>)this.C).l(this);
        }
        this.I = g.d(h).d;
        for (final a a : this.E) {
            for (final EventStream eventStream : this.I) {
                if (eventStream.a().equals(a.b())) {
                    final int e2 = g.e();
                    boolean b = true;
                    if (!g.d || h != e2 - 1) {
                        b = false;
                    }
                    a.d(eventStream, b);
                    break;
                }
            }
        }
    }
    
    @Override
    public void a(final ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        synchronized (this) {
            final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.y.remove(chunkSampleStream);
            if (playerTrackEmsgHandler != null) {
                playerTrackEmsgHandler.n();
            }
        }
    }
    
    @Override
    public long b() {
        return this.F.b();
    }
    
    @Override
    public long c(final long n, final SeekParameters seekParameters) {
        for (final ChunkSampleStream<DashChunkSource> chunkSampleStream : this.D) {
            if (chunkSampleStream.a == 2) {
                return chunkSampleStream.c(n, seekParameters);
            }
        }
        return n;
    }
    
    @Override
    public boolean d(final long n) {
        return this.F.d(n);
    }
    
    @Override
    public long f() {
        return this.F.f();
    }
    
    @Override
    public void g(final long n) {
        this.F.g(n);
    }
    
    @Override
    public long h(final long n) {
        final ChunkSampleStream<DashChunkSource>[] d = this.D;
        final int length = d.length;
        final int n2 = 0;
        for (int i = 0; i < length; ++i) {
            d[i].Q(n);
        }
        final a[] e = this.E;
        for (int length2 = e.length, j = n2; j < length2; ++j) {
            e[j].c(n);
        }
        return n;
    }
    
    @Override
    public long i() {
        return -9223372036854775807L;
    }
    
    @Override
    public boolean isLoading() {
        return this.F.isLoading();
    }
    
    @Override
    public void j(final MediaPeriod.Callback c, final long n) {
        (this.C = c).o(this);
    }
    
    @Override
    public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, final long n) {
        final int[] a = this.A(array);
        this.H(array, array2, array3);
        this.I(array, array3, a);
        this.J(array, array3, array4, n, a);
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (final SampleStream sampleStream : array3) {
            if (sampleStream instanceof ChunkSampleStream) {
                list.add(sampleStream);
            }
            else if (sampleStream instanceof a) {
                list2.add(sampleStream);
            }
        }
        list.toArray(this.D = D(list.size()));
        list2.toArray(this.E = new a[list2.size()]);
        this.F = this.w.a((SequenceableLoader[])this.D);
        return n;
    }
    
    @Override
    public /* bridge */ void l(final SequenceableLoader sequenceableLoader) {
        this.E((ChunkSampleStream<DashChunkSource>)sequenceableLoader);
    }
    
    @Override
    public void n() throws IOException {
        this.h.a();
    }
    
    @Override
    public TrackGroupArray p() {
        return this.j;
    }
    
    @Override
    public void q(final long n, final boolean b) {
        final ChunkSampleStream<DashChunkSource>[] d = this.D;
        for (int length = d.length, i = 0; i < length; ++i) {
            d[i].q(n, b);
        }
    }
    
    private static final class TrackGroupInfo
    {
        public final int[] a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        
        private TrackGroupInfo(final int b, final int c, final int[] a, final int e, final int f, final int g, final int d) {
            this.b = b;
            this.a = a;
            this.c = c;
            this.e = e;
            this.f = f;
            this.g = g;
            this.d = d;
        }
        
        public static TrackGroupInfo a(final int[] array, final int n) {
            return new TrackGroupInfo(3, 1, array, n, -1, -1, -1);
        }
        
        public static TrackGroupInfo b(final int[] array, final int n) {
            return new TrackGroupInfo(5, 1, array, n, -1, -1, -1);
        }
        
        public static TrackGroupInfo c(final int n) {
            return new TrackGroupInfo(5, 2, new int[0], -1, -1, -1, n);
        }
        
        public static TrackGroupInfo d(final int n, final int[] array, final int n2, final int n3, final int n4) {
            return new TrackGroupInfo(n, 0, array, n2, n3, n4, -1);
        }
        
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        @Target({ ElementType.TYPE_USE })
        public @interface TrackGroupCategory {
        }
    }
}
