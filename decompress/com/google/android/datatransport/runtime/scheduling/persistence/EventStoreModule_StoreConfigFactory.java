// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class EventStoreModule_StoreConfigFactory implements Factory<c>
{
    public static EventStoreModule_StoreConfigFactory a() {
        return a.a();
    }
    
    public static c c() {
        return Preconditions.c(EventStoreModule.d(), "Cannot return null from a non-@Nullable @Provides method");
    }
    
    public c b() {
        return c();
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
    
    private static final class a
    {
        private static final EventStoreModule_StoreConfigFactory a;
        
        static {
            a = new EventStoreModule_StoreConfigFactory();
        }
        
        static EventStoreModule_StoreConfigFactory a() {
            return EventStoreModule_StoreConfigFactory.a.a;
        }
    }
}
