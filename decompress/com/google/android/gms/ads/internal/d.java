// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzany;
import com.google.android.gms.internal.ads.zzaoc;
import com.google.android.gms.internal.ads.zzaob;
import java.util.concurrent.Callable;

final class d implements Callable
{
    final zzs a;
    
    d(final zzs a) {
        this.a = a;
    }
    
    @Override
    public final /* bridge */ Object call() throws Exception {
        final zzs a = this.a;
        return new zzaoc((zzany)zzaob.zzs(zzs.t1(a).zza, zzs.p1(a), false));
    }
}
