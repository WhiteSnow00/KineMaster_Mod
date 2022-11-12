// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzbp extends zzaqv implements zzbr
{
    zzbp(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }
    
    public final void zze(final IObjectWrapper objectWrapper) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        this.zzbl(2, zza);
    }
    
    public final boolean zzf(final IObjectWrapper objectWrapper, final String s, final String s2) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zza.writeString(s);
        zza.writeString(s2);
        final Parcel zzbk = this.zzbk(1, zza);
        final boolean zzh = zzaqx.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }
}
