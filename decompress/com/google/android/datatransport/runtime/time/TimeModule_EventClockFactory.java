// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class TimeModule_EventClockFactory implements Factory<Clock>
{
    public static TimeModule_EventClockFactory a() {
        return a.a();
    }
    
    public static Clock b() {
        return Preconditions.c(TimeModule.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    public Clock c() {
        return b();
    }
    
    public /* bridge */ Object get() {
        return this.c();
    }
    
    private static final class a
    {
        private static final TimeModule_EventClockFactory a;
        
        static {
            a = new TimeModule_EventClockFactory();
        }
        
        static TimeModule_EventClockFactory a() {
            return TimeModule_EventClockFactory.a.a;
        }
    }
}
