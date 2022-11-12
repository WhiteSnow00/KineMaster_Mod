// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.core.util.a;

public final class u implements a
{
    public final FragmentManager a;
    
    public u(final FragmentManager a) {
        this.a = a;
    }
    
    @Override
    public final void accept(final Object o) {
        FragmentManager.a(this.a, (Integer)o);
    }
}
