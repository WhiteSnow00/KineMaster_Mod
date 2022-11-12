// 
// Decompiled by Procyon v0.6.0
// 

package e1;

public interface i
{
    public static final b.c a = new b.c(null);
    public static final b.b b = new b.b(null);
    
    public abstract static class b
    {
        b() {
        }
        
        public static final class a extends i.b
        {
            private final Throwable a;
            
            public a(final Throwable a) {
                this.a = a;
            }
            
            public Throwable a() {
                return this.a;
            }
            
            @Override
            public String toString() {
                return String.format("FAILURE (%s)", this.a.getMessage());
            }
        }
        
        public static final class b extends i.b
        {
            private b() {
            }
            
            b(final i$a object) {
                this();
            }
            
            @Override
            public String toString() {
                return "IN_PROGRESS";
            }
        }
        
        public static final class c extends i.b
        {
            private c() {
            }
            
            c(final i$a object) {
                this();
            }
            
            @Override
            public String toString() {
                return "SUCCESS";
            }
        }
    }
}
