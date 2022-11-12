// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.annotation.KeepForSdk;

public abstract class PendingResult<R extends Result>
{
    @KeepForSdk
    public void b(final StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }
    
    public abstract R c(final long p0, final TimeUnit p1);
    
    public abstract void d();
    
    @KeepForSdk
    public interface StatusListener
    {
        @KeepForSdk
        void a(final Status p0);
    }
}
