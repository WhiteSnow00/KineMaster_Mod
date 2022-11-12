// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import e2.d;
import com.bumptech.glide.c;
import v2.l;
import com.bumptech.glide.load.engine.s;
import android.content.Context;
import android.graphics.Bitmap;
import c2.h;

public abstract class f implements h<Bitmap>
{
    @Override
    public final s<Bitmap> a(final Context context, s<Bitmap> e, int height, final int n) {
        if (l.u(height, n)) {
            final d f = c.c(context).f();
            final Bitmap bitmap = e.get();
            int width;
            if ((width = height) == Integer.MIN_VALUE) {
                width = bitmap.getWidth();
            }
            if ((height = n) == Integer.MIN_VALUE) {
                height = bitmap.getHeight();
            }
            final Bitmap c = this.c(f, bitmap, width, height);
            if (!bitmap.equals(c)) {
                e = e.e(c, f);
            }
            return e;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot apply transformation on width: ");
        sb.append(height);
        sb.append(" or height: ");
        sb.append(n);
        sb.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
        throw new IllegalArgumentException(sb.toString());
    }
    
    protected abstract Bitmap c(final d p0, final Bitmap p1, final int p2, final int p3);
}
