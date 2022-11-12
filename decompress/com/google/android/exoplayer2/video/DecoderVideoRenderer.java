// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.util.Util;
import android.media.MediaFormat;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ExoPlaybackException;
import android.os.SystemClock;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DrmSession;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.BaseRenderer;

public abstract class DecoderVideoRenderer extends BaseRenderer
{
    private final VideoRendererEventListener.EventDispatcher A;
    private final TimedValueQueue<Format> B;
    private final DecoderInputBuffer C;
    private Format D;
    private Format E;
    private Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> F;
    private DecoderInputBuffer G;
    private VideoDecoderOutputBuffer H;
    private int I;
    private Object J;
    private Surface K;
    private VideoDecoderOutputBufferRenderer L;
    private VideoFrameMetadataListener M;
    private DrmSession N;
    private DrmSession O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private long U;
    private long V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private VideoSize Z;
    private long a0;
    private int b0;
    private int c0;
    private int d0;
    private long e0;
    private long f0;
    protected DecoderCounters g0;
    private final long y;
    private final int z;
    
    private void B0() {
        long v;
        if (this.y > 0L) {
            v = SystemClock.elapsedRealtime() + this.y;
        }
        else {
            v = -9223372036854775807L;
        }
        this.V = v;
    }
    
    private void D0(final DrmSession o) {
        DrmSession.g(this.O, o);
        this.O = o;
    }
    
    private void Y() {
        this.R = false;
    }
    
    private void Z() {
        this.Z = null;
    }
    
    private boolean b0(final long n, final long n2) throws ExoPlaybackException, DecoderException {
        if (this.H == null) {
            final VideoDecoderOutputBuffer h = (VideoDecoderOutputBuffer)this.F.b();
            if ((this.H = h) == null) {
                return false;
            }
            final DecoderCounters g0 = this.g0;
            final int f = g0.f;
            final int c = h.c;
            g0.f = f + c;
            this.d0 -= c;
        }
        if (this.H.n()) {
            if (this.P == 2) {
                this.w0();
                this.j0();
            }
            else {
                this.H.r();
                this.H = null;
                this.Y = true;
            }
            return false;
        }
        final boolean v0 = this.v0(n, n2);
        if (v0) {
            this.t0(this.H.b);
            this.H = null;
        }
        return v0;
    }
    
