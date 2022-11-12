// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import android.media.MediaCodec$CodecException;
import android.media.MediaFormat;
import android.media.MediaCodec$BufferInfo;
import java.util.ArrayDeque;
import android.os.Handler;
import android.os.HandlerThread;
import android.media.MediaCodec$Callback;

final class f extends MediaCodec$Callback
{
    private final Object a;
    private final HandlerThread b;
    private Handler c;
    private final i d;
    private final i e;
    private final ArrayDeque<MediaCodec$BufferInfo> f;
    private final ArrayDeque<MediaFormat> g;
    private MediaFormat h;
    private MediaFormat i;
    private MediaCodec$CodecException j;
    private long k;
    private boolean l;
    private IllegalStateException m;
    
    f(final HandlerThread b) {
        this.a = new Object();
        this.b = b;
        this.d = new i();
        this.e = new i();
        this.f = new ArrayDeque<MediaCodec$BufferInfo>();
        this.g = new ArrayDeque<MediaFormat>();
    }
    
    public static void a(final f f) {
        f.m();
    }
    
    private void b(final MediaFormat mediaFormat) {
        this.e.a(-2);
        this.g.add(mediaFormat);
    }
    
    private void f() {
        if (!this.g.isEmpty()) {
            this.i = this.g.getLast();
        }
        this.d.b();
        this.e.b();
        this.f.clear();
        this.g.clear();
        this.j = null;
    }
    
    private boolean i() {
        return this.k > 0L || this.l;
    }
    
    private void j() {
        this.k();
        this.l();
    }
    
    private void k() {
        final IllegalStateException m = this.m;
        if (m == null) {
            return;
        }
        this.m = null;
        throw m;
    }
    
    private void l() {
        final MediaCodec$CodecException j = this.j;
        if (j == null) {
            return;
        }
        this.j = null;
        throw j;
    }
    
    private void m() {
        synchronized (this.a) {
            if (this.l) {
                return;
            }
            final long k = this.k - 1L;
            this.k = k;
            if (k > 0L) {
                return;
            }
            if (k < 0L) {
                this.n(new IllegalStateException());
                return;
            }
            this.f();
        }
    }
    
    private void n(final IllegalStateException m) {
        synchronized (this.a) {
            this.m = m;
        }
    }
    
    public int c() {
        synchronized (this.a) {
            final boolean i = this.i();
            int e = -1;
            if (i) {
                return -1;
            }
            this.j();
            if (!this.d.d()) {
                e = this.d.e();
            }
            return e;
        }
    }
    
    public int d(final MediaCodec$BufferInfo mediaCodec$BufferInfo) {
        synchronized (this.a) {
            if (this.i()) {
                return -1;
            }
            this.j();
            if (this.e.d()) {
                return -1;
            }
            final int e = this.e.e();
            if (e >= 0) {
                Assertions.i(this.h);
                final MediaCodec$BufferInfo mediaCodec$BufferInfo2 = this.f.remove();
                mediaCodec$BufferInfo.set(mediaCodec$BufferInfo2.offset, mediaCodec$BufferInfo2.size, mediaCodec$BufferInfo2.presentationTimeUs, mediaCodec$BufferInfo2.flags);
            }
            else if (e == -2) {
                this.h = this.g.remove();
            }
            return e;
        }
    }
    
    public void e() {
        synchronized (this.a) {
            ++this.k;
            Util.j(this.c).post((Runnable)new e(this));
        }
    }
    
    public MediaFormat g() {
        synchronized (this.a) {
            final MediaFormat h = this.h;
            if (h != null) {
                return h;
            }
            throw new IllegalStateException();
        }
    }
    
    public void h(final MediaCodec mediaCodec) {
        Assertions.g(this.c == null);
        this.b.start();
        final Handler c = new Handler(this.b.getLooper());
        mediaCodec.setCallback((MediaCodec$Callback)this, c);
        this.c = c;
    }
    
    public void o() {
        synchronized (this.a) {
            this.l = true;
            this.b.quit();
            this.f();
        }
    }
    
    public void onError(final MediaCodec mediaCodec, final MediaCodec$CodecException j) {
        synchronized (this.a) {
            this.j = j;
        }
    }
    
    public void onInputBufferAvailable(final MediaCodec mediaCodec, final int n) {
        synchronized (this.a) {
            this.d.a(n);
        }
    }
    
    public void onOutputBufferAvailable(final MediaCodec mediaCodec, final int n, final MediaCodec$BufferInfo mediaCodec$BufferInfo) {
        synchronized (this.a) {
            final MediaFormat i = this.i;
            if (i != null) {
                this.b(i);
                this.i = null;
            }
            this.e.a(n);
            this.f.add(mediaCodec$BufferInfo);
        }
    }
    
    public void onOutputFormatChanged(final MediaCodec mediaCodec, final MediaFormat mediaFormat) {
        synchronized (this.a) {
            this.b(mediaFormat);
            this.i = null;
        }
    }
}
