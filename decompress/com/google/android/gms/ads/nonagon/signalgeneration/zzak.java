// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzfvk;
import java.util.concurrent.Executor;
import com.google.android.gms.internal.ads.zzeaj;
import com.google.android.gms.internal.ads.zzgqc;
import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.internal.ads.zzgqh;
import com.google.android.gms.internal.ads.zzgpu;

public final class zzak implements zzgpu
{
    private final zzgqh a;
    private final zzgqh b;
    
    public zzak(final zzgqh a, final zzgqh b) {
        this.a = a;
        this.b = b;
    }
    
    public final zzaj a() {
        final zzfvk zza = zzcfv.zza;
        zzgqc.zzb((Object)zza);
        return new zzaj((Executor)zza, ((zzeaj)this.b).zza());
    }
    
    public final /* bridge */ Object zzb() {
        return this.a();
    }
}
