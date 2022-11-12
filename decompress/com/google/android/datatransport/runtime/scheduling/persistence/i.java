// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;

public final class i implements b
{
    public final String a;
    public final LogEventDropped.Reason b;
    public final long c;
    
    public i(final String a, final LogEventDropped.Reason b, final long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.u(this.a, this.b, this.c, (SQLiteDatabase)o);
    }
}
