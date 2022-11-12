// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class SchedulingConfigModule_ConfigFactory implements Factory<SchedulerConfig>
{
    private final Provider<Clock> a;
    
    public SchedulingConfigModule_ConfigFactory(final Provider<Clock> a) {
        this.a = a;
    }
    
    public static SchedulerConfig a(final Clock clock) {
        return Preconditions.c(SchedulingConfigModule.a(clock), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    public static SchedulingConfigModule_ConfigFactory b(final Provider<Clock> provider) {
        return new SchedulingConfigModule_ConfigFactory(provider);
    }
    
    public SchedulerConfig c() {
        return a((Clock)this.a.get());
    }
    
    public /* bridge */ Object get() {
        return this.c();
    }
}
