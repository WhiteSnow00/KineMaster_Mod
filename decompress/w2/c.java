// 
// Decompiled by Procyon v0.6.0
// 

package w2;

public abstract class c
{
    private c() {
    }
    
    c(final c$a object) {
        this();
    }
    
    public static c a() {
        return new b();
    }
    
    abstract void b(final boolean p0);
    
    public abstract void c();
    
    private static class b extends c
    {
        private volatile boolean a;
        
        b() {
            super(null);
        }
        
        public void b(final boolean a) {
            this.a = a;
        }
        
        @Override
        public void c() {
            if (!this.a) {
                return;
            }
            throw new IllegalStateException("Already released");
        }
    }
}
