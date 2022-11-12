// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.GoogleApiClient;

final class f extends g
{
    f(final GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }
    
    @Override
    protected final /* bridge */ Result e(final Status status) {
        return status;
    }
    
    @Override
    protected final /* bridge */ void q(final Api.AnyClient anyClient) throws RemoteException {
        final zbe zbe = (zbe)anyClient;
        ((zbs)zbe.getService()).M0(new e(this), zbe.e());
    }
}
