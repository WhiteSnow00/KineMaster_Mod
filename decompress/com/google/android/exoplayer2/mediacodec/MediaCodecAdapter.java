// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import java.io.IOException;
import android.media.MediaCrypto;
import com.google.android.exoplayer2.Format;
import android.media.MediaCodec$BufferInfo;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;
import android.os.Handler;
import android.media.MediaFormat;
import com.google.android.exoplayer2.decoder.CryptoInfo;

public interface MediaCodecAdapter
{
    void a(final int p0, final int p1, final CryptoInfo p2, final long p3, final int p4);
    
    MediaFormat b();
    
    void c(final OnFrameRenderedListener p0, final Handler p1);
    
    void d(final int p0);
    
    ByteBuffer e(final int p0);
    
    void f(final Surface p0);
    
    void flush();
    
    void g(final int p0, final int p1, final int p2, final long p3, final int p4);
    
    boolean h();
    
    void i(final Bundle p0);
    
    void j(final int p0, final long p1);
    
    int k();
    
    int l(final MediaCodec$BufferInfo p0);
    
    void m(final int p0, final boolean p1);
    
    ByteBuffer n(final int p0);
    
    void release();
    
    public static final class Configuration
    {
        public final MediaCodecInfo a;
        public final MediaFormat b;
        public final Format c;
        public final Surface d;
        public final MediaCrypto e;
        public final int f;
        
        private Configuration(final MediaCodecInfo a, final MediaFormat b, final Format c, final Surface d, final MediaCrypto e, final int f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }
        
        public static Configuration a(final MediaCodecInfo mediaCodecInfo, final MediaFormat mediaFormat, final Format format, final MediaCrypto mediaCrypto) {
            return new Configuration(mediaCodecInfo, mediaFormat, format, null, mediaCrypto, 0);
        }
        
        public static Configuration b(final MediaCodecInfo mediaCodecInfo, final MediaFormat mediaFormat, final Format format, final Surface surface, final MediaCrypto mediaCrypto) {
            return new Configuration(mediaCodecInfo, mediaFormat, format, surface, mediaCrypto, 0);
        }
    }
    
    public interface Factory
    {
        MediaCodecAdapter a(final Configuration p0) throws IOException;
    }
    
    public interface OnFrameRenderedListener
    {
        void a(final MediaCodecAdapter p0, final long p1, final long p2);
    }
}
