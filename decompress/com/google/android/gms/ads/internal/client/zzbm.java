// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbmo;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbmh;
import android.os.RemoteException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzbm extends zzaqv implements zzbo
{
    zzbm(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }
    
    public final zzbl zze() throws RemoteException {
        final Parcel zzbk = this.zzbk(1, this.zza());
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzbl zzbl;
        if (strongBinder == null) {
            zzbl = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            if (queryLocalInterface instanceof zzbl) {
                zzbl = (zzbl)queryLocalInterface;
            }
            else {
                zzbl = new zzbj(strongBinder);
            }
        }
        zzbk.recycle();
        return zzbl;
    }
    
    public final void zzh(final String s, final zzbmh zzbmh, final zzbme zzbme) throws RemoteException {
        final Parcel zza = this.zza();
        zza.writeString(s);
        zzaqx.zzg(zza, (IInterface)zzbmh);
        zzaqx.zzg(zza, (IInterface)zzbme);
        this.zzbl(5, zza);
    }
    
    public final void zzk(final zzbmo zzbmo) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzbmo);
        this.zzbl(10, zza);
    }
    
    public final void zzl(final zzbf zzbf) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzbf);
        this.zzbl(2, zza);
    }
    
    public final void zzo(final zzbko zzbko) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zzbko);
        this.zzbl(6, zza);
    }
}
