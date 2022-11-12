// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import java.util.ArrayList;
import java.util.List;
import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzdf extends zzaqv implements zzdh
{
    zzdf(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }
    
    public final zzu zzf() throws RemoteException {
        final Parcel zzbk = this.zzbk(4, this.zza());
        final zzu zzu = (zzu)zzaqx.zza(zzbk, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzu.CREATOR);
        zzbk.recycle();
        return zzu;
    }
    
    public final String zzg() throws RemoteException {
        final Parcel zzbk = this.zzbk(1, this.zza());
        final String string = zzbk.readString();
        zzbk.recycle();
        return string;
    }
    
    public final String zzh() throws RemoteException {
        final Parcel zzbk = this.zzbk(2, this.zza());
        final String string = zzbk.readString();
        zzbk.recycle();
        return string;
    }
    
    public final List zzi() throws RemoteException {
        final Parcel zzbk = this.zzbk(3, this.zza());
        final ArrayList typedArrayList = zzbk.createTypedArrayList((Parcelable$Creator)zzu.CREATOR);
        zzbk.recycle();
        return typedArrayList;
    }
}
