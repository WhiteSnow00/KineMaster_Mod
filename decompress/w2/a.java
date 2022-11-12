// 
// Decompiled by Procyon v0.6.0
// 

package w2;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import androidx.core.util.g;
import androidx.core.util.e;

public final class a
{
    private static final g<Object> a;
    
    static {
        a = (g)new g<Object>() {
            @Override
            public void a(final Object o) {
            }
        };
    }
    
    private static <T extends f> androidx.core.util.e<T> a(final androidx.core.util.e<T> e, final d<T> d) {
        return b(e, d, c());
    }
    
    private static <T> androidx.core.util.e<T> b(final androidx.core.util.e<T> e, final d<T> d, final g<T> g) {
        return new e<T>(e, d, g);
    }
    
    private static <T> g<T> c() {
        return (g<T>)w2.a.a;
    }
    
    public static <T extends f> androidx.core.util.e<T> d(final int n, final d<T> d) {
        return a(new androidx.core.util.g<T>(n), d);
    }
    
    public static <T> androidx.core.util.e<List<T>> e() {
        return f(20);
    }
    
    public static <T> androidx.core.util.e<List<T>> f(final int n) {
        return b(new androidx.core.util.g<List<T>>(n), (d<List<T>>)new d<List<T>>() {
            @Override
            public /* bridge */ Object a() {
                return this.b();
            }
            
            public List<T> b() {
                return new ArrayList<T>();
            }
        }, (g<List<T>>)new g<List<T>>() {
            @Override
            public /* bridge */ void a(final Object o) {
                this.b((List<T>)o);
            }
            
            public void b(final List<T> list) {
                list.clear();
            }
        });
    }
    
    public interface d<T>
    {
        T a();
    }
    
    private static final class e<T> implements androidx.core.util.e<T>
    {
        private final d<T> a;
        private final g<T> b;
        private final androidx.core.util.e<T> c;
        
        e(final androidx.core.util.e<T> c, final d<T> a, final g<T> b) {
            this.c = c;
            this.a = a;
            this.b = b;
        }
        
        @Override
        public T a() {
            Object o;
            if ((o = this.c.a()) == null) {
                final T t = (T)(o = this.a.a());
                if (Log.isLoggable("FactoryPools", 2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Created new ");
                    sb.append(((f)t).getClass());
                    Log.v("FactoryPools", sb.toString());
                    o = t;
                }
            }
            if (o instanceof f) {
                ((f)o).d().b(false);
            }
            return (T)o;
        }
        
        @Override
        public boolean b(final T t) {
            if (t instanceof f) {
                ((f)t).d().b(true);
            }
            this.b.a(t);
            return this.c.b(t);
        }
    }
    
    public interface f
    {
        c d();
    }
    
    public interface g<T>
    {
        void a(final T p0);
    }
}
