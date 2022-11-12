// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

@KeepForSdk
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L>
{
    private final ListenerHolder.ListenerKey a;
    
    @KeepForSdk
    public ListenerHolder.ListenerKey<L> a() {
        return this.a;
    }
    
    @KeepForSdk
    protected abstract void b(final A p0, final TaskCompletionSource<Boolean> p1) throws RemoteException;
}
