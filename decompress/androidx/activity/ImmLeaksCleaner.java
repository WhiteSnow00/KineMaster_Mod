// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import android.view.inputmethod.InputMethodManager;
import android.app.Activity;
import java.lang.reflect.Field;
import androidx.lifecycle.o;

final class ImmLeaksCleaner implements o
{
    private static int b;
    private static Field c;
    private static Field d;
    private static Field e;
    private Activity a;
    
    private static void g() {
        try {
            ImmLeaksCleaner.b = 2;
            (ImmLeaksCleaner.d = InputMethodManager.class.getDeclaredField("mServedView")).setAccessible(true);
            (ImmLeaksCleaner.e = InputMethodManager.class.getDeclaredField("mNextServedView")).setAccessible(true);
            (ImmLeaksCleaner.c = InputMethodManager.class.getDeclaredField("mH")).setAccessible(true);
            ImmLeaksCleaner.b = 1;
        }
        catch (final NoSuchFieldException ex) {}
    }
    
    @Override
    public void f(r value, final Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (ImmLeaksCleaner.b == 0) {
            g();
        }
        if (ImmLeaksCleaner.b != 1) {
            return;
        }
        final InputMethodManager inputMethodManager = (InputMethodManager)this.a.getSystemService("input_method");
        try {
            value = (r)ImmLeaksCleaner.c.get(inputMethodManager);
            if (value == null) {
                return;
            }
            monitorenter(value);
            try {
                try {
                    final View view = (View)ImmLeaksCleaner.d.get(inputMethodManager);
                    if (view == null) {
                        monitorexit(value);
                        return;
                    }
                    if (view.isAttachedToWindow()) {
                        monitorexit(value);
                        return;
                    }
                    try {
                        ImmLeaksCleaner.e.set(inputMethodManager, null);
                        monitorexit(value);
                        inputMethodManager.isActive();
                    }
                    catch (final IllegalAccessException ex) {
                        monitorexit(value);
                    }
                }
                finally {
                    monitorexit(value);
                }
            }
            catch (final ClassCastException ex2) {}
            catch (final IllegalAccessException ex3) {}
        }
        catch (final IllegalAccessException ex4) {}
    }
}
