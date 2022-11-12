// 
// Decompiled by Procyon v0.6.0
// 

package u1;

import java.util.Arrays;
import java.util.Collections;
import z1.a;
import java.util.List;

abstract class n<V, O> implements m<V, O>
{
    final List<a<V>> a;
    
    n(final V v) {
        this(Collections.singletonList(new a<V>(v)));
    }
    
    n(final List<a<V>> a) {
        this.a = a;
    }
    
    @Override
    public List<a<V>> b() {
        return this.a;
    }
    
    @Override
    public boolean f() {
        final boolean empty = this.a.isEmpty();
        final boolean b = false;
        if (!empty) {
            boolean b2 = b;
            if (this.a.size() != 1) {
                return b2;
            }
            b2 = b;
            if (!this.a.get(0).h()) {
                return b2;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }
}
