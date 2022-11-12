// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import kotlinx.coroutines.q1;

public final class l implements o
{
    public final m a;
    public final q1 b;
    
    public l(final m a, final q1 b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void f(final r r, final Lifecycle.Event event) {
        m.a(this.a, this.b, r, event);
    }
}
