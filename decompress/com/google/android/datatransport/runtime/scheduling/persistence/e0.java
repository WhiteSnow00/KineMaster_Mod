// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class e0 implements Migration
{
    public static final e0 a;
    
    static {
        a = new e0();
    }
    
    private e0() {
    }
    
    @Override
    public final void a(final SQLiteDatabase sqLiteDatabase) {
        SchemaManager.a(sqLiteDatabase);
    }
}
