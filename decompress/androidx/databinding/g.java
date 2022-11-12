// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

public class g
{
    private static e a;
    private static f b;
    
    static {
        g.a = new DataBinderMapperImpl();
        g.b = null;
    }
    
    static <T extends ViewDataBinding> T a(final f f, final View view, final int n) {
        return (T)g.a.b(f, view, n);
    }
    
    static <T extends ViewDataBinding> T b(final f f, final View[] array, final int n) {
        return (T)g.a.c(f, array, n);
    }
    
    private static <T extends ViewDataBinding> T c(final f f, final ViewGroup viewGroup, final int n, final int n2) {
        final int childCount = viewGroup.getChildCount();
        final int n3 = childCount - n;
        if (n3 == 1) {
            return (T)a(f, viewGroup.getChildAt(childCount - 1), n2);
        }
        final View[] array = new View[n3];
        for (int i = 0; i < n3; ++i) {
            array[i] = viewGroup.getChildAt(i + n);
        }
        return (T)b(f, array, n2);
    }
    
    public static <T extends ViewDataBinding> T d(final View view) {
        return (T)ViewDataBinding.l(view);
    }
    
    public static f e() {
        return g.b;
    }
    
    public static <T extends ViewDataBinding> T f(final LayoutInflater layoutInflater, final int n, final ViewGroup viewGroup, final boolean b) {
        return g(layoutInflater, n, viewGroup, b, g.b);
    }
    
    public static <T extends ViewDataBinding> T g(final LayoutInflater layoutInflater, final int n, final ViewGroup viewGroup, final boolean b, final f f) {
        int childCount = 0;
        final boolean b2 = viewGroup != null && b;
        if (b2) {
            childCount = viewGroup.getChildCount();
        }
        final View inflate = layoutInflater.inflate(n, viewGroup, b);
        if (b2) {
            return (T)c(f, viewGroup, childCount, n);
        }
        return (T)a(f, inflate, n);
    }
    
    public static <T extends ViewDataBinding> T h(final Activity activity, final int n) {
        return i(activity, n, g.b);
    }
    
    public static <T extends ViewDataBinding> T i(final Activity activity, final int contentView, final f f) {
        activity.setContentView(contentView);
        return c(f, (ViewGroup)activity.getWindow().getDecorView().findViewById(16908290), 0, contentView);
    }
}
