// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.core.view.y;
import java.util.Map;
import androidx.core.os.e;
import android.view.ViewParent;
import android.graphics.RectF;
import android.graphics.Rect;
import java.util.ArrayList;
import android.view.ViewGroup;
import androidx.core.view.b0;
import android.view.View;
import java.util.List;

public abstract class f0
{
    protected static void d(final List<View> list, View child) {
        final int size = list.size();
        if (g(list, child, size)) {
            return;
        }
        if (b0.J(child) != null) {
            list.add(child);
        }
        for (int i = size; i < list.size(); ++i) {
            child = (View)list.get(i);
            if (child instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup)child;
                for (int childCount = viewGroup.getChildCount(), j = 0; j < childCount; ++j) {
                    child = viewGroup.getChildAt(j);
                    if (!g(list, child, size) && b0.J(child) != null) {
                        list.add(child);
                    }
                }
            }
        }
    }
    
    private static boolean g(final List<View> list, final View view, final int n) {
        for (int i = 0; i < n; ++i) {
            if (list.get(i) == view) {
                return true;
            }
        }
        return false;
    }
    
    protected static boolean i(final List list) {
        return list == null || list.isEmpty();
    }
    
    public abstract void a(final Object p0, final View p1);
    
    public abstract void b(final Object p0, final ArrayList<View> p1);
    
    public abstract void c(final ViewGroup p0, final Object p1);
    
    public abstract boolean e(final Object p0);
    
    public abstract Object f(final Object p0);
    
    protected void h(final View view, final Rect rect) {
        if (!b0.S(view)) {
            return;
        }
        final RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        view.getMatrix().mapRect(rectF);
        rectF.offset((float)view.getLeft(), (float)view.getTop());
        View view2;
        for (ViewParent viewParent = view.getParent(); viewParent instanceof View; viewParent = view2.getParent()) {
            view2 = (View)viewParent;
            rectF.offset((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
            view2.getMatrix().mapRect(rectF);
            rectF.offset((float)view2.getLeft(), (float)view2.getTop());
        }
        final int[] array = new int[2];
        view.getRootView().getLocationOnScreen(array);
        rectF.offset((float)array[0], (float)array[1]);
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }
    
    public abstract Object j(final Object p0, final Object p1, final Object p2);
    
    public abstract Object k(final Object p0, final Object p1, final Object p2);
    
    ArrayList<String> l(final ArrayList<View> list) {
        final ArrayList list2 = new ArrayList();
        for (int size = list.size(), i = 0; i < size; ++i) {
            final View view = list.get(i);
            list2.add(b0.J(view));
            b0.J0(view, null);
        }
        return list2;
    }
    
    public abstract void m(final Object p0, final View p1, final ArrayList<View> p2);
    
    public abstract void n(final Object p0, final Object p1, final ArrayList<View> p2, final Object p3, final ArrayList<View> p4, final Object p5, final ArrayList<View> p6);
    
    public abstract void o(final Object p0, final Rect p1);
    
    public abstract void p(final Object p0, final View p1);
    
    public void q(final Fragment fragment, final Object o, final e e, final Runnable runnable) {
        runnable.run();
    }
    
    void r(final View view, final ArrayList<View> list, final ArrayList<View> list2, final ArrayList<String> list3, final Map<String, String> map) {
        final int size = list2.size();
        final ArrayList list4 = new ArrayList();
        for (int i = 0; i < size; ++i) {
            final View view2 = list.get(i);
            final String j = b0.J(view2);
            list4.add(j);
            if (j != null) {
                b0.J0(view2, null);
                final String s = map.get(j);
                for (int k = 0; k < size; ++k) {
                    if (s.equals(list3.get(k))) {
                        b0.J0((View)list2.get(k), j);
                        break;
                    }
                }
            }
        }
        y.a(view, new Runnable(this, size, list2, list3, list, list4) {
            final int a;
            final ArrayList b;
            final ArrayList c;
            final ArrayList d;
            final ArrayList e;
            final f0 f;
            
            @Override
            public void run() {
                for (int i = 0; i < this.a; ++i) {
                    b0.J0((View)this.b.get(i), (String)this.c.get(i));
                    b0.J0((View)this.d.get(i), (String)this.e.get(i));
                }
            }
        });
    }
    
    public abstract void s(final Object p0, final View p1, final ArrayList<View> p2);
    
    public abstract void t(final Object p0, final ArrayList<View> p1, final ArrayList<View> p2);
    
    public abstract Object u(final Object p0);
}
