// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.service;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.internal.GmsClient;

public final class zah extends GmsClient<zal>
{
    public zah(final Context context, final Looper looper, final ClientSettings clientSettings, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
    
    @Override
    protected final IInterface createServiceInterface(final IBinder binder) {
        Object o;
        if (binder == null) {
            o = null;
        }
        else {
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            if (queryLocalInterface instanceof zal) {
                o = queryLocalInterface;
            }
            else {
                o = new zal(binder);
            }
        }
        return (IInterface)o;
    }
    
    @Override
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
    
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.service.START";
    }
}
