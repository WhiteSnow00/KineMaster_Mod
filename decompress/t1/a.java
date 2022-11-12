// 
// Decompiled by Procyon v0.6.0
// 

package t1;

import android.graphics.PointF;

public class a
{
    private final PointF a;
    private final PointF b;
    private final PointF c;
    
    public a() {
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
    }
    
    public a(final PointF a, final PointF b, final PointF c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public PointF a() {
        return this.a;
    }
    
    public PointF b() {
        return this.b;
    }
    
    public PointF c() {
        return this.c;
    }
    
    public void d(final float n, final float n2) {
        this.a.set(n, n2);
    }
    
    public void e(final float n, final float n2) {
        this.b.set(n, n2);
    }
    
    public void f(final float n, final float n2) {
        this.c.set(n, n2);
    }
}
