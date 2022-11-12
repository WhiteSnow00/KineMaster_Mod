// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;
import com.google.android.exoplayer2.util.MediaClock;

final class DefaultMediaClock implements MediaClock
{
    private final StandaloneMediaClock a;
    private final PlaybackParametersListener b;
    private Renderer c;
    private MediaClock d;
    private boolean e;
    private boolean f;
    
    public DefaultMediaClock(final PlaybackParametersListener b, final Clock clock) {
        this.b = b;
        this.a = new StandaloneMediaClock(clock);
        this.e = true;
    }
    
    private boolean f(final boolean b) {
        final Renderer c = this.c;
        if (c != null && !c.c()) {
            if (!this.c.isReady()) {
                if (b) {
                    return true;
                }
                if (this.c.h()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    private void j(final boolean b) {
        if (this.f(b)) {
            this.e = true;
            if (this.f) {
                this.a.c();
            }
            return;
        }
        final MediaClock mediaClock = Assertions.e(this.d);
        final long w = mediaClock.w();
        if (this.e) {
            if (w < this.a.w()) {
                this.a.e();
                return;
            }
            this.e = false;
            if (this.f) {
                this.a.c();
            }
        }
        this.a.a(w);
        final PlaybackParameters b2 = mediaClock.b();
        if (!b2.equals(this.a.b())) {
            this.a.d(b2);
            this.b.onPlaybackParametersChanged(b2);
        }
    }
    
    public void a(final Renderer renderer) {
        if (renderer == this.c) {
            this.d = null;
            this.c = null;
            this.e = true;
        }
    }
    
    @Override
    public PlaybackParameters b() {
        final MediaClock d = this.d;
        PlaybackParameters playbackParameters;
        if (d != null) {
            playbackParameters = d.b();
        }
        else {
            playbackParameters = this.a.b();
        }
        return playbackParameters;
    }
    
    public void c(final Renderer c) throws ExoPlaybackException {
        final MediaClock d = c.D();
        if (d != null) {
            final MediaClock d2 = this.d;
            if (d != d2) {
                if (d2 != null) {
                    throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                }
                this.d = d;
                this.c = c;
                d.d(this.a.b());
            }
        }
    }
    
    @Override
    public void d(final PlaybackParameters playbackParameters) {
        final MediaClock d = this.d;
        PlaybackParameters b = playbackParameters;
        if (d != null) {
            d.d(playbackParameters);
            b = this.d.b();
        }
        this.a.d(b);
    }
    
    public void e(final long n) {
        this.a.a(n);
    }
    
    public void g() {
        this.f = true;
        this.a.c();
    }
    
    public void h() {
        this.f = false;
        this.a.e();
    }
    
    public long i(final boolean b) {
        this.j(b);
        return this.w();
    }
    
    @Override
    public long w() {
        long n;
        if (this.e) {
            n = this.a.w();
        }
        else {
            n = Assertions.e(this.d).w();
        }
        return n;
    }
    
    public interface PlaybackParametersListener
    {
        void onPlaybackParametersChanged(final PlaybackParameters p0);
    }
}
