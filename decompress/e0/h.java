// 
// Decompiled by Procyon v0.6.0
// 

package e0;

import android.graphics.Rect;
import androidx.emoji2.text.e;
import android.view.View;
import android.text.method.TransformationMethod;

class h implements TransformationMethod
{
    private final TransformationMethod a;
    
    h(final TransformationMethod a) {
        this.a = a;
    }
    
    public TransformationMethod a() {
        return this.a;
    }
    
    public CharSequence getTransformation(CharSequence o, final View view) {
        if (view.isInEditMode()) {
            return o;
        }
        final TransformationMethod a = this.a;
        CharSequence transformation = o;
        if (a != null) {
            transformation = a.getTransformation(o, view);
        }
        if ((o = transformation) != null) {
            if (e.b().d() != 1) {
                o = transformation;
            }
            else {
                o = e.b().o(transformation);
            }
        }
        return o;
    }
    
    public void onFocusChanged(final View view, final CharSequence charSequence, final boolean b, final int n, final Rect rect) {
        final TransformationMethod a = this.a;
        if (a != null) {
            a.onFocusChanged(view, charSequence, b, n, rect);
        }
    }
}
