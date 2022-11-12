// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Iterator;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.api.internal.zak;
import java.util.concurrent.locks.Lock;
import com.google.android.gms.common.api.internal.zabe;
import java.util.concurrent.locks.ReentrantLock;
import com.google.android.gms.common.api.internal.zat;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import java.util.Collection;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zad;
import androidx.collection.a;
import java.util.HashSet;
import java.util.ArrayList;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import android.view.View;
import android.accounts.Account;
import com.google.android.gms.common.api.internal.zada;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;
import java.util.Set;

@Deprecated
public abstract class GoogleApiClient
{
    @GuardedBy
    private static final Set a;
    
    static {
        a = Collections.newSetFromMap(new WeakHashMap<Object, Boolean>());
    }
    
    @KeepForSdk
    public static Set<GoogleApiClient> j() {
        final Set a = GoogleApiClient.a;
        synchronized (a) {
            return a;
        }
    }
    
    static /* bridge */ Set s() {
        return GoogleApiClient.a;
    }
    
    public abstract ConnectionResult d(final long p0, final TimeUnit p1);
    
    public abstract void e();
    
    public abstract void f();
    
    public abstract void g(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3);
    
    @KeepForSdk
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T h(final T t) {
        throw new UnsupportedOperationException();
    }
    
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T i(final T t) {
        throw new UnsupportedOperationException();
    }
    
    @KeepForSdk
    public <C extends Api.Client> C k(final Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }
    
    @KeepForSdk
    public Context l() {
        throw new UnsupportedOperationException();
    }
    
    @KeepForSdk
    public Looper m() {
        throw new UnsupportedOperationException();
    }
    
    @KeepForSdk
    public boolean n(final SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }
    
    @KeepForSdk
    public void o() {
        throw new UnsupportedOperationException();
    }
    
    public abstract void p(final OnConnectionFailedListener p0);
    
    public abstract void q(final OnConnectionFailedListener p0);
    
    public void r(final zada zada) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    public static final class Builder
    {
        private Account a;
        private final Set b;
        private final Set c;
        private int d;
        private View e;
        private String f;
        private String g;
        private final Map h;
        private final Context i;
        private final Map j;
        private LifecycleActivity k;
        private int l;
        private OnConnectionFailedListener m;
        private Looper n;
        private GoogleApiAvailability o;
        private Api.AbstractClientBuilder p;
        private final ArrayList q;
        private final ArrayList r;
        
        public Builder(final Context i) {
            this.b = new HashSet();
            this.c = new HashSet();
            this.h = new a();
            this.j = new a();
            this.l = -1;
            this.o = GoogleApiAvailability.q();
            this.p = zad.c;
            this.q = new ArrayList();
            this.r = new ArrayList();
            this.i = i;
            this.n = i.getMainLooper();
            this.f = i.getPackageName();
            this.g = i.getClass().getName();
        }
        
        @CanIgnoreReturnValue
        public Builder a(final Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            Preconditions.l(api, "Api must not be null");
            this.j.put(api, null);
            final List a = Preconditions.l(api.c(), "Base client builder must not be null").a(null);
            this.c.addAll(a);
            this.b.addAll(a);
            return this;
        }
        
        public GoogleApiClient b() {
            Preconditions.b(this.j.isEmpty() ^ true, "must call addApi() to add at least one API");
            final ClientSettings c = this.c();
            final Map k = c.k();
            final a a = new a();
            final a a2 = new a();
            final ArrayList list = new ArrayList();
            final Iterator iterator = this.j.keySet().iterator();
            Api api = null;
            int n = 0;
            while (iterator.hasNext()) {
                final Api api2 = (Api)iterator.next();
                final Object value = this.j.get(api2);
                final boolean b = k.get(api2) != null;
                a.put(api2, b);
                final zat zat = new zat(api2, b);
                list.add(zat);
                final Api.AbstractClientBuilder abstractClientBuilder = Preconditions.k(api2.a());
                final Api.Client c2 = abstractClientBuilder.c(this.i, this.n, c, value, zat, zat);
                a2.put(api2.b(), c2);
                int n2 = n;
                if (((Api.BaseClientBuilder)abstractClientBuilder).b() == 1) {
                    if (value != null) {
                        n2 = 1;
                    }
                    else {
                        n2 = 0;
                    }
                }
                n = n2;
                if (c2.providesSignIn()) {
                    if (api != null) {
                        final String d = api2.d();
                        final String d2 = api.d();
                        final StringBuilder sb = new StringBuilder();
                        sb.append(d);
                        sb.append(" cannot be used with ");
                        sb.append(d2);
                        throw new IllegalStateException(sb.toString());
                    }
                    api = api2;
                    n = n2;
                }
            }
            if (api != null) {
                if (n != 0) {
                    final String d3 = api.d();
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("With using ");
                    sb2.append(d3);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
                Preconditions.q(this.a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.d());
                Preconditions.q(this.b.equals(this.c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.d());
            }
            final zabe zabe = new zabe(this.i, new ReentrantLock(), this.n, c, this.o, this.p, a, this.q, this.r, a2, this.l, com.google.android.gms.common.api.internal.zabe.u(a2.values(), true), list);
            synchronized (GoogleApiClient.s()) {
                GoogleApiClient.s().add(zabe);
                monitorexit(GoogleApiClient.s());
                if (this.l >= 0) {
                    zak.t(this.k).u(this.l, zabe, this.m);
                }
                return zabe;
            }
        }
        
        @VisibleForTesting
        public final ClientSettings c() {
            SignInOptions j = SignInOptions.j;
            final Map i = this.j;
            final Api g = zad.g;
            if (i.containsKey(g)) {
                j = (SignInOptions)this.j.get(g);
            }
            return new ClientSettings(this.a, this.b, this.h, this.d, this.e, this.f, this.g, j, false);
        }
    }
    
    @Deprecated
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks
    {
    }
    
    @Deprecated
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener
    {
    }
}
