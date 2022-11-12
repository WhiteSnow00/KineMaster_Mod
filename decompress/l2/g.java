// 
// Decompiled by Procyon v0.6.0
// 

package l2;

import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import android.graphics.drawable.Drawable;
import c2.f;

public class g implements f<Drawable, Drawable>
{
    @Override
    public /* bridge */ s a(final Object o, final int n, final int n2, final e e) throws IOException {
        return this.c((Drawable)o, n, n2, e);
    }
    
    @Override
    public /* bridge */ boolean b(final Object o, final e e) throws IOException {
        return this.d((Drawable)o, e);
    }
    
    public s<Drawable> c(final Drawable drawable, final int n, final int n2, final e e) {
        return e.e(drawable);
    }
    
    public boolean d(final Drawable drawable, final e e) {
        return true;
    }
}
