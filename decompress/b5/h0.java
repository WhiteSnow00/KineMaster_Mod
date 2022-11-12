// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.e;

public final class h0 implements e
{
    public static final h0 a;
    
    static {
        a = new h0();
    }
    
    private h0() {
    }
    
    public final void accept(final Object o) {
        InAppMessageStreamManager.v((Throwable)o);
    }
}
