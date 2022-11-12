// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.os.Bundle;
import u0.c;

public final class g implements c
{
    public final h a;
    
    public g(final h a) {
        this.a = a;
    }
    
    @Override
    public final Bundle saveState() {
        return h.p(this.a);
    }
}
