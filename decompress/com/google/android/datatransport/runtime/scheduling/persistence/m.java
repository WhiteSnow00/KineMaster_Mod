// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;

public final class m implements b
{
    public static final m a;
    
    static {
        a = new m();
    }
    
    private m() {
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.M((Cursor)o);
    }
}
