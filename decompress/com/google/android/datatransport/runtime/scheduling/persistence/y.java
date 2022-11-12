// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;

public final class y implements b
{
    public final SQLiteEventStore a;
    
    public y(final SQLiteEventStore a) {
        this.a = a;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.g0(this.a, (Cursor)o);
    }
}
