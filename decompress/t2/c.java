// 
// Decompiled by Procyon v0.6.0
// 

package t2;

import com.bumptech.glide.load.DataSource;

public class c<R> implements d<R>
{
    static final c<?> a;
    private static final e<?> b;
    
    static {
        a = new c<Object>();
        b = new a<Object>();
    }
    
    public static <R> d<R> b() {
        return (d<R>)c.a;
    }
    
    public static <R> e<R> c() {
        return (e<R>)c.b;
    }
    
    @Override
    public boolean a(final Object o, final d.a a) {
        return false;
    }
    
    public static class a<R> implements e<R>
    {
        @Override
        public d<R> a(final DataSource dataSource, final boolean b) {
            return (d<R>)c.a;
        }
    }
}
