// 
// Decompiled by Procyon v0.6.0
// 

package e2;

import java.util.Queue;

abstract class c<T extends l>
{
    private final Queue<T> a;
    
    c() {
        this.a = v2.l.f(20);
    }
    
    abstract T a();
    
    T b() {
        l a;
        if ((a = this.a.poll()) == null) {
            a = this.a();
        }
        return (T)a;
    }
    
    public void c(final T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }
}
