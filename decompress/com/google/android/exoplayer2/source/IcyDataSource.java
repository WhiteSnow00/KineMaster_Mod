// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.DataSource;

final class IcyDataSource implements DataSource
{
    private final DataSource a;
    private final int b;
    private final Listener c;
    private final byte[] d;
    private int e;
    
    public IcyDataSource(final DataSource a, final int n, final Listener c) {
        Assertions.a(n > 0);
        this.a = a;
        this.b = n;
        this.c = c;
        this.d = new byte[1];
        this.e = n;
    }
    
    private boolean j() throws IOException {
        if (this.a.read(this.d, 0, 1) == -1) {
            return false;
        }
        final int n = (this.d[0] & 0xFF) << 4;
        if (n == 0) {
            return true;
        }
        final byte[] array = new byte[n];
        int n2 = n;
        int n3 = 0;
        int n4;
        while (true) {
            n4 = n;
            if (n2 <= 0) {
                break;
            }
            final int read = this.a.read(array, n3, n2);
            if (read == -1) {
                return false;
            }
            n3 += read;
            n2 -= read;
        }
        while (n4 > 0 && array[n4 - 1] == 0) {
            --n4;
        }
        if (n4 > 0) {
            this.c.b(new ParsableByteArray(array, n4));
        }
        return true;
    }
    
    @Override
    public long b(final DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void close() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void e(final TransferListener transferListener) {
        Assertions.e(transferListener);
        this.a.e(transferListener);
    }
    
    @Override
    public Map<String, List<String>> g() {
        return this.a.g();
    }
    
    @Override
    public Uri q() {
        return this.a.q();
    }
    
    @Override
    public int read(final byte[] array, int read, final int n) throws IOException {
        if (this.e == 0) {
            if (!this.j()) {
                return -1;
            }
            this.e = this.b;
        }
        read = this.a.read(array, read, Math.min(this.e, n));
        if (read != -1) {
            this.e -= read;
        }
        return read;
    }
    
    public interface Listener
    {
        void b(final ParsableByteArray p0);
    }
}
