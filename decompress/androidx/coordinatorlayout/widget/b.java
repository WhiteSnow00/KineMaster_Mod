// 
// Decompiled by Procyon v0.6.0
// 

package androidx.coordinatorlayout.widget;

import android.view.ViewParent;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.RectF;
import android.graphics.Matrix;

public class b
{
    private static final ThreadLocal<Matrix> a;
    private static final ThreadLocal<RectF> b;
    
    static {
        a = new ThreadLocal<Matrix>();
        b = new ThreadLocal<RectF>();
    }
    
    public static void a(final ViewGroup viewGroup, final View view, final Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        c(viewGroup, view, rect);
    }
    
    private static void b(final ViewParent viewParent, final View view, final Matrix matrix) {
        final ViewParent parent = view.getParent();
        if (parent instanceof View && parent != viewParent) {
            final View view2 = (View)parent;
            b(viewParent, view2, matrix);
            matrix.preTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
    
    static void c(final ViewGroup viewGroup, final View view, final Rect rect) {
        final ThreadLocal<Matrix> a = androidx.coordinatorlayout.widget.b.a;
        Matrix matrix = a.get();
        if (matrix == null) {
            matrix = new Matrix();
            a.set(matrix);
        }
        else {
            matrix.reset();
        }
        b((ViewParent)viewGroup, view, matrix);
        final ThreadLocal<RectF> b = androidx.coordinatorlayout.widget.b.b;
        RectF rectF;
        if ((rectF = b.get()) == null) {
            rectF = new RectF();
            b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int)(rectF.left + 0.5f), (int)(rectF.top + 0.5f), (int)(rectF.right + 0.5f), (int)(rectF.bottom + 0.5f));
    }
}
