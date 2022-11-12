// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.HashMap;
import com.google.android.gms.common.internal.zab;
import java.util.Collection;
import javax.annotation.concurrent.GuardedBy;
import java.util.Iterator;
import android.app.PendingIntent;
import java.util.Collections;
import java.util.concurrent.Future;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.HashSet;
import java.util.ArrayList;
import com.google.android.gms.common.api.Api;
import java.util.Map;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.signin.zae;
import java.util.Set;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import android.content.Context;
import java.util.concurrent.locks.Lock;

public final class zaaw implements zabf
{
    private final zabi a;
    private final Lock b;
    private final Context c;
    private final GoogleApiAvailabilityLight d;
    private ConnectionResult e;
    private int f;
    private int g;
    private int h;
    private final Bundle i;
    private final Set j;
    private zae k;
    private boolean l;
    private boolean m;
    private boolean n;
    private IAccountAccessor o;
    private boolean p;
    private boolean q;
    private final ClientSettings r;
    private final Map s;
    private final Api.AbstractClientBuilder t;
    private final ArrayList u;
    
    public zaaw(final zabi a, final ClientSettings r, final Map s, final GoogleApiAvailabilityLight d, final Api.AbstractClientBuilder t, final Lock b, final Context c) {
        this.g = 0;
        this.i = new Bundle();
        this.j = new HashSet();
        this.u = new ArrayList();
        this.a = a;
        this.r = r;
        this.s = s;
        this.d = d;
        this.t = t;
        this.b = b;
        this.c = c;
    }
    
    static /* bridge */ void A(final zaaw zaaw) {
        zaaw.i();
    }
    
