// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import java.util.ArrayList;
import com.google.android.gms.ads.query.AdInfo;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import android.os.Bundle;
import java.util.HashSet;

public final class zzdq
{
    private final HashSet a;
    private final Bundle b;
    private final HashMap c;
    private final HashSet d;
    private final Bundle e;
    private final HashSet f;
    private Date g;
    private String h;
    private final List i;
    private int j;
    private String k;
    private String l;
    private int m;
    private boolean n;
    private AdInfo o;
    private String p;
    private int q;
    
    public zzdq() {
        this.a = new HashSet();
        this.b = new Bundle();
        this.c = new HashMap();
        this.d = new HashSet();
        this.e = new Bundle();
        this.f = new HashSet();
        this.i = new ArrayList();
        this.j = -1;
        this.m = -1;
        this.q = 60000;
    }
    
    static /* bridge */ boolean f(final zzdq zzdq) {
        return zzdq.n;
    }
    
    static /* bridge */ int g(final zzdq zzdq) {
        return zzdq.j;
    }
    
    static /* bridge */ int h(final zzdq zzdq) {
        return zzdq.q;
    }
    
    static /* bridge */ int i(final zzdq zzdq) {
        return zzdq.m;
    }
    
    static /* bridge */ Bundle j(final zzdq zzdq) {
        return zzdq.e;
    }
    
    static /* bridge */ Bundle k(final zzdq zzdq) {
        return zzdq.b;
    }
    
    static /* bridge */ AdInfo l(final zzdq zzdq) {
        return zzdq.o;
    }
    
    static /* bridge */ String m(final zzdq zzdq) {
        return zzdq.p;
    }
    
    static /* bridge */ String n(final zzdq zzdq) {
        return zzdq.h;
    }
    
    static /* bridge */ String o(final zzdq zzdq) {
        return zzdq.k;
    }
    
    static /* bridge */ String p(final zzdq zzdq) {
        return zzdq.l;
    }
    
    static /* bridge */ Date q(final zzdq zzdq) {
        return zzdq.g;
    }
    
    static /* bridge */ HashMap r(final zzdq zzdq) {
        return zzdq.c;
    }
    
    static /* bridge */ HashSet s(final zzdq zzdq) {
        return zzdq.f;
    }
    
    static /* bridge */ HashSet t(final zzdq zzdq) {
        return zzdq.a;
    }
    
    static /* bridge */ HashSet u(final zzdq zzdq) {
        return zzdq.d;
    }
    
    static /* bridge */ List v(final zzdq zzdq) {
        return zzdq.i;
    }
    
    @Deprecated
    public final void a(final Date g) {
        this.g = g;
    }
    
    @Deprecated
    public final void b(final int j) {
        this.j = j;
    }
    
    public final void c(final int q) {
        this.q = q;
    }
    
    @Deprecated
    public final void d(final boolean n) {
        this.n = n;
    }
    
    @Deprecated
    public final void e(final boolean m) {
        this.m = (m ? 1 : 0);
    }
    
    public final void w(final String s) {
        this.a.add(s);
    }
    
    public final void x(final Class clazz, final Bundle bundle) {
        this.b.putBundle(clazz.getName(), bundle);
    }
    
    public final void y(final String s) {
        this.d.add(s);
    }
    
    public final void z(final String s) {
        this.d.remove("B3EEABB8EE11C2BE770B684D95219ECB");
    }
}
