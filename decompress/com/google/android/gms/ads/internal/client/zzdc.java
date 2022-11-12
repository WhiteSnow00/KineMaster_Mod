// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzdc extends zzaqv implements zzde
{
    zzdc(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }
    
    public final void Y0(final zzs zzs) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zzs);
        this.zzbl(1, zza);
    }
}
