// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.Iterator;
import android.app.Application;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import android.util.Log;
import android.os.Message;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import java.util.Collection;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import java.util.concurrent.Executor;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.base.zau;
import androidx.collection.b;
import java.util.concurrent.ConcurrentHashMap;
import android.os.Looper;
import java.util.Set;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import com.google.android.gms.common.internal.zal;
import com.google.android.gms.common.GoogleApiAvailability;
import android.content.Context;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryData;
import android.os.Handler;
import javax.annotation.concurrent.GuardedBy;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.Handler$Callback;

@KeepForSdk
@ShowFirstParty
public class GoogleApiManager implements Handler$Callback
{
    public static final Status C;
    private static final Status D;
    private static final Object E;
    @GuardedBy
    private static GoogleApiManager F;
    private final Handler A;
    private volatile boolean B;
    private long a;
    private long b;
    private long c;
    private boolean d;
    private TelemetryData e;
    private TelemetryLoggingClient f;
    private final Context g;
    private final GoogleApiAvailability h;
    private final zal i;
    private final AtomicInteger j;
    private final AtomicInteger p;
    private final Map w;
    @GuardedBy
    private zaae x;
    @GuardedBy
    private final Set y;
    private final Set z;
    
    static {
        C = new Status(4, "Sign-out occurred while this API call was in progress.");
        D = new Status(4, "The user must be signed in to make this API call.");
        E = new Object();
    }
    
    @KeepForSdk
    private GoogleApiManager(final Context g, final Looper looper, final GoogleApiAvailability h) {
        this.a = 5000L;
        this.b = 120000L;
        this.c = 10000L;
        this.d = false;
        this.j = new AtomicInteger(1);
        this.p = new AtomicInteger(0);
        this.w = new ConcurrentHashMap(5, 0.75f, 1);
        this.x = null;
        this.y = new b();
        this.z = new b();
        this.B = true;
        this.g = g;
        final zau a = new zau(looper, (Handler$Callback)this);
        this.A = (Handler)a;
        this.h = h;
        this.i = new zal(h);
        if (DeviceProperties.a(g)) {
            this.B = false;
        }
        ((Handler)a).sendMessage(((Handler)a).obtainMessage(6));
    }
    
    static /* bridge */ Object D() {
        return GoogleApiManager.E;
    }
    
    static /* bridge */ Map E(final GoogleApiManager googleApiManager) {
        return googleApiManager.w;
    }
    
    static /* bridge */ Set F(final GoogleApiManager googleApiManager) {
        return googleApiManager.y;
    }
    
    static /* bridge */ void G(final GoogleApiManager googleApiManager, final boolean b) {
        googleApiManager.d = true;
    }
    
    @KeepForSdk
    public static void a() {
        synchronized (GoogleApiManager.E) {
            final GoogleApiManager f = GoogleApiManager.F;
            if (f != null) {
                f.p.incrementAndGet();
                final Handler a = f.A;
                a.sendMessageAtFrontOfQueue(a.obtainMessage(10));
            }
        }
    }
    
    static /* bridge */ boolean f(final GoogleApiManager googleApiManager) {
        return googleApiManager.B;
    }
    
    private static Status i(final ApiKey apiKey, final ConnectionResult connectionResult) {
        final String b = apiKey.b();
        final String value = String.valueOf(connectionResult);
        final StringBuilder sb = new StringBuilder();
        sb.append("API: ");
        sb.append(b);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(value);
        return new Status(connectionResult, sb.toString());
    }
    
    private final zabq j(final GoogleApi googleApi) {
        final ApiKey apiKey = googleApi.getApiKey();
        zabq zabq;
        if ((zabq = this.w.get(apiKey)) == null) {
            zabq = new zabq(this, googleApi);
            this.w.put(apiKey, zabq);
        }
        if (zabq.M()) {
            this.z.add(apiKey);
        }
        zabq.B();
        return zabq;
    }
    
    private final TelemetryLoggingClient k() {
        if (this.f == null) {
            this.f = TelemetryLogging.a(this.g);
        }
        return this.f;
    }
    
