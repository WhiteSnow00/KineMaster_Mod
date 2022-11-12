// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import android.os.Looper;
import java.util.Arrays;
import android.media.MediaCodec$CryptoInfo$Pattern;
import com.google.android.exoplayer2.util.Util;
import android.media.MediaCodec$CryptoInfo;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Message;
import com.google.android.exoplayer2.util.ConditionVariable;
import java.util.concurrent.atomic.AtomicReference;
import android.os.Handler;
import android.os.HandlerThread;
import android.media.MediaCodec;
import java.util.ArrayDeque;

class d
{
    private static final ArrayDeque<b> g;
    private static final Object h;
    private final MediaCodec a;
    private final HandlerThread b;
    private Handler c;
    private final AtomicReference<RuntimeException> d;
    private final ConditionVariable e;
    private boolean f;
    
    static {
        g = new ArrayDeque<b>();
        h = new Object();
    }
    
    public d(final MediaCodec mediaCodec, final HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new ConditionVariable());
    }
    
    d(final MediaCodec a, final HandlerThread b, final ConditionVariable e) {
        this.a = a;
        this.b = b;
        this.e = e;
        this.d = new AtomicReference<RuntimeException>();
    }
    
    static void a(final d d, final Message message) {
        d.f(message);
    }
    
    private void b() throws InterruptedException {
        this.e.d();
        Assertions.e(this.c).obtainMessage(2).sendToTarget();
        this.e.a();
    }
    
    private static void c(final CryptoInfo cryptoInfo, final MediaCodec$CryptoInfo mediaCodec$CryptoInfo) {
        mediaCodec$CryptoInfo.numSubSamples = cryptoInfo.f;
        mediaCodec$CryptoInfo.numBytesOfClearData = e(cryptoInfo.d, mediaCodec$CryptoInfo.numBytesOfClearData);
        mediaCodec$CryptoInfo.numBytesOfEncryptedData = e(cryptoInfo.e, mediaCodec$CryptoInfo.numBytesOfEncryptedData);
        mediaCodec$CryptoInfo.key = Assertions.e(d(cryptoInfo.b, mediaCodec$CryptoInfo.key));
        mediaCodec$CryptoInfo.iv = Assertions.e(d(cryptoInfo.a, mediaCodec$CryptoInfo.iv));
        mediaCodec$CryptoInfo.mode = cryptoInfo.c;
        if (Util.a >= 24) {
            mediaCodec$CryptoInfo.setPattern(new MediaCodec$CryptoInfo$Pattern(cryptoInfo.g, cryptoInfo.h));
        }
    }
    
    private static byte[] d(final byte[] array, final byte[] array2) {
        if (array == null) {
            return array2;
        }
        if (array2 != null && array2.length >= array.length) {
            System.arraycopy(array, 0, array2, 0, array.length);
            return array2;
        }
        return Arrays.copyOf(array, array.length);
    }
    
    private static int[] e(final int[] array, final int[] array2) {
        if (array == null) {
            return array2;
        }
        if (array2 != null && array2.length >= array.length) {
            System.arraycopy(array, 0, array2, 0, array.length);
            return array2;
        }
        return Arrays.copyOf(array, array.length);
    }
    
    private void f(final Message message) {
        final int what = message.what;
        final b b = null;
        b b2;
        if (what != 0) {
            if (what != 1) {
                if (what != 2) {
                    this.d.compareAndSet(null, new IllegalStateException(String.valueOf(message.what)));
                    b2 = b;
                }
                else {
                    this.e.f();
                    b2 = b;
                }
            }
            else {
                b2 = (b)message.obj;
                this.h(b2.a, b2.b, b2.d, b2.e, b2.f);
            }
        }
        else {
            b2 = (b)message.obj;
            this.g(b2.a, b2.b, b2.c, b2.e, b2.f);
        }
        if (b2 != null) {
            o(b2);
        }
    }
    
    private void g(final int n, final int n2, final int n3, final long n4, final int n5) {
        try {
            this.a.queueInputBuffer(n, n2, n3, n4, n5);
        }
        catch (final RuntimeException ex) {
            this.d.compareAndSet(null, ex);
        }
    }
    
    private void h(final int n, final int n2, final MediaCodec$CryptoInfo mediaCodec$CryptoInfo, final long n3, final int n4) {
        try {
            synchronized (com.google.android.exoplayer2.mediacodec.d.h) {
                this.a.queueSecureInputBuffer(n, n2, mediaCodec$CryptoInfo, n3, n4);
            }
        }
        catch (final RuntimeException ex) {
            this.d.compareAndSet(null, ex);
        }
    }
    
    private void j() throws InterruptedException {
        Assertions.e(this.c).removeCallbacksAndMessages((Object)null);
        this.b();
    }
    
    private static b k() {
        final ArrayDeque<b> g = d.g;
        synchronized (g) {
            if (g.isEmpty()) {
                return new b();
            }
            return g.removeFirst();
        }
    }
    
    private void l() {
        final RuntimeException ex = this.d.getAndSet(null);
        if (ex == null) {
            return;
        }
        throw ex;
    }
    
    private static void o(final b b) {
        final ArrayDeque<b> g = d.g;
        synchronized (g) {
            g.add(b);
        }
    }
    
    public void i() {
        if (this.f) {
            try {
                this.j();
            }
            catch (final InterruptedException ex) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(ex);
            }
        }
    }
    
    public void m(final int n, final int n2, final int n3, final long n4, final int n5) {
        this.l();
        final b k = k();
        k.a(n, n2, n3, n4, n5);
        Util.j(this.c).obtainMessage(0, (Object)k).sendToTarget();
    }
    
    public void n(final int n, final int n2, final CryptoInfo cryptoInfo, final long n3, final int n4) {
        this.l();
        final b k = k();
        k.a(n, n2, 0, n3, n4);
        c(cryptoInfo, k.d);
        Util.j(this.c).obtainMessage(1, (Object)k).sendToTarget();
    }
    
    public void p() {
        if (this.f) {
            this.i();
            this.b.quit();
        }
        this.f = false;
    }
    
    public void q() {
        if (!this.f) {
            this.b.start();
            this.c = new Handler(this, this.b.getLooper()) {
                final d a;
                
                public void handleMessage(final Message message) {
                    com.google.android.exoplayer2.mediacodec.d.a(this.a, message);
                }
            };
            this.f = true;
        }
    }
    
    public void r() throws InterruptedException {
        this.b();
    }
    
    private static class b
    {
        public int a;
        public int b;
        public int c;
        public final MediaCodec$CryptoInfo d;
        public long e;
        public int f;
        
        b() {
            this.d = new MediaCodec$CryptoInfo();
        }
        
        public void a(final int a, final int b, final int c, final long e, final int f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.e = e;
            this.f = f;
        }
    }
}
