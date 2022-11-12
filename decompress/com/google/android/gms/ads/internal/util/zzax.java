// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzajk;
import com.google.android.gms.internal.ads.zzbqe;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.ads.internal.client.zzaw;
import java.util.regex.Pattern;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzaix;
import com.google.android.gms.internal.ads.zzajb;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzail;
import javax.net.ssl.SSLSocketFactory;
import com.google.android.gms.internal.ads.zzakb;
import com.google.android.gms.internal.ads.zzakc;
import com.google.android.gms.internal.ads.zzajx;
import java.io.File;
import com.google.android.gms.internal.ads.zzaje;
import com.google.android.gms.internal.ads.zzajp;
import android.content.Context;
import com.google.android.gms.internal.ads.zzajq;

public final class zzax extends zzajq
{
    private final Context a;
    
    private zzax(final Context a, final zzajp zzajp) {
        super(zzajp);
        this.a = a;
    }
    
    public static zzaje a(final Context context) {
        final zzaje zzaje = new zzaje((zzail)new zzajx(new File(context.getCacheDir(), "admob_volley"), 20971520), (zzaiu)new zzax(context, (zzajp)new zzakc((zzakb)null, (SSLSocketFactory)null)), 4);
        zzaje.zzd();
        return zzaje;
    }
    
    public final zzaix zza(final zzajb zzajb) throws zzajk {
        if (zzajb.zza() == 0 && Pattern.matches((String)zzay.c().zzb(zzbhy.zzdx), zzajb.zzk())) {
            zzaw.b();
            if (zzcfb.zzq(this.a, 13400000)) {
                final zzaix zza = new zzbqe(this.a).zza(zzajb);
                if (zza != null) {
                    zze.a("Got gmscore asset response: ".concat(String.valueOf(zzajb.zzk())));
                    return zza;
                }
                zze.a("Failed to get gmscore asset response: ".concat(String.valueOf(zzajb.zzk())));
            }
        }
        return super.zza(zzajb);
    }
}
