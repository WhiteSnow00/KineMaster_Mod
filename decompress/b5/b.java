// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import ba.a;

public final class b implements a
{
    public final CampaignCacheClient a;
    public final FetchEligibleCampaignsResponse b;
    
    public b(final CampaignCacheClient a, final FetchEligibleCampaignsResponse b) {
        this.a = a;
        this.b = b;
    }
    
    public final void run() {
        CampaignCacheClient.d(this.a, this.b);
    }
}
