// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import e1.e;
import e1.l;
import e1.g;
import e1.o;
import java.util.concurrent.Executor;

public final class a
{
    final Executor a;
    final Executor b;
    final o c;
    final g d;
    final l e;
    final e f;
    final String g;
    final int h;
    final int i;
    final int j;
    final int k;
    private final boolean l;
    
    a(final b b) {
        final Executor a = b.a;
        if (a == null) {
            this.a = this.a(false);
        }
        else {
            this.a = a;
        }
        final Executor d = b.d;
        if (d == null) {
            this.l = true;
            this.b = this.a(true);
        }
        else {
            this.l = false;
            this.b = d;
        }
        final o b2 = b.b;
        if (b2 == null) {
            this.c = o.c();
        }
        else {
            this.c = b2;
        }
        final g c = b.c;
        if (c == null) {
            this.d = e1.g.c();
        }
        else {
            this.d = c;
        }
        final l e = b.e;
        if (e == null) {
            this.e = new f1.a();
        }
        else {
            this.e = e;
        }
        this.h = b.h;
        this.i = b.i;
        this.j = b.j;
        this.k = b.k;
        this.f = b.f;
        this.g = b.g;
    }
    
    private Executor a(final boolean b) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), this.b(b));
    }
    
    private ThreadFactory b(final boolean b) {
        return new ThreadFactory(this, b) {
            private final AtomicInteger a = new AtomicInteger(0);
            final boolean b;
            final a c;
            
            @Override
            public Thread newThread(final Runnable runnable) {
                String s;
                if (this.b) {
                    s = "WM.task-";
                }
                else {
                    s = "androidx.work-";
                }
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(this.a.incrementAndGet());
                return new Thread(runnable, sb.toString());
            }
        };
    }
    
    public String c() {
        return this.g;
    }
    
    public e d() {
        return this.f;
    }
    
    public Executor e() {
        return this.a;
    }
    
    public g f() {
        return this.d;
    }
    
    public int g() {
        return this.j;
    }
    
    public int h() {
        return this.k;
    }
    
    public int i() {
        return this.i;
    }
    
    public int j() {
        return this.h;
    }
    
    public l k() {
        return this.e;
    }
    
    public Executor l() {
        return this.b;
    }
    
    public o m() {
        return this.c;
    }
    
    public static final class b
    {
        Executor a;
        o b;
        g c;
        Executor d;
        l e;
        e f;
        String g;
        int h;
        int i;
        int j;
        int k;
        
        public b() {
            this.h = 4;
            this.i = 0;
            this.j = Integer.MAX_VALUE;
            this.k = 20;
        }
        
        public a a() {
            return new a(this);
        }
    }
    
    public interface c
    {
        a a();
    }
}
