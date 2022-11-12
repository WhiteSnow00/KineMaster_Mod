// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import androidx.lifecycle.r;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.o;

public final class l implements o
{
    public final m a;
    public final Lifecycle.State b;
    public final androidx.core.view.o c;
    
    public l(final m a, final Lifecycle.State b, final androidx.core.view.o c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void f(final r r, final Lifecycle.Event event) {
        m.a(this.a, this.b, this.c, r, event);
    }
}
