// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view.animation;

import android.view.animation.PathInterpolator;
import android.graphics.Path;
import android.view.animation.Interpolator;

public final class a
{
    public static Interpolator a(final float n, final float n2, final float n3, final float n4) {
        return (Interpolator)a.b(n, n2, n3, n4);
    }
    
    public static Interpolator b(final Path path) {
        return (Interpolator)a.c(path);
    }
    
    static class a
    {
        static PathInterpolator a(final float n, final float n2) {
            return new PathInterpolator(n, n2);
        }
        
        static PathInterpolator b(final float n, final float n2, final float n3, final float n4) {
            return new PathInterpolator(n, n2, n3, n4);
        }
        
        static PathInterpolator c(final Path path) {
            return new PathInterpolator(path);
        }
    }
}
