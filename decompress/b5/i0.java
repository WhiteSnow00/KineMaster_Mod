// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.e;

public final class i0 implements e
{
    public static final i0 a;
    
    static {
        a = new i0();
    }
    
    private i0() {
    }
    
    public final void accept(final Object o) {
        InAppMessageStreamManager.w((Throwable)o);
    }
}
