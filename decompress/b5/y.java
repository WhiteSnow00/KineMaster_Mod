// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import ba.f;

public final class y implements f
{
    public final ImpressionStorageClient a;
    public final CampaignImpression b;
    
    public y(final ImpressionStorageClient a, final CampaignImpression b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object apply(final Object o) {
        return ImpressionStorageClient.a(this.a, this.b, (CampaignImpressionList)o);
    }
}
