// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import java.security.MessageDigest;
import e2.d;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.s;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import c2.h;

public class n implements h<Drawable>
{
    private final h<Bitmap> b;
    private final boolean c;
    
    public n(final h<Bitmap> b, final boolean c) {
        this.b = b;
        this.c = c;
    }
    
    private s<Drawable> d(final Context context, final s<Bitmap> s) {
        return (s<Drawable>)t.e(context.getResources(), s);
    }
    
    @Override
    public s<Drawable> a(final Context context, final s<Drawable> s, final int n, final int n2) {
        final d f = com.bumptech.glide.c.c(context).f();
        final Drawable drawable = s.get();
        final s<Bitmap> a = m.a(f, drawable, n, n2);
        if (a == null) {
            if (!this.c) {
                return s;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Unable to convert ");
            sb.append(drawable);
            sb.append(" to a Bitmap");
            throw new IllegalArgumentException(sb.toString());
        }
        else {
            final s<Bitmap> a2 = this.b.a(context, a, n, n2);
            if (a2.equals(a)) {
                a2.b();
                return s;
            }
            return this.d(context, a2);
        }
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }
    
    public h<BitmapDrawable> c() {
        return (h<BitmapDrawable>)this;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof n && this.b.equals(((n)o).b);
    }
    
    @Override
    public int hashCode() {
        return this.b.hashCode();
    }
}
