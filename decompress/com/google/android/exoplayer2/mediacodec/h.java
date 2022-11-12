// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.Format;

final class h
{
    private long a;
    private long b;
    private boolean c;
    
    private long a(final long n) {
        return this.a + Math.max(0L, (this.b - 529L) * 1000000L / n);
    }
    
    public long b(final Format format) {
        return this.a(format.K);
    }
    
    public void c() {
        this.a = 0L;
        this.b = 0L;
        this.c = false;
    }
    
    public long d(final Format format, final DecoderInputBuffer decoderInputBuffer) {
        if (this.b == 0L) {
            this.a = decoderInputBuffer.f;
        }
        if (this.c) {
            return decoderInputBuffer.f;
        }
        final ByteBuffer byteBuffer = Assertions.e(decoderInputBuffer.d);
        int i = 0;
        int n = 0;
        while (i < 4) {
            n = (n << 8 | (byteBuffer.get(i) & 0xFF));
            ++i;
        }
        final int m = MpegAudioUtil.m(n);
        if (m == -1) {
            this.c = true;
            this.b = 0L;
            this.a = decoderInputBuffer.f;
            Log.i("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return decoderInputBuffer.f;
        }
        final long a = this.a(format.K);
        this.b += m;
        return a;
    }
}
