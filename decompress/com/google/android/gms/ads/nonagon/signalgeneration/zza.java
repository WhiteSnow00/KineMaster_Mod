// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.ArrayDeque;
import com.google.android.gms.internal.ads.zzdwb;

public final class zza implements Runnable
{
    public final zzc a;
    public final zzdwb b;
    public final ArrayDeque c;
    public final ArrayDeque d;
    
    public zza(final zzc a, final zzdwb b, final ArrayDeque c, final ArrayDeque d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        this.a.e(this.b, this.c, this.d);
    }
}
