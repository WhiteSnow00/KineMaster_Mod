// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content;

import android.content.ComponentName;
import android.os.Bundle;
import android.content.Intent;
import androidx.core.os.g;
import android.os.Handler;
import java.util.concurrent.Executor;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.f;
import android.content.res.ColorStateList;
import android.os.Build$VERSION;
import android.util.Log;
import java.io.File;
import android.os.Process;
import androidx.core.util.c;
import android.content.Context;
import android.util.TypedValue;

public class a
{
    private static final String TAG = "ContextCompat";
    private static final Object sLock;
    private static final Object sSync;
    private static TypedValue sTempValue;
    
    static {
        sLock = new Object();
        sSync = new Object();
    }
    
    protected a() {
    }
    
    public static int checkSelfPermission(final Context context, final String s) {
        androidx.core.util.c.d(s, "permission must be non-null");
        return context.checkPermission(s, Process.myPid(), Process.myUid());
    }
    
    public static Context createDeviceProtectedStorageContext(final Context context) {
        return e.a(context);
    }
    
    private static File createFilesDir(final File file) {
        synchronized (a.sSync) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to create files subdir ");
                sb.append(file.getPath());
                Log.w("ContextCompat", sb.toString());
            }
            return file;
        }
    }
    
    public static String getAttributionTag(final Context context) {
        if (Build$VERSION.SDK_INT >= 30) {
            return h.a(context);
        }
        return null;
    }
    
    public static File getCodeCacheDir(final Context context) {
        return c.a(context);
    }
    
    public static int getColor(final Context context, final int n) {
        return d.a(context, n);
    }
    
    public static ColorStateList getColorStateList(final Context context, final int n) {
        return androidx.core.content.res.f.e(context.getResources(), n, context.getTheme());
    }
    
    public static File getDataDir(final Context context) {
        return e.b(context);
    }
    
    public static Drawable getDrawable(final Context context, final int n) {
        return c.b(context, n);
    }
    
    public static File[] getExternalCacheDirs(final Context context) {
        return b.a(context);
    }
    
    public static File[] getExternalFilesDirs(final Context context, final String s) {
        return b.b(context, s);
    }
    
    public static Executor getMainExecutor(final Context context) {
        if (Build$VERSION.SDK_INT >= 28) {
            return g.a(context);
        }
        return androidx.core.os.g.a(new Handler(context.getMainLooper()));
    }
    
    public static File getNoBackupFilesDir(final Context context) {
        return c.c(context);
    }
    
    public static File[] getObbDirs(final Context context) {
        return b.c(context);
    }
    
    public static <T> T getSystemService(final Context context, final Class<T> clazz) {
        return d.b(context, clazz);
    }
    
    public static String getSystemServiceName(final Context context, final Class<?> clazz) {
        return d.c(context, clazz);
    }
    
    public static boolean isDeviceProtectedStorage(final Context context) {
        return e.c(context);
    }
    
    public static boolean startActivities(final Context context, final Intent[] array) {
        return startActivities(context, array, null);
    }
    
    public static boolean startActivities(final Context context, final Intent[] array, final Bundle bundle) {
        a.a(context, array, bundle);
        return true;
    }
    
    public static void startActivity(final Context context, final Intent intent, final Bundle bundle) {
        a.b(context, intent, bundle);
    }
    
    public static void startForegroundService(final Context context, final Intent intent) {
        f.a(context, intent);
    }
    
    static class a
    {
        static void a(final Context context, final Intent[] array, final Bundle bundle) {
            context.startActivities(array, bundle);
        }
        
        static void b(final Context context, final Intent intent, final Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }
    
    static class b
    {
        static File[] a(final Context context) {
            return context.getExternalCacheDirs();
        }
        
        static File[] b(final Context context, final String s) {
            return context.getExternalFilesDirs(s);
        }
        
        static File[] c(final Context context) {
            return context.getObbDirs();
        }
    }
    
    static class c
    {
        static File a(final Context context) {
            return context.getCodeCacheDir();
        }
        
        static Drawable b(final Context context, final int n) {
            return context.getDrawable(n);
        }
        
        static File c(final Context context) {
            return context.getNoBackupFilesDir();
        }
    }
    
    static class d
    {
        static int a(final Context context, final int n) {
            return context.getColor(n);
        }
        
        static <T> T b(final Context context, final Class<T> clazz) {
            return (T)context.getSystemService((Class)clazz);
        }
        
        static String c(final Context context, final Class<?> clazz) {
            return context.getSystemServiceName((Class)clazz);
        }
    }
    
    static class e
    {
        static Context a(final Context context) {
            return context.createDeviceProtectedStorageContext();
        }
        
        static File b(final Context context) {
            return context.getDataDir();
        }
        
        static boolean c(final Context context) {
            return context.isDeviceProtectedStorage();
        }
    }
    
    static class f
    {
        static ComponentName a(final Context context, final Intent intent) {
            return context.startForegroundService(intent);
        }
    }
    
    static class g
    {
        static Executor a(final Context context) {
            return context.getMainExecutor();
        }
    }
    
    static class h
    {
        static String a(final Context context) {
            return context.getAttributionTag();
        }
    }
}
