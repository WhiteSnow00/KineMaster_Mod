// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import android.content.Context;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class Uploader_Factory implements Factory<Uploader>
{
    private final Provider<Context> a;
    private final Provider<BackendRegistry> b;
    private final Provider<EventStore> c;
    private final Provider<WorkScheduler> d;
    private final Provider<Executor> e;
    private final Provider<SynchronizationGuard> f;
    private final Provider<Clock> g;
    private final Provider<Clock> h;
    private final Provider<ClientHealthMetricsStore> i;
    
    public Uploader_Factory(final Provider<Context> a, final Provider<BackendRegistry> b, final Provider<EventStore> c, final Provider<WorkScheduler> d, final Provider<Executor> e, final Provider<SynchronizationGuard> f, final Provider<Clock> g, final Provider<Clock> h, final Provider<ClientHealthMetricsStore> i) {
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
    
    public static Uploader_Factory a(final Provider<Context> provider, final Provider<BackendRegistry> provider2, final Provider<EventStore> provider3, final Provider<WorkScheduler> provider4, final Provider<Executor> provider5, final Provider<SynchronizationGuard> provider6, final Provider<Clock> provider7, final Provider<Clock> provider8, final Provider<ClientHealthMetricsStore> provider9) {
        return new Uploader_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }
    
    public static Uploader c(final Context context, final BackendRegistry backendRegistry, final EventStore eventStore, final WorkScheduler workScheduler, final Executor executor, final SynchronizationGuard synchronizationGuard, final Clock clock, final Clock clock2, final ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }
    
    public Uploader b() {
        return c((Context)this.a.get(), (BackendRegistry)this.b.get(), (EventStore)this.c.get(), (WorkScheduler)this.d.get(), (Executor)this.e.get(), (SynchronizationGuard)this.f.get(), (Clock)this.g.get(), (Clock)this.h.get(), (ClientHealthMetricsStore)this.i.get());
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
}
