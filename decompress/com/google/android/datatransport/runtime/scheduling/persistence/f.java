// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import java.util.Map;

public final class f implements b
{
    public final SQLiteEventStore a;
    public final String b;
    public final Map c;
    public final ClientMetrics.Builder d;
    
    public f(final SQLiteEventStore a, final String b, final Map c, final ClientMetrics.Builder d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.O(this.a, this.b, this.c, this.d, (SQLiteDatabase)o);
    }
}
