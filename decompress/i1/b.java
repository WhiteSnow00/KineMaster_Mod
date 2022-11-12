// 
// Decompiled by Procyon v0.6.0
// 

package i1;

public class b
{
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    
    public b(final boolean a, final boolean b, final boolean c, final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public boolean a() {
        return this.a;
    }
    
    public boolean b() {
        return this.c;
    }
    
    public boolean c() {
        return this.d;
    }
    
    public boolean d() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof b)) {
            return false;
        }
        final b b2 = (b)o;
        if (this.a != b2.a || this.b != b2.b || this.c != b2.c || this.d != b2.d) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        int a;
        final int n = a = (this.a ? 1 : 0);
        if (this.b) {
            a = n + 16;
        }
        int n2 = a;
        if (this.c) {
            n2 = a + 256;
        }
        int n3 = n2;
        if (this.d) {
            n3 = n2 + 4096;
        }
        return n3;
    }
    
    @Override
    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", this.a, this.b, this.c, this.d);
    }
}
