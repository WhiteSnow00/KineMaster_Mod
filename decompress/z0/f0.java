// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

class f0
{
    private static Field a;
    private static boolean b;
    
    public void a(final View view) {
        throw null;
    }
    
    public float b(final View view) {
        throw null;
    }
    
    public void c(final View view) {
        throw null;
    }
    
    public void d(final View view, final int n, final int n2, final int n3, final int n4) {
        throw null;
    }
    
    public void e(final View view, final float n) {
        throw null;
    }
    
    public void f(final View view, final int n) {
        if (!f0.b) {
            try {
                (f0.a = View.class.getDeclaredField("mViewFlags")).setAccessible(true);
            }
            catch (final NoSuchFieldException ex) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f0.b = true;
        }
        final Field a = f0.a;
        if (a == null) {
            return;
        }
        try {
            f0.a.setInt(view, n | (a.getInt(view) & 0xFFFFFFF3));
        }
        catch (final IllegalAccessException ex2) {}
    }
    
    public void g(final View view, final Matrix matrix) {
        throw null;
    }
    
    public void h(final View view, final Matrix matrix) {
        throw null;
    }
}
