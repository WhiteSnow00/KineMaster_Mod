// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzcmm;
import com.google.android.gms.internal.ads.zzclp;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzcli;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.Map;
import com.google.android.gms.internal.ads.zzcfi;
import android.webkit.CookieManager;
import android.content.Context;

public class zzt extends zzaa
{
    public zzt() {
        super(null);
    }
    
    @Override
    public final int a() {
        return 16974374;
    }
    
    @Override
    public final CookieManager b(final Context context) {
        com.google.android.gms.ads.internal.zzt.q();
        if (zzs.b()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        }
        finally {
            final Throwable t;
            zzcfi.zzh("Failed to obtain CookieManager.", t);
            com.google.android.gms.ads.internal.zzt.p().zzt(t, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }
    
    @Override
    public final WebResourceResponse c(final String s, final String s2, final int n, final String s3, final Map map, final InputStream inputStream) {
        return new WebResourceResponse(s, s2, n, s3, map, inputStream);
    }
    
    @Override
    public final zzclp d(final zzcli zzcli, final zzbdl zzbdl, final boolean b) {
        return (zzclp)new zzcmm(zzcli, zzbdl, b);
    }
}
