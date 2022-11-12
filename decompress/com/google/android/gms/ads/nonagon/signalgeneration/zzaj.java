// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzeai;
import java.util.concurrent.Executor;
import com.google.android.gms.internal.ads.zzfuh;

public final class zzaj implements zzfuh
{
    private final Executor a;
    private final zzeai b;
    
    public zzaj(final Executor a, final zzeai b) {
        this.a = a;
        this.b = b;
    }
    
    public final /* bridge */ zzfvj zza(final Object o) throws Exception {
        final zzbzu zzbzu = (zzbzu)o;
        return zzfva.zzn(this.b.zzb(zzbzu), (zzfuh)new zzai(zzbzu), this.a);
    }
}
