// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import java.util.Map;

public final class j implements b
{
    public final Map a;
    
    public j(final Map a) {
        this.a = a;
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.e0(this.a, (Cursor)o);
    }
}
