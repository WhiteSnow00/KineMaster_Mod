// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzbd extends zzaqv implements zzbf
{
    zzbd(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IAdListener");
    }
    
    public final void zzc() throws RemoteException {
        this.zzbl(6, this.zza());
    }
    
    public final void zzd() throws RemoteException {
        this.zzbl(1, this.zza());
    }
    
    public final void zze(final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zza.writeInt(n);
        this.zzbl(2, zza);
    }
    
    public final void zzf(final zze zze) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zze);
        this.zzbl(8, zza);
    }
    
    public final void zzg() throws RemoteException {
        this.zzbl(7, this.zza());
    }
    
    public final void zzh() throws RemoteException {
        this.zzbl(3, this.zza());
    }
    
    public final void zzi() throws RemoteException {
        this.zzbl(4, this.zza());
    }
    
    public final void zzj() throws RemoteException {
        this.zzbl(5, this.zza());
    }
}
