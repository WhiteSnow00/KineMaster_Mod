// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

public final class y implements Runnable
{
    public final h0 a;
    
    public y(final h0 a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        h0.a(this.a);
    }
}
