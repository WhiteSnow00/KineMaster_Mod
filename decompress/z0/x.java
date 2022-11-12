// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class x implements y
{
    private final ViewOverlay a;
    
    x(final View view) {
        this.a = view.getOverlay();
    }
    
    @Override
    public void a(final Drawable drawable) {
        this.a.add(drawable);
    }
    
    @Override
    public void b(final Drawable drawable) {
        this.a.remove(drawable);
    }
}
