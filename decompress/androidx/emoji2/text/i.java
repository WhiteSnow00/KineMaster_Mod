// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import android.graphics.Paint;
import androidx.core.util.h;
import android.graphics.Paint$FontMetricsInt;
import android.text.style.ReplacementSpan;

public abstract class i extends ReplacementSpan
{
    private final Paint$FontMetricsInt a;
    private final g b;
    private short c;
    private short d;
    private float e;
    
    i(final g b) {
        this.a = new Paint$FontMetricsInt();
        this.c = -1;
        this.d = -1;
        this.e = 1.0f;
        h.h(b, "metadata cannot be null");
        this.b = b;
    }
    
    public final g a() {
        return this.b;
    }
    
    final int b() {
        return this.c;
    }
    
    public int getSize(final Paint paint, final CharSequence charSequence, final int n, final int n2, final Paint$FontMetricsInt paint$FontMetricsInt) {
        paint.getFontMetricsInt(this.a);
        final Paint$FontMetricsInt a = this.a;
        this.e = Math.abs(a.descent - a.ascent) * 1.0f / this.b.e();
        this.d = (short)(this.b.e() * this.e);
        final short c = (short)(this.b.i() * this.e);
        this.c = c;
        if (paint$FontMetricsInt != null) {
            final Paint$FontMetricsInt a2 = this.a;
            paint$FontMetricsInt.ascent = a2.ascent;
            paint$FontMetricsInt.descent = a2.descent;
            paint$FontMetricsInt.top = a2.top;
            paint$FontMetricsInt.bottom = a2.bottom;
        }
        return c;
    }
}
