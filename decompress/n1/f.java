// 
// Decompiled by Procyon v0.6.0
// 

package n1;

import android.text.TextUtils;
import androidx.work.a;
import java.util.Iterator;
import java.util.List;
import java.lang.reflect.Method;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.app.ActivityManager;
import android.os.Process;
import android.app.Application;
import android.os.Build$VERSION;
import android.content.Context;
import e1.h;

public class f
{
    private static final String a;
    
    static {
        a = h.f("ProcessUtils");
    }
    
    private f() {
    }
    
    public static String a(final Context context) {
        if (Build$VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            final Method declaredMethod = Class.forName("android.app.ActivityThread", false, f.class.getClassLoader()).getDeclaredMethod("currentProcessName", (Class<?>[])new Class[0]);
            declaredMethod.setAccessible(true);
            final Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String)invoke;
            }
        }
        finally {
            final Throwable t;
            h.c().a(f.a, "Unable to check ActivityThread for processName", t);
        }
        final int myPid = Process.myPid();
        final ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
        if (activityManager != null) {
            final List runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                for (final ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo : runningAppProcesses) {
                    if (activityManager$RunningAppProcessInfo.pid == myPid) {
                        return activityManager$RunningAppProcessInfo.processName;
                    }
                }
            }
        }
        return null;
    }
    
    public static boolean b(final Context context, final a a) {
        final String a2 = a(context);
        if (!TextUtils.isEmpty((CharSequence)a.c())) {
            return TextUtils.equals((CharSequence)a2, (CharSequence)a.c());
        }
        return TextUtils.equals((CharSequence)a2, (CharSequence)context.getApplicationInfo().processName);
    }
}
