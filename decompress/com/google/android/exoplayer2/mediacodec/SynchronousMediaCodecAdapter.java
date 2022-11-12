// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import com.google.android.exoplayer2.util.TraceUtil;
import android.media.MediaCodec$BufferInfo;
import android.os.Bundle;
import android.view.Surface;
import android.media.MediaCodec$OnFrameRenderedListener;
import android.os.Handler;
import android.media.MediaFormat;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import android.media.MediaCodec;

public final class SynchronousMediaCodecAdapter implements MediaCodecAdapter
{
    private final MediaCodec a;
    private ByteBuffer[] b;
    private ByteBuffer[] c;
    
    private SynchronousMediaCodecAdapter(final MediaCodec a) {
        this.a = a;
        if (Util.a < 21) {
            this.b = a.getInputBuffers();
            this.c = a.getOutputBuffers();
        }
    }
    
    SynchronousMediaCodecAdapter(final MediaCodec mediaCodec, final SynchronousMediaCodecAdapter$a object) {
        this(mediaCodec);
    }
    
    public static void o(final SynchronousMediaCodecAdapter synchronousMediaCodecAdapter, final OnFrameRenderedListener onFrameRenderedListener, final MediaCodec mediaCodec, final long n, final long n2) {
        synchronousMediaCodecAdapter.p(onFrameRenderedListener, mediaCodec, n, n2);
    }
    
    private void p(final OnFrameRenderedListener onFrameRenderedListener, final MediaCodec mediaCodec, final long n, final long n2) {
        onFrameRenderedListener.a(this, n, n2);
    }
    
    @Override
    public void a(final int n, final int n2, final CryptoInfo cryptoInfo, final long n3, final int n4) {
        this.a.queueSecureInputBuffer(n, n2, cryptoInfo.a(), n3, n4);
    }
    
    @Override
    public MediaFormat b() {
        return this.a.getOutputFormat();
    }
    
    @Override
    public void c(final OnFrameRenderedListener onFrameRenderedListener, final Handler handler) {
        this.a.setOnFrameRenderedListener((MediaCodec$OnFrameRenderedListener)new o(this, onFrameRenderedListener), handler);
    }
    
    @Override
    public void d(final int videoScalingMode) {
        this.a.setVideoScalingMode(videoScalingMode);
    }
    
    @Override
    public ByteBuffer e(final int n) {
        if (Util.a >= 21) {
            return this.a.getInputBuffer(n);
        }
        return Util.j(this.b)[n];
    }
    
    @Override
    public void f(final Surface outputSurface) {
        this.a.setOutputSurface(outputSurface);
    }
    
    @Override
    public void flush() {
        this.a.flush();
    }
    
    @Override
    public void g(final int n, final int n2, final int n3, final long n4, final int n5) {
        this.a.queueInputBuffer(n, n2, n3, n4, n5);
    }
    
    @Override
    public boolean h() {
        return false;
    }
    
    @Override
    public void i(final Bundle parameters) {
        this.a.setParameters(parameters);
    }
    
    @Override
    public void j(final int n, final long n2) {
        this.a.releaseOutputBuffer(n, n2);
    }
    
    @Override
    public int k() {
        return this.a.dequeueInputBuffer(0L);
    }
    
    @Override
    public int l(final MediaCodec$BufferInfo mediaCodec$BufferInfo) {
        int i;
        do {
            i = this.a.dequeueOutputBuffer(mediaCodec$BufferInfo, 0L);
            if (i == -3 && Util.a < 21) {
                this.c = this.a.getOutputBuffers();
            }
        } while (i == -3);
        return i;
    }
    
    @Override
    public void m(final int n, final boolean b) {
        this.a.releaseOutputBuffer(n, b);
    }
    
    @Override
    public ByteBuffer n(final int n) {
        if (Util.a >= 21) {
            return this.a.getOutputBuffer(n);
        }
        return Util.j(this.c)[n];
    }
    
    @Override
    public void release() {
        this.b = null;
        this.c = null;
        this.a.release();
    }
    
    public static class Factory implements MediaCodecAdapter.Factory
    {
        @Override
        public MediaCodecAdapter a(Configuration ex) throws IOException {
            final MediaCodec mediaCodec = null;
            MediaCodec b;
            try {
                b = this.b((Configuration)ex);
                try {
                    TraceUtil.a("configureCodec");
                    b.configure(((Configuration)ex).b, ((Configuration)ex).d, ((Configuration)ex).e, ((Configuration)ex).f);
                    TraceUtil.c();
                    TraceUtil.a("startCodec");
                    b.start();
                    TraceUtil.c();
                    ex = (RuntimeException)new SynchronousMediaCodecAdapter(b, null);
                    return (MediaCodecAdapter)ex;
                }
                catch (final RuntimeException ex) {}
                catch (final IOException ex2) {}
            }
            catch (final RuntimeException ex) {
                b = mediaCodec;
            }
            catch (final IOException ex) {
                b = mediaCodec;
            }
            if (b != null) {
                b.release();
            }
            throw ex;
        }
        
        protected MediaCodec b(final Configuration configuration) throws IOException {
            Assertions.e(configuration.a);
            final String a = configuration.a.a;
            final StringBuilder sb = new StringBuilder();
            sb.append("createCodec:");
            sb.append(a);
            TraceUtil.a(sb.toString());
            final MediaCodec byCodecName = MediaCodec.createByCodecName(a);
            TraceUtil.c();
            return byCodecName;
        }
    }
}
