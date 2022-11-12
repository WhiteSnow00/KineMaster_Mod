// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.util.List;
import com.google.android.exoplayer2.source.chunk.Chunk;
import java.io.IOException;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.util.Collection;
import java.util.Collections;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.SeekParameters;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.IdentityHashMap;

final class p implements MediaPeriod, Callback
{
    private final MediaPeriod[] a;
    private final IdentityHashMap<SampleStream, Integer> b;
    private final CompositeSequenceableLoaderFactory c;
    private final ArrayList<MediaPeriod> d;
    private final HashMap<TrackGroup, TrackGroup> e;
    private Callback f;
    private TrackGroupArray g;
    private MediaPeriod[] h;
    private SequenceableLoader i;
    
    public p(final CompositeSequenceableLoaderFactory c, final long[] array, final MediaPeriod... a) {
        this.c = c;
        this.a = a;
        this.d = new ArrayList<MediaPeriod>();
        this.e = new HashMap<TrackGroup, TrackGroup>();
        int i = 0;
        this.i = c.a(new SequenceableLoader[0]);
        this.b = new IdentityHashMap<SampleStream, Integer>();
        this.h = new MediaPeriod[0];
        while (i < a.length) {
            if (array[i] != 0L) {
                this.a[i] = new b(a[i], array[i]);
            }
            ++i;
        }
    }
    
    public MediaPeriod a(final int n) {
        final MediaPeriod[] a = this.a;
        MediaPeriod a2;
        if (a[n] instanceof b) {
            a2 = p.b.a((b)a[n]);
        }
        else {
            a2 = a[n];
        }
        return a2;
    }
    
    @Override
    public long b() {
        return this.i.b();
    }
    
    @Override
    public long c(final long n, final SeekParameters seekParameters) {
        final MediaPeriod[] h = this.h;
        MediaPeriod mediaPeriod;
        if (h.length > 0) {
            mediaPeriod = h[0];
        }
        else {
            mediaPeriod = this.a[0];
        }
        return mediaPeriod.c(n, seekParameters);
    }
    
    @Override
    public boolean d(final long n) {
        if (!this.d.isEmpty()) {
            for (int size = this.d.size(), i = 0; i < size; ++i) {
                this.d.get(i).d(n);
            }
            return false;
        }
        return this.i.d(n);
    }
    
    public void e(final MediaPeriod mediaPeriod) {
        ((SequenceableLoader.Callback<p>)Assertions.e(this.f)).l(this);
    }
    
    @Override
    public long f() {
        return this.i.f();
    }
    
    @Override
    public void g(final long n) {
        this.i.g(n);
    }
    
    @Override
    public long h(long h) {
        h = this.h[0].h(h);
        int n = 1;
        while (true) {
            final MediaPeriod[] h2 = this.h;
            if (n >= h2.length) {
                return h;
            }
            if (h2[n].h(h) != h) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            ++n;
        }
    }
    
