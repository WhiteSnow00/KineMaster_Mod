// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.ConnectionResult;
import android.util.Log;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.google.android.gms.common.GoogleApiAvailability;
import android.util.SparseArray;

public final class zak extends zap
{
    private final SparseArray f;
    
    private zak(final LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.q());
        this.f = new SparseArray();
        super.a.J("AutoManageHelper", this);
    }
    
    public static zak t(final LifecycleActivity lifecycleActivity) {
        final LifecycleFragment d = LifecycleCallback.d(lifecycleActivity);
        final zak zak = d.u0("AutoManageHelper", zak.class);
        if (zak != null) {
            return zak;
        }
        return new zak(d);
    }
    
    private final m0 w(final int n) {
        if (this.f.size() <= n) {
            return null;
        }
        final SparseArray f = this.f;
        return (m0)f.get(f.keyAt(n));
    }
    
    @Override
    public final void a(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        for (int i = 0; i < this.f.size(); ++i) {
            final m0 w = this.w(i);
            if (w != null) {
                printWriter.append(s).append("GoogleApiClient #").print(w.a);
                printWriter.println(":");
                w.b.g(String.valueOf(s).concat("  "), fileDescriptor, printWriter, array);
            }
        }
    }
    
    @Override
    public final void j() {
        super.j();
        final boolean b = super.b;
        final String value = String.valueOf(this.f);
        final StringBuilder sb = new StringBuilder();
        sb.append("onStart ");
        sb.append(b);
        sb.append(" ");
        sb.append(value);
        Log.d("AutoManageHelper", sb.toString());
        if (super.c.get() == null) {
            for (int i = 0; i < this.f.size(); ++i) {
                final m0 w = this.w(i);
                if (w != null) {
                    w.b.e();
                }
            }
        }
    }
    
    @Override
    public final void k() {
        super.k();
        for (int i = 0; i < this.f.size(); ++i) {
            final m0 w = this.w(i);
            if (w != null) {
                w.b.f();
            }
        }
    }
    
    @Override
    protected final void m(final ConnectionResult connectionResult, final int n) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (n < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", (Throwable)new Exception());
            return;
        }
        final m0 m0 = (m0)this.f.get(n);
        if (m0 != null) {
            this.v(n);
            final GoogleApiClient.OnConnectionFailedListener c = m0.c;
            if (c != null) {
                c.onConnectionFailed(connectionResult);
            }
        }
    }
    
    @Override
    protected final void n() {
        for (int i = 0; i < this.f.size(); ++i) {
            final m0 w = this.w(i);
            if (w != null) {
                w.b.e();
            }
        }
    }
    
    public final void u(final int n, final GoogleApiClient googleApiClient, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.l(googleApiClient, "GoogleApiClient instance cannot be null");
        final boolean b = this.f.indexOfKey(n) < 0;
        final StringBuilder sb = new StringBuilder();
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(n);
        Preconditions.p(b, sb.toString());
        final n0 n2 = super.c.get();
        final boolean b2 = super.b;
        final String value = String.valueOf(n2);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("starting AutoManage for client ");
        sb2.append(n);
        sb2.append(" ");
        sb2.append(b2);
        sb2.append(" ");
        sb2.append(value);
        Log.d("AutoManageHelper", sb2.toString());
        final m0 m0 = new m0(this, n, googleApiClient, onConnectionFailedListener);
        googleApiClient.p((GoogleApiClient.OnConnectionFailedListener)m0);
        this.f.put(n, (Object)m0);
        if (super.b && n2 == null) {
            Log.d("AutoManageHelper", "connecting ".concat(googleApiClient.toString()));
            googleApiClient.e();
        }
    }
    
    public final void v(final int n) {
        final m0 m0 = (m0)this.f.get(n);
        this.f.remove(n);
        if (m0 != null) {
            m0.b.q((GoogleApiClient.OnConnectionFailedListener)m0);
            m0.b.f();
        }
    }
}
