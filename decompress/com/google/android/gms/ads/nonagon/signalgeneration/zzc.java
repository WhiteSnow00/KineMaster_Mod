// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdwn;
import java.util.concurrent.Executor;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.ConcurrentModificationException;
import com.google.android.gms.ads.internal.zzt;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.concurrent.ConcurrentHashMap;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.internal.ads.zzdwb;
import java.util.Collections;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzdwl;
import java.util.ArrayDeque;
import javax.annotation.concurrent.GuardedBy;
import java.util.Map;

public final class zzc
{
    private final int a;
    private final long b;
    private final boolean c;
    private final boolean d;
    @GuardedBy
    private final Map e;
    @GuardedBy
    private final ArrayDeque f;
    @GuardedBy
    private final ArrayDeque g;
    private final zzdwl h;
    private Map i;
    
    public zzc(final zzdwl h) {
        this.f = new ArrayDeque();
        this.g = new ArrayDeque();
        this.h = h;
        this.a = (int)zzay.c().zzb(zzbhy.zzfU);
        this.b = (long)zzay.c().zzb(zzbhy.zzfV);
        this.c = (boolean)zzay.c().zzb(zzbhy.zzga);
        this.d = (boolean)zzay.c().zzb(zzbhy.zzfY);
        this.e = Collections.synchronizedMap((Map<Object, Object>)new zzb(this));
    }
    
    static /* bridge */ int a(final zzc zzc) {
        return zzc.a;
    }
    
    static /* bridge */ ArrayDeque c(final zzc zzc) {
        return zzc.f;
    }
    
    private final void g(final zzdwb zzdwb) {
        synchronized (this) {
            if (!this.c) {
                return;
            }
            final ArrayDeque clone = this.g.clone();
            this.g.clear();
            final ArrayDeque clone2 = this.f.clone();
            this.f.clear();
            ((Executor)zzcfv.zza).execute(new zza(this, zzdwb, clone, clone2));
        }
    }
    
    private final void h(final zzdwb zzdwb, final ArrayDeque arrayDeque, final String s) {
        while (!arrayDeque.isEmpty()) {
            final Pair pair = arrayDeque.poll();
            (this.i = new ConcurrentHashMap(zzdwb.zza())).put("action", "ev");
            this.i.put("e_r", s);
            this.i.put("e_id", pair.first);
            if (this.d) {
                final String s2 = (String)pair.second;
                Pair pair2;
                try {
                    final JSONObject jsonObject = new JSONObject(s2);
                    pair2 = new Pair((Object)zzf.a(jsonObject.getJSONObject("extras").getString("query_info_type")), (Object)jsonObject.getString("request_agent"));
                }
                catch (final JSONException ex) {
                    pair2 = new Pair((Object)"", (Object)"");
                }
                j(this.i, "e_type", (String)pair2.first);
                j(this.i, "e_agent", (String)pair2.second);
            }
            ((zzdwn)this.h).zze(this.i);
        }
    }
    
    private final void i() {
        synchronized (this) {
            final long a = zzt.a().a();
            final Set entrySet = this.e.entrySet();
            try {
                final Iterator iterator = entrySet.iterator();
                while (iterator.hasNext()) {
                    final Map.Entry<K, Pair> entry = (Map.Entry<K, Pair>)iterator.next();
                    if (a - (long)entry.getValue().first <= this.b) {
                        break;
                    }
                    this.g.add(new Pair((Object)entry.getKey(), (Object)entry.getValue().second));
                    iterator.remove();
                }
            }
            catch (final ConcurrentModificationException ex) {
                zzt.p().zzt((Throwable)ex, "QueryJsonMap.removeExpiredEntries");
            }
        }
    }
    
    private static final void j(final Map map, final String s, final String s2) {
        if (!TextUtils.isEmpty((CharSequence)s2)) {
            map.put(s, s2);
        }
    }
    
    public final String b(final String s, final zzdwb zzdwb) {
        synchronized (this) {
            final Pair pair = this.e.get(s);
            zzdwb.zza().put("rid", s);
            if (pair != null) {
                final String s2 = (String)pair.second;
                this.e.remove(s);
                zzdwb.zza().put("mhit", "true");
                return s2;
            }
            zzdwb.zza().put("mhit", "false");
            return null;
        }
    }
    
    public final void d(final String s, final String s2, final zzdwb zzdwb) {
        synchronized (this) {
            this.e.put(s, new Pair((Object)zzt.a().a(), (Object)s2));
            this.i();
            this.g(zzdwb);
        }
    }
    
    final void e(final zzdwb zzdwb, final ArrayDeque arrayDeque, final ArrayDeque arrayDeque2) {
        this.h(zzdwb, arrayDeque, "to");
        this.h(zzdwb, arrayDeque2, "of");
    }
    
    public final void f(final String s) {
        synchronized (this) {
            this.e.remove(s);
        }
    }
}
