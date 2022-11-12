// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.util.List;
import java.util.Collections;

public abstract class BasePlayer implements Player
{
    protected final Timeline.Window a;
    
    protected BasePlayer() {
        this.a = new Timeline.Window();
    }
    
    private int l0() {
        int repeatMode;
        if ((repeatMode = this.getRepeatMode()) == 1) {
            repeatMode = 0;
        }
        return repeatMode;
    }
    
    private void n0(long min) {
        final long n = this.g0() + min;
        final long duration = this.getDuration();
        min = n;
        if (duration != -9223372036854775807L) {
            min = Math.min(n, duration);
        }
        this.seekTo(Math.max(min, 0L));
    }
    
    @Override
    public final void D(final MediaItem mediaItem) {
        this.p0(Collections.singletonList(mediaItem));
    }
    
    @Override
    public final MediaItem G(final int n) {
        return this.w().r(n, this.a).c;
    }
    
    @Override
    public final long I() {
        final Timeline w = this.w();
        long g;
        if (w.u()) {
            g = -9223372036854775807L;
        }
        else {
            g = w.r(this.Y(), this.a).g();
        }
        return g;
    }
    
    @Override
    public final boolean M() {
        return this.k0() != -1;
    }
    
    @Override
    public final void O(final MediaItem mediaItem, final boolean b) {
        this.i(Collections.singletonList(mediaItem), b);
    }
    
    @Override
    public final void P(final int n) {
        this.B(n, -9223372036854775807L);
    }
    
    @Override
    public final boolean V() {
        final Timeline w = this.w();
        return !w.u() && w.r(this.Y(), this.a).h;
    }
    
    @Override
    public final boolean X() {
        return this.getPlaybackState() == 3 && this.E() && this.v() == 0;
    }
    
    @Override
    public final void a0(final List<MediaItem> list) {
        this.T(Integer.MAX_VALUE, list);
    }
    
    @Override
    public final void d0() {
        this.n0(this.Q());
    }
    
    @Override
    public final void e0() {
        this.n0(-this.h0());
    }
    
    @Override
    public final void h() {
        this.P(this.Y());
    }
    
    @Override
    public final boolean i0() {
        final Timeline w = this.w();
        return !w.u() && w.r(this.Y(), this.a).i();
    }
    
    public final int j0() {
        final Timeline w = this.w();
        int i;
        if (w.u()) {
            i = -1;
        }
        else {
            i = w.i(this.Y(), this.l0(), this.b0());
        }
        return i;
    }
    
    @Override
    public final void k(final int n) {
        this.m(n, n + 1);
    }
    
    public final int k0() {
        final Timeline w = this.w();
        int p;
        if (w.u()) {
            p = -1;
        }
        else {
            p = w.p(this.Y(), this.l0(), this.b0());
        }
        return p;
    }
    
    @Override
    public final int l() {
        return this.w().t();
    }
    
    public final void m0() {
        final int j0 = this.j0();
        if (j0 != -1) {
            this.P(j0);
        }
    }
    
    @Override
    public final void n() {
        if (!this.w().u()) {
            if (!this.e()) {
                final boolean m = this.M();
                if (this.i0() && !this.V()) {
                    if (m) {
                        this.o0();
                    }
                }
                else if (m && this.g0() <= this.H()) {
                    this.o0();
                }
                else {
                    this.seekTo(0L);
                }
            }
        }
    }
    
    public final void o0() {
        final int k0 = this.k0();
        if (k0 != -1) {
            this.P(k0);
        }
    }
    
    public final void p0(final List<MediaItem> list) {
        this.i(list, true);
    }
    
    @Override
    public final void pause() {
        this.o(false);
    }
    
    @Override
    public final void play() {
        this.o(true);
    }
    
    @Override
    public final boolean q() {
        return this.j0() != -1;
    }
    
    @Override
    public final void seekTo(final long n) {
        this.B(this.Y(), n);
    }
    
    @Override
    public final boolean t(final int n) {
        return this.C().c(n);
    }
    
    @Override
    public final boolean u() {
        final Timeline w = this.w();
        return !w.u() && w.r(this.Y(), this.a).i;
    }
    
    @Override
    public final void z() {
        if (!this.w().u()) {
            if (!this.e()) {
                if (this.q()) {
                    this.m0();
                }
                else if (this.i0() && this.u()) {
                    this.h();
                }
            }
        }
    }
}
