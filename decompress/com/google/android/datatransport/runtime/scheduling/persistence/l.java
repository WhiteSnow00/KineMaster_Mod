// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;

public final class l implements b
{
    public static final l a;
    
    static {
        a = new l();
    }
    
    private l() {
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.t((Cursor)o);
    }
}
