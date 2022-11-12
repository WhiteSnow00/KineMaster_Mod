// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics.drawable;

import android.graphics.Rect;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.o;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\b" }, d2 = { "Landroid/graphics/drawable/Drawable;", "", "width", "height", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "a", "core-ktx_release" }, k = 2, mv = { 1, 6, 0 })
public final class b
{
    public static final Bitmap a(final Drawable drawable, final int n, final int n2, final Bitmap$Config bitmap$Config) {
        o.g((Object)drawable, "<this>");
        if (drawable instanceof BitmapDrawable) {
            final BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            }
            if (bitmap$Config == null || bitmapDrawable.getBitmap().getConfig() == bitmap$Config) {
                if (n == bitmapDrawable.getBitmap().getWidth() && n2 == bitmapDrawable.getBitmap().getHeight()) {
                    final Bitmap bitmap = bitmapDrawable.getBitmap();
                    o.f((Object)bitmap, "bitmap");
                    return bitmap;
                }
                final Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), n, n2, true);
                o.f((Object)scaledBitmap, "createScaledBitmap(bitmap, width, height, true)");
                return scaledBitmap;
            }
        }
        final Rect bounds = drawable.getBounds();
        o.f((Object)bounds, "bounds");
        final int left = bounds.left;
        final int top = bounds.top;
        final int right = bounds.right;
        final int bottom = bounds.bottom;
        Bitmap$Config argb_8888;
        if ((argb_8888 = bitmap$Config) == null) {
            argb_8888 = Bitmap$Config.ARGB_8888;
        }
        final Bitmap bitmap2 = Bitmap.createBitmap(n, n2, argb_8888);
        drawable.setBounds(0, 0, n, n2);
        drawable.draw(new Canvas(bitmap2));
        drawable.setBounds(left, top, right, bottom);
        o.f((Object)bitmap2, "bitmap");
        return bitmap2;
    }
    
    public static Bitmap b(final Drawable drawable, int intrinsicWidth, int intrinsicHeight, Bitmap$Config bitmap$Config, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        if ((n & 0x2) != 0x0) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        if ((n & 0x4) != 0x0) {
            bitmap$Config = null;
        }
        return a(drawable, intrinsicWidth, intrinsicHeight, bitmap$Config);
    }
}
