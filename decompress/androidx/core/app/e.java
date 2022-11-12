// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.app.AppOpsManager;
import android.os.Binder;
import android.os.Build$VERSION;
import android.content.Context;

public final class e
{
    public static int a(final Context context, final int n, final String s, final String s2) {
        if (Build$VERSION.SDK_INT < 29) {
            return b(context, s, s2);
        }
        final AppOpsManager c = b.c(context);
        final int a = b.a(c, s, Binder.getCallingUid(), s2);
        if (a != 0) {
            return a;
        }
        return b.a(c, s, n, b.b(context));
    }
    
    public static int b(final Context context, final String s, final String s2) {
        return a.c(a.a(context, AppOpsManager.class), s, s2);
    }
    
    public static String c(final String s) {
        return a.d(s);
    }
    
    static class a
    {
        static <T> T a(final Context context, final Class<T> clazz) {
            return (T)context.getSystemService((Class)clazz);
        }
        
        static int b(final AppOpsManager appOpsManager, final String s, final String s2) {
            return appOpsManager.noteProxyOp(s, s2);
        }
        
        static int c(final AppOpsManager appOpsManager, final String s, final String s2) {
            return appOpsManager.noteProxyOpNoThrow(s, s2);
        }
        
        static String d(final String s) {
            return AppOpsManager.permissionToOp(s);
        }
    }
    
    static class b
    {
        static int a(final AppOpsManager appOpsManager, final String s, final int n, final String s2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(s, n, s2);
        }
        
        static String b(final Context context) {
            return context.getOpPackageName();
        }
        
        static AppOpsManager c(final Context context) {
            return (AppOpsManager)context.getSystemService((Class)AppOpsManager.class);
        }
    }
}
