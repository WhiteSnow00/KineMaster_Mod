// 
// Decompiled by Procyon v0.6.0
// 

package i;

public abstract class c
{
    public abstract void a(final Runnable p0);
    
    public void b(final Runnable runnable) {
        if (this.c()) {
            runnable.run();
        }
        else {
            this.d(runnable);
        }
    }
    
    public abstract boolean c();
    
    public abstract void d(final Runnable p0);
}
