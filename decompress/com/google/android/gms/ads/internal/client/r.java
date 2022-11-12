// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.internal.ads.zzcfi;
import android.os.RemoteException;

final class r extends zzbk
{
    final zzep a;
    
    r(final zzep a, final zzen zzen) {
        this.a = a;
    }
    
    public final String zze() throws RemoteException {
        return null;
    }
    
    public final String zzf() throws RemoteException {
        return null;
    }
    
    public final void zzg(final zzl zzl) throws RemoteException {
        this.zzh(zzl, 1);
    }
    
    public final void zzh(final zzl zzl, final int n) throws RemoteException {
        zzcfi.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzcfb.zza.post((Runnable)new q(this));
    }
    
    public final boolean zzi() throws RemoteException {
        return false;
    }
}
