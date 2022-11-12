// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzcp extends zzaqw implements zzcq
{
    public zzcp() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }
    
    public static zzcq M0(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
        if (queryLocalInterface instanceof zzcq) {
            return (zzcq)queryLocalInterface;
        }
        return new zzco(binder);
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n == 1) {
            this.zze();
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
