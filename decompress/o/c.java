// 
// Decompiled by Procyon v0.6.0
// 

package o;

import java.io.PrintStream;
import java.util.Arrays;

public class c
{
    static c b;
    public static String[] c;
    String a;
    
    static {
        o.c.b = new c();
        o.c.c = new String[] { "standard", "accelerate", "decelerate", "linear" };
    }
    
    public c() {
        this.a = "identity";
    }
    
    public static c c(final String s) {
        if (s == null) {
            return null;
        }
        if (s.startsWith("cubic")) {
            return new a(s);
        }
        if (s.startsWith("spline")) {
            return new k(s);
        }
        if (s.startsWith("Schlick")) {
            return new i(s);
        }
        int n = -1;
        switch (s) {
            case "standard": {
                n = 5;
                break;
            }
            case "overshoot": {
                n = 4;
                break;
            }
            case "linear": {
                n = 3;
                break;
            }
            case "anticipate": {
                n = 2;
                break;
            }
            case "decelerate": {
                n = 1;
                break;
            }
            case "accelerate": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                final PrintStream err = System.err;
                final StringBuilder sb = new StringBuilder();
                sb.append("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
                sb.append(Arrays.toString(o.c.c));
                err.println(sb.toString());
                return o.c.b;
            }
            case 5: {
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            }
            case 4: {
                return new a("cubic(0.34, 1.56, 0.64, 1)");
            }
            case 3: {
                return new a("cubic(1, 1, 0, 0)");
            }
            case 2: {
                return new a("cubic(0.36, 0, 0.66, -0.56)");
            }
            case 1: {
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            }
            case 0: {
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            }
        }
    }
    
    public double a(final double n) {
        return n;
    }
    
    public double b(final double n) {
        return 1.0;
    }
    
    @Override
    public String toString() {
        return this.a;
    }
    
    static class a extends c
    {
        private static double h = 0.01;
        private static double i = 1.0E-4;
        double d;
        double e;
        double f;
        double g;
        
        a(final String a) {
            super.a = a;
            final int index = a.indexOf(40);
            final int index2 = a.indexOf(44, index);
            this.d = Double.parseDouble(a.substring(index + 1, index2).trim());
            final int n = index2 + 1;
            int index3 = a.indexOf(44, n);
            this.e = Double.parseDouble(a.substring(n, index3).trim());
            ++index3;
            int index4 = a.indexOf(44, index3);
            this.f = Double.parseDouble(a.substring(index3, index4).trim());
            ++index4;
            this.g = Double.parseDouble(a.substring(index4, a.indexOf(41, index4)).trim());
        }
        
        private double d(final double n) {
            final double n2 = 1.0 - n;
            final double n3 = 3.0 * n2;
            return this.d * (n2 * n3 * n) + this.f * (n3 * n * n) + n * n * n;
        }
        
        private double e(final double n) {
            final double n2 = 1.0 - n;
            final double n3 = 3.0 * n2;
            return this.e * (n2 * n3 * n) + this.g * (n3 * n * n) + n * n * n;
        }
        
        @Override
        public double a(final double n) {
            if (n <= 0.0) {
                return 0.0;
            }
            if (n >= 1.0) {
                return 1.0;
            }
            double n2 = 0.5;
            double n3 = 0.5;
            while (n2 > a.h) {
                final double d = this.d(n3);
                n2 *= 0.5;
                if (d < n) {
                    n3 += n2;
                }
                else {
                    n3 -= n2;
                }
            }
            final double n4 = n3 - n2;
            final double d2 = this.d(n4);
            final double n5 = n3 + n2;
            final double d3 = this.d(n5);
            final double e = this.e(n4);
            return (this.e(n5) - e) * (n - d2) / (d3 - d2) + e;
        }
        
        @Override
        public double b(double d) {
            double n = 0.5;
            double n2 = 0.5;
            while (n > a.i) {
                final double d2 = this.d(n2);
                n *= 0.5;
                if (d2 < d) {
                    n2 += n;
                }
                else {
                    n2 -= n;
                }
            }
            final double n3 = n2 - n;
            d = this.d(n3);
            final double n4 = n2 + n;
            return (this.e(n4) - this.e(n3)) / (this.d(n4) - d);
        }
    }
}
