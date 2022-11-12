// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.view.View;

class a0 extends f0
{
    private static boolean c = true;
    
    @Override
    public void a(final View view) {
    }
    
    @Override
    public float b(final View view) {
        if (a0.c) {
            try {
                return view.getTransitionAlpha();
            }
            catch (final NoSuchMethodError noSuchMethodError) {
                a0.c = false;
            }
        }
        return view.getAlpha();
    }
    
    @Override
    public void c(final View view) {
    }
    
    @Override
    public void e(final View view, final float n) {
        if (a0.c) {
            try {
                view.setTransitionAlpha(n);
                return;
            }
            catch (final NoSuchMethodError noSuchMethodError) {
                a0.c = false;
            }
        }
        view.setAlpha(n);
    }
}
