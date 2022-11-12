// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.graphics.Matrix;
import android.view.View;

class e0 extends d0
{
    @Override
    public float b(final View view) {
        return view.getTransitionAlpha();
    }
    
    @Override
    public void d(final View view, final int n, final int n2, final int n3, final int n4) {
        view.setLeftTopRightBottom(n, n2, n3, n4);
    }
    
    @Override
    public void e(final View view, final float transitionAlpha) {
        view.setTransitionAlpha(transitionAlpha);
    }
    
    @Override
    public void f(final View view, final int transitionVisibility) {
        view.setTransitionVisibility(transitionVisibility);
    }
    
    @Override
    public void g(final View view, final Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }
    
    @Override
    public void h(final View view, final Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
