// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.res;

public final class g implements Runnable
{
    public final f.e a;
    public final int b;
    
    public g(final f.e a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        f.e.a(this.a, this.b);
    }
}
