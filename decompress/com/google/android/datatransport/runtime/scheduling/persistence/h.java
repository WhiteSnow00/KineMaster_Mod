// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import java.util.Map;

public final class h implements b
{
    public final SQLiteEventStore a;
    public final Map b;
    public final ClientMetrics.Builder c;
    
    public h(final SQLiteEventStore a, final Map b, final ClientMetrics.Builder c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.f0(this.a, this.b, this.c, (Cursor)o);
    }
}
