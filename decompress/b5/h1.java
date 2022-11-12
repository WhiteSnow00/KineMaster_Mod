// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.e;

public final class h1 implements e
{
    public final InAppMessageStreamManager a;
    
    public h1(final InAppMessageStreamManager a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        InAppMessageStreamManager.l(this.a, (FetchEligibleCampaignsResponse)o);
    }
}
