// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag extends zac
{
    private final TaskApiCall b;
    private final TaskCompletionSource c;
    private final StatusExceptionMapper d;
    
    public zag(final int n, final TaskApiCall b, final TaskCompletionSource c, final StatusExceptionMapper d) {
        super(n);
        this.c = c;
        this.b = b;
        this.d = d;
        if (n == 2 && b.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }
    
    @Override
    public final void a(final Status status) {
        this.c.d(this.d.a(status));
    }
    
    @Override
    public final void b(final Exception ex) {
        this.c.d(ex);
    }
    
    @Override
    public final void c(final zabq zabq) throws DeadObjectException {
        try {
            this.b.b(zabq.s(), this.c);
        }
        catch (final RuntimeException ex) {
            this.c.d((Exception)ex);
        }
        catch (final RemoteException ex2) {
            this.a(zai.e(ex2));
        }
        catch (final DeadObjectException ex3) {
            throw ex3;
        }
    }
    
    @Override
    public final void d(final zaad zaad, final boolean b) {
        zaad.d(this.c, b);
    }
    
    @Override
    public final boolean f(final zabq zabq) {
        return this.b.c();
    }
    
    @Override
    public final Feature[] g(final zabq zabq) {
        return this.b.e();
    }
}
