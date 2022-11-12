// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InstallationIdResult;
import com.google.firebase.installations.InstallationTokenResult;
import ba.b;

public final class o0 implements b
{
    public static final o0 a;
    
    static {
        a = new o0();
    }
    
    private o0() {
    }
    
    public final Object a(final Object o, final Object o2) {
        return InstallationIdResult.a((String)o, (InstallationTokenResult)o2);
    }
}
