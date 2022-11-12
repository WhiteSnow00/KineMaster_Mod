// 
// Decompiled by Procyon v0.6.0
// 

package j;

import java.util.Map;
import java.util.HashMap;

public class a<K, V> extends b<K, V>
{
    private HashMap<K, c<K, V>> e;
    
    public a() {
        this.e = new HashMap<K, c<K, V>>();
    }
    
    @Override
    protected c<K, V> b(final K k) {
        return this.e.get(k);
    }
    
    public boolean contains(final K k) {
        return this.e.containsKey(k);
    }
    
    @Override
    public V k(final K k, final V v) {
        final c<K, V> b = this.b(k);
        if (b != null) {
            return b.b;
        }
        this.e.put(k, this.g(k, v));
        return null;
    }
    
    @Override
    public V m(final K k) {
        final V m = super.m(k);
        this.e.remove(k);
        return m;
    }
    
    public Map.Entry<K, V> n(final K k) {
        if (this.contains(k)) {
            return this.e.get(k).d;
        }
        return null;
    }
}
