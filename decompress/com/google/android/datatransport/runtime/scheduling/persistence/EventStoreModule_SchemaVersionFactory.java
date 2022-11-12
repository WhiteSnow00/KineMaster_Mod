// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class EventStoreModule_SchemaVersionFactory implements Factory<Integer>
{
    public static EventStoreModule_SchemaVersionFactory a() {
        return a.a();
    }
    
    public static int c() {
        return EventStoreModule.c();
    }
    
    public Integer b() {
        return c();
    }
    
    public /* bridge */ Object get() {
        return this.b();
    }
    
    private static final class a
    {
        private static final EventStoreModule_SchemaVersionFactory a;
        
        static {
            a = new EventStoreModule_SchemaVersionFactory();
        }
        
        static EventStoreModule_SchemaVersionFactory a() {
            return EventStoreModule_SchemaVersionFactory.a.a;
        }
    }
}
