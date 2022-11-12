// 
// Decompiled by Procyon v0.6.0
// 

package b5;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList;
import x9.i;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import ba.f;

public final class r0 implements f
{
    public final InAppMessageStreamManager a;
    public final i b;
    
    public r0(final InAppMessageStreamManager a, final i b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object apply(final Object o) {
        return InAppMessageStreamManager.n(this.a, this.b, (CampaignImpressionList)o);
    }
}
