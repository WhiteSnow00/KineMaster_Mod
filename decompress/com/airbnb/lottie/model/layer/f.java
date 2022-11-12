// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.layer;

import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Matrix;
import r1.p;
import com.airbnb.lottie.k;
import z1.c;
import android.graphics.Paint$Style;
import android.graphics.RectF;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Paint;

public class f extends a
{
    private final Paint A;
    private final float[] B;
    private final Path C;
    private final Layer D;
    private r1.a<ColorFilter, ColorFilter> E;
    private final RectF z;
    
    f(final com.airbnb.lottie.f f, final Layer d) {
        super(f, d);
        this.z = new RectF();
        final p1.a a = new p1.a();
        this.A = a;
        this.B = new float[8];
        this.C = new Path();
        this.D = d;
        a.setAlpha(0);
        a.setStyle(Paint$Style.FILL);
        a.setColor(d.m());
    }
    
    @Override
    public <T> void c(final T t, final c<T> c) {
        super.c(t, c);
        if (t == com.airbnb.lottie.k.E) {
            if (c == null) {
                this.E = null;
            }
            else {
                this.E = new p<ColorFilter, ColorFilter>((c<ColorFilter>)c);
            }
        }
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        super.e(rectF, matrix, b);
        this.z.set(0.0f, 0.0f, (float)this.D.o(), (float)this.D.n());
        super.m.mapRect(this.z);
        rectF.set(this.z);
    }
    
    public void t(final Canvas canvas, final Matrix matrix, int alpha) {
        final int alpha2 = Color.alpha(this.D.m());
        if (alpha2 == 0) {
            return;
        }
        int intValue;
        if (super.v.h() == null) {
            intValue = 100;
        }
        else {
            intValue = super.v.h().h();
        }
        alpha = (int)(alpha / 255.0f * (alpha2 / 255.0f * intValue / 100.0f) * 255.0f);
        this.A.setAlpha(alpha);
        final r1.a<ColorFilter, ColorFilter> e = this.E;
        if (e != null) {
            this.A.setColorFilter((ColorFilter)e.h());
        }
        if (alpha > 0) {
            final float[] b = this.B;
            b[1] = (b[0] = 0.0f);
            b[2] = (float)this.D.o();
            final float[] b2 = this.B;
            b2[3] = 0.0f;
            b2[4] = (float)this.D.o();
            this.B[5] = (float)this.D.n();
            final float[] b3 = this.B;
            b3[6] = 0.0f;
            b3[7] = (float)this.D.n();
            matrix.mapPoints(this.B);
            this.C.reset();
            final Path c = this.C;
            final float[] b4 = this.B;
            c.moveTo(b4[0], b4[1]);
            final Path c2 = this.C;
            final float[] b5 = this.B;
            c2.lineTo(b5[2], b5[3]);
            final Path c3 = this.C;
            final float[] b6 = this.B;
            c3.lineTo(b6[4], b6[5]);
            final Path c4 = this.C;
            final float[] b7 = this.B;
            c4.lineTo(b7[6], b7[7]);
            final Path c5 = this.C;
            final float[] b8 = this.B;
            c5.lineTo(b8[0], b8[1]);
            this.C.close();
            canvas.drawPath(this.C, this.A);
        }
    }
}
