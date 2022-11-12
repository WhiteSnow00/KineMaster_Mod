// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

public final class f implements Runnable
{
    public final ContentLoadingProgressBar a;
    
    public f(final ContentLoadingProgressBar a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        ContentLoadingProgressBar.b(this.a);
    }
}
