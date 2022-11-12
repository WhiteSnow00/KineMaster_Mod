// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public interface DataSink
{
    void b(final DataSpec p0) throws IOException;
    
    void close() throws IOException;
    
    void write(final byte[] p0, final int p1, final int p2) throws IOException;
    
    public interface Factory
    {
        DataSink a();
    }
}
