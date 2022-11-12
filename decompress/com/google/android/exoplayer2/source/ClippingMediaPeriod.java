// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import java.io.IOException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.SeekParameters;

public final class ClippingMediaPeriod implements MediaPeriod, Callback
{
    public final MediaPeriod a;
    private Callback b;
    private a[] c;
    private long d;
    long e;
    long f;
    private ClippingMediaSource.IllegalClippingException g;
    
    public ClippingMediaPeriod(final MediaPeriod a, final boolean b, final long e, final long f) {
        this.a = a;
        this.c = new a[0];
        long d;
        if (b) {
            d = e;
        }
        else {
            d = -9223372036854775807L;
        }
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    private SeekParameters a(long r, final SeekParameters seekParameters) {
        final long r2 = Util.r(seekParameters.a, 0L, r - this.e);
        final long b = seekParameters.b;
        final long f = this.f;
        if (f == Long.MIN_VALUE) {
            r = Long.MAX_VALUE;
        }
        else {
            r = f - r;
        }
        r = Util.r(b, 0L, r);
        if (r2 == seekParameters.a && r == seekParameters.b) {
            return seekParameters;
        }
        return new SeekParameters(r2, r);
    }
    
    private static boolean t(final long n, final ExoTrackSelection[] array) {
        if (n != 0L) {
            for (final ExoTrackSelection exoTrackSelection : array) {
                if (exoTrackSelection != null) {
                    final Format s = exoTrackSelection.s();
                    if (!MimeTypes.a(s.w, s.i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public long b() {
        final long b = this.a.b();
        if (b != Long.MIN_VALUE) {
            final long f = this.f;
            if (f == Long.MIN_VALUE || b < f) {
                return b;
            }
        }
        return Long.MIN_VALUE;
    }
    
    @Override
    public long c(final long n, SeekParameters a) {
        final long e = this.e;
        if (n == e) {
            return e;
        }
        a = this.a(n, a);
        return this.a.c(n, a);
    }
    
    @Override
    public boolean d(final long n) {
        return this.a.d(n);
    }
    
    boolean e() {
        return this.d != -9223372036854775807L;
    }
    
    @Override
    public long f() {
        final long f = this.a.f();
        if (f != Long.MIN_VALUE) {
            final long f2 = this.f;
            if (f2 == Long.MIN_VALUE || f < f2) {
                return f;
            }
        }
        return Long.MIN_VALUE;
    }
    
    @Override
    public void g(final long n) {
        this.a.g(n);
    }
    
    @Override
    public long h(long f) {
        this.d = -9223372036854775807L;
        final a[] c = this.c;
        final int length = c.length;
        final boolean b = false;
        for (final a a : c) {
            if (a != null) {
                a.b();
            }
        }
        final long h = this.a.h(f);
        boolean b2 = false;
        Label_0111: {
            if (h != f) {
                b2 = b;
                if (h < this.e) {
                    break Label_0111;
                }
                f = this.f;
                if (f != Long.MIN_VALUE) {
                    b2 = b;
                    if (h > f) {
                        break Label_0111;
                    }
                }
            }
            b2 = true;
        }
        Assertions.g(b2);
        return h;
    }
    
    @Override
    public long i() {
        if (this.e()) {
            long d = this.d;
            this.d = -9223372036854775807L;
            final long i = this.i();
            if (i != -9223372036854775807L) {
                d = i;
            }
            return d;
        }
        final long j = this.a.i();
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        final long e = this.e;
        final boolean b = true;
        Assertions.g(j >= e);
        final long f = this.f;
        boolean b2 = b;
        if (f != Long.MIN_VALUE) {
            b2 = (j <= f && b);
        }
        Assertions.g(b2);
        return j;
    }
    
    @Override
    public boolean isLoading() {
        return this.a.isLoading();
    }
    
    @Override
    public void j(final Callback b, final long n) {
        this.b = b;
        this.a.j((Callback)this, n);
    }
    
    @Override
    public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, long f) {
        this.c = new a[array3.length];
        final SampleStream[] array5 = new SampleStream[array3.length];
        final int n = 0;
        int n2 = 0;
        while (true) {
            final int length = array3.length;
            SampleStream a = null;
            if (n2 >= length) {
                break;
            }
            final a[] c = this.c;
            c[n2] = (a)array3[n2];
            if (c[n2] != null) {
                a = c[n2].a;
            }
            array5[n2] = a;
            ++n2;
        }
        final long k = this.a.k(array, array2, array5, array4, f);
        long d = 0L;
        Label_0146: {
            if (this.e()) {
                final long e = this.e;
                if (f == e && t(e, array)) {
                    d = k;
                    break Label_0146;
                }
            }
            d = -9223372036854775807L;
        }
        this.d = d;
        boolean b = false;
        Label_0205: {
            Label_0202: {
                if (k != f) {
                    if (k >= this.e) {
                        f = this.f;
                        if (f == Long.MIN_VALUE) {
                            break Label_0202;
                        }
                        if (k <= f) {
                            break Label_0202;
                        }
                    }
                    b = false;
                    break Label_0205;
                }
            }
            b = true;
        }
        Assertions.g(b);
        for (int i = n; i < array3.length; ++i) {
            if (array5[i] == null) {
                this.c[i] = null;
            }
            else {
                final a[] c2 = this.c;
                if (c2[i] == null || c2[i].a != array5[i]) {
                    c2[i] = new a(array5[i]);
                }
            }
            array3[i] = this.c[i];
        }
        return k;
    }
    
    @Override
    public /* bridge */ void l(final SequenceableLoader sequenceableLoader) {
        this.r((MediaPeriod)sequenceableLoader);
    }
    
    @Override
    public void n() throws IOException {
        final ClippingMediaSource.IllegalClippingException g = this.g;
        if (g == null) {
            this.a.n();
            return;
        }
        throw g;
    }
    
    @Override
    public void o(final MediaPeriod mediaPeriod) {
        if (this.g != null) {
            return;
        }
        Assertions.e(this.b).o(this);
    }
    
    @Override
    public TrackGroupArray p() {
        return this.a.p();
    }
    
    @Override
    public void q(final long n, final boolean b) {
        this.a.q(n, b);
    }
    
    public void r(final MediaPeriod mediaPeriod) {
        ((SequenceableLoader.Callback<ClippingMediaPeriod>)Assertions.e(this.b)).l(this);
    }
    
    public void s(final ClippingMediaSource.IllegalClippingException g) {
        this.g = g;
    }
    
    public void u(final long e, final long f) {
        this.e = e;
        this.f = f;
    }
    
    private final class a implements SampleStream
    {
        public final SampleStream a;
        private boolean b;
        final ClippingMediaPeriod c;
        
        public a(final ClippingMediaPeriod c, final SampleStream a) {
            this.c = c;
            this.a = a;
        }
        
        @Override
        public void a() throws IOException {
            this.a.a();
        }
        
        public void b() {
            this.b = false;
        }
        
        @Override
        public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, int n) {
            if (this.c.e()) {
                return -3;
            }
            if (this.b) {
                decoderInputBuffer.q(4);
                return -4;
            }
            n = this.a.e(formatHolder, decoderInputBuffer, n);
            if (n == -5) {
                final Format format = Assertions.e(formatHolder.b);
                n = format.M;
                if (n != 0 || format.N != 0) {
                    final ClippingMediaPeriod c = this.c;
                    final long e = c.e;
                    int n2 = 0;
                    if (e != 0L) {
                        n = 0;
                    }
                    if (c.f == Long.MIN_VALUE) {
                        n2 = format.N;
                    }
                    formatHolder.b = format.b().N(n).O(n2).E();
                }
                return -5;
            }
            final ClippingMediaPeriod c2 = this.c;
            final long f = c2.f;
            if (f != Long.MIN_VALUE && ((n == -4 && decoderInputBuffer.f >= f) || (n == -3 && c2.f() == Long.MIN_VALUE && !decoderInputBuffer.e))) {
                decoderInputBuffer.h();
                decoderInputBuffer.q(4);
                this.b = true;
                return -4;
            }
            return n;
        }
        
        @Override
        public boolean isReady() {
            return !this.c.e() && this.a.isReady();
        }
        
        @Override
        public int l(final long n) {
            if (this.c.e()) {
                return -3;
            }
            return this.a.l(n);
        }
    }
}
