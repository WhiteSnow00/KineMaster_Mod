// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl;
import ba.e;

public final class r implements e
{
    public static final r a;
    
    static {
        a = new r();
    }
    
    private r() {
    }
    
    public final void accept(final Object o) {
        DisplayCallbacksImpl.f((Throwable)o);
    }
}
