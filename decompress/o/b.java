// 
// Decompiled by Procyon v0.6.0
// 

package o;

public abstract class b
{
    public static b a(int n, final double[] array, final double[][] array2) {
        if (array.length == 1) {
            n = 2;
        }
        if (n == 0) {
            return new g(array, array2);
        }
        if (n != 2) {
            return new f(array, array2);
        }
        return new a(array[0], array2[0]);
    }
    
    public static b b(final int[] array, final double[] array2, final double[][] array3) {
        return new o.a(array, array2, array3);
    }
    
    public abstract double c(final double p0, final int p1);
    
    public abstract void d(final double p0, final double[] p1);
    
    public abstract void e(final double p0, final float[] p1);
    
    public abstract void f(final double p0, final double[] p1);
    
    public abstract double[] g();
    
    static class a extends b
    {
        double a;
        double[] b;
        
        a(final double a, final double[] b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public double c(final double n, final int n2) {
            return this.b[n2];
        }
        
        @Override
        public void d(final double n, final double[] array) {
            final double[] b = this.b;
            System.arraycopy(b, 0, array, 0, b.length);
        }
        
        @Override
        public void e(final double n, final float[] array) {
            int n2 = 0;
            while (true) {
                final double[] b = this.b;
                if (n2 >= b.length) {
                    break;
                }
                array[n2] = (float)b[n2];
                ++n2;
            }
        }
        
        @Override
        public void f(final double n, final double[] array) {
            for (int i = 0; i < this.b.length; ++i) {
                array[i] = 0.0;
            }
        }
        
        @Override
        public double[] g() {
            return new double[] { this.a };
        }
    }
}
