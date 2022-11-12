// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import android.graphics.Typeface;
import android.graphics.Paint;
import android.graphics.Canvas;
import androidx.emoji2.text.flatbuffer.a;

public class g
{
    private static final ThreadLocal<a> d;
    private final int a;
    private final m b;
    private volatile int c;
    
    static {
        d = new ThreadLocal<a>();
    }
    
    g(final m b, final int a) {
        this.c = 0;
        this.b = b;
        this.a = a;
    }
    
    private a g() {
        final ThreadLocal<a> d = g.d;
        a a;
        if ((a = d.get()) == null) {
            a = new a();
            d.set(a);
        }
        this.b.d().j(a, this.a);
        return a;
    }
    
    public void a(final Canvas canvas, final float n, final float n2, final Paint paint) {
        final Typeface g = this.b.g();
        final Typeface typeface = paint.getTypeface();
        paint.setTypeface(g);
        canvas.drawText(this.b.c(), this.a * 2, 2, n, n2, paint);
        paint.setTypeface(typeface);
    }
    
    public int b(final int n) {
        return this.g().h(n);
    }
    
    public int c() {
        return this.g().i();
    }
    
    public int d() {
        return this.c;
    }
    
    public short e() {
        return this.g().k();
    }
    
    public int f() {
        return this.g().l();
    }
    
    public short h() {
        return this.g().m();
    }
    
    public short i() {
        return this.g().n();
    }
    
    public boolean j() {
        return this.g().j();
    }
    
    public void k(final boolean b) {
        int c;
        if (b) {
            c = 2;
        }
        else {
            c = 1;
        }
        this.c = c;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(this.f()));
        sb.append(", codepoints:");
        for (int c = this.c(), i = 0; i < c; ++i) {
            sb.append(Integer.toHexString(this.b(i)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
