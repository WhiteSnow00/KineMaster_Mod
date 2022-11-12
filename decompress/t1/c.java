// 
// Decompiled by Procyon v0.6.0
// 

package t1;

import v1.i;
import java.util.List;

public class c
{
    private final List<i> a;
    private final char b;
    private final double c;
    private final double d;
    private final String e;
    private final String f;
    
    public c(final List<i> a, final char b, final double c, final double d, final String e, final String f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public static int c(final char c, final String s, final String s2) {
        return (('\0' + c) * 31 + s.hashCode()) * 31 + s2.hashCode();
    }
    
    public List<i> a() {
        return this.a;
    }
    
    public double b() {
        return this.d;
    }
    
    @Override
    public int hashCode() {
        return c(this.b, this.f, this.e);
    }
}
