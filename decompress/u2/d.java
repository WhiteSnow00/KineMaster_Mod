// 
// Decompiled by Procyon v0.6.0
// 

package u2;

import java.security.MessageDigest;
import v2.k;
import c2.b;

public final class d implements b
{
    private final Object b;
    
    public d(final Object o) {
        this.b = k.d(o);
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(c2.b.a));
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof d && this.b.equals(((d)o).b);
    }
    
    @Override
    public int hashCode() {
        return this.b.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ObjectKey{object=");
        sb.append(this.b);
        sb.append('}');
        return sb.toString();
    }
}
