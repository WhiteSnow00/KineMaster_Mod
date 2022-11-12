// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.HashSet;
import java.util.Set;
import java.util.Locale;
import com.google.android.gms.internal.ads.zzbdv;

public final class zzad
{
    private final String a;
    
    zzad(final zzab zzab, final zzac zzac) {
        this.a = zzab.c(zzab);
    }
    
    public final zzbdv a() {
        final String a = this.a;
        int n = 0;
        Label_0113: {
            switch (a.hashCode()) {
                case 1951953708: {
                    if (a.equals("BANNER")) {
                        n = 0;
                        break Label_0113;
                    }
                    break;
                }
                case 543046670: {
                    if (a.equals("REWARDED")) {
                        n = 3;
                        break Label_0113;
                    }
                    break;
                }
                case -1372958932: {
                    if (a.equals("INTERSTITIAL")) {
                        n = 1;
                        break Label_0113;
                    }
                    break;
                }
                case -1999289321: {
                    if (a.equals("NATIVE")) {
                        n = 2;
                        break Label_0113;
                    }
                    break;
                }
            }
            n = -1;
        }
        if (n == 0) {
            return zzbdv.zzb;
        }
        if (n == 1) {
            return zzbdv.zzd;
        }
        if (n == 2) {
            return zzbdv.zzg;
        }
        if (n != 3) {
            return zzbdv.zza;
        }
        return zzbdv.zzh;
    }
    
    public final String b() {
        return this.a.toLowerCase(Locale.ROOT);
    }
    
    public final Set c() {
        final HashSet set = new HashSet();
        set.add(this.a.toLowerCase(Locale.ROOT));
        return set;
    }
}
