// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import android.os.Bundle;
import u0.c;

public final class f0 implements c
{
    public final g0 a;
    
    public f0(final g0 a) {
        this.a = a;
    }
    
    @Override
    public final Bundle saveState() {
        return g0.a(this.a);
    }
}
