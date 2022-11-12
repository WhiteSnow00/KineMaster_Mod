// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.graphics.Matrix;
import androidx.core.view.b0;
import android.os.Build$VERSION;
import android.graphics.Rect;
import android.view.View;
import android.util.Property;

class z
{
    private static final f0 a;
    static final Property<View, Float> b;
    static final Property<View, Rect> c;
    
    static {
        if (Build$VERSION.SDK_INT >= 29) {
            a = new e0();
        }
        else {
            a = new d0();
        }
        b = new Property<View, Float>("translationAlpha") {
            public Float a(final View view) {
                return z.c(view);
            }
            
            public void b(final View view, final Float n) {
                z.g(view, n);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.a((View)o);
            }
            
            public /* bridge */ void set(final Object o, final Object o2) {
                this.b((View)o, (Float)o2);
            }
        };
        c = new Property<View, Rect>("clipBounds") {
            public Rect a(final View view) {
                return b0.u(view);
            }
            
            public void b(final View view, final Rect rect) {
                b0.w0(view, rect);
            }
            
            public /* bridge */ Object get(final Object o) {
                return this.a((View)o);
            }
            
            public /* bridge */ void set(final Object o, final Object o2) {
                this.b((View)o, (Rect)o2);
            }
        };
    }
    
    static void a(final View view) {
        z.a.a(view);
    }
    
    static y b(final View view) {
        return new x(view);
    }
    
    static float c(final View view) {
        return z.a.b(view);
    }
    
    static i0 d(final View view) {
        return new h0(view);
    }
    
    static void e(final View view) {
        z.a.c(view);
    }
    
    static void f(final View view, final int n, final int n2, final int n3, final int n4) {
        z.a.d(view, n, n2, n3, n4);
    }
    
    static void g(final View view, final float n) {
        z.a.e(view, n);
    }
    
    static void h(final View view, final int n) {
        z.a.f(view, n);
    }
    
    static void i(final View view, final Matrix matrix) {
        z.a.g(view, matrix);
    }
    
    static void j(final View view, final Matrix matrix) {
        z.a.h(view, matrix);
    }
}
