// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.internal.ads.zzcfb;
import android.content.Context;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Map;
import android.os.Bundle;
import java.util.Set;
import java.util.List;
import java.util.Date;

public final class zzdr
{
    private final Date a;
    private final String b;
    private final List c;
    private final int d;
    private final Set e;
    private final Bundle f;
    private final Map g;
    private final String h;
    private final String i;
    private final SearchAdRequest j;
    private final int k;
    private final Set l;
    private final Bundle m;
    private final Set n;
    private final boolean o;
    private final AdInfo p;
    private final String q;
    private final int r;
    
    public zzdr(final zzdq zzdq, final SearchAdRequest j) {
        this.a = zzdq.q(zzdq);
        this.b = zzdq.n(zzdq);
        this.c = zzdq.v(zzdq);
        this.d = zzdq.g(zzdq);
        this.e = Collections.unmodifiableSet((Set<?>)zzdq.t(zzdq));
        this.f = zzdq.k(zzdq);
        this.g = Collections.unmodifiableMap((Map<?, ?>)zzdq.r(zzdq));
        this.h = zzdq.o(zzdq);
        this.i = zzdq.p(zzdq);
        this.j = j;
        this.k = zzdq.i(zzdq);
        this.l = Collections.unmodifiableSet((Set<?>)zzdq.u(zzdq));
        this.m = zzdq.j(zzdq);
        this.n = Collections.unmodifiableSet((Set<?>)zzdq.s(zzdq));
        this.o = zzdq.f(zzdq);
        this.p = zzdq.l(zzdq);
        this.q = zzdq.m(zzdq);
        this.r = zzdq.h(zzdq);
    }
    
    @Deprecated
    public final int a() {
        return this.d;
    }
    
    public final int b() {
        return this.r;
    }
    
    public final int c() {
        return this.k;
    }
    
    public final Bundle d() {
        return this.m;
    }
    
    public final Bundle e(final Class clazz) {
        return this.f.getBundle(clazz.getName());
    }
    
    public final Bundle f() {
        return this.f;
    }
    
    public final AdInfo g() {
        return this.p;
    }
    
    public final SearchAdRequest h() {
        return this.j;
    }
    
    public final String i() {
        return this.q;
    }
    
    public final String j() {
        return this.b;
    }
    
    public final String k() {
        return this.h;
    }
    
    public final String l() {
        return this.i;
    }
    
    @Deprecated
    public final Date m() {
        return this.a;
    }
    
    public final List n() {
        return new ArrayList(this.c);
    }
    
    public final Set o() {
        return this.n;
    }
    
    public final Set p() {
        return this.e;
    }
    
    @Deprecated
    public final boolean q() {
        return this.o;
    }
    
    public final boolean r(final Context context) {
        final RequestConfiguration c = zzee.f().c();
        zzaw.b();
        final String zzw = zzcfb.zzw(context);
        return this.l.contains(zzw) || c.d().contains(zzw);
    }
}
