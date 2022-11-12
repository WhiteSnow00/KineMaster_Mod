// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzbjg;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import org.json.JSONException;
import org.json.JSONArray;
import android.content.Context;
import java.util.Iterator;
import com.google.android.gms.ads.internal.zzt;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.internal.ads.zzcfi;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.Collections;
import java.util.ArrayList;
import org.json.JSONObject;
import java.util.Set;
import com.google.android.gms.internal.ads.zzcel;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import com.google.android.gms.internal.ads.zzbbl;
import com.google.android.gms.internal.ads.zzfvj;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public final class zzj implements zzg
{
    @GuardedBy
    private boolean A;
    @GuardedBy
    private String B;
    @GuardedBy
    private int C;
    @GuardedBy
    private int D;
    @GuardedBy
    private long E;
    private final Object a;
    private boolean b;
    private final List c;
    private zzfvj d;
    @GuardedBy
    private zzbbl e;
    @GuardedBy
    private SharedPreferences f;
    @GuardedBy
    private SharedPreferences$Editor g;
    @GuardedBy
    private boolean h;
    @GuardedBy
    private String i;
    @GuardedBy
    private String j;
    @GuardedBy
    private boolean k;
    @GuardedBy
    private String l;
    @GuardedBy
    private String m;
    @GuardedBy
    private String n;
    @GuardedBy
    private int o;
    @GuardedBy
    private zzcel p;
    @GuardedBy
    private long q;
    @GuardedBy
    private long r;
    @GuardedBy
    private int s;
    @GuardedBy
    private int t;
    @GuardedBy
    private Set u;
    @GuardedBy
    private JSONObject v;
    @GuardedBy
    private boolean w;
    @GuardedBy
    private boolean x;
    @GuardedBy
    private String y;
    @GuardedBy
    private String z;
    
    public zzj() {
        this.a = new Object();
        this.c = new ArrayList();
        this.e = null;
        this.h = true;
        this.k = true;
        this.l = "-1";
        this.m = "-1";
        this.n = "-1";
        this.o = -1;
        this.p = new zzcel("", 0L);
        this.q = 0L;
        this.r = 0L;
        this.s = -1;
        this.t = 0;
        this.u = Collections.emptySet();
        this.v = new JSONObject();
        this.w = true;
        this.x = true;
        this.y = null;
        this.z = "";
        this.A = false;
        this.B = "";
        this.C = -1;
        this.D = -1;
        this.E = 0L;
    }
    
    private final void u() {
        final zzfvj d = this.d;
        if (d == null) {
            return;
        }
        if (((Future)d).isDone()) {
            return;
        }
        try {
            ((Future<Object>)this.d).get(1L, TimeUnit.SECONDS);
        }
        catch (final TimeoutException d) {
            goto Label_0044;
        }
        catch (final ExecutionException d) {
            goto Label_0044;
        }
        catch (final CancellationException ex) {}
        catch (final InterruptedException ex2) {
            Thread.currentThread().interrupt();
            zzcfi.zzk("Interrupted while waiting for preferences loaded.", (Throwable)ex2);
        }
    }
    
    private final void v() {
        ((Executor)zzcfv.zza).execute(new zzi(this));
    }
    
    @Override
    public final void a(final int o) {
        this.u();
        synchronized (this.a) {
            this.o = o;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                if (o == -1) {
                    g.remove("gad_has_consent_for_cookies");
                }
                else {
                    g.putInt("gad_has_consent_for_cookies", o);
                }
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void b(final Runnable runnable) {
        this.c.add(runnable);
    }
    
    @Override
    public final void c(final int t) {
        this.u();
        synchronized (this.a) {
            if (this.t == t) {
                return;
            }
            this.t = t;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putInt("version_code", t);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void d(final long q) {
        this.u();
        synchronized (this.a) {
            if (this.q == q) {
                return;
            }
            this.q = q;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putLong("app_last_background_time_ms", q);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void e(final boolean x) {
        this.u();
        synchronized (this.a) {
            if (this.x == x) {
                return;
            }
            this.x = x;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putBoolean("content_vertical_opted_out", x);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void f(final String s, final String l) {
        this.u();
        synchronized (this.a) {
            final int hashCode = s.hashCode();
            int n = 0;
            Label_0083: {
                if (hashCode != -2004976699) {
                    if (hashCode != 83641339) {
                        if (hashCode == 1218895378) {
                            if (s.equals("IABTCF_TCString")) {
                                n = 1;
                                break Label_0083;
                            }
                        }
                    }
                    else if (s.equals("IABTCF_gdprApplies")) {
                        n = 0;
                        break Label_0083;
                    }
                }
                else if (s.equals("IABTCF_PurposeConsents")) {
                    n = 2;
                    break Label_0083;
                }
                n = -1;
            }
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) {
                        return;
                    }
                    this.n = l;
                }
                else {
                    this.m = l;
                }
            }
            else {
                this.l = l;
            }
            if (this.g != null) {
                if (l.equals("-1")) {
                    this.g.remove(s);
                }
                else {
                    this.g.putString(s, l);
                }
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void g(final long r) {
        this.u();
        synchronized (this.a) {
            if (this.r == r) {
                return;
            }
            this.r = r;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putLong("first_ad_req_time_ms", r);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void h(final boolean w) {
        this.u();
        synchronized (this.a) {
            if (this.w == w) {
                return;
            }
            this.w = w;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putBoolean("content_url_opted_out", w);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void i(final int d) {
        this.u();
        synchronized (this.a) {
            if (this.D == d) {
                return;
            }
            this.D = d;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putInt("sd_app_measure_npa", d);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void j(final long e) {
        this.u();
        synchronized (this.a) {
            if (this.E == e) {
                return;
            }
            this.E = e;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putLong("sd_app_measure_npa_ts", e);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void k(final boolean k) {
        this.u();
        synchronized (this.a) {
            if (k == this.k) {
                return;
            }
            this.k = k;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putBoolean("gad_idless", k);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void l(final String y) {
        this.u();
        synchronized (this.a) {
            if (TextUtils.equals((CharSequence)this.y, (CharSequence)y)) {
                return;
            }
            this.y = y;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putString("display_cutout", y);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void m(final String i) {
        this.u();
        synchronized (this.a) {
            if (i.equals(this.i)) {
                return;
            }
            this.i = i;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putString("content_url_hashes", i);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void n(final String s) {
        this.u();
        synchronized (this.a) {
            final long a = zzt.a().a();
            if (s != null && !s.equals(this.p.zzc())) {
                this.p = new zzcel(s, a);
                final SharedPreferences$Editor g = this.g;
                if (g != null) {
                    g.putString("app_settings_json", s);
                    this.g.putLong("app_settings_last_update_ms", a);
                    this.g.apply();
                }
                this.v();
                final Iterator iterator = this.c.iterator();
                while (iterator.hasNext()) {
                    ((Runnable)iterator.next()).run();
                }
                return;
            }
            this.p.zzg(a);
        }
    }
    
    @Override
    public final void o(final int s) {
        this.u();
        synchronized (this.a) {
            if (this.s == s) {
                return;
            }
            this.s = s;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putInt("request_in_session_count", s);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void p(final Context context) {
        synchronized (this.a) {
            if (this.f != null) {
                return;
            }
            monitorexit(this.a);
            this.d = zzcfv.zza.zza((Runnable)new zzh(this, context, "admob"));
            this.b = true;
        }
    }
    
    @Override
    public final void q(final String j) {
        this.u();
        synchronized (this.a) {
            if (j.equals(this.j)) {
                return;
            }
            this.j = j;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putString("content_vertical_hashes", j);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void r(final String s, final String s2, final boolean b) {
        this.u();
        synchronized (this.a) {
            JSONArray optJSONArray;
            if ((optJSONArray = this.v.optJSONArray(s)) == null) {
                optJSONArray = new JSONArray();
            }
            final int length = optJSONArray.length();
            int n = 0;
            int n2;
            while (true) {
                n2 = length;
                if (n >= optJSONArray.length()) {
                    break;
                }
                final JSONObject optJSONObject = optJSONArray.optJSONObject(n);
                if (optJSONObject == null) {
                    return;
                }
                if (s2.equals(optJSONObject.optString("template_id"))) {
                    if (b && optJSONObject.optBoolean("uses_media_view", false)) {
                        return;
                    }
                    n2 = n;
                    break;
                }
                else {
                    ++n;
                }
            }
            try {
                final JSONObject jsonObject = new JSONObject();
                jsonObject.put("template_id", (Object)s2);
                jsonObject.put("uses_media_view", b);
                jsonObject.put("timestamp_ms", zzt.a().a());
                optJSONArray.put(n2, (Object)jsonObject);
                this.v.put(s, (Object)optJSONArray);
            }
            catch (final JSONException ex) {
                zzcfi.zzk("Could not update native advanced settings", (Throwable)ex);
            }
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putString("native_advanced_settings", this.v.toString());
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void s(final String z) {
        if (!(boolean)zzay.c().zzb(zzbhy.zzhr)) {
            return;
        }
        this.u();
        synchronized (this.a) {
            if (this.z.equals(z)) {
                return;
            }
            this.z = z;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putString("inspector_info", z);
                this.g.apply();
            }
            this.v();
        }
    }
    
    final void t(final Context context, String string) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("admob", 0);
        final SharedPreferences$Editor edit = sharedPreferences.edit();
        synchronized (this.a) {
            this.f = sharedPreferences;
            this.g = edit;
            if (PlatformVersion.g()) {
                NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            this.h = this.f.getBoolean("use_https", this.h);
            this.w = this.f.getBoolean("content_url_opted_out", this.w);
            this.i = this.f.getString("content_url_hashes", this.i);
            this.k = this.f.getBoolean("gad_idless", this.k);
            this.x = this.f.getBoolean("content_vertical_opted_out", this.x);
            this.j = this.f.getString("content_vertical_hashes", this.j);
            this.t = this.f.getInt("version_code", this.t);
            string = this.f.getString("app_settings_json", this.p.zzc());
            this.p = new zzcel(string, this.f.getLong("app_settings_last_update_ms", this.p.zza()));
            this.q = this.f.getLong("app_last_background_time_ms", this.q);
            this.s = this.f.getInt("request_in_session_count", this.s);
            this.r = this.f.getLong("first_ad_req_time_ms", this.r);
            this.u = this.f.getStringSet("never_pool_slots", this.u);
            this.y = this.f.getString("display_cutout", this.y);
            this.C = this.f.getInt("app_measurement_npa", this.C);
            this.D = this.f.getInt("sd_app_measure_npa", this.D);
            this.E = this.f.getLong("sd_app_measure_npa_ts", this.E);
            this.z = this.f.getString("inspector_info", this.z);
            this.A = this.f.getBoolean("linked_device", this.A);
            this.B = this.f.getString("linked_ad_unit", this.B);
            this.l = this.f.getString("IABTCF_gdprApplies", this.l);
            this.n = this.f.getString("IABTCF_PurposeConsents", this.n);
            this.m = this.f.getString("IABTCF_TCString", this.m);
            this.o = this.f.getInt("gad_has_consent_for_cookies", this.o);
            try {
                this.v = new JSONObject(this.f.getString("native_advanced_settings", "{}"));
            }
            catch (final JSONException ex) {
                zzcfi.zzk("Could not convert native advanced settings to json object", (Throwable)ex);
            }
            this.v();
        }
    }
    
    @Override
    public final void zzA(final String b) {
        if (!(boolean)zzay.c().zzb(zzbhy.zzhG)) {
            return;
        }
        this.u();
        synchronized (this.a) {
            if (this.B.equals(b)) {
                return;
            }
            this.B = b;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putString("linked_ad_unit", b);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final void zzB(final boolean a) {
        if (!(boolean)zzay.c().zzb(zzbhy.zzhG)) {
            return;
        }
        this.u();
        synchronized (this.a) {
            if (this.A == a) {
                return;
            }
            this.A = a;
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.putBoolean("linked_device", a);
                this.g.apply();
            }
            this.v();
        }
    }
    
    @Override
    public final boolean zzM() {
        this.u();
        synchronized (this.a) {
            return this.w;
        }
    }
    
    @Override
    public final boolean zzN() {
        this.u();
        synchronized (this.a) {
            return this.x;
        }
    }
    
    @Override
    public final boolean zzO() {
        this.u();
        synchronized (this.a) {
            return this.A;
        }
    }
    
    @Override
    public final boolean zzP() {
        if (!(boolean)zzay.c().zzb(zzbhy.zzar)) {
            return false;
        }
        this.u();
        synchronized (this.a) {
            return this.k;
        }
    }
    
    @Override
    public final int zza() {
        this.u();
        synchronized (this.a) {
            return this.t;
        }
    }
    
    @Override
    public final int zzb() {
        this.u();
        synchronized (this.a) {
            return this.o;
        }
    }
    
    @Override
    public final int zzc() {
        this.u();
        synchronized (this.a) {
            return this.s;
        }
    }
    
    @Override
    public final long zzd() {
        this.u();
        synchronized (this.a) {
            return this.q;
        }
    }
    
    @Override
    public final long zze() {
        this.u();
        synchronized (this.a) {
            return this.r;
        }
    }
    
    @Override
    public final long zzf() {
        this.u();
        synchronized (this.a) {
            return this.E;
        }
    }
    
    @Override
    public final zzbbl zzg() {
        if (!this.b) {
            return null;
        }
        if (this.zzM() && this.zzN()) {
            return null;
        }
        if (!(boolean)zzbjg.zzb.zze()) {
            return null;
        }
        synchronized (this.a) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.e == null) {
                this.e = new zzbbl();
            }
            this.e.zze();
            zzcfi.zzi("start fetching content...");
            return this.e;
        }
    }
    
    @Override
    public final zzcel zzh() {
        this.u();
        synchronized (this.a) {
            return this.p;
        }
    }
    
    @Override
    public final zzcel zzi() {
        synchronized (this.a) {
            return this.p;
        }
    }
    
    @Override
    public final String zzj() {
        this.u();
        synchronized (this.a) {
            return this.i;
        }
    }
    
    @Override
    public final String zzk() {
        this.u();
        synchronized (this.a) {
            return this.j;
        }
    }
    
    @Override
    public final String zzl() {
        this.u();
        synchronized (this.a) {
            return this.B;
        }
    }
    
    @Override
    public final String zzm() {
        this.u();
        synchronized (this.a) {
            return this.y;
        }
    }
    
    @Override
    public final String zzn(String s) {
        this.u();
        synchronized (this.a) {
            final int hashCode = s.hashCode();
            int n = 0;
            Label_0081: {
                if (hashCode != -2004976699) {
                    if (hashCode != 83641339) {
                        if (hashCode == 1218895378) {
                            if (s.equals("IABTCF_TCString")) {
                                n = 1;
                                break Label_0081;
                            }
                        }
                    }
                    else if (s.equals("IABTCF_gdprApplies")) {
                        n = 0;
                        break Label_0081;
                    }
                }
                else if (s.equals("IABTCF_PurposeConsents")) {
                    n = 2;
                    break Label_0081;
                }
                n = -1;
            }
            if (n == 0) {
                s = this.l;
                return s;
            }
            if (n == 1) {
                s = this.m;
                return s;
            }
            if (n != 2) {
                return null;
            }
            s = this.n;
            return s;
        }
    }
    
    @Override
    public final String zzo() {
        this.u();
        synchronized (this.a) {
            return this.z;
        }
    }
    
    @Override
    public final JSONObject zzp() {
        this.u();
        synchronized (this.a) {
            return this.v;
        }
    }
    
    @Override
    public final void zzs() {
        this.u();
        synchronized (this.a) {
            this.v = new JSONObject();
            final SharedPreferences$Editor g = this.g;
            if (g != null) {
                g.remove("native_advanced_settings");
                this.g.apply();
            }
            this.v();
        }
    }
}
