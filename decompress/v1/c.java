// 
// Decompiled by Procyon v0.6.0
// 

package v1;

import y1.b;
import y1.g;

public class c
{
    private final float[] a;
    private final int[] b;
    
    public c(final float[] a, final int[] b) {
        this.a = a;
        this.b = b;
    }
    
    public int[] a() {
        return this.b;
    }
    
    public float[] b() {
        return this.a;
    }
    
    public int c() {
        return this.b.length;
    }
    
    public void d(final c c, final c c2, final float n) {
        if (c.b.length == c2.b.length) {
            for (int i = 0; i < c.b.length; ++i) {
                this.a[i] = g.k(c.a[i], c2.a[i], n);
                this.b[i] = y1.b.c(n, c.b[i], c2.b[i]);
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot interpolate between gradients. Lengths vary (");
        sb.append(c.b.length);
        sb.append(" vs ");
        sb.append(c2.b.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }
}
