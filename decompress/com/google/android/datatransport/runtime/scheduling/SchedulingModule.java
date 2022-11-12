// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Module;

@Module
public abstract class SchedulingModule
{
    @Provides
    static WorkScheduler a(final Context context, final EventStore eventStore, final SchedulerConfig schedulerConfig, @Monotonic final Clock clock) {
        return new JobInfoScheduler(context, eventStore, schedulerConfig);
    }
}
