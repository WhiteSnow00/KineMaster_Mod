// 
// Decompiled by Procyon v0.6.0
// 

package s2;

import android.graphics.drawable.Drawable;
import v2.l;
import com.bumptech.glide.request.e;

public abstract class c<T> implements i<T>
{
    private final int height;
    private e request;
    private final int width;
    
    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    
    public c(final int width, final int height) {
        if (l.u(width, height)) {
            this.width = width;
            this.height = height;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        sb.append(width);
        sb.append(" and height: ");
        sb.append(height);
        throw new IllegalArgumentException(sb.toString());
    }
    
    @Override
    public final e getRequest() {
        return this.request;
    }
    
    @Override
    public final void getSize(final h h) {
        h.d(this.width, this.height);
    }
    
    @Override
    public void onDestroy() {
    }
    
    @Override
    public void onLoadFailed(final Drawable drawable) {
    }
    
    @Override
    public void onLoadStarted(final Drawable drawable) {
    }
    
    @Override
    public void onStart() {
    }
    
    @Override
    public void onStop() {
    }
    
    @Override
    public final void removeCallback(final h h) {
    }
    
    @Override
    public final void setRequest(final e request) {
        this.request = request;
    }
}
