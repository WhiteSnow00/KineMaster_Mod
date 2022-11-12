// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

class m
{
    private static m d;
    public long a;
    public long b;
    public int c;
    
    static m b() {
        if (m.d == null) {
            m.d = new m();
        }
        return m.d;
    }
    
    public void a(final long n, double n2, double n3) {
        final float n4 = (n - 946728000000L) / 8.64E7f;
        final float n5 = 0.01720197f * n4 + 6.24006f;
        final double n6 = n5;
        final double n7 = Math.sin(n6) * 0.03341960161924362 + n6 + Math.sin(2.0f * n5) * 3.4906598739326E-4 + Math.sin(n5 * 3.0f) * 5.236000106378924E-6 + 1.796593063 + 3.141592653589793;
        n3 = -n3 / 360.0;
        n3 = Math.round(n4 - 9.0E-4f - n3) + 9.0E-4f + n3 + Math.sin(n6) * 0.0053 + Math.sin(2.0 * n7) * -0.0069;
        final double asin = Math.asin(Math.sin(n7) * Math.sin(0.4092797040939331));
        n2 *= 0.01745329238474369;
        n2 = (Math.sin(-0.10471975803375244) - Math.sin(n2) * Math.sin(asin)) / (Math.cos(n2) * Math.cos(asin));
        if (n2 >= 1.0) {
            this.c = 1;
            this.a = -1L;
            this.b = -1L;
            return;
        }
        if (n2 <= -1.0) {
            this.c = 0;
            this.a = -1L;
            this.b = -1L;
            return;
        }
        n2 = (float)(Math.acos(n2) / 6.283185307179586);
        this.a = Math.round((n3 + n2) * 8.64E7) + 946728000000L;
        final long b = Math.round((n3 - n2) * 8.64E7) + 946728000000L;
        this.b = b;
        if (b < n && this.a > n) {
            this.c = 0;
        }
        else {
            this.c = 1;
        }
    }
}
