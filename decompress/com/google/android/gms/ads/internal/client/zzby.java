// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzby extends zzaqw implements zzbz
{
    public zzby() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }
    
    public static zzbz zzd(final IBinder binder) {
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        if (queryLocalInterface instanceof zzbz) {
            return (zzbz)queryLocalInterface;
        }
        return new zzbx(binder);
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n == 1) {
            final String string = parcel.readString();
            final String string2 = parcel.readString();
            zzaqx.zzc(parcel);
            this.zzc(string, string2);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
