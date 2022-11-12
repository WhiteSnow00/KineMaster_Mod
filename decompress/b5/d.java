// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import ba.e;

public final class d implements e
{
    public final CampaignCacheClient a;
    
    public d(final CampaignCacheClient a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        CampaignCacheClient.e(this.a, (Throwable)o);
    }
}
