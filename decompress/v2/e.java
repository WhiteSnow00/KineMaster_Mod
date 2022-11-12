// 
// Decompiled by Procyon v0.6.0
// 

package v2;

import java.util.concurrent.Executor;

public final class e
{
    private static final Executor a;
    private static final Executor b;
    
    static {
        a = new Executor() {
            @Override
            public void execute(final Runnable runnable) {
                l.v(runnable);
            }
        };
        b = new Executor() {
            @Override
            public void execute(final Runnable runnable) {
                runnable.run();
            }
        };
    }
    
    public static Executor a() {
        return e.b;
    }
    
    public static Executor b() {
        return e.a;
    }
}
