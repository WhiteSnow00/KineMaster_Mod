// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

public final class l0 implements Runnable
{
    public final n0 a;
    
    public l0(final n0 a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        n0.a(this.a);
    }
}
