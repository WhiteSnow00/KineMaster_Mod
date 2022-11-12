// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import ba.e;

public final class w implements e
{
    public final ImpressionStorageClient a;
    
    public w(final ImpressionStorageClient a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        ImpressionStorageClient.c(this.a, (CampaignImpressionList)o);
    }
}
