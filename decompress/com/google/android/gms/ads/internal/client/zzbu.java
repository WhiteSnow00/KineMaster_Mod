// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzbu extends zzaqv implements zzbw
{
    zzbu(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IAdMetadataListener");
    }
    
    public final void zze() throws RemoteException {
        this.zzbl(1, this.zza());
    }
}