    @Override
    public long i() {
        final MediaPeriod[] h = this.h;
        final int length = h.length;
        int i = 0;
        long n = -9223372036854775807L;
        while (i < length) {
            final MediaPeriod mediaPeriod = h[i];
            long j = mediaPeriod.i();
            if (j != -9223372036854775807L) {
                if (n == -9223372036854775807L) {
                    for (final MediaPeriod mediaPeriod2 : this.h) {
                        if (mediaPeriod2 == mediaPeriod) {
                            break;
                        }
                        if (mediaPeriod2.h(j) != j) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                }
                else {
                    if (j != n) {
                        throw new IllegalStateException("Conflicting discontinuities.");
                    }
                    j = n;
                }
            }
            else {
                j = n;
                if (n != -9223372036854775807L) {
                    if (mediaPeriod.h(n) != n) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                    j = n;
                }
            }
            ++i;
            n = j;
        }
        return n;
    }
    
    @Override
    public boolean isLoading() {
        return this.i.isLoading();
    }
    
    @Override
    public void j(final Callback f, final long n) {
        this.f = f;
        Collections.addAll(this.d, this.a);
        final MediaPeriod[] a = this.a;
        for (int length = a.length, i = 0; i < length; ++i) {
            a[i].j((Callback)this, n);
        }
    }
    
    @Override
    public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, long n) {
        final int[] array5 = new int[array.length];
        final int[] array6 = new int[array.length];
        int n2 = 0;
        while (true) {
            final int length = array.length;
            Integer n3 = null;
            if (n2 >= length) {
                break;
            }
            if (array3[n2] != null) {
                n3 = this.b.get(array3[n2]);
            }
            int intValue;
            if (n3 == null) {
                intValue = -1;
            }
            else {
                intValue = n3;
            }
            array5[n2] = intValue;
            array6[n2] = -1;
            if (array[n2] != null) {
                final TrackGroup trackGroup = Assertions.e(this.e.get(array[n2].l()));
                int n4 = 0;
                while (true) {
                    final MediaPeriod[] a = this.a;
                    if (n4 >= a.length) {
                        break;
                    }
                    if (a[n4].p().c(trackGroup) != -1) {
                        array6[n2] = n4;
                        break;
                    }
                    ++n4;
                }
            }
            ++n2;
        }
        this.b.clear();
        final int length2 = array.length;
        final SampleStream[] array7 = new SampleStream[length2];
        final SampleStream[] array8 = new SampleStream[array.length];
        final ExoTrackSelection[] array9 = new ExoTrackSelection[array.length];
        final ArrayList<MediaPeriod> list = new ArrayList<MediaPeriod>(this.a.length);
        for (int i = 0; i < this.a.length; ++i) {
            for (int j = 0; j < array.length; ++j) {
                SampleStream sampleStream;
                if (array5[j] == i) {
                    sampleStream = array3[j];
                }
                else {
                    sampleStream = null;
                }
                array8[j] = sampleStream;
                if (array6[j] == i) {
                    final ExoTrackSelection exoTrackSelection = Assertions.e(array[j]);
                    array9[j] = new a(exoTrackSelection, Assertions.e(this.e.get(exoTrackSelection.l())));
                }
                else {
                    array9[j] = null;
                }
            }
            final long k = this.a[i].k(array9, array2, array8, array4, n);
            if (i == 0) {
                n = k;
            }
            else if (k != n) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            int l = 0;
            int n5 = 0;
            while (l < array.length) {
                final int n6 = array6[l];
                boolean b = true;
                int n7;
                if (n6 == i) {
                    final SampleStream sampleStream2 = Assertions.e(array8[l]);
                    array7[l] = array8[l];
                    this.b.put(sampleStream2, i);
                    n7 = 1;
                }
                else {
                    n7 = n5;
                    if (array5[l] == i) {
                        if (array8[l] != null) {
                            b = false;
                        }
                        Assertions.g(b);
                        n7 = n5;
                    }
                }
                ++l;
                n5 = n7;
            }
            if (n5 != 0) {
                list.add(this.a[i]);
            }
        }
        System.arraycopy(array7, 0, array3, 0, length2);
        final MediaPeriod[] h = list.toArray(new MediaPeriod[0]);
        this.h = h;
        this.i = this.c.a((SequenceableLoader[])h);
        return n;
    }
    
    @Override
    public /* bridge */ void l(final SequenceableLoader sequenceableLoader) {
        this.e((MediaPeriod)sequenceableLoader);
    }
    
    @Override
    public void n() throws IOException {
        final MediaPeriod[] a = this.a;
        for (int length = a.length, i = 0; i < length; ++i) {
            a[i].n();
        }
    }
    
