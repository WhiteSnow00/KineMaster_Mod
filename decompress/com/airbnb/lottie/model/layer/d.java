// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.f;

public class d extends a
{
    d(final com.airbnb.lottie.f f, final Layer layer) {
        super(f, layer);
    }
    
    @Override
    public void e(final RectF rectF, final Matrix matrix, final boolean b) {
        super.e(rectF, matrix, b);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
    
    @Override
    void t(final Canvas canvas, final Matrix matrix, final int n) {
    }
}
