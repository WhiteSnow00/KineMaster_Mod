// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface RemoteCall<T, U>
{
    @KeepForSdk
    void accept(final T p0, final U p1) throws RemoteException;
}
