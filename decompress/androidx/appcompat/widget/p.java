// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.drawable.ClipDrawable;
import android.graphics.Shader;
import android.graphics.BitmapShader;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.graphics.drawable.f;
import android.util.AttributeSet;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.graphics.Bitmap;
import android.widget.ProgressBar;

class p
{
    private static final int[] c;
    private final ProgressBar a;
    private Bitmap b;
    
    static {
        c = new int[] { 16843067, 16843068 };
    }
    
    p(final ProgressBar a) {
        this.a = a;
    }
    
    private Shape a() {
        return (Shape)new RoundRectShape(new float[] { 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f }, (RectF)null, (float[])null);
    }
    
    private Drawable e(final Drawable drawable) {
        Object o = drawable;
        if (drawable instanceof AnimationDrawable) {
            final AnimationDrawable animationDrawable = (AnimationDrawable)drawable;
            final int numberOfFrames = animationDrawable.getNumberOfFrames();
            o = new AnimationDrawable();
            ((AnimationDrawable)o).setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; ++i) {
                final Drawable d = this.d(animationDrawable.getFrame(i), true);
                d.setLevel(10000);
                ((AnimationDrawable)o).addFrame(d, animationDrawable.getDuration(i));
            }
            ((AnimationDrawable)o).setLevel(10000);
        }
        return (Drawable)o;
    }
    
    Bitmap b() {
        return this.b;
    }
    
    void c(final AttributeSet set, final int n) {
        final r0 v = r0.v(this.a.getContext(), set, p.c, n, 0);
        final Drawable h = v.h(0);
        if (h != null) {
            this.a.setIndeterminateDrawable(this.e(h));
        }
        final Drawable h2 = v.h(1);
        if (h2 != null) {
            this.a.setProgressDrawable(this.d(h2, false));
        }
        v.w();
    }
    
    Drawable d(final Drawable drawable, final boolean b) {
        if (drawable instanceof f) {
            final f f = (f)drawable;
            final Drawable a = f.a();
            if (a != null) {
                f.b(this.d(a, b));
            }
        }
        else {
            if (drawable instanceof LayerDrawable) {
                final LayerDrawable layerDrawable = (LayerDrawable)drawable;
                final int numberOfLayers = layerDrawable.getNumberOfLayers();
                final Drawable[] array = new Drawable[numberOfLayers];
                final int n = 0;
                for (int i = 0; i < numberOfLayers; ++i) {
                    final int id = layerDrawable.getId(i);
                    array[i] = this.d(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                final LayerDrawable layerDrawable2 = new LayerDrawable(array);
                for (int j = n; j < numberOfLayers; ++j) {
                    layerDrawable2.setId(j, layerDrawable.getId(j));
                    p.a.a(layerDrawable, layerDrawable2, j);
                }
                return (Drawable)layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                final BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
                final Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.b == null) {
                    this.b = bitmap;
                }
                final ShapeDrawable shapeDrawable = new ShapeDrawable(this.a());
                shapeDrawable.getPaint().setShader((Shader)new BitmapShader(bitmap, Shader$TileMode.REPEAT, Shader$TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                Object o = shapeDrawable;
                if (b) {
                    o = new ClipDrawable((Drawable)shapeDrawable, 3, 1);
                }
                return (Drawable)o;
            }
        }
        return drawable;
    }
    
    private static class a
    {
        public static void a(final LayerDrawable layerDrawable, final LayerDrawable layerDrawable2, final int n) {
            layerDrawable2.setLayerGravity(n, layerDrawable.getLayerGravity(n));
            layerDrawable2.setLayerWidth(n, layerDrawable.getLayerWidth(n));
            layerDrawable2.setLayerHeight(n, layerDrawable.getLayerHeight(n));
            layerDrawable2.setLayerInsetLeft(n, layerDrawable.getLayerInsetLeft(n));
            layerDrawable2.setLayerInsetRight(n, layerDrawable.getLayerInsetRight(n));
            layerDrawable2.setLayerInsetTop(n, layerDrawable.getLayerInsetTop(n));
            layerDrawable2.setLayerInsetBottom(n, layerDrawable.getLayerInsetBottom(n));
            layerDrawable2.setLayerInsetStart(n, layerDrawable.getLayerInsetStart(n));
            layerDrawable2.setLayerInsetEnd(n, layerDrawable.getLayerInsetEnd(n));
        }
    }
}
