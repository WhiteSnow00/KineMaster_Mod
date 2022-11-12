// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqv;

public final class zzcz extends zzaqv implements zzdb
{
    zzcz(final IBinder binder) {
        super(binder, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }
    
    public final void zze() throws RemoteException {
        this.zzbl(1, this.zza());
    }
}
