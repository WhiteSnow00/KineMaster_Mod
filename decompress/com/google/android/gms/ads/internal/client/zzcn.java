// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzcn extends zzaqv
{
    zzcn(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
    }
    
    public final IBinder M0(final IObjectWrapper objectWrapper, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zza.writeInt(221310000);
        final Parcel zzbk = this.zzbk(1, zza);
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzbk.recycle();
        return strongBinder;
    }
}
