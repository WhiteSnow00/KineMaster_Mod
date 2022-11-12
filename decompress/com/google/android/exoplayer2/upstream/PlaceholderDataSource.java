// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import f4.b;

public final class PlaceholderDataSource implements DataSource
{
    public static final PlaceholderDataSource a;
    public static final Factory b;
    
    static {
        a = new PlaceholderDataSource();
        b = (Factory)f4.b.a;
    }
    
    private PlaceholderDataSource() {
    }
    
    public static PlaceholderDataSource j() {
        return new PlaceholderDataSource();
    }
    
    @Override
    public long b(final DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public void e(final TransferListener transferListener) {
    }
    
    @Override
    public Uri q() {
        return null;
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) {
        throw new UnsupportedOperationException();
    }
}
