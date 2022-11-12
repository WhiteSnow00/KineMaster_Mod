// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.io.IOException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.source.SampleQueue;
import java.util.List;
import java.util.ArrayList;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.SampleStream;

public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback
{
    private Chunk A;
    private Format B;
    private ReleaseCallback<T> C;
    private long D;
    private long E;
    private int F;
    private BaseMediaChunk G;
    boolean H;
    public final int a;
    private final int[] b;
    private final Format[] c;
    private final boolean[] d;
    private final T e;
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> f;
    private final MediaSourceEventListener.EventDispatcher g;
    private final LoadErrorHandlingPolicy h;
    private final Loader i;
    private final ChunkHolder j;
    private final ArrayList<BaseMediaChunk> p;
    private final List<BaseMediaChunk> w;
    private final SampleQueue x;
    private final SampleQueue[] y;
    private final BaseMediaChunkOutput z;
    
    public ChunkSampleStream(int i, final int[] array, final Format[] array2, final T e, final SequenceableLoader.Callback<ChunkSampleStream<T>> f, final Allocator allocator, final long n, final DrmSessionManager drmSessionManager, final DrmSessionEventListener.EventDispatcher eventDispatcher, final LoadErrorHandlingPolicy h, final MediaSourceEventListener.EventDispatcher g) {
        this.a = i;
        final int n2 = 0;
        int[] b = array;
        if (array == null) {
            b = new int[0];
        }
        this.b = b;
        Format[] c;
        if ((c = array2) == null) {
            c = new Format[0];
        }
        this.c = c;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = new Loader("ChunkSampleStream");
        this.j = new ChunkHolder();
        final ArrayList<BaseMediaChunk> p11 = new ArrayList<BaseMediaChunk>();
        this.p = p11;
        this.w = (List<BaseMediaChunk>)Collections.unmodifiableList((List<?>)p11);
        final int length = b.length;
        this.y = new SampleQueue[length];
        this.d = new boolean[length];
        final int n3 = length + 1;
        final int[] array3 = new int[n3];
        final SampleQueue[] array4 = new SampleQueue[n3];
        final SampleQueue k = SampleQueue.k(allocator, drmSessionManager, eventDispatcher);
        this.x = k;
        array3[0] = i;
        array4[0] = k;
        SampleQueue l;
        int n4;
        for (i = n2; i < length; i = n4) {
            l = SampleQueue.l(allocator);
            this.y[i] = l;
            n4 = i + 1;
            array4[n4] = l;
            array3[n4] = this.b[i];
        }
        this.z = new BaseMediaChunkOutput(array3, array4);
        this.D = n;
        this.E = n;
    }
    
    private BaseMediaChunk C() {
        final ArrayList<BaseMediaChunk> p = this.p;
        return p.get(p.size() - 1);
    }
    
    private boolean D(int n) {
        final BaseMediaChunk baseMediaChunk = this.p.get(n);
        if (this.x.C() > baseMediaChunk.i(0)) {
            return true;
        }
        n = 0;
        SampleQueue[] y;
        do {
            y = this.y;
            if (n < y.length) {
                continue;
            }
            return false;
        } while (y[n].C() <= baseMediaChunk.i(++n));
        return true;
    }
    
    private boolean E(final Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }
    
    private void G() {
        final int m = this.M(this.x.C(), this.F - 1);
        while (true) {
            final int f = this.F;
            if (f > m) {
                break;
            }
            this.F = f + 1;
            this.H(f);
        }
    }
    
    private void H(final int n) {
        final BaseMediaChunk baseMediaChunk = this.p.get(n);
        final Format d = baseMediaChunk.d;
        if (!d.equals(this.B)) {
            this.g.i(this.a, d, baseMediaChunk.e, baseMediaChunk.f, baseMediaChunk.g);
        }
        this.B = d;
    }
    
    private int M(final int n, int n2) {
        int n3;
        do {
            n3 = n2 + 1;
            if (n3 >= this.p.size()) {
                return this.p.size() - 1;
            }
            n2 = n3;
        } while (this.p.get(n3).i(0) <= n);
        return n3 - 1;
    }
    
    private void P() {
        this.x.V();
        final SampleQueue[] y = this.y;
        for (int length = y.length, i = 0; i < length; ++i) {
            y[i].V();
        }
    }
    
    static BaseMediaChunk o(final ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.G;
    }
    
    static boolean[] r(final ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.d;
    }
    
    static int[] s(final ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.b;
    }
    
    static Format[] t(final ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.c;
    }
    
    static long u(final ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.E;
    }
    
    static MediaSourceEventListener.EventDispatcher w(final ChunkSampleStream chunkSampleStream) {
        return chunkSampleStream.g;
    }
    
    private void x(int min) {
        min = Math.min(this.M(min, 0), this.F);
        if (min > 0) {
            Util.N0(this.p, 0, min);
            this.F -= min;
        }
    }
    
    private void y(int i) {
        Assertions.g(this.i.j() ^ true);
        while (true) {
            while (i < this.p.size()) {
                if (!this.D(i)) {
                    if (i == -1) {
                        return;
                    }
                    final long h = this.C().h;
                    final BaseMediaChunk z = this.z(i);
                    if (this.p.isEmpty()) {
                        this.D = this.E;
                    }
                    this.H = false;
                    this.g.D(this.a, z.g, h);
                    return;
                }
                else {
                    ++i;
                }
            }
            i = -1;
            continue;
        }
    }
    
    private BaseMediaChunk z(int n) {
        final BaseMediaChunk baseMediaChunk = this.p.get(n);
        final ArrayList<BaseMediaChunk> p = this.p;
        Util.N0((List<Object>)p, n, p.size());
        this.F = Math.max(this.F, this.p.size());
        final SampleQueue x = this.x;
        n = 0;
        x.u(baseMediaChunk.i(0));
        while (true) {
            final SampleQueue[] y = this.y;
            if (n >= y.length) {
                break;
            }
            final SampleQueue sampleQueue = y[n];
            ++n;
            sampleQueue.u(baseMediaChunk.i(n));
        }
        return baseMediaChunk;
    }
    
    @Override
    public /* bridge */ void A(final Loadable loadable, final long n, final long n2) {
        this.J((Chunk)loadable, n, n2);
    }
    
    public T B() {
        return this.e;
    }
    
    boolean F() {
        return this.D != -9223372036854775807L;
    }
    
    public void I(final Chunk chunk, final long n, final long n2, final boolean b) {
        this.A = null;
        this.G = null;
        final LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), n, n2, chunk.b());
        this.h.d(chunk.a);
        this.g.r(loadEventInfo, chunk.c, this.a, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h);
        if (!b) {
            if (this.F()) {
                this.P();
            }
            else if (this.E(chunk)) {
                this.z(this.p.size() - 1);
                if (this.p.isEmpty()) {
                    this.D = this.E;
                }
            }
            this.f.l(this);
        }
    }
    
    public void J(final Chunk chunk, final long n, final long n2) {
        this.A = null;
        this.e.f(chunk);
        final LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), n, n2, chunk.b());
        this.h.d(chunk.a);
        this.g.u(loadEventInfo, chunk.c, this.a, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h);
        this.f.l(this);
    }
    
    public LoadErrorAction K(final Chunk chunk, long a, final long n, final IOException ex, final int n2) {
        final long b = chunk.b();
        final boolean e = this.E(chunk);
        final int n3 = this.p.size() - 1;
        final boolean b2 = b == 0L || !e || !this.D(n3);
        final LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), a, n, b);
        final LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(chunk.c, this.a, chunk.d, chunk.e, chunk.f, Util.f1(chunk.g), Util.f1(chunk.h)), ex, n2);
        LoadErrorAction f = null;
        Label_0247: {
            if (this.e.g(chunk, b2, loadErrorInfo, this.h)) {
                if (b2) {
                    final Loader.LoadErrorAction loadErrorAction = f = Loader.f;
                    if (!e) {
                        break Label_0247;
                    }
                    Assertions.g(this.z(n3) == chunk);
                    f = loadErrorAction;
                    if (this.p.isEmpty()) {
                        this.D = this.E;
                        f = loadErrorAction;
                    }
                    break Label_0247;
                }
                else {
                    Log.i("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
                }
            }
            f = null;
        }
        Loader.LoadErrorAction loadErrorAction2;
        if ((loadErrorAction2 = f) == null) {
            a = this.h.a(loadErrorInfo);
            if (a != -9223372036854775807L) {
                loadErrorAction2 = Loader.h(false, a);
            }
            else {
                loadErrorAction2 = Loader.g;
            }
        }
        final boolean b3 = loadErrorAction2.c() ^ true;
        this.g.w(loadEventInfo, chunk.c, this.a, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h, ex, b3);
        if (b3) {
            this.A = null;
            this.h.d(chunk.a);
            this.f.l(this);
        }
        return loadErrorAction2;
    }
    
    @Override
    public /* bridge */ LoadErrorAction L(final Loadable loadable, final long n, final long n2, final IOException ex, final int n3) {
        return this.K((Chunk)loadable, n, n2, ex, n3);
    }
    
    public void N() {
        this.O(null);
    }
    
    public void O(final ReleaseCallback<T> c) {
        this.C = c;
        this.x.R();
        final SampleQueue[] y = this.y;
        for (int length = y.length, i = 0; i < length; ++i) {
            y[i].R();
        }
        this.i.m((Loader.ReleaseCallback)this);
    }
    
    public void Q(final long d) {
        this.E = d;
        if (this.F()) {
            this.D = d;
            return;
        }
        final BaseMediaChunk baseMediaChunk = null;
        final int n = 0;
        final int n2 = 0;
        int n3 = 0;
        BaseMediaChunk baseMediaChunk2;
        while (true) {
            baseMediaChunk2 = baseMediaChunk;
            if (n3 >= this.p.size()) {
                break;
            }
            baseMediaChunk2 = this.p.get(n3);
            final long n4 = lcmp(baseMediaChunk2.g, d);
            if (n4 == 0 && baseMediaChunk2.k == -9223372036854775807L) {
                break;
            }
            if (n4 > 0) {
                baseMediaChunk2 = baseMediaChunk;
                break;
            }
            ++n3;
        }
        boolean b;
        if (baseMediaChunk2 != null) {
            b = this.x.Y(baseMediaChunk2.i(0));
        }
        else {
            b = this.x.Z(d, d < this.b());
        }
        if (b) {
            this.F = this.M(this.x.C(), 0);
            final SampleQueue[] y = this.y;
            for (int length = y.length, i = n2; i < length; ++i) {
                y[i].Z(d, true);
            }
        }
        else {
            this.D = d;
            this.H = false;
            this.p.clear();
            this.F = 0;
            if (this.i.j()) {
                this.x.r();
                final SampleQueue[] y2 = this.y;
                for (int length2 = y2.length, j = n; j < length2; ++j) {
                    y2[j].r();
                }
                this.i.f();
            }
            else {
                this.i.g();
                this.P();
            }
        }
    }
    
    public EmbeddedSampleStream R(final long n, final int n2) {
        for (int i = 0; i < this.y.length; ++i) {
            if (this.b[i] == n2) {
                Assertions.g(this.d[i] ^ true);
                this.d[i] = true;
                this.y[i].Z(n, true);
                return new EmbeddedSampleStream(this, this.y[i], i);
            }
        }
        throw new IllegalStateException();
    }
    
    @Override
    public void a() throws IOException {
        this.i.a();
        this.x.N();
        if (!this.i.j()) {
            this.e.a();
        }
    }
    
    @Override
    public long b() {
        if (this.F()) {
            return this.D;
        }
        long h;
        if (this.H) {
            h = Long.MIN_VALUE;
        }
        else {
            h = this.C().h;
        }
        return h;
    }
    
    public long c(final long n, final SeekParameters seekParameters) {
        return this.e.c(n, seekParameters);
    }
    
    @Override
    public boolean d(long n) {
        final boolean h = this.H;
        int i = 0;
        if (h || this.i.j() || this.i.i()) {
            return false;
        }
        final boolean f = this.F();
        Object o;
        long n2;
        if (f) {
            o = Collections.emptyList();
            n2 = this.D;
        }
        else {
            o = this.w;
            n2 = this.C().h;
        }
        this.e.j(n, n2, (List<? extends MediaChunk>)o, this.j);
        final ChunkHolder j = this.j;
        final boolean b = j.b;
        final Chunk a = j.a;
        j.a();
        if (b) {
            this.D = -9223372036854775807L;
            return this.H = true;
        }
        if (a == null) {
            return false;
        }
        this.A = a;
        if (this.E(a)) {
            final BaseMediaChunk baseMediaChunk = (BaseMediaChunk)a;
            if (f) {
                final long g = baseMediaChunk.g;
                n = this.D;
                if (g != n) {
                    this.x.b0(n);
                    for (SampleQueue[] y = this.y; i < y.length; ++i) {
                        y[i].b0(this.D);
                    }
                }
                this.D = -9223372036854775807L;
            }
            baseMediaChunk.k(this.z);
            this.p.add(baseMediaChunk);
        }
        else if (a instanceof InitializationChunk) {
            ((InitializationChunk)a).g(this.z);
        }
        n = this.i.n(a, (Loader.Callback<?>)this, this.h.b(a.c));
        this.g.A(new LoadEventInfo(a.a, a.b, n), a.c, this.a, a.d, a.e, a.f, a.g, a.h);
        return true;
    }
    
    @Override
    public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
        if (this.F()) {
            return -3;
        }
        final BaseMediaChunk g = this.G;
        if (g != null && g.i(0) <= this.x.C()) {
            return -3;
        }
        this.G();
        return this.x.S(formatHolder, decoderInputBuffer, n, this.H);
    }
    
    @Override
    public long f() {
        if (this.H) {
            return Long.MIN_VALUE;
        }
        if (this.F()) {
            return this.D;
        }
        final long e = this.E;
        BaseMediaChunk c = this.C();
        if (!c.h()) {
            if (this.p.size() > 1) {
                final ArrayList<BaseMediaChunk> p = this.p;
                c = p.get(p.size() - 2);
            }
            else {
                c = null;
            }
        }
        long max = e;
        if (c != null) {
            max = Math.max(e, c.h);
        }
        return Math.max(max, this.x.z());
    }
    
    @Override
    public void g(final long n) {
        if (!this.i.i()) {
            if (!this.F()) {
                if (this.i.j()) {
                    final Chunk chunk = Assertions.e(this.A);
                    if (this.E(chunk) && this.D(this.p.size() - 1)) {
                        return;
                    }
                    if (this.e.d(n, chunk, this.w)) {
                        this.i.f();
                        if (this.E(chunk)) {
                            this.G = (BaseMediaChunk)chunk;
                        }
                    }
                }
                else {
                    final int i = this.e.i(n, this.w);
                    if (i < this.p.size()) {
                        this.y(i);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean isLoading() {
        return this.i.j();
    }
    
    @Override
    public boolean isReady() {
        return !this.F() && this.x.K(this.H);
    }
    
    @Override
    public int l(final long n) {
        if (this.F()) {
            return 0;
        }
        final int e = this.x.E(n, this.H);
        final BaseMediaChunk g = this.G;
        int min = e;
        if (g != null) {
            min = Math.min(e, g.i(0) - this.x.C());
        }
        this.x.e0(min);
        this.G();
        return min;
    }
    
    @Override
    public void m() {
        this.x.T();
        final SampleQueue[] y = this.y;
        for (int length = y.length, i = 0; i < length; ++i) {
            y[i].T();
        }
        this.e.release();
        final ReleaseCallback<T> c = this.C;
        if (c != null) {
            c.a(this);
        }
    }
    
    public void q(long y, final boolean b) {
        if (this.F()) {
            return;
        }
        final int x = this.x.x();
        this.x.q(y, b, true);
        final int x2 = this.x.x();
        if (x2 > x) {
            y = this.x.y();
            int n = 0;
            while (true) {
                final SampleQueue[] y2 = this.y;
                if (n >= y2.length) {
                    break;
                }
                y2[n].q(y, b, this.d[n]);
                ++n;
            }
        }
        this.x(x2);
    }
    
    @Override
    public /* bridge */ void v(final Loadable loadable, final long n, final long n2, final boolean b) {
        this.I((Chunk)loadable, n, n2, b);
    }
    
    public final class EmbeddedSampleStream implements SampleStream
    {
        public final ChunkSampleStream<T> a;
        private final SampleQueue b;
        private final int c;
        private boolean d;
        final ChunkSampleStream e;
        
        public EmbeddedSampleStream(final ChunkSampleStream e, final ChunkSampleStream<T> a, final SampleQueue b, final int c) {
            this.e = e;
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        private void b() {
            if (!this.d) {
                ChunkSampleStream.w(this.e).i(ChunkSampleStream.s(this.e)[this.c], ChunkSampleStream.t(this.e)[this.c], 0, null, ChunkSampleStream.u(this.e));
                this.d = true;
            }
        }
        
        @Override
        public void a() {
        }
        
        public void c() {
            Assertions.g(ChunkSampleStream.r(this.e)[this.c]);
            ChunkSampleStream.r(this.e)[this.c] = false;
        }
        
        @Override
        public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
            if (this.e.F()) {
                return -3;
            }
            if (ChunkSampleStream.o(this.e) != null && ChunkSampleStream.o(this.e).i(this.c + 1) <= this.b.C()) {
                return -3;
            }
            this.b();
            return this.b.S(formatHolder, decoderInputBuffer, n, this.e.H);
        }
        
        @Override
        public boolean isReady() {
            return !this.e.F() && this.b.K(this.e.H);
        }
        
        @Override
        public int l(final long n) {
            if (this.e.F()) {
                return 0;
            }
            int n3;
            final int n2 = n3 = this.b.E(n, this.e.H);
            if (ChunkSampleStream.o(this.e) != null) {
                n3 = Math.min(n2, ChunkSampleStream.o(this.e).i(this.c + 1) - this.b.C());
            }
            this.b.e0(n3);
            if (n3 > 0) {
                this.b();
            }
            return n3;
        }
    }
    
    public interface ReleaseCallback<T extends ChunkSource>
    {
        void a(final ChunkSampleStream<T> p0);
    }
}
