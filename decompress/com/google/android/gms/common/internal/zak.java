// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Message;
import android.util.Log;
import android.os.Bundle;
import java.util.Iterator;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Collection;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.base.zau;
import android.os.Looper;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicInteger;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import android.os.Handler$Callback;

public final class zak implements Handler$Callback
{
    private final zaj a;
    private final ArrayList b;
    @VisibleForTesting
    final ArrayList c;
    private final ArrayList d;
    private volatile boolean e;
    private final AtomicInteger f;
    private boolean g;
    private final Handler h;
    private final Object i;
    
    public zak(final Looper looper, final zaj a) {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = false;
        this.f = new AtomicInteger(0);
        this.g = false;
        this.i = new Object();
        this.a = a;
        this.h = (Handler)new zau(looper, (Handler$Callback)this);
    }
    
    public final void a() {
        this.e = false;
        this.f.incrementAndGet();
    }
    
    public final void b() {
        this.e = true;
    }
    
    @VisibleForTesting
    public final void c(final ConnectionResult connectionResult) {
        Preconditions.e(this.h, "onConnectionFailure must only be called on the Handler thread");
        this.h.removeMessages(1);
        synchronized (this.i) {
            final ArrayList list = new ArrayList(this.d);
            final int value = this.f.get();
            for (final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : list) {
                if (!this.e || this.f.get() != value) {
                    return;
                }
                if (!this.d.contains(onConnectionFailedListener)) {
                    continue;
                }
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }
    
    @VisibleForTesting
    public final void d(final Bundle bundle) {
        Preconditions.e(this.h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.i) {
            Preconditions.o(this.g ^ true);
            this.h.removeMessages(1);
            this.g = true;
            Preconditions.o(this.c.isEmpty());
            final ArrayList list = new ArrayList(this.b);
            final int value = this.f.get();
            for (final GoogleApiClient.ConnectionCallbacks connectionCallbacks : list) {
                if (!this.e || !this.a.isConnected()) {
                    break;
                }
                if (this.f.get() != value) {
                    break;
                }
                if (this.c.contains(connectionCallbacks)) {
                    continue;
                }
                connectionCallbacks.onConnected(bundle);
            }
            this.c.clear();
            this.g = false;
        }
    }
    
    @VisibleForTesting
    public final void e(final int n) {
        Preconditions.e(this.h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.h.removeMessages(1);
        synchronized (this.i) {
            this.g = true;
            final ArrayList list = new ArrayList(this.b);
            final int value = this.f.get();
            for (final GoogleApiClient.ConnectionCallbacks connectionCallbacks : list) {
                if (!this.e) {
                    break;
                }
                if (this.f.get() != value) {
                    break;
                }
                if (!this.b.contains(connectionCallbacks)) {
                    continue;
                }
                connectionCallbacks.onConnectionSuspended(n);
            }
            this.c.clear();
            this.g = false;
        }
    }
    
    public final void f(final GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.k(connectionCallbacks);
        Object o = this.i;
        synchronized (o) {
            if (this.b.contains(connectionCallbacks)) {
                final String value = String.valueOf(connectionCallbacks);
                final StringBuilder sb = new StringBuilder();
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(value);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            }
            else {
                this.b.add(connectionCallbacks);
            }
            monitorexit(o);
            if (this.a.isConnected()) {
                o = this.h;
                ((Handler)o).sendMessage(((Handler)o).obtainMessage(1, (Object)connectionCallbacks));
            }
        }
    }
    
    public final void g(final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.k(onConnectionFailedListener);
        synchronized (this.i) {
            if (this.d.contains(onConnectionFailedListener)) {
                final String value = String.valueOf(onConnectionFailedListener);
                final StringBuilder sb = new StringBuilder();
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(value);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            }
            else {
                this.d.add(onConnectionFailedListener);
            }
        }
    }
    
    public final void h(final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.k(onConnectionFailedListener);
        synchronized (this.i) {
            if (!this.d.remove(onConnectionFailedListener)) {
                final String value = String.valueOf(onConnectionFailedListener);
                final StringBuilder sb = new StringBuilder();
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(value);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }
    
    public final boolean handleMessage(final Message message) {
        final int what = message.what;
        if (what == 1) {
            final GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks)message.obj;
            synchronized (this.i) {
                if (this.e && this.a.isConnected() && this.b.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(null);
                }
                return true;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Don't know how to handle message: ");
        sb.append(what);
        Log.wtf("GmsClientEvents", sb.toString(), (Throwable)new Exception());
        return false;
    }
}
