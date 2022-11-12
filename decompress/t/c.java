// 
// Decompiled by Procyon v0.6.0
// 

package t;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionLayout;
import o.b;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import android.util.SparseArray;
import o.j;

public abstract class c extends o.j
{
    public static c e(final String s, final SparseArray<ConstraintAttribute> sparseArray) {
        return new b(s, sparseArray);
    }
    
    public static c f(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 156108012: {
                if (!s.equals("waveOffset")) {
                    break;
                }
                n = 15;
                break;
            }
            case 92909918: {
                if (!s.equals("alpha")) {
                    break;
                }
                n = 14;
                break;
            }
            case 37232917: {
                if (!s.equals("transitionPathRotate")) {
                    break;
                }
                n = 13;
                break;
            }
            case -4379043: {
                if (!s.equals("elevation")) {
                    break;
                }
                n = 12;
                break;
            }
            case -40300674: {
                if (!s.equals("rotation")) {
                    break;
                }
                n = 11;
                break;
            }
            case -760884509: {
                if (!s.equals("transformPivotY")) {
                    break;
                }
                n = 10;
                break;
            }
            case -760884510: {
                if (!s.equals("transformPivotX")) {
                    break;
                }
                n = 9;
                break;
            }
            case -797520672: {
                if (!s.equals("waveVariesBy")) {
                    break;
                }
                n = 8;
                break;
            }
            case -908189617: {
                if (!s.equals("scaleY")) {
                    break;
                }
                n = 7;
                break;
            }
            case -908189618: {
                if (!s.equals("scaleX")) {
                    break;
                }
                n = 6;
                break;
            }
            case -1001078227: {
                if (!s.equals("progress")) {
                    break;
                }
                n = 5;
                break;
            }
            case -1225497655: {
                if (!s.equals("translationZ")) {
                    break;
                }
                n = 4;
                break;
            }
            case -1225497656: {
                if (!s.equals("translationY")) {
                    break;
                }
                n = 3;
                break;
            }
            case -1225497657: {
                if (!s.equals("translationX")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1249320805: {
                if (!s.equals("rotationY")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1249320806: {
                if (!s.equals("rotationX")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return null;
            }
            case 15: {
                return new a();
            }
            case 14: {
                return new a();
            }
            case 13: {
                return new d();
            }
            case 12: {
                return new c();
            }
            case 11: {
                return new h();
            }
            case 10: {
                return new f();
            }
            case 9: {
                return new e();
            }
            case 8: {
                return new a();
            }
            case 7: {
                return new l();
            }
            case 6: {
                return new k();
            }
            case 5: {
                return new g();
            }
            case 4: {
                return new o();
            }
            case 3: {
                return new n();
            }
            case 2: {
                return new m();
            }
            case 1: {
                return new j();
            }
            case 0: {
                return new i();
            }
        }
    }
    
    public abstract void g(final View p0, final float p1);
    
    static class a extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setAlpha(this.a(n));
        }
    }
    
    public static class b extends c
    {
        String f;
        SparseArray<ConstraintAttribute> g;
        float[] h;
        
        public b(final String s, final SparseArray<ConstraintAttribute> g) {
            this.f = s.split(",")[1];
            this.g = g;
        }
        
        @Override
        public void b(final int n, final float n2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }
        
        @Override
        public void d(final int n) {
            final int size = this.g.size();
            final int g = ((ConstraintAttribute)this.g.valueAt(0)).g();
            final double[] array = new double[size];
            this.h = new float[g];
            final double[][] array2 = new double[size][g];
            for (int i = 0; i < size; ++i) {
                final int key = this.g.keyAt(i);
                final ConstraintAttribute constraintAttribute = (ConstraintAttribute)this.g.valueAt(i);
                array[i] = key * 0.01;
                constraintAttribute.f(this.h);
                int n2 = 0;
                while (true) {
                    final float[] h = this.h;
                    if (n2 >= h.length) {
                        break;
                    }
                    array2[i][n2] = h[n2];
                    ++n2;
                }
            }
            super.a = o.b.a(n, array, array2);
        }
        
        @Override
        public void g(final View view, final float n) {
            super.a.e(n, this.h);
            t.a.b((ConstraintAttribute)this.g.valueAt(0), view, this.h);
        }
        
        public void h(final int n, final ConstraintAttribute constraintAttribute) {
            this.g.append(n, (Object)constraintAttribute);
        }
    }
    
    static class c extends t.c
    {
        @Override
        public void g(final View view, final float n) {
            view.setElevation(this.a(n));
        }
    }
    
    public static class d extends c
    {
        @Override
        public void g(final View view, final float n) {
        }
        
        public void h(final View view, final float n, final double n2, final double n3) {
            view.setRotation(this.a(n) + (float)Math.toDegrees(Math.atan2(n3, n2)));
        }
    }
    
    static class e extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setPivotX(this.a(n));
        }
    }
    
    static class f extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setPivotY(this.a(n));
        }
    }
    
    static class g extends c
    {
        boolean f;
        
        g() {
            this.f = false;
        }
        
        @Override
        public void g(final View view, final float n) {
            if (view instanceof MotionLayout) {
                ((MotionLayout)view).setProgress(this.a(n));
            }
            else {
                if (this.f) {
                    return;
                }
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                }
                catch (final NoSuchMethodException ex) {
                    this.f = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, this.a(n));
                    }
                    catch (final InvocationTargetException ex2) {
                        Log.e("ViewSpline", "unable to setProgress", (Throwable)ex2);
                    }
                    catch (final IllegalAccessException ex3) {
                        Log.e("ViewSpline", "unable to setProgress", (Throwable)ex3);
                    }
                }
            }
        }
    }
    
    static class h extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setRotation(this.a(n));
        }
    }
    
    static class i extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setRotationX(this.a(n));
        }
    }
    
    static class j extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setRotationY(this.a(n));
        }
    }
    
    static class k extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setScaleX(this.a(n));
        }
    }
    
    static class l extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setScaleY(this.a(n));
        }
    }
    
    static class m extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setTranslationX(this.a(n));
        }
    }
    
    static class n extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setTranslationY(this.a(n));
        }
    }
    
    static class o extends c
    {
        @Override
        public void g(final View view, final float n) {
            view.setTranslationZ(this.a(n));
        }
    }
}
