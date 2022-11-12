// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;

public class q0
{
    private final HashMap<String, l0> a;
    
    public q0() {
        this.a = new HashMap<String, l0>();
    }
    
    public final void a() {
        final Iterator<l0> iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().clear();
        }
        this.a.clear();
    }
    
    final l0 b(final String s) {
        return this.a.get(s);
    }
    
    Set<String> c() {
        return new HashSet<String>(this.a.keySet());
    }
    
    final void d(final String s, final l0 l0) {
        final l0 l2 = this.a.put(s, l0);
        if (l2 != null) {
            l2.onCleared();
        }
    }
}
