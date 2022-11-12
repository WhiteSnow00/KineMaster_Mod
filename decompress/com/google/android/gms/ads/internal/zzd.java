// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfva;
import org.json.JSONObject;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzfhg;
import com.google.android.gms.internal.ads.zzfhs;
import com.google.android.gms.internal.ads.zzfuh;

public final class zzd implements zzfuh
{
    public final zzfhs a;
    public final zzfhg b;
    
    public zzd(final zzfhs a, final zzfhg b) {
        this.a = a;
        this.b = b;
    }
    
    public final zzfvj zza(final Object o) {
        final zzfhs a = this.a;
        final zzfhg b = this.b;
        final JSONObject jsonObject = (JSONObject)o;
        final boolean optBoolean = jsonObject.optBoolean("isSuccessful", false);
        if (optBoolean) {
            zzt.p().zzh().n(jsonObject.getString("appSettingsJson"));
        }
        b.zze(optBoolean);
        a.zzb(b.zzj());
        return zzfva.zzi((Object)null);
    }
}
