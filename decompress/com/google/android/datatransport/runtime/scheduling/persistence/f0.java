// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class f0 implements Migration
{
    public static final f0 a;
    
    static {
        a = new f0();
    }
    
    private f0() {
    }
    
    @Override
    public final void a(final SQLiteDatabase sqLiteDatabase) {
        SchemaManager.c(sqLiteDatabase);
    }
}
