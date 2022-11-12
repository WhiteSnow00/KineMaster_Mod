// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.util.Log;
import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;
import android.os.IBinder;

public final class zzf extends i
{
    public final IBinder g;
    final BaseGmsClient h;
    
    public zzf(final BaseGmsClient h, final int n, final IBinder g, final Bundle bundle) {
        super(this.h = h, n, bundle);
        this.g = g;
    }
    
    @Override
    protected final void f(final ConnectionResult connectionResult) {
        if (BaseGmsClient.zzc((BaseGmsClient<IInterface>)this.h) != null) {
            BaseGmsClient.zzc((BaseGmsClient<IInterface>)this.h).onConnectionFailed(connectionResult);
        }
        this.h.onConnectionFailed(connectionResult);
    }
    
    @Override
    protected final boolean g() {
        try {
            final IBinder g = this.g;
            Preconditions.k(g);
            final String interfaceDescriptor = g.getInterfaceDescriptor();
            if (!this.h.getServiceDescriptor().equals(interfaceDescriptor)) {
                final String serviceDescriptor = this.h.getServiceDescriptor();
                final StringBuilder sb = new StringBuilder();
                sb.append("service descriptor mismatch: ");
                sb.append(serviceDescriptor);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                Log.w("GmsClient", sb.toString());
                return false;
            }
            final IInterface serviceInterface = this.h.createServiceInterface(this.g);
            if (serviceInterface != null && (BaseGmsClient.zzn((BaseGmsClient<IInterface>)this.h, 2, 4, serviceInterface) || BaseGmsClient.zzn((BaseGmsClient<IInterface>)this.h, 3, 4, serviceInterface))) {
                BaseGmsClient.zzg((BaseGmsClient<IInterface>)this.h, (ConnectionResult)null);
                final Bundle connectionHint = this.h.getConnectionHint();
                final BaseGmsClient h = this.h;
                if (BaseGmsClient.zzb((BaseGmsClient<IInterface>)h) != null) {
                    BaseGmsClient.zzb((BaseGmsClient<IInterface>)h).onConnected(connectionHint);
                }
                return true;
            }
            return false;
        }
        catch (final RemoteException ex) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
