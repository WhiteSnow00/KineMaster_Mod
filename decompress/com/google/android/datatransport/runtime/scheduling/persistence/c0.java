// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;

public final class c0 implements b
{
    public final SQLiteEventStore a;
    public final TransportContext b;
    
    public c0(final SQLiteEventStore a, final TransportContext b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.k(this.a, this.b, (SQLiteDatabase)o);
    }
}
