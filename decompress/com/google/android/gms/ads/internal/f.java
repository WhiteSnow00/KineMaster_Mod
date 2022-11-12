// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import java.util.Iterator;
import android.os.Bundle;
import org.json.JSONException;
import com.google.android.gms.internal.ads.zzesy;
import org.json.JSONArray;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzcfo;
import com.google.android.gms.ads.internal.client.zzl;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.TreeMap;
import java.util.Map;
import android.content.Context;

final class f
{
    private final Context a;
    private final String b;
    private final Map c;
    private String d;
    private String e;
    private final String f;
    
    public f(final Context context, String packageName) {
        this.a = context.getApplicationContext();
        this.b = packageName;
        this.c = new TreeMap();
        packageName = context.getPackageName();
        String f;
        try {
            final String versionName = Wrappers.a(context).f(context.getPackageName(), 0).versionName;
            final StringBuilder sb = new StringBuilder();
            sb.append(packageName);
            sb.append("-");
            sb.append(versionName);
            f = sb.toString();
        }
        catch (final PackageManager$NameNotFoundException ex) {
            zzcfi.zzh("Unable to get package version name for reporting", (Throwable)ex);
            f = String.valueOf(packageName).concat("-missing");
        }
        this.f = f;
    }
    
    public final String a() {
        return this.f;
    }
    
    public final String b() {
        return this.e;
    }
    
    public final String c() {
        return this.b;
    }
    
    public final String d() {
        return this.d;
    }
    
    public final Map e() {
        return this.c;
    }
    
    public final void f(final zzl zzl, final zzcfo zzcfo) {
        this.d = zzl.j.a;
        final Bundle x = zzl.x;
        Bundle bundle;
        if (x != null) {
            bundle = x.getBundle(AdMobAdapter.class.getName());
        }
        else {
            bundle = null;
        }
        if (bundle == null) {
            return;
        }
        final String s = (String)zzbjc.zzc.zze();
        for (final String s2 : bundle.keySet()) {
            if (s.equals(s2)) {
                this.e = bundle.getString(s2);
            }
            else {
                if (!s2.startsWith("csa_")) {
                    continue;
                }
                this.c.put(s2.substring(4), bundle.getString(s2));
            }
        }
        this.c.put("SDKVersion", zzcfo.zza);
        if (zzbjc.zza.zze()) {
            try {
                final Bundle zzc = zzesy.zzc(this.a, new JSONArray((String)zzbjc.zzb.zze()));
                for (final String s3 : zzc.keySet()) {
                    this.c.put(s3, zzc.get(s3).toString());
                }
            }
            catch (final JSONException ex) {
                zzcfi.zzh("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", (Throwable)ex);
            }
        }
    }
}
