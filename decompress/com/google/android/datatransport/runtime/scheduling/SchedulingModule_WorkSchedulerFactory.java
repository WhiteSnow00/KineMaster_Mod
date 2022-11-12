// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import android.content.Context;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler>
{
    private final Provider<Context> a;
    private final Provider<EventStore> b;
    private final Provider<SchedulerConfig> c;
    private final Provider<Clock> d;
    
    public SchedulingModule_WorkSchedulerFactory(final Provider<Context> a, final Provider<EventStore> b, final Provider<SchedulerConfig> c, final Provider<Clock> d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static SchedulingModule_WorkSchedulerFactory a(final Provider<Context> provider, final Provider<EventStore> provider2, final Provider<SchedulerConfig> provider3, final Provider<Clock> provider4) {
        return new SchedulingModule_WorkSchedulerFactory(provider, provider2, provider3, provider4);
    }
    
    public static WorkScheduler c(final Context context, final EventStore eventStore, final SchedulerConfig schedulerConfig, final Clock clock) {
        return Preconditions.c(SchedulingModule.a(context, eventStore, schedulerConfig, clock), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    public WorkScheduler b() {
        return c((Context)this.a.get(), (EventStore)this.b.get(), (SchedulerConfig)this.c.get(), (Clock)this.d.get());
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
}
