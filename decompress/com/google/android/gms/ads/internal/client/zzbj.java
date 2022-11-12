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

public final class zzbj extends zzaqv implements zzbl
{
    zzbj(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }
    
    public final void zzg(final zzl zzl) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zzl);
        this.zzbl(1, zza);
    }
}
