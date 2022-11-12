// 
// Decompiled by Procyon v0.6.0
// 

package y1;

import t1.e;
import q1.k;
import java.util.List;
import t1.d;
import t1.a;
import android.graphics.Path;
import android.graphics.PointF;

public class g
{
    private static PointF a;
    
    static {
        g.a = new PointF();
    }
    
    public static PointF a(final PointF pointF, final PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }
    
    public static double b(final double n, final double n2, final double n3) {
        return Math.max(n2, Math.min(n3, n));
    }
    
    public static float c(final float n, final float n2, final float n3) {
        return Math.max(n2, Math.min(n3, n));
    }
    
    public static int d(final int n, final int n2, final int n3) {
        return Math.max(n2, Math.min(n3, n));
    }
    
    public static boolean e(final float n, final float n2, final float n3) {
        return n >= n2 && n <= n3;
    }
    
    private static int f(final int n, final int n2) {
        final int n3 = n / n2;
        final boolean b = (n ^ n2) >= 0;
        int n4 = n3;
        if (!b) {
            n4 = n3;
            if (n % n2 != 0) {
                n4 = n3 - 1;
            }
        }
        return n4;
    }
    
    static int g(final float n, final float n2) {
        return h((int)n, (int)n2);
    }
    
    private static int h(final int n, final int n2) {
        return n - n2 * f(n, n2);
    }
    
    public static void i(final v1.g g, final Path path) {
        path.reset();
        final PointF b = g.b();
        path.moveTo(b.x, b.y);
        g.a.set(b.x, b.y);
        for (int i = 0; i < g.a().size(); ++i) {
            final a a = g.a().get(i);
            final PointF a2 = a.a();
            final PointF b2 = a.b();
            final PointF c = a.c();
            if (a2.equals((Object)g.a) && b2.equals((Object)c)) {
                path.lineTo(c.x, c.y);
            }
            else {
                path.cubicTo(a2.x, a2.y, b2.x, b2.y, c.x, c.y);
            }
            g.a.set(c.x, c.y);
        }
        if (g.d()) {
            path.close();
        }
    }
    
    public static double j(final double n, final double n2, final double n3) {
        return n + n3 * (n2 - n);
    }
    
    public static float k(final float n, final float n2, final float n3) {
        return n + n3 * (n2 - n);
    }
    
    public static int l(final int n, final int n2, final float n3) {
        return (int)(n + n3 * (n2 - n));
    }
    
    public static void m(final d d, final int n, final List<d> list, final d d2, final k k) {
        if (d.c(k.getName(), n)) {
            list.add(d2.a(k.getName()).i(k));
        }
    }
}