    static /* bridge */ void B(final zaaw zaaw, final zak zak) {
        if (!zaaw.o(0)) {
            return;
        }
        final ConnectionResult k1 = zak.K1();
        if (k1.O1()) {
            final zav zav = Preconditions.k(zak.L1());
            final ConnectionResult k2 = zav.K1();
            if (!k2.O1()) {
                Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(k2)), (Throwable)new Exception());
                zaaw.l(k2);
                return;
            }
            zaaw.n = true;
            zaaw.o = Preconditions.k(zav.L1());
            zaaw.p = zav.M1();
            zaaw.q = zav.N1();
            zaaw.n();
        }
        else {
            if (zaaw.q(k1)) {
                zaaw.i();
                zaaw.n();
                return;
            }
            zaaw.l(k1);
        }
    }
    
    static /* bridge */ void C(final zaaw zaaw, final ConnectionResult connectionResult) {
        zaaw.l(connectionResult);
    }
    
    static /* bridge */ void D(final zaaw zaaw, final ConnectionResult connectionResult, final Api api, final boolean b) {
        zaaw.m(connectionResult, api, b);
    }
    
    static /* bridge */ void E(final zaaw zaaw) {
        zaaw.n();
    }
    
    static /* bridge */ boolean F(final zaaw zaaw) {
        return zaaw.m;
    }
    
    static /* bridge */ boolean G(final zaaw zaaw, final int n) {
        return zaaw.o(0);
    }
    
    static /* bridge */ boolean H(final zaaw zaaw) {
        return zaaw.p();
    }
    
    static /* bridge */ boolean I(final zaaw zaaw, final ConnectionResult connectionResult) {
        return zaaw.q(connectionResult);
    }
    
    private final void J() {
        final ArrayList u = this.u;
        for (int size = u.size(), i = 0; i < size; ++i) {
            ((Future)u.get(i)).cancel(true);
        }
        this.u.clear();
    }
    
    @GuardedBy
    private final void i() {
        this.m = false;
        this.a.y.p = Collections.emptySet();
        for (final Api.AnyClientKey anyClientKey : this.j) {
            if (!this.a.g.containsKey(anyClientKey)) {
                this.a.g.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }
    
    @GuardedBy
    private final void j(final boolean b) {
        final zae k = this.k;
        if (k != null) {
            if (((Api.Client)k).isConnected() && b) {
                k.a();
            }
            ((Api.Client)k).disconnect();
            final ClientSettings clientSettings = Preconditions.k(this.r);
            this.o = null;
        }
    }
    
    @GuardedBy
    private final void k() {
        this.a.m();
        zabj.a().execute(new g(this));
        final zae k = this.k;
        if (k != null) {
            if (this.p) {
                k.d((IAccountAccessor)Preconditions.k(this.o), this.q);
            }
            this.j(false);
        }
        final Iterator iterator = this.a.g.keySet().iterator();
        while (iterator.hasNext()) {
            Preconditions.k(this.a.f.get(iterator.next())).disconnect();
        }
        Bundle i;
        if (this.i.isEmpty()) {
            i = null;
        }
        else {
            i = this.i;
        }
        this.a.z.a(i);
    }
    
    @GuardedBy
    private final void l(final ConnectionResult connectionResult) {
        this.J();
        this.j(connectionResult.N1() ^ true);
        this.a.o(connectionResult);
        this.a.z.c(connectionResult);
    }
    
    @GuardedBy
    private final void m(final ConnectionResult e, final Api api, final boolean b) {
        final int b2 = api.c().b();
        Label_0064: {
            if (b) {
                if (!e.N1()) {
                    if (this.d.c(e.K1()) == null) {
                        break Label_0064;
                    }
                }
            }
            if (this.e == null || b2 < this.f) {
                this.e = e;
                this.f = b2;
            }
        }
        this.a.g.put(api.b(), e);
    }
    
    @GuardedBy
    private final void n() {
        if (this.h != 0) {
            return;
        }
        if (!this.m || this.n) {
            final ArrayList list = new ArrayList();
            this.g = 1;
            this.h = this.a.f.size();
            for (final Api.AnyClientKey anyClientKey : this.a.f.keySet()) {
                if (this.a.g.containsKey(anyClientKey)) {
                    if (!this.p()) {
                        continue;
                    }
                    this.k();
                }
                else {
                    list.add(this.a.f.get(anyClientKey));
                }
            }
            if (!list.isEmpty()) {
                this.u.add(zabj.a().submit(new l(this, list)));
            }
        }
    }
    
    @GuardedBy
    private final boolean o(final int n) {
        if (this.g != n) {
            Log.w("GACConnecting", this.a.y.v());
            Log.w("GACConnecting", "Unexpected callback in ".concat(this.toString()));
            final int h = this.h;
            final StringBuilder sb = new StringBuilder();
            sb.append("mRemainingConnections=");
            sb.append(h);
            Log.w("GACConnecting", sb.toString());
            final int g = this.g;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("GoogleApiClient connecting is in step ");
            sb2.append(r(g));
            sb2.append(" but received callback for step ");
            sb2.append(r(n));
            Log.e("GACConnecting", sb2.toString(), (Throwable)new Exception());
            this.l(new ConnectionResult(8, null));
            return false;
        }
        return true;
    }
    
    @GuardedBy
    private final boolean p() {
        final int h = this.h - 1;
        this.h = h;
        if (h > 0) {
            return false;
        }
        if (h < 0) {
            Log.w("GACConnecting", this.a.y.v());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", (Throwable)new Exception());
            this.l(new ConnectionResult(8, null));
            return false;
        }
        final ConnectionResult e = this.e;
        if (e != null) {
            this.a.x = this.f;
            this.l(e);
            return false;
        }
        return true;
    }
    
    @GuardedBy
    private final boolean q(final ConnectionResult connectionResult) {
        return this.l && !connectionResult.N1();
    }
    
    private static final String r(final int n) {
        if (n != 0) {
            return "STEP_GETTING_REMOTE_SERVICE";
        }
        return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }
    
    static /* bridge */ Context s(final zaaw zaaw) {
        return zaaw.c;
    }
    
    static /* bridge */ GoogleApiAvailabilityLight t(final zaaw zaaw) {
        return zaaw.d;
    }
    
    static /* bridge */ zabi u(final zaaw zaaw) {
        return zaaw.a;
    }
    
    static /* bridge */ ClientSettings v(final zaaw zaaw) {
        return zaaw.r;
    }
    
    static /* bridge */ IAccountAccessor w(final zaaw zaaw) {
        return zaaw.o;
    }
    
    static /* bridge */ zae x(final zaaw zaaw) {
        return zaaw.k;
    }
    
    static /* bridge */ Set y(final zaaw zaaw) {
        final ClientSettings r = zaaw.r;
        Set<Object> emptySet;
        if (r == null) {
            emptySet = Collections.emptySet();
        }
        else {
            final HashSet set = new HashSet(r.g());
            final Map k = zaaw.r.k();
            for (final Api api : k.keySet()) {
                if (!zaaw.a.g.containsKey(api.b())) {
                    set.addAll(((zab)k.get(api)).a);
                }
            }
            emptySet = (Set<Object>)set;
        }
        return emptySet;
    }
    
    static /* bridge */ Lock z(final zaaw zaaw) {
        return zaaw.b;
    }
    
    @GuardedBy
    @Override
    public final void a(final Bundle bundle) {
        if (!this.o(1)) {
            return;
        }
        if (bundle != null) {
            this.i.putAll(bundle);
        }
        if (this.p()) {
            this.k();
        }
    }
    
    @GuardedBy
    @Override
    public final void b() {
        this.a.g.clear();
        this.m = false;
        this.e = null;
        this.g = 0;
        this.l = true;
        this.n = false;
        this.p = false;
        final HashMap hashMap = new HashMap();
        final Iterator iterator = this.s.keySet().iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            final Api api = (Api)iterator.next();
            final Api.Client client = Preconditions.k((Api.Client)this.a.f.get(api.b()));
            b |= (api.c().b() == 1);
            final boolean booleanValue = this.s.get(api);
            if (client.requiresSignIn()) {
                this.m = true;
                if (booleanValue) {
                    this.j.add(api.b());
                }
                else {
                    this.l = false;
                }
            }
            hashMap.put(client, new h(this, api, booleanValue));
        }
        if (b) {
            this.m = false;
        }
        if (this.m) {
            Preconditions.k(this.r);
            Preconditions.k(this.t);
            this.r.l(System.identityHashCode(this.a.y));
            final o o = new o(this, null);
            final Api.AbstractClientBuilder t = this.t;
            final Context c = this.c;
            final Looper m = this.a.y.m();
            final ClientSettings r = this.r;
            this.k = t.c(c, m, r, r.h(), o, o);
        }
        this.h = this.a.f.size();
        this.u.add(zabj.a().submit(new k(this, hashMap)));
    }
    
    @Override
    public final void c() {
    }
    
    @GuardedBy
    @Override
    public final void d(final ConnectionResult connectionResult, final Api api, final boolean b) {
        if (!this.o(1)) {
            return;
        }
        this.m(connectionResult, api, b);
        if (this.p()) {
            this.k();
        }
    }
    
    @GuardedBy
    @Override
    public final void e(final int n) {
        this.l(new ConnectionResult(8, null));
    }
    
    @Override
    public final BaseImplementation.ApiMethodImpl f(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.a.y.h.add(apiMethodImpl);
        return apiMethodImpl;
    }
    
    @GuardedBy
    @Override
    public final boolean g() {
        this.J();
        this.j(true);
        this.a.o(null);
        return true;
    }
    
    @Override
    public final BaseImplementation.ApiMethodImpl h(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
