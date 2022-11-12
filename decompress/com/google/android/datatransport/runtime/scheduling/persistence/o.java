// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class o implements b
{
    public final long a;
    
    public o(final long a) {
        this.a = a;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.L(this.a, (SQLiteDatabase)o);
    }
}
