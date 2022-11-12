// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class z implements b
{
    public final SQLiteEventStore a;
    
    public z(final SQLiteEventStore a) {
        this.a = a;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.W(this.a, (SQLiteDatabase)o);
    }
}
