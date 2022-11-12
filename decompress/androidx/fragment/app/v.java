// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.os.Bundle;
import u0.c;

public final class v implements c
{
    public final FragmentManager a;
    
    public v(final FragmentManager a) {
        this.a = a;
    }
    
    @Override
    public final Bundle saveState() {
        return FragmentManager.e(this.a);
    }
}
