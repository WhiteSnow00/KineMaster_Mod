// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import android.content.res.AssetManager;

public abstract class b<T> implements d<T>
{
    private final String a;
    private final AssetManager b;
    private T c;
    
    public b(final AssetManager b, final String a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public void b() {
        final T c = this.c;
        if (c == null) {
            return;
        }
        try {
            this.c(c);
        }
        catch (final IOException ex) {}
    }
    
    protected abstract void c(final T p0) throws IOException;
    
    @Override
    public void cancel() {
    }
    
    @Override
    public DataSource d() {
        return DataSource.LOCAL;
    }
    
    @Override
    public void e(final Priority priority, final a<? super T> a) {
        try {
            a.f(this.c = this.f(this.b, this.a));
        }
        catch (final IOException ex) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", (Throwable)ex);
            }
            a.c(ex);
        }
    }
    
    protected abstract T f(final AssetManager p0, final String p1) throws IOException;
}
