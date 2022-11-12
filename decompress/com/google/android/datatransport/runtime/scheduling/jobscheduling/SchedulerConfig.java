// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.auto.value.AutoValue$Builder;
import java.util.Objects;
import java.util.HashMap;
import android.app.job.JobInfo$Builder;
import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import com.google.android.datatransport.Priority;
import java.util.Map;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SchedulerConfig
{
    private long a(int n, final long n2) {
        --n;
        long n3;
        if (n2 > 1L) {
            n3 = n2;
        }
        else {
            n3 = 2L;
        }
        return (long)(Math.pow(3.0, n) * n2 * Math.max(1.0, Math.log(10000.0) / Math.log((double)(n3 * n))));
    }
    
    public static Builder b() {
        return new Builder();
    }
    
    static SchedulerConfig d(final Clock clock, final Map<Priority, ConfigValue> map) {
        return new a(clock, map);
    }
    
    public static SchedulerConfig f(final Clock clock) {
        return b().a(Priority.DEFAULT, ConfigValue.a().b(30000L).d(86400000L).a()).a(Priority.HIGHEST, ConfigValue.a().b(1000L).d(86400000L).a()).a(Priority.VERY_LOW, ConfigValue.a().b(86400000L).d(86400000L).c(i(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE)).a()).c(clock).b();
    }
    
    private static <T> Set<T> i(final T... array) {
        return Collections.unmodifiableSet((Set<? extends T>)new HashSet<T>((Collection<? extends T>)Arrays.asList(array)));
    }
    
    private void j(final JobInfo$Builder jobInfo$Builder, final Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            jobInfo$Builder.setRequiredNetworkType(2);
        }
        else {
            jobInfo$Builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            jobInfo$Builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            jobInfo$Builder.setRequiresDeviceIdle(true);
        }
    }
    
    public JobInfo$Builder c(final JobInfo$Builder jobInfo$Builder, final Priority priority, final long n, final int n2) {
        jobInfo$Builder.setMinimumLatency(this.g(priority, n, n2));
        this.j(jobInfo$Builder, this.h().get(priority).c());
        return jobInfo$Builder;
    }
    
    abstract Clock e();
    
    public long g(final Priority priority, final long n, final int n2) {
        final long a = this.e().a();
        final ConfigValue configValue = this.h().get(priority);
        return Math.min(Math.max(this.a(n2, configValue.b()), n - a), configValue.d());
    }
    
    abstract Map<Priority, ConfigValue> h();
    
    public static class Builder
    {
        private Clock a;
        private Map<Priority, ConfigValue> b;
        
        public Builder() {
            this.b = new HashMap<Priority, ConfigValue>();
        }
        
        public Builder a(final Priority priority, final ConfigValue configValue) {
            this.b.put(priority, configValue);
            return this;
        }
        
        public SchedulerConfig b() {
            Objects.requireNonNull(this.a, "missing required property: clock");
            if (this.b.keySet().size() >= Priority.values().length) {
                final Map<Priority, ConfigValue> b = this.b;
                this.b = new HashMap<Priority, ConfigValue>();
                return SchedulerConfig.d(this.a, b);
            }
            throw new IllegalStateException("Not all priorities have been configured");
        }
        
        public Builder c(final Clock a) {
            this.a = a;
            return this;
        }
    }
    
    @AutoValue
    public abstract static class ConfigValue
    {
        public static Builder a() {
            return new b.b().c(Collections.emptySet());
        }
        
        abstract long b();
        
        abstract Set<Flag> c();
        
        abstract long d();
        
        @AutoValue$Builder
        public abstract static class Builder
        {
            public abstract ConfigValue a();
            
            public abstract Builder b(final long p0);
            
            public abstract Builder c(final Set<Flag> p0);
            
            public abstract Builder d(final long p0);
        }
    }
    
    public enum Flag
    {
        private static final Flag[] $VALUES;
        
        DEVICE_CHARGING, 
        DEVICE_IDLE, 
        NETWORK_UNMETERED;
    }
}
