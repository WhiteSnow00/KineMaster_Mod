// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api;

import com.google.android.gms.internal.auth_api.zbo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.api.Api;

final class a extends AbstractClientBuilder
{
    @Override
    public final Client c(final Context context, final Looper looper, final ClientSettings clientSettings, final Object o, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return (Client)new zbo(context, looper, clientSettings, (Auth.AuthCredentialsOptions)o, connectionCallbacks, onConnectionFailedListener);
    }
}
