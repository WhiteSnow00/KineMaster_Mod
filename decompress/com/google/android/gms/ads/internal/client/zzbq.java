// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Parcelable$Creator;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbci;
import android.os.Parcelable;
import android.os.Parcel;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzbq extends zzaqv implements zzbs
{
    zzbq(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IAdManager");
    }
    
    public final void zzB() throws RemoteException {
        this.zzbl(6, this.zza());
    }
    
    public final void zzC(final zzbc zzbc) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzbc);
        this.zzbl(20, zza);
    }
    
    public final void zzD(final zzbf zzbf) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzbf);
        this.zzbl(7, zza);
    }
    
    public final void zzF(final zzq zzq) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zzq);
        this.zzbl(13, zza);
    }
    
    public final void zzG(final zzbz zzbz) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzbz);
        this.zzbl(8, zza);
    }
    
    public final void zzH(final zzbci zzbci) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzbci);
        this.zzbl(40, zza);
    }
    
    public final void zzI(final zzw zzw) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zzw);
        this.zzbl(39, zza);
    }
    
    public final void zzJ(final zzcg zzcg) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzcg);
        this.zzbl(45, zza);
    }
    
    public final void zzL(final boolean b) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzd(zza, b);
        this.zzbl(34, zza);
    }
    
    public final void zzN(final boolean b) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzd(zza, b);
        this.zzbl(22, zza);
    }
    
    public final void zzP(final zzde zzde) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzde);
        this.zzbl(42, zza);
    }
    
    public final void zzU(final zzfg zzfg) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zzfg);
        this.zzbl(29, zza);
    }
    
    public final void zzW(final IObjectWrapper objectWrapper) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        this.zzbl(44, zza);
    }
    
    public final boolean zzaa(final zzl zzl) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zzl);
        final Parcel zzbk = this.zzbk(4, zza);
        final boolean zzh = zzaqx.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }
    
    public final zzq zzg() throws RemoteException {
        final Parcel zzbk = this.zzbk(12, this.zza());
        final zzq zzq = (zzq)zzaqx.zza(zzbk, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzq.CREATOR);
        zzbk.recycle();
        return zzq;
    }
    
    public final zzbf zzi() throws RemoteException {
        final Parcel zzbk = this.zzbk(33, this.zza());
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzbf zzbf;
        if (strongBinder == null) {
            zzbf = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            if (queryLocalInterface instanceof zzbf) {
                zzbf = (zzbf)queryLocalInterface;
            }
            else {
                zzbf = new zzbd(strongBinder);
            }
        }
        zzbk.recycle();
        return zzbf;
    }
    
    public final zzbz zzj() throws RemoteException {
        final Parcel zzbk = this.zzbk(32, this.zza());
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzbz zzbz;
        if (strongBinder == null) {
            zzbz = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            if (queryLocalInterface instanceof zzbz) {
                zzbz = (zzbz)queryLocalInterface;
            }
            else {
                zzbz = new zzbx(strongBinder);
            }
        }
        zzbk.recycle();
        return zzbz;
    }
    
    public final zzdh zzk() throws RemoteException {
        final Parcel zzbk = this.zzbk(41, this.zza());
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzdh zzdh;
        if (strongBinder == null) {
            zzdh = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            if (queryLocalInterface instanceof zzdh) {
                zzdh = (zzdh)queryLocalInterface;
            }
            else {
                zzdh = new zzdf(strongBinder);
            }
        }
        zzbk.recycle();
        return zzdh;
    }
    
    public final zzdk zzl() throws RemoteException {
        final Parcel zzbk = this.zzbk(26, this.zza());
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzdk zzdk;
        if (strongBinder == null) {
            zzdk = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            if (queryLocalInterface instanceof zzdk) {
                zzdk = (zzdk)queryLocalInterface;
            }
            else {
                zzdk = new zzdi(strongBinder);
            }
        }
        zzbk.recycle();
        return zzdk;
    }
    
    public final IObjectWrapper zzn() throws RemoteException {
        final Parcel zzbk = this.zzbk(1, this.zza());
        final IObjectWrapper m0 = IObjectWrapper.Stub.M0(zzbk.readStrongBinder());
        zzbk.recycle();
        return m0;
    }
    
    public final String zzr() throws RemoteException {
        final Parcel zzbk = this.zzbk(31, this.zza());
        final String string = zzbk.readString();
        zzbk.recycle();
        return string;
    }
    
    public final void zzx() throws RemoteException {
        this.zzbl(2, this.zza());
    }
    
    public final void zzy(final zzl zzl, final zzbi zzbi) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zzl);
        zzaqx.zzg(zza, (IInterface)zzbi);
        this.zzbl(43, zza);
    }
    
    public final void zzz() throws RemoteException {
        this.zzbl(5, this.zza());
    }
}
