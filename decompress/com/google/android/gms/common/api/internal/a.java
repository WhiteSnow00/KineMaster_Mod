// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.common.internal.Preconditions;
import android.util.Log;
import com.google.android.gms.internal.base.zap;
import android.app.PendingIntent;
import java.util.Iterator;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.ArrayList;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import javax.annotation.concurrent.GuardedBy;
import java.util.concurrent.locks.Lock;
import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import java.util.Set;
import java.util.Map;
import android.os.Looper;
import android.content.Context;

final class a implements zaca
{
    private final Context a;
    private final zabe b;
    private final Looper c;
    private final zabi d;
    private final zabi e;
    private final Map f;
    private final Set g;
    private final Api.Client h;
    private Bundle i;
    private ConnectionResult j;
    private ConnectionResult p;
    private boolean w;
    private final Lock x;
    @GuardedBy
    private int y;
    
    private a(final Context a, final zabe b, final Lock x, final Looper c, final GoogleApiAvailabilityLight googleApiAvailabilityLight, final Map map, final Map map2, final ClientSettings clientSettings, final Api.AbstractClientBuilder abstractClientBuilder, final Api.Client h, final ArrayList list, final ArrayList list2, final Map map3, final Map map4) {
        this.g = Collections.newSetFromMap(new WeakHashMap<Object, Boolean>());
        this.j = null;
        this.p = null;
        this.w = false;
        this.y = 0;
        this.a = a;
        this.b = b;
        this.x = x;
        this.c = c;
        this.h = h;
        this.d = new zabi(a, b, x, c, googleApiAvailabilityLight, map2, null, map4, null, list2, new t0(this, null));
        this.e = new zabi(a, b, x, c, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, list, new u0(this, null));
        final androidx.collection.a a2 = new androidx.collection.a();
        final Iterator iterator = map2.keySet().iterator();
        while (iterator.hasNext()) {
            a2.put(iterator.next(), this.d);
        }
        final Iterator iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            a2.put(iterator2.next(), this.e);
        }
        this.f = Collections.unmodifiableMap((Map<?, ?>)a2);
    }
    
    static /* bridge */ boolean A(final a a) {
        return a.w;
    }
    
    private final PendingIntent C() {
        if (this.h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.a, System.identityHashCode(this.b), this.h.getSignInIntent(), zap.zaa | 0x8000000);
    }
    
    @GuardedBy
    private final void k(final ConnectionResult connectionResult) {
        final int y = this.y;
        Label_0045: {
            if (y != 1) {
                if (y != 2) {
                    Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", (Throwable)new Exception());
                    break Label_0045;
                }
                this.b.c(connectionResult);
            }
            this.l();
        }
        this.y = 0;
    }
    
    @GuardedBy
    private final void l() {
        final Iterator iterator = this.g.iterator();
        while (iterator.hasNext()) {
            ((SignInConnectionListener)iterator.next()).onComplete();
        }
        this.g.clear();
    }
    
    @GuardedBy
    private final boolean m() {
        final ConnectionResult p = this.p;
        return p != null && p.K1() == 4;
    }
    
    private final boolean n(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        final zabi zabi = this.f.get(apiMethodImpl.s());
        Preconditions.l(zabi, "GoogleApiClient is not configured to use the API required for this call.");
        return zabi.equals(this.e);
    }
    
    private static boolean o(final ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.O1();
    }
    
    static /* bridge */ ConnectionResult p(final a a) {
        return a.p;
    }
    
    public static a q(final Context context, final zabe zabe, final Lock lock, final Looper looper, final GoogleApiAvailabilityLight googleApiAvailabilityLight, final Map map, final ClientSettings clientSettings, final Map map2, final Api.AbstractClientBuilder abstractClientBuilder, final ArrayList list) {
        final androidx.collection.a a = new androidx.collection.a();
        final androidx.collection.a a2 = new androidx.collection.a();
        final Iterator iterator = map.entrySet().iterator();
        Api.Client client = null;
        while (iterator.hasNext()) {
            final Map.Entry<K, Api.Client> entry = (Map.Entry<K, Api.Client>)iterator.next();
            final Api.Client client2 = entry.getValue();
            if (client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                a.put(entry.getKey(), client2);
            }
            else {
                a2.put(entry.getKey(), client2);
            }
        }
        Preconditions.p(a.isEmpty() ^ true, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        final androidx.collection.a a3 = new androidx.collection.a();
        final androidx.collection.a a4 = new androidx.collection.a();
        for (final Api api : map2.keySet()) {
            final Api.AnyClientKey b = api.b();
            if (a.containsKey(b)) {
                a3.put(api, map2.get(api));
            }
            else {
                if (!a2.containsKey(b)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                a4.put(api, map2.get(api));
            }
        }
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        for (int size = list.size(), i = 0; i < size; ++i) {
            final zat zat = (zat)list.get(i);
            if (a3.containsKey(zat.a)) {
                list2.add(zat);
            }
            else {
                if (!a4.containsKey(zat.a)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                list3.add(zat);
            }
        }
        return new a(context, zabe, lock, looper, googleApiAvailabilityLight, a, a2, clientSettings, abstractClientBuilder, client, list2, list3, a3, a4);
    }
    
    static /* bridge */ zabi r(final a a) {
        return a.d;
    }
    
    static /* bridge */ zabi s(final a a) {
        return a.e;
    }
    
    static /* bridge */ Lock t(final a a) {
        return a.x;
    }
    
    static /* bridge */ void u(final a a, final ConnectionResult j) {
        a.j = j;
    }
    
    static /* bridge */ void v(final a a, final ConnectionResult p2) {
        a.p = p2;
    }
    
    static /* bridge */ void w(final a a, final boolean w) {
        a.w = w;
    }
    
    static /* bridge */ void x(final a a, final int n, final boolean b) {
        a.b.b(n, b);
        a.p = null;
        a.j = null;
    }
    
    static /* bridge */ void y(final a a, final Bundle i) {
        final Bundle j = a.i;
        if (j == null) {
            a.i = i;
            return;
        }
        if (i != null) {
            j.putAll(i);
        }
    }
    
    static /* bridge */ void z(final a a) {
        if (o(a.j)) {
            if (o(a.p) || a.m()) {
                final int y = a.y;
                Label_0120: {
                    if (y != 1) {
                        if (y != 2) {
                            Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", (Throwable)new AssertionError());
                            break Label_0120;
                        }
                        Preconditions.k(a.b).a(a.i);
                    }
                    a.l();
                }
                a.y = 0;
                return;
            }
            final ConnectionResult p = a.p;
            if (p != null) {
                if (a.y == 1) {
                    a.l();
                    return;
                }
                a.k(p);
                a.d.d();
            }
        }
        else {
            if (a.j != null && o(a.p)) {
                a.e.d();
                a.k(Preconditions.k(a.j));
                return;
            }
            ConnectionResult j = a.j;
            if (j != null) {
                final ConnectionResult p2 = a.p;
                if (p2 != null) {
                    if (a.e.x < a.d.x) {
                        j = p2;
                    }
                    a.k(j);
                }
            }
        }
    }
    
    public final boolean B() {
        this.x.lock();
        try {
            return this.y == 2;
        }
        finally {
            this.x.unlock();
        }
    }
    
    @GuardedBy
    @Override
    public final void a() {
        this.y = 2;
        this.w = false;
        this.p = null;
        this.j = null;
        this.d.a();
        this.e.a();
    }
    
    @GuardedBy
    @Override
    public final void b() {
        this.d.b();
        this.e.b();
    }
    
    @Override
    public final void c() {
        this.x.lock();
        try {
            final boolean b = this.B();
            this.e.d();
            this.p = new ConnectionResult(4);
            if (b) {
                ((Handler)new zau(this.c)).post((Runnable)new s0(this));
            }
            else {
                this.l();
            }
        }
        finally {
            this.x.unlock();
        }
    }
    
    @GuardedBy
    @Override
    public final void d() {
        this.p = null;
        this.j = null;
        this.y = 0;
        this.d.d();
        this.e.d();
        this.l();
    }
    
    @Override
    public final boolean e(final SignInConnectionListener signInConnectionListener) {
        this.x.lock();
        try {
            if ((this.B() || this.i()) && !this.e.i()) {
                this.g.add(signInConnectionListener);
                if (this.y == 0) {
                    this.y = 1;
                }
                this.p = null;
                this.e.a();
                return true;
            }
            return false;
        }
        finally {
            this.x.unlock();
        }
    }
    
    @Override
    public final void f(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.append(s).append("authClient").println(":");
        this.e.f(String.valueOf(s).concat("  "), fileDescriptor, printWriter, array);
        printWriter.append(s).append("anonClient").println(":");
        this.d.f(String.valueOf(s).concat("  "), fileDescriptor, printWriter, array);
    }
    
    @GuardedBy
    @Override
    public final ConnectionResult g(final long n, final TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }
    
    @GuardedBy
    @Override
    public final BaseImplementation.ApiMethodImpl h(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (!this.n(apiMethodImpl)) {
            this.d.h(apiMethodImpl);
            return apiMethodImpl;
        }
        if (this.m()) {
            apiMethodImpl.w(new Status(4, null, this.C()));
            return apiMethodImpl;
        }
        this.e.h(apiMethodImpl);
        return apiMethodImpl;
    }
    
    @Override
    public final boolean i() {
        this.x.lock();
        try {
            final boolean i = this.d.i();
            boolean b = false;
            if (i) {
                if (!this.e.i() && !this.m()) {
                    final int y = this.y;
                    b = b;
                    if (y != 1) {
                        return b;
                    }
                }
                b = true;
            }
            return b;
        }
        finally {
            this.x.unlock();
        }
    }
    
    @GuardedBy
    @Override
    public final BaseImplementation.ApiMethodImpl j(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (!this.n(apiMethodImpl)) {
            return this.d.j(apiMethodImpl);
        }
        if (this.m()) {
            apiMethodImpl.w(new Status(4, null, this.C()));
            return apiMethodImpl;
        }
        return this.e.j(apiMethodImpl);
    }
}
