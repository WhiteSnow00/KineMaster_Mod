// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;

public final class h0 implements Migration
{
    public static final h0 a;
    
    static {
        a = new h0();
    }
    
    private h0() {
    }
    
    @Override
    public final void a(final SQLiteDatabase sqLiteDatabase) {
        SchemaManager.e(sqLiteDatabase);
    }
}
