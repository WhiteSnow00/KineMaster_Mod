// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import java.lang.reflect.InvocationTargetException;
import androidx.core.view.b0;
import android.util.Log;
import android.graphics.Rect;
import android.view.View;
import java.lang.reflect.Method;

public class w0
{
    private static Method a;
    
    static {
        try {
            if (!(w0.a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class)).isAccessible()) {
                w0.a.setAccessible(true);
            }
        }
        catch (final NoSuchMethodException ex) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }
    
    public static void a(final View view, final Rect rect, final Rect rect2) {
        final Method a = w0.a;
        if (a != null) {
            try {
                a.invoke(view, rect, rect2);
            }
            catch (final Exception ex) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", (Throwable)ex);
            }
        }
    }
    
    public static boolean b(final View view) {
        final int b = b0.B(view);
        boolean b2 = true;
        if (b != 1) {
            b2 = false;
        }
        return b2;
    }
    
    public static void c(final View view) {
        try {
            final Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", (Class<?>[])new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, new Object[0]);
        }
        catch (final IllegalAccessException ex) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", (Throwable)ex);
        }
        catch (final InvocationTargetException ex2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", (Throwable)ex2);
        }
        catch (final NoSuchMethodException ex3) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        }
    }
}
