// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.h;

public final class b1 implements h
{
    public static final b1 a;
    
    static {
        a = new b1();
    }
    
    private b1() {
    }
    
    public final boolean test(final Object o) {
        return InAppMessageStreamManager.D((Boolean)o);
    }
}
