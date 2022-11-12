// 
// Decompiled by Procyon v0.6.0
// 

package s2;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.graphics.drawable.Animatable;
import t2.d;
import android.widget.ImageView;

public abstract class f<Z> extends j<ImageView, Z> implements d.a
{
    private Animatable h;
    
    public f(final ImageView imageView) {
        super((View)imageView);
    }
    
    private void g(final Z b) {
        if (b instanceof Animatable) {
            (this.h = (Animatable)b).start();
        }
        else {
            this.h = null;
        }
    }
    
    private void i(final Z b) {
        this.h(b);
        this.g(b);
    }
    
    @Override
    public void a(final Drawable imageDrawable) {
        ((ImageView)super.a).setImageDrawable(imageDrawable);
    }
    
    @Override
    public Drawable b() {
        return ((ImageView)super.a).getDrawable();
    }
    
    protected abstract void h(final Z p0);
    
    @Override
    public void onLoadCleared(final Drawable drawable) {
        super.onLoadCleared(drawable);
        final Animatable h = this.h;
        if (h != null) {
            h.stop();
        }
        this.i(null);
        this.a(drawable);
    }
    
    @Override
    public void onLoadFailed(final Drawable drawable) {
        super.onLoadFailed(drawable);
        this.i(null);
        this.a(drawable);
    }
    
    @Override
    public void onLoadStarted(final Drawable drawable) {
        super.onLoadStarted(drawable);
        this.i(null);
        this.a(drawable);
    }
    
    @Override
    public void onResourceReady(final Z b, final d<? super Z> d) {
        if (d != null && d.a(b, (d.a)this)) {
            this.g(b);
        }
        else {
            this.i(b);
        }
    }
    
    @Override
    public void onStart() {
        final Animatable h = this.h;
        if (h != null) {
            h.start();
        }
    }
    
    @Override
    public void onStop() {
        final Animatable h = this.h;
        if (h != null) {
            h.stop();
        }
    }
}
