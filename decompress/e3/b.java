// 
// Decompiled by Procyon v0.6.0
// 

package e3;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

public class b implements Interpolator
{
    private TimeInterpolator a;
    private float[] b;
    
    public b(final TimeInterpolator a, final float... b) {
        this.a = a;
        this.b = b;
    }
    
    public static b a(final float... array) {
        final b b = new b((TimeInterpolator)a.a(), new float[0]);
        b.c(array);
        return b;
    }
    
    public static b b(final float n, final float n2, final float n3, final float n4, final float... array) {
        final b b = new b((TimeInterpolator)c.a(n, n2, n3, n4), new float[0]);
        b.c(array);
        return b;
    }
    
    public void c(final float... b) {
        this.b = b;
    }
    
    public float getInterpolation(float n) {
        synchronized (this) {
            if (this.b.length > 1) {
                int n2 = 0;
                while (true) {
                    final float[] b = this.b;
                    if (n2 >= b.length - 1) {
                        break;
                    }
                    final float n3 = b[n2];
                    final int n4 = n2 + 1;
                    final float n5 = b[n4];
                    final float n6 = n5 - n3;
                    n2 = n4;
                    if (n < n3) {
                        continue;
                    }
                    n2 = n4;
                    if (n <= n5) {
                        n = (n - n3) / n6;
                        n = this.a.getInterpolation(n);
                        monitorexit(this);
                        return n3 + n * n6;
                    }
                }
            }
            n = this.a.getInterpolation(n);
            return n;
        }
    }
}
