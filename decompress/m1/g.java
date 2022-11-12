// 
// Decompiled by Procyon v0.6.0
// 

package m1;

public class g
{
    public final String a;
    public final int b;
    
    public g(final String a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof g)) {
            return false;
        }
        final g g = (g)o;
        return this.b == g.b && this.a.equals(g.a);
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() * 31 + this.b;
    }
}
