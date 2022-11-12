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
import o.l;

public abstract class d extends o.l
{
    public static d g(final String s, final SparseArray<ConstraintAttribute> sparseArray) {
        return new b(s, sparseArray);
    }
    
    public static d h(final String s, final long n) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n2 = -1;
        switch (hashCode) {
            case 92909918: {
                if (!s.equals("alpha")) {
                    break;
                }
                n2 = 11;
                break;
            }
            case 37232917: {
                if (!s.equals("transitionPathRotate")) {
                    break;
                }
                n2 = 10;
                break;
            }
            case -4379043: {
                if (!s.equals("elevation")) {
                    break;
                }
                n2 = 9;
                break;
            }
            case -40300674: {
                if (!s.equals("rotation")) {
                    break;
                }
                n2 = 8;
                break;
            }
            case -908189617: {
                if (!s.equals("scaleY")) {
                    break;
                }
                n2 = 7;
                break;
            }
            case -908189618: {
                if (!s.equals("scaleX")) {
                    break;
                }
                n2 = 6;
                break;
            }
            case -1001078227: {
                if (!s.equals("progress")) {
                    break;
                }
                n2 = 5;
                break;
            }
            case -1225497655: {
                if (!s.equals("translationZ")) {
                    break;
                }
                n2 = 4;
                break;
            }
            case -1225497656: {
                if (!s.equals("translationY")) {
                    break;
                }
                n2 = 3;
                break;
            }
            case -1225497657: {
                if (!s.equals("translationX")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case -1249320805: {
                if (!s.equals("rotationY")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case -1249320806: {
                if (!s.equals("rotationX")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        d d = null;
        switch (n2) {
            default: {
                return null;
            }
            case 11: {
                d = new a();
                break;
            }
            case 10: {
                d = new d();
                break;
            }
            case 9: {
                d = new c();
                break;
            }
            case 8: {
                d = new f();
                break;
            }
            case 7: {
                d = new j();
                break;
            }
            case 6: {
                d = new i();
                break;
            }
            case 5: {
                d = new e();
                break;
            }
            case 4: {
                d = new m();
                break;
            }
            case 3: {
                d = new l();
                break;
            }
            case 2: {
                d = new k();
                break;
            }
            case 1: {
                d = new h();
                break;
            }
            case 0: {
                d = new g();
                break;
            }
        }
        d.c(n);
        return d;
    }
    
    public float f(float n, final long i, final View view, final d d) {
        super.a.e(n, super.g);
        final float[] g = super.g;
        final float n2 = g[1];
        final float n3 = fcmpl(n2, 0.0f);
        if (n3 == 0) {
            super.h = false;
            return g[2];
        }
        if (Float.isNaN(super.j)) {
            n = d.a(view, super.f, 0);
            super.j = n;
            if (Float.isNaN(n)) {
                super.j = 0.0f;
            }
        }
        n = (float)((super.j + (i - super.i) * 1.0E-9 * n2) % 1.0);
        super.j = n;
        d.b(view, super.f, 0, n);
        super.i = i;
        final float n4 = super.g[0];
        n = this.a(super.j);
        final float n5 = super.g[2];
        super.h = (n4 != 0.0f || n3 != 0);
        return n * n4 + n5;
    }
    
    public abstract boolean i(final View p0, final float p1, final long p2, final d p3);
    
    static class a extends d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            view.setAlpha(this.f(n, n2, view, d));
            return super.h;
        }
    }
    
    public static class b extends d
    {
        String l;
        SparseArray<ConstraintAttribute> m;
        SparseArray<float[]> n;
        float[] o;
        float[] p;
        
        public b(final String s, final SparseArray<ConstraintAttribute> m) {
            this.n = (SparseArray<float[]>)new SparseArray();
            this.l = s.split(",")[1];
            this.m = m;
        }
        
        @Override
        public void b(final int n, final float n2, final float n3, final int n4, final float n5) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }
        
        @Override
        public void e(final int n) {
            final int size = this.m.size();
            final int g = ((ConstraintAttribute)this.m.valueAt(0)).g();
            final double[] array = new double[size];
            final int n2 = g + 2;
            this.o = new float[n2];
            this.p = new float[g];
            final double[][] array2 = new double[size][n2];
            for (int i = 0; i < size; ++i) {
                final int key = this.m.keyAt(i);
                final ConstraintAttribute constraintAttribute = (ConstraintAttribute)this.m.valueAt(i);
                final float[] array3 = (float[])this.n.valueAt(i);
                array[i] = key * 0.01;
                constraintAttribute.f(this.o);
                int n3 = 0;
                while (true) {
                    final float[] o = this.o;
                    if (n3 >= o.length) {
                        break;
                    }
                    array2[i][n3] = o[n3];
                    ++n3;
                }
                array2[i][g] = array3[0];
                array2[i][g + 1] = array3[1];
            }
            super.a = o.b.a(n, array, array2);
        }
        
        @Override
        public boolean i(final View view, float n, final long i, final d d) {
            super.a.e(n, this.o);
            final float[] o = this.o;
            final float n2 = o[o.length - 2];
            n = o[o.length - 1];
            final long j = super.i;
            if (Float.isNaN(super.j)) {
                final float a = d.a(view, this.l, 0);
                super.j = a;
                if (Float.isNaN(a)) {
                    super.j = 0.0f;
                }
            }
            final float k = (float)((super.j + (i - j) * 1.0E-9 * n2) % 1.0);
            super.j = k;
            super.i = i;
            final float a2 = this.a(k);
            super.h = false;
            int n3 = 0;
            while (true) {
                final float[] p4 = this.p;
                if (n3 >= p4.length) {
                    break;
                }
                final boolean h = super.h;
                final float[] o2 = this.o;
                super.h = (h | o2[n3] != 0.0);
                p4[n3] = o2[n3] * a2 + n;
                ++n3;
            }
            t.a.b((ConstraintAttribute)this.m.valueAt(0), view, this.p);
            if (n2 != 0.0f) {
                super.h = true;
            }
            return super.h;
        }
        
        public void j(final int n, final ConstraintAttribute constraintAttribute, final float n2, final int n3, final float n4) {
            this.m.append(n, (Object)constraintAttribute);
            this.n.append(n, (Object)new float[] { n2, n4 });
            super.b = Math.max(super.b, n3);
        }
    }
    
    static class c extends d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            view.setElevation(this.f(n, n2, view, d));
            return super.h;
        }
    }
    
    public static class d extends t.d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final o.d d) {
            return super.h;
        }
        
