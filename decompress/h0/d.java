// 
// Decompiled by Procyon v0.6.0
// 

package h0;

import android.view.animation.Interpolator;

abstract class d implements Interpolator
{
    private final float[] a;
    private final float b;
    
    protected d(final float[] a) {
        this.a = a;
        this.b = 1.0f / (a.length - 1);
    }
    
    public float getInterpolation(float n) {
        if (n >= 1.0f) {
            return 1.0f;
        }
        if (n <= 0.0f) {
            return 0.0f;
        }
        final float[] a = this.a;
        final int min = Math.min((int)((a.length - 1) * n), a.length - 2);
        final float n2 = (float)min;
        final float b = this.b;
        n = (n - n2 * b) / b;
        final float[] a2 = this.a;
        return a2[min] + n * (a2[min + 1] - a2[min]);
    }
}
