// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl;
import ba.e;

public final class s implements e
{
    public static final s a;
    
    static {
        a = new s();
    }
    
    private s() {
    }
    
    public final void accept(final Object o) {
        DisplayCallbacksImpl.h((Throwable)o);
    }
}
