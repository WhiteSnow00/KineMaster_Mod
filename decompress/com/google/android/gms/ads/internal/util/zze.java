// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzbjr;
import java.util.Iterator;
import android.util.Log;
import com.google.android.gms.internal.ads.zzcfi;

public final class zze extends zzcfi
{
    public static void a(String s) {
        if (c()) {
            if (s != null && s.length() > 4000) {
                final Iterator iterator = zzcfi.zza.zzd((CharSequence)s).iterator();
                int n = 1;
                while (iterator.hasNext()) {
                    s = (String)iterator.next();
                    if (n != 0) {
                        Log.v("Ads", s);
                    }
                    else {
                        Log.v("Ads-cont", s);
                    }
                    n = 0;
                }
            }
            else {
                Log.v("Ads", s);
            }
        }
    }
    
    public static void b(final String s, final Throwable t) {
        if (c()) {
            Log.v("Ads", s, t);
        }
    }
    
    public static boolean c() {
        return zzcfi.zzm(2) && (boolean)zzbjr.zza.zze();
    }
}
