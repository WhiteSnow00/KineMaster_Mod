// 
// Decompiled by Procyon v0.6.0
// 

package v0;

import android.app.ActivityManager;
import android.net.Uri;
import android.database.Cursor;

public final class c
{
    public static Uri a(final Cursor cursor) {
        return cursor.getNotificationUri();
    }
    
    public static boolean b(final ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
