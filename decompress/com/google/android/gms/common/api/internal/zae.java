// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

public final class zae extends zai
{
    protected final BaseImplementation.ApiMethodImpl b;
    
    public zae(final int n, final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        super(n);
        this.b = (BaseImplementation.ApiMethodImpl)Preconditions.l(apiMethodImpl, "Null methods are not runnable.");
    }
    
    @Override
    public final void a(final Status status) {
        try {
            this.b.w(status);
        }
        catch (final IllegalStateException ex) {
            Log.w("ApiCallRunner", "Exception reporting failure", (Throwable)ex);
        }
    }
    
    @Override
    public final void b(final Exception ex) {
        final String simpleName = ex.getClass().getSimpleName();
        final String localizedMessage = ex.getLocalizedMessage();
        final StringBuilder sb = new StringBuilder();
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        final Status status = new Status(10, sb.toString());
        try {
            this.b.w(status);
        }
        catch (final IllegalStateException ex2) {
            Log.w("ApiCallRunner", "Exception reporting failure", (Throwable)ex2);
        }
    }
    
    @Override
    public final void c(final zabq zabq) throws DeadObjectException {
        try {
            this.b.u(zabq.s());
        }
        catch (final RuntimeException ex) {
            this.b(ex);
        }
    }
    
    @Override
    public final void d(final zaad zaad, final boolean b) {
        zaad.c(this.b, b);
    }
}
