// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import ba.a;

public final class u implements a
{
    public final ImpressionStorageClient a;
    public final CampaignImpressionList b;
    
    public u(final ImpressionStorageClient a, final CampaignImpressionList b) {
        this.a = a;
        this.b = b;
    }
    
    public final void run() {
        ImpressionStorageClient.d(this.a, this.b);
    }
}
