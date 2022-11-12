// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.query;

import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.internal.ads.zzbyl;
import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdFormat;
import android.content.Context;
import com.google.android.gms.ads.internal.client.zzeh;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class QueryInfo
{
    private final zzeh a;
    
    public QueryInfo(final zzeh a) {
        this.a = a;
    }
    
    @KeepForSdk
    public static void a(final Context context, final AdFormat adFormat, final AdRequest adRequest, final QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzbhy.zzc(context);
        if ((boolean)zzbjm.zzh.zze() && (boolean)zzay.c().zzb(zzbhy.zziq)) {
            zzcex.zzb.execute(new zza(context, adFormat, adRequest, queryInfoGenerationCallback));
            return;
        }
        zzdr a;
        if (adRequest == null) {
            a = null;
        }
        else {
            a = adRequest.a();
        }
        new zzbyl(context, adFormat, a).zzb(queryInfoGenerationCallback);
    }
    
    @KeepForSdk
    public String b() {
        return this.a.a();
    }
    
    public final zzeh c() {
        return this.a;
    }
}