    @Override
    public void o(final MediaPeriod mediaPeriod) {
        this.d.remove(mediaPeriod);
        if (!this.d.isEmpty()) {
            return;
        }
        final MediaPeriod[] a = this.a;
        final int length = a.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            n += a[i].p().a;
            ++i;
        }
        final TrackGroup[] array = new TrackGroup[n];
        int n2 = 0;
        int n3 = 0;
        while (true) {
            final MediaPeriod[] a2 = this.a;
            if (n2 >= a2.length) {
                break;
            }
            final TrackGroupArray p = a2[n2].p();
            for (int a3 = p.a, j = 0; j < a3; ++j, ++n3) {
                final TrackGroup b = p.b(j);
                final StringBuilder sb = new StringBuilder();
                sb.append(n2);
                sb.append(":");
                sb.append(b.b);
                final TrackGroup b2 = b.b(sb.toString());
                this.e.put(b2, b);
                array[n3] = b2;
            }
            ++n2;
        }
        this.g = new TrackGroupArray(array);
        Assertions.e(this.f).o(this);
    }
    
    @Override
    public TrackGroupArray p() {
        return Assertions.e(this.g);
    }
    
    @Override
    public void q(final long n, final boolean b) {
        final MediaPeriod[] h = this.h;
        for (int length = h.length, i = 0; i < length; ++i) {
            h[i].q(n, b);
        }
    }
    
    private static final class a implements ExoTrackSelection
    {
        private final ExoTrackSelection a;
        private final TrackGroup b;
        
        public a(final ExoTrackSelection a, final TrackGroup b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public int a() {
            return this.a.a();
        }
        
        @Override
        public boolean b(final int n, final long n2) {
            return this.a.b(n, n2);
        }
        
        @Override
        public boolean c(final int n, final long n2) {
            return this.a.c(n, n2);
        }
        
        @Override
        public boolean d(final long n, final Chunk chunk, final List<? extends MediaChunk> list) {
            return this.a.d(n, chunk, list);
        }
        
        @Override
        public void e() {
            this.a.e();
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof a)) {
                return false;
            }
            final a a = (a)o;
            if (!this.a.equals(a.a) || !this.b.equals(a.b)) {
                b = false;
            }
            return b;
        }
        
        @Override
        public Format f(final int n) {
            return this.a.f(n);
        }
        
        @Override
        public int g(final int n) {
            return this.a.g(n);
        }
        
        @Override
        public void h(final float n) {
            this.a.h(n);
        }
        
        @Override
        public int hashCode() {
            return (527 + this.b.hashCode()) * 31 + this.a.hashCode();
        }
        
        @Override
        public Object i() {
            return this.a.i();
        }
        
        @Override
        public void j() {
            this.a.j();
        }
        
        @Override
        public int k(final int n) {
            return this.a.k(n);
        }
        
        @Override
        public TrackGroup l() {
            return this.b;
        }
        
        @Override
        public int length() {
            return this.a.length();
        }
        
        @Override
        public void m(final boolean b) {
            this.a.m(b);
        }
        
        @Override
        public void n() {
            this.a.n();
        }
        
        @Override
        public int o(final long n, final List<? extends MediaChunk> list) {
            return this.a.o(n, list);
        }
        
        @Override
        public int p(final Format format) {
            return this.a.p(format);
        }
        
        @Override
        public void q(final long n, final long n2, final long n3, final List<? extends MediaChunk> list, final MediaChunkIterator[] array) {
            this.a.q(n, n2, n3, list, array);
        }
        
        @Override
        public int r() {
            return this.a.r();
        }
        
        @Override
        public Format s() {
            return this.a.s();
        }
        
        @Override
        public int t() {
            return this.a.t();
        }
        
        @Override
        public void u() {
            this.a.u();
        }
    }
    
    private static final class b implements MediaPeriod, Callback
    {
        private final MediaPeriod a;
        private final long b;
        private Callback c;
        
        public b(final MediaPeriod a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        static MediaPeriod a(final b b) {
            return b.a;
        }
        
        @Override
        public long b() {
            final long b = this.a.b();
            long n = Long.MIN_VALUE;
            if (b != Long.MIN_VALUE) {
                n = this.b + b;
            }
            return n;
        }
        
        @Override
        public long c(final long n, final SeekParameters seekParameters) {
            return this.a.c(n - this.b, seekParameters) + this.b;
        }
        
        @Override
        public boolean d(final long n) {
            return this.a.d(n - this.b);
        }
        
        public void e(final MediaPeriod mediaPeriod) {
            ((SequenceableLoader.Callback<b>)Assertions.e(this.c)).l(this);
        }
        
        @Override
        public long f() {
            final long f = this.a.f();
            long n = Long.MIN_VALUE;
            if (f != Long.MIN_VALUE) {
                n = this.b + f;
            }
            return n;
        }
        
        @Override
        public void g(final long n) {
            this.a.g(n - this.b);
        }
        
        @Override
        public long h(final long n) {
            return this.a.h(n - this.b) + this.b;
        }
        
        @Override
        public long i() {
            final long i = this.a.i();
            long n = -9223372036854775807L;
            if (i != -9223372036854775807L) {
                n = this.b + i;
            }
            return n;
        }
        
        @Override
        public boolean isLoading() {
            return this.a.isLoading();
        }
        
        @Override
        public void j(final Callback c, final long n) {
            this.c = c;
            this.a.j((Callback)this, n - this.b);
        }
        
        @Override
        public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, long k) {
            final SampleStream[] array5 = new SampleStream[array3.length];
            final int n = 0;
            int n2 = 0;
            while (true) {
                final int length = array3.length;
                SampleStream b = null;
                if (n2 >= length) {
                    break;
                }
                final c c = (c)array3[n2];
                if (c != null) {
                    b = c.b();
                }
                array5[n2] = b;
                ++n2;
            }
            k = this.a.k(array, array2, array5, array4, k - this.b);
            for (int i = n; i < array3.length; ++i) {
                final SampleStream sampleStream = array5[i];
                if (sampleStream == null) {
                    array3[i] = null;
                }
                else if (array3[i] == null || ((c)array3[i]).b() != sampleStream) {
                    array3[i] = new c(sampleStream, this.b);
                }
            }
            return k + this.b;
        }
        
        @Override
        public /* bridge */ void l(final SequenceableLoader sequenceableLoader) {
            this.e((MediaPeriod)sequenceableLoader);
        }
        
        @Override
        public void n() throws IOException {
            this.a.n();
        }
        
        @Override
        public void o(final MediaPeriod mediaPeriod) {
            Assertions.e(this.c).o(this);
        }
        
        @Override
        public TrackGroupArray p() {
            return this.a.p();
        }
        
        @Override
        public void q(final long n, final boolean b) {
            this.a.q(n - this.b, b);
        }
    }
    
    private static final class c implements SampleStream
    {
        private final SampleStream a;
        private final long b;
        
        public c(final SampleStream a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void a() throws IOException {
            this.a.a();
        }
        
        public SampleStream b() {
            return this.a;
        }
        
        @Override
        public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, int e) {
            e = this.a.e(formatHolder, decoderInputBuffer, e);
            if (e == -4) {
                decoderInputBuffer.f = Math.max(0L, decoderInputBuffer.f + this.b);
            }
            return e;
        }
        
        @Override
        public boolean isReady() {
            return this.a.isReady();
        }
        
        @Override
        public int l(final long n) {
            return this.a.l(n - this.b);
        }
    }
}
