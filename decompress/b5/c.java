// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import ba.e;

public final class c implements e
{
    public final CampaignCacheClient a;
    
    public c(final CampaignCacheClient a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        CampaignCacheClient.b(this.a, (FetchEligibleCampaignsResponse)o);
    }
}
