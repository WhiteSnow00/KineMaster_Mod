// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Bundle;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import android.app.PendingIntent;
import android.util.Log;
import android.os.Message;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collection;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import com.google.android.gms.common.internal.Objects;
import androidx.collection.a;
import com.google.android.gms.common.Feature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.ConnectionResult;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.google.android.gms.common.api.Api;
import java.util.Queue;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zabq implements ConnectionCallbacks, OnConnectionFailedListener, zau
{
    private final Queue a;
    private final Api.Client b;
    private final ApiKey c;
    private final zaad d;
    private final Set e;
    private final Map f;
    private final int g;
    private final zact h;
    private boolean i;
    private final List j;
    private ConnectionResult p;
    private int w;
    final GoogleApiManager x;
    
    public zabq(final GoogleApiManager x, final GoogleApi googleApi) {
        this.x = x;
        this.a = new LinkedList();
        this.e = new HashSet();
        this.f = new HashMap();
        this.j = new ArrayList();
        this.p = null;
        this.w = 0;
        final Api.Client zab = googleApi.zab(GoogleApiManager.s(x).getLooper(), this);
        this.b = zab;
        this.c = googleApi.getApiKey();
        this.d = new zaad();
        this.g = googleApi.zaa();
        if (zab.requiresSignIn()) {
            this.h = googleApi.zac(GoogleApiManager.r(x), GoogleApiManager.s(x));
            return;
        }
        this.h = null;
    }
    
    static /* bridge */ boolean K(final zabq zabq, final boolean b) {
        return zabq.n(false);
    }
    
    private final Feature b(final Feature[] array) {
        if (array != null) {
            if (array.length != 0) {
                final Feature[] availableFeatures = this.b.getAvailableFeatures();
                final int n = 0;
                Feature[] array2;
                if ((array2 = availableFeatures) == null) {
                    array2 = new Feature[0];
                }
                final int length = array2.length;
                final a a = new a(length);
                for (final Feature feature : array2) {
                    a.put((Object)feature.K1(), (Object)feature.L1());
                }
                for (int length2 = array.length, j = n; j < length2; ++j) {
                    final Feature feature2 = array[j];
                    final Long n2 = (Long)a.get(feature2.K1());
                    if (n2 == null || n2 < feature2.L1()) {
                        return feature2;
                    }
                }
            }
        }
        return null;
    }
    
    private final void c(final ConnectionResult connectionResult) {
        for (final zal zal : this.e) {
            String endpointPackageName;
            if (Objects.b(connectionResult, ConnectionResult.e)) {
                endpointPackageName = this.b.getEndpointPackageName();
            }
            else {
                endpointPackageName = null;
            }
            zal.b(this.c, connectionResult, endpointPackageName);
        }
        this.e.clear();
    }
    
    private final void d(final Status status) {
        Preconditions.d(GoogleApiManager.s(this.x));
        this.e(status, null, false);
    }
    
    private final void e(final Status status, final Exception ex, final boolean b) {
        Preconditions.d(GoogleApiManager.s(this.x));
        int n = false ? 1 : 0;
        final boolean b2 = status == null;
        if (ex == null) {
            n = (true ? 1 : 0);
        }
        if ((b2 ? 1 : 0) != n) {
            final Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                final zai zai = (zai)iterator.next();
                if (!b || zai.a == 2) {
                    if (status != null) {
                        zai.a(status);
                    }
                    else {
                        zai.b(ex);
                    }
                    iterator.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }
    
    private final void f() {
        final ArrayList list = new ArrayList(this.a);
        for (int size = list.size(), i = 0; i < size; ++i) {
            final zai zai = (zai)list.get(i);
            if (!this.b.isConnected()) {
                break;
            }
            if (this.l(zai)) {
                this.a.remove(zai);
            }
        }
    }
    
    private final void g() {
        this.A();
        this.c(ConnectionResult.e);
        this.k();
        final Iterator iterator = this.f.values().iterator();
        while (iterator.hasNext()) {
            final zaci zaci = (zaci)iterator.next();
            if (this.b(zaci.a.c()) == null) {
                try {
                    zaci.a.d(this.b, new TaskCompletionSource());
                    continue;
                }
                catch (final RemoteException ex) {
                    iterator.remove();
                    continue;
                }
                catch (final DeadObjectException ex2) {
                    this.onConnectionSuspended(3);
                    this.b.disconnect("DeadObjectException thrown while calling register listener method.");
                }
                break;
            }
            iterator.remove();
        }
        this.f();
        this.i();
    }
    
    private final void h(final int n) {
        this.A();
        this.i = true;
        this.d.e(n, this.b.getLastDisconnectMessage());
        final GoogleApiManager x = this.x;
        GoogleApiManager.s(x).sendMessageDelayed(Message.obtain(GoogleApiManager.s(x), 9, (Object)this.c), GoogleApiManager.o(this.x));
        final GoogleApiManager x2 = this.x;
        GoogleApiManager.s(x2).sendMessageDelayed(Message.obtain(GoogleApiManager.s(x2), 11, (Object)this.c), GoogleApiManager.p(this.x));
        GoogleApiManager.z(this.x).c();
        final Iterator iterator = this.f.values().iterator();
        while (iterator.hasNext()) {
            ((zaci)iterator.next()).c.run();
        }
    }
    
    private final void i() {
        GoogleApiManager.s(this.x).removeMessages(12, (Object)this.c);
        final GoogleApiManager x = this.x;
        GoogleApiManager.s(x).sendMessageDelayed(GoogleApiManager.s(x).obtainMessage(12, (Object)this.c), GoogleApiManager.q(this.x));
    }
    
    private final void j(final zai zai) {
        zai.d(this.d, this.M());
        try {
            zai.c(this);
        }
        catch (final DeadObjectException ex) {
            this.onConnectionSuspended(1);
            this.b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }
    
    private final void k() {
        if (this.i) {
            GoogleApiManager.s(this.x).removeMessages(11, (Object)this.c);
            GoogleApiManager.s(this.x).removeMessages(9, (Object)this.c);
            this.i = false;
        }
    }
    
    private final boolean l(final zai zai) {
        if (!(zai instanceof zac)) {
            this.j(zai);
            return true;
        }
        final zac zac = (zac)zai;
        final Feature b = this.b(zac.g(this));
        if (b == null) {
            this.j(zai);
            return true;
        }
        final String name = this.b.getClass().getName();
        final String k1 = b.K1();
        final long l1 = b.L1();
        final StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" could not execute call because it requires feature (");
        sb.append(k1);
        sb.append(", ");
        sb.append(l1);
        sb.append(").");
        Log.w("GoogleApiManager", sb.toString());
        if (GoogleApiManager.f(this.x) && zac.f(this)) {
            final a0 a0 = new a0(this.c, b, null);
            final int index = this.j.indexOf(a0);
            if (index >= 0) {
                final a0 a2 = this.j.get(index);
                GoogleApiManager.s(this.x).removeMessages(15, (Object)a2);
                final GoogleApiManager x = this.x;
                GoogleApiManager.s(x).sendMessageDelayed(Message.obtain(GoogleApiManager.s(x), 15, (Object)a2), GoogleApiManager.o(this.x));
            }
            else {
                this.j.add(a0);
                final GoogleApiManager x2 = this.x;
                GoogleApiManager.s(x2).sendMessageDelayed(Message.obtain(GoogleApiManager.s(x2), 15, (Object)a0), GoogleApiManager.o(this.x));
                final GoogleApiManager x3 = this.x;
                GoogleApiManager.s(x3).sendMessageDelayed(Message.obtain(GoogleApiManager.s(x3), 16, (Object)a0), GoogleApiManager.p(this.x));
                final ConnectionResult connectionResult = new ConnectionResult(2, null);
                if (!this.m(connectionResult)) {
                    this.x.h(connectionResult, this.g);
                }
            }
            return false;
        }
        zac.b(new UnsupportedApiCallException(b));
        return true;
    }
    
    private final boolean m(final ConnectionResult connectionResult) {
        synchronized (GoogleApiManager.D()) {
            final GoogleApiManager x = this.x;
            if (GoogleApiManager.w(x) != null && GoogleApiManager.F(x).contains(this.c)) {
                GoogleApiManager.w(this.x).s(connectionResult, this.g);
                return true;
            }
            return false;
        }
    }
    
    private final boolean n(final boolean b) {
        Preconditions.d(GoogleApiManager.s(this.x));
        if (!this.b.isConnected() || this.f.size() != 0) {
            return false;
        }
        if (this.d.g()) {
            if (b) {
                this.i();
            }
            return false;
        }
        this.b.disconnect("Timing out service connection.");
        return true;
    }
    
    static /* bridge */ Api.Client r(final zabq zabq) {
        return zabq.b;
    }
    
    static /* bridge */ ApiKey t(final zabq zabq) {
        return zabq.c;
    }
    
    static /* bridge */ void v(final zabq zabq, final Status status) {
        zabq.d(status);
    }
    
    static /* bridge */ void w(final zabq zabq) {
        zabq.g();
    }
    
    static /* bridge */ void x(final zabq zabq, final int n) {
        zabq.h(n);
    }
    
    static /* bridge */ void y(final zabq zabq, final a0 a0) {
        if (zabq.j.contains(a0)) {
            if (!zabq.i) {
                if (!zabq.b.isConnected()) {
                    zabq.B();
                    return;
                }
                zabq.f();
            }
        }
    }
    
    static /* bridge */ void z(final zabq zabq, final a0 a0) {
        if (zabq.j.remove(a0)) {
            GoogleApiManager.s(zabq.x).removeMessages(15, (Object)a0);
            GoogleApiManager.s(zabq.x).removeMessages(16, (Object)a0);
            final Feature a2 = a0.a(a0);
            final ArrayList list = new ArrayList(zabq.a.size());
            for (final zai zai : zabq.a) {
                if (zai instanceof zac) {
                    final Feature[] g = ((zac)zai).g(zabq);
                    if (g == null || !ArrayUtils.c(g, a2)) {
                        continue;
                    }
                    list.add(zai);
                }
            }
            for (int size = list.size(), i = 0; i < size; ++i) {
                final zai zai2 = (zai)list.get(i);
                zabq.a.remove(zai2);
                zai2.b(new UnsupportedApiCallException(a2));
            }
        }
    }
    
    public final void A() {
        Preconditions.d(GoogleApiManager.s(this.x));
        this.p = null;
    }
    
    public final void B() {
        Preconditions.d(GoogleApiManager.s(this.x));
        if (!this.b.isConnected()) {
            if (!this.b.isConnecting()) {
                try {
                    final GoogleApiManager x = this.x;
                    final int b = GoogleApiManager.z(x).b(GoogleApiManager.r(x), this.b);
                    if (b != 0) {
                        final ConnectionResult connectionResult = new ConnectionResult(b, null);
                        final String name = this.b.getClass().getName();
                        final String string = connectionResult.toString();
                        final StringBuilder sb = new StringBuilder();
                        sb.append("The service for ");
                        sb.append(name);
                        sb.append(" is not available: ");
                        sb.append(string);
                        Log.w("GoogleApiManager", sb.toString());
                        this.E(connectionResult, null);
                        return;
                    }
                    final GoogleApiManager x2 = this.x;
                    final Api.Client b2 = this.b;
                    final c0 c0 = new c0(x2, b2, this.c);
                    if (b2.requiresSignIn()) {
                        Preconditions.k(this.h).r1(c0);
                    }
                    try {
                        this.b.connect(c0);
                    }
                    catch (final SecurityException ex) {
                        this.E(new ConnectionResult(10), ex);
                    }
                }
                catch (final IllegalStateException ex2) {
                    this.E(new ConnectionResult(10), ex2);
                }
            }
        }
    }
    
    public final void C(final zai zai) {
        Preconditions.d(GoogleApiManager.s(this.x));
        if (this.b.isConnected()) {
            if (this.l(zai)) {
                this.i();
                return;
            }
            this.a.add(zai);
        }
        else {
            this.a.add(zai);
            final ConnectionResult p = this.p;
            if (p != null && p.N1()) {
                this.E(this.p, null);
                return;
            }
            this.B();
        }
    }
    
    final void D() {
        ++this.w;
    }
    
    public final void E(final ConnectionResult p2, final Exception ex) {
        Preconditions.d(GoogleApiManager.s(this.x));
        final zact h = this.h;
        if (h != null) {
            h.s1();
        }
        this.A();
        GoogleApiManager.z(this.x).c();
        this.c(p2);
        if (this.b instanceof zap && p2.K1() != 24) {
            GoogleApiManager.G(this.x, true);
            final GoogleApiManager x = this.x;
            GoogleApiManager.s(x).sendMessageDelayed(GoogleApiManager.s(x).obtainMessage(19), 300000L);
        }
        if (p2.K1() == 4) {
            this.d(GoogleApiManager.u());
            return;
        }
        if (this.a.isEmpty()) {
            this.p = p2;
            return;
        }
        if (ex != null) {
            Preconditions.d(GoogleApiManager.s(this.x));
            this.e(null, ex, false);
            return;
        }
        if (!GoogleApiManager.f(this.x)) {
            this.d(GoogleApiManager.v(this.c, p2));
            return;
        }
        this.e(GoogleApiManager.v(this.c, p2), null, true);
        if (this.a.isEmpty()) {
            return;
        }
        if (this.m(p2)) {
            return;
        }
        if (!this.x.h(p2, this.g)) {
            if (p2.K1() == 18) {
                this.i = true;
            }
            if (this.i) {
                final GoogleApiManager x2 = this.x;
                GoogleApiManager.s(x2).sendMessageDelayed(Message.obtain(GoogleApiManager.s(x2), 9, (Object)this.c), GoogleApiManager.o(this.x));
                return;
            }
            this.d(GoogleApiManager.v(this.c, p2));
        }
    }
    
    public final void F(final ConnectionResult connectionResult) {
        Preconditions.d(GoogleApiManager.s(this.x));
        final Api.Client b = this.b;
        final String name = b.getClass().getName();
        final String value = String.valueOf(connectionResult);
        final StringBuilder sb = new StringBuilder();
        sb.append("onSignInFailed for ");
        sb.append(name);
        sb.append(" with ");
        sb.append(value);
        b.disconnect(sb.toString());
        this.E(connectionResult, null);
    }
    
    public final void G(final zal zal) {
        Preconditions.d(GoogleApiManager.s(this.x));
        this.e.add(zal);
    }
    
    public final void H() {
        Preconditions.d(GoogleApiManager.s(this.x));
        if (this.i) {
            this.B();
        }
    }
    
    public final void I() {
        Preconditions.d(GoogleApiManager.s(this.x));
        this.d(GoogleApiManager.C);
        this.d.f();
        final Set keySet = this.f.keySet();
        int i = 0;
        for (ListenerHolder.ListenerKey[] array = (ListenerHolder.ListenerKey[])keySet.toArray(new ListenerHolder.ListenerKey[0]); i < array.length; ++i) {
            this.C(new zah(array[i], new TaskCompletionSource()));
        }
        this.c(new ConnectionResult(4));
        if (this.b.isConnected()) {
            this.b.onUserSignOut(new z(this));
        }
    }
    
    public final void J() {
        Preconditions.d(GoogleApiManager.s(this.x));
        if (this.i) {
            this.k();
            final GoogleApiManager x = this.x;
            Status status;
            if (GoogleApiManager.t(x).i(GoogleApiManager.r(x)) == 18) {
                status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
            }
            else {
                status = new Status(22, "API failed to connect while resuming due to an unknown error.");
            }
            this.d(status);
            this.b.disconnect("Timing out connection while resuming.");
        }
    }
    
    final boolean L() {
        return this.b.isConnected();
    }
    
    public final boolean M() {
        return this.b.requiresSignIn();
    }
    
    @Override
    public final void M0(final ConnectionResult connectionResult, final Api api, final boolean b) {
        throw null;
    }
    
    public final boolean a() {
        return this.n(true);
    }
    
    public final int o() {
        return this.g;
    }
    
    @Override
    public final void onConnected(final Bundle bundle) {
        if (Looper.myLooper() == GoogleApiManager.s(this.x).getLooper()) {
            this.g();
            return;
        }
        GoogleApiManager.s(this.x).post((Runnable)new w(this));
    }
    
    @Override
    public final void onConnectionFailed(final ConnectionResult connectionResult) {
        this.E(connectionResult, null);
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
        if (Looper.myLooper() == GoogleApiManager.s(this.x).getLooper()) {
            this.h(n);
            return;
        }
        GoogleApiManager.s(this.x).post((Runnable)new x(this, n));
    }
    
    final int p() {
        return this.w;
    }
    
    public final ConnectionResult q() {
        Preconditions.d(GoogleApiManager.s(this.x));
        return this.p;
    }
    
    public final Api.Client s() {
        return this.b;
    }
    
    public final Map u() {
        return this.f;
    }
}
