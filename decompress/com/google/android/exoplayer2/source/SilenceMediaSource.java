// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.SeekParameters;
import java.util.ArrayList;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Format;

public final class SilenceMediaSource extends BaseMediaSource
{
    private static final Format j;
    private static final MediaItem p;
    private static final byte[] w;
    private final long h;
    private final MediaItem i;
    
    static {
        p = new MediaItem.Builder().e("SilenceMediaSource").i(Uri.EMPTY).f((j = new Format.Builder().e0("audio/raw").H(2).f0(44100).Y(2).E()).w).a();
        w = new byte[Util.e0(2, 2) * 1024];
    }
    
    static Format p0() {
        return SilenceMediaSource.j;
    }
    
    static long q0(final long n) {
        return t0(n);
    }
    
    static long r0(final long n) {
        return u0(n);
    }
    
    static byte[] s0() {
        return SilenceMediaSource.w;
    }
    
    private static long t0(long n) {
        n = n * 44100L / 1000000L;
        return Util.e0(2, 2) * n;
    }
    
    private static long u0(final long n) {
        return n / Util.e0(2, 2) * 1000000L / 44100L;
    }
    
    @Override
    public MediaItem F() {
        return this.i;
    }
    
    @Override
    public void I(final MediaPeriod mediaPeriod) {
    }
    
    @Override
    public void U() {
    }
    
    @Override
    protected void m0(final TransferListener transferListener) {
        this.n0(new SinglePeriodTimeline(this.h, true, false, false, null, this.i));
    }
    
    @Override
    protected void o0() {
    }
    
    @Override
    public MediaPeriod u(final MediaPeriodId mediaPeriodId, final Allocator allocator, final long n) {
        return new a(this.h);
    }
    
    public static final class Factory
    {
    }
    
    private static final class a implements MediaPeriod
    {
        private static final TrackGroupArray c;
        private final long a;
        private final ArrayList<SampleStream> b;
        
        static {
            c = new TrackGroupArray(new TrackGroup[] { new TrackGroup(new Format[] { SilenceMediaSource.p0() }) });
        }
        
        public a(final long a) {
            this.a = a;
            this.b = new ArrayList<SampleStream>();
        }
        
        private long a(final long n) {
            return Util.r(n, 0L, this.a);
        }
        
        @Override
        public long b() {
            return Long.MIN_VALUE;
        }
        
        @Override
        public long c(final long n, final SeekParameters seekParameters) {
            return this.a(n);
        }
        
        @Override
        public boolean d(final long n) {
            return false;
        }
        
        @Override
        public long f() {
            return Long.MIN_VALUE;
        }
        
        @Override
        public void g(final long n) {
        }
        
        @Override
        public long h(long a) {
            a = this.a(a);
            for (int i = 0; i < this.b.size(); ++i) {
                ((b)this.b.get(i)).b(a);
            }
            return a;
        }
        
        @Override
        public long i() {
            return -9223372036854775807L;
        }
        
        @Override
        public boolean isLoading() {
            return false;
        }
        
        @Override
        public void j(final Callback callback, final long n) {
            callback.o(this);
        }
        
        @Override
        public long k(final ExoTrackSelection[] array, final boolean[] array2, final SampleStream[] array3, final boolean[] array4, long a) {
            a = this.a(a);
            for (int i = 0; i < array.length; ++i) {
                if (array3[i] != null && (array[i] == null || !array2[i])) {
                    this.b.remove(array3[i]);
                    array3[i] = null;
                }
                if (array3[i] == null && array[i] != null) {
                    final b b = new b(this.a);
                    b.b(a);
                    this.b.add(b);
                    array3[i] = b;
                    array4[i] = true;
                }
            }
            return a;
        }
        
        @Override
        public void n() {
        }
        
        @Override
        public TrackGroupArray p() {
            return SilenceMediaSource.a.c;
        }
        
        @Override
        public void q(final long n, final boolean b) {
        }
    }
    
    private static final class b implements SampleStream
    {
        private final long a;
        private boolean b;
        private long c;
        
        public b(final long n) {
            this.a = SilenceMediaSource.q0(n);
            this.b(0L);
        }
        
        @Override
        public void a() {
        }
        
        public void b(final long n) {
            this.c = Util.r(SilenceMediaSource.q0(n), 0L, this.a);
        }
        
        @Override
        public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
            if (!this.b || (n & 0x2) != 0x0) {
                formatHolder.b = SilenceMediaSource.p0();
                this.b = true;
                return -5;
            }
            final long a = this.a;
            final long c = this.c;
            final long n2 = a - c;
            if (n2 == 0L) {
                decoderInputBuffer.g(4);
                return -4;
            }
            decoderInputBuffer.f = SilenceMediaSource.r0(c);
            decoderInputBuffer.g(1);
            final int n3 = (int)Math.min(SilenceMediaSource.s0().length, n2);
            if ((n & 0x4) == 0x0) {
                decoderInputBuffer.s(n3);
                decoderInputBuffer.d.put(SilenceMediaSource.s0(), 0, n3);
            }
            if ((n & 0x1) == 0x0) {
                this.c += n3;
            }
            return -4;
        }
        
        @Override
        public boolean isReady() {
            return true;
        }
        
        @Override
        public int l(final long n) {
            final long c = this.c;
            this.b(n);
            return (int)((this.c - c) / SilenceMediaSource.s0().length);
        }
    }
}
