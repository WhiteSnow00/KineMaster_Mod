// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.util.Util;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.Cue;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.AbsoluteSizeSpan;
import com.google.android.exoplayer2.util.Log;
import android.text.SpannableStringBuilder;
import android.graphics.Paint$Join;
import android.graphics.Color;
import com.google.android.exoplayer2.util.Assertions;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import android.graphics.Paint$Style;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.Layout$Alignment;
import android.graphics.Paint;
import android.text.TextPaint;
import android.graphics.Rect;
import android.text.StaticLayout;

final class y
{
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final TextPaint f;
    private final Paint g;
    private final Paint h;
    private CharSequence i;
    private Layout$Alignment j;
    private Bitmap k;
    private float l;
    private int m;
    private int n;
    private float o;
    private int p;
    private float q;
    private float r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private float x;
    private float y;
    private float z;
    
    public y(final Context context) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet)null, new int[] { 16843287, 16843288 }, 0, 0);
        this.e = (float)obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        final float c = (float)Math.round(context.getResources().getDisplayMetrics().densityDpi * 2.0f / 160.0f);
        this.a = c;
        this.b = c;
        this.c = c;
        final TextPaint f = new TextPaint();
        (this.f = f).setAntiAlias(true);
        f.setSubpixelText(true);
        final Paint g = new Paint();
        (this.g = g).setAntiAlias(true);
        g.setStyle(Paint$Style.FILL);
        final Paint h = new Paint();
        (this.h = h).setAntiAlias(true);
        h.setFilterBitmap(true);
    }
    
    private static boolean a(final CharSequence charSequence, final CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }
    
    private void c(final Canvas canvas) {
        canvas.drawBitmap(this.k, (Rect)null, this.J, this.h);
    }
    
    private void d(final Canvas canvas, final boolean b) {
        if (b) {
            this.e(canvas);
        }
        else {
            Assertions.e(this.J);
            Assertions.e(this.k);
            this.c(canvas);
        }
    }
    
    private void e(final Canvas canvas) {
        final StaticLayout e = this.E;
        final StaticLayout f = this.F;
        if (e != null) {
            if (f != null) {
                final int save = canvas.save();
                canvas.translate((float)this.G, (float)this.H);
                if (Color.alpha(this.u) > 0) {
                    this.g.setColor(this.u);
                    canvas.drawRect((float)(-this.I), 0.0f, (float)(e.getWidth() + this.I), (float)e.getHeight(), this.g);
                }
                final int w = this.w;
                boolean b = true;
                if (w == 1) {
                    this.f.setStrokeJoin(Paint$Join.ROUND);
                    this.f.setStrokeWidth(this.a);
                    this.f.setColor(this.v);
                    this.f.setStyle(Paint$Style.FILL_AND_STROKE);
                    f.draw(canvas);
                }
                else if (w == 2) {
                    final TextPaint f2 = this.f;
                    final float b2 = this.b;
                    final float c = this.c;
                    f2.setShadowLayer(b2, c, c, this.v);
                }
                else if (w == 3 || w == 4) {
                    if (w != 3) {
                        b = false;
                    }
                    int v = -1;
                    int v2;
                    if (b) {
                        v2 = -1;
                    }
                    else {
                        v2 = this.v;
                    }
                    if (b) {
                        v = this.v;
                    }
                    final float n = this.b / 2.0f;
                    this.f.setColor(this.s);
                    this.f.setStyle(Paint$Style.FILL);
                    final TextPaint f3 = this.f;
                    final float b3 = this.b;
                    final float n2 = -n;
                    f3.setShadowLayer(b3, n2, n2, v2);
                    f.draw(canvas);
                    this.f.setShadowLayer(this.b, n, n, v);
                }
                this.f.setColor(this.s);
                this.f.setStyle(Paint$Style.FILL);
                e.draw(canvas);
                this.f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                canvas.restoreToCount(save);
            }
        }
    }
    
    private void f() {
        final Bitmap k = this.k;
        final int c = this.C;
        final int a = this.A;
        final int d = this.D;
        final int b = this.B;
        final float n = (float)a;
        final float n2 = (float)(c - a);
        final float n3 = n + this.o * n2;
        final float n4 = (float)b;
        final float n5 = (float)(d - b);
        final float n6 = n4 + this.l * n5;
        final int round = Math.round(n2 * this.q);
        final float r = this.r;
        int n7;
        if (r != -3.4028235E38f) {
            n7 = Math.round(n5 * r);
        }
        else {
            n7 = Math.round(round * (k.getHeight() / (float)k.getWidth()));
        }
        final int p = this.p;
        float n9 = 0.0f;
        Label_0170: {
            float n8;
            if (p == 2) {
                n8 = (float)round;
            }
            else {
                n9 = n3;
                if (p != 1) {
                    break Label_0170;
                }
                n8 = (float)(round / 2);
            }
            n9 = n3 - n8;
        }
        final int round2 = Math.round(n9);
        final int n10 = this.n;
        float n12 = 0.0f;
        Label_0216: {
            float n11;
            if (n10 == 2) {
                n11 = (float)n7;
            }
            else {
                n12 = n6;
                if (n10 != 1) {
                    break Label_0216;
                }
                n11 = (float)(n7 / 2);
            }
            n12 = n6 - n11;
        }
        final int round3 = Math.round(n12);
        this.J = new Rect(round2, round3, round + round2, n7 + round3);
    }
    
    private void g() {
        final CharSequence i = this.i;
        SpannableStringBuilder spannableStringBuilder;
        if (i instanceof SpannableStringBuilder) {
            spannableStringBuilder = (SpannableStringBuilder)i;
        }
        else {
            spannableStringBuilder = new SpannableStringBuilder(this.i);
        }
        final int n = this.C - this.A;
        final int n2 = this.D - this.B;
        this.f.setTextSize(this.x);
        final int j = (int)(this.x * 0.125f + 0.5f);
        final int n3 = j * 2;
        final int n4 = n - n3;
        final float q = this.q;
        int n5 = n4;
        if (q != -3.4028235E38f) {
            n5 = (int)(n4 * q);
        }
        final int n6 = n5;
        if (n6 <= 0) {
            Log.i("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.y > 0.0f) {
            spannableStringBuilder.setSpan((Object)new AbsoluteSizeSpan((int)this.y), 0, spannableStringBuilder.length(), 16711680);
        }
        final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder((CharSequence)spannableStringBuilder);
        if (this.w == 1) {
            final ForegroundColorSpan[] array = (ForegroundColorSpan[])spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), (Class)ForegroundColorSpan.class);
            for (int length = array.length, k = 0; k < length; ++k) {
                spannableStringBuilder2.removeSpan((Object)array[k]);
            }
        }
        if (Color.alpha(this.t) > 0) {
            final int w = this.w;
            if (w != 0 && w != 2) {
                spannableStringBuilder2.setSpan((Object)new BackgroundColorSpan(this.t), 0, spannableStringBuilder2.length(), 16711680);
            }
            else {
                spannableStringBuilder.setSpan((Object)new BackgroundColorSpan(this.t), 0, spannableStringBuilder.length(), 16711680);
            }
        }
        Layout$Alignment layout$Alignment;
        if ((layout$Alignment = this.j) == null) {
            layout$Alignment = Layout$Alignment.ALIGN_CENTER;
        }
        final StaticLayout e = new StaticLayout((CharSequence)spannableStringBuilder, this.f, n6, layout$Alignment, this.d, this.e, true);
        this.E = e;
        final int height = e.getHeight();
        final int lineCount = this.E.getLineCount();
        int max = 0;
        for (int l = 0; l < lineCount; ++l) {
            max = Math.max((int)Math.ceil(this.E.getLineWidth(l)), max);
        }
        if (this.q != -3.4028235E38f && max < n6) {
            max = n6;
        }
        final int n7 = max + n3;
        final float o = this.o;
        int max2;
        int min;
        if (o != -3.4028235E38f) {
            final int round = Math.round(n * o);
            final int a = this.A;
            int n8 = round + a;
            final int p = this.p;
            if (p != 1) {
                if (p == 2) {
                    n8 -= n7;
                }
            }
            else {
                n8 = (n8 * 2 - n7) / 2;
            }
            max2 = Math.max(n8, a);
            min = Math.min(n7 + max2, this.C);
        }
        else {
            max2 = (n - n7) / 2 + this.A;
            min = max2 + n7;
        }
        final int n9 = min - max2;
        if (n9 <= 0) {
            Log.i("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        final float m = this.l;
        int h = 0;
        Label_0773: {
            int n14;
            if (m != -3.4028235E38f) {
                int n12 = 0;
                Label_0712: {
                    int n10;
                    if (this.m == 0) {
                        n10 = Math.round(n2 * m) + this.B;
                        final int n11 = this.n;
                        if (n11 != 2) {
                            n12 = n10;
                            if (n11 == 1) {
                                n12 = (n10 * 2 - height) / 2;
                            }
                            break Label_0712;
                        }
                    }
                    else {
                        final int n13 = this.E.getLineBottom(0) - this.E.getLineTop(0);
                        final float l2 = this.l;
                        if (l2 >= 0.0f) {
                            n12 = Math.round(l2 * n13) + this.B;
                            break Label_0712;
                        }
                        n10 = Math.round((l2 + 1.0f) * n13) + this.D;
                    }
                    n12 = n10 - height;
                }
                final int d = this.D;
                if (n12 + height > d) {
                    n14 = d - height;
                }
                else {
                    final int b = this.B;
                    if ((n14 = n12) < b) {
                        h = b;
                        break Label_0773;
                    }
                }
            }
            else {
                n14 = this.D - height - (int)(n2 * this.z);
            }
            h = n14;
        }
        this.E = new StaticLayout((CharSequence)spannableStringBuilder, this.f, n9, layout$Alignment, this.d, this.e, true);
        this.F = new StaticLayout((CharSequence)spannableStringBuilder2, this.f, n9, layout$Alignment, this.d, this.e, true);
        this.G = max2;
        this.H = h;
        this.I = j;
    }
    
    public void b(final Cue cue, final CaptionStyleCompat captionStyleCompat, final float x, final float y, final float z, final Canvas canvas, final int a, final int b, final int c, final int d) {
        final boolean b2 = cue.d == null;
        int u = -16777216;
        if (b2) {
            if (TextUtils.isEmpty(cue.a)) {
                return;
            }
            if (cue.w) {
                u = cue.x;
            }
            else {
                u = captionStyleCompat.c;
            }
        }
        if (a(this.i, cue.a) && Util.c(this.j, cue.b) && this.k == cue.d && this.l == cue.e && this.m == cue.f && Util.c(this.n, cue.g) && this.o == cue.h && Util.c(this.p, cue.i) && this.q == cue.j && this.r == cue.p && this.s == captionStyleCompat.a && this.t == captionStyleCompat.b && this.u == u && this.w == captionStyleCompat.d && this.v == captionStyleCompat.e && Util.c(this.f.getTypeface(), captionStyleCompat.f) && this.x == x && this.y == y && this.z == z && this.A == a && this.B == b && this.C == c && this.D == d) {
            this.d(canvas, b2);
            return;
        }
        this.i = cue.a;
        this.j = cue.b;
        this.k = cue.d;
        this.l = cue.e;
        this.m = cue.f;
        this.n = cue.g;
        this.o = cue.h;
        this.p = cue.i;
        this.q = cue.j;
        this.r = cue.p;
        this.s = captionStyleCompat.a;
        this.t = captionStyleCompat.b;
        this.u = u;
        this.w = captionStyleCompat.d;
        this.v = captionStyleCompat.e;
        this.f.setTypeface(captionStyleCompat.f);
        this.x = x;
        this.y = y;
        this.z = z;
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
        if (b2) {
            Assertions.e(this.i);
            this.g();
        }
        else {
            Assertions.e(this.k);
            this.f();
        }
        this.d(canvas, b2);
    }
}
