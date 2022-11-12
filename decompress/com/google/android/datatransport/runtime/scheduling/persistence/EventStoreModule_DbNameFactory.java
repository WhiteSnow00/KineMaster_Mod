// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class EventStoreModule_DbNameFactory implements Factory<String>
{
    public static EventStoreModule_DbNameFactory a() {
        return a.a();
    }
    
    public static String b() {
        return Preconditions.c(EventStoreModule.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    public String c() {
        return b();
    }
    
    public /* bridge */ Object get() {
        return this.c();
    }
    
    private static final class a
    {
        private static final EventStoreModule_DbNameFactory a;
        
        static {
            a = new EventStoreModule_DbNameFactory();
        }
        
        static EventStoreModule_DbNameFactory a() {
            return EventStoreModule_DbNameFactory.a.a;
        }
    }
}
