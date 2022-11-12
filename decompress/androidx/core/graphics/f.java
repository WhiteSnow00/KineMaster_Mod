// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.util.d;

public final class f
{
    private static final ThreadLocal<d<Rect, Rect>> a;
    
    static {
        a = new ThreadLocal<d<Rect, Rect>>();
    }
    
    public static boolean a(final Paint paint, final String s) {
        return f.a.a(paint, s);
    }
    
    static class a
    {
        static boolean a(final Paint paint, final String s) {
            return paint.hasGlyph(s);
        }
    }
}
