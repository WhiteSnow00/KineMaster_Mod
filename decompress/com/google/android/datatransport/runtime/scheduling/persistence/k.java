// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;

public final class k implements b
{
    public static final k a;
    
    static {
        a = new k();
    }
    
    private k() {
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.s((Cursor)o);
    }
}
