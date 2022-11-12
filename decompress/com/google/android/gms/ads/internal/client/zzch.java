// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Parcelable$Creator;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.RemoteException;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzch extends zzaqv implements zzcj
{
    zzch(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }
    
    public final zzbtz getAdapterCreator() throws RemoteException {
        final Parcel zzbk = this.zzbk(2, this.zza());
        final zzbtz zzf = zzbty.zzf(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzf;
    }
    
    public final zzei getLiteSdkVersion() throws RemoteException {
        final Parcel zzbk = this.zzbk(1, this.zza());
        final zzei zzei = (zzei)zzaqx.zza(zzbk, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzei.CREATOR);
        zzbk.recycle();
        return zzei;
    }
}
