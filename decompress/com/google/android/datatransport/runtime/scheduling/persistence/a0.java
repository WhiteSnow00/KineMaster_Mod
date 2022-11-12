// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class a0 implements b
{
    public final SQLiteEventStore a;
    public final long b;
    
    public a0(final SQLiteEventStore a, final long b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.i0(this.a, this.b, (SQLiteDatabase)o);
    }
}
