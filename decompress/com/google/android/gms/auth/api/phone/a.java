// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.phone;

import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.internal.auth_api_phone.zzw;
import com.google.android.gms.common.api.Api;

final class a extends AbstractClientBuilder<zzw, ApiOptions.NoOptions>
{
    @Override
    public final /* bridge */ Client d(final Context context, final Looper looper, final ClientSettings clientSettings, final Object o, final ConnectionCallbacks connectionCallbacks, final OnConnectionFailedListener onConnectionFailedListener) {
        final ApiOptions.NoOptions noOptions = (ApiOptions.NoOptions)o;
        return (Client)new zzw(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
