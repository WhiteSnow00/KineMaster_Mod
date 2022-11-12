// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzfnu;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

public final class zzm implements Callable
{
    public final WebSettings a;
    public final Context b;
    
    public zzm(final WebSettings a, final Context b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object call() {
        final WebSettings a = this.a;
        final Context b = this.b;
        final zzfnu i = zzs.i;
        a.setDatabasePath(b.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        a.setDatabaseEnabled(true);
        a.setDomStorageEnabled(true);
        a.setDisplayZoomControls(false);
        a.setBuiltInZoomControls(true);
        a.setSupportZoom(true);
        if (zzay.c().zzb(zzbhy.zzaE)) {
            a.setTextZoom(100);
        }
        a.setAllowContentAccess(false);
        return Boolean.TRUE;
    }
}
