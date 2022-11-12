// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video.spherical;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.util.Assertions;

final class Projection
{
    public final Mesh a;
    public final Mesh b;
    public final int c;
    public final boolean d;
    
    public Projection(final Mesh mesh, final int n) {
        this(mesh, mesh, n);
    }
    
    public Projection(final Mesh a, final Mesh b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = (a == b);
    }
    
    public static Projection a(final float n, final int n2, final int n3, float n4, float n5, final int n6) {
        Assertions.a(n > 0.0f);
        Assertions.a(n2 >= 1);
        Assertions.a(n3 >= 1);
        Assertions.a(n4 > 0.0f && n4 <= 180.0f);
        Assertions.a(n5 > 0.0f && n5 <= 360.0f);
        final float n7 = (float)Math.toRadians(n4);
        final float n8 = (float)Math.toRadians(n5);
        float n9 = n7 / n2;
        float n10 = n8 / n3;
        final int n11 = n3 + 1;
        final int n12 = (n11 * 2 + 2) * n2;
        final float[] array = new float[n12 * 3];
        final float[] array2 = new float[n12 * 2];
        int i = 0;
        int n13 = 0;
        int n14 = 0;
        while (i < n2) {
            n5 = (float)i;
            n4 = n7 / 2.0f;
            n5 = n5 * n9 - n4;
            final int n15 = i + 1;
            n4 = n15 * n9 - n4;
            int j = 0;
            final int n16 = i;
            i = n15;
            float n17 = n10;
            final float n18 = n9;
            while (j < n11) {
                int k = 0;
                final float n19 = n17;
                final int n20 = j;
                while (k < 2) {
                    float n21;
                    if (k == 0) {
                        n21 = n5;
                    }
                    else {
                        n21 = n4;
                    }
                    final float n22 = n20 * n19;
                    final float n23 = n8 / 2.0f;
                    final int n24 = n13 + 1;
                    final double n25 = n;
                    final double n26 = n22 + 3.1415927f - n23;
                    final double sin = Math.sin(n26);
                    final double n27 = n21;
                    array[n13] = -(float)(sin * n25 * Math.cos(n27));
                    final int n28 = n24 + 1;
                    array[n24] = (float)(n25 * Math.sin(n27));
                    int n29 = n28 + 1;
                    array[n28] = (float)(n25 * Math.cos(n26) * Math.cos(n27));
                    final int n30 = n14 + 1;
                    array2[n14] = n22 / n8;
                    int n31 = n30 + 1;
                    array2[n30] = (n16 + k) * n18 / n7;
                    Label_0504: {
                        if (n20 != 0 || k != 0) {
                            if (n20 != n3 || k != 1) {
                                break Label_0504;
                            }
                        }
                        System.arraycopy(array, n29 - 3, array, n29, 3);
                        n29 += 3;
                        System.arraycopy(array2, n31 - 2, array2, n31, 2);
                        n31 += 2;
                    }
                    n13 = n29;
                    ++k;
                    n14 = n31;
                }
                j = n20 + 1;
                n17 = n19;
            }
            n9 = n18;
            n10 = n17;
        }
        return new Projection(new Mesh(new SubMesh[] { new SubMesh(0, array, array2, 1) }), n6);
    }
    
    public static Projection b(final int n) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, n);
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface DrawMode {
    }
    
    public static final class Mesh
    {
        private final SubMesh[] a;
        
        public Mesh(final SubMesh... a) {
            this.a = a;
        }
        
        public SubMesh a(final int n) {
            return this.a[n];
        }
        
        public int b() {
            return this.a.length;
        }
    }
    
    public static final class SubMesh
    {
        public final int a;
        public final int b;
        public final float[] c;
        public final float[] d;
        
        public SubMesh(final int a, final float[] c, final float[] d, final int b) {
            this.a = a;
            Assertions.a(c.length * 2L == d.length * 3L);
            this.c = c;
            this.d = d;
            this.b = b;
        }
        
        public int a() {
            return this.c.length / 3;
        }
    }
}
