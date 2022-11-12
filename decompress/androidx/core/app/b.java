// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.app.SharedElementCallback$OnSharedElementsReadyListener;
import android.content.IntentSender$SendIntentException;
import android.content.IntentSender;
import android.os.Bundle;
import android.content.Intent;
import android.app.SharedElementCallback;
import java.util.Arrays;
import android.text.TextUtils;
import android.os.Handler;
import android.os.Build$VERSION;
import android.app.Activity;
import androidx.core.content.a;

public class b extends androidx.core.content.a
{
    private static d a;
    
    public static void a(final Activity activity) {
        d(activity);
    }
    
    public static void b(final Activity activity) {
        androidx.core.app.b.a.a(activity);
    }
    
    public static void c(final Activity activity) {
        b.a(activity);
    }
    
    private static void d(final Activity activity) {
        if (!activity.isFinishing() && !androidx.core.app.d.i(activity)) {
            activity.recreate();
        }
    }
    
    public static void e(final Activity activity) {
        b.b(activity);
    }
    
    public static void f(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 28) {
            activity.recreate();
        }
        else {
            new Handler(activity.getMainLooper()).post((Runnable)new androidx.core.app.a(activity));
        }
    }
    
    public static void g(final Activity activity, final String[] array, final int n) {
        final d a = b.a;
        if (a != null && a.a(activity, array, n)) {
            return;
        }
        for (int length = array.length, i = 0; i < length; ++i) {
            if (TextUtils.isEmpty((CharSequence)array[i])) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Permission request for permissions ");
                sb.append(Arrays.toString(array));
                sb.append(" must not contain null or empty values");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (activity instanceof e) {
            ((e)activity).validateRequestPermissionsRequestCode(n);
        }
        c.b(activity, array, n);
    }
    
    public static void h(final Activity activity, final u u) {
        b.c(activity, null);
    }
    
    public static void i(final Activity activity, final u u) {
        b.d(activity, null);
    }
    
    public static boolean j(final Activity activity, final String s) {
        return c.c(activity, s);
    }
    
    public static void k(final Activity activity, final Intent intent, final int n, final Bundle bundle) {
        androidx.core.app.b.a.b(activity, intent, n, bundle);
    }
    
    public static void l(final Activity activity, final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) throws IntentSender$SendIntentException {
        androidx.core.app.b.a.c(activity, intentSender, n, intent, n2, n3, n4, bundle);
    }
    
    public static void m(final Activity activity) {
        b.e(activity);
    }
    
    static class a
    {
        static void a(final Activity activity) {
            activity.finishAffinity();
        }
        
        static void b(final Activity activity, final Intent intent, final int n, final Bundle bundle) {
            activity.startActivityForResult(intent, n, bundle);
        }
        
        static void c(final Activity activity, final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) throws IntentSender$SendIntentException {
            activity.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4, bundle);
        }
    }
    
    static class b
    {
        static void a(final Activity activity) {
            activity.finishAfterTransition();
        }
        
        static void b(final Activity activity) {
            activity.postponeEnterTransition();
        }
        
        static void c(final Activity activity, final SharedElementCallback enterSharedElementCallback) {
            activity.setEnterSharedElementCallback(enterSharedElementCallback);
        }
        
        static void d(final Activity activity, final SharedElementCallback exitSharedElementCallback) {
            activity.setExitSharedElementCallback(exitSharedElementCallback);
        }
        
        static void e(final Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }
    
    static class c
    {
        static void a(final Object o) {
            ((SharedElementCallback$OnSharedElementsReadyListener)o).onSharedElementsReady();
        }
        
        static void b(final Activity activity, final String[] array, final int n) {
            activity.requestPermissions(array, n);
        }
        
        static boolean c(final Activity activity, final String s) {
            return activity.shouldShowRequestPermissionRationale(s);
        }
    }
    
    public interface d
    {
        boolean a(final Activity p0, final String[] p1, final int p2);
    }
    
    public interface e
    {
        void validateRequestPermissionsRequestCode(final int p0);
    }
}
