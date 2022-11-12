// 
// Decompiled by Procyon v0.6.0
// 

package e1;

import androidx.work.b;
import java.util.List;

public abstract class f
{
    private static final String a;
    
    static {
        a = h.f("InputMerger");
    }
    
    public static f a(final String s) {
        try {
            return (f)Class.forName(s).newInstance();
        }
        catch (final Exception ex) {
            final h c = h.c();
            final String a = f.a;
            final StringBuilder sb = new StringBuilder();
            sb.append("Trouble instantiating + ");
            sb.append(s);
            c.b(a, sb.toString(), ex);
            return null;
        }
    }
    
    public abstract b b(final List<b> p0);
}
