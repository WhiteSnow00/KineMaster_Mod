// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

public final class e
{
    public static final e e;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    
    static {
        e = new e(0, 0, 0, 0);
    }
    
    private e(final int a, final int b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static e a(final e e, final e e2) {
        return b(Math.max(e.a, e2.a), Math.max(e.b, e2.b), Math.max(e.c, e2.c), Math.max(e.d, e2.d));
    }
    
    public static e b(final int n, final int n2, final int n3, final int n4) {
        if (n == 0 && n2 == 0 && n3 == 0 && n4 == 0) {
            return androidx.core.graphics.e.e;
        }
        return new e(n, n2, n3, n4);
    }
    
    public static e c(final Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }
    
    public static e d(final Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }
    
    public Insets e() {
        return androidx.core.graphics.e.a.a(this.a, this.b, this.c, this.d);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && e.class == o.getClass()) {
            final e e = (e)o;
            return this.d == e.d && this.a == e.a && this.c == e.c && this.b == e.b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((this.a * 31 + this.b) * 31 + this.c) * 31 + this.d;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Insets{left=");
        sb.append(this.a);
        sb.append(", top=");
        sb.append(this.b);
        sb.append(", right=");
        sb.append(this.c);
        sb.append(", bottom=");
        sb.append(this.d);
        sb.append('}');
        return sb.toString();
    }
    
    static class a
    {
        static Insets a(final int n, final int n2, final int n3, final int n4) {
            return Insets.of(n, n2, n3, n4);
        }
    }
}
