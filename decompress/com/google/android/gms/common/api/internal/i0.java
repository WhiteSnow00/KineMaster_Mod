// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Result;

final class i0 implements Runnable
{
    final Result a;
    final zada b;
    
    i0(final zada b, final Result a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void run() {
        try {
            BasePendingResult.p.set(Boolean.TRUE);
            Preconditions.k(zada.b((zada<Result>)this.b)).b(this.a);
            final zada b = this.b;
            zada.c((zada<Result>)b);
            zada.c((zada<Result>)b);
            throw null;
        }
        catch (final RuntimeException ex) {}
        finally {
            BasePendingResult.p.set(Boolean.FALSE);
            zada.e((zada<Result>)this.b, this.a);
            final GoogleApiClient googleApiClient = (GoogleApiClient)zada.d((zada<Result>)this.b).get();
            if (googleApiClient != null) {
                googleApiClient.r(this.b);
            }
        }
    }
}
