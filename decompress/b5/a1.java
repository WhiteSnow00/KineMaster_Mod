// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.h;

public final class a1 implements h
{
    public static final a1 a;
    
    static {
        a = new a1();
    }
    
    private a1() {
    }
    
    public final boolean test(final Object o) {
        return InAppMessageStreamManager.z((Boolean)o);
    }
}
