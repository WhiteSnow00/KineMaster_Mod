// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Bundle;
import android.app.PendingIntent;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import com.google.android.gms.common.internal.Preconditions;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import javax.annotation.concurrent.GuardedBy;
import java.util.HashMap;
import java.util.ArrayList;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.Map;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import android.content.Context;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zabi implements zaca, zau
{
    private final Lock a;
    private final Condition b;
    private final Context c;
    private final GoogleApiAvailabilityLight d;
    private final u e;
    final Map f;
    final Map g;
    final ClientSettings h;
    final Map i;
    final Api.AbstractClientBuilder j;
    private volatile zabf p;
    private ConnectionResult w;
    int x;
    final zabe y;
    final zabz z;
    
    public zabi(final Context c, final zabe y, final Lock a, final Looper looper, final GoogleApiAvailabilityLight d, final Map f, final ClientSettings h, final Map i, final Api.AbstractClientBuilder j, final ArrayList list, final zabz z) {
        this.g = new HashMap();
        this.w = null;
        this.c = c;
        this.a = a;
        this.d = d;
        this.f = f;
        this.h = h;
        this.i = i;
        this.j = j;
        this.y = y;
        this.z = z;
        for (int size = list.size(), k = 0; k < size; ++k) {
            ((zat)list.get(k)).a(this);
        }
        this.e = new u(this, looper);
        this.b = a.newCondition();
        this.p = new zaax(this);
    }
    
    static /* bridge */ zabf k(final zabi zabi) {
        return zabi.p;
    }
    
    static /* bridge */ Lock l(final zabi zabi) {
        return zabi.a;
    }
    
    @Override
    public final void M0(final ConnectionResult connectionResult, final Api api, final boolean b) {
        this.a.lock();
        try {
            this.p.d(connectionResult, api, b);
        }
        finally {
            this.a.unlock();
        }
    }
    
    @GuardedBy
    @Override
    public final void a() {
        this.p.c();
    }
    
    @GuardedBy
    @Override
    public final void b() {
        if (this.p instanceof zaaj) {
            ((zaaj)this.p).j();
        }
    }
    
    @Override
    public final void c() {
    }
    
    @GuardedBy
    @Override
    public final void d() {
        if (this.p.g()) {
            this.g.clear();
        }
    }
    
    @Override
    public final boolean e(final SignInConnectionListener signInConnectionListener) {
        return false;
    }
    
    @Override
    public final void f(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        final String concat = String.valueOf(s).concat("  ");
        printWriter.append(s).append("mState=").println(this.p);
        for (final Api api : this.i.keySet()) {
            printWriter.append(s).append(api.d()).println(":");
            Preconditions.k(this.f.get(api.b())).dump(concat, fileDescriptor, printWriter, array);
        }
    }
    
    @GuardedBy
    @Override
    public final ConnectionResult g(long n, final TimeUnit timeUnit) {
        this.a();
        n = timeUnit.toNanos(n);
    Label_0041_Outer:
        while (this.p instanceof zaaw) {
            while (true) {
                if (n <= 0L) {
                    try {
                        this.d();
                        return new ConnectionResult(14, null);
                        n = this.b.awaitNanos(n);
                        continue Label_0041_Outer;
                    }
                    catch (final InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        return new ConnectionResult(15, null);
                    }
                    break;
                }
                continue;
            }
        }
        if (this.p instanceof zaaj) {
            return ConnectionResult.e;
        }
        final ConnectionResult w = this.w;
        if (w != null) {
            return w;
        }
        return new ConnectionResult(13, null);
    }
    
    @GuardedBy
    @Override
    public final BaseImplementation.ApiMethodImpl h(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.m();
        this.p.f(apiMethodImpl);
        return apiMethodImpl;
    }
    
    @Override
    public final boolean i() {
        return this.p instanceof zaaj;
    }
    
    @GuardedBy
    @Override
    public final BaseImplementation.ApiMethodImpl j(final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.m();
        return this.p.h(apiMethodImpl);
    }
    
    final void m() {
        this.a.lock();
        try {
            this.y.z();
            (this.p = new zaaj(this)).b();
            this.b.signalAll();
        }
        finally {
            this.a.unlock();
        }
    }
    
    final void n() {
        this.a.lock();
        try {
            (this.p = new zaaw(this, this.h, this.i, this.d, this.j, this.a, this.c)).b();
            this.b.signalAll();
        }
        finally {
            this.a.unlock();
        }
    }
    
    final void o(final ConnectionResult w) {
        this.a.lock();
        try {
            this.w = w;
            (this.p = new zaax(this)).b();
            this.b.signalAll();
        }
        finally {
            this.a.unlock();
        }
    }
    
    @Override
    public final void onConnected(final Bundle bundle) {
        this.a.lock();
        try {
            this.p.a(bundle);
        }
        finally {
            this.a.unlock();
        }
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
        this.a.lock();
        try {
            this.p.e(n);
        }
        finally {
            this.a.unlock();
        }
    }
    
    final void p(final t t) {
        ((Handler)this.e).sendMessage(((Handler)this.e).obtainMessage(1, (Object)t));
    }
    
    final void q(final RuntimeException ex) {
        ((Handler)this.e).sendMessage(((Handler)this.e).obtainMessage(2, (Object)ex));
    }
}
