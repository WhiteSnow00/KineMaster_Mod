// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.graphics.PathMeasure;
import android.graphics.Matrix;
import android.graphics.Path;

public class h extends g
{
    private Path a;
    private final Path b;
    private final Matrix c;
    
    public h(final Path path) {
        this.b = new Path();
        this.c = new Matrix();
        this.c(path);
    }
    
    private static float b(final float n, final float n2) {
        return (float)Math.sqrt(n * n + n2 * n2);
    }
    
    @Override
    public Path a(final float n, final float n2, float n3, float b) {
        n3 -= n;
        final float n4 = b - n2;
        b = b(n3, n4);
        final double atan2 = Math.atan2(n4, n3);
        this.c.setScale(b, b);
        this.c.postRotate((float)Math.toDegrees(atan2));
        this.c.postTranslate(n, n2);
        final Path path = new Path();
        this.b.transform(this.c, path);
        return path;
    }
    
    public void c(final Path a) {
        final PathMeasure pathMeasure = new PathMeasure(a, false);
        final float length = pathMeasure.getLength();
        final float[] array = new float[2];
        pathMeasure.getPosTan(length, array, (float[])null);
        final float n = array[0];
        final float n2 = array[1];
        pathMeasure.getPosTan(0.0f, array, (float[])null);
        final float n3 = array[0];
        final float n4 = array[1];
        if (n3 == n && n4 == n2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.c.setTranslate(-n3, -n4);
        final float n5 = n - n3;
        final float n6 = n2 - n4;
        final float n7 = 1.0f / b(n5, n6);
        this.c.postScale(n7, n7);
        this.c.postRotate((float)Math.toDegrees(-Math.atan2(n6, n5)));
        a.transform(this.c, this.b);
        this.a = a;
    }
}
