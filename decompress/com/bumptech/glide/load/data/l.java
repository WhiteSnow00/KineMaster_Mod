// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import java.io.FileNotFoundException;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import android.content.ContentResolver;
import android.net.Uri;

public abstract class l<T> implements d<T>
{
    private final Uri a;
    private final ContentResolver b;
    private T c;
    
    public l(final ContentResolver b, final Uri a) {
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
    public final void e(final Priority priority, final a<? super T> a) {
        try {
            a.f(this.c = this.f(this.a, this.b));
        }
        catch (final FileNotFoundException ex) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", (Throwable)ex);
            }
            a.c(ex);
        }
    }
    
    protected abstract T f(final Uri p0, final ContentResolver p1) throws FileNotFoundException;
}
