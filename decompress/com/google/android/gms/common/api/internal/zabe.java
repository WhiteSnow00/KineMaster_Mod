// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.io.Writer;
import java.io.StringWriter;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.Result;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;
import javax.annotation.concurrent.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.Iterator;
import java.util.HashSet;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.LinkedList;
import java.util.List;
import com.google.android.gms.common.internal.zaj;
import java.util.ArrayList;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.Set;
import java.util.Map;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Queue;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.internal.zak;
import java.util.concurrent.locks.Lock;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zabe extends GoogleApiClient implements zabz
{
    private final Lock b;
    private final zak c;
    private zaca d;
    private final int e;
    private final Context f;
    private final Looper g;
    @VisibleForTesting
    final Queue h;
    private volatile boolean i;
    private long j;
    private long k;
    private final r l;
    private final GoogleApiAvailability m;
    @VisibleForTesting
    zabx n;
    final Map o;
    Set p;
    final ClientSettings q;
    final Map r;
    final Api.AbstractClientBuilder s;
    private final ListenerHolders t;
    private final ArrayList u;
    private Integer v;
    Set w;
    final zadc x;
    private final zaj y;
    
    public zabe(final Context f, final Lock b, final Looper g, final ClientSettings q, final GoogleApiAvailability m, final Api.AbstractClientBuilder s, final Map r, final List list, final List list2, final Map o, final int e, final int n, final ArrayList u) {
        this.d = null;
        this.h = new LinkedList();
        long j;
        if (!ClientLibraryUtils.a()) {
            j = 120000L;
        }
        else {
            j = 10000L;
        }
        this.j = j;
        this.k = 5000L;
        this.p = new HashSet();
        this.t = new ListenerHolders();
        this.v = null;
        this.w = null;
        final q y = new q(this);
        this.y = y;
        this.f = f;
        this.b = b;
        this.c = new zak(g, y);
        this.g = g;
        this.l = new r(this, g);
        this.m = m;
        this.e = e;
        if (e >= 0) {
            this.v = n;
        }
        this.r = r;
        this.o = o;
        this.u = u;
        this.x = new zadc();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            this.c.f((ConnectionCallbacks)iterator.next());
        }
        final Iterator iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            this.c.g((OnConnectionFailedListener)iterator2.next());
        }
        this.q = q;
        this.s = s;
    }
    
    private final void A(int n) {
        final Integer v = this.v;
        if (v == null) {
            this.v = n;
        }
        else if (v != n) {
            final int intValue = this.v;
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot use sign-in mode: ");
            sb.append(w(n));
            sb.append(". Mode was already set to ");
            sb.append(w(intValue));
            throw new IllegalStateException(sb.toString());
        }
        if (this.d != null) {
            return;
        }
        final Iterator iterator = this.o.values().iterator();
        boolean b = false;
        n = 0;
        while (iterator.hasNext()) {
            final Api.Client client = (Api.Client)iterator.next();
            b |= client.requiresSignIn();
            n |= (client.providesSignIn() ? 1 : 0);
        }
        final int intValue2 = this.v;
        if (intValue2 != 1) {
            if (intValue2 == 2) {
                if (b) {
                    this.d = com.google.android.gms.common.api.internal.a.q(this.f, this, this.b, this.g, this.m, this.o, this.q, this.r, this.s, this.u);
                    return;
                }
            }
        }
        else {
            if (!b) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (n != 0) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        }
        this.d = new zabi(this.f, this, this.b, this.g, this.m, this.o, this.q, this.r, this.s, this.u, this);
    }
    
    @GuardedBy
    private final void B() {
        this.c.b();
        Preconditions.k(this.d).a();
    }
    
    public static int u(final Iterable iterable, final boolean b) {
        final Iterator iterator = iterable.iterator();
        boolean b2 = false;
        boolean b3 = false;
        while (iterator.hasNext()) {
            final Api.Client client = (Api.Client)iterator.next();
            b2 |= client.requiresSignIn();
            b3 |= client.providesSignIn();
        }
        if (!b2) {
            return 3;
        }
        if (b3 && b) {
            return 2;
        }
        return 1;
    }
    
    static String w(final int n) {
        if (n == 1) {
            return "SIGN_IN_MODE_REQUIRED";
        }
        if (n == 2) {
            return "SIGN_IN_MODE_OPTIONAL";
        }
        if (n != 3) {
            return "UNKNOWN";
        }
        return "SIGN_IN_MODE_NONE";
    }
    
    static /* bridge */ void x(final zabe zabe) {
        zabe.b.lock();
        try {
            if (zabe.i) {
                zabe.B();
            }
        }
        finally {
            zabe.b.unlock();
        }
    }
    
    static /* bridge */ void y(final zabe zabe) {
        zabe.b.lock();
        try {
            if (zabe.z()) {
                zabe.B();
            }
        }
        finally {
            zabe.b.unlock();
        }
    }
    
    @GuardedBy
    @Override
    public final void a(final Bundle bundle) {
        while (!this.h.isEmpty()) {
            this.i((BaseImplementation.ApiMethodImpl)this.h.remove());
        }
        this.c.d(bundle);
    }
    
    @GuardedBy
    @Override
    public final void b(int i, final boolean b) {
        int n = i;
        Label_0124: {
            if (i != 1) {
                break Label_0124;
            }
            Label_0122: {
                if (b) {
                    break Label_0122;
                }
                if (this.i) {
                    break Label_0122;
                }
                this.i = true;
                while (true) {
                    if (this.n != null || ClientLibraryUtils.a()) {
                        break Label_0078;
                    }
                    try {
                        this.n = this.m.w(this.f.getApplicationContext(), new s(this));
                        final r l = this.l;
                        ((Handler)l).sendMessageDelayed(((Handler)l).obtainMessage(1), this.j);
                        final r j = this.l;
                        ((Handler)j).sendMessageDelayed(((Handler)j).obtainMessage(2), this.k);
                        n = 1;
                        final Set a = this.x.a;
                        i = 0;
                        for (BasePendingResult[] array = a.toArray(new BasePendingResult[0]); i < array.length; ++i) {
                            array[i].f(zadc.c);
                        }
                        this.c.e(n);
                        this.c.a();
                        if (n == 2) {
                            this.B();
                        }
                    }
                    catch (final SecurityException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    @GuardedBy
    @Override
    public final void c(final ConnectionResult connectionResult) {
        if (!this.m.k(this.f, connectionResult.K1())) {
            this.z();
        }
        if (!this.i) {
            this.c.c(connectionResult);
            this.c.a();
        }
    }
    
    @Override
    public final ConnectionResult d(final long n, final TimeUnit timeUnit) {
        Preconditions.p(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.l(timeUnit, "TimeUnit must not be null");
        this.b.lock();
        try {
            final Integer v = this.v;
            if (v == null) {
                this.v = u(this.o.values(), false);
            }
            else if (v == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            this.A(Preconditions.k(this.v));
            this.c.b();
            return Preconditions.k(this.d).g(n, timeUnit);
        }
        finally {
            this.b.unlock();
        }
    }
    
    @Override
    public final void e() {
        this.b.lock();
        try {
            final int e = this.e;
            final int n = 2;
            final boolean b = false;
            if (e >= 0) {
                Preconditions.p(this.v != null, "Sign-in mode should have been set explicitly by auto-manage.");
            }
            else {
                final Integer v = this.v;
                if (v == null) {
                    this.v = u(this.o.values(), false);
                }
                else if (v == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = Preconditions.k(this.v);
            this.b.lock();
            Label_0141: {
                if (intValue != 3 && intValue != 1) {
                    if (intValue != 2) {
                        final boolean b2 = b;
                        break Label_0141;
                    }
                    intValue = n;
                }
                final boolean b2 = true;
                try {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Illegal sign-in mode: ");
                    sb.append(intValue);
                    Preconditions.b(b2, sb.toString());
                    this.A(intValue);
                    this.B();
                    return;
                }
                finally {
                    this.b.unlock();
                }
            }
            throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
        }
        finally {
            this.b.unlock();
        }
    }
    
    @Override
    public final void f() {
        this.b.lock();
        try {
            this.x.b();
            final zaca d = this.d;
            if (d != null) {
                d.d();
            }
            this.t.c();
            for (final BaseImplementation.ApiMethodImpl apiMethodImpl : this.h) {
                apiMethodImpl.p(null);
                apiMethodImpl.d();
            }
            this.h.clear();
            Lock lock;
            if (this.d == null) {
                lock = this.b;
            }
            else {
                this.z();
                this.c.a();
                lock = this.b;
            }
            lock.unlock();
        }
        finally {
            this.b.unlock();
        }
    }
    
    @Override
    public final void g(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.append(s).append("mContext=").println(this.f);
        printWriter.append(s).append("mResuming=").print(this.i);
        printWriter.append(" mWorkQueue.size()=").print(this.h.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.x.a.size());
        final zaca d = this.d;
        if (d != null) {
            d.f(s, fileDescriptor, printWriter, array);
        }
    }
    
    @Override
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T h(final T t) {
        final Api<?> r = ((BaseImplementation.ApiMethodImpl)t).r();
        final boolean containsKey = this.o.containsKey(t.s());
        String d;
        if (r != null) {
            d = r.d();
        }
        else {
            d = "the API";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(d);
        sb.append(" required for this call.");
        Preconditions.b(containsKey, sb.toString());
        this.b.lock();
        try {
            final zaca d2 = this.d;
            BaseImplementation.ApiMethodImpl<R, A> h;
            Lock b2;
            if (d2 == null) {
                this.h.add(t);
                final Lock b = this.b;
                h = t;
                b2 = b;
            }
            else {
                h = d2.h(t);
                b2 = this.b;
            }
            b2.unlock();
            return (T)h;
        }
        finally {
            this.b.unlock();
        }
    }
    
    @Override
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T i(T j) {
        final Api<?> r = ((BaseImplementation.ApiMethodImpl)j).r();
        final boolean containsKey = this.o.containsKey(j.s());
        String d;
        if (r != null) {
            d = r.d();
        }
        else {
            d = "the API";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(d);
        sb.append(" required for this call.");
        Preconditions.b(containsKey, sb.toString());
        this.b.lock();
        try {
            final zaca d2 = this.d;
            if (d2 != null) {
                Lock lock;
                if (this.i) {
                    this.h.add(j);
                    while (!this.h.isEmpty()) {
                        final BaseImplementation.ApiMethodImpl apiMethodImpl = (BaseImplementation.ApiMethodImpl)this.h.remove();
                        this.x.a(apiMethodImpl);
                        apiMethodImpl.w(Status.i);
                    }
                    lock = this.b;
                }
                else {
                    j = (T)d2.j(j);
                    lock = this.b;
                }
                lock.unlock();
                return j;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        }
        finally {
            this.b.unlock();
        }
    }
    
    @Override
    public final <C extends Api.Client> C k(final Api.AnyClientKey<C> anyClientKey) {
        final Api.Client client = this.o.get(anyClientKey);
        Preconditions.l(client, "Appropriate Api was not requested.");
        return (C)client;
    }
    
    @Override
    public final Context l() {
        return this.f;
    }
    
    @Override
    public final Looper m() {
        return this.g;
    }
    
    @Override
    public final boolean n(final SignInConnectionListener signInConnectionListener) {
        final zaca d = this.d;
        return d != null && d.e(signInConnectionListener);
    }
    
    @Override
    public final void o() {
        final zaca d = this.d;
        if (d != null) {
            d.c();
        }
    }
    
    @Override
    public final void p(final OnConnectionFailedListener onConnectionFailedListener) {
        this.c.g(onConnectionFailedListener);
    }
    
    @Override
    public final void q(final OnConnectionFailedListener onConnectionFailedListener) {
        this.c.h(onConnectionFailedListener);
    }
    
    @Override
    public final void r(final zada zada) {
        this.b.lock();
        try {
            final Set w = this.w;
            if (w == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", (Throwable)new Exception());
                return;
            }
            if (!w.remove(zada)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", (Throwable)new Exception());
                return;
            }
            this.b.lock();
            try {
                final Set w2 = this.w;
                if (w2 == null) {
                    this.b.unlock();
                }
                else {
                    final boolean empty = w2.isEmpty();
                    this.b.unlock();
                    if (empty ^ true) {
                        return;
                    }
                }
                final zaca d = this.d;
                if (d != null) {
                    d.b();
                }
            }
            finally {
                this.b.unlock();
            }
        }
        finally {
            this.b.unlock();
        }
    }
    
    public final boolean t() {
        final zaca d = this.d;
        return d != null && d.i();
    }
    
    final String v() {
        final StringWriter stringWriter = new StringWriter();
        this.g("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }
    
    @GuardedBy
    final boolean z() {
        if (!this.i) {
            return false;
        }
        this.i = false;
        ((Handler)this.l).removeMessages(2);
        ((Handler)this.l).removeMessages(1);
        final zabx n = this.n;
        if (n != null) {
            n.b();
            this.n = null;
        }
        return true;
    }
}
