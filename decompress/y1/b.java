// 
// Decompiled by Procyon v0.6.0
// 

package y1;

public class b
{
    private static float a(float n) {
        if (n <= 0.04045f) {
            n /= 12.92f;
        }
        else {
            n = (float)Math.pow((n + 0.055f) / 1.055f, 2.4000000953674316);
        }
        return n;
    }
    
    private static float b(float n) {
        if (n <= 0.0031308f) {
            n *= 12.92f;
        }
        else {
            n = (float)(Math.pow(n, 0.4166666567325592) * 1.0549999475479126 - 0.054999999701976776);
        }
        return n;
    }
    
    public static int c(final float n, int round, final int n2) {
        if (round == n2) {
            return round;
        }
        final float n3 = (round >> 24 & 0xFF) / 255.0f;
        final float n4 = (round >> 16 & 0xFF) / 255.0f;
        final float n5 = (round >> 8 & 0xFF) / 255.0f;
        final float n6 = (round & 0xFF) / 255.0f;
        final float n7 = (n2 >> 24 & 0xFF) / 255.0f;
        final float n8 = (n2 >> 16 & 0xFF) / 255.0f;
        final float n9 = (n2 >> 8 & 0xFF) / 255.0f;
        final float n10 = (n2 & 0xFF) / 255.0f;
        final float a = a(n4);
        final float a2 = a(n5);
        final float a3 = a(n6);
        final float a4 = a(n8);
        final float a5 = a(n9);
        final float a6 = a(n10);
        final float b = b(a + (a4 - a) * n);
        final float b2 = b(a2 + (a5 - a2) * n);
        final float b3 = b(a3 + n * (a6 - a3));
        round = Math.round((n3 + (n7 - n3) * n) * 255.0f);
        return Math.round(b * 255.0f) << 16 | round << 24 | Math.round(b2 * 255.0f) << 8 | Math.round(b3 * 255.0f);
    }
}
