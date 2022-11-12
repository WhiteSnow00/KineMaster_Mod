// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzdl extends zzaqv implements zzdn
{
    zzdl(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }
    
    public final void c(final boolean b) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzd(zza, b);
        this.zzbl(5, zza);
    }
    
    public final void zze() throws RemoteException {
        this.zzbl(4, this.zza());
    }
    
    public final void zzg() throws RemoteException {
        this.zzbl(3, this.zza());
    }
    
    public final void zzh() throws RemoteException {
        this.zzbl(2, this.zza());
    }
    
    public final void zzi() throws RemoteException {
        this.zzbl(1, this.zza());
    }
}
