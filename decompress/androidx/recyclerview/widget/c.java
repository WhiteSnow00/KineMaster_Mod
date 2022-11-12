// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import java.util.concurrent.Executors;
import java.util.concurrent.Executor;

public final class c<T>
{
    private final Executor a;
    private final Executor b;
    private final i.f<T> c;
    
    c(final Executor a, final Executor b, final i.f<T> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public Executor a() {
        return this.b;
    }
    
    public i.f<T> b() {
        return this.c;
    }
    
    public Executor c() {
        return this.a;
    }
    
    public static final class a<T>
    {
        private static final Object d;
        private static Executor e;
        private Executor a;
        private Executor b;
        private final i.f<T> c;
        
        static {
            d = new Object();
        }
        
        public a(final i.f<T> c) {
            this.c = c;
        }
        
        public c<T> a() {
            if (this.b == null) {
                synchronized (androidx.recyclerview.widget.c.a.d) {
                    if (androidx.recyclerview.widget.c.a.e == null) {
                        androidx.recyclerview.widget.c.a.e = Executors.newFixedThreadPool(2);
                    }
                    monitorexit(androidx.recyclerview.widget.c.a.d);
                    this.b = androidx.recyclerview.widget.c.a.e;
                }
            }
            return new c<T>(this.a, this.b, this.c);
        }
    }
}
