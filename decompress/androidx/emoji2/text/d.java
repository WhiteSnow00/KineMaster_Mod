// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import android.graphics.Paint;
import androidx.core.graphics.f;
import android.text.TextPaint;

class d implements androidx.emoji2.text.e.d
{
    private static final ThreadLocal<StringBuilder> b;
    private final TextPaint a;
    
    static {
        b = new ThreadLocal<StringBuilder>();
    }
    
    d() {
        (this.a = new TextPaint()).setTextSize(10.0f);
    }
    
    private static StringBuilder b() {
        final ThreadLocal<StringBuilder> b = d.b;
        if (b.get() == null) {
            b.set(new StringBuilder());
        }
        return b.get();
    }
    
    @Override
    public boolean a(final CharSequence charSequence, int i, final int n, final int n2) {
        final StringBuilder b = b();
        b.setLength(0);
        while (i < n) {
            b.append(charSequence.charAt(i));
            ++i;
        }
        return androidx.core.graphics.f.a((Paint)this.a, b.toString());
    }
}
