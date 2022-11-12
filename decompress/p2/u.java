// 
// Decompiled by Procyon v0.6.0
// 

package p2;

import java.util.Iterator;
import java.util.Collection;
import v2.l;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import s2.i;
import java.util.Set;

public final class u implements m
{
    private final Set<i<?>> a;
    
    public u() {
        this.a = Collections.newSetFromMap(new WeakHashMap<i<?>, Boolean>());
    }
    
    public void a() {
        this.a.clear();
    }
    
    public List<i<?>> b() {
        return l.j(this.a);
    }
    
    public void c(final i<?> i) {
        this.a.add(i);
    }
    
    public void d(final i<?> i) {
        this.a.remove(i);
    }
    
    @Override
    public void onDestroy() {
        final Iterator<i<?>> iterator = l.j(this.a).iterator();
        while (iterator.hasNext()) {
            iterator.next().onDestroy();
        }
    }
    
    @Override
    public void onStart() {
        final Iterator<i<?>> iterator = l.j(this.a).iterator();
        while (iterator.hasNext()) {
            iterator.next().onStart();
        }
    }
    
    @Override
    public void onStop() {
        final Iterator<i<?>> iterator = l.j(this.a).iterator();
        while (iterator.hasNext()) {
            iterator.next().onStop();
        }
    }
}
