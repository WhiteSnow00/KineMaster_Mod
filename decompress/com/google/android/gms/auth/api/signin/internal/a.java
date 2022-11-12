// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

final class a extends zba
{
    final b a;
    
    a(final b a) {
        this.a = a;
    }
    
    @Override
    public final void D(final GoogleSignInAccount googleSignInAccount, final Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zbn.c(this.a.t).e(this.a.u, googleSignInAccount);
        }
        this.a.i(new GoogleSignInResult(googleSignInAccount, status));
    }
}
