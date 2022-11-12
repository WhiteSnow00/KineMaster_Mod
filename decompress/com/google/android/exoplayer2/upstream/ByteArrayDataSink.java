// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.io.ByteArrayOutputStream;

public final class ByteArrayDataSink implements DataSink
{
    private ByteArrayOutputStream a;
    
    @Override
    public void b(final DataSpec dataSpec) {
        final long h = dataSpec.h;
        if (h == -1L) {
            this.a = new ByteArrayOutputStream();
        }
        else {
            Assertions.a(h <= 2147483647L);
            this.a = new ByteArrayOutputStream((int)dataSpec.h);
        }
    }
    
    @Override
    public void close() throws IOException {
        Util.j(this.a).close();
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) {
        Util.j(this.a).write(array, n, n2);
    }
}
