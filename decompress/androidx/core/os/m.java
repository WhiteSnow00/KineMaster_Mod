// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import android.os.UserManager;
import android.content.Context;

public class m
{
    public static boolean a(final Context context) {
        return a.a(context);
    }
    
    static class a
    {
        static boolean a(final Context context) {
            return ((UserManager)context.getSystemService((Class)UserManager.class)).isUserUnlocked();
        }
    }
}
