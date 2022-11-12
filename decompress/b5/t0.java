// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import ba.f;

public final class t0 implements f
{
    public final CampaignProto$ThickContent a;
    
    public t0(final CampaignProto$ThickContent a) {
        this.a = a;
    }
    
    public final Object apply(final Object o) {
        return InAppMessageStreamManager.e(this.a, (Boolean)o);
    }
}
