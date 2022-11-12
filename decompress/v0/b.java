// 
// Decompiled by Procyon v0.6.0
// 

package v0;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import android.os.CancellationSignal;

public final class b
{
    public static void a(final CancellationSignal cancellationSignal) {
        cancellationSignal.cancel();
    }
    
    public static CancellationSignal b() {
        return new CancellationSignal();
    }
    
    public static boolean c(final File file) {
        return SQLiteDatabase.deleteDatabase(file);
    }
    
    public static boolean d(final SQLiteDatabase sqLiteDatabase) {
        return sqLiteDatabase.isWriteAheadLoggingEnabled();
    }
    
    public static Cursor e(final SQLiteDatabase sqLiteDatabase, final String s, final String[] array, final String s2, final CancellationSignal cancellationSignal, final SQLiteDatabase$CursorFactory sqLiteDatabase$CursorFactory) {
        return sqLiteDatabase.rawQueryWithFactory(sqLiteDatabase$CursorFactory, s, array, s2, cancellationSignal);
    }
    
    public static void f(final SQLiteOpenHelper sqLiteOpenHelper, final boolean writeAheadLoggingEnabled) {
        sqLiteOpenHelper.setWriteAheadLoggingEnabled(writeAheadLoggingEnabled);
    }
}
