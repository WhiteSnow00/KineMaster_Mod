// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.Gravity;
import android.graphics.Rect;

public final class f
{
    public static void a(final int n, final int n2, final int n3, final Rect rect, final Rect rect2, final int n4) {
        a.b(n, n2, n3, rect, rect2, n4);
    }
    
    public static int b(final int n, final int n2) {
        return Gravity.getAbsoluteGravity(n, n2);
    }
    
    static class a
    {
        static void a(final int n, final int n2, final int n3, final Rect rect, final int n4, final int n5, final Rect rect2, final int n6) {
            Gravity.apply(n, n2, n3, rect, n4, n5, rect2, n6);
        }
        
        static void b(final int n, final int n2, final int n3, final Rect rect, final Rect rect2, final int n4) {
            Gravity.apply(n, n2, n3, rect, rect2, n4);
        }
        
        static void c(final int n, final Rect rect, final Rect rect2, final int n2) {
            Gravity.applyDisplay(n, rect, rect2, n2);
        }
    }
}
