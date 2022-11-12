// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.Context;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import android.content.res.Configuration;
import android.app.Activity;

public class zzu extends zzt
{
    static final boolean k(final int n, final int n2, final int n3) {
        return Math.abs(n - n2) <= n3;
    }
    
    @Override
    public final boolean e(final Activity activity, final Configuration configuration) {
        final boolean booleanValue = (boolean)zzay.c().zzb(zzbhy.zzdQ);
        boolean b = false;
        if (!booleanValue) {
            return false;
        }
        if (zzay.c().zzb(zzbhy.zzdS)) {
            return activity.isInMultiWindowMode();
        }
        zzaw.b();
        final int zzv = zzcfb.zzv((Context)activity, configuration.screenHeightDp);
        final int zzv2 = zzcfb.zzv((Context)activity, configuration.screenWidthDp);
        final WindowManager windowManager = (WindowManager)activity.getApplicationContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzt.q();
        final DisplayMetrics n = zzs.N(windowManager);
        final int heightPixels = n.heightPixels;
        final int widthPixels = n.widthPixels;
        final int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize;
        if (identifier > 0) {
            dimensionPixelSize = activity.getResources().getDimensionPixelSize(identifier);
        }
        else {
            dimensionPixelSize = 0;
        }
        final int n2 = (int)Math.round(activity.getResources().getDisplayMetrics().density + 0.5) * (int)zzay.c().zzb(zzbhy.zzdO);
        if (k(heightPixels, zzv + dimensionPixelSize, n2)) {
            if (!k(widthPixels, zzv2, n2)) {
                return true;
            }
        }
        else {
            b = true;
        }
        return b;
    }
}
