// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.e;

public final class g0 implements e
{
    public static final g0 a;
    
    static {
        a = new g0();
    }
    
    private g0() {
    }
    
    public final void accept(final Object o) {
        InAppMessageStreamManager.p((Throwable)o);
    }
}
