// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.signin.internal.zbe;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import java.util.Collections;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.List;
import com.google.android.gms.common.api.Api;

final class b extends AbstractClientBuilder
{
    @Override
    public final /* bridge */ List a(final Object o) {
        final GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions)o;
        Object o2;
        if (googleSignInOptions == null) {
            o2 = Collections.emptyList();
        }
        else {
            o2 = googleSignInOptions.M1();
        }
        return (List)o2;
    }
    
    @Override
    public final Client c(final Context context, final Looper looper, final ClientSettings clientSettings, final Object o, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zbe(context, looper, clientSettings, (GoogleSignInOptions)o, connectionCallbacks, onConnectionFailedListener);
    }
}
