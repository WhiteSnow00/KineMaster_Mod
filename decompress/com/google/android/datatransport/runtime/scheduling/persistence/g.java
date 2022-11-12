// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.List;

public final class g implements b
{
    public final SQLiteEventStore a;
    public final List b;
    public final TransportContext c;
    
    public g(final SQLiteEventStore a, final List b, final TransportContext c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.V(this.a, this.b, this.c, (Cursor)o);
    }
}
