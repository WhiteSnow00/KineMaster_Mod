// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.io.IOException;

public interface DataSource extends DataReader
{
    long b(final DataSpec p0) throws IOException;
    
    void close() throws IOException;
    
    void e(final TransferListener p0);
    
    default Map<String, List<String>> g() {
        return Collections.emptyMap();
    }
    
    Uri q();
    
    public interface Factory
    {
        DataSource createDataSource();
    }
}
