// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.io.IOException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.analytics.PlayerId;

public abstract class BaseRenderer implements Renderer, RendererCapabilities
{
    private final int a;
    private final FormatHolder b;
    private RendererConfiguration c;
    private int d;
    private PlayerId e;
    private int f;
    private SampleStream g;
    private Format[] h;
    private long i;
    private long j;
    private long p;
    private boolean w;
    private boolean x;
    
    public BaseRenderer(final int a) {
        this.a = a;
        this.b = new FormatHolder();
        this.p = Long.MIN_VALUE;
    }
    
    private void V(final long n, final boolean b) throws ExoPlaybackException {
        this.w = false;
        this.j = n;
        this.P(this.p = n, b);
    }
    
    @Override
    public final long B() {
        return this.p;
    }
    
    @Override
    public final void C(final long n) throws ExoPlaybackException {
        this.V(n, false);
    }
    
    @Override
    public MediaClock D() {
        return null;
    }
    
    protected final ExoPlaybackException F(final Throwable t, final Format format, final int n) {
        return this.G(t, format, false, n);
    }
    
    protected final ExoPlaybackException G(final Throwable t, final Format format, final boolean b, final int n) {
        if (format != null && !this.x) {
            this.x = true;
            try {
                final int e = RendererCapabilities.E(this.a(format));
                return ExoPlaybackException.createForRenderer(t, this.getName(), this.J(), format, e, b, n);
            }
            catch (final ExoPlaybackException ex) {
                this.x = false;
            }
            finally {
                this.x = false;
            }
        }
        final int e = 4;
        return ExoPlaybackException.createForRenderer(t, this.getName(), this.J(), format, e, b, n);
    }
    
    protected final RendererConfiguration H() {
        return Assertions.e(this.c);
    }
    
    protected final FormatHolder I() {
        this.b.a();
        return this.b;
    }
    
    protected final int J() {
        return this.d;
    }
    
    protected final PlayerId K() {
        return Assertions.e(this.e);
    }
    
    protected final Format[] L() {
        return Assertions.e(this.h);
    }
    
    protected final boolean M() {
        boolean b;
        if (this.h()) {
            b = this.w;
        }
        else {
            b = Assertions.e(this.g).isReady();
        }
        return b;
    }
    
    protected void N() {
    }
    
    protected void O(final boolean b, final boolean b2) throws ExoPlaybackException {
    }
    
    protected void P(final long n, final boolean b) throws ExoPlaybackException {
    }
    
    protected void Q() {
    }
    
    protected void R() throws ExoPlaybackException {
    }
    
    protected void S() {
    }
    
    protected void T(final Format[] array, final long n, final long n2) throws ExoPlaybackException {
    }
    
    protected final int U(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, int n) {
        final int e = Assertions.e(this.g).e(formatHolder, decoderInputBuffer, n);
        n = -4;
        if (e == -4) {
            if (decoderInputBuffer.n()) {
                this.p = Long.MIN_VALUE;
                if (!this.w) {
                    n = -3;
                }
                return n;
            }
            final long f = decoderInputBuffer.f + this.i;
            decoderInputBuffer.f = f;
            this.p = Math.max(this.p, f);
        }
        else if (e == -5) {
            final Format format = Assertions.e(formatHolder.b);
            if (format.A != Long.MAX_VALUE) {
                formatHolder.b = format.b().i0(format.A + this.i).E();
            }
        }
        return e;
    }
    
    protected int W(final long n) {
        return Assertions.e(this.g).l(n - this.i);
    }
    
    @Override
    public final void e() {
        final int f = this.f;
        boolean b = true;
        if (f != 1) {
            b = false;
        }
        Assertions.g(b);
        this.b.a();
        this.f = 0;
        this.g = null;
        this.h = null;
        this.w = false;
        this.N();
    }
    
    @Override
    public final int f() {
        return this.a;
    }
    
    @Override
    public final SampleStream g() {
        return this.g;
    }
    
    @Override
    public final int getState() {
        return this.f;
    }
    
    @Override
    public final boolean h() {
        return this.p == Long.MIN_VALUE;
    }
    
    @Override
    public final void j() {
        this.w = true;
    }
    
    @Override
    public final void l(final int d, final PlayerId e) {
        this.d = d;
        this.e = e;
    }
    
    @Override
    public void p(final int n, final Object o) throws ExoPlaybackException {
    }
    
    @Override
    public final void q() throws IOException {
        Assertions.e(this.g).a();
    }
    
    @Override
    public final boolean r() {
        return this.w;
    }
    
    @Override
    public final void reset() {
        Assertions.g(this.f == 0);
        this.b.a();
        this.Q();
    }
    
    @Override
    public final void s(final Format[] h, final SampleStream g, final long p4, final long i) throws ExoPlaybackException {
        Assertions.g(this.w ^ true);
        this.g = g;
        if (this.p == Long.MIN_VALUE) {
            this.p = p4;
        }
        this.T(this.h = h, p4, this.i = i);
    }
    
    @Override
    public final void start() throws ExoPlaybackException {
        final int f = this.f;
        boolean b = true;
        if (f != 1) {
            b = false;
        }
        Assertions.g(b);
        this.f = 2;
        this.R();
    }
    
    @Override
    public final void stop() {
        Assertions.g(this.f == 2);
        this.f = 1;
        this.S();
    }
    
    @Override
    public final RendererCapabilities u() {
        return this;
    }
    
    @Override
    public final void y(final RendererConfiguration c, final Format[] array, final SampleStream sampleStream, final long n, final boolean b, final boolean b2, final long n2, final long n3) throws ExoPlaybackException {
        Assertions.g(this.f == 0);
        this.c = c;
        this.f = 1;
        this.O(b, b2);
        this.s(array, sampleStream, n2, n3);
        this.V(n, b);
    }
    
    @Override
    public int z() throws ExoPlaybackException {
        return 0;
    }
}
