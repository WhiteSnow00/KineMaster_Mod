// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.common.zzs;
import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import com.google.android.gms.internal.common.zzc;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzo;
import android.os.IBinder;
import com.google.android.gms.internal.common.zza;

public final class zzad extends zza implements zzaf
{
    zzad(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }
    
    public final zzq K0(final zzo zzo) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzd(zza, (Parcelable)zzo);
        final Parcel zzB = this.zzB(6, zza);
        final zzq zzq = (zzq)zzc.zza(zzB, (Parcelable$Creator)com.google.android.gms.common.zzq.CREATOR);
        zzB.recycle();
        return zzq;
    }
    
    public final zzq U0(final zzo zzo) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzd(zza, (Parcelable)zzo);
        final Parcel zzB = this.zzB(8, zza);
        final zzq zzq = (zzq)zzc.zza(zzB, (Parcelable$Creator)com.google.android.gms.common.zzq.CREATOR);
        zzB.recycle();
        return zzq;
    }
    
    public final boolean t0(final zzs zzs, final IObjectWrapper objectWrapper) throws RemoteException {
        final Parcel zza = this.zza();
        zzc.zzd(zza, (Parcelable)zzs);
        zzc.zzf(zza, (IInterface)objectWrapper);
        final Parcel zzB = this.zzB(5, zza);
        final boolean zzg = zzc.zzg(zzB);
        zzB.recycle();
        return zzg;
    }
    
    public final boolean zzi() throws RemoteException {
        final Parcel zzB = this.zzB(7, this.zza());
        final boolean zzg = zzc.zzg(zzB);
        zzB.recycle();
        return zzg;
    }
}
