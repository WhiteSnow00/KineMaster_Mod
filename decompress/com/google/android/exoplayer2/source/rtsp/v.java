// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.concurrent.LinkedBlockingQueue;
import com.google.android.exoplayer2.upstream.BaseDataSource;

final class v extends BaseDataSource implements RtpDataChannel, InterleavedBinaryDataListener
{
    private final LinkedBlockingQueue<byte[]> e;
    private final long f;
    private byte[] g;
    private int h;
    
    public v(final long f) {
        super(true);
        this.f = f;
        this.e = new LinkedBlockingQueue<byte[]>();
        this.g = new byte[0];
        this.h = -1;
    }
    
    @Override
    public long b(final DataSpec dataSpec) {
        this.h = dataSpec.a.getPort();
        return -1L;
    }
    
    @Override
    public String c() {
        Assertions.g(this.h != -1);
        return Util.C("RTP/AVP/TCP;unicast;interleaved=%d-%d", this.h, this.h + 1);
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public int d() {
        return this.h;
    }
    
    @Override
    public void j(final byte[] array) {
        this.e.add(array);
    }
    
    @Override
    public InterleavedBinaryDataListener l() {
        return this;
    }
    
    @Override
    public Uri q() {
        return null;
    }
    
    @Override
    public int read(final byte[] array, final int n, int min) {
        if (min == 0) {
            return 0;
        }
        final int min2 = Math.min(min, this.g.length);
        System.arraycopy(this.g, 0, array, n, min2);
        final int n2 = min2 + 0;
        final byte[] g = this.g;
        this.g = Arrays.copyOfRange(g, min2, g.length);
        if (n2 == min) {
            return n2;
        }
        try {
            final byte[] array2 = this.e.poll(this.f, TimeUnit.MILLISECONDS);
            if (array2 == null) {
                return -1;
            }
            min = Math.min(min - n2, array2.length);
            System.arraycopy(array2, 0, array, n + n2, min);
            if (min < array2.length) {
                this.g = Arrays.copyOfRange(array2, min, array2.length);
            }
            return n2 + min;
        }
        catch (final InterruptedException ex) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }
}
