// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.crypto;

import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSink;

public final class AesCipherDataSink implements DataSink
{
    private final DataSink a;
    private final byte[] b;
    private final byte[] c;
    private AesFlushingCipher d;
    
    @Override
    public void b(final DataSpec dataSpec) throws IOException {
        this.a.b(dataSpec);
        this.d = new AesFlushingCipher(1, this.b, dataSpec.i, dataSpec.g + dataSpec.b);
    }
    
    @Override
    public void close() throws IOException {
        this.d = null;
        this.a.close();
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) throws IOException {
        if (this.c == null) {
            Util.j(this.d).e(array, n, n2);
            this.a.write(array, n, n2);
        }
        else {
            int min;
            for (int i = 0; i < n2; i += min) {
                min = Math.min(n2 - i, this.c.length);
                Util.j(this.d).d(array, n + i, min, this.c, 0);
                this.a.write(this.c, 0, min);
            }
        }
    }
}
