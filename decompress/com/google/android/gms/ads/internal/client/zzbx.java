// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzbx extends zzaqv implements zzbz
{
    zzbx(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }
    
    public final void zzc(final String s, final String s2) throws RemoteException {
        final Parcel zza = this.zza();
        zza.writeString(s);
        zza.writeString(s2);
        this.zzbl(1, zza);
    }
}
