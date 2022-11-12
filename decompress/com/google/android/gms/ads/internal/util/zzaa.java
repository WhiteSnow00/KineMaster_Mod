// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.telephony.TelephonyManager;
import android.content.res.Configuration;
import android.app.Activity;
import com.google.android.gms.internal.ads.zzcmk;
import com.google.android.gms.internal.ads.zzclp;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzcli;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.Map;
import com.google.android.gms.internal.ads.zzcfi;
import android.webkit.CookieSyncManager;
import android.webkit.CookieManager;
import android.content.Context;

public class zzaa
{
    private zzaa() {
    }
    
    zzaa(final zzz zzz) {
    }
    
    public static zzaa j(final int n) {
        if (n >= 30) {
            return new zzy();
        }
        if (n >= 28) {
            return new zzx();
        }
        if (n >= 26) {
            return new zzv();
        }
        if (n >= 24) {
            return new zzu();
        }
        if (n >= 21) {
            return new zzt();
        }
        return new zzaa();
    }
    
    public int a() {
        return 1;
    }
    
    public CookieManager b(final Context context) {
        com.google.android.gms.ads.internal.zzt.q();
        if (zzs.b()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        }
        finally {
            final Throwable t;
            zzcfi.zzh("Failed to obtain CookieManager.", t);
            com.google.android.gms.ads.internal.zzt.p().zzt(t, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }
    
    public WebResourceResponse c(final String s, final String s2, final int n, final String s3, final Map map, final InputStream inputStream) {
        return new WebResourceResponse(s, s2, inputStream);
    }
    
    public zzclp d(final zzcli zzcli, final zzbdl zzbdl, final boolean b) {
        return (zzclp)new zzcmk(zzcli, zzbdl, b);
    }
    
    public boolean e(final Activity activity, final Configuration configuration) {
        return false;
    }
    
    public void f(final Context context) {
    }
    
    public int g(final Context context, final TelephonyManager telephonyManager) {
        return 1001;
    }
    
    public void h(final Activity activity) {
    }
    
    public int i(final Context context) {
        return ((TelephonyManager)context.getSystemService("phone")).getNetworkType();
    }
}
