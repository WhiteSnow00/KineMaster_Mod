// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbtz;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzci extends zzaqw implements zzcj
{
    public zzci() {
        super("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }
    
    public static zzcj asInterface(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
        if (queryLocalInterface instanceof zzcj) {
            return (zzcj)queryLocalInterface;
        }
        return new zzch(binder);
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            final zzbtz adapterCreator = this.getAdapterCreator();
            parcel2.writeNoException();
            zzaqx.zzg(parcel2, (IInterface)adapterCreator);
        }
        else {
            final zzei liteSdkVersion = this.getLiteSdkVersion();
            parcel2.writeNoException();
            zzaqx.zzf(parcel2, (Parcelable)liteSdkVersion);
        }
        return true;
    }
}
