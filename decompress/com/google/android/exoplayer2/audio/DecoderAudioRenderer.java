// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import android.os.SystemClock;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.common.base.MoreObjects;
import android.os.Handler;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.SimpleDecoderOutputBuffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.Decoder;

public abstract class DecoderAudioRenderer<T extends Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException>> extends BaseRenderer implements MediaClock
{
    private final DecoderInputBuffer A;
    private DecoderCounters B;
    private Format C;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private T H;
    private DecoderInputBuffer I;
    private SimpleDecoderOutputBuffer J;
    private DrmSession K;
    private DrmSession L;
    private int M;
    private boolean N;
    private boolean O;
    private long P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private final AudioRendererEventListener.EventDispatcher y;
    private final AudioSink z;
    
    public DecoderAudioRenderer() {
        this(null, null, new AudioProcessor[0]);
    }
    
    public DecoderAudioRenderer(final Handler handler, final AudioRendererEventListener audioRendererEventListener, final AudioCapabilities audioCapabilities, final AudioProcessor... array) {
        this(handler, audioRendererEventListener, new DefaultAudioSink.Builder().g((AudioCapabilities)MoreObjects.a((Object)audioCapabilities, (Object)AudioCapabilities.c)).i(array).f());
    }
    
    public DecoderAudioRenderer(final Handler handler, final AudioRendererEventListener audioRendererEventListener, final AudioSink z) {
        super(1);
        this.y = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        (this.z = z).k((AudioSink.Listener)new b(null));
        this.A = DecoderInputBuffer.w();
        this.M = 0;
        this.O = true;
    }
    
    public DecoderAudioRenderer(final Handler handler, final AudioRendererEventListener audioRendererEventListener, final AudioProcessor... array) {
        this(handler, audioRendererEventListener, (AudioCapabilities)null, array);
    }
    
    static AudioRendererEventListener.EventDispatcher X(final DecoderAudioRenderer decoderAudioRenderer) {
        return decoderAudioRenderer.y;
    }
    
    private boolean a0() throws ExoPlaybackException, DecoderException, AudioSink.ConfigurationException, AudioSink.InitializationException, AudioSink.WriteException {
        if (this.J == null) {
            final SimpleDecoderOutputBuffer j = ((Decoder<I, SimpleDecoderOutputBuffer, E>)this.H).b();
            if ((this.J = j) == null) {
                return false;
            }
            final int c = j.c;
            if (c > 0) {
                final DecoderCounters b = this.B;
                b.f += c;
                this.z.q();
            }
            if (this.J.o()) {
                this.z.q();
            }
        }
        if (this.J.n()) {
            if (this.M == 2) {
                this.j0();
                this.e0();
                this.O = true;
                return false;
            }
            this.J.r();
            this.J = null;
            try {
                this.i0();
                return false;
            }
            catch (final AudioSink.WriteException ex) {
                throw this.G(ex, ex.format, ex.isRecoverable, 5002);
            }
        }
        if (this.O) {
            this.z.s(this.d0(this.H).b().N(this.D).O(this.E).E(), 0, null);
            this.O = false;
        }
        final AudioSink z = this.z;
        final SimpleDecoderOutputBuffer i = this.J;
        if (z.j(i.e, i.b, 1)) {
            final DecoderCounters b2 = this.B;
            ++b2.e;
            this.J.r();
            this.J = null;
            return true;
        }
        return false;
    }
    
