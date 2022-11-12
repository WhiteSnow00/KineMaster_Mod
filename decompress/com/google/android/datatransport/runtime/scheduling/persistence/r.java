// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class r implements b
{
    public static final r a;
    
    static {
        a = new r();
    }
    
    private r() {
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.l0((SQLiteDatabase)o);
    }
}
