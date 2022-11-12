// 
// Decompiled by Procyon v0.6.0
// 

package t1;

import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class d
{
    public static final d c;
    private final List<String> a;
    private e b;
    
    static {
        c = new d(new String[] { "COMPOSITION" });
    }
    
    private d(final d d) {
        this.a = new ArrayList<String>(d.a);
        this.b = d.b;
    }
    
    public d(final String... array) {
        this.a = Arrays.asList(array);
    }
    
    private boolean b() {
        final List<String> a = this.a;
        return ((String)a.get(a.size() - 1)).equals("**");
    }
    
    private boolean f(final String s) {
        return "__container".equals(s);
    }
    
    public d a(final String s) {
        final d d = new d(this);
        d.a.add(s);
        return d;
    }
    
    public boolean c(final String s, int n) {
        final int size = this.a.size();
        final boolean b = false;
        final boolean b2 = false;
        if (n >= size) {
            return false;
        }
        final boolean b3 = n == this.a.size() - 1;
        final String s2 = this.a.get(n);
        if (!s2.equals("**")) {
            final boolean b4 = s2.equals(s) || s2.equals("*");
            if (!b3) {
                boolean b5 = b2;
                if (n != this.a.size() - 2) {
                    return b5;
                }
                b5 = b2;
                if (!this.b()) {
                    return b5;
                }
            }
            boolean b5 = b2;
            if (b4) {
                b5 = true;
            }
            return b5;
        }
        if (!b3 && this.a.get(n + 1).equals(s)) {
            if (n != this.a.size() - 2) {
                boolean b6 = b;
                if (n != this.a.size() - 3) {
                    return b6;
                }
                b6 = b;
                if (!this.b()) {
                    return b6;
                }
            }
            return true;
        }
        return b3 || (++n >= this.a.size() - 1 && this.a.get(n).equals(s));
    }
    
    public e d() {
        return this.b;
    }
    
    public int e(final String s, final int n) {
        if (this.f(s)) {
            return 0;
        }
        if (!this.a.get(n).equals("**")) {
            return 1;
        }
        if (n == this.a.size() - 1) {
            return 0;
        }
        if (this.a.get(n + 1).equals(s)) {
            return 2;
        }
        return 0;
    }
    
    public boolean g(final String s, final int n) {
        return this.f(s) || (n < this.a.size() && (this.a.get(n).equals(s) || this.a.get(n).equals("**") || this.a.get(n).equals("*")));
    }
    
    public boolean h(final String s, final int n) {
        final boolean equals = "__container".equals(s);
        final boolean b = true;
        if (equals) {
            return true;
        }
        boolean b2 = b;
        if (n >= this.a.size() - 1) {
            b2 = (this.a.get(n).equals("**") && b);
        }
        return b2;
    }
    
    public d i(final e b) {
        final d d = new d(this);
        d.b = b;
        return d;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.a);
        sb.append(",resolved=");
        sb.append(this.b != null);
        sb.append('}');
        return sb.toString();
    }
}
