// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import com.google.android.gms.ads.internal.client.zzcy;
import com.google.android.gms.internal.ads.zzdyz;
import java.io.FileOutputStream;
import android.net.Uri$Builder;
import java.util.UUID;
import java.io.IOException;
import java.io.InputStream;
import com.google.android.gms.common.util.IOUtils;
import android.text.TextUtils;
import android.net.Uri;
import java.util.concurrent.TimeoutException;
import com.google.android.gms.internal.ads.zzcfi;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.Map;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import android.content.Context;
import com.google.android.gms.internal.ads.zzdza;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

public final class zzaw
{
    private final Object a;
    @GuardedBy
    private String b;
    @GuardedBy
    private String c;
    @GuardedBy
    private boolean d;
    @GuardedBy
    private boolean e;
    @VisibleForTesting
    protected String f;
    private zzdza g;
    
    public zzaw() {
        this.a = new Object();
        this.b = "";
        this.c = "";
        this.d = false;
        this.e = false;
        this.f = "";
    }
    
    @VisibleForTesting
    protected static final String o(Context b, final String s, String s2) {
        final HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzt.q().y(b, s2));
        b = (Context)new zzbo(b).b(0, s, hashMap, null);
        try {
            s2 = ((Future<String>)b).get((long)zzay.c().zzb(zzbhy.zzdN), TimeUnit.MILLISECONDS);
            return s2;
        }
        catch (final Exception ex) {
            zzcfi.zzh("Error retrieving a response from: ".concat(String.valueOf(s)), (Throwable)ex);
        }
        catch (final InterruptedException ex2) {
            zzcfi.zzh("Interrupted while retrieving a response from: ".concat(String.valueOf(s)), (Throwable)ex2);
            ((Future)b).cancel(true);
        }
        catch (final TimeoutException ex3) {
            zzcfi.zzh("Timeout while retrieving a response from: ".concat(String.valueOf(s)), (Throwable)ex3);
            ((Future)b).cancel(true);
        }
        return null;
    }
    
    private final Uri p(final Context context, String b, final String s, final String s2) {
        final Uri$Builder buildUpon = Uri.parse(b).buildUpon();
        synchronized (this.a) {
            if (TextUtils.isEmpty((CharSequence)this.b)) {
                zzt.q();
                try {
                    b = new String(IOUtils.d(context.openFileInput("debug_signals_id.txt"), true), "UTF-8");
                }
                catch (final IOException ex) {
                    zzcfi.zze("Error reading from internal storage.");
                    b = "";
                }
                this.b = b;
                if (TextUtils.isEmpty((CharSequence)b)) {
                    zzt.q();
                    this.b = UUID.randomUUID().toString();
                    zzt.q();
                    b = this.b;
                    try {
                        final FileOutputStream openFileOutput = context.openFileOutput("debug_signals_id.txt", 0);
                        openFileOutput.write(b.getBytes("UTF-8"));
                        openFileOutput.close();
                    }
                    catch (final Exception ex2) {
                        zzcfi.zzh("Error writing to file in internal storage.", (Throwable)ex2);
                    }
                }
            }
            final String b2 = this.b;
            monitorexit(this.a);
            buildUpon.appendQueryParameter("linkedDeviceId", b2);
            buildUpon.appendQueryParameter("adSlotPath", s);
            buildUpon.appendQueryParameter("afmaVersion", s2);
            return buildUpon.build();
        }
    }
    
    public final zzdza a() {
        return this.g;
    }
    
    public final String b() {
        synchronized (this.a) {
            return this.c;
        }
    }
    
    public final void c(final Context context) {
        if (zzay.c().zzb(zzbhy.zzhG)) {
            final zzdza g = this.g;
            if (g != null) {
                g.zzg((zzcy)new b(this, context), zzdyz.zzd);
            }
        }
    }
    
    public final void d(final Context context, final String s, final String s2) {
        zzt.q();
        zzs.p(context, this.p(context, (String)zzay.c().zzb(zzbhy.zzdJ), s, s2));
    }
    
    public final void e(final Context context, final String s, final String s2, final String s3) {
        final Uri$Builder buildUpon = this.p(context, (String)zzay.c().zzb(zzbhy.zzdM), s3, s).buildUpon();
        buildUpon.appendQueryParameter("debugData", s2);
        zzt.q();
        zzs.g(context, s, buildUpon.build().toString());
    }
    
    public final void f(final boolean e) {
        synchronized (this.a) {
            this.e = e;
            if (zzay.c().zzb(zzbhy.zzhG)) {
                zzt.p().zzh().zzB(e);
                final zzdza g = this.g;
                if (g != null) {
                    g.zzi(e);
                }
            }
        }
    }
    
    public final void g(final zzdza g) {
        this.g = g;
    }
    
    public final void h(final boolean d) {
        synchronized (this.a) {
            this.d = d;
        }
    }
    
    @VisibleForTesting
    protected final void i(final Context context, final String s, final boolean b, final boolean b2) {
        if (!(context instanceof Activity)) {
            zzcfi.zzi("Can not create dialog without Activity Context");
            return;
        }
        ((Handler)zzs.i).post((Runnable)new d(this, context, s, b, b2));
    }
    
    public final boolean j(final Context context, String s, String trim) {
        final String o = o(context, this.p(context, (String)zzay.c().zzb(zzbhy.zzdL), s, trim).toString(), trim);
        if (TextUtils.isEmpty((CharSequence)o)) {
            zzcfi.zze("Not linked for debug signals.");
            return false;
        }
        trim = o.trim();
        try {
            final boolean equals = "1".equals(new JSONObject(trim).optString("debug_mode"));
            this.f(equals);
            if (zzay.c().zzb(zzbhy.zzhG)) {
                final zzg zzh = zzt.p().zzh();
                if (!equals) {
                    s = "";
                }
                zzh.zzA(s);
            }
            return equals;
        }
        catch (final JSONException ex) {
            zzcfi.zzk("Fail to get debug mode response json.", (Throwable)ex);
            return false;
        }
    }
    
    @VisibleForTesting
    final boolean k(final Context context, String s, final String s2) {
        final String o = o(context, this.p(context, (String)zzay.c().zzb(zzbhy.zzdK), s, s2).toString(), s2);
        if (TextUtils.isEmpty((CharSequence)o)) {
            zzcfi.zze("Not linked for in app preview.");
            return false;
        }
        final String trim = o.trim();
        try {
            final JSONObject jsonObject = new JSONObject(trim);
            final String optString = jsonObject.optString("gct");
            this.f = jsonObject.optString("status");
            if (zzay.c().zzb(zzbhy.zzhG)) {
                final boolean b = "0".equals(this.f) || "2".equals(this.f);
                this.f(b);
                final zzg zzh = zzt.p().zzh();
                if (!b) {
                    s = "";
                }
                zzh.zzA(s);
            }
            synchronized (this.a) {
                this.c = optString;
                return true;
            }
        }
        catch (final JSONException ex) {
            zzcfi.zzk("Fail to get in app preview response json.", (Throwable)ex);
            return false;
        }
    }
    
    public final boolean l() {
        synchronized (this.a) {
            return this.e;
        }
    }
    
    public final boolean m() {
        synchronized (this.a) {
            return this.d;
        }
    }
    
    public final boolean n(final Context context, final String s, final String s2, final String s3) {
        if (!TextUtils.isEmpty((CharSequence)s2) && this.m()) {
            zzcfi.zze("Sending troubleshooting signals to the server.");
            this.e(context, s, s2, s3);
            return true;
        }
        return false;
    }
}
