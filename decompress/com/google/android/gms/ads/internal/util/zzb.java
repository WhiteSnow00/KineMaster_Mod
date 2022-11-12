// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.internal.ads.zzfvj;

public abstract class zzb
{
    private final Runnable zza;
    private volatile Thread zzb;
    
    public zzb() {
        this.zza = new a(this);
    }
    
    static /* bridge */ void zzc(final zzb zzb, final Thread zzb2) {
        zzb.zzb = zzb2;
    }
    
    public abstract void zza();
    
    public zzfvj zzb() {
        return zzcfv.zza.zza(this.zza);
    }
}
