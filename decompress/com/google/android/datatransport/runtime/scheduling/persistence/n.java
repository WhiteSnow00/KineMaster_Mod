// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;

public final class n implements b
{
    public static final n a;
    
    static {
        a = new n();
    }
    
    private n() {
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.Z((Cursor)o);
    }
}
