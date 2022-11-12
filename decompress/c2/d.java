// 
// Decompiled by Procyon v0.6.0
// 

package c2;

import v2.k;
import java.security.MessageDigest;

public final class d<T>
{
    private static final b<Object> e;
    private final T a;
    private final b<T> b;
    private final String c;
    private volatile byte[] d;
    
    static {
        e = (b)new b<Object>() {
            @Override
            public void a(final byte[] array, final Object o, final MessageDigest messageDigest) {
            }
        };
    }
    
    private d(final String s, final T a, final b<T> b) {
        this.c = k.b(s);
        this.a = a;
        this.b = k.d(b);
    }
    
    public static <T> d<T> a(final String s, final T t, final b<T> b) {
        return new d<T>(s, t, b);
    }
    
    private static <T> b<T> b() {
        return (b<T>)d.e;
    }
    
    private byte[] d() {
        if (this.d == null) {
            this.d = this.c.getBytes(c2.b.a);
        }
        return this.d;
    }
    
    public static <T> d<T> e(final String s) {
        return new d<T>(s, null, b());
    }
    
    public static <T> d<T> f(final String s, final T t) {
        return new d<T>(s, t, b());
    }
    
    public T c() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof d && this.c.equals(((d)o).c);
    }
    
    public void g(final T t, final MessageDigest messageDigest) {
        this.b.a(this.d(), t, messageDigest);
    }
    
    @Override
    public int hashCode() {
        return this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Option{key='");
        sb.append(this.c);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
    
    public interface b<T>
    {
        void a(final byte[] p0, final T p1, final MessageDigest p2);
    }
}
