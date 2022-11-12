// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.net.SocketTimeoutException;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import com.google.android.exoplayer2.util.Assertions;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramSocket;
import android.net.Uri;
import java.net.DatagramPacket;

public final class UdpDataSource extends BaseDataSource
{
    private final int e;
    private final byte[] f;
    private final DatagramPacket g;
    private Uri h;
    private DatagramSocket i;
    private MulticastSocket j;
    private InetAddress k;
    private boolean l;
    private int m;
    
    public UdpDataSource() {
        this(2000);
    }
    
    public UdpDataSource(final int n) {
        this(n, 8000);
    }
    
    public UdpDataSource(final int n, final int e) {
        super(true);
        this.e = e;
        final byte[] f = new byte[n];
        this.f = f;
        this.g = new DatagramPacket(f, 0, n);
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws UdpDataSourceException {
        final Uri a = dataSpec.a;
        this.h = a;
        final String s = Assertions.e(a.getHost());
        final int port = this.h.getPort();
        this.u(dataSpec);
        try {
            this.k = InetAddress.getByName(s);
            final InetSocketAddress inetSocketAddress = new InetSocketAddress(this.k, port);
            if (this.k.isMulticastAddress()) {
                (this.j = new MulticastSocket(inetSocketAddress)).joinGroup(this.k);
                this.i = this.j;
            }
            else {
                this.i = new DatagramSocket(inetSocketAddress);
            }
            this.i.setSoTimeout(this.e);
            this.l = true;
            this.v(dataSpec);
            return -1L;
        }
        catch (final IOException ex) {
            throw new UdpDataSourceException(ex, 2001);
        }
        catch (final SecurityException ex2) {
            throw new UdpDataSourceException(ex2, 2006);
        }
    }
    
    @Override
    public void close() {
        this.h = null;
        final MulticastSocket j = this.j;
        Label_0033: {
            if (j == null) {
                break Label_0033;
            }
            while (true) {
                try {
                    j.leaveGroup(Assertions.e(this.k));
                    this.j = null;
                    final DatagramSocket i = this.i;
                    if (i != null) {
                        i.close();
                        this.i = null;
                    }
                    this.k = null;
                    this.m = 0;
                    if (this.l) {
                        this.l = false;
                        this.t();
                    }
                }
                catch (final IOException ex) {
                    continue;
                }
                break;
            }
        }
    }
    
    public int d() {
        final DatagramSocket i = this.i;
        if (i == null) {
            return -1;
        }
        return i.getLocalPort();
    }
    
    @Override
    public Uri q() {
        return this.h;
    }
    
    @Override
    public int read(final byte[] array, final int n, int min) throws UdpDataSourceException {
        if (min == 0) {
            return 0;
        }
        if (this.m == 0) {
            try {
                Assertions.e(this.i).receive(this.g);
                this.s(this.m = this.g.getLength());
            }
            catch (final IOException ex) {
                throw new UdpDataSourceException(ex, 2001);
            }
            catch (final SocketTimeoutException ex2) {
                throw new UdpDataSourceException(ex2, 2002);
            }
        }
        final int length = this.g.getLength();
        final int m = this.m;
        min = Math.min(m, min);
        System.arraycopy(this.f, length - m, array, n, min);
        this.m -= min;
        return min;
    }
    
    public static final class UdpDataSourceException extends DataSourceException
    {
        public UdpDataSourceException(final Throwable t, final int n) {
            super(t, n);
        }
    }
}
