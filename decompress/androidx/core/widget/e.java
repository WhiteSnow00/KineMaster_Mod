// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

public final class e implements Runnable
{
    public final ContentLoadingProgressBar a;
    
    public e(final ContentLoadingProgressBar a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        ContentLoadingProgressBar.a(this.a);
    }
}
