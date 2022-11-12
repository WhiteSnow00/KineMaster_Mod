// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

public final class f implements Runnable
{
    public final g a;
    public final Runnable b;
    
    public f(final g a, final Runnable b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        g.a(this.a, this.b);
    }
}
