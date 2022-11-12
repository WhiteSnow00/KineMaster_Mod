// 
// Decompiled by Procyon v0.6.0
// 

package d3;

import android.util.Log;
import e3.b;
import java.util.Iterator;
import android.animation.TimeInterpolator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ObjectAnimator;
import android.util.Property;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;
import android.view.animation.Interpolator;
import f3.f;

public class d
{
    private f a;
    private Interpolator b;
    private int c;
    private long d;
    private int e;
    private Map<String, b> f;
    
    public d(final f a) {
        this.c = -1;
        this.d = 2000L;
        this.e = 0;
        this.f = new HashMap<String, b>();
        this.a = a;
    }
    
    private void e(final int n, final int n2) {
        if (n == n2) {
            return;
        }
        throw new IllegalStateException(String.format(Locale.getDefault(), "The fractions.length must equal values.length, fraction.length[%d], values.length[%d]", n, n2));
    }
    
    private void f(final float[] array, final Property property, final Float[] array2) {
        this.e(array.length, array2.length);
        this.f.put(property.getName(), new a(array, property, array2));
    }
    
    private void g(final float[] array, final Property property, final Integer[] array2) {
        this.e(array.length, array2.length);
        this.f.put(property.getName(), new c(array, property, array2));
    }
    
    public d a(final float[] array, final Integer... array2) {
        this.g(array, f3.f.O, array2);
        return this;
    }
    
    public ObjectAnimator b() {
        final PropertyValuesHolder[] array = new PropertyValuesHolder[this.f.size()];
        final Iterator<Map.Entry<String, b>> iterator = this.f.entrySet().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final b b = ((Map.Entry<K, b>)iterator.next()).getValue();
            final float[] a = b.a;
            final Keyframe[] array2 = new Keyframe[a.length];
            int e = this.e;
            final float n2 = a[e];
            while (true) {
                final int e2 = this.e;
                final T[] c = b.c;
                if (e >= c.length + e2) {
                    break;
                }
                final int n3 = e - e2;
                final int n4 = e % c.length;
                float n6;
                final float n5 = n6 = a[n4] - n2;
                if (n5 < 0.0f) {
                    n6 = n5 + a[a.length - 1];
                }
                if (b instanceof c) {
                    array2[n3] = Keyframe.ofInt(n6, (int)c[n4]);
                }
                else if (b instanceof a) {
                    array2[n3] = Keyframe.ofFloat(n6, (float)c[n4]);
                }
                else {
                    array2[n3] = Keyframe.ofObject(n6, (Object)c[n4]);
                }
                ++e;
            }
            array[n] = PropertyValuesHolder.ofKeyframe(b.b, array2);
            ++n;
        }
        final ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((Object)this.a, array);
        ofPropertyValuesHolder.setDuration(this.d);
        ofPropertyValuesHolder.setRepeatCount(this.c);
        ofPropertyValuesHolder.setInterpolator((TimeInterpolator)this.b);
        return ofPropertyValuesHolder;
    }
    
    public d c(final long d) {
        this.d = d;
        return this;
    }
    
    public d d(final float... array) {
        this.h((Interpolator)e3.b.a(array));
        return this;
    }
    
    public d h(final Interpolator b) {
        this.b = b;
        return this;
    }
    
    public d i(final float[] array, final Integer... array2) {
        this.g(array, f3.f.F, array2);
        return this;
    }
    
    public d j(final float[] array, final Integer... array2) {
        this.g(array, f3.f.E, array2);
        return this;
    }
    
    public d k(final float[] array, final Integer... array2) {
        this.g(array, f3.f.G, array2);
        return this;
    }
    
    public d l(final float[] array, final Float... array2) {
        this.f(array, f3.f.N, array2);
        return this;
    }
    
    public d m(final float[] array, final Float... array2) {
        this.f(array, f3.f.M, array2);
        return this;
    }
    
    public d n(final int n) {
        int e = n;
        if (n < 0) {
            Log.w("SpriteAnimatorBuilder", "startFrame should always be non-negative");
            e = 0;
        }
        this.e = e;
        return this;
    }
    
    public d o(final float[] array, final Float... array2) {
        this.f(array, f3.f.J, array2);
        return this;
    }
    
    public d p(final float[] array, final Float... array2) {
        this.f(array, f3.f.K, array2);
        return this;
    }
    
    class a extends b<Float>
    {
        final d e;
        
        public a(final d e, final float[] array, final Property property, final Float[] array2) {
            super(array, property, array2);
        }
    }
    
    class b<T>
    {
        float[] a;
        Property b;
        T[] c;
        final d d;
        
        public b(final d d, final float[] a, final Property b, final T[] c) {
            this.d = d;
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    class c extends b<Integer>
    {
        final d e;
        
        public c(final d e, final float[] array, final Property property, final Integer[] array2) {
            super(array, property, array2);
        }
    }
}
