// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import java.util.Map;
import java.util.LinkedHashMap;

final class zzb extends LinkedHashMap
{
    final zzc zza;
    
    zzb(final zzc zza) {
        this.zza = zza;
    }
    
    @Override
    protected final boolean removeEldestEntry(final Map.Entry entry) {
        synchronized (this.zza) {
            final int size = this.size();
            final zzc zza = this.zza;
            final int a = zzc.a(zza);
            boolean b = false;
            if (size <= a) {
                return false;
            }
            zzc.c(zza).add(new Pair((Object)entry.getKey(), (Object)((Pair)entry.getValue()).second));
            if (this.size() > zzc.a(this.zza)) {
                b = true;
            }
            return b;
        }
    }
}
