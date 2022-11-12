// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

public final class t implements b
{
    public static final t a;
    
    static {
        a = new t();
    }
    
    private t() {
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.i((Throwable)o);
    }
}
