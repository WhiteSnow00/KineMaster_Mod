// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.account;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.internal.auth.zzam;
import com.google.android.gms.common.api.Api;

final class a extends AbstractClientBuilder<zzam, ApiOptions.NoOptions>
{
    @Override
    public final /* bridge */ Client c(final Context context, final Looper looper, final ClientSettings clientSettings, final Object o, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        final ApiOptions.NoOptions noOptions = (ApiOptions.NoOptions)o;
        return (Client)new zzam(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
