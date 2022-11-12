// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzc;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.common.zzb;

public abstract class zzy extends zzb implements zzz
{
    public zzy() {
        super("com.google.android.gms.common.internal.ICertData");
    }
    
    public static zzz M0(final IBinder binder) {
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof zzz) {
            return (zzz)queryLocalInterface;
        }
        return new zzx(binder);
    }
    
    protected final boolean zza(int zzc, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
        if (zzc != 1) {
            if (zzc != 2) {
                return false;
            }
            zzc = this.zzc();
            parcel2.writeNoException();
            parcel2.writeInt(zzc);
        }
        else {
            final IObjectWrapper zzd = this.zzd();
            parcel2.writeNoException();
            zzc.zzf(parcel2, (IInterface)zzd);
        }
        return true;
    }
}
