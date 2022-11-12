// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import ba.h;

public final class e implements h
{
    public final CampaignCacheClient a;
    
    public e(final CampaignCacheClient a) {
        this.a = a;
    }
    
    public final boolean test(final Object o) {
        return CampaignCacheClient.c(this.a, (FetchEligibleCampaignsResponse)o);
    }
}
