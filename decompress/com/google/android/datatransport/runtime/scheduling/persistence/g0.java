// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class g0 implements Migration
{
    public static final g0 a;
    
    static {
        a = new g0();
    }
    
    private g0() {
    }
    
    @Override
    public final void a(final SQLiteDatabase sqLiteDatabase) {
        SchemaManager.d(sqLiteDatabase);
    }
}
