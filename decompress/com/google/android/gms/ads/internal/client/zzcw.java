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

public final class zzcw extends zzaqv implements zzcy
{
    zzcw(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
    }
    
    public final void y(final zze zze) throws RemoteException {
        final Parcel zza = this.zza();
        zzaqx.zze(zza, (Parcelable)zze);
        this.zzbl(1, zza);
    }
}
