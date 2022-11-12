// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import ba.e;

public final class j1 implements e
{
    public final CampaignProto$ThickContent a;
    
    public j1(final CampaignProto$ThickContent a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        InAppMessageStreamManager.u(this.a, (Boolean)o);
    }
}
