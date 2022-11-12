// 
// Decompiled by Procyon v0.6.0
// 

package t2;

import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

public class b implements d<Drawable>
{
    private final int a;
    private final boolean b;
    
    public b(final int a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public /* bridge */ boolean a(final Object o, final a a) {
        return this.b((Drawable)o, a);
    }
    
    public boolean b(final Drawable drawable, final a a) {
        Object b;
        if ((b = a.b()) == null) {
            b = new ColorDrawable(0);
        }
        final TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[] { (Drawable)b, drawable });
        transitionDrawable.setCrossFadeEnabled(this.b);
        transitionDrawable.startTransition(this.a);
        a.a((Drawable)transitionDrawable);
        return true;
    }
}
