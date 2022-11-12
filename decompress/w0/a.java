// 
// Decompiled by Procyon v0.6.0
// 

package w0;

import android.util.Pair;
import java.util.List;
import v0.b;
import android.os.CancellationSignal;
import java.io.IOException;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import v0.i;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.database.Cursor;
import v0.j;
import v0.k;
import android.database.sqlite.SQLiteDatabase;
import v0.g;

class a implements g
{
    private static final String[] b;
    private static final String[] c;
    private final SQLiteDatabase a;
    
    static {
        b = new String[] { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
        c = new String[0];
    }
    
    a(final SQLiteDatabase a) {
        this.a = a;
    }
    
    @Override
    public k H0(final String s) {
        return new e(this.a.compileStatement(s));
    }
    
    @Override
    public Cursor J(final j j) {
        return this.a.rawQueryWithFactory((SQLiteDatabase$CursorFactory)new SQLiteDatabase$CursorFactory(this, j) {
            final j a;
            final a b;
            
            public Cursor newCursor(final SQLiteDatabase sqLiteDatabase, final SQLiteCursorDriver sqLiteCursorDriver, final String s, final SQLiteQuery sqLiteQuery) {
                this.a.d(new d((SQLiteProgram)sqLiteQuery));
                return (Cursor)new SQLiteCursor(sqLiteCursorDriver, s, sqLiteQuery);
            }
        }, j.c(), w0.a.c, (String)null);
    }
    
    @Override
    public void T(final String s, final Object[] array) throws SQLException {
        this.a.execSQL(s, array);
    }
    
    @Override
    public void U() {
        this.a.beginTransactionNonExclusive();
    }
    
    @Override
    public Cursor Z0(final String s) {
        return this.J(new v0.a(s));
    }
    
    boolean a(final SQLiteDatabase sqLiteDatabase) {
        return this.a == sqLiteDatabase;
    }
    
    @Override
    public void close() throws IOException {
        this.a.close();
    }
    
    @Override
    public String getPath() {
        return this.a.getPath();
    }
    
    @Override
    public boolean isOpen() {
        return this.a.isOpen();
    }
    
    @Override
    public void m() {
        this.a.beginTransaction();
    }
    
    @Override
    public void p() {
        this.a.setTransactionSuccessful();
    }
    
    @Override
    public void q() {
        this.a.endTransaction();
    }
    
    @Override
    public boolean q1() {
        return this.a.inTransaction();
    }
    
    @Override
    public Cursor u0(final j j, final CancellationSignal cancellationSignal) {
        return v0.b.e(this.a, j.c(), w0.a.c, null, cancellationSignal, (SQLiteDatabase$CursorFactory)new SQLiteDatabase$CursorFactory(this, j) {
            final j a;
            final a b;
            
            public Cursor newCursor(final SQLiteDatabase sqLiteDatabase, final SQLiteCursorDriver sqLiteCursorDriver, final String s, final SQLiteQuery sqLiteQuery) {
                this.a.d(new d((SQLiteProgram)sqLiteQuery));
                return (Cursor)new SQLiteCursor(sqLiteCursorDriver, s, sqLiteQuery);
            }
        });
    }
    
    @Override
    public List<Pair<String, String>> x() {
        return this.a.getAttachedDbs();
    }
    
    @Override
    public void z(final String s) throws SQLException {
        this.a.execSQL(s);
    }
    
    @Override
    public boolean z1() {
        return v0.b.d(this.a);
    }
}
