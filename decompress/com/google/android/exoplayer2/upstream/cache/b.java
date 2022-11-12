// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import java.util.Iterator;
import java.util.Set;
import com.google.android.exoplayer2.database.VersionTable;
import android.database.SQLException;
import com.google.android.exoplayer2.database.DatabaseIOException;
import java.util.HashMap;
import java.util.Map;
import com.google.android.exoplayer2.util.Assertions;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseProvider;

final class b
{
    private static final String[] c;
    private final DatabaseProvider a;
    private String b;
    
    static {
        c = new String[] { "name", "length", "last_touch_timestamp" };
    }
    
    public b(final DatabaseProvider a) {
        this.a = a;
    }
    
    private static void a(final SQLiteDatabase sqLiteDatabase, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE IF EXISTS ");
        sb.append(s);
        sqLiteDatabase.execSQL(sb.toString());
    }
    
    private Cursor c() {
        Assertions.e(this.b);
        return this.a.getReadableDatabase().query(this.b, com.google.android.exoplayer2.upstream.cache.b.c, (String)null, (String[])null, (String)null, (String)null, (String)null);
    }
    
    private static String d(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("ExoPlayerCacheFileMetadata");
        sb.append(s);
        return sb.toString();
    }
    
    public Map<String, a> b() throws DatabaseIOException {
        try {
            final Cursor c = this.c();
            try {
                final HashMap hashMap = new HashMap(c.getCount());
                while (c.moveToNext()) {
                    hashMap.put((Object)Assertions.e(c.getString(0)), (Object)new a(c.getLong(1), c.getLong(2)));
                }
                c.close();
                return (Map<String, a>)hashMap;
            }
            finally {
                if (c != null) {
                    try {
                        c.close();
                    }
                    finally {
                        final Throwable t;
                        final Throwable t2;
                        t.addSuppressed(t2);
                    }
                }
            }
        }
        catch (final SQLException ex) {
            throw new DatabaseIOException(ex);
        }
    }
    
    public void e(final long n) throws DatabaseIOException {
        try {
            final String hexString = Long.toHexString(n);
            this.b = d(hexString);
            if (VersionTable.b(this.a.getReadableDatabase(), 2, hexString) != 1) {
                final SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    VersionTable.d(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.b);
                    final StringBuilder sb = new StringBuilder();
                    sb.append("CREATE TABLE ");
                    sb.append(this.b);
                    sb.append(" ");
                    sb.append("(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.execSQL(sb.toString());
                    writableDatabase.setTransactionSuccessful();
                }
                finally {
                    writableDatabase.endTransaction();
                }
            }
        }
        catch (final SQLException ex) {
            throw new DatabaseIOException(ex);
        }
    }
    
    public void f(final String s) throws DatabaseIOException {
        Assertions.e(this.b);
        try {
            this.a.getWritableDatabase().delete(this.b, "name = ?", new String[] { s });
        }
        catch (final SQLException ex) {
            throw new DatabaseIOException(ex);
        }
    }
    
    public void g(final Set<String> set) throws DatabaseIOException {
        Assertions.e(this.b);
        try {
            final SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                final Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    writableDatabase.delete(this.b, "name = ?", new String[] { iterator.next() });
                }
                writableDatabase.setTransactionSuccessful();
            }
            finally {
                writableDatabase.endTransaction();
            }
        }
        catch (final SQLException ex) {
            throw new DatabaseIOException(ex);
        }
    }
    
    public void h(final String s, final long n, final long n2) throws DatabaseIOException {
        Assertions.e(this.b);
        try {
            final SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            final ContentValues contentValues = new ContentValues();
            contentValues.put("name", s);
            contentValues.put("length", Long.valueOf(n));
            contentValues.put("last_touch_timestamp", Long.valueOf(n2));
            writableDatabase.replaceOrThrow(this.b, (String)null, contentValues);
        }
        catch (final SQLException ex) {
            throw new DatabaseIOException(ex);
        }
    }
}
