// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzfvk;
import android.content.Context;
import com.google.android.gms.internal.ads.zzcnu;
import com.google.android.gms.internal.ads.zzfig;
import com.google.android.gms.internal.ads.zzdwl;
import java.util.concurrent.ScheduledExecutorService;
import com.google.android.gms.internal.ads.zzgqc;
import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.internal.ads.zzfcu;
import com.google.android.gms.internal.ads.zzaoc;
import com.google.android.gms.internal.ads.zzcnk;
import com.google.android.gms.internal.ads.zzcnf;
import com.google.android.gms.internal.ads.zzgqh;
import com.google.android.gms.internal.ads.zzgpu;

public final class zzaa implements zzgpu
{
    private final zzgqh a;
    private final zzgqh b;
    private final zzgqh c;
    private final zzgqh d;
    private final zzgqh e;
    private final zzgqh f;
    private final zzgqh g;
    private final zzgqh h;
    private final zzgqh i;
    
    public zzaa(final zzgqh a, final zzgqh b, final zzgqh c, final zzgqh d, final zzgqh e, final zzgqh f, final zzgqh g, final zzgqh h, final zzgqh i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    public final /* bridge */ Object zzb() {
        final zzcnf zzcnf = (zzcnf)this.a.zzb();
        final Context zza = ((zzcnk)this.b).zza();
        final zzaoc zzaoc = (zzaoc)this.c.zzb();
        final zzfcu zzfcu = (zzfcu)this.d.zzb();
        final zzfvk zza2 = zzcfv.zza;
        zzgqc.zzb((Object)zza2);
        return new zzz(zzcnf, zza, zzaoc, zzfcu, zza2, (ScheduledExecutorService)this.f.zzb(), (zzdwl)this.g.zzb(), (zzfig)this.h.zzb(), ((zzcnu)this.i).zza());
    }
}
