// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import y1.h;
import android.graphics.Matrix;
import android.graphics.RectF;
import r1.p;
import com.airbnb.lottie.k;
import android.graphics.Bitmap;
import com.airbnb.lottie.f;
import android.graphics.Paint;
import android.graphics.ColorFilter;
import android.graphics.Rect;

public class c extends a
{
    private final Rect A;
    private final Rect B;
    private r1.a<ColorFilter, ColorFilter> C;
    private final Paint z;
    
    c(final com.airbnb.lottie.f f, final Layer layer) {
        super(f, layer);
        this.z = new p1.a(3);
        this.A = new Rect();
        this.B = new Rect();
    }
    
    private Bitmap K() {
        return super.n.t(super.o.k());
    }
    
    @Override
    public <T> void c(final T t, final z1.c<T> c) {
        super.c(t, c);
        if (t == com.airbnb.lottie.k.E) {
            if (c == null) {
                this.C = null;
            }
            else {
                this.C = new p<ColorFilter, ColorFilter>((z1.c<ColorFilter>)c);
            }
        }
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        super.e(rectF, matrix, b);
        final Bitmap k = this.K();
        if (k != null) {
            rectF.set(0.0f, 0.0f, k.getWidth() * y1.h.e(), k.getHeight() * y1.h.e());
            super.m.mapRect(rectF);
        }
    }
    
    public void t(final Canvas canvas, final Matrix matrix, final int alpha) {
        final Bitmap k = this.K();
        if (k != null) {
            if (!k.isRecycled()) {
                final float e = y1.h.e();
                this.z.setAlpha(alpha);
                final r1.a<ColorFilter, ColorFilter> c = this.C;
                if (c != null) {
                    this.z.setColorFilter((ColorFilter)c.h());
                }
                canvas.save();
                canvas.concat(matrix);
                this.A.set(0, 0, k.getWidth(), k.getHeight());
                this.B.set(0, 0, (int)(k.getWidth() * e), (int)(k.getHeight() * e));
                canvas.drawBitmap(k, this.A, this.B, this.z);
                canvas.restore();
            }
        }
    }
}
