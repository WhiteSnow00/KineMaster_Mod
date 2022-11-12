// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.database;

import android.database.Cursor;
import android.database.SQLException;
import com.google.android.exoplayer2.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class StandaloneDatabaseProvider extends SQLiteOpenHelper implements DatabaseProvider
{
    public StandaloneDatabaseProvider(final Context context) {
        super(context.getApplicationContext(), "exoplayer_internal.db", (SQLiteDatabase$CursorFactory)null, 1);
    }
    
    private static void a(final SQLiteDatabase sqLiteDatabase) {
        final Cursor query = sqLiteDatabase.query("sqlite_master", new String[] { "type", "name" }, (String)null, (String[])null, (String)null, (String)null, (String)null);
        try {
            while (query.moveToNext()) {
                final String string = query.getString(0);
                final String string2 = query.getString(1);
                if (!"sqlite_sequence".equals(string2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("DROP ");
                    sb.append(string);
                    sb.append(" IF EXISTS ");
                    sb.append(string2);
                    final String string3 = sb.toString();
                    try {
                        sqLiteDatabase.execSQL(string3);
                    }
                    catch (final SQLException ex) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Error executing ");
                        sb2.append(string3);
                        Log.d("SADatabaseProvider", sb2.toString(), (Throwable)ex);
                    }
                }
            }
            query.close();
        }
        finally {
            if (query != null) {
                try {
                    query.close();
                }
                finally {
                    final Throwable t;
                    ((Throwable)sqLiteDatabase).addSuppressed(t);
                }
            }
        }
    }
    
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
    }
    
    public void onDowngrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
        a(sqLiteDatabase);
    }
    
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
    }
}