        public boolean j(final View view, final o.d d, final float n, final long n2, final double n3, final double n4) {
            view.setRotation(this.f(n, n2, view, d) + (float)Math.toDegrees(Math.atan2(n4, n3)));
            return super.h;
        }
    }
    
    static class e extends d
    {
        boolean l;
        
        e() {
            this.l = false;
        }
        
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            if (view instanceof MotionLayout) {
                ((MotionLayout)view).setProgress(this.f(n, n2, view, d));
            }
            else {
                if (this.l) {
                    return false;
                }
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                }
                catch (final NoSuchMethodException ex) {
                    this.l = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, this.f(n, n2, view, d));
                    }
                    catch (final InvocationTargetException ex2) {
                        Log.e("ViewTimeCycle", "unable to setProgress", (Throwable)ex2);
                    }
                    catch (final IllegalAccessException ex3) {
                        Log.e("ViewTimeCycle", "unable to setProgress", (Throwable)ex3);
                    }
                }
            }
            return super.h;
        }
    }
    
    static class f extends d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            view.setRotation(this.f(n, n2, view, d));
            return super.h;
        }
    }
    
    static class g extends d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            view.setRotationX(this.f(n, n2, view, d));
            return super.h;
        }
    }
    
    static class h extends d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            view.setRotationY(this.f(n, n2, view, d));
            return super.h;
        }
    }
    
    static class i extends d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            view.setScaleX(this.f(n, n2, view, d));
            return super.h;
        }
    }
    
    static class j extends d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            view.setScaleY(this.f(n, n2, view, d));
            return super.h;
        }
    }
    
    static class k extends d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            view.setTranslationX(this.f(n, n2, view, d));
            return super.h;
        }
    }
    
    static class l extends d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            view.setTranslationY(this.f(n, n2, view, d));
            return super.h;
        }
    }
    
    static class m extends d
    {
        @Override
        public boolean i(final View view, final float n, final long n2, final d d) {
            view.setTranslationZ(this.f(n, n2, view, d));
            return super.h;
        }
    }
}
