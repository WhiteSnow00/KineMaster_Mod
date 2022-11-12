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

public final class zzq extends zza
{
    zzq(final IBinder binder) {
        super(binder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }
    
    public final int M0(final IObjectWrapper objectWrapper, final String s, final boolean b) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzf(zza, (IInterface)objectWrapper);
        zza.writeString(s);
        zzc.zzc(zza, b);
        final Parcel zzB = this.zzB(3, zza);
        final int int1 = zzB.readInt();
        zzB.recycle();
        return int1;
    }
    
    public final int p1(final IObjectWrapper objectWrapper, final String s, final boolean b) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzf(zza, (IInterface)objectWrapper);
        zza.writeString(s);
        zzc.zzc(zza, b);
        final Parcel zzB = this.zzB(5, zza);
        final int int1 = zzB.readInt();
        zzB.recycle();
        return int1;
    }
    
    public final IObjectWrapper q1(IObjectWrapper m0, final String s, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzf(zza, (IInterface)m0);
        zza.writeString(s);
        zza.writeInt(n);
        final Parcel zzB = this.zzB(2, zza);
        m0 = IObjectWrapper.Stub.M0(zzB.readStrongBinder());
        zzB.recycle();
        return m0;
    }
    
    public final IObjectWrapper r1(final IObjectWrapper objectWrapper, final String s, final int n, final IObjectWrapper objectWrapper2) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzf(zza, (IInterface)objectWrapper);
        zza.writeString(s);
        zza.writeInt(n);
        zzc.zzf(zza, (IInterface)objectWrapper2);
        final Parcel zzB = this.zzB(8, zza);
        final IObjectWrapper m0 = IObjectWrapper.Stub.M0(zzB.readStrongBinder());
        zzB.recycle();
        return m0;
    }
    
    public final IObjectWrapper s1(final IObjectWrapper objectWrapper, final String s, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzf(zza, (IInterface)objectWrapper);
        zza.writeString(s);
        zza.writeInt(n);
        final Parcel zzB = this.zzB(4, zza);
        final IObjectWrapper m0 = IObjectWrapper.Stub.M0(zzB.readStrongBinder());
        zzB.recycle();
        return m0;
    }
    
    public final IObjectWrapper t1(final IObjectWrapper objectWrapper, final String s, final boolean b, final long n) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzf(zza, (IInterface)objectWrapper);
        zza.writeString(s);
        zzc.zzc(zza, b);
        zza.writeLong(n);
        final Parcel zzB = this.zzB(7, zza);
        final IObjectWrapper m0 = IObjectWrapper.Stub.M0(zzB.readStrongBinder());
        zzB.recycle();
        return m0;
    }
    
    public final int zze() throws RemoteException {
        final Parcel zzB = this.zzB(6, this.zza());
        final int int1 = zzB.readInt();
        zzB.recycle();
        return int1;
    }
}
