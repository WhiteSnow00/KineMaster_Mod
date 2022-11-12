// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Objects;
import com.google.android.datatransport.Priority;
import java.util.Map;
import com.google.android.datatransport.runtime.time.Clock;

final class a extends SchedulerConfig
{
    private final Clock a;
    private final Map<Priority, ConfigValue> b;
    
    a(final Clock a, final Map<Priority, ConfigValue> b) {
        Objects.requireNonNull(a, "Null clock");
        this.a = a;
        Objects.requireNonNull(b, "Null values");
        this.b = b;
    }
    
    @Override
    Clock e() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof SchedulerConfig) {
            final SchedulerConfig schedulerConfig = (SchedulerConfig)o;
            if (!this.a.equals(schedulerConfig.e()) || !this.b.equals(schedulerConfig.h())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    Map<Priority, ConfigValue> h() {
        return this.b;
    }
    
    @Override
    public int hashCode() {
        return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SchedulerConfig{clock=");
        sb.append(this.a);
        sb.append(", values=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
}
