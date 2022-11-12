// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzdsd;
import com.google.android.gms.internal.ads.zzfuh;

public final class zzj implements zzfuh
{
    public final zzz a;
    public final zzdsd[] b;
    public final String c;
    
    public zzj(final zzz a, final zzdsd[] b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final zzfvj zza(final Object o) {
        return this.a.V1(this.b, this.c, (zzdsd)o);
    }
}
