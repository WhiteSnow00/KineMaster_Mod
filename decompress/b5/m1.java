// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.e;

public final class m1 implements e
{
    public static final m1 a;
    
    static {
        a = new m1();
    }
    
    private m1() {
    }
    
    public final void accept(final Object o) {
        InAppMessageStreamManager.y((Boolean)o);
    }
}
