// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.f;

public final class l0 implements f
{
    public final InAppMessageStreamManager a;
    
    public l0(final InAppMessageStreamManager a) {
        this.a = a;
    }
    
    public final Object apply(final Object o) {
        return InAppMessageStreamManager.o(this.a, (String)o);
    }
}
