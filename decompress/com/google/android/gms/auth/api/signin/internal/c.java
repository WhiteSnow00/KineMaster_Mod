// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class c extends zba
{
    final d a;
    
    c(final d a) {
        this.a = a;
    }
    
    @Override
    public final void zbc(final Status status) throws RemoteException {
        this.a.i(status);
    }
}
