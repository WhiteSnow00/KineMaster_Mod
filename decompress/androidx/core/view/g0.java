// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class g0
{
    public static boolean a(final ViewParent viewParent, final View view, final float n, final float n2, final boolean b) {
        try {
            return a.a(viewParent, view, n, n2, b);
        }
        catch (final AbstractMethodError abstractMethodError) {
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface method onNestedFling");
            Log.e("ViewParentCompat", sb.toString(), (Throwable)abstractMethodError);
            return false;
        }
    }
    
    public static boolean b(final ViewParent viewParent, final View view, final float n, final float n2) {
        try {
            return a.b(viewParent, view, n, n2);
        }
        catch (final AbstractMethodError abstractMethodError) {
            final StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(viewParent);
            sb.append(" does not implement interface method onNestedPreFling");
            Log.e("ViewParentCompat", sb.toString(), (Throwable)abstractMethodError);
            return false;
        }
    }
    
    public static void c(final ViewParent viewParent, final View view, final int n, final int n2, final int[] array, final int n3) {
        if (viewParent instanceof s) {
            ((s)viewParent).k(view, n, n2, array, n3);
        }
        else if (n3 == 0) {
            try {
                a.c(viewParent, view, n, n2, array);
            }
            catch (final AbstractMethodError abstractMethodError) {
                final StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onNestedPreScroll");
                Log.e("ViewParentCompat", sb.toString(), (Throwable)abstractMethodError);
            }
        }
    }
    
    public static void d(final ViewParent viewParent, final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int[] array) {
        if (viewParent instanceof t) {
            ((t)viewParent).m(view, n, n2, n3, n4, n5, array);
        }
        else {
            array[0] += n3;
            array[1] += n4;
            if (viewParent instanceof s) {
                ((s)viewParent).n(view, n, n2, n3, n4, n5);
            }
            else if (n5 == 0) {
                try {
                    a.d(viewParent, view, n, n2, n3, n4);
                }
                catch (final AbstractMethodError abstractMethodError) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(viewParent);
                    sb.append(" does not implement interface method onNestedScroll");
                    Log.e("ViewParentCompat", sb.toString(), (Throwable)abstractMethodError);
                }
            }
        }
    }
    
    public static void e(final ViewParent viewParent, final View view, final View view2, final int n, final int n2) {
        if (viewParent instanceof s) {
            ((s)viewParent).i(view, view2, n, n2);
        }
        else if (n2 == 0) {
            try {
                a.e(viewParent, view, view2, n);
            }
            catch (final AbstractMethodError abstractMethodError) {
                final StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onNestedScrollAccepted");
                Log.e("ViewParentCompat", sb.toString(), (Throwable)abstractMethodError);
            }
        }
    }
    
    public static boolean f(final ViewParent viewParent, final View view, final View view2, final int n, final int n2) {
        if (viewParent instanceof s) {
            return ((s)viewParent).o(view, view2, n, n2);
        }
        if (n2 == 0) {
            try {
                return a.f(viewParent, view, view2, n);
            }
            catch (final AbstractMethodError abstractMethodError) {
                final StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onStartNestedScroll");
                Log.e("ViewParentCompat", sb.toString(), (Throwable)abstractMethodError);
            }
        }
        return false;
    }
    
    public static void g(final ViewParent viewParent, final View view, final int n) {
        if (viewParent instanceof s) {
            ((s)viewParent).j(view, n);
        }
        else if (n == 0) {
            try {
                a.g(viewParent, view);
            }
            catch (final AbstractMethodError abstractMethodError) {
                final StringBuilder sb = new StringBuilder();
                sb.append("ViewParent ");
                sb.append(viewParent);
                sb.append(" does not implement interface method onStopNestedScroll");
                Log.e("ViewParentCompat", sb.toString(), (Throwable)abstractMethodError);
            }
        }
    }
    
    static class a
    {
        static boolean a(final ViewParent viewParent, final View view, final float n, final float n2, final boolean b) {
            return viewParent.onNestedFling(view, n, n2, b);
        }
        
        static boolean b(final ViewParent viewParent, final View view, final float n, final float n2) {
            return viewParent.onNestedPreFling(view, n, n2);
        }
        
        static void c(final ViewParent viewParent, final View view, final int n, final int n2, final int[] array) {
            viewParent.onNestedPreScroll(view, n, n2, array);
        }
        
        static void d(final ViewParent viewParent, final View view, final int n, final int n2, final int n3, final int n4) {
            viewParent.onNestedScroll(view, n, n2, n3, n4);
        }
        
        static void e(final ViewParent viewParent, final View view, final View view2, final int n) {
            viewParent.onNestedScrollAccepted(view, view2, n);
        }
        
        static boolean f(final ViewParent viewParent, final View view, final View view2, final int n) {
            return viewParent.onStartNestedScroll(view, view2, n);
        }
        
        static void g(final ViewParent viewParent, final View view) {
            viewParent.onStopNestedScroll(view);
        }
    }
}
