// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.graphics.Matrix;
import android.view.View;

class b0 extends a0
{
    private static boolean d = true;
    private static boolean e = true;
    
    @Override
    public void g(final View view, final Matrix matrix) {
        if (b0.d) {
            try {
                view.transformMatrixToGlobal(matrix);
            }
            catch (final NoSuchMethodError noSuchMethodError) {
                b0.d = false;
            }
        }
    }
    
    @Override
    public void h(final View view, final Matrix matrix) {
        if (b0.e) {
            try {
                view.transformMatrixToLocal(matrix);
            }
            catch (final NoSuchMethodError noSuchMethodError) {
                b0.e = false;
            }
        }
    }
}
