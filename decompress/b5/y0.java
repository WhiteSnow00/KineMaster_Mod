// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.InstallationIdResult;
import ba.h;

public final class y0 implements h
{
    public static final y0 a;
    
    static {
        a = new y0();
    }
    
    private y0() {
    }
    
    public final boolean test(final Object o) {
        return InAppMessageStreamManager.d((InstallationIdResult)o);
    }
}
