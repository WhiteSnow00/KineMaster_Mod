// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.dagger.Module;

@Module
public abstract class SchedulingConfigModule
{
    @Provides
    static SchedulerConfig a(@WallTime final Clock clock) {
        return SchedulerConfig.f(clock);
    }
}
