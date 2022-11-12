// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class e extends zba
{
    final f a;
    
    e(final f a) {
        this.a = a;
    }
    
    @Override
    public final void N0(final Status status) throws RemoteException {
        this.a.i(status);
    }
}
