// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.Releasable;
import javax.annotation.concurrent.GuardedBy;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.lang.ref.WeakReference;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.api.Result;

public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R>
{
    private ResultTransform a;
    private zada b;
    private volatile ResultCallbacks c;
    private final Object d;
    private Status e;
    private final WeakReference f;
    
    static /* bridge */ ResultTransform b(final zada zada) {
        return zada.a;
    }
    
    static /* bridge */ j0 c(final zada zada) {
        Objects.requireNonNull(zada);
        return null;
    }
    
    static /* bridge */ WeakReference d(final zada zada) {
        return zada.f;
    }
    
    static /* bridge */ void e(final zada zada, final Result result) {
        j(result);
    }
    
    private final void g(final Status e) {
        synchronized (this.d) {
            this.h(this.e = e);
        }
    }
    
    private final void h(Status status) {
        synchronized (this.d) {
            final ResultTransform a = this.a;
            if (a != null) {
                status = Preconditions.l(a.a(status), "onFailure must not return null");
                Preconditions.k(this.b).g(status);
            }
            else if (this.i()) {
                Preconditions.k(this.c).b(status);
            }
        }
    }
    
    @GuardedBy
    private final boolean i() {
        final GoogleApiClient googleApiClient = (GoogleApiClient)this.f.get();
        return this.c != null && googleApiClient != null;
    }
    
    private static final void j(final Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable)result).release();
            }
            catch (final RuntimeException ex) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), (Throwable)ex);
            }
        }
    }
    
    @Override
    public final void a(final Result result) {
        synchronized (this.d) {
            if (result.getStatus().P1()) {
                if (this.a != null) {
                    zaco.a().submit(new i0(this, result));
                }
                else if (this.i()) {
                    Preconditions.k(this.c).c(result);
                }
            }
            else {
                this.g(result.getStatus());
                j(result);
            }
        }
    }
    
    final void f() {
        this.c = null;
    }
}
