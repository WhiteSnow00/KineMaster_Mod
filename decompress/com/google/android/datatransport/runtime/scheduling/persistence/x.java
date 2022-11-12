// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;

public final class x implements b
{
    public final SQLiteEventStore a;
    
    public x(final SQLiteEventStore a) {
        this.a = a;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.E(this.a, (Cursor)o);
    }
}
