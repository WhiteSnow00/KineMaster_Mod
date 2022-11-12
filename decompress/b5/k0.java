// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.f;

public final class k0 implements f
{
    public final InAppMessageStreamManager a;
    
    public k0(final InAppMessageStreamManager a) {
        this.a = a;
    }
    
    public final Object apply(final Object o) {
        return InAppMessageStreamManager.A(this.a, (CampaignProto$ThickContent)o);
    }
}
