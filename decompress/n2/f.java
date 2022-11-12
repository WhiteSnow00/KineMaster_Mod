// 
// Decompiled by Procyon v0.6.0
// 

package n2;

import java.security.MessageDigest;
import com.bumptech.glide.load.resource.bitmap.e;
import com.bumptech.glide.load.engine.s;
import android.content.Context;
import v2.k;
import android.graphics.Bitmap;
import c2.h;

public class f implements h<c>
{
    private final h<Bitmap> b;
    
    public f(final h<Bitmap> h) {
        this.b = k.d(h);
    }
    
    @Override
    public s<c> a(final Context context, final s<c> s, final int n, final int n2) {
        final c c = s.get();
        final e e = new e(c.e(), com.bumptech.glide.c.c(context).f());
        final s<Bitmap> a = this.b.a(context, e, n, n2);
        if (!e.equals(a)) {
            e.b();
        }
        c.n(this.b, a.get());
        return s;
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof f && this.b.equals(((f)o).b);
    }
    
    @Override
    public int hashCode() {
        return this.b.hashCode();
    }
}
