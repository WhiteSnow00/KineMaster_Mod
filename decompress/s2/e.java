// 
// Decompiled by Procyon v0.6.0
// 

package s2;

import android.widget.ImageView;
import android.graphics.drawable.Drawable;

public class e extends f<Drawable>
{
    public e(final ImageView imageView) {
        super(imageView);
    }
    
    @Override
    protected /* bridge */ void h(final Object o) {
        this.j((Drawable)o);
    }
    
    protected void j(final Drawable imageDrawable) {
        ((ImageView)super.a).setImageDrawable(imageDrawable);
    }
}
