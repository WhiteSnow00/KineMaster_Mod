// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;

final class q implements Runnable
{
    final r a;
    
    q(final r a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final zzep a = this.a.a;
        if (zzep.M0(a) != null) {
            try {
                zzep.M0(a).zze(1);
            }
            catch (final RemoteException ex) {
                zzcfi.zzk("Could not notify onAdFailedToLoad event.", (Throwable)ex);
            }
        }
    }
}
