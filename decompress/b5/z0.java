// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import ba.e;

public final class z0 implements e
{
    public final AnalyticsEventsManager a;
    
    public z0(final AnalyticsEventsManager a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        this.a.e((FetchEligibleCampaignsResponse)o);
    }
}
