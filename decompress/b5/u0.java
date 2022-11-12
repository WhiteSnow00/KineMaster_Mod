// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import ba.f;

public final class u0 implements f
{
    public static final u0 a;
    
    static {
        a = new u0();
    }
    
    private u0() {
    }
    
    public final Object apply(final Object o) {
        return InAppMessageStreamManager.m((CampaignProto$ThickContent)o);
    }
}
