// 
// Decompiled by Procyon v0.6.0
// 

package t0;

import android.util.Log;
import java.util.Arrays;
import android.database.MatrixCursor;
import android.database.Cursor;

public class b
{
    public static Cursor a(final Cursor cursor) {
        try {
            final MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                final Object[] array = new Object[cursor.getColumnCount()];
                for (int i = 0; i < cursor.getColumnCount(); ++i) {
                    final int type = cursor.getType(i);
                    if (type != 0) {
                        if (type != 1) {
                            if (type != 2) {
                                if (type != 3) {
                                    if (type != 4) {
                                        throw new IllegalStateException();
                                    }
                                    array[i] = cursor.getBlob(i);
                                }
                                else {
                                    array[i] = cursor.getString(i);
                                }
                            }
                            else {
                                array[i] = cursor.getDouble(i);
                            }
                        }
                        else {
                            array[i] = cursor.getLong(i);
                        }
                    }
                    else {
                        array[i] = null;
                    }
                }
                matrixCursor.addRow(array);
            }
            return (Cursor)matrixCursor;
        }
        finally {
            cursor.close();
        }
    }
    
    private static int b(final Cursor cursor, final String s) {
        return -1;
    }
    
    public static int c(final Cursor cursor, final String s) {
        final int columnIndex = cursor.getColumnIndex(s);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("`");
        sb.append(s);
        sb.append("`");
        final int columnIndex2 = cursor.getColumnIndex(sb.toString());
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        return b(cursor, s);
    }
    
    public static int d(final Cursor cursor, final String s) {
        final int c = c(cursor, s);
        if (c >= 0) {
            return c;
        }
        String string;
        try {
            string = Arrays.toString(cursor.getColumnNames());
        }
        catch (final Exception ex) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", (Throwable)ex);
            string = "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("column '");
        sb.append(s);
        sb.append("' does not exist. Available columns: ");
        sb.append(string);
        throw new IllegalArgumentException(sb.toString());
    }
}
