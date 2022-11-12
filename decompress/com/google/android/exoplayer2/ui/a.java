// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import android.graphics.Canvas;
import android.text.Layout$Alignment;
import java.util.Collections;
import java.util.ArrayList;
import android.util.AttributeSet;
import android.content.Context;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import android.view.View;

final class a extends View implements SubtitleView.a
{
    private final List<y> a;
    private List<Cue> b;
    private int c;
    private float d;
    private CaptionStyleCompat e;
    private float f;
    
    public a(final Context context) {
        this(context, null);
    }
    
    public a(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = new ArrayList<y>();
        this.b = Collections.emptyList();
        this.c = 0;
        this.d = 0.0533f;
        this.e = CaptionStyleCompat.g;
        this.f = 0.08f;
    }
    
    private static Cue b(final Cue cue) {
        final Cue.Builder p = cue.b().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        if (cue.f == 0) {
            p.h(1.0f - cue.e, 0);
        }
        else {
            p.h(-cue.e - 1.0f, 1);
        }
        final int g = cue.g;
        if (g != 0) {
            if (g == 2) {
                p.i(0);
            }
        }
        else {
            p.i(2);
        }
        return p.a();
    }
    
    public void a(final List<Cue> b, final CaptionStyleCompat e, final float d, final int c, final float f) {
        this.b = b;
        this.e = e;
        this.d = d;
        this.c = c;
        this.f = f;
        while (this.a.size() < b.size()) {
            this.a.add(new y(this.getContext()));
        }
        this.invalidate();
    }
    
    public void dispatchDraw(final Canvas canvas) {
        final List<Cue> b = this.b;
        if (b.isEmpty()) {
            return;
        }
        final int height = this.getHeight();
        final int paddingLeft = this.getPaddingLeft();
        final int paddingTop = this.getPaddingTop();
        final int n = this.getWidth() - this.getPaddingRight();
        final int n2 = height - this.getPaddingBottom();
        if (n2 > paddingTop) {
            if (n > paddingLeft) {
                final int n3 = n2 - paddingTop;
                final float h = b0.h(this.c, this.d, height, n3);
                if (h <= 0.0f) {
                    return;
                }
                for (int size = b.size(), i = 0; i < size; ++i) {
                    Cue b2;
                    final Cue cue = b2 = b.get(i);
                    if (cue.A != Integer.MIN_VALUE) {
                        b2 = b(cue);
                    }
                    this.a.get(i).b(b2, this.e, h, b0.h(b2.y, b2.z, height, n3), this.f, canvas, paddingLeft, paddingTop, n, n2);
                }
            }
        }
    }
}
