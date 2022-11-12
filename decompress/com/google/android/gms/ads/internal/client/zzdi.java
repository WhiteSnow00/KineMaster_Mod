// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzaqx;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzdi extends zzaqv implements zzdk
{
    zzdi(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IVideoController");
    }
    
    public final float zze() throws RemoteException {
        throw null;
    }
    
    public final float zzf() throws RemoteException {
        throw null;
    }
    
    public final float zzg() throws RemoteException {
        throw null;
    }
    
    public final int zzh() throws RemoteException {
        final Parcel zzbk = this.zzbk(5, this.zza());
        final int int1 = zzbk.readInt();
        zzbk.recycle();
        return int1;
    }
    
    public final zzdn zzi() throws RemoteException {
        final Parcel zzbk = this.zzbk(11, this.zza());
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzdn zzdn;
        if (strongBinder == null) {
            zzdn = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            if (queryLocalInterface instanceof zzdn) {
                zzdn = (zzdn)queryLocalInterface;
            }
            else {
                zzdn = new zzdl(strongBinder);
            }
        }
        zzbk.recycle();
        return zzdn;
    }
    
    public final void zzl() throws RemoteException {
        this.zzbl(1, this.zza());
    }
    
    public final void zzm(final zzdn zzdn) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzdn);
        this.zzbl(8, zza);
    }
}
