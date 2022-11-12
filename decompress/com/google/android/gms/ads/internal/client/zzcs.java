// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzcs extends zzaqv implements zzcu
{
    zzcs(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }
    
    public final String zze() throws RemoteException {
        final Parcel zzbk = this.zzbk(1, this.zza());
        final String string = zzbk.readString();
        zzbk.recycle();
        return string;
    }
    
    public final String zzf() throws RemoteException {
        final Parcel zzbk = this.zzbk(2, this.zza());
        final String string = zzbk.readString();
        zzbk.recycle();
        return string;
    }
}
