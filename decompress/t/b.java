// 
// Decompiled by Procyon v0.6.0
// 

package t;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import android.view.View;
import o.e;

public abstract class b extends o.e
{
    public static b h(final String s) {
        if (s.startsWith("CUSTOM")) {
            return new b();
        }
        int n = -1;
        switch (s) {
            case "waveOffset": {
                n = 13;
                break;
            }
            case "alpha": {
                n = 12;
                break;
            }
            case "transitionPathRotate": {
                n = 11;
                break;
            }
            case "elevation": {
                n = 10;
                break;
            }
            case "rotation": {
                n = 9;
                break;
            }
            case "waveVariesBy": {
                n = 8;
                break;
            }
            case "scaleY": {
                n = 7;
                break;
            }
            case "scaleX": {
                n = 6;
                break;
            }
            case "progress": {
                n = 5;
                break;
            }
            case "translationZ": {
                n = 4;
                break;
            }
            case "translationY": {
                n = 3;
                break;
            }
            case "translationX": {
                n = 2;
                break;
            }
            case "rotationY": {
                n = 1;
                break;
            }
            case "rotationX": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                return null;
            }
            case 13: {
                return new a();
            }
            case 12: {
                return new a();
            }
            case 11: {
                return new d();
            }
            case 10: {
                return new c();
            }
            case 9: {
                return new f();
            }
            case 8: {
                return new a();
            }
            case 7: {
                return new j();
            }
            case 6: {
                return new i();
            }
            case 5: {
                return new e();
            }
            case 4: {
                return new m();
            }
            case 3: {
                return new l();
            }
            case 2: {
                return new k();
            }
            case 1: {
                return new h();
            }
            case 0: {
                return new g();
            }
        }
    }
    
    public abstract void i(final View p0, final float p1);
    
    static class a extends b
    {
        @Override
        public void i(final View view, final float n) {
            view.setAlpha(this.a(n));
        }
    }
    
    static class b extends t.b
    {
        float[] h;
        protected ConstraintAttribute i;
        
        b() {
            this.h = new float[1];
        }
        
        @Override
        protected void b(final Object o) {
            this.i = (ConstraintAttribute)o;
        }
        
        @Override
        public void i(final View view, final float n) {
            this.h[0] = this.a(n);
            t.a.b(this.i, view, this.h);
        }
    }
    
    static class c extends b
    {
        @Override
        public void i(final View view, final float n) {
            view.setElevation(this.a(n));
        }
    }
    
    public static class d extends b
    {
        @Override
        public void i(final View view, final float n) {
        }
        
        public void j(final View view, final float n, final double n2, final double n3) {
            view.setRotation(this.a(n) + (float)Math.toDegrees(Math.atan2(n3, n2)));
        }
    }
    
    static class e extends b
    {
        boolean h;
        
        e() {
            this.h = false;
        }
        
        @Override
        public void i(final View view, final float n) {
            if (view instanceof MotionLayout) {
                ((MotionLayout)view).setProgress(this.a(n));
            }
            else {
                if (this.h) {
                    return;
                }
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                }
                catch (final NoSuchMethodException ex) {
                    this.h = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, this.a(n));
                    }
                    catch (final InvocationTargetException ex2) {
                        Log.e("ViewOscillator", "unable to setProgress", (Throwable)ex2);
                    }
                    catch (final IllegalAccessException ex3) {
                        Log.e("ViewOscillator", "unable to setProgress", (Throwable)ex3);
                    }
                }
            }
        }
    }
    
    static class f extends b
    {
        @Override
        public void i(final View view, final float n) {
            view.setRotation(this.a(n));
        }
    }
    
    static class g extends b
    {
        @Override
        public void i(final View view, final float n) {
            view.setRotationX(this.a(n));
        }
    }
    
    static class h extends b
    {
        @Override
        public void i(final View view, final float n) {
            view.setRotationY(this.a(n));
        }
    }
    
    static class i extends b
    {
        @Override
        public void i(final View view, final float n) {
            view.setScaleX(this.a(n));
        }
    }
    
    static class j extends b
    {
        @Override
        public void i(final View view, final float n) {
            view.setScaleY(this.a(n));
        }
    }
    
    static class k extends b
    {
        @Override
        public void i(final View view, final float n) {
            view.setTranslationX(this.a(n));
        }
    }
    
    static class l extends b
    {
        @Override
        public void i(final View view, final float n) {
            view.setTranslationY(this.a(n));
        }
    }
    
    static class m extends b
    {
        @Override
        public void i(final View view, final float n) {
            view.setTranslationZ(this.a(n));
        }
    }
}
