// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.List;
import java.util.Collections;
import v1.i;
import com.airbnb.lottie.f;
import q1.d;

public class e extends a
{
    private final q1.d z;
    
    e(final com.airbnb.lottie.f f, final Layer layer) {
        super(f, layer);
        (this.z = new q1.d(f, this, new i("__container", layer.l(), false))).b(Collections.emptyList(), Collections.emptyList());
    }
    
    protected void D(final t1.d d, final int n, final List<t1.d> list, final t1.d d2) {
        this.z.d(d, n, list, d2);
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        super.e(rectF, matrix, b);
        this.z.e(rectF, super.m, b);
    }
    
    @Override
    void t(final Canvas canvas, final Matrix matrix, final int n) {
        this.z.g(canvas, matrix, n);
    }
}
