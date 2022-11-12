// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamite;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import com.google.android.gms.internal.common.zzc;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.internal.common.zza;

public final class zzr extends zza
{
    zzr(final IBinder binder) {
        super(binder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }
    
    public final IObjectWrapper M0(IObjectWrapper m0, final String s, final int n, final IObjectWrapper objectWrapper) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzf(zza, (IInterface)m0);
        zza.writeString(s);
        zza.writeInt(n);
        zzc.zzf(zza, (IInterface)objectWrapper);
        final Parcel zzB = this.zzB(2, zza);
        m0 = IObjectWrapper.Stub.M0(zzB.readStrongBinder());
        zzB.recycle();
        return m0;
    }
    
    public final IObjectWrapper p1(final IObjectWrapper objectWrapper, final String s, final int n, final IObjectWrapper objectWrapper2) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzf(zza, (IInterface)objectWrapper);
        zza.writeString(s);
        zza.writeInt(n);
        zzc.zzf(zza, (IInterface)objectWrapper2);
        final Parcel zzB = this.zzB(3, zza);
        final IObjectWrapper m0 = IObjectWrapper.Stub.M0(zzB.readStrongBinder());
        zzB.recycle();
        return m0;
    }
}
