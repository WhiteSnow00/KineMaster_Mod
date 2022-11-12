// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import i3.d;
import i3.h;
import i3.k;
import java.util.HashMap;
import i3.c;
import i3.i;
import i3.j;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.ArrayList;
import com.google.android.datatransport.runtime.logging.Logging;
import i3.f;
import i3.e;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import com.google.android.datatransport.runtime.EncodedPayload;
import i3.l;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import i3.g;
import i3.m;
import java.util.Objects;
import java.util.Iterator;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import java.util.Map;
import com.google.android.datatransport.runtime.TransportContext;
import javax.inject.Inject;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import android.content.Context;

public class Uploader
{
    private final Context a;
    private final BackendRegistry b;
    private final EventStore c;
    private final WorkScheduler d;
    private final Executor e;
    private final SynchronizationGuard f;
    private final Clock g;
    private final Clock h;
    private final ClientHealthMetricsStore i;
    
    @Inject
    public Uploader(final Context a, final BackendRegistry b, final EventStore c, final WorkScheduler d, final Executor e, final SynchronizationGuard f, @WallTime final Clock g, @Monotonic final Clock h, final ClientHealthMetricsStore i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    public static void a(final Uploader uploader, final TransportContext transportContext, final int n, final Runnable runnable) {
        uploader.t(transportContext, n, runnable);
    }
    
    public static Boolean b(final Uploader uploader, final TransportContext transportContext) {
        return uploader.l(transportContext);
    }
    
    public static Object c(final Uploader uploader, final Map map) {
        return uploader.q(map);
    }
    
    public static Iterable d(final Uploader uploader, final TransportContext transportContext) {
        return uploader.m(transportContext);
    }
    
    public static Object e(final Uploader uploader, final Iterable iterable, final TransportContext transportContext, final long n) {
        return uploader.n(iterable, transportContext, n);
    }
    
    public static Object f(final Uploader uploader, final TransportContext transportContext, final long n) {
        return uploader.r(transportContext, n);
    }
    
    public static Object g(final Uploader uploader, final Iterable iterable) {
        return uploader.o(iterable);
    }
    
    public static Object h(final Uploader uploader, final TransportContext transportContext, final int n) {
        return uploader.s(transportContext, n);
    }
    
    public static Object i(final Uploader uploader) {
        return uploader.p();
    }
    
    private Boolean l(final TransportContext transportContext) {
        return this.c.q0(transportContext);
    }
    
    private Iterable m(final TransportContext transportContext) {
        return this.c.I0(transportContext);
    }
    
    private Object n(final Iterable iterable, final TransportContext transportContext, final long n) {
        this.c.s0(iterable);
        this.c.H(transportContext, this.g.a() + n);
        return null;
    }
    
    private Object o(final Iterable iterable) {
        this.c.w(iterable);
        return null;
    }
    
    private Object p() {
        this.i.a();
        return null;
    }
    
    private Object q(final Map map) {
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            this.i.e((int)entry.getValue(), LogEventDropped.Reason.INVALID_PAYLOD, entry.getKey());
        }
        return null;
    }
    
    private Object r(final TransportContext transportContext, final long n) {
        this.c.H(transportContext, this.g.a() + n);
        return null;
    }
    
    private Object s(final TransportContext transportContext, final int n) {
        this.d.a(transportContext, n + 1);
        return null;
    }
    
    private void t(final TransportContext transportContext, final int n, final Runnable runnable) {
        try {
            try {
                final SynchronizationGuard f = this.f;
                final EventStore c = this.c;
                Objects.requireNonNull(c);
                f.c((SynchronizationGuard.CriticalSection<Object>)new m(c));
                if (!this.k()) {
                    this.f.c((SynchronizationGuard.CriticalSection<Object>)new g(this, transportContext, n));
                }
                this.u(transportContext, n);
            }
            finally {}
        }
        catch (final SynchronizationException ex) {
            this.d.a(transportContext, n + 1);
        }
        runnable.run();
        return;
        runnable.run();
    }
    
    public EventInternal j(final TransportBackend transportBackend) {
        final SynchronizationGuard f = this.f;
        final ClientHealthMetricsStore i = this.i;
        Objects.requireNonNull(i);
        return transportBackend.a(EventInternal.a().i(this.g.a()).k(this.h.a()).j("GDT_CLIENT_METRICS").h(new EncodedPayload(Encoding.b("proto"), f.c((SynchronizationGuard.CriticalSection<ClientMetrics>)new l(i)).f())).d());
    }
    
    boolean k() {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    
    BackendResponse u(final TransportContext transportContext, final int n) {
        final TransportBackend a = this.b.a(transportContext.b());
        long max = 0L;
        BackendResponse e = BackendResponse.e(0L);
        while (this.f.c((SynchronizationGuard.CriticalSection<Boolean>)new e(this, transportContext))) {
            final Iterable iterable = this.f.c((SynchronizationGuard.CriticalSection<Iterable>)new f(this, transportContext));
            if (!iterable.iterator().hasNext()) {
                return e;
            }
            BackendResponse backendResponse;
            if (a == null) {
                Logging.a("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                backendResponse = BackendResponse.a();
            }
            else {
                final ArrayList list = new ArrayList();
                final Iterator iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    list.add(((PersistedEvent)iterator.next()).b());
                }
                if (transportContext.e()) {
                    list.add(this.j(a));
                }
                backendResponse = a.b(BackendRequest.a().b(list).c(transportContext.c()).a());
            }
            if (backendResponse.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                this.f.c((SynchronizationGuard.CriticalSection<Object>)new j(this, (Iterable)iterable, transportContext, max));
                this.d.b(transportContext, n + 1, true);
                return backendResponse;
            }
            this.f.c((SynchronizationGuard.CriticalSection<Object>)new i(this, (Iterable)iterable));
            if (backendResponse.c() == BackendResponse.Status.OK) {
                final long n2 = max = Math.max(max, backendResponse.b());
                e = backendResponse;
                if (!transportContext.e()) {
                    continue;
                }
                this.f.c((SynchronizationGuard.CriticalSection<Object>)new c(this));
                max = n2;
                e = backendResponse;
            }
            else {
                e = backendResponse;
                if (backendResponse.c() != BackendResponse.Status.INVALID_PAYLOAD) {
                    continue;
                }
                final HashMap hashMap = new HashMap();
                final Iterator iterator2 = iterable.iterator();
                while (iterator2.hasNext()) {
                    final String j = ((PersistedEvent)iterator2.next()).b().j();
                    if (!hashMap.containsKey(j)) {
                        hashMap.put(j, 1);
                    }
                    else {
                        hashMap.put(j, (int)hashMap.get(j) + 1);
                    }
                }
                this.f.c((SynchronizationGuard.CriticalSection<Object>)new k(this, (Map)hashMap));
                e = backendResponse;
            }
        }
        this.f.c((SynchronizationGuard.CriticalSection<Object>)new h(this, transportContext, max));
        return e;
    }
    
    public void v(final TransportContext transportContext, final int n, final Runnable runnable) {
        this.e.execute((Runnable)new d(this, transportContext, n, runnable));
    }
}