    private boolean d0() throws DecoderException, ExoPlaybackException {
        final Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> f = this.F;
        if (f == null || this.P == 2 || this.X) {
            return false;
        }
        if (this.G == null && (this.G = f.d()) == null) {
            return false;
        }
        if (this.P == 1) {
            this.G.q(4);
            this.F.c(this.G);
            this.G = null;
            this.P = 2;
            return false;
        }
        final FormatHolder i = this.I();
        final int u = this.U(i, this.G, 0);
        if (u == -5) {
            this.p0(i);
            return true;
        }
        if (u != -4) {
            if (u == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        else {
            if (this.G.n()) {
                this.X = true;
                this.F.c(this.G);
                this.G = null;
                return false;
            }
            if (this.W) {
                this.B.a(this.G.f, this.D);
                this.W = false;
            }
            this.G.t();
            final DecoderInputBuffer g = this.G;
            g.b = this.D;
            this.u0(g);
            this.F.c(this.G);
            ++this.d0;
            this.Q = true;
            final DecoderCounters g2 = this.g0;
            ++g2.c;
            this.G = null;
            return true;
        }
    }
    
    private boolean f0() {
        return this.I != -1;
    }
    
    private static boolean g0(final long n) {
        return n < -30000L;
    }
    
    private static boolean h0(final long n) {
        return n < -500000L;
    }
    
    private void j0() throws ExoPlaybackException {
        if (this.F != null) {
            return;
        }
        this.z0(this.O);
        CryptoConfig cryptoConfig = null;
        final DrmSession n = this.N;
        if (n != null) {
            final CryptoConfig f = n.f();
            if ((cryptoConfig = f) == null) {
                if (this.N.a() == null) {
                    return;
                }
                cryptoConfig = f;
            }
        }
        try {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.F = this.a0(this.D, cryptoConfig);
            this.A0(this.I);
            final long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.A.k(this.F.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            final DecoderCounters g0 = this.g0;
            ++g0.a;
        }
        catch (final OutOfMemoryError outOfMemoryError) {
            throw this.F(outOfMemoryError, this.D, 4001);
        }
        catch (final DecoderException ex) {
            Log.d("DecoderVideoRenderer", "Video codec error", ex);
            this.A.C(ex);
            throw this.F(ex, this.D, 4001);
        }
    }
    
    private void k0() {
        if (this.b0 > 0) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.A.n(this.b0, elapsedRealtime - this.a0);
            this.b0 = 0;
            this.a0 = elapsedRealtime;
        }
    }
    
    private void l0() {
        this.T = true;
        if (!this.R) {
            this.R = true;
            this.A.A(this.J);
        }
    }
    
    private void m0(final int n, final int n2) {
        final VideoSize z = this.Z;
        if (z == null || z.a != n || z.b != n2) {
            final VideoSize z2 = new VideoSize(n, n2);
            this.Z = z2;
            this.A.D(z2);
        }
    }
    
    private void n0() {
        if (this.R) {
            this.A.A(this.J);
        }
    }
    
    private void o0() {
        final VideoSize z = this.Z;
        if (z != null) {
            this.A.D(z);
        }
    }
    
    private void q0() {
        this.o0();
        this.Y();
        if (this.getState() == 2) {
            this.B0();
        }
    }
    
    private void r0() {
        this.Z();
        this.Y();
    }
    
    private void s0() {
        this.o0();
        this.n0();
    }
    
    private boolean v0(final long u, final long n) throws ExoPlaybackException, DecoderException {
        if (this.U == -9223372036854775807L) {
            this.U = u;
        }
        final long n2 = this.H.b - u;
        if (!this.f0()) {
            if (g0(n2)) {
                this.H0(this.H);
                return true;
            }
            return false;
        }
        else {
            final long n3 = this.H.b - this.f0;
            final Format e = this.B.j(n3);
            if (e != null) {
                this.E = e;
            }
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            final long e2 = this.e0;
            final boolean b = this.getState() == 2;
            boolean b2 = false;
            Label_0159: {
                Label_0156: {
                    if (!this.T) {
                        if (!b) {
                            if (!this.S) {
                                break Label_0156;
                            }
                        }
                    }
                    else if (this.R) {
                        break Label_0156;
                    }
                    b2 = true;
                    break Label_0159;
                }
                b2 = false;
            }
            if (!b2 && (!b || !this.G0(n2, elapsedRealtime * 1000L - e2))) {
                if (b) {
                    if (u != this.U) {
                        if (this.E0(n2, n) && this.i0(u)) {
                            return false;
                        }
                        if (this.F0(n2, n)) {
                            this.c0(this.H);
                            return true;
                        }
                        if (n2 < 30000L) {
                            this.x0(this.H, n3, this.E);
                            return true;
                        }
                    }
                }
                return false;
            }
            this.x0(this.H, n3, this.E);
            return true;
        }
    }
    
    private void z0(final DrmSession n) {
        DrmSession.g(this.N, n);
        this.N = n;
    }
    
    @Override
    public void A(final long n, final long n2) throws ExoPlaybackException {
        if (this.Y) {
            return;
        }
        if (this.D == null) {
            final FormatHolder i = this.I();
            this.C.h();
            final int u = this.U(i, this.C, 2);
            if (u != -5) {
                if (u == -4) {
                    Assertions.g(this.C.n());
                    this.X = true;
                    this.Y = true;
                }
                return;
            }
            this.p0(i);
        }
        this.j0();
        if (this.F != null) {
            try {
                TraceUtil.a("drainAndFeed");
                while (this.b0(n, n2)) {}
                while (this.d0()) {}
                TraceUtil.c();
                this.g0.c();
            }
            catch (final DecoderException ex) {
                Log.d("DecoderVideoRenderer", "Video codec error", ex);
                this.A.C(ex);
                throw this.F(ex, this.D, 4003);
            }
        }
    }
    
    protected abstract void A0(final int p0);
    
    protected final void C0(Object j) {
        if (j instanceof Surface) {
            this.K = (Surface)j;
            this.L = null;
            this.I = 1;
        }
        else if (j instanceof VideoDecoderOutputBufferRenderer) {
            this.K = null;
            this.L = (VideoDecoderOutputBufferRenderer)j;
            this.I = 0;
        }
        else {
            this.K = null;
            this.L = null;
            this.I = -1;
            j = null;
        }
        if (this.J != j) {
            if ((this.J = j) != null) {
                if (this.F != null) {
                    this.A0(this.I);
                }
                this.q0();
            }
            else {
                this.r0();
            }
        }
        else if (j != null) {
            this.s0();
        }
    }
    
    protected boolean E0(final long n, final long n2) {
        return h0(n);
    }
    
    protected boolean F0(final long n, final long n2) {
        return g0(n);
    }
    
    protected boolean G0(final long n, final long n2) {
        return g0(n) && n2 > 100000L;
    }
    
    protected void H0(final VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        final DecoderCounters g0 = this.g0;
        ++g0.f;
        videoDecoderOutputBuffer.r();
    }
    
    protected void I0(int z, final int n) {
        final DecoderCounters g0 = this.g0;
        g0.h += z;
        z += n;
        g0.g += z;
        this.b0 += z;
        z += this.c0;
        this.c0 = z;
        g0.i = Math.max(z, g0.i);
        z = this.z;
        if (z > 0 && this.b0 >= z) {
            this.k0();
        }
    }
    
    @Override
    protected void N() {
        this.D = null;
        this.Z();
        this.Y();
        try {
            this.D0(null);
            this.w0();
        }
        finally {
            this.A.m(this.g0);
        }
    }
    
    @Override
    protected void O(final boolean b, final boolean s) throws ExoPlaybackException {
        final DecoderCounters g0 = new DecoderCounters();
        this.g0 = g0;
        this.A.o(g0);
        this.S = s;
        this.T = false;
    }
    
    @Override
    protected void P(final long n, final boolean b) throws ExoPlaybackException {
        this.X = false;
        this.Y = false;
        this.Y();
        this.U = -9223372036854775807L;
        this.c0 = 0;
        if (this.F != null) {
            this.e0();
        }
        if (b) {
            this.B0();
        }
        else {
            this.V = -9223372036854775807L;
        }
        this.B.c();
    }
    
    @Override
    protected void R() {
        this.b0 = 0;
        this.a0 = SystemClock.elapsedRealtime();
        this.e0 = SystemClock.elapsedRealtime() * 1000L;
    }
    
    @Override
    protected void S() {
        this.V = -9223372036854775807L;
        this.k0();
    }
    
    @Override
    protected void T(final Format[] array, final long n, final long f0) throws ExoPlaybackException {
        super.T(array, n, this.f0 = f0);
    }
    
    protected DecoderReuseEvaluation X(final String s, final Format format, final Format format2) {
        return new DecoderReuseEvaluation(s, format, format2, 0, 1);
    }
    
    protected abstract Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> a0(final Format p0, final CryptoConfig p1) throws DecoderException;
    
    @Override
    public boolean c() {
        return this.Y;
    }
    
    protected void c0(final VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.I0(0, 1);
        videoDecoderOutputBuffer.r();
    }
    
    protected void e0() throws ExoPlaybackException {
        this.d0 = 0;
        if (this.P != 0) {
            this.w0();
            this.j0();
        }
        else {
            this.G = null;
            final VideoDecoderOutputBuffer h = this.H;
            if (h != null) {
                h.r();
                this.H = null;
            }
            this.F.flush();
            this.Q = false;
        }
    }
    
    protected boolean i0(final long n) throws ExoPlaybackException {
        final int w = this.W(n);
        if (w == 0) {
            return false;
        }
        final DecoderCounters g0 = this.g0;
        ++g0.j;
        this.I0(w, this.d0);
        this.e0();
        return true;
    }
    
    @Override
    public boolean isReady() {
        if (this.D != null && (this.M() || this.H != null) && (this.R || !this.f0())) {
            this.V = -9223372036854775807L;
            return true;
        }
        if (this.V == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.V) {
            return true;
        }
        this.V = -9223372036854775807L;
        return false;
    }
    
    @Override
    public void p(final int n, final Object o) throws ExoPlaybackException {
        if (n == 1) {
            this.C0(o);
        }
        else if (n == 7) {
            this.M = (VideoFrameMetadataListener)o;
        }
        else {
            super.p(n, o);
        }
    }
    
    protected void p0(final FormatHolder formatHolder) throws ExoPlaybackException {
        this.W = true;
        final Format d = Assertions.e(formatHolder.b);
        this.D0(formatHolder.a);
        final Format d2 = this.D;
        this.D = d;
        final Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> f = this.F;
        if (f == null) {
            this.j0();
            this.A.p(this.D, null);
            return;
        }
        DecoderReuseEvaluation x;
        if (this.O != this.N) {
            x = new DecoderReuseEvaluation(f.getName(), d2, d, 0, 128);
        }
        else {
            x = this.X(f.getName(), d2, d);
        }
        if (x.d == 0) {
            if (this.Q) {
                this.P = 1;
            }
            else {
                this.w0();
                this.j0();
            }
        }
        this.A.p(this.D, x);
    }
    
    protected void t0(final long n) {
        --this.d0;
    }
    
    protected void u0(final DecoderInputBuffer decoderInputBuffer) {
    }
    
    protected void w0() {
        this.G = null;
        this.H = null;
        this.P = 0;
        this.Q = false;
        this.d0 = 0;
        final Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> f = this.F;
        if (f != null) {
            final DecoderCounters g0 = this.g0;
            ++g0.b;
            f.release();
            this.A.l(this.F.getName());
            this.F = null;
        }
        this.z0(null);
    }
    
    protected void x0(final VideoDecoderOutputBuffer outputBuffer, final long n, final Format format) throws DecoderException {
        final VideoFrameMetadataListener m = this.M;
        if (m != null) {
            m.a(n, System.nanoTime(), format, null);
        }
        this.e0 = Util.C0(SystemClock.elapsedRealtime() * 1000L);
        final int d = outputBuffer.d;
        final boolean b = d == 1 && this.K != null;
        final boolean b2 = d == 0 && this.L != null;
        if (!b2 && !b) {
            this.c0(outputBuffer);
        }
        else {
            this.m0(outputBuffer.e, outputBuffer.f);
            if (b2) {
                this.L.setOutputBuffer(outputBuffer);
            }
            else {
                this.y0(outputBuffer, this.K);
            }
            this.c0 = 0;
            final DecoderCounters g0 = this.g0;
            ++g0.e;
            this.l0();
        }
    }
    
    protected abstract void y0(final VideoDecoderOutputBuffer p0, final Surface p1) throws DecoderException;
}
