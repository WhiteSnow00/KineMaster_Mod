// 
// Decompiled by Procyon v0.6.0
// 

package e2;

import java.util.TreeMap;
import android.util.Log;
import v2.k;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.Map;

public final class i implements e2.b
{
    private final g<a, Object> a;
    private final b b;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> c;
    private final Map<Class<?>, e2.a<?>> d;
    private final int e;
    private int f;
    
    public i(final int e) {
        this.a = new g<a, Object>();
        this.b = new b();
        this.c = new HashMap<Class<?>, NavigableMap<Integer, Integer>>();
        this.d = new HashMap<Class<?>, e2.a<?>>();
        this.e = e;
    }
    
    private void e(final int n, final Class<?> clazz) {
        final NavigableMap<Integer, Integer> l = this.l(clazz);
        final Integer n2 = l.get(n);
        if (n2 != null) {
            if (n2 == 1) {
                l.remove(n);
            }
            else {
                l.put(n, n2 - 1);
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Tried to decrement empty size, size: ");
        sb.append(n);
        sb.append(", this: ");
        sb.append(this);
        throw new NullPointerException(sb.toString());
    }
    
    private void f() {
        this.g(this.e);
    }
    
    private void g(final int n) {
        while (this.f > n) {
            final Object f = this.a.f();
            k.d(f);
            final e2.a<Object> h = this.h(f);
            this.f -= h.b(f) * h.a();
            this.e(h.b(f), f.getClass());
            if (Log.isLoggable(h.getTag(), 2)) {
                final String tag = h.getTag();
                final StringBuilder sb = new StringBuilder();
                sb.append("evicted: ");
                sb.append(h.b(f));
                Log.v(tag, sb.toString());
            }
        }
    }
    
    private <T> e2.a<T> h(final T t) {
        return this.i(t.getClass());
    }
    
    private <T> e2.a<T> i(final Class<T> clazz) {
        e2.a a;
        if ((a = this.d.get(clazz)) == null) {
            if (clazz.equals(int[].class)) {
                a = new h();
            }
            else {
                if (!clazz.equals(byte[].class)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("No array pool found for: ");
                    sb.append(clazz.getSimpleName());
                    throw new IllegalArgumentException(sb.toString());
                }
                a = new f();
            }
            this.d.put(clazz, a);
        }
        return a;
    }
    
    private <T> T j(final a a) {
        return (T)this.a.a(a);
    }
    
    private <T> T k(final a a, final Class<T> clazz) {
        final e2.a<T> i = this.i(clazz);
        final T j = this.j(a);
        if (j != null) {
            this.f -= i.b(j) * i.a();
            this.e(i.b(j), clazz);
        }
        Object array;
        if ((array = j) == null) {
            if (Log.isLoggable(i.getTag(), 2)) {
                final String tag = i.getTag();
                final StringBuilder sb = new StringBuilder();
                sb.append("Allocated ");
                sb.append(a.b);
                sb.append(" bytes");
                Log.v(tag, sb.toString());
            }
            array = i.newArray(a.b);
        }
        return (T)array;
    }
    
    private NavigableMap<Integer, Integer> l(final Class<?> clazz) {
        NavigableMap navigableMap;
        if ((navigableMap = this.c.get(clazz)) == null) {
            navigableMap = new TreeMap();
            this.c.put(clazz, navigableMap);
        }
        return navigableMap;
    }
    
    private boolean m() {
        final int f = this.f;
        return f == 0 || this.e / f >= 2;
    }
    
    private boolean n(final int n) {
        return n <= this.e / 2;
    }
    
    private boolean o(final int n, final Integer n2) {
        return n2 != null && (this.m() || n2 <= n * 8);
    }
    
    @Override
    public void a(final int n) {
        monitorenter(this);
        Label_0041: {
            Label_0019: {
                if (n >= 40) {
                    Label_0044: {
                        try {
                            this.b();
                            break Label_0041;
                        }
                        finally {
                            break Label_0044;
                        }
                        break Label_0019;
                    }
                    monitorexit(this);
                }
            }
            if (n >= 20 || n == 15) {
                this.g(this.e / 2);
            }
        }
        monitorexit(this);
    }
    
    @Override
    public void b() {
        synchronized (this) {
            this.g(0);
        }
    }
    
    @Override
    public <T> T c(final int n, final Class<T> clazz) {
        synchronized (this) {
            final Integer n2 = this.l(clazz).ceilingKey(n);
            a a;
            if (this.o(n, n2)) {
                a = this.b.e(n2, clazz);
            }
            else {
                a = this.b.e(n, clazz);
            }
            return this.k(a, clazz);
        }
    }
    
    @Override
    public <T> T d(final int n, final Class<T> clazz) {
        synchronized (this) {
            return this.k(this.b.e(n, clazz), clazz);
        }
    }
    
    @Override
    public <T> void put(final T t) {
        synchronized (this) {
            final Class<?> class1 = t.getClass();
            final e2.a<T> i = this.i(class1);
            final int b = i.b(t);
            final int n = i.a() * b;
            if (!this.n(n)) {
                return;
            }
            final a e = this.b.e(b, class1);
            this.a.d(e, t);
            final NavigableMap<Integer, Integer> l = this.l(class1);
            final Integer n2 = l.get(e.b);
            final int b2 = e.b;
            int n3 = 1;
            if (n2 != null) {
                n3 = 1 + n2;
            }
            l.put(b2, n3);
            this.f += n;
            this.f();
        }
    }
    
    private static final class a implements l
    {
        private final b a;
        int b;
        private Class<?> c;
        
        a(final b a) {
            this.a = a;
        }
        
        @Override
        public void a() {
            this.a.c(this);
        }
        
        void b(final int b, final Class<?> c) {
            this.b = b;
            this.c = c;
        }
        
        @Override
        public boolean equals(final Object o) {
            final boolean b = o instanceof a;
            boolean b3;
            final boolean b2 = b3 = false;
            if (b) {
                final a a = (a)o;
                b3 = b2;
                if (this.b == a.b) {
                    b3 = b2;
                    if (this.c == a.c) {
                        b3 = true;
                    }
                }
            }
            return b3;
        }
        
        @Override
        public int hashCode() {
            final int b = this.b;
            final Class<?> c = this.c;
            int hashCode;
            if (c != null) {
                hashCode = c.hashCode();
            }
            else {
                hashCode = 0;
            }
            return b * 31 + hashCode;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Key{size=");
            sb.append(this.b);
            sb.append("array=");
            sb.append(this.c);
            sb.append('}');
            return sb.toString();
        }
    }
    
    private static final class b extends c<a>
    {
        b() {
        }
        
        protected /* bridge */ l a() {
            return this.d();
        }
        
        protected a d() {
            return new a(this);
        }
        
        a e(final int n, final Class<?> clazz) {
            final a a = this.b();
            a.b(n, clazz);
            return a;
        }
    }
}
