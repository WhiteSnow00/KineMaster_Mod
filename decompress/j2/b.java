// 
// Decompiled by Procyon v0.6.0
// 

package j2;

import v2.k;
import com.bumptech.glide.load.engine.s;

public class b<T> implements s<T>
{
    protected final T a;
    
    public b(final T t) {
        this.a = k.d(t);
    }
    
    @Override
    public final int a() {
        return 1;
    }
    
    @Override
    public void b() {
    }
    
    @Override
    public Class<T> c() {
        return (Class<T>)this.a.getClass();
    }
    
    @Override
    public final T get() {
        return this.a;
    }
}
