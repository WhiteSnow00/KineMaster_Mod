// 
// Decompiled by Procyon v0.6.0
// 

package v0;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.List;
import android.database.Cursor;

public final class f
{
    public static List<Uri> a(final Cursor cursor) {
        return cursor.getNotificationUris();
    }
    
    public static void b(final Cursor cursor, final ContentResolver contentResolver, final List<Uri> list) {
        cursor.setNotificationUris(contentResolver, (List)list);
    }
}
