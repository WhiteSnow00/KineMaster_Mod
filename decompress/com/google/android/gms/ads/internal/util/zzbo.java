// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaij;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzajf;
import com.google.android.gms.internal.ads.zzajg;
import com.google.android.gms.internal.ads.zzcfh;
import com.google.android.gms.internal.ads.zzajb;
import java.util.Map;
import com.google.android.gms.internal.ads.zzcga;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzajp;
import com.google.android.gms.internal.ads.zzaki;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzbhy;
import android.content.Context;
import com.google.android.gms.internal.ads.zzaje;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbo
{
    private static zzaje a;
    private static final Object b;
    @Deprecated
    public static final zzbj c;
    
    static {
        b = new Object();
        c = new e();
    }
    
    public zzbo(Context applicationContext) {
        if (applicationContext.getApplicationContext() != null) {
            applicationContext = applicationContext.getApplicationContext();
        }
        synchronized (zzbo.b) {
            if (zzbo.a == null) {
                zzbhy.zzc(applicationContext);
                zzaje a;
                if (!ClientLibraryUtils.a() && (boolean)zzay.c().zzb(zzbhy.zzdw)) {
                    a = zzax.a(applicationContext);
                }
                else {
                    a = zzaki.zza(applicationContext, (zzajp)null);
                }
                zzbo.a = a;
            }
        }
    }
    
    public final zzfvj a(final String s) {
        final zzcga zzcga = new zzcga();
        zzbo.a.zza((zzajb)new zzbn(s, null, zzcga));
        return (zzfvj)zzcga;
    }
    
    public final zzfvj b(final int n, final String s, Map g, final byte[] array) {
        final h h = new h(null);
        final f f = new f(this, s, h);
        final zzcfh zzcfh = new zzcfh((String)null);
        g = new g(this, n, s, (zzajg)h, (zzajf)f, array, (Map)g, zzcfh);
        if (com.google.android.gms.internal.ads.zzcfh.zzl()) {
            try {
                zzcfh.zzd(s, "GET", ((zzajb)g).zzl(), ((zzajb)g).zzx());
            }
            catch (final zzaij zzaij) {
                zzcfi.zzj(((Throwable)zzaij).getMessage());
            }
        }
        zzbo.a.zza((zzajb)g);
        return (zzfvj)h;
    }
}
