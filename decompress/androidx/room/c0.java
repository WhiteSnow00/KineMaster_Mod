// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

public final class c0 implements Runnable
{
    public final h0 a;
    public final String b;
    
    public c0(final h0 a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        h0.h(this.a, this.b);
    }
}
