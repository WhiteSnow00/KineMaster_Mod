// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class DefaultDatabaseProvider implements DatabaseProvider
{
    private final SQLiteOpenHelper a;
    
    @Override
    public SQLiteDatabase getReadableDatabase() {
        return this.a.getReadableDatabase();
    }
    
    @Override
    public SQLiteDatabase getWritableDatabase() {
        return this.a.getWritableDatabase();
    }
}
