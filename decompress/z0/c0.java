// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.view.View;

class c0 extends b0
{
    private static boolean f = true;
    
    @Override
    public void d(final View view, final int n, final int n2, final int n3, final int n4) {
        if (c0.f) {
            try {
                view.setLeftTopRightBottom(n, n2, n3, n4);
            }
            catch (final NoSuchMethodError noSuchMethodError) {
                c0.f = false;
            }
        }
    }
}
