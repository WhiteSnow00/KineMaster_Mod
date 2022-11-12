// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzcbk;

public final class zzew implements Runnable
{
    public final zzcbk a;
    
    public zzew(final zzcbk a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final zzcbk a = this.a;
        if (a != null) {
            try {
                a.zze(1);
            }
            catch (final RemoteException ex) {
                zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            }
        }
    }
}
