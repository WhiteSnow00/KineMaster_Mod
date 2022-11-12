// 
// Decompiled by Procyon v0.6.0
// 

package o2;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.s;
import android.graphics.Bitmap;
import e2.d;
import android.graphics.drawable.Drawable;

public final class c implements e<Drawable, byte[]>
{
    private final d a;
    private final e<Bitmap, byte[]> b;
    private final e<n2.c, byte[]> c;
    
    public c(final d a, final e<Bitmap, byte[]> b, final e<n2.c, byte[]> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private static s<n2.c> b(final s<Drawable> s) {
        return (s<n2.c>)s;
    }
    
    @Override
    public s<byte[]> a(final s<Drawable> s, final c2.e e) {
        final Drawable drawable = s.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(com.bumptech.glide.load.resource.bitmap.e.e(((BitmapDrawable)drawable).getBitmap(), this.a), e);
        }
        if (drawable instanceof n2.c) {
            return this.c.a(b(s), e);
        }
        return null;
    }
}
