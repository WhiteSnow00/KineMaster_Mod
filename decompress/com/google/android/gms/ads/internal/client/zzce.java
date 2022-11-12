// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzce extends zzaqv implements zzcg
{
    zzce(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }
    
    public final void zzb() throws RemoteException {
        this.zzbl(5, this.zza());
    }
    
    public final void zzc() throws RemoteException {
        this.zzbl(3, this.zza());
    }
    
    public final void zzd(final zze zze) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zze);
        this.zzbl(1, zza);
    }
    
    public final void zze() throws RemoteException {
        this.zzbl(4, this.zza());
    }
    
    public final void zzf() throws RemoteException {
        this.zzbl(2, this.zza());
    }
}