    private final void l() {
        final TelemetryData e = this.e;
        if (e != null) {
            if (e.K1() > 0 || this.g()) {
                this.k().a(e);
            }
            this.e = null;
        }
    }
    
    private final void m(final TaskCompletionSource taskCompletionSource, final int n, final GoogleApi googleApi) {
        if (n != 0) {
            final d0 a = d0.a(this, n, googleApi.getApiKey());
            if (a != null) {
                final Task a2 = taskCompletionSource.a();
                final Handler a3 = this.A;
                a3.getClass();
                a2.d((Executor)new zabk(a3), (OnCompleteListener)a);
            }
        }
    }
    
    static /* bridge */ long o(final GoogleApiManager googleApiManager) {
        return googleApiManager.a;
    }
    
    static /* bridge */ long p(final GoogleApiManager googleApiManager) {
        return googleApiManager.b;
    }
    
    static /* bridge */ long q(final GoogleApiManager googleApiManager) {
        return googleApiManager.c;
    }
    
    static /* bridge */ Context r(final GoogleApiManager googleApiManager) {
        return googleApiManager.g;
    }
    
    static /* bridge */ Handler s(final GoogleApiManager googleApiManager) {
        return googleApiManager.A;
    }
    
    static /* bridge */ GoogleApiAvailability t(final GoogleApiManager googleApiManager) {
        return googleApiManager.h;
    }
    
    static /* bridge */ Status u() {
        return GoogleApiManager.D;
    }
    
    static /* bridge */ Status v(final ApiKey apiKey, final ConnectionResult connectionResult) {
        return i(apiKey, connectionResult);
    }
    
    static /* bridge */ zaae w(final GoogleApiManager googleApiManager) {
        return googleApiManager.x;
    }
    
