// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class k0 extends zac
{
    protected final TaskCompletionSource b;
    
    public k0(final int n, final TaskCompletionSource b) {
        super(n);
        this.b = b;
    }
    
    @Override
    public final void a(final Status status) {
        this.b.d((Exception)new ApiException(status));
    }
    
    @Override
    public final void b(final Exception ex) {
        this.b.d(ex);
    }
    
    @Override
    public final void c(final zabq zabq) throws DeadObjectException {
        try {
            this.h(zabq);
        }
        catch (final RuntimeException ex) {
            this.b.d((Exception)ex);
        }
        catch (final RemoteException ex2) {
            this.a(zai.e(ex2));
        }
        catch (final DeadObjectException ex3) {
            this.a(zai.e((RemoteException)ex3));
            throw ex3;
        }
    }
    
    protected abstract void h(final zabq p0) throws RemoteException;
}
