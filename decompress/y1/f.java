// 
// Decompiled by Procyon v0.6.0
// 

package y1;

public class f
{
    private float a;
    private int b;
    
    public void a(float a) {
        a += this.a;
        this.a = a;
        final int b = this.b + 1;
        this.b = b;
        if (b == Integer.MAX_VALUE) {
            this.a = a / 2.0f;
            this.b = b / 2;
        }
    }
}
