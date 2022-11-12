// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;

public final class p implements b
{
    public static final p a;
    
    static {
        a = new p();
    }
    
    private p() {
    }
    
    @Override
    public final Object apply(final Object o) {
        return SQLiteEventStore.m0((Cursor)o);
    }
}
