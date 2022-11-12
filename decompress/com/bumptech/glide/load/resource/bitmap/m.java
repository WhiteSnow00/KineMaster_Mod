// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import java.util.concurrent.locks.Lock;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import android.util.Log;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.s;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import e2.e;
import e2.d;

final class m
{
    private static final d a;
    
    static {
        a = new e() {
            @Override
            public void c(final Bitmap bitmap) {
            }
        };
    }
    
    static s<Bitmap> a(d a, Drawable current, int n, final int n2) {
        current = current.getCurrent();
        final boolean b = current instanceof BitmapDrawable;
        final int n3 = 0;
        Bitmap bitmap;
        if (b) {
            bitmap = ((BitmapDrawable)current).getBitmap();
            n = n3;
        }
        else if (!(current instanceof Animatable)) {
            bitmap = b(a, current, n, n2);
            n = 1;
        }
        else {
            bitmap = null;
            n = n3;
        }
        if (n == 0) {
            a = m.a;
        }
        return com.bumptech.glide.load.resource.bitmap.e.e(bitmap, a);
    }
    
    private static Bitmap b(final d d, final Drawable drawable, int intrinsicWidth, int intrinsicHeight) {
        if (intrinsicWidth == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to draw ");
                sb.append(drawable);
                sb.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                Log.w("DrawableToBitmap", sb.toString());
            }
            return null;
        }
        if (intrinsicHeight == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to draw ");
                sb2.append(drawable);
                sb2.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                Log.w("DrawableToBitmap", sb2.toString());
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        final Lock i = y.i();
        i.lock();
        final Bitmap d2 = d.d(intrinsicWidth, intrinsicHeight, Bitmap$Config.ARGB_8888);
        try {
            final Canvas canvas = new Canvas(d2);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            canvas.setBitmap((Bitmap)null);
            return d2;
        }
        finally {
            i.unlock();
        }
    }
}
