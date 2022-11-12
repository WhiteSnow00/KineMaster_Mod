// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public final class DataSourceUtil
{
    private DataSourceUtil() {
    }
    
    public static void a(final DataSource dataSource) {
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        }
        catch (final IOException ex) {}
    }
}
