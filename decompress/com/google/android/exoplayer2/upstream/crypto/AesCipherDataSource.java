// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.crypto;

import com.google.android.exoplayer2.util.Util;
import android.net.Uri;
import java.util.List;
import java.util.Map;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSource;

public final class AesCipherDataSource implements DataSource
{
    private final DataSource a;
    private final byte[] b;
    private AesFlushingCipher c;
    
    @Override
    public long b(final DataSpec dataSpec) throws IOException {
        final long b = this.a.b(dataSpec);
        this.c = new AesFlushingCipher(2, this.b, dataSpec.i, dataSpec.g + dataSpec.b);
        return b;
    }
    
    @Override
    public void close() throws IOException {
        this.c = null;
        this.a.close();
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
    public int read(final byte[] array, final int n, int read) throws IOException {
        if (read == 0) {
            return 0;
        }
        read = this.a.read(array, n, read);
        if (read == -1) {
            return -1;
        }
        Util.j(this.c).e(array, n, read);
        return read;
    }
}
