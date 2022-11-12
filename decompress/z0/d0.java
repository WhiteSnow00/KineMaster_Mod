// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.os.Build$VERSION;
import android.view.View;

class d0 extends c0
{
    private static boolean g = true;
    
    @Override
    public void f(final View view, final int transitionVisibility) {
        if (Build$VERSION.SDK_INT == 28) {
            super.f(view, transitionVisibility);
        }
        else if (d0.g) {
            try {
                view.setTransitionVisibility(transitionVisibility);
            }
            catch (final NoSuchMethodError noSuchMethodError) {
                d0.g = false;
            }
        }
    }
}
