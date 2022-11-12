// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.view.View;

public final class s implements Runnable
{
    public final t a;
    public final View[] b;
    
    public s(final t a, final View[] b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        t.a(this.a, this.b);
    }
}
