// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzbt extends zzaqv
{
    zzbt(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }
    
    public final IBinder M0(final IObjectWrapper objectWrapper, final zzq zzq, final String s, final zzbtz zzbtz, final int n, final int n2) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zzaqx.zze(zza, (Parcelable)zzq);
        zza.writeString(s);
        zzaqx.zzg(zza, (IInterface)zzbtz);
        zza.writeInt(221310000);
        zza.writeInt(n2);
        final Parcel zzbk = this.zzbk(2, zza);
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzbk.recycle();
        return strongBinder;
    }
}
