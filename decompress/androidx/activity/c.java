// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity;

public final class c implements Runnable
{
    public final ComponentActivity a;
    
    public c(final ComponentActivity a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.invalidateMenu();
    }
}
