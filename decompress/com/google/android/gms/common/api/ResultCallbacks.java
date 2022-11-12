// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import android.util.Log;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R>
{
    @KeepForSdk
    @Override
    public final void a(final R r) {
        final Status status = r.getStatus();
        if (status.P1()) {
            this.c(r);
            return;
        }
        this.b(status);
        if (r instanceof Releasable) {
            try {
                ((Releasable)r).release();
            }
            catch (final RuntimeException ex) {
                Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(r)), (Throwable)ex);
            }
        }
    }
    
    public abstract void b(final Status p0);
    
    public abstract void c(final R p0);
}
