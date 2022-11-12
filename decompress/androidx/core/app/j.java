// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build$VERSION;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.content.Context;
import android.content.ComponentName;
import android.content.Intent;
import android.app.Activity;

public final class j
{
    public static Intent a(final Activity activity) {
        final Intent a = j.a.a(activity);
        if (a != null) {
            return a;
        }
        final String c = c(activity);
        if (c == null) {
            return null;
        }
        final ComponentName component = new ComponentName((Context)activity, c);
        try {
            Intent intent;
            if (d((Context)activity, component) == null) {
                intent = Intent.makeMainActivity(component);
            }
            else {
                intent = new Intent().setComponent(component);
            }
            return intent;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("getParentActivityIntent: bad parentActivityName '");
            sb.append(c);
            sb.append("' in manifest");
            Log.e("NavUtils", sb.toString());
            return null;
        }
    }
    
    public static Intent b(final Context context, ComponentName component) throws PackageManager$NameNotFoundException {
        final String d = d(context, component);
        if (d == null) {
            return null;
        }
        component = new ComponentName(component.getPackageName(), d);
        Intent intent;
        if (d(context, component) == null) {
            intent = Intent.makeMainActivity(component);
        }
        else {
            intent = new Intent().setComponent(component);
        }
        return intent;
    }
    
    public static String c(final Activity activity) {
        try {
            return d((Context)activity, activity.getComponentName());
        }
        catch (final PackageManager$NameNotFoundException ex) {
            throw new IllegalArgumentException((Throwable)ex);
        }
    }
    
    public static String d(final Context context, final ComponentName componentName) throws PackageManager$NameNotFoundException {
        final PackageManager packageManager = context.getPackageManager();
        int n;
        if (Build$VERSION.SDK_INT >= 29) {
            n = 269222528;
        }
        else {
            n = 787072;
        }
        final ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, n);
        final String parentActivityName = activityInfo.parentActivityName;
        if (parentActivityName != null) {
            return parentActivityName;
        }
        final Bundle metaData = activityInfo.metaData;
        if (metaData == null) {
            return null;
        }
        final String string = metaData.getString("android.support.PARENT_ACTIVITY");
        if (string == null) {
            return null;
        }
        String string2 = string;
        if (string.charAt(0) == '.') {
            final StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(string);
            string2 = sb.toString();
        }
        return string2;
    }
    
    public static void e(final Activity activity, final Intent intent) {
        a.b(activity, intent);
    }
    
    public static boolean f(final Activity activity, final Intent intent) {
        return a.c(activity, intent);
    }
    
    static class a
    {
        static Intent a(final Activity activity) {
            return activity.getParentActivityIntent();
        }
        
        static boolean b(final Activity activity, final Intent intent) {
            return activity.navigateUpTo(intent);
        }
        
        static boolean c(final Activity activity, final Intent intent) {
            return activity.shouldUpRecreateTask(intent);
        }
    }
}
