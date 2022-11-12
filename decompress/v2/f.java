// 
// Decompiled by Procyon v0.6.0
// 

package v2;

public final class f
{
    public static <T> b<T> a(final b<T> b) {
        return (b<T>)new b<T>(b) {
            private volatile T a;
            final b b;
            
            @Override
            public T get() {
                if (this.a == null) {
                    synchronized (this) {
                        if (this.a == null) {
                            this.a = k.d(this.b.get());
                        }
                    }
                }
                return this.a;
            }
        };
    }
    
    public interface b<T>
    {
        T get();
    }
}
