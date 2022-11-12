// 
// Decompiled by Procyon v0.6.0
// 

package z1;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.d;

public class a<T>
{
    private final d a;
    public final T b;
    public T c;
    public final Interpolator d;
    public final Interpolator e;
    public final Interpolator f;
    public final float g;
    public Float h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;
    public PointF o;
    public PointF p;
    
    public a(final d a, final T b, final T c, final Interpolator d, final float g, final Float h) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = null;
        this.f = null;
        this.g = g;
        this.h = h;
    }
    
    public a(final d a, final T b, final T c, final Interpolator e, final Interpolator f, final float g, final Float h) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = null;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    protected a(final d a, final T b, final T c, final Interpolator d, final Interpolator e, final Interpolator f, final float g, final Float h) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public a(final T t) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = null;
        this.b = t;
        this.c = t;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = Float.MIN_VALUE;
        this.h = Float.MAX_VALUE;
    }
    
    public boolean a(final float n) {
        return n >= this.e() && n < this.b();
    }
    
    public float b() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.n == Float.MIN_VALUE) {
            if (this.h == null) {
                this.n = 1.0f;
            }
            else {
                this.n = this.e() + (this.h - this.g) / this.a.e();
            }
        }
        return this.n;
    }
    
    public float c() {
        if (this.j == -3987645.8f) {
            this.j = (float)this.c;
        }
        return this.j;
    }
    
    public int d() {
        if (this.l == 784923401) {
            this.l = (int)this.c;
        }
        return this.l;
    }
    
    public float e() {
        final d a = this.a;
        if (a == null) {
            return 0.0f;
        }
        if (this.m == Float.MIN_VALUE) {
            this.m = (this.g - a.o()) / this.a.e();
        }
        return this.m;
    }
    
    public float f() {
        if (this.i == -3987645.8f) {
            this.i = (float)this.b;
        }
        return this.i;
    }
    
    public int g() {
        if (this.k == 784923401) {
            this.k = (int)this.b;
        }
        return this.k;
    }
    
    public boolean h() {
        return this.d == null && this.e == null && this.f == null;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Keyframe{startValue=");
        sb.append(this.b);
        sb.append(", endValue=");
        sb.append(this.c);
        sb.append(", startFrame=");
        sb.append(this.g);
        sb.append(", endFrame=");
        sb.append(this.h);
        sb.append(", interpolator=");
        sb.append(this.d);
        sb.append('}');
        return sb.toString();
    }
}
