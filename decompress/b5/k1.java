// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import ba.e;

public final class k1 implements e
{
    public static final k1 a;
    
    static {
        a = new k1();
    }
    
    private k1() {
    }
    
    public final void accept(final Object o) {
        InAppMessageStreamManager.g((FetchEligibleCampaignsResponse)o);
    }
}
