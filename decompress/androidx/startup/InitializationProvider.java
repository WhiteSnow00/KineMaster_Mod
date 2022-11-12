// 
// Decompiled by Procyon v0.6.0
// 

package androidx.startup;

import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.net.Uri;
import android.content.ContentProvider;

public class InitializationProvider extends ContentProvider
{
    public final int delete(final Uri uri, final String s, final String[] array) {
        throw new IllegalStateException("Not allowed.");
    }
    
    public final String getType(final Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }
    
    public final Uri insert(final Uri uri, final ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }
    
    public final boolean onCreate() {
        final Context context = this.getContext();
        if (context != null) {
            if (context.getApplicationContext() != null) {
                a.e(context).a();
            }
            return true;
        }
        throw new StartupException("Context cannot be null");
    }
    
    public final Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        throw new IllegalStateException("Not allowed.");
    }
    
    public final int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        throw new IllegalStateException("Not allowed.");
    }
}
