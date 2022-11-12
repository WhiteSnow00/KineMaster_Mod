// 
// Decompiled by Procyon v0.6.0
// 

package l2;

import com.bumptech.glide.load.engine.s;
import android.graphics.drawable.Drawable;

final class e extends c<Drawable>
{
    private e(final Drawable drawable) {
        super(drawable);
    }
    
    static s<Drawable> e(final Drawable drawable) {
        e e;
        if (drawable != null) {
            e = new e(drawable);
        }
        else {
            e = null;
        }
        return e;
    }
    
    @Override
    public int a() {
        return Math.max(1, super.a.getIntrinsicWidth() * super.a.getIntrinsicHeight() * 4);
    }
    
    @Override
    public void b() {
    }
    
    @Override
    public Class<Drawable> c() {
        return (Class<Drawable>)super.a.getClass();
    }
}
