// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.content.res.Configuration;
import androidx.core.util.a;

public final class r implements a
{
    public final FragmentManager a;
    
    public r(final FragmentManager a) {
        this.a = a;
    }
    
    @Override
    public final void accept(final Object o) {
        FragmentManager.d(this.a, (Configuration)o);
    }
}
