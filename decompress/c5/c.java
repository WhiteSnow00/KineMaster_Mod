// 
// Decompiled by Procyon v0.6.0
// 

package c5;

import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule;
import com.google.android.datatransport.Transformer;

public final class c implements Transformer
{
    public static final c a;
    
    static {
        a = new c();
    }
    
    private c() {
    }
    
    @Override
    public final Object apply(final Object o) {
        return TransportClientModule.a((byte[])o);
    }
}
