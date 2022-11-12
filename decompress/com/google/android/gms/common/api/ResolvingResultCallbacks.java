// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import android.content.IntentSender$SendIntentException;
import android.util.Log;
import android.app.Activity;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R>
{
    private final Activity a;
    private final int b;
    
    @KeepForSdk
    @Override
    public final void b(final Status status) {
        if (status.O1()) {
            try {
                status.Q1(this.a, this.b);
                return;
            }
            catch (final IntentSender$SendIntentException ex) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", (Throwable)ex);
                this.d(new Status(8));
                return;
            }
        }
        this.d(status);
    }
    
    public abstract void d(final Status p0);
}
