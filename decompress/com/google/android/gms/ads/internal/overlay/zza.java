// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.ads.internal.client.zzay;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbhy;
import android.content.ActivityNotFoundException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.internal.util.zze;
import android.content.Intent;
import android.content.Context;

public final class zza
{
    public static final boolean a(final Context context, final Intent intent, final zzw zzw, final zzu zzu, final boolean b) {
        if (b) {
            return c(context, intent.getData(), zzw, zzu);
        }
        try {
            final String uri = intent.toURI();
            final StringBuilder sb = new StringBuilder();
            sb.append("Launching an intent: ");
            sb.append(uri);
            zze.a(sb.toString());
            zzt.q();
            zzs.i(context, intent);
            if (zzw != null) {
                zzw.zzg();
            }
            if (zzu != null) {
                zzu.zza(true);
            }
            return true;
        }
        catch (final ActivityNotFoundException ex) {
            zzcfi.zzj(ex.getMessage());
            if (zzu != null) {
                zzu.zza(false);
            }
            return false;
        }
    }
    
    public static final boolean b(final Context context, final zzc zzc, final zzw zzw, final zzu zzu) {
        final int n = 0;
        if (zzc == null) {
            zzcfi.zzj("No intent data for launcher overlay.");
            return false;
        }
        zzbhy.zzc(context);
        final Intent h = zzc.h;
        if (h != null) {
            return a(context, h, zzw, zzu, zzc.j);
        }
        final Intent intent = new Intent();
        if (TextUtils.isEmpty((CharSequence)zzc.b)) {
            zzcfi.zzj("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty((CharSequence)zzc.c)) {
            intent.setDataAndType(Uri.parse(zzc.b), zzc.c);
        }
        else {
            intent.setData(Uri.parse(zzc.b));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty((CharSequence)zzc.d)) {
            intent.setPackage(zzc.d);
        }
        if (!TextUtils.isEmpty((CharSequence)zzc.e)) {
            final String[] split = zzc.e.split("/", 2);
            if (split.length < 2) {
                zzcfi.zzj("Could not parse component name from open GMSG: ".concat(String.valueOf(zzc.e)));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        final String f = zzc.f;
        if (!TextUtils.isEmpty((CharSequence)f)) {
            int int1;
            try {
                int1 = Integer.parseInt(f);
            }
            catch (final NumberFormatException ex) {
                zzcfi.zzj("Could not parse intent flags.");
                int1 = n;
            }
            intent.addFlags(int1);
        }
        if (zzay.c().zzb(zzbhy.zzdA)) {
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        }
        else if (zzay.c().zzb(zzbhy.zzdz)) {
            zzt.q();
            zzs.I(context, intent);
        }
        return a(context, intent, zzw, zzu, zzc.j);
    }
    
    private static final boolean c(final Context context, final Uri uri, final zzw zzw, final zzu zzu) {
        int g;
        try {
            final int n = g = zzt.q().G(context, uri);
            if (zzw != null) {
                zzw.zzg();
                g = n;
            }
        }
        catch (final ActivityNotFoundException ex) {
            zzcfi.zzj(ex.getMessage());
            g = 6;
        }
        if (zzu != null) {
            zzu.zzb(g);
        }
        return g == 5;
    }
}
