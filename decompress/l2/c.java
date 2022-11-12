// 
// Decompiled by Procyon v0.6.0
// 

package l2;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable$ConstantState;
import v2.k;
import com.bumptech.glide.load.engine.o;
import com.bumptech.glide.load.engine.s;
import android.graphics.drawable.Drawable;

public abstract class c<T extends Drawable> implements s<T>, o
{
    protected final T a;
    
    public c(final T t) {
        this.a = k.d(t);
    }
    
    public final T d() {
        final Drawable$ConstantState constantState = this.a.getConstantState();
        if (constantState == null) {
            return this.a;
        }
        return (T)constantState.newDrawable();
    }
    
    @Override
    public /* bridge */ Object get() {
        return this.d();
    }
    
    @Override
    public void initialize() {
        final Drawable a = this.a;
        if (a instanceof BitmapDrawable) {
            ((BitmapDrawable)a).getBitmap().prepareToDraw();
        }
        else if (a instanceof n2.c) {
            ((n2.c)a).e().prepareToDraw();
        }
    }
}
