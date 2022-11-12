// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.o;

public final class k implements o
{
    public final m a;
    public final androidx.core.view.o b;
    
    public k(final m a, final androidx.core.view.o b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void f(final r r, final Lifecycle.Event event) {
        m.b(this.a, this.b, r, event);
    }
}