    public static GoogleApiManager y(final Context context) {
        synchronized (GoogleApiManager.E) {
            if (GoogleApiManager.F == null) {
                GoogleApiManager.F = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.d().getLooper(), GoogleApiAvailability.q());
            }
            return GoogleApiManager.F;
        }
    }
    
    static /* bridge */ zal z(final GoogleApiManager googleApiManager) {
        return googleApiManager.i;
    }
    
    public final Task A(final GoogleApi googleApi) {
        final d d = new d(googleApi.getApiKey());
        final Handler a = this.A;
        a.sendMessage(a.obtainMessage(14, (Object)d));
        return d.b().a();
    }
    
    public final Task B(final GoogleApi googleApi, final RegisterListenerMethod registerListenerMethod, final UnregisterListenerMethod unregisterListenerMethod, final Runnable runnable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.m(taskCompletionSource, registerListenerMethod.e(), googleApi);
        final zaf zaf = new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource);
        final Handler a = this.A;
        a.sendMessage(a.obtainMessage(8, (Object)new zach(zaf, this.p.get(), googleApi)));
        return taskCompletionSource.a();
    }
    
    public final Task C(final GoogleApi googleApi, final ListenerHolder.ListenerKey listenerKey, final int n) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.m(taskCompletionSource, n, googleApi);
        final zah zah = new zah(listenerKey, taskCompletionSource);
        final Handler a = this.A;
        a.sendMessage(a.obtainMessage(13, (Object)new zach(zah, this.p.get(), googleApi)));
        return taskCompletionSource.a();
    }
    
    public final void H(final GoogleApi googleApi, final int n, final BaseImplementation.ApiMethodImpl apiMethodImpl) {
        final zae zae = new zae(n, apiMethodImpl);
        final Handler a = this.A;
        a.sendMessage(a.obtainMessage(4, (Object)new zach(zae, this.p.get(), googleApi)));
    }
    
    public final void I(final GoogleApi googleApi, final int n, final TaskApiCall taskApiCall, final TaskCompletionSource taskCompletionSource, final StatusExceptionMapper statusExceptionMapper) {
        this.m(taskCompletionSource, taskApiCall.d(), googleApi);
        final zag zag = new zag(n, taskApiCall, taskCompletionSource, statusExceptionMapper);
        final Handler a = this.A;
        a.sendMessage(a.obtainMessage(4, (Object)new zach(zag, this.p.get(), googleApi)));
    }
    
    final void J(final MethodInvocation methodInvocation, final int n, final long n2, final int n3) {
        final Handler a = this.A;
        a.sendMessage(a.obtainMessage(18, (Object)new e0(methodInvocation, n, n2, n3)));
    }
    
    public final void K(final ConnectionResult connectionResult, final int n) {
        if (!this.h(connectionResult, n)) {
            final Handler a = this.A;
            a.sendMessage(a.obtainMessage(5, n, 0, (Object)connectionResult));
        }
    }
    
    public final void b() {
        final Handler a = this.A;
        a.sendMessage(a.obtainMessage(3));
    }
    
    public final void c(final GoogleApi googleApi) {
        final Handler a = this.A;
        a.sendMessage(a.obtainMessage(7, (Object)googleApi));
    }
    
    public final void d(final zaae x) {
        synchronized (GoogleApiManager.E) {
            if (this.x != x) {
                this.x = x;
                this.y.clear();
            }
            this.y.addAll(x.t());
        }
    }
    
    final void e(final zaae zaae) {
        synchronized (GoogleApiManager.E) {
            if (this.x == zaae) {
                this.x = null;
                this.y.clear();
            }
        }
    }
    
    final boolean g() {
        if (this.d) {
            return false;
        }
        final RootTelemetryConfiguration a = RootTelemetryConfigManager.b().a();
        if (a != null && !a.M1()) {
            return false;
        }
        final int a2 = this.i.a(this.g, 203400000);
        return a2 == -1 || a2 == 0;
    }
    
    final boolean h(final ConnectionResult connectionResult, final int n) {
        return this.h.B(this.g, connectionResult, n);
    }
    
    public final boolean handleMessage(final Message message) {
        final int what = message.what;
        long c = 300000L;
        final zabq zabq = null;
        switch (what) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown message id: ");
                sb.append(what);
                Log.w("GoogleApiManager", sb.toString());
                return false;
            }
            case 19: {
                this.d = false;
                break;
            }
            case 18: {
                final e0 e0 = (e0)message.obj;
                if (e0.c == 0L) {
                    this.k().a(new TelemetryData(e0.b, Arrays.asList(e0.a)));
                    break;
                }
                final TelemetryData e2 = this.e;
                if (e2 != null) {
                    final List l1 = e2.L1();
                    if (e2.K1() == e0.b && (l1 == null || l1.size() < e0.d)) {
                        this.e.M1(e0.a);
                    }
                    else {
                        this.A.removeMessages(17);
                        this.l();
                    }
                }
                if (this.e == null) {
                    final ArrayList<MethodInvocation> list = new ArrayList<MethodInvocation>();
                    list.add(e0.a);
                    this.e = new TelemetryData(e0.b, list);
                    final Handler a = this.A;
                    a.sendMessageDelayed(a.obtainMessage(17), e0.c);
                    break;
                }
                break;
            }
            case 17: {
                this.l();
                break;
            }
            case 16: {
                final a0 a2 = (a0)message.obj;
                if (this.w.containsKey(a0.b(a2))) {
                    com.google.android.gms.common.api.internal.zabq.z((zabq)this.w.get(a0.b(a2)), a2);
                    break;
                }
                break;
            }
            case 15: {
                final a0 a3 = (a0)message.obj;
                if (this.w.containsKey(a0.b(a3))) {
                    com.google.android.gms.common.api.internal.zabq.y((zabq)this.w.get(a0.b(a3)), a3);
                    break;
                }
                break;
            }
            case 14: {
                final d d = (d)message.obj;
                final ApiKey a4 = d.a();
                if (!this.w.containsKey(a4)) {
                    d.b().c((Object)Boolean.FALSE);
                    break;
                }
                d.b().c((Object)com.google.android.gms.common.api.internal.zabq.K((zabq)this.w.get(a4), false));
                break;
            }
            case 12: {
                if (this.w.containsKey(message.obj)) {
                    this.w.get(message.obj).a();
                    break;
                }
                break;
            }
            case 11: {
                if (this.w.containsKey(message.obj)) {
                    this.w.get(message.obj).J();
                    break;
                }
                break;
            }
            case 10: {
                final Iterator iterator = this.z.iterator();
                while (iterator.hasNext()) {
                    final zabq zabq2 = this.w.remove(iterator.next());
                    if (zabq2 != null) {
                        zabq2.I();
                    }
                }
                this.z.clear();
                break;
            }
            case 9: {
                if (this.w.containsKey(message.obj)) {
                    this.w.get(message.obj).H();
                    break;
                }
                break;
            }
            case 7: {
                this.j((GoogleApi)message.obj);
                break;
            }
            case 6: {
                if (!(this.g.getApplicationContext() instanceof Application)) {
                    break;
                }
                BackgroundDetector.c((Application)this.g.getApplicationContext());
                BackgroundDetector.b().a((BackgroundDetector.BackgroundStateChangeListener)new v(this));
                if (!BackgroundDetector.b().e(true)) {
                    this.c = 300000L;
                    break;
                }
                break;
            }
            case 5: {
                final int arg1 = message.arg1;
                final ConnectionResult connectionResult = (ConnectionResult)message.obj;
                final Iterator iterator2 = this.w.values().iterator();
                zabq zabq3;
                do {
                    zabq3 = zabq;
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    zabq3 = (zabq)iterator2.next();
                } while (zabq3.o() != arg1);
                if (zabq3 == null) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Could not find API instance ");
                    sb2.append(arg1);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), (Throwable)new Exception());
                    break;
                }
                if (connectionResult.K1() == 13) {
                    final String g = this.h.g(connectionResult.K1());
                    final String l2 = connectionResult.L1();
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Error resolution was canceled by the user, original error message: ");
                    sb3.append(g);
                    sb3.append(": ");
                    sb3.append(l2);
                    com.google.android.gms.common.api.internal.zabq.v(zabq3, new Status(17, sb3.toString()));
                    break;
                }
                com.google.android.gms.common.api.internal.zabq.v(zabq3, i(com.google.android.gms.common.api.internal.zabq.t(zabq3), connectionResult));
                break;
            }
            case 4:
            case 8:
            case 13: {
                final zach zach = (zach)message.obj;
                zabq j;
                if ((j = this.w.get(zach.c.getApiKey())) == null) {
                    j = this.j(zach.c);
                }
                if (j.M() && this.p.get() != zach.b) {
                    zach.a.a(GoogleApiManager.C);
                    j.I();
                    break;
                }
                j.C(zach.a);
                break;
            }
            case 3: {
                for (final zabq zabq4 : this.w.values()) {
                    zabq4.A();
                    zabq4.B();
                }
                break;
            }
            case 2: {
                final com.google.android.gms.common.api.internal.zal zal = (com.google.android.gms.common.api.internal.zal)message.obj;
                for (final ApiKey apiKey : zal.a()) {
                    final zabq zabq5 = this.w.get(apiKey);
                    if (zabq5 == null) {
                        zal.b(apiKey, new ConnectionResult(13), null);
                        break;
                    }
                    if (zabq5.L()) {
                        zal.b(apiKey, ConnectionResult.e, zabq5.s().getEndpointPackageName());
                    }
                    else {
                        final ConnectionResult q = zabq5.q();
                        if (q != null) {
                            zal.b(apiKey, q, null);
                        }
                        else {
                            zabq5.G(zal);
                            zabq5.B();
                        }
                    }
                }
                break;
            }
            case 1: {
                if (message.obj) {
                    c = 10000L;
                }
                this.c = c;
                this.A.removeMessages(12);
                for (final ApiKey apiKey2 : this.w.keySet()) {
                    final Handler a5 = this.A;
                    a5.sendMessageDelayed(a5.obtainMessage(12, (Object)apiKey2), this.c);
                }
                break;
            }
        }
        return true;
    }
    
    public final int n() {
        return this.j.getAndIncrement();
    }
    
    final zabq x(final ApiKey apiKey) {
        return this.w.get(apiKey);
    }
}
