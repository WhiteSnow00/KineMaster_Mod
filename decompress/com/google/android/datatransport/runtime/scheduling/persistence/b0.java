// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.EventInternal;

public final class b0 implements b
{
    public final SQLiteEventStore a;
    public final EventInternal b;
    public final TransportContext c;
    
    public b0(final SQLiteEventStore a, final EventInternal b, final TransportContext c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.c0(this.a, this.b, this.c, (SQLiteDatabase)o);
    }
}
