// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdwn;
import java.util.Map;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzdwb;
import com.google.android.gms.internal.ads.zzdwl;

public final class zze implements Runnable
{
    public final zzdwl a;
    public final zzdwb b;
    public final String c;
    public final Pair[] d;
    
    public zze(final zzdwl a, final zzdwb b, final String c, final Pair[] d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        final zzdwl a = this.a;
        final zzdwb b = this.b;
        final String c = this.c;
        final Pair[] d = this.d;
        Map map;
        if (b == null) {
            map = ((zzdwn)a).zzc();
        }
        else {
            map = b.zza();
        }
        map.put("action", c);
        for (final Pair pair : d) {
            map.put(pair.first, pair.second);
        }
        ((zzdwn)a).zze(map);
    }
}
