// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzbtz;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import com.google.android.gms.internal.ads.zzbqf;
import java.util.List;
import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzck extends zzaqv implements zzcm
{
    zzck(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }
    
    public final float zze() throws RemoteException {
        final Parcel zzbk = this.zzbk(7, this.zza());
        final float float1 = zzbk.readFloat();
        zzbk.recycle();
        return float1;
    }
    
    public final String zzf() throws RemoteException {
        final Parcel zzbk = this.zzbk(9, this.zza());
        final String string = zzbk.readString();
        zzbk.recycle();
        return string;
    }
    
    public final List zzg() throws RemoteException {
        final Parcel zzbk = this.zzbk(13, this.zza());
        final ArrayList typedArrayList = zzbk.createTypedArrayList(zzbqf.CREATOR);
        zzbk.recycle();
        return typedArrayList;
    }
    
    public final void zzj() throws RemoteException {
        this.zzbl(1, this.zza());
    }
    
    public final void zzk(final String s, final IObjectWrapper objectWrapper) throws RemoteException {
        final Parcel zza = this.zza();
        zza.writeString((String)null);
        zzaqx.zzg(zza, (IInterface)objectWrapper);
        this.zzbl(6, zza);
    }
    
    public final void zzn(final zzbtz zzbtz) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzbtz);
        this.zzbl(11, zza);
    }
    
    public final void zzr(final zzbqm zzbqm) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zzg(zza, (IInterface)zzbqm);
        this.zzbl(12, zza);
    }
    
    public final void zzs(final zzfa zzfa) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zzfa);
        this.zzbl(14, zza);
    }
    
    public final boolean zzt() throws RemoteException {
        final Parcel zzbk = this.zzbk(8, this.zza());
        final boolean zzh = zzaqx.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }
}
