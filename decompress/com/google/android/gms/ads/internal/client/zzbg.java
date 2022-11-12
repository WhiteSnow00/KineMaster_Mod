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

public final class zzbg extends zzaqv implements zzbi
{
    zzbg(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }
    
    public final void zzb(final zze zze) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zze);
        this.zzbl(2, zza);
    }
    
    public final void zzc() throws RemoteException {
        this.zzbl(1, this.zza());
    }
}
