// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video.spherical;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.TimedValueQueue;

final class a
{
    private final float[] a;
    private final float[] b;
    private final TimedValueQueue<float[]> c;
    private boolean d;
    
    public a() {
        this.a = new float[16];
        this.b = new float[16];
        this.c = new TimedValueQueue<float[]>();
    }
    
    public static void a(final float[] array, final float[] array2) {
        Matrix.setIdentityM(array, 0);
        final float n = (float)Math.sqrt(array2[10] * array2[10] + array2[8] * array2[8]);
        array[0] = array2[10] / n;
        array[2] = array2[8] / n;
        array[8] = -array2[8] / n;
        array[10] = array2[10] / n;
    }
    
    private static void b(final float[] array, final float[] array2) {
        final float n = array2[0];
        final float n2 = -array2[1];
        final float n3 = -array2[2];
        final float length = Matrix.length(n, n2, n3);
        if (length != 0.0f) {
            Matrix.setRotateM(array, 0, (float)Math.toDegrees(length), n / length, n2 / length, n3 / length);
        }
        else {
            Matrix.setIdentityM(array, 0);
        }
    }
    
    public boolean c(final float[] array, final long n) {
        final float[] array2 = this.c.j(n);
        if (array2 == null) {
            return false;
        }
        b(this.b, array2);
        if (!this.d) {
            a(this.a, this.b);
            this.d = true;
        }
        Matrix.multiplyMM(array, 0, this.a, 0, this.b, 0);
        return true;
    }
    
    public void d() {
        this.c.c();
        this.d = false;
    }
    
    public void e(final long n, final float[] array) {
        this.c.a(n, array);
    }
}
