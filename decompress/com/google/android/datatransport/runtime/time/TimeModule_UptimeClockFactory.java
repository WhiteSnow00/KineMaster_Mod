// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class TimeModule_UptimeClockFactory implements Factory<Clock>
{
    public static TimeModule_UptimeClockFactory a() {
        return a.a();
    }
    
    public static Clock c() {
        return Preconditions.c(TimeModule.b(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    public Clock b() {
        return c();
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
    
    private static final class a
    {
        private static final TimeModule_UptimeClockFactory a;
        
        static {
            a = new TimeModule_UptimeClockFactory();
        }
        
        static TimeModule_UptimeClockFactory a() {
            return TimeModule_UptimeClockFactory.a.a;
        }
    }
}
