// 
// Decompiled by Procyon v0.6.0
// 

package p2;

import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Set;

class a implements l
{
    private final Set<m> a;
    private boolean b;
    private boolean c;
    
    a() {
        this.a = Collections.newSetFromMap(new WeakHashMap<m, Boolean>());
    }
    
    @Override
    public void a(final m m) {
        this.a.remove(m);
    }
    
    @Override
    public void b(final m m) {
        this.a.add(m);
        if (this.c) {
            m.onDestroy();
        }
        else if (this.b) {
            m.onStart();
        }
        else {
            m.onStop();
        }
    }
    
    void c() {
        this.c = true;
        final Iterator<m> iterator = v2.l.j(this.a).iterator();
        while (iterator.hasNext()) {
            iterator.next().onDestroy();
        }
    }
    
    void d() {
        this.b = true;
        final Iterator<m> iterator = v2.l.j(this.a).iterator();
        while (iterator.hasNext()) {
            iterator.next().onStart();
        }
    }
    
    void e() {
        this.b = false;
        final Iterator<m> iterator = v2.l.j(this.a).iterator();
        while (iterator.hasNext()) {
            iterator.next().onStop();
        }
    }
}
