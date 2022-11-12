// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;

abstract class g extends ApiMethodImpl
{
    public g(final GoogleApiClient googleApiClient) {
        super(Auth.c, googleApiClient);
    }
    
    @KeepForSdk
    @Override
    public final /* bridge */ void a(final Object o) {
        super.i((Result)o);
    }
}
