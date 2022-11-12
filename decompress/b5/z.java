// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import java.util.HashSet;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import ba.f;

public final class z implements f
{
    public final ImpressionStorageClient a;
    public final HashSet b;
    
    public z(final ImpressionStorageClient a, final HashSet b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object apply(final Object o) {
        return ImpressionStorageClient.f(this.a, this.b, (CampaignImpressionList)o);
    }
}
