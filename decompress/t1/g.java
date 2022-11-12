// 
// Decompiled by Procyon v0.6.0
// 

package t1;

public class g
{
    private static String d = "\r";
    private final String a;
    public final float b;
    public final float c;
    
    public g(final String a, final float b, final float c) {
        this.a = a;
        this.c = c;
        this.b = b;
    }
    
    public boolean a(final String s) {
        if (this.a.equalsIgnoreCase(s)) {
            return true;
        }
        if (this.a.endsWith(g.d)) {
            final String a = this.a;
            if (a.substring(0, a.length() - 1).equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
}
