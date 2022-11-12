// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;

final class s implements Runnable
{
    final zzer a;
    
    s(final zzer a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final zzer a = this.a;
        if (zzer.M0(a) != null) {
            try {
                zzer.M0(a).zze(1);
            }
            catch (final RemoteException ex) {
                zzcfi.zzk("Could not notify onAdFailedToLoad event.", (Throwable)ex);
            }
        }
    }
}
