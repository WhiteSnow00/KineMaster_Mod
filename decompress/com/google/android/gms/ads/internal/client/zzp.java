// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.AdInfo;
import android.os.Bundle;
import java.util.Set;
import java.util.Date;
import android.location.Location;
import java.util.Comparator;
import java.util.Arrays;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.List;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzp
{
    public static final zzp a;
    
    static {
        a = new zzp();
    }
    
    @VisibleForTesting
    protected zzp() {
    }
    
    public final zzl a(Context applicationContext, final zzdr zzdr) {
        final Date m = zzdr.m();
        long time;
        if (m != null) {
            time = m.getTime();
        }
        else {
            time = -1L;
        }
        final String j = zzdr.j();
        final int a = zzdr.a();
        final Set p2 = zzdr.p();
        List<Object> unmodifiableList;
        if (!p2.isEmpty()) {
            unmodifiableList = Collections.unmodifiableList((List<?>)new ArrayList<Object>(p2));
        }
        else {
            unmodifiableList = null;
        }
        final boolean r = zzdr.r(applicationContext);
        final Bundle e = zzdr.e(AdMobAdapter.class);
        final AdInfo g = zzdr.g();
        zzc zzc;
        if (g != null) {
            final QueryInfo b = g.b();
            String b2;
            if (b != null) {
                b2 = b.c().b();
            }
            else {
                b2 = "";
            }
            zzc = new zzc(zzdr.g().a(), b2);
        }
        else {
            zzc = null;
        }
        final String k = zzdr.k();
        final SearchAdRequest h = zzdr.h();
        zzfc zzfc;
        if (h != null) {
            zzfc = new zzfc(h);
        }
        else {
            zzfc = null;
        }
        applicationContext = applicationContext.getApplicationContext();
        String zzo;
        if (applicationContext != null) {
            final String packageName = applicationContext.getPackageName();
            zzaw.b();
            zzo = zzcfb.zzo(Thread.currentThread().getStackTrace(), packageName);
        }
        else {
            zzo = null;
        }
        final boolean q = zzdr.q();
        final RequestConfiguration c = zzee.f().c();
        return new zzl(8, time, e, a, unmodifiableList, r, Math.max(zzdr.c(), c.b()), false, k, zzfc, null, j, zzdr.f(), zzdr.d(), Collections.unmodifiableList((List<?>)new ArrayList<Object>(zzdr.o())), zzdr.l(), zzo, q, zzc, Math.max(-1, c.c()), (String)Collections.max((Collection<?>)Arrays.asList(null, c.a()), (Comparator<? super Object>)com.google.android.gms.ads.internal.client.zzo.a), zzdr.n(), zzdr.b(), zzdr.i());
    }
}
