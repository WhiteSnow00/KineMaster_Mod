// 
// Decompiled by Procyon v0.6.0
// 

package t1;

import androidx.core.util.d;

public class h<T>
{
    T a;
    T b;
    
    private static boolean a(final Object o, final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    public void b(final T a, final T b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof d;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final d d = (d)o;
        boolean b3 = b2;
        if (a(d.a, this.a)) {
            b3 = b2;
            if (a(d.b, this.b)) {
                b3 = true;
            }
        }
        return b3;
    }
    
    @Override
    public int hashCode() {
        final T a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = a.hashCode();
        }
        final T b = this.b;
        if (b != null) {
            hashCode = b.hashCode();
        }
        return hashCode2 ^ hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Pair{");
        sb.append(String.valueOf(this.a));
        sb.append(" ");
        sb.append(String.valueOf(this.b));
        sb.append("}");
        return sb.toString();
    }
}
