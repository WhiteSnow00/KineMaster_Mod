// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzba extends zzaqv implements zzbc
{
    zzba(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }
    
    public final void zzb() throws RemoteException {
        this.zzbl(1, this.zza());
    }
}
