// 
// Decompiled by Procyon v0.6.0
// 

package t0;

public class f
{
    public static final String[] a;
    
    static {
        a = new String[0];
    }
    
    public static void a(final StringBuilder sb, final int n) {
        for (int i = 0; i < n; ++i) {
            sb.append("?");
            if (i < n - 1) {
                sb.append(",");
            }
        }
    }
    
    public static StringBuilder b() {
        return new StringBuilder();
    }
}
