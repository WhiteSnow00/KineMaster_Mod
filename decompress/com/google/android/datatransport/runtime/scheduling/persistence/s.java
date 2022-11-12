// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

public final class s implements b
{
    public static final s a;
    
    static {
        a = new s();
    }
    
    private s() {
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.h((Throwable)o);
    }
}
