// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.io.IOException;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.source.SampleStream;

public abstract class NoSampleRenderer implements Renderer, RendererCapabilities
{
    private RendererConfiguration a;
    private int b;
    private int c;
    private SampleStream d;
    private boolean e;
    
    @Override
    public long B() {
        return Long.MIN_VALUE;
    }
    
    @Override
    public final void C(final long n) throws ExoPlaybackException {
        this.w(n, this.e = false);
    }
    
    @Override
    public MediaClock D() {
        return null;
    }
    
    protected void F(final long n) throws ExoPlaybackException {
    }
    
    protected void G() {
    }
    
    protected void H() throws ExoPlaybackException {
    }
    
    protected void I() {
    }
    
    @Override
    public int a(final Format format) throws ExoPlaybackException {
        return RendererCapabilities.o(0);
    }
    
    protected void b() {
    }
    
    @Override
    public boolean c() {
        return true;
    }
    
    protected void d(final boolean b) throws ExoPlaybackException {
    }
    
    @Override
    public final void e() {
        final int c = this.c;
        boolean b = true;
        if (c != 1) {
            b = false;
        }
        Assertions.g(b);
        this.c = 0;
        this.d = null;
        this.e = false;
        this.b();
    }
    
    @Override
    public final int f() {
        return -2;
    }
    
    @Override
    public final SampleStream g() {
        return this.d;
    }
    
    @Override
    public final int getState() {
        return this.c;
    }
    
    @Override
    public final boolean h() {
        return true;
    }
    
    @Override
    public boolean isReady() {
        return true;
    }
    
    @Override
    public final void j() {
        this.e = true;
    }
    
    @Override
    public final void l(final int b, final PlayerId playerId) {
        this.b = b;
    }
    
    @Override
    public void p(final int n, final Object o) throws ExoPlaybackException {
    }
    
    @Override
    public final void q() throws IOException {
    }
    
    @Override
    public final boolean r() {
        return this.e;
    }
    
    @Override
    public final void reset() {
        Assertions.g(this.c == 0);
        this.G();
    }
    
    @Override
    public final void s(final Format[] array, final SampleStream d, final long n, final long n2) throws ExoPlaybackException {
        Assertions.g(this.e ^ true);
        this.d = d;
        this.F(n2);
    }
    
    @Override
    public final void start() throws ExoPlaybackException {
        final int c = this.c;
        boolean b = true;
        if (c != 1) {
            b = false;
        }
        Assertions.g(b);
        this.c = 2;
        this.H();
    }
    
    @Override
    public final void stop() {
        Assertions.g(this.c == 2);
        this.c = 1;
        this.I();
    }
    
    @Override
    public final RendererCapabilities u() {
        return this;
    }
    
    protected void w(final long n, final boolean b) throws ExoPlaybackException {
    }
    
    @Override
    public final void y(final RendererConfiguration a, final Format[] array, final SampleStream sampleStream, final long n, final boolean b, final boolean b2, final long n2, final long n3) throws ExoPlaybackException {
        Assertions.g(this.c == 0);
        this.a = a;
        this.c = 1;
        this.d(b);
        this.s(array, sampleStream, n2, n3);
        this.w(n, b);
    }
    
    @Override
    public int z() throws ExoPlaybackException {
        return 0;
    }
}