    private boolean b0() throws DecoderException, ExoPlaybackException {
        final Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException> h = this.H;
        if (h == null || this.M == 2 || this.S) {
            return false;
        }
        if (this.I == null && (this.I = h.d()) == null) {
            return false;
        }
        if (this.M == 1) {
            this.I.q(4);
            ((Decoder<DecoderInputBuffer, O, E>)this.H).c(this.I);
            this.I = null;
            this.M = 2;
            return false;
        }
        final FormatHolder i = this.I();
        final int u = this.U(i, this.I, 0);
        if (u == -5) {
            this.f0(i);
            return true;
        }
        if (u != -4) {
            if (u == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        else {
            if (this.I.n()) {
                this.S = true;
                ((Decoder<DecoderInputBuffer, O, E>)this.H).c(this.I);
                this.I = null;
                return false;
            }
            if (!this.G) {
                this.G = true;
                this.I.g(134217728);
            }
            this.I.t();
            final DecoderInputBuffer j = this.I;
            j.b = this.C;
            this.h0(j);
            ((Decoder<DecoderInputBuffer, O, E>)this.H).c(this.I);
            this.N = true;
            final DecoderCounters b = this.B;
            ++b.c;
            this.I = null;
            return true;
        }
    }
    
    private void c0() throws ExoPlaybackException {
        if (this.M != 0) {
            this.j0();
            this.e0();
        }
        else {
            this.I = null;
            final SimpleDecoderOutputBuffer j = this.J;
            if (j != null) {
                j.r();
                this.J = null;
            }
            this.H.flush();
            this.N = false;
        }
    }
    
    private void e0() throws ExoPlaybackException {
        if (this.H != null) {
            return;
        }
        this.k0(this.L);
        CryptoConfig cryptoConfig = null;
        final DrmSession k = this.K;
        if (k != null) {
            final CryptoConfig f = k.f();
            if ((cryptoConfig = f) == null) {
                if (this.K.a() == null) {
                    return;
                }
                cryptoConfig = f;
            }
        }
        try {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            TraceUtil.a("createAudioDecoder");
            this.H = this.Z(this.C, cryptoConfig);
            TraceUtil.c();
            final long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.y.m(this.H.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            final DecoderCounters b = this.B;
            ++b.a;
        }
        catch (final OutOfMemoryError outOfMemoryError) {
            throw this.F(outOfMemoryError, this.C, 4001);
        }
        catch (final DecoderException ex) {
            Log.d("DecoderAudioRenderer", "Audio codec error", ex);
            this.y.k(ex);
            throw this.F(ex, this.C, 4001);
        }
    }
    
    private void f0(final FormatHolder formatHolder) throws ExoPlaybackException {
        final Format c = Assertions.e(formatHolder.b);
        this.l0(formatHolder.a);
        final Format c2 = this.C;
        this.C = c;
        this.D = c.M;
        this.E = c.N;
        final Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException> h = this.H;
        if (h == null) {
            this.e0();
            this.y.q(this.C, null);
            return;
        }
        DecoderReuseEvaluation y;
        if (this.L != this.K) {
            y = new DecoderReuseEvaluation(h.getName(), c2, c, 0, 128);
        }
        else {
            y = this.Y(h.getName(), c2, c);
        }
        if (y.d == 0) {
            if (this.N) {
                this.M = 1;
            }
            else {
                this.j0();
                this.e0();
                this.O = true;
            }
        }
        this.y.q(this.C, y);
    }
    
    private void i0() throws AudioSink.WriteException {
        this.T = true;
        this.z.o();
    }
    
    private void j0() {
        this.I = null;
        this.J = null;
        this.M = 0;
        this.N = false;
        final Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException> h = this.H;
        if (h != null) {
            final DecoderCounters b = this.B;
            ++b.b;
            h.release();
            this.y.n(this.H.getName());
            this.H = null;
        }
        this.k0(null);
    }
    
    private void k0(final DrmSession k) {
        DrmSession.g(this.K, k);
        this.K = k;
    }
    
    private void l0(final DrmSession l) {
        DrmSession.g(this.L, l);
        this.L = l;
    }
    
    private void n0() {
        long p = this.z.p(this.c());
        if (p != Long.MIN_VALUE) {
            if (!this.R) {
                p = Math.max(this.P, p);
            }
            this.P = p;
            this.R = false;
        }
    }
    
    @Override
    public void A(final long n, final long n2) throws ExoPlaybackException {
        if (this.T) {
            try {
                this.z.o();
                return;
            }
            catch (final AudioSink.WriteException ex) {
                throw this.G(ex, ex.format, ex.isRecoverable, 5002);
            }
        }
        if (this.C == null) {
            final FormatHolder i = this.I();
            this.A.h();
            final int u = this.U(i, this.A, 2);
            if (u != -5) {
                if (u == -4) {
                    Assertions.g(this.A.n());
                    this.S = true;
                    try {
                        this.i0();
                    }
                    catch (final AudioSink.WriteException ex2) {
                        throw this.F(ex2, null, 5002);
                    }
                }
                return;
            }
            this.f0(i);
        }
        this.e0();
        if (this.H != null) {
            try {
                TraceUtil.a("drainAndFeed");
                while (this.a0()) {}
                while (this.b0()) {}
                TraceUtil.c();
                this.B.c();
            }
            catch (final AudioSink.WriteException ex3) {
                throw this.G(ex3, ex3.format, ex3.isRecoverable, 5002);
            }
            catch (final AudioSink.InitializationException ex4) {
                throw this.G(ex4, ex4.format, ex4.isRecoverable, 5001);
            }
            catch (final AudioSink.ConfigurationException ex5) {
                throw this.F(ex5, ex5.format, 5001);
            }
            catch (final DecoderException ex6) {
                Log.d("DecoderAudioRenderer", "Audio codec error", ex6);
                this.y.k(ex6);
                throw this.F(ex6, this.C, 4003);
            }
        }
    }
    
    @Override
    public MediaClock D() {
        return this;
    }
    
    @Override
    protected void N() {
        this.C = null;
        this.O = true;
        try {
            this.l0(null);
            this.j0();
            this.z.reset();
        }
        finally {
            this.y.o(this.B);
        }
    }
    
    @Override
    protected void O(final boolean b, final boolean b2) throws ExoPlaybackException {
        final DecoderCounters b3 = new DecoderCounters();
        this.B = b3;
        this.y.p(b3);
        if (this.H().a) {
            this.z.r();
        }
        else {
            this.z.g();
        }
        this.z.i(this.K());
    }
    
    @Override
    protected void P(final long p2, final boolean b) throws ExoPlaybackException {
        if (this.F) {
            this.z.m();
        }
        else {
            this.z.flush();
        }
        this.P = p2;
        this.Q = true;
        this.R = true;
        this.S = false;
        this.T = false;
        if (this.H != null) {
            this.c0();
        }
    }
    
    @Override
    protected void R() {
        this.z.play();
    }
    
    @Override
    protected void S() {
        this.n0();
        this.z.pause();
    }
    
    @Override
    protected void T(final Format[] array, final long n, final long n2) throws ExoPlaybackException {
        super.T(array, n, n2);
        this.G = false;
    }
    
    protected DecoderReuseEvaluation Y(final String s, final Format format, final Format format2) {
        return new DecoderReuseEvaluation(s, format, format2, 0, 1);
    }
    
    protected abstract T Z(final Format p0, final CryptoConfig p1) throws DecoderException;
    
    @Override
    public final int a(final Format format) {
        final boolean o = MimeTypes.o(format.w);
        int n = 0;
        if (!o) {
            return RendererCapabilities.o(0);
        }
        final int m0 = this.m0(format);
        if (m0 <= 2) {
            return RendererCapabilities.o(m0);
        }
        if (Util.a >= 21) {
            n = 32;
        }
        return RendererCapabilities.v(m0, 8, n);
    }
    
    @Override
    public PlaybackParameters b() {
        return this.z.b();
    }
    
    @Override
    public boolean c() {
        return this.T && this.z.c();
    }
    
    @Override
    public void d(final PlaybackParameters playbackParameters) {
        this.z.d(playbackParameters);
    }
    
    protected abstract Format d0(final T p0);
    
    protected void g0() {
        this.R = true;
    }
    
    protected void h0(final DecoderInputBuffer decoderInputBuffer) {
        if (this.Q && !decoderInputBuffer.m()) {
            if (Math.abs(decoderInputBuffer.f - this.P) > 500000L) {
                this.P = decoderInputBuffer.f;
            }
            this.Q = false;
        }
    }
    
    @Override
    public boolean isReady() {
        if (!this.z.e()) {
            if (this.C != null) {
                if (this.M()) {
                    return true;
                }
                if (this.J != null) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    protected abstract int m0(final Format p0);
    
    @Override
    public void p(final int n, final Object o) throws ExoPlaybackException {
        if (n != 2) {
            if (n != 3) {
                if (n != 6) {
                    if (n != 9) {
                        if (n != 10) {
                            super.p(n, o);
                        }
                        else {
                            this.z.f((int)o);
                        }
                    }
                    else {
                        this.z.t((boolean)o);
                    }
                }
                else {
                    this.z.n((AuxEffectInfo)o);
                }
            }
            else {
                this.z.h((AudioAttributes)o);
            }
        }
        else {
            this.z.setVolume((float)o);
        }
    }
    
    @Override
    public long w() {
        if (this.getState() == 2) {
            this.n0();
        }
        return this.P;
    }
    
    private final class b implements Listener
    {
        final DecoderAudioRenderer a;
        
        private b(final DecoderAudioRenderer a) {
            this.a = a;
        }
        
        b(final DecoderAudioRenderer decoderAudioRenderer, final DecoderAudioRenderer$a object) {
            this(decoderAudioRenderer);
        }
        
        @Override
        public void a(final Exception ex) {
            Log.d("DecoderAudioRenderer", "Audio sink error", ex);
            DecoderAudioRenderer.X(this.a).l(ex);
        }
        
        @Override
        public void b(final long n) {
            DecoderAudioRenderer.X(this.a).B(n);
        }
        
        @Override
        public void d(final int n, final long n2, final long n3) {
            DecoderAudioRenderer.X(this.a).D(n, n2, n3);
        }
        
        @Override
        public void e() {
            this.a.g0();
        }
        
        @Override
        public void onSkipSilenceEnabledChanged(final boolean b) {
            DecoderAudioRenderer.X(this.a).C(b);
        }
    }
}
