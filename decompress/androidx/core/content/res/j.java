// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.res;

final class j
{
    static final j k;
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float[] g;
    private final float h;
    private final float i;
    private final float j;
    
    static {
        k = k(b.c, (float)(b.h(50.0f) * 63.66197723675813 / 100.0), 50.0f, 2.0f, false);
    }
    
    private j(final float f, final float a, final float b, final float c, final float d, final float e, final float[] g, final float h, final float i, final float j) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    static j k(float[] array, float n, float n2, float n3, final boolean b) {
        final float[][] a = b.a;
        final float n4 = array[0] * a[0][0] + array[1] * a[0][1] + array[2] * a[0][2];
        final float n5 = array[0] * a[1][0] + array[1] * a[1][1] + array[2] * a[1][2];
        final float n6 = array[0] * a[2][0] + array[1] * a[2][1] + array[2] * a[2][2];
        final float n7 = n3 / 10.0f + 0.8f;
        float n8;
        if (n7 >= 0.9) {
            n8 = b.d(0.59f, 0.69f, (n7 - 0.9f) * 10.0f);
        }
        else {
            n8 = b.d(0.525f, 0.59f, (n7 - 0.8f) * 10.0f);
        }
        if (b) {
            n3 = 1.0f;
        }
        else {
            n3 = (1.0f - (float)Math.exp((-n - 42.0f) / 92.0f) * 0.2777778f) * n7;
        }
        final double n9 = n3;
        if (n9 > 1.0) {
            n3 = 1.0f;
        }
        else if (n9 < 0.0) {
            n3 = 0.0f;
        }
        final float[] array2 = { 100.0f / n4 * n3 + 1.0f - n3, 100.0f / n5 * n3 + 1.0f - n3, 100.0f / n6 * n3 + 1.0f - n3 };
        n3 = 1.0f / (5.0f * n + 1.0f);
        n3 *= n3 * n3 * n3;
        final float n10 = 1.0f - n3;
        n = n3 * n + 0.1f * n10 * n10 * (float)Math.cbrt(n * 5.0);
        n2 = b.h(n2) / array[1];
        final double n11 = n2;
        final float n12 = (float)Math.sqrt(n11);
        n3 = 0.725f / (float)Math.pow(n11, 0.2);
        final float[] array3 = { (float)Math.pow(array2[0] * n * n4 / 100.0, 0.42), (float)Math.pow(array2[1] * n * n5 / 100.0, 0.42), (float)Math.pow(array2[2] * n * n6 / 100.0, 0.42) };
        array = new float[] { array3[0] * 400.0f / (array3[0] + 27.13f), array3[1] * 400.0f / (array3[1] + 27.13f), array3[2] * 400.0f / (array3[2] + 27.13f) };
        return new j(n2, (array[0] * 2.0f + array[1] + array[2] * 0.05f) * n3, n3, n3, n8, n7, array2, n, (float)Math.pow(n, 0.25), n12 + 1.48f);
    }
    
    float a() {
        return this.a;
    }
    
    float b() {
        return this.d;
    }
    
    float c() {
        return this.h;
    }
    
    float d() {
        return this.i;
    }
    
    float e() {
        return this.f;
    }
    
    float f() {
        return this.b;
    }
    
    float g() {
        return this.e;
    }
    
    float h() {
        return this.c;
    }
    
    float[] i() {
        return this.g;
    }
    
    float j() {
        return this.j;
    }
}
