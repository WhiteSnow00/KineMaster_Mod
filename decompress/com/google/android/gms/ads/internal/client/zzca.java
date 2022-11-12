// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbxt;
import com.google.android.gms.internal.ads.zzbxu;
import com.google.android.gms.internal.ads.zzcdy;
import com.google.android.gms.internal.ads.zzcdz;
import com.google.android.gms.internal.ads.zzbxj;
import com.google.android.gms.internal.ads.zzbxk;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzcbc;
import com.google.android.gms.internal.ads.zzcbd;
import com.google.android.gms.internal.ads.zzbld;
import com.google.android.gms.internal.ads.zzble;
import android.os.RemoteException;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbpi;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.internal.ads.zzbpj;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzca extends zzaqv implements zzcc
{
    zzca(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IClientApi");
    }
    
    public final zzbpj I0(final IObjectWrapper objectWrapper, final zzbtz zzbtz, final int n, final zzbpg zzbpg) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zzaqx.zzg(zza, (IInterface)zzbtz);
        zza.writeInt(221310000);
        zzaqx.zzg(zza, (IInterface)zzbpg);
        final Parcel zzbk = this.zzbk(16, zza);
        final zzbpj zzb = zzbpi.zzb(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzb;
    }
    
    public final zzble P(final IObjectWrapper objectWrapper, final IObjectWrapper objectWrapper2) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zzaqx.zzg(zza, (IInterface)objectWrapper2);
        final Parcel zzbk = this.zzbk(5, zza);
        final zzble zzbB = zzbld.zzbB(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzbB;
    }
    
    public final zzcbd Q0(final IObjectWrapper objectWrapper, final String s, final zzbtz zzbtz, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zza.writeString(s);
        zzaqx.zzg(zza, (IInterface)zzbtz);
        zza.writeInt(221310000);
        final Parcel zzbk = this.zzbk(12, zza);
        final zzcbd zzq = zzcbc.zzq(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzq;
    }
    
    public final zzbs S0(final IObjectWrapper objectWrapper, final zzq zzq, final String s, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zzaqx.zze(zza, (Parcelable)zzq);
        zza.writeString(s);
        zza.writeInt(221310000);
        final Parcel zzbk = this.zzbk(10, zza);
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzbs zzbs;
        if (strongBinder == null) {
            zzbs = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzbs) {
                zzbs = (zzbs)queryLocalInterface;
            }
            else {
                zzbs = new zzbq(strongBinder);
            }
        }
        zzbk.recycle();
        return zzbs;
    }
    
    public final zzbxk V(final IObjectWrapper objectWrapper, final zzbtz zzbtz, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zzaqx.zzg(zza, (IInterface)zzbtz);
        zza.writeInt(221310000);
        final Parcel zzbk = this.zzbk(15, zza);
        final zzbxk zzb = zzbxj.zzb(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzb;
    }
    
    public final zzbo c0(final IObjectWrapper objectWrapper, final String s, final zzbtz zzbtz, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zza.writeString(s);
        zzaqx.zzg(zza, (IInterface)zzbtz);
        zza.writeInt(221310000);
        final Parcel zzbk = this.zzbk(3, zza);
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzbo zzbo;
        if (strongBinder == null) {
            zzbo = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzbo) {
                zzbo = (zzbo)queryLocalInterface;
            }
            else {
                zzbo = new zzbm(strongBinder);
            }
        }
        zzbk.recycle();
        return zzbo;
    }
    
    public final zzbs f(final IObjectWrapper objectWrapper, final zzq zzq, final String s, final zzbtz zzbtz, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zzaqx.zze(zza, (Parcelable)zzq);
        zza.writeString(s);
        zzaqx.zzg(zza, (IInterface)zzbtz);
        zza.writeInt(221310000);
        final Parcel zzbk = this.zzbk(13, zza);
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzbs zzbs;
        if (strongBinder == null) {
            zzbs = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzbs) {
                zzbs = (zzbs)queryLocalInterface;
            }
            else {
                zzbs = new zzbq(strongBinder);
            }
        }
        zzbk.recycle();
        return zzbs;
    }
    
    public final zzbs f1(final IObjectWrapper objectWrapper, final zzq zzq, final String s, final zzbtz zzbtz, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zzaqx.zze(zza, (Parcelable)zzq);
        zza.writeString(s);
        zzaqx.zzg(zza, (IInterface)zzbtz);
        zza.writeInt(221310000);
        final Parcel zzbk = this.zzbk(2, zza);
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzbs zzbs;
        if (strongBinder == null) {
            zzbs = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzbs) {
                zzbs = (zzbs)queryLocalInterface;
            }
            else {
                zzbs = new zzbq(strongBinder);
            }
        }
        zzbk.recycle();
        return zzbs;
    }
    
    public final zzcdz o(final IObjectWrapper objectWrapper, final zzbtz zzbtz, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zzaqx.zzg(zza, (IInterface)zzbtz);
        zza.writeInt(221310000);
        final Parcel zzbk = this.zzbk(14, zza);
        final zzcdz zzb = zzcdy.zzb(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzb;
    }
    
    public final zzbs p(final IObjectWrapper objectWrapper, final zzq zzq, final String s, final zzbtz zzbtz, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zzaqx.zze(zza, (Parcelable)zzq);
        zza.writeString(s);
        zzaqx.zzg(zza, (IInterface)zzbtz);
        zza.writeInt(221310000);
        final Parcel zzbk = this.zzbk(1, zza);
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzbs zzbs;
        if (strongBinder == null) {
            zzbs = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzbs) {
                zzbs = (zzbs)queryLocalInterface;
            }
            else {
                zzbs = new zzbq(strongBinder);
            }
        }
        zzbk.recycle();
        return zzbs;
    }
    
    public final zzcm zzg(final IObjectWrapper objectWrapper, final int n) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        zza.writeInt(221310000);
        final Parcel zzbk = this.zzbk(9, zza);
        final IBinder strongBinder = zzbk.readStrongBinder();
        zzcm zzcm;
        if (strongBinder == null) {
            zzcm = null;
        }
        else {
            final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzcm) {
                zzcm = (zzcm)queryLocalInterface;
            }
            else {
                zzcm = new zzck(strongBinder);
            }
        }
        zzbk.recycle();
        return zzcm;
    }
    
    public final zzbxu zzl(final IObjectWrapper objectWrapper) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        final Parcel zzbk = this.zzbk(8, zza);
        final zzbxu zzF = zzbxt.zzF(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzF;
    }
}
