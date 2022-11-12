// 
// Decompiled by Procyon v0.6.0
// 

package o;

public class i extends c
{
    double d;
    double e;
    
    i(final String a) {
        super.a = a;
        final int index = a.indexOf(40);
        int index2 = a.indexOf(44, index);
        this.d = Double.parseDouble(a.substring(index + 1, index2).trim());
        ++index2;
        this.e = Double.parseDouble(a.substring(index2, a.indexOf(44, index2)).trim());
    }
    
    private double d(final double n) {
        final double e = this.e;
        if (n < e) {
            final double d = this.d;
            return d * e * e / (((e - n) * d + n) * (d * (e - n) + n));
        }
        final double d2 = this.d;
        return (e - 1.0) * d2 * (e - 1.0) / ((-d2 * (e - n) - n + 1.0) * (-d2 * (e - n) - n + 1.0));
    }
    
    private double e(final double n) {
        final double e = this.e;
        if (n < e) {
            return e * n / (n + this.d * (e - n));
        }
        return (1.0 - e) * (n - 1.0) / (1.0 - n - this.d * (e - n));
    }
    
    @Override
    public double a(final double n) {
        return this.e(n);
    }
    
    @Override
    public double b(final double n) {
        return this.d(n);
    }
}
