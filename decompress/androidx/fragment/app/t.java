// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.core.app.s;
import androidx.core.util.a;

public final class t implements a
{
    public final FragmentManager a;
    
    public t(final FragmentManager a) {
        this.a = a;
    }
    
    @Override
    public final void accept(final Object o) {
        FragmentManager.b(this.a, (s)o);
    }
}
