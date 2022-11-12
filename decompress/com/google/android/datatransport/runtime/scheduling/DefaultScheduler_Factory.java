// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class DefaultScheduler_Factory implements Factory<DefaultScheduler>
{
    private final Provider<Executor> a;
    private final Provider<BackendRegistry> b;
    private final Provider<WorkScheduler> c;
    private final Provider<EventStore> d;
    private final Provider<SynchronizationGuard> e;
    
    public DefaultScheduler_Factory(final Provider<Executor> a, final Provider<BackendRegistry> b, final Provider<WorkScheduler> c, final Provider<EventStore> d, final Provider<SynchronizationGuard> e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public static DefaultScheduler_Factory a(final Provider<Executor> provider, final Provider<BackendRegistry> provider2, final Provider<WorkScheduler> provider3, final Provider<EventStore> provider4, final Provider<SynchronizationGuard> provider5) {
        return new DefaultScheduler_Factory(provider, provider2, provider3, provider4, provider5);
    }
    
    public static DefaultScheduler c(final Executor executor, final BackendRegistry backendRegistry, final WorkScheduler workScheduler, final EventStore eventStore, final SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }
    
    public DefaultScheduler b() {
        return c((Executor)this.a.get(), (BackendRegistry)this.b.get(), (WorkScheduler)this.c.get(), (EventStore)this.d.get(), (SynchronizationGuard)this.e.get());
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
}
