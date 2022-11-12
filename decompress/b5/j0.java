// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.e;

public final class j0 implements e
{
    public static final j0 a;
    
    static {
        a = new j0();
    }
    
    private j0() {
    }
    
    public final void accept(final Object o) {
        InAppMessageStreamManager.x((Throwable)o);
    }
}
