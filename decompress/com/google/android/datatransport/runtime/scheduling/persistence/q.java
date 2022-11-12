// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;

public final class q implements b
{
    public static final q a;
    
    static {
        a = new q();
    }
    
    private q() {
    }
    
    @Override
    public final Object apply(final Object o) {
        return ((Cursor)o).moveToNext();
    }
}
