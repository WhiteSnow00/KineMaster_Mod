// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.ads.MuteThisAdReason;

public final class zzcv implements MuteThisAdReason
{
    private final String a;
    private final zzcu b;
    
    public zzcv(final zzcu b) {
        this.b = b;
        String zze;
        try {
            zze = b.zze();
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("", (Throwable)ex);
            zze = null;
        }
        this.a = zze;
    }
    
    public final zzcu a() {
        return this.b;
    }
    
    @Override
    public final String toString() {
        return this.a;
    }
}
