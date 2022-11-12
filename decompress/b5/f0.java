// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.e;

public final class f0 implements e
{
    public static final f0 a;
    
    static {
        a = new f0();
    }
    
    private f0() {
    }
    
    public final void accept(final Object o) {
        InAppMessageStreamManager.j((Throwable)o);
    }
}
