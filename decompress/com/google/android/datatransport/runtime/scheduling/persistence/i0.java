// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class i0 implements Migration
{
    public static final i0 a;
    
    static {
        a = new i0();
    }
    
    private i0() {
    }
    
    @Override
    public final void a(final SQLiteDatabase sqLiteDatabase) {
        SchemaManager.h(sqLiteDatabase);
    }
}
