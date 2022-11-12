// 
// Decompiled by Procyon v0.6.0
// 

package i;

import java.util.concurrent.Executor;

public class a extends c
{
    private static volatile a c;
    private static final Executor d;
    private static final Executor e;
    private c a;
    private c b;
    
    static {
        d = new Executor() {
            @Override
            public void execute(final Runnable runnable) {
                i.a.f().d(runnable);
            }
        };
        e = new Executor() {
            @Override
            public void execute(final Runnable runnable) {
                i.a.f().a(runnable);
            }
        };
    }
    
    private a() {
        final b b = new b();
        this.b = b;
        this.a = b;
    }
    
    public static Executor e() {
        return a.e;
    }
    
    public static a f() {
        if (a.c != null) {
            return a.c;
        }
        synchronized (a.class) {
            if (a.c == null) {
                a.c = new a();
            }
            return a.c;
        }
    }
    
    @Override
    public void a(final Runnable runnable) {
        this.a.a(runnable);
    }
    
    @Override
    public boolean c() {
        return this.a.c();
    }
    
    @Override
    public void d(final Runnable runnable) {
        this.a.d(runnable);
    }
}
