// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import java.util.concurrent.Callable;

public final class f implements Callable
{
    public final CampaignCacheClient a;
    
    public f(final CampaignCacheClient a) {
        this.a = a;
    }
    
    @Override
    public final Object call() {
        return CampaignCacheClient.a(this.a);
    }
}
