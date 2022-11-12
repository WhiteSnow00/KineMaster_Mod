// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api;

import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.internal.auth.zzbe;
import com.google.android.gms.common.api.Api;

final class c extends AbstractClientBuilder<zzbe, AuthProxyOptions>
{
    @Override
    public final /* bridge */ Client d(final Context context, final Looper looper, final ClientSettings clientSettings, final Object o, final ConnectionCallbacks connectionCallbacks, final OnConnectionFailedListener onConnectionFailedListener) {
        return (Client)new zzbe(context, looper, clientSettings, (AuthProxyOptions)o, connectionCallbacks, onConnectionFailedListener);
    }
}
