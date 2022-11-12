// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.internal.base.zav;
import com.google.android.gms.common.Feature;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.internal.GmsClient;

public final class zaz extends GmsClient
{
    protected zaz(final Context context, final Looper looper, final ClientSettings clientSettings, final ConnectionCallbacks connectionCallbacks, final OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 308, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
    
    @Override
    protected final IInterface createServiceInterface(final IBinder binder) {
        Object o;
        if (binder == null) {
            o = null;
        }
        else {
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
            if (queryLocalInterface instanceof zaf) {
                o = queryLocalInterface;
            }
            else {
                o = new zaf(binder);
            }
        }
        return (IInterface)o;
    }
    
    @Override
    public final Feature[] getApiFeatures() {
        return zav.zab;
    }
    
    @Override
    public final int getMinApkVersion() {
        return 17895000;
    }
    
    @Override
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService";
    }
    
    @Override
    protected final String getStartServiceAction() {
        return "com.google.android.gms.chimera.container.moduleinstall.ModuleInstallService.START";
    }
    
    @Override
    protected final boolean getUseDynamicLookup() {
        return true;
    }
    
    @Override
    public final boolean usesClientTelemetry() {
        return true;
    }
}
