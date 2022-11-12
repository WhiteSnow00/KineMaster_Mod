// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class WorkInitializer_Factory implements Factory<WorkInitializer>
{
    private final Provider<Executor> a;
    private final Provider<EventStore> b;
    private final Provider<WorkScheduler> c;
    private final Provider<SynchronizationGuard> d;
    
    public WorkInitializer_Factory(final Provider<Executor> a, final Provider<EventStore> b, final Provider<WorkScheduler> c, final Provider<SynchronizationGuard> d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static WorkInitializer_Factory a(final Provider<Executor> provider, final Provider<EventStore> provider2, final Provider<WorkScheduler> provider3, final Provider<SynchronizationGuard> provider4) {
        return new WorkInitializer_Factory(provider, provider2, provider3, provider4);
    }
    
    public static WorkInitializer c(final Executor executor, final EventStore eventStore, final WorkScheduler workScheduler, final SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }
    
    public WorkInitializer b() {
        return c((Executor)this.a.get(), (EventStore)this.b.get(), (WorkScheduler)this.c.get(), (SynchronizationGuard)this.d.get());
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
}
