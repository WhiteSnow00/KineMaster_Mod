// 
// Decompiled by Procyon v0.6.0
// 

package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

class e extends Drawable
{
    private static final double a;
    
    static {
        a = Math.cos(Math.toRadians(45.0));
    }
    
    static float a(final float n, final float n2, final boolean b) {
        float n3 = n;
        if (b) {
            n3 = (float)(n + (1.0 - e.a) * n2);
        }
        return n3;
    }
    
    static float b(final float n, final float n2, final boolean b) {
        if (b) {
            return (float)(n * 1.5f + (1.0 - e.a) * n2);
        }
        return n * 1.5f;
    }
}
