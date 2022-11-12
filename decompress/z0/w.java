// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.os.Build$VERSION;
import android.view.ViewGroup;

class w
{
    private static boolean a = true;
    
    static v a(final ViewGroup viewGroup) {
        return new u(viewGroup);
    }
    
    private static void b(final ViewGroup viewGroup, final boolean b) {
        if (w.a) {
            try {
                viewGroup.suppressLayout(b);
            }
            catch (final NoSuchMethodError noSuchMethodError) {
                w.a = false;
            }
        }
    }
    
    static void c(final ViewGroup viewGroup, final boolean b) {
        if (Build$VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(b);
        }
        else {
            b(viewGroup, b);
        }
    }
}
