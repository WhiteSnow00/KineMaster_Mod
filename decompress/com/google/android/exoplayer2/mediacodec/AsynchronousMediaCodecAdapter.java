// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import java.io.IOException;
import com.google.common.base.Supplier;
import android.media.MediaCodec$BufferInfo;
import android.os.Bundle;
import java.nio.ByteBuffer;
import android.media.MediaCodec$OnFrameRenderedListener;
import android.os.Handler;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.TraceUtil;
import android.media.MediaCrypto;
import android.view.Surface;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.media.MediaCodec;

final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter
{
    private final MediaCodec a;
    private final f b;
    private final d c;
    private final boolean d;
    private boolean e;
    private int f;
    
    private AsynchronousMediaCodecAdapter(final MediaCodec a, final HandlerThread handlerThread, final HandlerThread handlerThread2, final boolean d) {
        this.a = a;
        this.b = new f(handlerThread);
        this.c = new d(a, handlerThread2);
        this.d = d;
        this.f = 0;
    }
    
    AsynchronousMediaCodecAdapter(final MediaCodec mediaCodec, final HandlerThread handlerThread, final HandlerThread handlerThread2, final boolean b, final AsynchronousMediaCodecAdapter$a object) {
        this(mediaCodec, handlerThread, handlerThread2, b);
    }
    
    public static void o(final AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, final OnFrameRenderedListener onFrameRenderedListener, final MediaCodec mediaCodec, final long n, final long n2) {
        asynchronousMediaCodecAdapter.w(onFrameRenderedListener, mediaCodec, n, n2);
    }
    
    static void p(final AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, final MediaFormat mediaFormat, final Surface surface, final MediaCrypto mediaCrypto, final int n) {
        asynchronousMediaCodecAdapter.v(mediaFormat, surface, mediaCrypto, n);
    }
    
    static String q(final int n) {
        return t(n);
    }
    
    static String r(final int n) {
        return s(n);
    }
    
    private static String s(final int n) {
        return u(n, "ExoPlayer:MediaCodecAsyncAdapter:");
    }
    
    private static String t(final int n) {
        return u(n, "ExoPlayer:MediaCodecQueueingThread:");
    }
    
    private static String u(final int n, final String s) {
        final StringBuilder sb = new StringBuilder(s);
        if (n == 1) {
            sb.append("Audio");
        }
        else if (n == 2) {
            sb.append("Video");
        }
        else {
            sb.append("Unknown(");
            sb.append(n);
            sb.append(")");
        }
        return sb.toString();
    }
    
    private void v(final MediaFormat mediaFormat, final Surface surface, final MediaCrypto mediaCrypto, final int n) {
        this.b.h(this.a);
        TraceUtil.a("configureCodec");
        this.a.configure(mediaFormat, surface, mediaCrypto, n);
        TraceUtil.c();
        this.c.q();
        TraceUtil.a("startCodec");
        this.a.start();
        TraceUtil.c();
        this.f = 1;
    }
    
    private void w(final OnFrameRenderedListener onFrameRenderedListener, final MediaCodec mediaCodec, final long n, final long n2) {
        onFrameRenderedListener.a(this, n, n2);
    }
    
    private void x() {
        if (this.d) {
            try {
                this.c.r();
            }
            catch (final InterruptedException ex) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(ex);
            }
        }
    }
    
    @Override
    public void a(final int n, final int n2, final CryptoInfo cryptoInfo, final long n3, final int n4) {
        this.c.n(n, n2, cryptoInfo, n3, n4);
    }
    
    @Override
    public MediaFormat b() {
        return this.b.g();
    }
    
    @Override
    public void c(final OnFrameRenderedListener onFrameRenderedListener, final Handler handler) {
        this.x();
        this.a.setOnFrameRenderedListener((MediaCodec$OnFrameRenderedListener)new a(this, onFrameRenderedListener), handler);
    }
    
    @Override
    public void d(final int videoScalingMode) {
        this.x();
        this.a.setVideoScalingMode(videoScalingMode);
    }
    
    @Override
    public ByteBuffer e(final int n) {
        return this.a.getInputBuffer(n);
    }
    
    @Override
    public void f(final Surface outputSurface) {
        this.x();
        this.a.setOutputSurface(outputSurface);
    }
    
    @Override
    public void flush() {
        this.c.i();
        this.a.flush();
        this.b.e();
        this.a.start();
    }
    
    @Override
    public void g(final int n, final int n2, final int n3, final long n4, final int n5) {
        this.c.m(n, n2, n3, n4, n5);
    }
    
    @Override
    public boolean h() {
        return false;
    }
    
    @Override
    public void i(final Bundle parameters) {
        this.x();
        this.a.setParameters(parameters);
    }
    
    @Override
    public void j(final int n, final long n2) {
        this.a.releaseOutputBuffer(n, n2);
    }
    
    @Override
    public int k() {
        return this.b.c();
    }
    
    @Override
    public int l(final MediaCodec$BufferInfo mediaCodec$BufferInfo) {
        return this.b.d(mediaCodec$BufferInfo);
    }
    
    @Override
    public void m(final int n, final boolean b) {
        this.a.releaseOutputBuffer(n, b);
    }
    
    @Override
    public ByteBuffer n(final int n) {
        return this.a.getOutputBuffer(n);
    }
    
    @Override
    public void release() {
        try {
            if (this.f == 1) {
                this.c.p();
                this.b.o();
            }
            this.f = 2;
        }
        finally {
            if (!this.e) {
                this.a.release();
                this.e = true;
            }
        }
    }
    
    public static final class Factory implements MediaCodecAdapter.Factory
    {
        private final Supplier<HandlerThread> a;
        private final Supplier<HandlerThread> b;
        private final boolean c;
        
        public Factory(final int n, final boolean b) {
            this((Supplier<HandlerThread>)new b(n), (Supplier<HandlerThread>)new c(n), b);
        }
        
        Factory(final Supplier<HandlerThread> a, final Supplier<HandlerThread> b, final boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public static HandlerThread b(final int n) {
            return e(n);
        }
        
        public static HandlerThread c(final int n) {
            return f(n);
        }
        
        private static HandlerThread e(final int n) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.r(n));
        }
        
        private static HandlerThread f(final int n) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.q(n));
        }
        
        @Override
        public /* bridge */ MediaCodecAdapter a(final Configuration configuration) throws IOException {
            return this.d(configuration);
        }
        
        public AsynchronousMediaCodecAdapter d(final Configuration configuration) throws IOException {
            final String a = configuration.a.a;
            AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter = null;
            MediaCodec byCodecName;
            try {
                final StringBuilder sb = new StringBuilder();
                sb.append("createCodec:");
                sb.append(a);
                TraceUtil.a(sb.toString());
                byCodecName = MediaCodec.createByCodecName(a);
                try {
                    final AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter2 = new AsynchronousMediaCodecAdapter(byCodecName, (HandlerThread)this.a.get(), (HandlerThread)this.b.get(), this.c, null);
                    try {
                        TraceUtil.c();
                        AsynchronousMediaCodecAdapter.p(asynchronousMediaCodecAdapter2, configuration.b, configuration.d, configuration.e, configuration.f);
                        return asynchronousMediaCodecAdapter2;
                    }
                    catch (final Exception ex) {
                        asynchronousMediaCodecAdapter = asynchronousMediaCodecAdapter2;
                    }
                }
                catch (final Exception ex) {}
            }
            catch (final Exception ex) {
                byCodecName = null;
            }
            if (asynchronousMediaCodecAdapter == null) {
                if (byCodecName != null) {
                    byCodecName.release();
                }
            }
            else {
                asynchronousMediaCodecAdapter.release();
            }
            throw;
        }
    }
}
