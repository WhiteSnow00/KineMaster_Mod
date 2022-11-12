// 
// Decompiled by Procyon v0.6.0
// 

package v2;

import androidx.collection.g;
import androidx.collection.a;

public final class b<K, V> extends a<K, V>
{
    private int i;
    
    @Override
    public void clear() {
        this.i = 0;
        super.clear();
    }
    
    @Override
    public int hashCode() {
        if (this.i == 0) {
            this.i = super.hashCode();
        }
        return this.i;
    }
    
    @Override
    public void j(final g<? extends K, ? extends V> g) {
        this.i = 0;
        super.j(g);
    }
    
    @Override
    public V k(final int n) {
        this.i = 0;
        return super.k(n);
    }
    
    @Override
    public V l(final int n, final V v) {
        this.i = 0;
        return super.l(n, v);
    }
    
    @Override
    public V put(final K k, final V v) {
        this.i = 0;
        return super.put(k, v);
    }
}
