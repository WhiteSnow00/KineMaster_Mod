// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.database;

import android.database.sqlite.SQLiteDatabase;

public interface DatabaseProvider
{
    SQLiteDatabase getReadableDatabase();
    
    SQLiteDatabase getWritableDatabase();
}
