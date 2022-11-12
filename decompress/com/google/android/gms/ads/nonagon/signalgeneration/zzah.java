// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzffw;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzfuh;
import com.google.android.gms.internal.ads.zzdaz;
import com.google.android.gms.internal.ads.zzffy;
import com.google.android.gms.internal.ads.zzfge;
import com.google.android.gms.internal.ads.zzgqh;
import com.google.android.gms.internal.ads.zzgpu;

public final class zzah implements zzgpu
{
    private final zzgqh a;
    private final zzgqh b;
    private final zzgqh c;
    
    public zzah(final zzgqh a, final zzgqh b, final zzgqh c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final /* bridge */ Object zzb() {
        return ((zzffw)this.a.zzb()).zzb((Object)zzffy.zzt, ((zzdaz)this.c).zza().zzc()).zzf((zzfuh)((zzak)this.b).a()).zzi((long)(int)zzay.c().zzb(zzbhy.zzex), TimeUnit.SECONDS).zza();
    }
}
