// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.text.TextPaint;
import android.graphics.Paint;

public final class o extends i
{
    private static Paint f;
    
    public o(final g g) {
        super(g);
    }
    
    private static Paint c() {
        if (o.f == null) {
            (o.f = (Paint)new TextPaint()).setColor(e.b().c());
            o.f.setStyle(Paint$Style.FILL);
        }
        return o.f;
    }
    
    public void draw(final Canvas canvas, final CharSequence charSequence, final int n, final int n2, final float n3, final int n4, final int n5, final int n6, final Paint paint) {
        if (androidx.emoji2.text.e.b().i()) {
            canvas.drawRect(n3, (float)n4, n3 + this.b(), (float)n6, c());
        }
        this.a().a(canvas, n3, (float)n5, paint);
    }
}
