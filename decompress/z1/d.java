// 
// Decompiled by Procyon v0.6.0
// 

package z1;

public class d
{
    private float a;
    private float b;
    
    public d() {
        this(1.0f, 1.0f);
    }
    
    public d(final float a, final float b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean a(final float n, final float n2) {
        return this.a == n && this.b == n2;
    }
    
    public float b() {
        return this.a;
    }
    
    public float c() {
        return this.b;
    }
    
    public void d(final float a, final float b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.b());
        sb.append("x");
        sb.append(this.c());
        return sb.toString();
    }
}
