// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity;

public final class e implements Runnable
{
    public final f a;
    
    public e(final f a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        f.a(this.a);
    }
}
