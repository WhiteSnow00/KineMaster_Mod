// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzbq extends zzaqw implements zzbr
{
    public zzbq() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            final IObjectWrapper m0 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
            zzaqx.zzc(parcel);
            this.zze(m0);
            parcel2.writeNoException();
        }
        else {
            final IObjectWrapper m2 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
            final String string = parcel.readString();
            final String string2 = parcel.readString();
            zzaqx.zzc(parcel);
            final boolean zzf = this.zzf(m2, string, string2);
            parcel2.writeNoException();
            zzaqx.zzd(parcel2, zzf);
        }
        return true;
    }
}
