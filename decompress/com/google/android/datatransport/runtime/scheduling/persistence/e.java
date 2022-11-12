// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class e implements b
{
    public final SQLiteEventStore a;
    public final String b;
    public final String c;
    
    public e(final SQLiteEventStore a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.a0(this.a, this.b, this.c, (SQLiteDatabase)o);
    }
}
