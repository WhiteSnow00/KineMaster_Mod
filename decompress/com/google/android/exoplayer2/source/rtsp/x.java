// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.common.primitives.Ints;
import com.google.android.exoplayer2.upstream.UdpDataSource;

final class x implements RtpDataChannel
{
    private final UdpDataSource a;
    private x b;
    
    public x(final long n) {
        this.a = new UdpDataSource(2000, Ints.d(n));
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws IOException {
        return this.a.b(dataSpec);
    }
    
    @Override
    public String c() {
        final int d = this.d();
        Assertions.g(d != -1);
        return Util.C("RTP/AVP;unicast;client_port=%d-%d", d, d + 1);
    }
    
    @Override
    public void close() {
        this.a.close();
        try (final x b = this.b) {}
    }
    
    @Override
    public int d() {
        int d;
        if ((d = this.a.d()) == -1) {
            d = -1;
        }
        return d;
    }
    
    @Override
    public void e(final TransferListener transferListener) {
        this.a.e(transferListener);
    }
    
    public void j(final x b) {
        Assertions.a(this != b);
        this.b = b;
    }
    
    @Override
    public RtspMessageChannel.InterleavedBinaryDataListener l() {
        return null;
    }
    
    @Override
    public Uri q() {
        return this.a.q();
    }
    
    @Override
    public int read(final byte[] array, int read, final int n) throws IOException {
        try {
            read = this.a.read(array, read, n);
            return read;
        }
        catch (final UdpDataSource.UdpDataSourceException ex) {
            if (ex.reason == 2002) {
                return -1;
            }
            throw ex;
        }
    }
}
