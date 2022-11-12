// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

public final class h implements Runnable
{
    public final ContentLoadingProgressBar a;
    
    public h(final ContentLoadingProgressBar a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        ContentLoadingProgressBar.d(this.a);
    }
}
