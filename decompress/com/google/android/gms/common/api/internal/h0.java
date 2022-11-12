// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.Feature;

final class h0 extends TaskApiCall
{
    final Builder d;
    
    h0(final Builder d, final Feature[] array, final boolean b, final int n) {
        this.d = d;
        super(array, b, n);
    }
    
    @Override
    protected final void b(final Api.AnyClient anyClient, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        Builder.f((Builder<Api.AnyClient, Object>)this.d).accept(anyClient, taskCompletionSource);
    }
}
