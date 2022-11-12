// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.os.Build$VERSION;
import android.widget.EdgeEffect;
import android.util.AttributeSet;
import android.content.Context;

public final class i
{
    public static EdgeEffect a(final Context context, final AttributeSet set) {
        if (Build$VERSION.SDK_INT >= 31) {
            return b.a(context, set);
        }
        return new EdgeEffect(context);
    }
    
    public static float b(final EdgeEffect edgeEffect) {
        if (Build$VERSION.SDK_INT >= 31) {
            return b.b(edgeEffect);
        }
        return 0.0f;
    }
    
    public static void c(final EdgeEffect edgeEffect, final float n, final float n2) {
        a.a(edgeEffect, n, n2);
    }
    
    public static float d(final EdgeEffect edgeEffect, final float n, final float n2) {
        if (Build$VERSION.SDK_INT >= 31) {
            return b.c(edgeEffect, n, n2);
        }
        c(edgeEffect, n, n2);
        return n;
    }
    
    static class a
    {
        static void a(final EdgeEffect edgeEffect, final float n, final float n2) {
            edgeEffect.onPull(n, n2);
        }
    }
    
    private static class b
    {
        public static EdgeEffect a(final Context context, final AttributeSet set) {
            try {
                return new EdgeEffect(context, set);
            }
            finally {
                return new EdgeEffect(context);
            }
        }
        
        public static float b(final EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            }
            finally {
                return 0.0f;
            }
        }
        
        public static float c(final EdgeEffect edgeEffect, final float n, final float n2) {
            try {
                return edgeEffect.onPullDistance(n, n2);
            }
            finally {
                edgeEffect.onPull(n, n2);
                return 0.0f;
            }
        }
    }
}
