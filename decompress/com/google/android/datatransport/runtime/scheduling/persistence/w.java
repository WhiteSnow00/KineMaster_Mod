// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;

public final class w implements b
{
    public final long a;
    public final TransportContext b;
    
    public w(final long a, final TransportContext b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.r(this.a, this.b, (SQLiteDatabase)o);
    }
}
