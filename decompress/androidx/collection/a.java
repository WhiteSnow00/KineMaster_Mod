// 
// Decompiled by Procyon v0.6.0
// 

package androidx.collection;

import java.util.Iterator;
import java.util.Collection;
import java.util.Set;
import java.util.Map;

public class a<K, V> extends g<K, V> implements Map<K, V>
{
    f<K, V> h;
    
    public a() {
    }
    
    public a(final int n) {
        super(n);
    }
    
    public a(final g g) {
        super(g);
    }
    
    private f<K, V> n() {
        if (this.h == null) {
            this.h = new f<K, V>(this) {
                final a d;
                
                @Override
                protected void a() {
                    this.d.clear();
                }
                
                @Override
                protected Object b(final int n, final int n2) {
                    return this.d.b[(n << 1) + n2];
                }
                
                @Override
                protected Map<K, V> c() {
                    return this.d;
                }
                
                @Override
                protected int d() {
                    return this.d.c;
                }
                
                @Override
                protected int e(final Object o) {
                    return this.d.f(o);
                }
                
                @Override
                protected int f(final Object o) {
                    return this.d.h(o);
                }
                
                @Override
                protected void g(final K k, final V v) {
                    this.d.put(k, v);
                }
                
                @Override
                protected void h(final int n) {
                    this.d.k(n);
                }
                
                @Override
                protected V i(final int n, final V v) {
                    return this.d.l(n, v);
                }
            };
        }
        return this.h;
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.n().l();
    }
    
    @Override
    public Set<K> keySet() {
        return this.n().m();
    }
    
    public boolean o(final Collection<?> collection) {
        return androidx.collection.f.p((Map<Object, Object>)this, collection);
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> map) {
        this.c(super.c + map.size());
        for (final Entry<K, V> entry : map.entrySet()) {
            this.put(entry.getKey(), (V)entry.getValue());
        }
    }
    
    @Override
    public Collection<V> values() {
        return this.n().n();
    }
}
