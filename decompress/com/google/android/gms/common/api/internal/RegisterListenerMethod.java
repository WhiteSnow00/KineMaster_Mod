// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

@KeepForSdk
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L>
{
    private final ListenerHolder a;
    private final Feature[] b;
    private final boolean c;
    private final int d;
    
    @KeepForSdk
    public void a() {
        this.a.a();
    }
    
    @KeepForSdk
    public ListenerHolder.ListenerKey<L> b() {
        return this.a.b();
    }
    
    @KeepForSdk
    public Feature[] c() {
        return this.b;
    }
    
    @KeepForSdk
    protected abstract void d(final A p0, final TaskCompletionSource<Void> p1) throws RemoteException;
    
    public final int e() {
        return this.d;
    }
    
    public final boolean f() {
        return this.c;
    }
}
