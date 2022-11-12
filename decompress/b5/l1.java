// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import ba.e;

public final class l1 implements e
{
    public static final l1 a;
    
    static {
        a = new l1();
    }
    
    private l1() {
    }
    
    public final void accept(final Object o) {
        InAppMessageStreamManager.r((FetchEligibleCampaignsResponse)o);
    }
}
