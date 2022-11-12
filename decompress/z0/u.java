// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class u implements v
{
    private final ViewGroupOverlay a;
    
    u(final ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }
    
    @Override
    public void a(final Drawable drawable) {
        this.a.add(drawable);
    }
    
    @Override
    public void b(final Drawable drawable) {
        this.a.remove(drawable);
    }
    
    @Override
    public void c(final View view) {
        this.a.add(view);
    }
    
    @Override
    public void d(final View view) {
        this.a.remove(view);
    }
}
