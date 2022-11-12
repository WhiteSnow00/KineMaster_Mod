// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

public final class g implements Runnable
{
    public final ContentLoadingProgressBar a;
    
    public g(final ContentLoadingProgressBar a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        ContentLoadingProgressBar.c(this.a);
    }
}
