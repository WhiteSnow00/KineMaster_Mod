// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.res;

import android.graphics.Typeface;

public final class h implements Runnable
{
    public final f.e a;
    public final Typeface b;
    
    public h(final f.e a, final Typeface b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        f.e.b(this.a, this.b);
    }
}
