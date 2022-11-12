// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import android.graphics.BlendModeColorFilter;
import android.graphics.BlendMode;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build$VERSION;
import android.graphics.ColorFilter;

public class b
{
    public static ColorFilter a(final int n, final BlendModeCompat blendModeCompat) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        final ColorFilter colorFilter = null;
        final ColorFilter colorFilter2 = null;
        if (sdk_INT >= 29) {
            final Object a = c.b.a(blendModeCompat);
            ColorFilter a2 = colorFilter2;
            if (a != null) {
                a2 = b.a.a(n, a);
            }
            return a2;
        }
        final PorterDuff$Mode a3 = c.a(blendModeCompat);
        Object o = colorFilter;
        if (a3 != null) {
            o = new PorterDuffColorFilter(n, a3);
        }
        return (ColorFilter)o;
    }
    
    static class a
    {
        static ColorFilter a(final int n, final Object o) {
            return (ColorFilter)new BlendModeColorFilter(n, (BlendMode)o);
        }
    }
}
