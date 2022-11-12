// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.io.IOException;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.Allocator;

public final class MaskingMediaPeriod implements MediaPeriod, Callback
{
    public final MediaSource.MediaPeriodId a;
    private final long b;
    private final Allocator c;
    private MediaSource d;
    private MediaPeriod e;
    private Callback f;
    private PrepareListener g;
    private boolean h;
    private long i;
    
    public MaskingMediaPeriod(final MediaSource.MediaPeriodId a, final Allocator c, final long b) {
        this.a = a;
        this.c = c;
        this.b = b;
        this.i = -9223372036854775807L;
    }
    
    private long s(long n) {
        final long i = this.i;
        if (i != -9223372036854775807L) {
            n = i;
        }
        return n;
    }
    
    public void a(final MediaSource.MediaPeriodId mediaPeriodId) {
        final long s = this.s(this.b);
        final MediaPeriod u = Assertions.e(this.d).u(mediaPeriodId, this.c, s);
        this.e = u;
        if (this.f != null) {
            u.j((Callback)this, s);
        }
    }
    
    @Override
    public long b() {
        return Util.j(this.e).b();
    }
    
    @Override
    public long c(final long n, final SeekParameters seekParameters) {
        return Util.j(this.e).c(n, seekParameters);
    }
    
    @Override
    public boolean d(final long n) {
        final MediaPeriod e = this.e;
        return e != null && e.d(n);
    }
    
    public long e() {
        return this.i;
    }
    
    @Override
    public long f() {
        return Util.j(this.e).f();
    }
    
    @Override
    public void g(final long n) {
        Util.j(this.e).g(n);
    }
    
    @Override
    public long h(final long n) {
        return Util.j(this.e).h(n);
    }
    
    @Override
    public long i() {
        return Util.j(this.e).i();
    }
    
    @Override
    public boolean isLoading() {
        final MediaPeriod e = this.e;
        return e != null && e.isLoading();
    }
    
    @Override
    public void j(final Callback f, final long n) {
        this.f = f;
        final MediaPeriod e = this.e;
        if (e != null) {
            e.j((Callback)this, this.s(this.b));
        }
    }
    
    @Override
    public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, long n) {
        final long i = this.i;
        if (i != -9223372036854775807L && n == this.b) {
            this.i = -9223372036854775807L;
            n = i;
        }
        return Util.j(this.e).k(array, array2, array3, array4, n);
    }
    
    @Override
    public /* bridge */ void l(final SequenceableLoader sequenceableLoader) {
        this.t((MediaPeriod)sequenceableLoader);
    }
    
    @Override
    public void n() throws IOException {
        try {
            final MediaPeriod e = this.e;
            if (e != null) {
                e.n();
            }
            else {
                final MediaSource d = this.d;
                if (d != null) {
                    d.U();
                }
            }
        }
        catch (final IOException ex) {
            final PrepareListener g = this.g;
            if (g == null) {
                throw ex;
            }
            if (!this.h) {
                this.h = true;
                g.b(this.a, ex);
            }
        }
    }
    
    @Override
    public void o(final MediaPeriod mediaPeriod) {
        Util.j(this.f).o(this);
        final PrepareListener g = this.g;
        if (g != null) {
            g.a(this.a);
        }
    }
    
    @Override
    public TrackGroupArray p() {
        return Util.j(this.e).p();
    }
    
    @Override
    public void q(final long n, final boolean b) {
        Util.j(this.e).q(n, b);
    }
    
    public long r() {
        return this.b;
    }
    
    public void t(final MediaPeriod mediaPeriod) {
        ((SequenceableLoader.Callback<MaskingMediaPeriod>)Util.j(this.f)).l(this);
    }
    
    public void u(final long i) {
        this.i = i;
    }
    
    public void v() {
        if (this.e != null) {
            Assertions.e(this.d).I(this.e);
        }
    }
    
    public void w(final MediaSource d) {
        Assertions.g(this.d == null);
        this.d = d;
    }
    
    public void x(final PrepareListener g) {
        this.g = g;
    }
    
    public interface PrepareListener
    {
        void a(final MediaSource.MediaPeriodId p0);
        
        void b(final MediaSource.MediaPeriodId p0, final IOException p1);
    }
}
