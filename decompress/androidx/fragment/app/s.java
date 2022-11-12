// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.core.app.i;
import androidx.core.util.a;

public final class s implements a
{
    public final FragmentManager a;
    
    public s(final FragmentManager a) {
        this.a = a;
    }
    
    @Override
    public final void accept(final Object o) {
        FragmentManager.c(this.a, (i)o);
    }
}
