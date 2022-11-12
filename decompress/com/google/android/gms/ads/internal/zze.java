// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzfvk;
import com.google.android.gms.internal.ads.zzfvj;
import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.internal.ads.zzbsp;
import com.google.android.gms.internal.ads.zzbst;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzcfy;
import java.util.concurrent.Executor;
import com.google.android.gms.internal.ads.zzfuh;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.internal.ads.zzfhg;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.common.wrappers.Wrappers;
import org.json.JSONObject;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbss;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzfhf;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzcel;
import com.google.android.gms.internal.ads.zzfhs;
import com.google.android.gms.internal.ads.zzcfo;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zze
{
    private Context a;
    private long b;
    
    public zze() {
        this.b = 0L;
    }
    
    public final void a(final Context context, final zzcfo zzcfo, final String s, final Runnable runnable, final zzfhs zzfhs) {
        this.b(context, zzcfo, true, null, s, null, runnable, zzfhs);
    }
    
    @VisibleForTesting
    final void b(final Context context, zzcfo zzcfo, final boolean b, zzcel zza, final String s, final String s2, final Runnable runnable, final zzfhs zzfhs) {
        if (zzt.a().c() - this.b < 5000L) {
            zzcfi.zzj("Not retrying to fetch app settings");
            return;
        }
        this.b = zzt.a().c();
        if (zza != null) {
            if (zzt.a().a() - zza.zza() <= (long)zzay.c().zzb(zzbhy.zzdd) && zza.zzi()) {
                return;
            }
        }
        if (context == null) {
            zzcfi.zzj("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty((CharSequence)s) && TextUtils.isEmpty((CharSequence)s2)) {
            zzcfi.zzj("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext;
        if ((applicationContext = context.getApplicationContext()) == null) {
            applicationContext = context;
        }
        this.a = applicationContext;
        zza = (zzcel)zzfhf.zza(context, 4);
        ((zzfhg)zza).zzf();
        final zzbsz zza2 = zzt.g().zza(this.a, zzcfo, zzfhs);
        final zzbst zza3 = zzbsw.zza;
        final zzbsp zza4 = zza2.zza("google.afma.config.fetchAppSettings", (zzbss)zza3, (zzbsr)zza3);
        try {
            zzcfo = (zzcfo)new JSONObject();
            if (!TextUtils.isEmpty((CharSequence)s)) {
                ((JSONObject)zzcfo).put("app_id", (Object)s);
            }
            else if (!TextUtils.isEmpty((CharSequence)s2)) {
                ((JSONObject)zzcfo).put("ad_unit_id", (Object)s2);
            }
            ((JSONObject)zzcfo).put("is_init", b);
            ((JSONObject)zzcfo).put("pn", (Object)context.getPackageName());
            ((JSONObject)zzcfo).put("experiment_ids", (Object)TextUtils.join((CharSequence)",", (Iterable)zzbhy.zza()));
            try {
                final ApplicationInfo applicationInfo = this.a.getApplicationInfo();
                if (applicationInfo != null) {
                    final PackageInfo f = Wrappers.a(context).f(applicationInfo.packageName, 0);
                    if (f != null) {
                        ((JSONObject)zzcfo).put("version", f.versionCode);
                    }
                }
            }
            catch (final PackageManager$NameNotFoundException ex) {
                com.google.android.gms.ads.internal.util.zze.a("Error fetching PackageInfo.");
            }
            final zzfvj zzb = zza4.zzb((Object)zzcfo);
            final zzd zzd = new zzd(zzfhs, (zzfhg)zza);
            final zzfvk zzf = zzcfv.zzf;
            final zzfvj zzn = zzfva.zzn(zzb, (zzfuh)zzd, (Executor)zzf);
            if (runnable != null) {
                zzb.zzc(runnable, (Executor)zzf);
            }
            zzcfy.zza(zzn, "ConfigLoader.maybeFetchNewAppSettings");
        }
        catch (final Exception ex2) {
            zzcfi.zzh("Error requesting application settings", (Throwable)ex2);
            ((zzfhg)zza).zze(false);
            zzfhs.zzb(((zzfhg)zza).zzj());
        }
    }
    
    public final void c(final Context context, final zzcfo zzcfo, final String s, final zzcel zzcel, final zzfhs zzfhs) {
        String zzb;
        if (zzcel != null) {
            zzb = zzcel.zzb();
        }
        else {
            zzb = null;
        }
        this.b(context, zzcfo, false, zzcel, zzb, s, null, zzfhs);
    }
}
