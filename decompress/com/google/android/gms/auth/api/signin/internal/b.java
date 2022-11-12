// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import android.content.Context;

final class b extends g
{
    final Context t;
    final GoogleSignInOptions u;
    
    b(final GoogleApiClient googleApiClient, final Context t, final GoogleSignInOptions u) {
        this.t = t;
        this.u = u;
        super(googleApiClient);
    }
    
    @Override
    protected final Result e(final Status status) {
        return new GoogleSignInResult(null, status);
    }
    
    @Override
    protected final /* bridge */ void q(final Api.AnyClient anyClient) throws RemoteException {
        ((zbe)anyClient).getService().q1(new a(this), this.u);
    }
}
