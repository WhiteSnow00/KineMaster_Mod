// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.service;

import android.os.Bundle;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.common.Feature;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.GmsClient;

public final class zap extends GmsClient
{
    private final TelemetryLoggingOptions a;
    
    public zap(final Context context, final Looper looper, final ClientSettings clientSettings, final TelemetryLoggingOptions a, final ConnectionCallbacks connectionCallbacks, final OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 270, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.a = a;
    }
    
    @Override
    protected final IInterface createServiceInterface(final IBinder binder) {
        Object o;
        if (binder == null) {
            o = null;
        }
        else {
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
            if (queryLocalInterface instanceof zai) {
                o = queryLocalInterface;
            }
            else {
                o = new zai(binder);
            }
        }
        return (IInterface)o;
    }
    
    @Override
    public final Feature[] getApiFeatures() {
        return zaf.zab;
    }
    
    @Override
    protected final Bundle getGetServiceRequestExtraArgs() {
        return this.a.b();
    }
    
    @Override
    public final int getMinApkVersion() {
        return 203400000;
    }
    
    @Override
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }
    
    @Override
    protected final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }
    
    @Override
    protected final boolean getUseDynamicLookup() {
        return true;
    }
}
