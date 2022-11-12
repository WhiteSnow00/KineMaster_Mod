// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.api.Api;

final class b extends AbstractClientBuilder
{
    @Override
    public final Client d(final Context context, final Looper looper, final ClientSettings clientSettings, final Object o, final ConnectionCallbacks connectionCallbacks, final OnConnectionFailedListener onConnectionFailedListener) {
        return new zap(context, looper, clientSettings, (TelemetryLoggingOptions)o, connectionCallbacks, onConnectionFailedListener);
    }
}
